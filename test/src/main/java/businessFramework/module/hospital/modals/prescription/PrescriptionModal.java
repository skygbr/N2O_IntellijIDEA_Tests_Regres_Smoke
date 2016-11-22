package businessFramework.module.hospital.modals.prescription;

import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.hospital.modals.medicament.HoldingModal;
import net.framework.autotesting.ApplicationManager;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class PrescriptionModal extends PrescriptionHelper {

    public PrescriptionModal(ApplicationManager app) {
        super(app);
    }

    public HoldingModal getHoldingModal() {
        return new HoldingModal();
    }

    //Проверка полей модального окна Лекарственное назначение
    public void assertPrescriptionForm(PrescriptionData prescriptionData, boolean isCopying) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        int expectedCountOfHoldingRows = prescriptionData.getHoldings().size();
        assertCountOfVisibleHoldingRows(actualCountOfHoldingRows, expectedCountOfHoldingRows);

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings())
            assertHoldingFields(holdingData);

        getAdministrationRouteField().assertValue_contains(prescriptionData.getAdministrationRoute());
        getPeriodicityField().assertValue_contains(prescriptionData.getPeriodicity());
        getVisitTermField().assertValue_contains(prescriptionData.getVisitTerm());
        if (!isCopying) {
            getBeginDateField().assertValue_contains(prescriptionData.getPeriodBeginDt());
            getEndDateField().assertValue_contains(prescriptionData.getPeriodEndDt());
        } else {
            getBeginDateField().assertValue_contains(getCurrentDate());
            getEndDateField().assertValue_equals(false, "");
        }
        getNoteFiled().assertValue(prescriptionData.getNote());

        getSingleDoseFiled().assertFieldText(prescriptionData.getSingleDoseWithMeasure());
        getDailyDoseFiled().assertFieldText(prescriptionData.getDailyDoseWithMeasure());
        if (!isCopying)
            getCourseDoseFiled().assertFieldText(prescriptionData.getCourseDoseWithMeasure());
    }

    // Проверка полей Препарата
    private void assertHoldingFields(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        getHoldingField(index).assertValue_contains(holdingData.getHolding());
        getCountField(index).assertValue(String.valueOf(holdingData.getCount()));
        getDoseField(index).assertValue(String.valueOf(holdingData.getDose()));
        assertHoldingOutputFields(holdingData);
        getIsPatientMedicamentCheckbox(index).assertThatCheckboxIsChecked(holdingData.isPatientMedicament());
    }

    public void updateCommentField(PrescriptionData prescriptionData) {
        prescriptionData.setNote("редактирование");
        getNoteFiled().setValue(prescriptionData.getNote());
        getConfirmButton().click();
    }

    //Заполнение полей модального окна Лекарственное назначение
    public void fillPrescriptionForm(PrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        int expectedCountOfHoldingRows = 1;
        assertCountOfVisibleHoldingRows(actualCountOfHoldingRows, expectedCountOfHoldingRows);

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            fillHoldingFields(holdingData);
        }
        getAdministrationRouteField().setValue(prescriptionData.getAdministrationRoute());
        getPeriodicityField().setValue(prescriptionData.getPeriodicity());
        getVisitTermField().setValue(prescriptionData.getVisitTerm());
        getBeginDateField().assertValue_contains(getCurrentDate());
        getBeginDateField().setValue(prescriptionData.getPeriodBeginDt());
        getEndDateField().setValue(prescriptionData.getPeriodEndDt());
        getNoteFiled().setValue(prescriptionData.getNote());

        getDayAmountField().assertFieldText(String.valueOf(prescriptionData.getDayAmount()));
        prescriptionData.calculateSingleDailyCourseDose();
        getSingleDoseFiled().assertFieldText(prescriptionData.getSingleDoseWithMeasure());
        getDailyDoseFiled().assertFieldText(prescriptionData.getDailyDoseWithMeasure());
        getCourseDoseFiled().assertFieldText(prescriptionData.getCourseDoseWithMeasure());
    }

    public void fillHoldingFields(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        if (index > 0)
            clickAddHoldingRow();
        getHoldingField(index).findModalButtonClick();
        getHoldingModal().selectHolding(holdingData);
        getCountField(index).setValue(String.valueOf(holdingData.getCount()));
        assertDoseCalculatedCorrectly(holdingData);
        assertHoldingOutputFields(holdingData);
        getIsPatientMedicamentCheckbox(index).check(holdingData.isPatientMedicament());
    }

    private void clickAddHoldingRow() {
        int countBefore = getCountOfVisibleHoldingRows();
        getDoseField(0).clickLink("+");
        assertCountOfVisibleHoldingRows(getCountOfVisibleHoldingRows(), countBefore + 1);
    }

    private void clickRemoveHoldingRow() {
        int countBefore = getCountOfVisibleHoldingRows();
        getDoseField(0).clickLink("-");
        assertCountOfVisibleHoldingRows(getCountOfVisibleHoldingRows(), countBefore - 1);
    }

    private void assertCountOfVisibleHoldingRows(int actualCount, int expectedCount) {
        assertThat("Holding rows assertion: count of visible rows is not equal to expected",
                actualCount, is(expectedCount));
    }

    private void calculateExpectedDose(PrescriptionHoldingData holdingData) {
        BigDecimal doseValue = holdingData.getCount().multiply(holdingData.getDosage());
        holdingData.setDose(doseValue);
    }

    private void assertDoseCalculatedCorrectly(PrescriptionHoldingData holdingData) {
        calculateExpectedDose(holdingData);
        assertThat("Dose calculation assertion: not correct value",
                Integer.valueOf(getDoseField(holdingData.getIndex()).getValue()),
                is(holdingData.getDose().intValue()));
    }

    private void assertHoldingOutputFields(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        getDosageWithMeasureField(index).assertFieldText(holdingData.getDosageWithMeasure());
    }

    //Заполнение полей модального окна Лекарственное назначение (копирование)
    public void fillPrescriptionCopyForm(PrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        if (actualCountOfHoldingRows > 1) {
            while (actualCountOfHoldingRows > 1) {
                clickRemoveHoldingRow();
                actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
            }
            //assertFieldsClearedAfterHoldingRowWasRemoved();
        }

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            fillHoldingFields(holdingData);
        }
        getAdministrationRouteField().setValue(0);
        prescriptionData.setAdministrationRoute(getAdministrationRouteField().getValue());
        getVisitTermField().setValue(prescriptionData.getVisitTerm());
        getNoteFiled().setValue(prescriptionData.getNote());
        getBeginDateField().setValue(prescriptionData.getPeriodBeginDt());
        getEndDateField().setValue(prescriptionData.getPeriodEndDt());

        getDayAmountField().assertFieldText(String.valueOf(prescriptionData.getDayAmount()));
        prescriptionData.calculateSingleDailyCourseDose();
        getSingleDoseFiled().assertFieldText(prescriptionData.getSingleDoseWithMeasure());
        getDailyDoseFiled().assertFieldText(prescriptionData.getDailyDoseWithMeasure());
        getCourseDoseFiled().assertFieldText(prescriptionData.getCourseDoseWithMeasure());
    }

    private void assertFieldsClearedAfterHoldingRowWasRemoved() {
        clickAddHoldingRow();
        int indexOfClearedRow = getCountOfVisibleHoldingRows() - 1;
        getHoldingField(indexOfClearedRow).assertValue_equals("");
        getCountField(indexOfClearedRow).assertValue_equals(false, "");
        getDoseField(indexOfClearedRow).assertValue_equals(false, "");
        getMneiNameField(indexOfClearedRow).assertFieldText("");
        getDosageWithMeasureField(indexOfClearedRow).assertFieldText("");
        getIsPatientMedicamentCheckbox(indexOfClearedRow).assertThatCheckboxIsChecked(false);
        clickRemoveHoldingRow();
    }
}
