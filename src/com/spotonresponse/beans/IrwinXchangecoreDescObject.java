package com.spotonresponse.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.text.WordUtils;

public class IrwinXchangecoreDescObject {

	private String irwinid;
	private String recordsource;
	private String createdondatetime;
	private String modifiedondatetime;
	private String inconflict;
	private String uniquefireidentifier;
	private String firediscoverydatetime;
	private String pooresponsibleunit;
	private String localincidentidentifier;
	private String dispatchcenterid;
	private String incidentname;
	private String firecause;
	private String incidenttypekind;
	private String incidenttypecategory;
	private String initiallatitude;
	private String initiallongitude;
	private String discoveryacres;
	private String poolatitude;
	private String poolongitude;
	private String pooownerunit;
	private String poostate;
	private String poocounty;
	private String poolandownerkind;
	private String poolandownercategory;
	private String firecoderequested;
	private String firecode;
	private String fsjobcode;
	private String fsoverridecode;
	private String iscomplex;
	private String isfsassisted;
	private String ismultijurisdictional;
	private String istrespass;
	private String isreimbursable;
	private String fireoutdatetime;
	private String createdbysystem;
	private String modifiedbysystem;
	private String gacc;
	private String isactive;

	
		
	public boolean add(IrwinXchangecoreDescObject obj, String key, String value) {
		try {
			String capitolKey = WordUtils.capitalize(key.toLowerCase());	
			Method method = IrwinXchangecoreDescObject.class.getMethod("set" + capitolKey, String.class);
			method.invoke(obj, new String(value));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}



	public String getIrwinid() {
		return irwinid;
	}



	public void setIrwinid(String irwinid) {
		this.irwinid = irwinid;
	}



	public String getRecordsource() {
		return recordsource;
	}



	public void setRecordsource(String recordsource) {
		this.recordsource = recordsource;
	}



	public String getCreatedondatetime() {
		return createdondatetime;
	}



	public void setCreatedondatetime(String createdondatetime) {
		this.createdondatetime = createdondatetime;
	}



	public String getModifiedondatetime() {
		return modifiedondatetime;
	}



	public void setModifiedondatetime(String modifiedondatetime) {
		this.modifiedondatetime = modifiedondatetime;
	}



	public String getInconflict() {
		return inconflict;
	}



	public void setInconflict(String inconflict) {
		this.inconflict = inconflict;
	}



	public String getUniquefireidentifier() {
		return uniquefireidentifier;
	}



	public void setUniquefireidentifier(String uniquefireidentifier) {
		this.uniquefireidentifier = uniquefireidentifier;
	}



	public String getFirediscoverydatetime() {
		return firediscoverydatetime;
	}



	public void setFirediscoverydatetime(String firediscoverydatetime) {
		this.firediscoverydatetime = firediscoverydatetime;
	}



	public String getPooresponsibleunit() {
		return pooresponsibleunit;
	}



	public void setPooresponsibleunit(String pooresponsibleunit) {
		this.pooresponsibleunit = pooresponsibleunit;
	}



	public String getLocalincidentidentifier() {
		return localincidentidentifier;
	}



	public void setLocalincidentidentifier(String localincidentidentifier) {
		this.localincidentidentifier = localincidentidentifier;
	}



	public String getDispatchcenterid() {
		return dispatchcenterid;
	}



	public void setDispatchcenterid(String dispatchcenterid) {
		this.dispatchcenterid = dispatchcenterid;
	}



	public String getIncidentname() {
		return incidentname;
	}



	public void setIncidentname(String incidentname) {
		this.incidentname = incidentname;
	}



	public String getFirecause() {
		return firecause;
	}



	public void setFirecause(String firecause) {
		this.firecause = firecause;
	}



	public String getIncidenttypekind() {
		return incidenttypekind;
	}



	public void setIncidenttypekind(String incidenttypekind) {
		this.incidenttypekind = incidenttypekind;
	}



	public String getIncidenttypecategory() {
		return incidenttypecategory;
	}



	public void setIncidenttypecategory(String incidenttypecategory) {
		this.incidenttypecategory = incidenttypecategory;
	}



	public String getInitiallatitude() {
		return initiallatitude;
	}



	public void setInitiallatitude(String initiallatitude) {
		this.initiallatitude = initiallatitude;
	}



	public String getInitiallongitude() {
		return initiallongitude;
	}



	public void setInitiallongitude(String initiallongitude) {
		this.initiallongitude = initiallongitude;
	}



	public String getDiscoveryacres() {
		return discoveryacres;
	}



	public void setDiscoveryacres(String discoveryacres) {
		this.discoveryacres = discoveryacres;
	}



	public String getPoolatitude() {
		return poolatitude;
	}



	public void setPoolatitude(String poolatitude) {
		this.poolatitude = poolatitude;
	}



	public String getPoolongitude() {
		return poolongitude;
	}



	public void setPoolongitude(String poolongitude) {
		this.poolongitude = poolongitude;
	}



	public String getPooownerunit() {
		return pooownerunit;
	}



	public void setPooownerunit(String pooownerunit) {
		this.pooownerunit = pooownerunit;
	}



	public String getPoostate() {
		return poostate;
	}



	public void setPoostate(String poostate) {
		this.poostate = poostate;
	}



	public String getPoocounty() {
		return poocounty;
	}



	public void setPoocounty(String poocounty) {
		this.poocounty = poocounty;
	}



	public String getPoolandownerkind() {
		return poolandownerkind;
	}



	public void setPoolandownerkind(String poolandownerkind) {
		this.poolandownerkind = poolandownerkind;
	}



	public String getPoolandownercategory() {
		return poolandownercategory;
	}



	public void setPoolandownercategory(String poolandownercategory) {
		this.poolandownercategory = poolandownercategory;
	}



	public String getFirecoderequested() {
		return firecoderequested;
	}



	public void setFirecoderequested(String firecoderequested) {
		this.firecoderequested = firecoderequested;
	}



	public String getFirecode() {
		return firecode;
	}



	public void setFirecode(String firecode) {
		this.firecode = firecode;
	}



	public String getFsjobcode() {
		return fsjobcode;
	}



	public void setFsjobcode(String fsjobcode) {
		this.fsjobcode = fsjobcode;
	}



	public String getFsoverridecode() {
		return fsoverridecode;
	}



	public void setFsoverridecode(String fsoverridecode) {
		this.fsoverridecode = fsoverridecode;
	}



	public String getIscomplex() {
		return iscomplex;
	}



	public void setIscomplex(String iscomplex) {
		this.iscomplex = iscomplex;
	}



	public String getIsfsassisted() {
		return isfsassisted;
	}



	public void setIsfsassisted(String isfsassisted) {
		this.isfsassisted = isfsassisted;
	}



	public String getIsmultijurisdictional() {
		return ismultijurisdictional;
	}



	public void setIsmultijurisdictional(String ismultijurisdictional) {
		this.ismultijurisdictional = ismultijurisdictional;
	}



	public String getIstrespass() {
		return istrespass;
	}



	public void setIstrespass(String istrespass) {
		this.istrespass = istrespass;
	}



	public String getIsreimbursable() {
		return isreimbursable;
	}



	public void setIsreimbursable(String isreimbursable) {
		this.isreimbursable = isreimbursable;
	}



	public String getFireoutdatetime() {
		return fireoutdatetime;
	}



	public void setFireoutdatetime(String fireoutdatetime) {
		this.fireoutdatetime = fireoutdatetime;
	}



	public String getCreatedbysystem() {
		return createdbysystem;
	}



	public void setCreatedbysystem(String createdbysystem) {
		this.createdbysystem = createdbysystem;
	}



	public String getModifiedbysystem() {
		return modifiedbysystem;
	}



	public void setModifiedbysystem(String modifiedbysystem) {
		this.modifiedbysystem = modifiedbysystem;
	}



	public String getGacc() {
		return gacc;
	}



	public void setGacc(String gacc) {
		this.gacc = gacc;
	}



	public String getIsactive() {
		return isactive;
	}



	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	

}
