package businessFramework.entities.dAccount;

import java.util.List;

public class DAccountData implements Cloneable
{
    /** Данные для выбора контекста */
    private String departmentForContext;
    private String registerForContext;

    /** Данные для установки значений в поля в модальном окне "Постановка на учет" */
    private String regDate;
    private String patient;
    private String clinicDistrict;
    private String acStage;
    private String condition;
    private String patState;
    private String hiv;
    private String hivDate;
    private String group;
    private String amb;
    // диагноз
    private String stage;
    private String disease;
    private List<String> diagnos;
    private String clinicalForm;
    private String localization;
    private String complication;

    //диагноз в листовой форме
    private String fullDiagnosis;

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getRegisterForContext() {
        return registerForContext;
    }

    public void setRegisterForContext(String registerForContext) {
        this.registerForContext = registerForContext;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getClinicDistrict() {
        return clinicDistrict;
    }

    public void setClinicDistrict(String clinicDistrict) {
        this.clinicDistrict = clinicDistrict;
    }

    public String getAcStage() {
        return acStage;
    }

    public void setAcStage(String ac_stage) {
        this.acStage = ac_stage;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPatState() {
        return patState;
    }

    public void setPatState(String patState) {
        this.patState = patState;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getHivDate() {
        return hivDate;
    }

    public void setHivDate(String hivDate) {
        this.hivDate = hivDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAmb() {
        return amb;
    }

    public void setAmb(String amb) {
        this.amb = amb;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<String> getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(List<String> diagnos) {
        this.diagnos = diagnos;
    }

    public String getClinicalForm() {
        return clinicalForm;
    }

    public void setClinicalForm(String clinicalForm) {
        this.clinicalForm = clinicalForm;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getFullDiagnosis() {
        return fullDiagnosis;
    }

    public void setFullDiagnosis(String fullDiagnosis) {
        this.fullDiagnosis = fullDiagnosis;
    }

    @Override
    public DAccountData clone() throws CloneNotSupportedException
    {
        return (DAccountData)super.clone();
    }
}
