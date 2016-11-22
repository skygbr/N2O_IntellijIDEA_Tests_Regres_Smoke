package businessFramework.entities.phthisiatry;

import java.util.List;

/**
 * Created by bulat.garipov on 28.10.2016.
 */
public class MStepData implements Cloneable
{

    /** Данные для установки значений в поля в модальном окне "Посещения" */

    private String stepPatient;
    private String res;
    private String vrach;
    private String vrachContainer;
    private String service;
    private String equip;
    private String admissionDate;
    private String place;
    private String profile;
    private String initGoal;
    private String diseaseType;
    private List<String> diagnosis;
    private String diagnosisCode;
    private String clinicalForm;
    private String localization;
    private String complication;


    public String getStepPatient() {
        return stepPatient;
    }

    public void setStepPatient(String stepPatient) {
        this.stepPatient = stepPatient;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getVrach() {
        return vrach;
    }

    public void setVrach(String vrach) {
        this.vrach = vrach;
    }

    public String getVrachContainer() {
        return vrachContainer;
    }

    public void setVrachContainer(String vrachContainer) {
        this.vrachContainer = vrachContainer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getInitGoal() {
        return initGoal;
    }

    public void setInitGoal(String initGoal) {
        this.initGoal = initGoal;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
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

    @Override
    public MStepData clone() throws CloneNotSupportedException
    {
        return (MStepData)super.clone();
    }
}
