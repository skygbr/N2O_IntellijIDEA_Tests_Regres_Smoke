package businessFramework.module.hospital.pages.HospitalCase;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

public class HospitalRefusalHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public HospitalRefusalHelper()
    {
        this.container = "refusal";
    }

    public Container getContainer()
    {
        return page.getContainer(container);
    }


    public Container getRefusalContainer()
    {
        return page.getContainer(container);
    }

    public InputDate getRefusalDate()
    {
        return getRefusalContainer().getForm().getInputDate("refusalDate");
    }

    public InputText getUid()
    {
        return getRefusalContainer().getForm().getInputText("uid");
    }

    public Classifier getStepResultReason()
    {
        return getRefusalContainer().getForm().getClassifier("stepResultReason");
    }

    public Classifier getRefusalEmployee()
    {
        return getRefusalContainer().getForm().getClassifier("refusalEmployee");
    }

    public Classifier getStepResult()
    {
        return getRefusalContainer().getForm().getClassifier("stepResult");
    }

    public OutputText getPatientName(){
        return getRefusalContainer().getForm().getOutputText("patientName");
    }

    public OutputText getFinancialTypeName() {
        return getRefusalContainer().getForm().getOutputText("financialTypeName");
    }

    public Classifier getRegimen(){
        return getRefusalContainer().getForm().getClassifier("careRegimen");
    }

    public Classifier getProfile()
    {
        return getRefusalContainer().getForm().getClassifier("profile");
    }
}
