package businessFramework.module.hospital.pages.service.operation;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;

/**
 * @author agabdrakhmanova
 * @since 05.11.2015
 */
public class AddResultToOperationPageHelper extends Page implements Values {
    public AddResultToOperationPageHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainer()
    {
        return getContainer("main");
    }

    public InputDate getRenderedDate()
    {
        return getContainer().getForm().getInputDate("renderedDate");
    }

    public InputCheckBox getUrgent()
    {
        return getContainer().getForm().getInputCheckBox("urgent");
    }

    public Classifier getHospitalRecord()
    {
        return getContainer().getForm().getClassifier("hospitalRecord");
    }

    public Classifier getService()
    {
        return getContainer().getForm().getClassifier("service");
    }

    public Classifier getSurgeon()
    {
        return getContainer().getForm().getClassifier("surgeon");
    }

    public Classifier getOperationRoom()
    {
        return getContainer().getForm().getClassifier("operationRoom");
    }

    public Classifier getFinancialType()
    {
        return getContainer().getForm().getClassifier("financialType");
    }

    public Classifier getAnesthesiaType()
    {
        return getContainer().getForm().getClassifier("anesthesiaType");
    }

    public Classifier getComplicationType()
    {
        return getContainer().getForm().getClassifier("complicationType");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getBackButton()
    {
        return getButton("back");
    }

    public void clickBackButton() {
        Button back = getBackButton();
        back.assertIsEnabled();
        back.click();
    }
}
