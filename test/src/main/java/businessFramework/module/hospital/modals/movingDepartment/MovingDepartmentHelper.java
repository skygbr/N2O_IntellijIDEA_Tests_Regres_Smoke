package businessFramework.module.hospital.modals.movingDepartment;


import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;


public class MovingDepartmentHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public MovingDepartmentHelper()
    {
        this.container = "main";
    }

    public MovingDepartmentHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getPatient()
    {
        return getContainer().getForm().getClassifier("patient");
    }

    public OutputText getPatientOutputText()
    {
        return getContainer().getForm().getOutputText("patientName");
    }

    public Classifier getFinancialType()
    {
        return getContainer().getForm().getClassifier("financialType");
    }

    public OutputText getFinancialTypeOutputText()
    {
        return getContainer().getForm().getOutputText("financialTypeName");
    }

    public Classifier getDepartment()
    {
        return getContainer().getForm().getClassifier("department");
    }

    public InputDate getAdmissionDate()
    {
        return getContainer().getForm().getInputDate("admissionDate");
    }

    public InputText getUid()
    {
        return getContainer().getForm().getInputText("uid");
    }

    public Classifier getProfile()
    {
        return getContainer().getForm().getClassifier("profile");
    }

    public Classifier getCareRegimen()
    {
        return getContainer().getForm().getClassifier("careRegimen");
    }

    public Classifier getAdmissionDepartment()
    {
        return getContainer().getForm().getClassifier("admissionDepartment");
    }

    public Classifier getDiagnosis()
    {
        return getContainer().getForm().getClassifier("diagnosis");
    }

    public Diagnosis getDiagnosisTree() {
        return new Diagnosis(app, getContainer().getForm().getFormElement(), "diagnosis");
    }

    public Classifier getBedProfile()
    {
        return getContainer().getForm().getClassifier("bedProfile");
    }

    public InputDate getOutcomeDate()
    {
        return getContainer().getForm().getInputDate("outcomeDate");
    }

    public Classifier getDoctor()
    {
        return getContainer().getForm().getClassifier("doctor");
    }

    public Classifier getStepResult()
    {
        return getContainer().getForm().getClassifier("stepResult");
    }

    public Classifier getNextDepartment()
    {
        return getContainer().getForm().getClassifier("nextDepartment");
    }

    public Classifier getNextProfile()
    {
        return getContainer().getForm().getClassifier("nextProfile");
    }

    public Classifier getNextCareRegiment()
    {
        return getContainer().getForm().getClassifier("nextCareRegimen");
    }

    public Classifier getNextFinancialType()
    {
        return getContainer().getForm().getClassifier("nextFinancialType");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Classifier getFinalDiagnosis()
    {
        return getContainer().getForm().getClassifier("finalDiagnosis");
    }

    public Classifier getCareLevel()
    {
        return getContainer().getForm().getClassifier("careLevel");
    }

    public Classifier getStepDepartment()
    {
        return getContainer().getForm().getClassifier("stepDepartment");
    }

    public Classifier getOutcome(){
        return getContainer().getForm().getClassifier("outcome");
    }

    public Classifier getDeviationReason() {
        return getContainer().getForm().getClassifier("deviationReason");
    }

    public Classifier getComplexityLevel() {
        return getContainer().getForm().getClassifier("complexityLevel");
    }

    public void clickStandardTab() {
        page.getContainer("tab2").clickContainer();
    }

    public Classifier getNextBedProfile() {
        return getContainer().getForm().getClassifier("nextBedProfile");
    }

    public InputCheckBox getNeedSickList()
    {
        return getContainer().getForm().getInputCheckBox("is_need_sickList");
    }

    public InputCheckBox getHasSickList()
    {
        return getContainer().getForm().getInputCheckBox("has_sickList");
    }

    public InputDate getSickListIssueDate()
    {
        return getContainer().getForm().getInputDate("sickListIssueDate");
    }

    public InputText getSickListNumber()
    {
        return getContainer().getForm().getInputText("sickListNumber");
    }
}
