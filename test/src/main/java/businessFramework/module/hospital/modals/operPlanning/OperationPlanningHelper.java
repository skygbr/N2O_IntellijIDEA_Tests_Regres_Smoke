package businessFramework.module.hospital.modals.operPlanning;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 11.11.2015
 */
public class OperationPlanningHelper  implements Values {
    private String container;
    private Page page = Page.getInstance();

    public OperationPlanningHelper() {
        this.container = "main";
    }

    public OperationPlanningHelper(String cotainer) {
        this.container = cotainer;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Classifier getDepartment()
    {
        return getContainer().getForm().getClassifier("department");
    }

    public Classifier getMedicalCase()
    {
        return getContainer().getForm().getClassifier("medicalCase");
    }

    public InputDate getPlannedDate()
    {
        return getContainer().getForm().getInputDate("plannedDate");
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
        return getContainer().getForm().getClassifier("plan.operationRoom");
    }

    public OutputText getQueue()
    {
        return getContainer().getForm().getOutputText("plan.queue");
    }

    public InputCheckBox getUrgent()
    {
        return getContainer().getForm().getInputCheckBox("urgent");
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
