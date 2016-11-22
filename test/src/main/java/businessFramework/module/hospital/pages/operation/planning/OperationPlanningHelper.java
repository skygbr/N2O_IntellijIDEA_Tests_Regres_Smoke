package businessFramework.module.hospital.pages.operation.planning;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 11.11.2015
 */
public class OperationPlanningHelper  extends Page implements Values  {
    public OperationPlanningHelper(ApplicationManager app) {
        super(app);
    }

    //Шаблон
    public Container getServicesTemplateContainer() {
        return getRegion(SINGLE).getContainer("operationPlanningList");
    }

    public Button getCreatePlannedOperationButton() {
        return getServicesTemplateContainer().getButton("createPlannedOperation");
    }

    public Button getUpdatePlannedOperationButton() {
        return getServicesTemplateContainer().getButton("updatePlannedOperation");
    }

    public Button getDeleteButton() {
        return getServicesTemplateContainer().getButton("delete");
    }

    public Button getDeleteOperationsButton() {
        return getServicesTemplateContainer().getButton("delete");
    }

    public Button getCancelButton() {
        return getServicesTemplateContainer().getButton("cancel");
    }

    public Button getReturnButton() {
        return getServicesTemplateContainer().getButton("return");
    }

    public Button addQueueFromScheduleButton() {
        return getServicesTemplateContainer().getButton("operationSchedule");
    }
}
