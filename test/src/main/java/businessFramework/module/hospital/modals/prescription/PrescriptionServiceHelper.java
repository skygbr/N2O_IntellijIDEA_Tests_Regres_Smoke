package businessFramework.module.hospital.modals.prescription;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;


/**
 * @author agabdrakhmanova
 * @since 30.11.2015
 */
public class PrescriptionServiceHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public PrescriptionServiceHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public OutputText getCaseInfo() {
        return getContainer().getForm().getOutputText("caseInfo");
    }

    public TextArea getName() {
        return getContainer().getForm().getTextArea("name");
    }

    public Classifier getService() {
        return getContainer().getForm().getClassifier("service");
    }

    public InputText getDuration() {
        return getContainer().getForm().getInputText("duration");
    }

    public Classifier getSrvDurationUnit() {
        return getContainer().getForm().getClassifier("srvDurationUnit");
    }

    public Classifier getPeriodicity() {
        return getContainer().getForm().getClassifier("periodicity");
    }

    public Classifier getVisitTerm() {
        return getContainer().getForm().getClassifier("visitTerm");
    }

    public InputDate getPeriodBeginDt() {
        return getContainer().getForm().getInputDate("periodBeginDt");
    }

    public InputDate getPeriodEndDt() {
        return getContainer().getForm().getInputDate("periodEndDt");
    }

    public TextArea getNote() {
        return getContainer().getForm().getTextArea("note");
    }

    public Select getExecution() {
        return getContainer().getForm().getSelect("execution");
    }

    public OutputText getCount() {
        return getContainer().getForm().getOutputText("count");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }


}
