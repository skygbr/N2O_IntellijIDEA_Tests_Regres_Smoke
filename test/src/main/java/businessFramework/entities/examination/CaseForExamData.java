package businessFramework.entities.examination;

public class CaseForExamData implements Cloneable {
    private String patient;
    private String caseType;
    private String openDate;
    private String closeDate;
    private String lastStepDepartment;
    private String doctor;
    private String examinedByLevels;
    private String socGroup;
    private String ageGroup;
    private String mainDiagCode;
    private String mainDiagName;
    private boolean isOutAndClinicDiagDifferent;
    private boolean isAdmAndClinicDiagDifferent;
    private boolean isPatAndClinicDiagDifferent;
    private String result;
    private String resultCode;
    private int repeatCaseDuringLastMonths;
    private int durationIsMoreThanPlanned;
    private int durationIsLessThanPlanned;
    private String uid;
    private Integer duration;
    private Integer stdDuration;
    private Integer mesDuration;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getLastStepDepartment() {
        return lastStepDepartment;
    }

    public void setLastStepDepartment(String lastStepDepartment) {
        this.lastStepDepartment = lastStepDepartment;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getExaminedByLevels() {
        return examinedByLevels == null? "" : examinedByLevels;
    }

    public void setExaminedByLevels(String examinedByLevels) {
        this.examinedByLevels = examinedByLevels;
    }

    public String getSocGroup() {
        return socGroup;
    }

    public void setSocGroup(String socGroup) {
        this.socGroup = socGroup;
    }

    public String getMainDiagCode() {
        return mainDiagCode;
    }

    public void setMainDiagCode(String mainDiagCode) {
        this.mainDiagCode = mainDiagCode;
    }

    public String getMainDiagName() {
        return mainDiagName;
    }

    public void setMainDiagName(String mainDiagName) {
        this.mainDiagName = mainDiagName;
    }

    public String getMainDiagCodeAndName() {
        return getMainDiagCode() + " " + getMainDiagName();
    }

    public boolean isOutAndClinicDiagDifferent() {
        return isOutAndClinicDiagDifferent;
    }

    public void setOutAndClinicDiagDifferent(boolean isOutAndClinicDiagDifferent) {
        this.isOutAndClinicDiagDifferent = isOutAndClinicDiagDifferent;
    }

    public boolean isAdmAndClinicDiagDifferent() {
        return isAdmAndClinicDiagDifferent;
    }

    public void setAdmissionAndClinicDiagDifferent(boolean isAdmAndClinicDiagDifferent) {
        this.isAdmAndClinicDiagDifferent = isAdmAndClinicDiagDifferent;
    }

    public boolean isPatAndClinicDiagDifferent() {
        return isPatAndClinicDiagDifferent;
    }

    public void setPatAndClinicDiagDifferent(boolean isPatAndClinicDiagDifferent) {
        this.isPatAndClinicDiagDifferent = isPatAndClinicDiagDifferent;
    }

    public String getResult() {
        return result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultWithCode() {
        return getResultCode() + " " + getResult();
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getRepeatCaseDuringLastMonths() {
        return repeatCaseDuringLastMonths;
    }

    public void setRepeatCaseDuringLastMonths(int repeatCaseDuringLastMonths) {
        this.repeatCaseDuringLastMonths = repeatCaseDuringLastMonths;
    }

    public int getDurationIsMoreThanPlanned() {
        return durationIsMoreThanPlanned;
    }

    public void setDurationIsMoreThanPlanned(int durationIsMoreThanPlanned) {
        this.durationIsMoreThanPlanned = durationIsMoreThanPlanned;
    }

    public int getDurationIsLessThanPlanned() {
        return durationIsLessThanPlanned;
    }

    public void setDurationIsLessThanPlanned(int durationIsLessThanPlanned) {
        this.durationIsLessThanPlanned = durationIsLessThanPlanned;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStdDuration() {
        return stdDuration;
    }

    public void setStdDuration(Integer stdDuration) {
        this.stdDuration = stdDuration;
    }

    public Integer getMesDuration() {
        return mesDuration;
    }

    public void setMesDuration(Integer mesDuration) {
        this.mesDuration = mesDuration;
    }

    public String getStdAndMesDuration() {
        return String.valueOf(getStdDuration()) + " / " + String.valueOf(getMesDuration());
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public CaseForExamData clone() throws CloneNotSupportedException {
        return (CaseForExamData) super.clone();
    }
}
