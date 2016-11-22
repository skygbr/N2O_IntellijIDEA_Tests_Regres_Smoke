package businessFramework.module.hospital.pages.prescriptionExecution;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.entities.hospital.prescription.PrescriptionStatus;
import businessFramework.module.Values;
import businessFramework.module.hospital.modals.inventories.InventoriesModal;
import businessFramework.module.hospital.modals.inventoriesComplex.InventoriesComplexModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrescriptionExecutionPage extends PrescriptionExecutionHelper implements Values {
    public PrescriptionExecutionPage(ApplicationManager app) {
        super(app);
    }

    public PrescriptionExecutionFilter getFilter() {
        return new PrescriptionExecutionFilter(app);
    }

    public InventoriesModal getInventoriesModal() {
        return new InventoriesModal();
    }

    public InventoriesComplexModal getInventoriesComplexModal() {
        return new InventoriesComplexModal(app);
    }

    public void clickExecuteAndWriteOffButton(boolean isComplex) {
        getExecuteAndWriteOffButton().assertIsDisplayed(!isComplex);
        getExecuteAndWriteOffComplexButton().assertIsDisplayed(isComplex);

        Button executeAndWriteOff = isComplex ? getExecuteAndWriteOffComplexButton() : getExecuteAndWriteOffButton();
        executeAndWriteOff.assertIsEnabled();
        executeAndWriteOff.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains(isComplex ? "Выбор товарных запасов" : "Выбор товарного запаса");
    }

    public void clickCancelExecuteButton() {
        Button cancelExecute = getCancelExecuteButton();
        cancelExecute.assertIsEnabled();
        cancelExecute.click();
        getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
    }

    /**
     * Проверка полей фильтра
     */
    public void assertFilter(HospitalData hospitalData) {
        PrescriptionExecutionFilter filter = getFilter();
        filter.getPrescriptionDate().assertThatDateContainsValue(getCurrentDate());
        filter.getPrescriptionDepartment().assertValue_equals(hospitalData.getDepartment());
        filter.getPrescriptionStatus().assertValue("Запланировано");
    }

    /**
     * Фильтрация по ФИО пациента
     */
    public void findPatient(HospitalData hospitalData, Integer statusId, String filterDate) {
        PrescriptionExecutionFilter filter = getFilter();
        getContainerPrescriptionScheduleList().getFilter().clickClearButton();
        filter.getPrescriptionDate().setValue(filterDate.substring(0, 10));
        filter.getPrescriptionPatient().setValue(hospitalData.getPatient());
        filter.getPrescriptionStatus().selectOption(statusId);
        getContainerPrescriptionScheduleList().getFilter().clickFindButton();
    }

    public void assertButtonsEnabledOrDisabled(boolean isExecuted, boolean isComplex) {
        assertExecuteAndWriteOffBtnEnabledOrDisabled(isExecuted, isComplex);
        if (isExecuted) {
            getExecuteAndWriteOffComplexButton().assertIsDisabled();
            getExecuteAndWriteOffButton().assertIsDisabled();
            getCancelExecuteButton().assertIsEnabled();
            getCancelPrescriptionButton().assertIsDisabled();
            getChangeExecuteDateButton().assertIsEnabled();
        } else {
            getExecuteAndWriteOffComplexButton().assertIsEnabled();
            getExecuteAndWriteOffButton().assertIsEnabled();
            getCancelExecuteButton().assertIsDisabled();
            getCancelPrescriptionButton().assertIsEnabled();
            getChangeExecuteDateButton().assertIsDisabled();
        }
    }

    /**
     * Изменение даты выполнения
     */
    public void changeExecutionDate(PrescriptionData prescriptionData) {
        getChangeExecuteDateButton().click();
        assertModalPresentOnPage(true);
        String newDt = getDateBeforeAfterCurrent(3) + " 10:00";
        getModal().getContainer("main").getForm().getInputDate("executionDt").setValue(newDt);
        getModal().getContainer("main").getButton(N2O_CONFIRM_BUTTON).click();
        assertModalPresentOnPage(false);
        getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        assertButtonsEnabledOrDisabled(true, prescriptionData.isComplex());
        assertExecutionDate(newDt);
    }

    /**
     * Отмена назначения
     */
    public void cancelPrescription(HospitalData hospitalData, PrescriptionData prescriptionData) {
        String cancelReason = "Причина отмены";

        findPatient(hospitalData, 1, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, false);

        getCancelPrescriptionButton().click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_equal("Отменить назначение");
        getModal().getForm().getTextArea("cancelReason").setValue(cancelReason);
        getModal().getContainer("main").getButton(N2O_CONFIRM_BUTTON).click();
        assertModalPresentOnPage(false);
        getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        prescriptionData.addExecutions(1);
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

        findPatient(hospitalData, 3, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, true);
        assertExecutionDateIsEqualToFiltered(true);
        assertCancelReason(cancelReason);
    }

    private void assertCancelReason(String expectedValue) {
        int index = getTablePrescriptionScheduleList().getChosenRowNumber();
        String actualValue = getTablePrescriptionScheduleList().getRowColumnIntersectionValue(index, "Причина отмены", true);
        assertThat("Cancel reason is not equal to expected", actualValue, is(expectedValue));
    }

    /**
     * Отмена выполнения
     */
    public void cancelExecute(HospitalData hospitalData, PrescriptionData prescriptionData) {
        getCancelExecuteButton().click();
        getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        prescriptionData.addExecutions(-1);
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

        findPatient(hospitalData, 1, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, false);
        assertExecutionDateIsEqualToFiltered(false);
    }

    /**
     * Выполнение лекарственного назначения
     */
    public void execute(HospitalData hospitalData, PrescriptionData prescriptionData) {
        clickQuickExecuteButton();
        assertQuickExecute(hospitalData,prescriptionData);
    }

    /**
     * Выполнение лекарственного назначения  с препаратом пациента
     */
    public void executeWithPatientMedicament(HospitalData hospitalData, PrescriptionData prescriptionData) {
        findPatient(hospitalData, 1, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, false);
        clickExecuteWithPatientMedicamentButton();
        assertQuickExecute(hospitalData, prescriptionData);
    }

    private void assertQuickExecute(HospitalData hospitalData, PrescriptionData prescriptionData) {
        getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        prescriptionData.addExecutions(1);
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

        findPatient(hospitalData, 2, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, true);
        assertExecutionDateIsEqualToFiltered(true);
    }

    public void assertCountOfRecords(int expectedCount) {
        getTablePrescriptionScheduleList().assertThatCountOfRowsIs(expectedCount);
    }

    /**
     * Выполнение и списание лекарственного назначения
     */
    public void executeAndWriteOff(HospitalData hospitalData, PrescriptionData prescriptionData) {
        findPatient(hospitalData, 1, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, false);

        clickExecuteAndWriteOffButton(prescriptionData.isComplex());
        if (prescriptionData.isComplex())
            getInventoriesComplexModal().fillForm(prescriptionData);
        else
            getInventoriesModal().selectInventory(prescriptionData.getHoldings().get(0));

        assertModalPresentOnPage(false);
        if (prescriptionData.isComplex())
            getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        prescriptionData.addExecutions(1);
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

    }

    public void assertExecuteAndWriteOff(HospitalData hospitalData, PrescriptionData prescriptionData) {
        findPatient(hospitalData, 2, prescriptionData.getPeriodBeginDt());
        chooseRow(prescriptionData, true);
        assertExecutionDateIsEqualToFiltered(true);
        assertHoldingsExecutionData(prescriptionData);
    }

    private void assertExecuteAndWriteOffBtnEnabledOrDisabled(boolean isExecuted, boolean isComplex) {
        Button execAndWriteOffBtn = isComplex ? getExecuteAndWriteOffComplexButton() : getExecuteAndWriteOffButton();
        if (isExecuted)
            execAndWriteOffBtn.assertIsDisabled();
        else
            execAndWriteOffBtn.assertIsEnabled();
    }

    public void assertExecutionDateIsEqualToFiltered(boolean isExecutionDtExpected) {
        int index = getTablePrescriptionScheduleList().getChosenRowNumber();
        String expectedExDt = "";
        if (isExecutionDtExpected) {
            String execution_time = getTablePrescriptionScheduleList().getRowColumnIntersectionValue(index, "Время", true);
            expectedExDt = getFilter().getPrescriptionDate().getValue() + " " + execution_time;
        }
        String execution_dt = getTablePrescriptionScheduleList().getRowColumnIntersectionValue(index, "Дата выполнения", true);
        assertThat("Execution date in table is not equal to expected",
                execution_dt, is(expectedExDt));
    }


    public void assertExecutionDate(String date) {
        int index = getTablePrescriptionScheduleList().getChosenRowNumber();
        String execution_dt = getTablePrescriptionScheduleList().getRowColumnIntersectionValue(index, "Дата выполнения", true);
        assertThat("Execution date in table is not equal to expected",
                execution_dt, is(date));
    }

    public void assertHoldingsExecutionData(PrescriptionData prescriptionData) {
        getTableHoldingList().assertThatCountOfRowsIs(prescriptionData.getHoldings().size());
        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            int ind = holdingData.getIndex();
            Map<String, String> map = new HashMap<>();
            map.put("Препарат", holdingData.getHolding());
            map.put("Доза", holdingData.getDoseWithMeasure());
            map.put("Модификация выполнения", holdingData.isPatientMedicament() ? "" : holdingData.getModification());
            map.put("Склад", holdingData.isPatientMedicament() ? "" : holdingData.getStore());

            getTableHoldingList().assertThatRowColumnsIntersectionValueContains(ind, map);
        }
    }

    public void chooseRow(PrescriptionData prescriptionData, boolean isExecutedOrCanceled) {
        Map<String, String> map = new HashMap<>();
        map.put("Комментарий", prescriptionData.getNote());
        int index = getTablePrescriptionScheduleList().getRowNumberBySeveralColumnValues(map, true);
        getTablePrescriptionScheduleList().chooseRowInTable(index);
        assertButtonsEnabledOrDisabled(isExecutedOrCanceled, prescriptionData.isComplex());
    }

    /**
     * Отмена проведения лекарственного назначения
     */
    public void cancelExecute() {
        int result = getTablePrescriptionScheduleList().getCountRowsInTable(true);

        for (int i = 0; i < result; i++) {
            getTablePrescriptionScheduleList().chooseRowInTable(i);
            String executionDt = getTablePrescriptionScheduleList().getRowColumnIntersectionValue(i, "Дата выполнения", true);
            if (!"".equals(executionDt)) {
                clickCancelExecuteButton();
                getTablePrescriptionScheduleList().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
            }
        }
    }

    public void closeModals(){
        while (isPresentModal()) {
            findElement(By.cssSelector(".close-modal-dictionary,.close-modal"), getModal().takeModal()).click();
            if (isAlertPresent())
                getDialog().clickYes();
        }
    }
}