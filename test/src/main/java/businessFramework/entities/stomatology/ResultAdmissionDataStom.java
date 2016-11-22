package businessFramework.entities.stomatology;

/**
 * Created by bulat.garipov on 27.07.2016.
 */
public class ResultAdmissionDataStom {
    private String caseInitGoal;
    private String careProvidingForm;
    private String careLevel;
    private String careProvisionCondition;
    private String profile;
    private String service;
    private String mcCaseType;
    private String fundingSourceType;
    private String medicalCardPlaceName;
    private String McCaseCareRegimen;

    public String getMedicalCardPlaceName() {
        return medicalCardPlaceName;
    }

    public void setMedicalCardPlaceName(String medicalCardPlaceName) {
        this.medicalCardPlaceName = medicalCardPlaceName;
    }

    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCareProvisionCondition() {
        return careProvisionCondition;
    }

    public void setCareProvisionCondition(String careProvisionCondition) {
        this.careProvisionCondition = careProvisionCondition;
    }

    public String getCareProvidingForm() {
        return careProvidingForm;
    }

    public void setCareProvidingForm(String careProvidingForm) {
        this.careProvidingForm = careProvidingForm;
    }

    public String getCaseInitGoal() {
        return caseInitGoal;
    }

    public void setCaseInitGoal(String caseInitGoal) {
        this.caseInitGoal = caseInitGoal;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    private String visitPlace;

    public String getMcCaseType() {
        return mcCaseType;
    }

    public void setMcCaseType(String mcCaseType) {
        this.mcCaseType = mcCaseType;
    }

    public String getFundingSourceType() {
        return fundingSourceType;
    }

    public void setFundingSourceType(String fundingSourceType) {
        this.fundingSourceType = fundingSourceType;
    }

    public String getMcCaseCareRegimen() {
        return McCaseCareRegimen;
    }

    public void setMcCaseCareRegimen(String mcCaseCareRegimen) {
        McCaseCareRegimen = mcCaseCareRegimen;
    }
}
