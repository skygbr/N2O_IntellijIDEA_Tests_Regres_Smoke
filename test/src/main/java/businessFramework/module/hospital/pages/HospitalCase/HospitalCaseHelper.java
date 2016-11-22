package businessFramework.module.hospital.pages.HospitalCase;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

public class HospitalCaseHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public HospitalCaseHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getContainer(container);
    }

    public InputDate getAdmissionDate() {
        return this.getContainer().getForm().getInputDate("admissionDate");
    }

    public Classifier getPatient() {
        return this.getContainer().getForm().getClassifier("patient");
    }

    public Classifier getFinancialType() {
        return this.getContainer().getForm().getClassifier("financialType");
    }

    public Classifier getCareProvidingForm() {
        return this.getContainer().getForm().getClassifier("careProvidingForm");
    }
    public Classifier getDrunkennessType() {
        return this.getContainer().getForm().getClassifier("drunkennessType");
    }

    public Classifier getInitGoal() {
        return this.getContainer().getForm().getClassifier("initGoal");
    }

    public InputText getNarcoticSubstance() {
        return  this.getContainer().getForm().getInputText("narcoticSubstance");
    }

    public InputText getWhereFromDelivered() {
        return  this.getContainer().getForm().getInputText("whereFromDelivered");
    }

    public InputText getNotesToWork() {
        return  this.getContainer().getForm().getInputText("notesToWork");
    }

    public Classifier getSeverityLevel() {
        return this.getContainer().getForm().getClassifier("severityLevel");
    }

    public Classifier getTransportingType() {
        return this.getContainer().getForm().getClassifier("transportingType");
    }

    public Classifier getAdmissionDepartment() {
        return this.getContainer().getForm().getClassifier("admissionDepartment");
    }

    public Classifier getRepeatCount() {
        return this.getContainer().getForm().getClassifier("repeatCount");
    }

    public Classifier getDoctor() {
        return this.getContainer().getForm().getClassifier("doctor");
    }

    public Classifier getAdmissionDiagnosis() {
        return this.getContainer().getForm().getClassifier("admissionDiagnosis");
    }

    public Button getCreateFirstHospitalRecordButton() {
        return this.getContainer().getButton("createFirstHospitalRecord");
    }

    public Classifier getAttendantIndiv() {
        return getContainer().getForm().getClassifier("attendantIndiv");
    }

    public Button getRefusalButton() {
        return this.getContainer().getButton("refusal");
    }

    public Button getConfirmButton() {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getEditButton() {
        return this.getContainer().getButton(SAVE_BUTTON);
    }

    public Button getBackButton() {
        return page.getButton(BACK);
    }

    public InputCheckBox getMarkInput() {
        return this.getContainer().getForm().getInputCheckBox("markMsg");
    }

    public InputCheckBox getRelativesInput() {
        return this.getContainer().getForm().getInputCheckBox("relatives");
    }

    public InputCheckBox getInstitutionInput() {
        return this.getContainer().getForm().getInputCheckBox("institution");
    }

}
