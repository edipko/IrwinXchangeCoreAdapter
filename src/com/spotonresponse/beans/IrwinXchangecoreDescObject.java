package com.spotonresponse.beans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IrwinXchangecoreDescObject {

	private String IrwinID;
	private String RecordSource;
	private String CreatedOnDateTime;
	private String ModifiedOnDateTime;
	private String InConflict;
	private String UniqueFireIdentifier;
	private String FireDiscoveryDateTime;
	private String POOResponsibleUnit;
	private String LocalIncidentIdentifier;
	private String DispatchCenterID;
	private String IncidentName;
	private String FireCause;
	private String IncidentTypeKind;
	private String IncidentTypeCategory;
	private String InitialLatitude;
	private String InitialLongitude;
	private String DiscoveryAcres;
	private String POOLatitude;
	private String POOLongitude;
	private String POOOwnerUnit;
	private String POOState;
	private String POOCounty;
	private String POOLandownerKind;
	private String POOLandownerCategory;
	private String FirecodeRequested;
	private String FireCode;
	private String FSJobCode;
	private String FSOverrideCode;
	private String IsComplex;
	private String IsFSAssisted;
	private String IsMultiJurisdictional;
	private String IsTrespass;
	private String IsReimbursable;
	private String FireOutDateTime;
	private String CreatedBySystem;
	private String ModifiedBySystem;
	private String GACC;
	private String IsActive;
	
		
	public boolean add(IrwinXchangecoreDescObject obj, String key, String value) {
		try {
			Method method = IrwinXchangecoreDescObject.class.getMethod("set" + key, String.class);
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
	
	public String getIrwinID() {
		return IrwinID;
	}
	public void setIrwinID(String irwinID) {
		IrwinID = irwinID;
	}
	public String getRecordSource() {
		return RecordSource;
	}
	public void setRecordSource(String recordSource) {
		RecordSource = recordSource;
	}
	public String getCreatedOnDateTime() {
		return CreatedOnDateTime;
	}
	public void setCreatedOnDateTime(String createdOnDateTime) {
		CreatedOnDateTime = createdOnDateTime;
	}
	public String getModifiedOnDateTime() {
		return ModifiedOnDateTime;
	}
	public void setModifiedOnDateTime(String modifiedOnDateTime) {
		ModifiedOnDateTime = modifiedOnDateTime;
	}
	public String getInConflict() {
		return InConflict;
	}
	public void setInConflict(String inConflict) {
		InConflict = inConflict;
	}
	public String getUniqueFireIdentifier() {
		return UniqueFireIdentifier;
	}
	public void setUniqueFireIdentifier(String uniqueFireIdentifier) {
		UniqueFireIdentifier = uniqueFireIdentifier;
	}
	public String getFireDiscoveryDateTime() {
		return FireDiscoveryDateTime;
	}
	public void setFireDiscoveryDateTime(String fireDiscoveryDateTime) {
		FireDiscoveryDateTime = fireDiscoveryDateTime;
	}
	public String getPOOResponsibleUnit() {
		return POOResponsibleUnit;
	}
	public void setPOOResponsibleUnit(String pOOResponsibleUnit) {
		POOResponsibleUnit = pOOResponsibleUnit;
	}
	public String getLocalIncidentIdentifier() {
		return LocalIncidentIdentifier;
	}
	public void setLocalIncidentIdentifier(String localIncidentIdentifier) {
		LocalIncidentIdentifier = localIncidentIdentifier;
	}
	public String getDispatchCenterID() {
		return DispatchCenterID;
	}
	public void setDispatchCenterID(String dispatchCenterID) {
		DispatchCenterID = dispatchCenterID;
	}
	public String getIncidentName() {
		return IncidentName;
	}
	public void setIncidentName(String incidentName) {
		IncidentName = incidentName;
	}
	public String getFireCause() {
		return FireCause;
	}
	public void setFireCause(String fireCause) {
		FireCause = fireCause;
	}
	public String getIncidentTypeKind() {
		return IncidentTypeKind;
	}
	public void setIncidentTypeKind(String incidentTypeKind) {
		IncidentTypeKind = incidentTypeKind;
	}
	public String getIncidentTypeCategory() {
		return IncidentTypeCategory;
	}
	public void setIncidentTypeCategory(String incidentTypeCategory) {
		IncidentTypeCategory = incidentTypeCategory;
	}
	public String getInitialLatitude() {
		return InitialLatitude;
	}
	public void setInitialLatitude(String initialLatitude) {
		InitialLatitude = initialLatitude;
	}
	public String getInitialLongitude() {
		return InitialLongitude;
	}
	public void setInitialLongitude(String initialLongitude) {
		InitialLongitude = initialLongitude;
	}
	public String getDiscoveryAcres() {
		return DiscoveryAcres;
	}
	public void setDiscoveryAcres(String discoveryAcres) {
		DiscoveryAcres = discoveryAcres;
	}
	public String getPOOLatitude() {
		return POOLatitude;
	}
	public void setPOOLatitude(String pOOLatitude) {
		POOLatitude = pOOLatitude;
	}
	public String getPOOLongitude() {
		return POOLongitude;
	}
	public void setPOOLongitude(String pOOLongitude) {
		POOLongitude = pOOLongitude;
	}
	public String getPOOOwnerUnit() {
		return POOOwnerUnit;
	}
	public void setPOOOwnerUnit(String pOOOwnerUnit) {
		POOOwnerUnit = pOOOwnerUnit;
	}
	public String getPOOState() {
		return POOState;
	}
	public void setPOOState(String pOOState) {
		POOState = pOOState;
	}
	public String getPOOCounty() {
		return POOCounty;
	}
	public void setPOOCounty(String pOOCounty) {
		POOCounty = pOOCounty;
	}
	public String getPOOLandownerKind() {
		return POOLandownerKind;
	}
	public void setPOOLandownerKind(String pOOLandownerKind) {
		POOLandownerKind = pOOLandownerKind;
	}
	public String getPOOLandownerCategory() {
		return POOLandownerCategory;
	}
	public void setPOOLandownerCategory(String pOOLandownerCategory) {
		POOLandownerCategory = pOOLandownerCategory;
	}
	public String getFirecodeRequested() {
		return FirecodeRequested;
	}
	public void setFirecodeRequested(String firecodeRequested) {
		FirecodeRequested = firecodeRequested;
	}
	public String getFireCode() {
		return FireCode;
	}
	public void setFireCode(String fireCode) {
		FireCode = fireCode;
	}
	public String getFSJobCode() {
		return FSJobCode;
	}
	public void setFSJobCode(String fSJobCode) {
		FSJobCode = fSJobCode;
	}
	public String getFSOverrideCode() {
		return FSOverrideCode;
	}
	public void setFSOverrideCode(String fSOverrideCode) {
		FSOverrideCode = fSOverrideCode;
	}
	public String getIsComplex() {
		return IsComplex;
	}
	public void setIsComplex(String isComplex) {
		IsComplex = isComplex;
	}
	public String getIsFSAssisted() {
		return IsFSAssisted;
	}
	public void setIsFSAssisted(String isFSAssisted) {
		IsFSAssisted = isFSAssisted;
	}
	public String getIsMultiJurisdictional() {
		return IsMultiJurisdictional;
	}
	public void setIsMultiJurisdictional(String isMultiJurisdictional) {
		IsMultiJurisdictional = isMultiJurisdictional;
	}
	public String getIsTrespass() {
		return IsTrespass;
	}
	public void setIsTrespass(String isTrespass) {
		IsTrespass = isTrespass;
	}
	public String getIsReimbursable() {
		return IsReimbursable;
	}
	public void setIsReimbursable(String isReimbursable) {
		IsReimbursable = isReimbursable;
	}
	public String getFireOutDateTime() {
		return FireOutDateTime;
	}
	public void setFireOutDateTime(String fireOutDateTime) {
		FireOutDateTime = fireOutDateTime;
	}
	public String getCreatedBySystem() {
		return CreatedBySystem;
	}
	public void setCreatedBySystem(String createdBySystem) {
		CreatedBySystem = createdBySystem;
	}
	public String getModifiedBySystem() {
		return ModifiedBySystem;
	}
	public void setModifiedBySystem(String modifiedBySystem) {
		ModifiedBySystem = modifiedBySystem;
	}
	public String getGACC() {
		return GACC;
	}
	public void setGACC(String gACC) {
		GACC = gACC;
	}
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
}
