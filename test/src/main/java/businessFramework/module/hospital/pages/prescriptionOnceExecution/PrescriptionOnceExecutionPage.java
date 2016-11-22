package businessFramework.module.hospital.pages.prescriptionOnceExecution;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.StoreSupplyData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class PrescriptionOnceExecutionPage extends PrescriptionOnceExecutionHelper implements PrescriprionOnceExecutionValues {
    public PrescriptionOnceExecutionPage(ApplicationManager app) {
        super(app);
    }

    public HoldingBalanceModal getHoldingBalanceModal() {
        return new HoldingBalanceModal(app);
    }

    // Инфопанель

    public void assertInfoPanel(HospitalData data) {
        getPatientField().assertValue_contains(data.getPatient());
        getCaseUidField().assertValue(data.getUid());
        assertThat("Field Диагноз assertion failed", getDiagnosisField().getValue(), containsString(data.getDiagnosis()));
        getAdmissionDateField().assertValue_equals(data.getAdmissionDate());
    }

    // Таблица

    public void assertPrescriptionsCount(int expectedCount) {
        getListTable().assertThatCountOfRowsIs(expectedCount);
    }

    public void removeAllPrescriptions() {
        int count = getListTable().getCountRowsInTable(true);
        while (count > 0 )  {
            removePrescription();
            count = count - 1;
        }
        getRemoveButton().assertIsDisabled();
        assertPrescriptionsCount(0);
    }

    public void removePrescription() {
        getListTable().chooseRowInTable(0);
        getRemoveButton().click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void assertPrescriptionTableRowValues(int row, PrescriptionData data) {
        Map<String, String> map = new HashMap<>();
        map.put(COLUMN_HOLDING,     data.getHoldings().get(0).getHolding());
        map.put(COLUMN_DOSE,        data.getHoldings().get(0).getDoseWithMeasure());
        map.put(COLUMN_FROM,        data.getPeriodBeginDt().substring(0, 10));
        map.put(COLUMN_TO,          data.getPeriodEndDt().substring(0,10));
        map.put(COLUMN_PERIODICITY, data.getPeriodicity());
        map.put(COLUMN_EMPLOYEE,    data.getEmployee());
        getListTable().assertThatRowColumnsIntersectionValueContains(row, map);
    }

    // Форма

    private void clickConfirmButton() {
        Button btn = getConfirmButton();
        btn.assertTitle(CONFIRM_BUTTON_LABEL_TEXT);
        getConfirmButton().click();
    }

    public void addExecutedOncePrescription(PrescriptionData data, StoreSupplyData storeData) {
        getCreateMoreWebElement().click();
        fillForm(data, storeData);
        clickConfirmButton();
        assertBreadcrumbContainsValue(BREADCRUMB_TEXT);
        getPrescriptionForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        assertPrescriptionsCount(1);
    }

    public void assertStoreBalanceChanged(StoreSupplyData storeData, int difference) {
        getHoldingField().findModalButtonClick();
        assertModalPresentOnPage(true);
        getHoldingBalanceModal().assertBalanceChanged(storeData, difference);
        assertModalPresentOnPage(false);
    }

    private void fillForm(PrescriptionData data, StoreSupplyData storeData) {
        setHoldingFieldValue(storeData);
        getCountField().setValue(String.valueOf(data.getHoldings().get(0).getCount()));
        assertAutoFieldFields();
        saveTotalDoseAndMeasure(data);
        getAdministrationRouteField().setValue(data.getAdministrationRoute());
        getPeriodicityField().setValue(data.getPeriodicity());
        getVisitTermField().setValue(data.getVisitTerm());
        getFromField().setValue(data.getPeriodBeginDt());
        getToField().setValue(data.getPeriodEndDt());
    }

    private void setHoldingFieldValue(StoreSupplyData storeSupplyData) {
        getHoldingField().findModalButtonClick();
        assertModalPresentOnPage(true);
        getHoldingBalanceModal().chooseHolding(storeSupplyData);
        assertModalPresentOnPage(false);
        getHoldingField().assertValue_contains(storeSupplyData.getHoldingName());
    }

    private void assertAutoFieldFields() {
        assertFieldValueIsNotEmpty(getDoseField().getValue(),           "Доза" );
        assertFieldValueIsNotEmpty(getDoseWithMeasureField().getText(), "Дозировка" );
        assertFieldValueIsNotEmpty(getMneiNameField().getText(),        "Основная ед.изм.");
        getFromField().assertValue_contains(getCurrentDate());

    }

    private void saveTotalDoseAndMeasure(PrescriptionData data) {
        String doseAndMeasure = getDoseWithMeasureField().getText().trim();
        String dose = doseAndMeasure.split(" ")[0];
        BigDecimal totalDose = data.getHoldings().get(0).getCount().multiply(new BigDecimal(dose));
        data.getHoldings().get(0).setDose(totalDose);
        data.getHoldings().get(0).setDoseMeasure(doseAndMeasure.replace(dose, "").trim());
    }

    private void assertFieldValueIsNotEmpty(String value, String label) {
        assertThat(String.format("Field '%s' value is expected to be not null or empty", label),
                value, not(isEmptyOrNullString()));
    }
}