package businessFramework.entities.phthisiatry;

import java.util.List;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseData implements Cloneable
{
    /** Данные для выбора контекста */

    private String departmentForContext;

    /** Данные для установки значений в поля в модальном окне "Случай" */

    private String patient;
    private String uid;
    private String createDate;
    private String mdCaseDiagnos;
    private String caseType;
    private String careRegimen;
    private String careLevel;
    private String funding;
    private String initGoal;
    private String repeatCount;
    private String caseDiagnosis;
    private String diagnosisStage;
    private List<String> diagnosis;
    private String diagnosisCode;
    private String diagnosisDate;
    private String clinic;
    private String clinicalForm;
    private String localization;
    private String complication;
    private String resultTreatment;
    private String resultReason;
    private String outcome;
    private String deviationReason;
    private String csg;
    private String diagnosisType;
    private String diseaseType;
    private String establishmentDate;
    private String diagnosisCodeClose;
    private String diagnosisStageClose;


    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getMdCaseDiagnos() {
        return mdCaseDiagnos;
    }

    public void setMdCaseDiagnos(String mdCaseDiagnos) {
        this.mdCaseDiagnos = mdCaseDiagnos;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCareRegimen() {
        return careRegimen;
    }

    public void setCareRegimen(String careRegimen) {
        this.careRegimen = careRegimen;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getInitGoal() {
        return initGoal;
    }

    public void setInitGoal(String initGoal) {
        this.initGoal = initGoal;
    }

    public String getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(String repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getCaseDiagnosis() {
        return caseDiagnosis;
    }

    public void setCaseDiagnosis(String caseDiagnosis) {
        this.caseDiagnosis = caseDiagnosis;
    }

    public String getDiagnosisStage() {
        return diagnosisStage;
    }

    public void setDiagnosisStage(String diagnosisStage) {
        this.diagnosisStage = diagnosisStage;
    }

    public String getDiagnosisStageClose() {
        return diagnosisStageClose;
    }

    public void setDiagnosisStageClose(String diagnosisStageClose) {
        this.diagnosisStageClose = diagnosisStageClose;
    }

    public List<String> getDiagnosis() {
        return diagnosis;
    }


    public void setDiagnosis(List<String> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisCodeClose() {
        return diagnosisCodeClose;
    }

    public void setDiagnosisCodeClose(String diagnosisCodeClose) {
        this.diagnosisCodeClose = diagnosisCodeClose;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
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

    public String getResultTreatment() {
        return resultTreatment;
    }

    public void setResultTreatment(String resultTreatment) {
        this.resultTreatment = resultTreatment;
    }

    public String getResultReason() {
        return resultReason;
    }

    public void setResultReason(String resultReason) {
        this.resultReason = resultReason;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getDeviationReason() {
        return deviationReason;
    }

    public void setDeviationReason(String deviationReason) {
        this.deviationReason = deviationReason;
    }

    public String getCsg() {
        return csg;
    }

    public void setCsg(String csg) {
        this.csg = csg;
    }

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    @Override
    public MCaseData clone() throws CloneNotSupportedException
    {
        return (MCaseData)super.clone();
    }
}
