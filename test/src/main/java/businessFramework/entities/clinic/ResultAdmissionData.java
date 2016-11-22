package businessFramework.entities.clinic;

import javax.xml.soap.SAAJResult;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class ResultAdmissionData {
    private String caseInitGoal;
    private String careProvidingForm;
    private String careLevel;
    private String careProvisionCondition;
    private String mcCaseType;
    private String fundingSourceType;

    private String profile;
    private String diagnosis;
    private String service;
    private String diseaseType;
    private String medicalCardPlaceName;
    private String mcCaseCareRegimen;
    private String periodicity;
    private String visitPlace;

    public String getCaseInitGoal() {
        return caseInitGoal;
    }

    public void setCaseInitGoal(String caseInitGoal) {
        this.caseInitGoal = caseInitGoal;
    }

    public String getCareProvidingForm() {
        return careProvidingForm;
    }

    public void setCareProvidingForm(String careProvidingForm) {
        this.careProvidingForm = careProvidingForm;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public String getCareProvisionCondition() {
        return careProvisionCondition;
    }

    public void setCareProvisionCondition(String careProvisionCondition) {
        this.careProvisionCondition = careProvisionCondition;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getMedicalCardPlaceName() {
        return medicalCardPlaceName;
    }

    public void setMedicalCardPlaceName(String medicalCardPlaceName) {
        this.medicalCardPlaceName = medicalCardPlaceName;
    }
    public String getMcCaseCareRegimen() {
        return mcCaseCareRegimen;
    }

    public void setMcCaseCareRegimen(String mcCaseCareRegimen) {
        this.mcCaseCareRegimen = mcCaseCareRegimen;
    }

    public String getFundingSourceType() {
        return fundingSourceType;
    }

    public void setFundingSourceType(String fundingSourceType) {
        this.fundingSourceType = fundingSourceType;
    }

    public String getMcCaseType() {
        return mcCaseType;
    }

    public void setMcCaseType(String mcCaseType) {
        this.mcCaseType = mcCaseType;
    }

    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }
}
