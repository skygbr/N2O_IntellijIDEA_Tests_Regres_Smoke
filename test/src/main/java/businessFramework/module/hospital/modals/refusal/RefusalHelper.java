package businessFramework.module.hospital.modals.refusal;


import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class RefusalHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public RefusalHelper()
    {
        this.container = "main";
    }

    public RefusalHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public InputDate getRefusalDate()
    {
        return getContainer().getForm().getInputDate("refusalDate");
    }

    public InputText getUid()
    {
        return getContainer().getForm().getInputText("uid");
    }

    public Classifier getStepResultReason()
    {
        return getContainer().getForm().getClassifier("stepResultReason");
    }

    public Classifier getRefusalEmployee()
    {
        return getContainer().getForm().getClassifier("refusalEmployee");
    }

    public Classifier getStepResult()
    {
        return getContainer().getForm().getClassifier("stepResult");
    }

    public Classifier getPatient()
    {
        return getContainer().getForm().getClassifier("patient");
    }

    public OutputText getPatientName(){
        return getContainer().getForm().getOutputText("patientName");
    }

    public Classifier getFinancialType()
    {
        return getContainer().getForm().getClassifier("financialType");
    }

    public OutputText getFinancialTypeName() {
        return getContainer().getForm().getOutputText("financialTypeName");
    }

    public Classifier getRegimen(){
        return getContainer().getForm().getClassifier("careRegimen");
    }

    public Classifier getProfile()
    {
        return getContainer().getForm().getClassifier("profile");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
