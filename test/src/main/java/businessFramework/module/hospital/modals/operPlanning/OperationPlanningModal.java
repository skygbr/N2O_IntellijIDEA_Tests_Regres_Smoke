package businessFramework.module.hospital.modals.operPlanning;

import businessFramework.entities.hospital.OperationServiceData;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

/**
 * @author agabdrakhmanova
 * @since 11.11.2015
 */
public class OperationPlanningModal {
    private OperationPlanningHelper operationPlanningHelper;
    private Page page = Page.getInstance();
    private OperationRoomScheduleModal operationRoomScheduleModal;

    public OperationPlanningModal() {
        this.operationPlanningHelper = new OperationPlanningHelper();
        this.operationRoomScheduleModal = new OperationRoomScheduleModal();
    }

    public OperationPlanningModal(String locator) {
        this.operationPlanningHelper = new OperationPlanningHelper(locator);
    }

    public void clickConfirmButton() {
        Button confirm = operationPlanningHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void fillForm(OperationServiceData data, Boolean create) {

        if (create) {
            operationPlanningHelper.getDepartment().setValue(data.getDepartment());
            operationPlanningHelper.getMedicalCase().setValue(data.getMedicalCase());
        } else {
            operationPlanningHelper.getDepartment().assertThatComboboxIsDisabled();
            operationPlanningHelper.getMedicalCase().assertThatComboboxIsDisabled();
        }

        operationPlanningHelper.getPlannedDate().setValue(data.getPlannedDate());
        operationPlanningHelper.getService().setValue(data.getService());
        operationPlanningHelper.getSurgeon().setValue(data.getSurgeon());
        operationPlanningHelper.getOperationRoom().setValue(data.getOperationRoom());
        operationPlanningHelper.getUrgent().check(data.getUrgent());
        operationPlanningHelper.getFinancialType().setValue(data.getFinancialType());

        if (data.getUrgent()) {
            operationPlanningHelper.getQueue().getButton("Заполнить").assertIsDisabled();
            operationPlanningHelper.getQueue().getButton("n2o-view").assertIsDisabled();
            MatcherAssert.assertThat(page.findElement(By.cssSelector(".n2o-typeahead-header-value"),operationPlanningHelper.getQueue().takeContainer()).getText().trim().toLowerCase(), containsString(""));
        } else {
            operationPlanningHelper.getQueue().getButton("Заполнить").assertIsEnabled();
            operationPlanningHelper.getQueue().getButton("Заполнить").click();
            MatcherAssert.assertThat(page.findElement(By.cssSelector(".n2o-typeahead-header-value"),operationPlanningHelper.getQueue().takeContainer()).getText().trim().toLowerCase(), containsString("1"));

            operationPlanningHelper.getQueue().getButton("n2o-view").assertIsEnabled();
            operationPlanningHelper.getQueue().getButton("n2o-view").click();

            page.assertModalPresentOnPage(true);
            page.getModal().assertModalHeader_contains("Расписание операций");
            operationRoomScheduleModal.chooseFreeQueue("Очередь " + data.getQueue());
            MatcherAssert.assertThat(page.findElement(By.cssSelector(".n2o-typeahead-header-value"),operationPlanningHelper.getQueue().takeContainer()).getText().trim().toLowerCase(), containsString(data.getQueue()));
        }
    }


    public void assertForm(OperationServiceData data) {
        operationPlanningHelper.getDepartment().assertValue_equals(data.getDepartment());
        operationPlanningHelper.getMedicalCase().assertValue_contains(data.getMedicalCase());
        operationPlanningHelper.getPlannedDate().assertValue_equals(data.getPlannedDate());
        operationPlanningHelper.getUrgent().assertThatCheckboxIsChecked(data.getUrgent());
        operationPlanningHelper.getService().assertValue_equals(data.getService());
        operationPlanningHelper.getSurgeon().assertValue_equals(data.getSurgeon());
        operationPlanningHelper.getOperationRoom().assertValue_equals(data.getOperationRoom());
        operationPlanningHelper.getFinancialType().assertValue_equals(data.getFinancialType());
    }


}
