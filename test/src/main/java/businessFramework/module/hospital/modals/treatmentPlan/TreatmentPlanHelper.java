package businessFramework.module.hospital.modals.treatmentPlan;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class TreatmentPlanHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public TreatmentPlanHelper(String container) {
        this.container = container;
    }

    public TreatmentPlanHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    private Form getForm() {
        return getContainer().getForm();
    }

    public InputDate getSymptomDate() {
        return getForm().getInputDate("simptom_dt");
    }

    public InputDate getFirstVisitDate() {
        return getForm().getInputDate("first_visit_dt");
    }

    public Classifier getDiagnosis() {
        return getForm().getClassifier("diagnosis_group");
    }

    public InputText getClinicForm() {
        return getForm().getInputText("clinic_form");
    }

    public MultiClassifier getOrgans() {
        return getForm().getMultiClassifier("organs");
    }

    public Classifier getPatientGroup() {
        return getForm().getClassifier("patient_group");
    }

    public InputText getCardNum() {
        return getForm().getInputText("num");
    }

    public InputText getCourseNum() {
        return getForm().getInputText("course_num");
    }

    public InputDate getCreateDate() {
        return getForm().getInputDate("create_dt");
    }

    public InputDate getEndDate() {
        return getForm().getInputDate("end_dt");
    }

    public OutputText getDayAmount(){
        return getForm().getOutputText("dayAmount");
    }

    public Classifier getChemoPhase() {
        return getForm().getClassifier("chemo_phase");
    }

    public Classifier getChemoRegimen() {
        return getForm().getClassifier("chemo_regimen");
    }

    public InputText getPatientWeight() {
        return getForm().getInputText("patient_weight");
    }

    public Classifier getResult() {
        return getForm().getClassifier("treatment_result");
    }

    public InputText getOutcomeOrg() {
        return getForm().getInputText("outcome_org");
    }

    public InputDate getResultEndDate() {
        return getForm().getInputDate("fact_end_dt");
    }

    public Button getCancelButton() {
        return getContainer().getButton(N2O_CANCEL_BUTTON);
    }

    public Button getCreateSaveButton(){
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getUpdateSaveButton(){
        return getContainer().getButton(CONFIRM_BUTTON);
    }

}
