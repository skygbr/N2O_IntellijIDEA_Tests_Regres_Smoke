package businessFramework.entities.hospital;


import java.util.List;

public class HospitalData implements Cloneable
{
    private String patient;
    private String financialType;
    private String careProvidingForm;
    private String initGoal;
    private String transportingType;
    private String severityLevel;

    private String admissionDepartment;
    private String repeatCount;
    private String doctor;
    private String bdateService;
    private String service;
    private String admissionDate;
    private String department;
    private String careRegimen;
    private String Uid;
    private String profile;
    private String attendantIndivSurname;
    private String attendantIndivName;
    private String attendantIndivPartName;
    private String attendantIndivBirthday;
    private String attendantRelationSide;
    private String attendantSNILS;
    private String diagnosis;
    private List<String> diagnosisTree;
    private String diagnosisCode;
    private String diagnosisFeature1;
    private String diagnosisFeature2;
    private String prescriptionMedicine;
    private String prescriptionAdministrationRoute;
    private String prescriptionPeriodicity;
    private String prescriptionCount;
    private String recorder;
    private String nurse;
    private String branchManager;
    private String bed;
    private String bedProfile;
    private String outcomeDate;
    private String stepResult;
    private String nextDepartment;
    private String nextProfile;
    private String nextCareRegiment;
    private String nextFinancialType;
    private String beginDateBed;
    private String stageDiagnosis;
    private String finalDiagnosis;
    private String careLevel;
    private String refusalDate;
    private String stepResultReason;
    private String refusalEmployee;
    private String stepDepartment;
    private String outcome;
    private String caseType;
    private String note;
    private String complexityLevel;
    private String deviationReason;
    private String nextBedProfile;

    private Boolean needSickList;
    private Boolean hasSickList;
    private String sickListIssueDate;
    private String sickListNumber;

    private String notesToWork;
    private String drunkennessType;
    private String narcoticSubstance;
    private String whereFromDelivered;


    public String getNextBedProfile() {
        return nextBedProfile;
    }

    public void setNextBedProfile(String nextBedProfile) {
        this.nextBedProfile = nextBedProfile;
    }

