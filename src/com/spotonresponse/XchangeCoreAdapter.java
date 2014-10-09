package com.spotonresponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Document;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import static org.apache.commons.lang3.StringEscapeUtils.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spotonresonse.httputils.HttpServices;
import com.spotonresonse.httputils.UserAuthenticationObject;
import com.spotonresponse.beans.IrwinIncident;
import com.spotonresponse.beans.IrwinToken;
import com.spotonresponse.beans.IrwinXchangecoreDescObject;
import com.spotonresponse.beans.WorkProduct;
import com.spotonresponse.uicds.utils.XmlFeedParser;
import com.spotonresponse.utils.HashUtils;
import com.spotonresponse.xmlutils.XmlTools;

public class XchangeCoreAdapter {

	static Logger logger = Logger.getLogger(XchangeCoreAdapter.class);
	 
	// A List of XchangeCore WorkProducts
	static List<WorkProduct> wplist = new ArrayList<WorkProduct>();

	// The Irwin Authentication Token
	static IrwinToken irwin_auth_token = null;
	
	// Properties from runtime property file
	static Properties props = null;

	private static void getXchangeCoreData(String url,
			UserAuthenticationObject ua) {
		String xml = "";
		try {
			xml = IOUtils.toString(XchangeCoreAdapter.class
					.getResourceAsStream("xchangecorexml/GetIncidentList.xml"),
					"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resp = HttpServices.postXML(xml, url, ua);

		/* Remove the SOAP Nodes from the response */
		String response = XmlTools.replaceSoap(resp);
		Document xmldocument = XmlTools.stringToDoc(response);
		// System.out.println("UICDS: " + response);
		/* Parse the Document and get the Workproduct */
		XmlFeedParser parser = new XmlFeedParser(
				XmlTools.docToInputStream(xmldocument));
		parser.parseStream();
		wplist = parser.getWorkProducts();
	}

	private static IrwinToken getIrwinToken(String base_url) {
		String url = base_url + "/arcgis/tokens/generateToken";
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("f", "json");
		//params.put("username", "xchangecore");
		//params.put("password", "88LARdmSpq4t");
		params.put("username",  props.getProperty("irwin_user"));
		params.put("password", props.getProperty("irwin_pass"));
		params.put("client", "requestip");
		String irwinToken = HttpServices.postParameters(params, url);
		Gson gson = new GsonBuilder().create();
		IrwinToken it = gson.fromJson(irwinToken, IrwinToken.class);
		return it;
	}

	private static boolean doesExistInIrwin(String base_url, WorkProduct wp) {
		// System.out.println("Checking Irwin exists...");
		String url = base_url
				+ "/arcgis/rest/services/Irwin/MapServer/exts/Irwin/GetConflicts";
		String[] position = wp.getPosition().split(",");
		if ((Double.valueOf(position[0]) == 0)
				|| (Double.valueOf(position[1]) == 0)
				|| (wp.getCreated() == "")) {
			System.out.println("bad lat/lng");
			// Return true so we do not try and push this event to the Irwin
			// system
			return true;
		}

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("f", "json");
		params.put("token", irwin_auth_token.getToken());
		params.put("pooLatitude", position[0]);
		params.put("pooLongitude", position[1]);
		params.put("fireDiscoveryDateTime", wp.getCreated());
		// System.out.println("Lat/Lon: " + position[0] + "/" + position[1] +
		// " Time: " + wp.getCreated());
		String conflicts_response = HttpServices.postParameters(params, url);

		// System.out.println("Conflict Response: " + conflicts_response);
		// Parse the response
		JsonElement json = new JsonParser().parse(conflicts_response);
		JsonElement isconflict = json.getAsJsonObject().get("conflicts");

		if (isconflict == null) {
			// There was as error, lets parse the response and see if there is
			// any information
			JsonElement error = json.getAsJsonObject().get("error");
			JsonElement description = error.getAsJsonObject()
					.get("description");
			System.out.println("Error description: "
					+ description.getAsString());
			return true;
		} else {

			// If it exists - return true
			if (isconflict.getAsJsonArray().size() > 0) {
				System.out.println("Conflict: " + wp.getName());
				return true;
			}
		}
		System.out.println("No Conflict");
		return false;
	}

	private static void submitToIrwin(String base_url, WorkProduct wp) {
		System.out.println("Adding Incident: " + wp.getName());
		String url = base_url
				+ "/arcgis/rest/services/Irwin/MapServer/exts/Irwin/SubmitIncident";
		String[] position = wp.getPosition().split(",");

		IrwinXchangecoreDescObject ido = getIrwinFromDesc(wp);

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("f", "json");
		params.put("token", irwin_auth_token.getToken());
		params.put("pooResponsibleUnit", "CABDF");
		params.put("localIncidentIdentifier", HashUtils.md5(wp.getWpID())
				.substring(0, 9));
		params.put("incidentName", wp.getName().substring(0, Math.min(wp.getName().length(), 50)));
		params.put("incidentTypeKind", ido.getIncidenttypekind());
		params.put("incidentTypeCategory", ido.getIncidenttypecategory());
		params.put("dispatchCenterId", ido.getDispatchcenterid());
		params.put("pooLatitude", position[0]);
		params.put("pooLongitude", position[1]);
		params.put("initialLatitude", position[0]);
		params.put("initialLongitude", position[1]);
		params.put("fireCause", ido.getFirecause());
		params.put("discoveryAcres", ido.getDiscoveryacres());
		params.put("fireDiscoveryDateTime", wp.getCreated());
		String submit_response = HttpServices.postParameters(params, url);

		System.out.println("SUBMIT: " + submit_response);
	}

	@SuppressWarnings("unused")
	private static IrwinIncident getIrwinIncidents(String base_url) {
		String url = base_url
				+ "/arcgis/rest/services/Irwin/MapServer/exts/Irwin/GetUpdates";
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("f", "json");
		// params.put("needsFireCode", "true");
		// params.put("fields", "IrwinID");
		params.put("fromDateTime", "2013-03-10T14:23:00Z");
		params.put("token", irwin_auth_token.getToken());
		String irwinData = HttpServices.postParameters(params, url);

		// Get the incidents array from the JSON string
		JsonElement json = new JsonParser().parse(irwinData);
		JsonElement irwinIncidents = json.getAsJsonObject().get("incidents");

		Gson gson = new GsonBuilder().registerTypeAdapter(IrwinIncident.class,
				new IrwinAttributesDeserializer()).create();
		IrwinIncident irwinincidents = null;
		List<IrwinIncident> il = new ArrayList<IrwinIncident>();

		for (JsonElement incidents : irwinIncidents.getAsJsonArray()) {
			JsonElement incident = incidents.getAsJsonObject()
					.get("attributes");
			irwinincidents = gson.fromJson(incident, IrwinIncident.class);
			il.add(irwinincidents);
		}

		// Roll the Incident Data into the POJO

		for (IrwinIncident ii : il) {
			System.out.println("--" + ii.getIrwinID() + "|"
					+ ii.getIncidentName());
		}

		return null;
	}

	private static IrwinXchangecoreDescObject getIrwinFromDesc(WorkProduct wp) {
		// Massage the Descriptor to get the Irwin data
		String[] desc_data = unescapeHtml3(wp.getEventDescriptor()).split(
				"<br/>");

		//System.out.println("Got data: " + unescapeHtml3(wp.getEventDescriptor()));
		IrwinXchangecoreDescObject descObject = new IrwinXchangecoreDescObject();
		for (String str : desc_data) {
			String[] key_data = str.replace("<b>", "").split("</b>");
			try {
				String key = key_data[0].trim().replace(":", "");
				String value = key_data[1];
			//System.out.println("Found: " + key);
				descObject.add(descObject, key, value);
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
                
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return descObject;
	}

	private static Properties getProperties() {
		Properties prop = new Properties();
		
		String propertiesFile = System.getProperty("propfile");
	    try {
	      propertiesFile.length();
	    } catch (Exception ex) {
	      logger.fatal("No properties file specified: " + ex);
	      System.exit(1);
	    }
   
	    try
	    {
	      prop.load(new FileInputStream(propertiesFile));
	    } catch (IOException ex) {
	      ex.printStackTrace();
	      System.exit(2);
	    }

	    return prop;
	}
	public static void main(String[] args) {

		// Get the runtime properties
		props = getProperties();
		String url = props.getProperty("xchangecore_url");
		String irwin_url = props.getProperty("irwin_url");
		UserAuthenticationObject ua = new UserAuthenticationObject(props.getProperty("xchangecore_user")
				, props.getProperty("xchangecore_pass"));
		

		// Get the XChangeCore Data
		getXchangeCoreData(url, ua);

		// Get an Authentication Token from the IRWIN Server
	    irwin_auth_token = getIrwinToken(irwin_url);
	   // System.out.println("Got Token: " + irwin_auth_token.getToken());

		// Loop through the incidetns
		for (WorkProduct wp : wplist) {
			// System.out.println("Checking: " + wp.getWpID());
			// If the incident does not exist in the Irwin system, add it
			 if (!doesExistInIrwin(irwin_url, wp)) {
			 submitToIrwin(irwin_url, wp);
			 }

		}
	}
}
