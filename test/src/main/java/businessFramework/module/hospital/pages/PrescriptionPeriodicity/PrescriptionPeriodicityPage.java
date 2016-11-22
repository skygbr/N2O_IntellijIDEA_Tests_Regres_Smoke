package businessFramework.module.hospital.pages.PrescriptionPeriodicity;

import businessFramework.entities.hospital.PrescriptionPeriodicityData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PrescriptionPeriodicityPage extends PrescriptionPeriodicityHelper {

    public PrescriptionPeriodicityPage(ApplicationManager app) {
        super(app);
    }

    public void addPeriodicity(PrescriptionPeriodicityData periodicityData) {
        getContainerPeriodicity().getButton(CREATE_BUTTON).click();
        fillAndConfirmPeriodicityForm(periodicityData);
    }

    public void assertPeriodicity(PrescriptionPeriodicityData periodicityData) {
        assertPeriodicityTableSuccessMessageExists();
        openFilteredList_theOnlyRecord(periodicityData);
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put("Наименование", periodicityData.getName());
        columnValues.put("Количество", String.valueOf(periodicityData.getCount()));
        columnValues.put("Интервал", String.valueOf(periodicityData.getInterval()));
        getTablePeriodicity().assertThatRowColumnsIntersectionValueContains(0, columnValues);
    }

    public void updatePeriodicity(PrescriptionPeriodicityData periodicityData, PrescriptionPeriodicityData periodicityData_edit) {
        choosePeriodicityRowInTable(periodicityData.getName());
        getContainerPeriodicity().getButton(UPDATE_BUTTON).click();
        fillAndConfirmPeriodicityForm(periodicityData_edit);
        assertPeriodicity(periodicityData_edit);
    }

    private void fillAndConfirmPeriodicityForm(PrescriptionPeriodicityData periodicityData) {
        assertModalPresentOnPage(true);
        getNameField().setValue(periodicityData.getName());
        getCountField().setValue(String.valueOf(periodicityData.getCount()));
        getIntervalField().setValue(String.valueOf(periodicityData.getInterval()));
        confirmModal();
        assertModalPresentOnPage(false);
    }

    public void removePeriodicity(PrescriptionPeriodicityData periodicityData) {
        openFilteredList_theOnlyRecord(periodicityData);
        getContainerPeriodicity().getButton(DELETE_BUTTON).click();
        getModal().getButton(CONFIRM_BUTTON).click();
        assertPeriodicityTableSuccessMessageExists();
    }

    private void openFilteredList_theOnlyRecord(PrescriptionPeriodicityData periodicityData){
        openUrl(getPrescriptionFilteredListUrl(periodicityData.getName()));
        getContainerPeriodicity().assertCountTable(1);
        getContainerPeriodicity().getTable().chooseRowInTable(0);
    }

    private String getPrescriptionFilteredListUrl(String name) {
        String baseUrl = app.getProperty("baseUrl");
        baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        return baseUrl + "#hospital.hosp_prescription_periodicity_list?prescriptionPeriodicity:filter:name=" + name;
    }

    private void assertPeriodicityTableSuccessMessageExists() {
        getTablePeriodicity().getAlerts().assertSuccessAlertIsPresent();
    }

    private void assertTimeTableSuccessMessageExists() {
        getTableTime().getAlerts().assertSuccessAlertIsPresent();
    }

    private void choosePeriodicityRowInTable(String name) {
        getTablePeriodicity().chooseRowInTable(getIndexOfPeriodicityRowInTable(name));
    }

    private int getIndexOfPeriodicityRowInTable(String name) {
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put("Наименование", name);
        return getTablePeriodicity().getRowNumberBySeveralColumnValues(columnValues, true);
    }

    public void addTime(String periodicityName, String time) {
        choosePeriodicityRowInTable(periodicityName);
        getContainerTime().getButton(CREATE_BUTTON).click();
        fillAndConfirmTimeForm(time);
    }

    public void assertTimeCountValidationMessage() {
        String message = "Количество записей не должно превышать значение поля 'Количество приемов'";
        assertThat("Валидация кол-ва записей в таблице 'Время приема' не сработала.\n Ожидалось сообщение " + message,
                isPresentModal(), is(true));
        getModal().getForm().getAlerts()
                .assertErrorAlertMessage(message);
        cancelModal();
        getAlerts().acceptAlert();
    }

    private void fillAndConfirmTimeForm(String time) {
        assertModalPresentOnPage(true);
        getTimeField().setValueWithoutClear(time);
        clickModalHeader();
        confirmModal();
    }

    private void clickModalHeader() {
        click(findElement(By.cssSelector(".modal-header"), getModal().takeModal()));
    }

    public void assertCountOfTimeRows(int expectedCount) {
        int actualCount = getTableTime().getCountRowsInTable(true);
        assertThat("Количество записей в таблице 'Время приема' превышает указанное в поле 'Количество приемов (в день)'",
                actualCount, lessThanOrEqualTo(expectedCount));
    }

    public void removeTimeRows(String periodicityName) {
        choosePeriodicityRowInTable(periodicityName);
        while (getTableTime().getCountRowsInTable(true) > 0) {
            getTableTime().chooseRowInTable(0);
            getContainerTime().getButton(DELETE_BUTTON).click();
            getModal().getButton(CONFIRM_BUTTON).click();
            assertTimeTableSuccessMessageExists();
        }
        getTableTime().assertThatCountOfRowsIs(0);
    }

    public void assertTime(String time) {
        assertTimeTableSuccessMessageExists();
        assertThat("Сохраненное время приема не соответствует ожидаемому",
                getTableTime().getRowValues(0, true).get(0), containsString(time));
    }

    public void updateTime(String time) {
        getTableTime().chooseRowInTable(0);
        getContainerTime().getButton(UPDATE_BUTTON).click();
        fillAndConfirmTimeForm(time);
        assertTime(time);
    }

    private void confirmModal() {
        Button btn = getModal().getButton(N2O_CONFIRM_BUTTON);
        btn.assertIsEnabled();
        btn.click();
    }

    private void cancelModal() {
        getModal().getButton(N2O_CANCEL_BUTTON).click();
    }

}
