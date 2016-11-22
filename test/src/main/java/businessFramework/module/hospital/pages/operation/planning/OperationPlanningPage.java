package businessFramework.module.hospital.pages.operation.planning;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.module.hospital.modals.operPlanning.OperationPlanningModal;
import businessFramework.module.hospital.modals.operPlanning.OperationRoomScheduleModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.test.DateUtil;


/**
 * @author agabdrakhmanova
 * @since 11.11.2015
 */
public class OperationPlanningPage extends OperationPlanningHelper {

    private OperationPlanningModal operationPlanningModal;
    private OperationRoomScheduleModal operationRoomScheduleModal;


    public OperationPlanningPage(ApplicationManager app) {
        super(app);
        operationPlanningModal = new OperationPlanningModal();
        operationRoomScheduleModal = new OperationRoomScheduleModal();
    }

    public void click(Button button)
    {
        button.assertIsEnabled();
        button.click();
    }

    public void createPlannedOperation(OperationServiceData operationServiceData)
    {
        clickButtonOpeningModal(getCreatePlannedOperationButton(), "Направление на операцию");
        assertModalPresentOnPage(true);
        operationPlanningModal.fillForm(operationServiceData, true);
        operationPlanningModal.clickConfirmButton();
        getServicesTemplateContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        getServicesTemplateContainer().getTable().assertThatTableContainsOnlyXRows(1);
    }

    public void updatePlannedOperation(OperationServiceData operationServiceData1, OperationServiceData operationServiceData2)
    {
        fillPlannedDateToFilter(operationServiceData1.getPlannedDate());
        clickButtonOpeningModal(getUpdatePlannedOperationButton(), "Направление на операцию");
        assertModalPresentOnPage(true);
        operationPlanningModal.assertForm(operationServiceData1);
        operationPlanningModal.fillForm(operationServiceData2, false);
        operationPlanningModal.clickConfirmButton();
        getServicesTemplateContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        getServicesTemplateContainer().getTable().assertThatTableContainsOnlyXRows(1);

    }

    public void cancelOperation()
    {
        click(getCancelButton());
        getModal().getButton(CONFIRM_BUTTON).click();
        getServicesTemplateContainer().getTable().assertIconInRowOnColumn(0, "", "icomoon-cross");
        getServicesTemplateContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void returnOperation()
    {
        click(getReturnButton());
        getModal().getButton(CONFIRM_BUTTON).click();
        getServicesTemplateContainer().getTable().assertIconInRowOnColumn(0, "", "icomoon-hour-glass");
        getServicesTemplateContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void fillPlannedDateToFilter(String dt)
    {
        getServicesTemplateContainer().showFilter();
        getServicesTemplateContainer().getFilter().getInputDate("plannedDate").setValue(DateUtil.getDateWithoutTime(dt));
        getServicesTemplateContainer().getFilter().clickFindButton();
    }

    public void addQueueFromSchedule()
    {
        clickButtonOpeningModal(addQueueFromScheduleButton(), "Расписание операций");
        assertModalPresentOnPage(true);
        operationRoomScheduleModal.saveQueue("Очередь 4");
    }

    public void deleteAllForDayOperations() {
        deleteAllForDayOperations(getDeleteOperationsButton());
        getServicesTemplateContainer().getTable().assertThatTableContainsOnlyXRows(0);
    }

    public void deleteAllForDayOperations(Button button) {
        this.getServicesTemplateContainer().getTable();
        while (getServicesTemplateContainer().getTable().getCountRowsInTable(true) > 0)
        {
            getServicesTemplateContainer().getTable().chooseRowInTable(0);
            clickDeleteService(button);
            getAlerts().assertSuccessAlertMessage("Данные сохранены");
        }
    }

    public void clickDeleteService(Button button) {
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

}
