package businessFramework.module.hospital.modals.service.operation;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;

/**
 * @author agabdrakhmanova
 * @since 03.11.2015
 */
public class PlannedOperationHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public PlannedOperationHelper() {
        this.container = "main";
    }

    public PlannedOperationHelper(String cotainer) {
        this.container = cotainer;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public InputDate getPlannedDate()
    {
        return getContainer().getForm().getInputDate("plannedDate");
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

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
