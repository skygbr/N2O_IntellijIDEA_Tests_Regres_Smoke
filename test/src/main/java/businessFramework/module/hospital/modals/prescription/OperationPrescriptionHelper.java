package businessFramework.module.hospital.modals.prescription;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;
import net.framework.autotesting.meta.components.OutputText;

/**
 * @author agabdrakhmanova
 * @since 18.11.2015
 */
public class OperationPrescriptionHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public OperationPrescriptionHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Classifier getHolding() {
        return getContainer().getForm().getClassifier("holding");
    }

    public Classifier getAdministrationRoute() {
        return getContainer().getForm().getClassifier("administrationRoute");
    }

    public InputText getCount() {
        return getContainer().getForm().getInputText("count");
    }

    public InputText getDose() {
        return getContainer().getForm().getInputText("dose");
    }

    public OutputText getDoseWithMeasureField(){
        return getContainer().getForm().getOutputText("holding.doseWithMeasure");
    }

    public OutputText getMneiNameField(){
        return getContainer().getForm().getOutputText("holding.mneiName");
    }



    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
