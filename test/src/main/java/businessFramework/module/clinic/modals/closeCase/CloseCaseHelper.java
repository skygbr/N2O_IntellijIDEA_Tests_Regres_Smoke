package businessFramework.module.clinic.modals.closeCase;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

/**
 * Created by asamoilov on 18.02.2016.
 */
public class CloseCaseHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerCloseCase(){
        return page.getModal().getContainer("main");
    }

    public InputDate getOutcomeDate(){
        return getContainerCloseCase().getForm().getInputDate("outcomeDate");
    }
    public Classifier getRepeatCount(){
        return getContainerCloseCase().getForm().getClassifier("repeatCount");
    }
    public Classifier getStepResult(){
        return getContainerCloseCase().getForm().getClassifier("stepResult");
    }
    public Classifier getOutcome(){
        return getContainerCloseCase().getForm().getClassifier("outcome");
    }
    public Button getCancelButton(){
        return getContainerCloseCase().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerCloseCase().getButton(N2O_CONFIRM_BUTTON);
    }
}
