package businessFramework.module.hospital.pages.service;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

/**
 * @author agabdrakhmanova
 * @since 04.09.2015
 */
public class AddResultToServicePageHelper extends Page implements Values {
    public AddResultToServicePageHelper(ApplicationManager app)
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

    public Classifier getService()
    {
        return getContainer().getForm().getClassifier("service");
    }

    public Classifier getDoctor()
    {
        return getContainer().getForm().getClassifier("doctor");
    }

    public Classifier getHospitalRecord()
    {
        return getContainer().getForm().getClassifier("hospitalRecord");
    }

    public Classifier getFinancialType()
    {
        return getContainer().getForm().getClassifier("financialType");
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