    public String getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(String complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public String getDeviationReason() {
        return deviationReason;
    }

    public void setDeviationReason(String deviationReason) {
        this.deviationReason = deviationReason;
    }
    private Boolean mark;
    private Boolean institution;
    private Boolean relatives;

    public Boolean getRelatives() {
        return relatives;
    }

    public void setRelatives(Boolean relatives) {
        this.relatives = relatives;
    }

    public Boolean getInstitution() {
        return institution;
    }

    public void setInstitution(Boolean institution) {
        this.institution = institution;
    }

    public Boolean getMark() {
        return mark;
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public String getPatient()
    {
        return patient;
    }

    public void setPatient(String patient)
    {
        this.patient = patient;
    }

    public String getFinancialType()
    {
        return financialType;
    }

    public void setFinancialType(String financialType)
    {
        this.financialType = financialType;
    }

    public String getCareProvidingForm()
    {
        return careProvidingForm;
    }

    public void setCareProvidingForm(String careProvidingForm)
    {
        this.careProvidingForm = careProvidingForm;
    }

    public String getInitGoal()
    {
        return initGoal;
    }

    public void setInitGoal(String initGoal)
    {
        this.initGoal = initGoal;
    }

    public String getTransportingType()
    {
        return transportingType;
    }

    public void setTransportingType(String transportingType)
    {
        this.transportingType = transportingType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getAdmissionDepartment()
    {
        return admissionDepartment;
    }

    public void setAdmissionDepartment(String admissionDepartment)
    {
        this.admissionDepartment = admissionDepartment;
    }

    public String getRepeatCount()
    {
        return repeatCount;
    }

    public void setRepeatCount(String repeatCount)
    {
        this.repeatCount = repeatCount;
    }

    public String getDoctor()
    {
        return doctor;
    }

    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }

    public String getBdateService()
    {
        return bdateService;
    }

    public void setBdateService(String bdateService)
    {
        this.bdateService = bdateService;
    }

    public String getService()
    {
        return service;
    }

    public void setService(String service)
    {
        this.service = service;
    }

    public String getAdmissionDate()
    {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate)
    {
        this.admissionDate = admissionDate;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getCareRegimen()
    {
        return careRegimen;
    }

    public void setCareRegimen(String careRegimen)
    {
        this.careRegimen = careRegimen;
    }

    public String getUid()
    {
        return Uid;
    }

    public void setUid(String uid)
    {
        Uid = uid;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public void setAttendantIndivSurname(String attendantIndivSurname)
    {
        this.attendantIndivSurname = attendantIndivSurname;
    }

    public void setAttendantIndivName(String attendantIndivName)
    {
        this.attendantIndivName = attendantIndivName;
    }

    public void setAttendantIndivPartName(String attendantIndivPartName)
    {
        this.attendantIndivPartName = attendantIndivPartName;
    }

    public void setAttendantIndivBirthday(String attendantIndivBirthday)
    {
        this.attendantIndivBirthday = attendantIndivBirthday;
    }

    public String getAttendantIndivFIOB()
    {
        return attendantIndivSurname.substring(0,1).toLowerCase()
                + attendantIndivName.substring(0,1).toLowerCase()
                + attendantIndivPartName.substring(0,1).toLowerCase()
                + attendantIndivBirthday;
    }

    public String getAttendantIndivFullFIO()
    {
        return attendantIndivSurname + " "
                + attendantIndivName + " "
                + attendantIndivPartName + "";
    }

    public String getAttendantIndivFullFShortIO()
    {
        return attendantIndivSurname + " "
                + attendantIndivName.substring(0,1) +  ". "
                + attendantIndivPartName.substring(0,1) + ".";
    }

    public String getAttendantSNILS() {
        return attendantSNILS;
    }

    public void setAttendantSNILS(String attendantSNILS) {
        this.attendantSNILS = attendantSNILS;
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public String getPrescriptionMedicine() {
        return prescriptionMedicine;
    }

    public void setPrescriptionMedicine(String prescriptionMedicine) {
        this.prescriptionMedicine = prescriptionMedicine;
    }

    public String getPrescriptionAdministrationRoute() {
        return prescriptionAdministrationRoute;
    }

    public void setPrescriptionAdministrationRoute(String prescriptionAdministrationRoute) {
        this.prescriptionAdministrationRoute = prescriptionAdministrationRoute;
    }

    public String getPrescriptionPeriodicity() {
        return prescriptionPeriodicity;
    }

    public void setPrescriptionPeriodicity(String prescriptionPeriodicity) {
        this.prescriptionPeriodicity = prescriptionPeriodicity;
    }

    public String getPrescriptionCount() {
        return prescriptionCount;
    }

    public void setPrescriptionCount(String prescriptionCount) {
        this.prescriptionCount = prescriptionCount;
    }

    public String getRecorder()
    {
        return recorder;
    }

    public void setRecorder(String recorder)
    {
        this.recorder = recorder;
    }

    public String getNurse()
    {
        return nurse;
    }

    public void setNurse(String nurse)
    {
        this.nurse = nurse;
    }

    public String getBranchManager()
    {
        return branchManager;
    }

    public void setBranchManager(String branchManager)
    {
        this.branchManager = branchManager;
    }

    public String getAttendantRelationSide()
    {
        return attendantRelationSide;
    }

    public void setAttendantRelationSide(String attendantRelationSide)
    {
        this.attendantRelationSide = attendantRelationSide;
    }

    public String getBed()
    {
        return bed;
    }

    public void setBed(String bed)
    {
        this.bed = bed;
    }

    public String getBedProfile()
    {
        return bedProfile;
    }

    public void setBedProfile(String bedProfile)
    {
        this.bedProfile = bedProfile;
    }

    public String getOutcomeDate()
    {
        return outcomeDate;
    }

    public void setOutcomeDate(String outcomeDate)
    {
        this.outcomeDate = outcomeDate;
    }

    public String getStepResult()
    {
        return stepResult;
    }

    public void setStepResult(String stepResult)
    {
        this.stepResult = stepResult;
    }

    public String getNextDepartment()
    {
        return nextDepartment;
    }

    public void setNextDepartment(String nextDepartment)
    {
        this.nextDepartment = nextDepartment;
    }

    public String getNextProfile()
    {
        return nextProfile;
    }

    public String getNextCareRegiment()
    {
        return nextCareRegiment;
    }

    public String getNextFinancialType()
    {
        return nextFinancialType;
    }

    public void setNextProfile(String nextProfile)
    {
        this.nextProfile = nextProfile;
    }

    public void setNextCareRegiment(String nextCareRegiment)
    {
        this.nextCareRegiment = nextCareRegiment;
    }

    public void setNextFinancialType(String nextFinancialType)
    {
        this.nextFinancialType = nextFinancialType;
    }

    public String getBeginDateBed()
    {
        return beginDateBed;
    }

    public void setBeginDateBed(String beginDateBed)
    {
        this.beginDateBed = beginDateBed;
    }

    public String getStageDiagnosis()
    {
        return stageDiagnosis;
    }

    public void setStageDiagnosis(String stageDiagnosis)
    {
        this.stageDiagnosis = stageDiagnosis;
    }

    public String getFinalDiagnosis()
    {
        return finalDiagnosis;
    }

    public String getCareLevel()
    {
        return careLevel;
    }

    public void setCareLevel(String careLevel)
    {
        this.careLevel = careLevel;
    }

    public void setFinalDiagnosis(String finalDiagnosis)
    {
        this.finalDiagnosis = finalDiagnosis;
    }

    public String getRefusalEmployee()
    {
        return refusalEmployee;
    }

    public String getRefusalDate()
    {
        return refusalDate;
    }

    public String getStepResultReason()
    {
        return stepResultReason;
    }

    public void setRefusalDate(String refusalDate)
    {
        this.refusalDate = refusalDate;
    }

    public void setStepResultReason(String stepResultReason)
    {
        this.stepResultReason = stepResultReason;
    }

    public void setRefusalEmployee(String refusalEmployee)
    {
        this.refusalEmployee = refusalEmployee;
    }

    public String getStepDepartment()
    {
        return stepDepartment;
    }

    public void setStepDepartment(String stepDepartment)
    {
        this.stepDepartment = stepDepartment;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getDiagnosisFeature1() {
        return diagnosisFeature1;
    }

    public void setDiagnosisFeature1(String diagnosisFeature1) {
        this.diagnosisFeature1 = diagnosisFeature1;
    }

    public String getDiagnosisFeature2() {
        return diagnosisFeature2;
    }

    public void setDiagnosisFeature2(String diagnosisFeature2) {
        this.diagnosisFeature2 = diagnosisFeature2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getNeedSickList() {
        return needSickList;
    }

    public void setNeedSickList(Boolean needSickList) {
        this.needSickList = needSickList;
    }

    public Boolean getHasSickList() {
        return hasSickList;
    }

    public void setHasSickList(Boolean hasSickList) {
        this.hasSickList = hasSickList;
    }

    public String getSickListIssueDate() {
        return sickListIssueDate;
    }

    public void setSickListIssueDate(String sickListIssueDate) {
        this.sickListIssueDate = sickListIssueDate;
    }

    public String getSickListNumber() {
        return sickListNumber;
    }

    public void setSickListNumber(String sickListNumber) {
        this.sickListNumber = sickListNumber;
    }

    public String getNotesToWork() {
        return notesToWork;
    }

    public void setNotesToWork(String notesToWork) {
        this.notesToWork = notesToWork;
    }

    public String getDrunkennessType() {
        return drunkennessType;
    }

    public void setDrunkennessType(String drunkennessType) {
        this.drunkennessType = drunkennessType;
    }

    public String getWhereFromDelivered() {
        return whereFromDelivered;
    }

    public void setWhereFromDelivered(String whereFromDelivered) {
        this.whereFromDelivered = whereFromDelivered;
    }

    public String getNarcoticSubstance() {
        return narcoticSubstance;
    }

    public void setNarcoticSubstance(String narcoticSubstance) {
        this.narcoticSubstance = narcoticSubstance;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public List<String> getDiagnosisTree() {
        return diagnosisTree;
    }

    public void setDiagnosisTree(List<String> diagnosisTree) {
        this.diagnosisTree = diagnosisTree;
    }

    @Override
    public HospitalData clone() throws CloneNotSupportedException
    {
        return (HospitalData)super.clone();
    }
}
