package businessFramework.module.hospital.pages.servicesTemplate;

import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplatePrescriptionData;
import businessFramework.module.hospital.modals.medicament.HoldingModal;
import net.framework.autotesting.ApplicationManager;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ServiceTemplatePrescriptionModal extends ServiceTemplatePrescriptionHelper {

    public ServiceTemplatePrescriptionModal(ApplicationManager app) {
        super(app);
    }

    public HoldingModal getHoldingModal() {
        return new HoldingModal();
    }

    // проверка значений по умолчанию
    public void assertDefaultValues() {
        getBeginDayField().assertValue("1");
    }

    //Заполнение полей модального окна
    public void fillForm(ServicesTemplatePrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        int expectedCountOfHoldingRows = 1;
        assertCountOfVisibleHoldingRows(actualCountOfHoldingRows, expectedCountOfHoldingRows);

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            fillHoldingFields(holdingData, false);
        }
        getAdministrationRouteField().setValue(0);
        prescriptionData.setAdministrationRoute(getAdministrationRouteField().getValue());

        getPeriodicityField().setValue(prescriptionData.getPeriodicity());

        getVisitTermField().setValue(0);
        prescriptionData.setVisitTerm(getVisitTermField().getValue());

        getBeginDayField().setValue(String.valueOf(prescriptionData.getBeginDay()));
        getCountDayField().setValue(String.valueOf(prescriptionData.getCountDay()));
        getNoteFiled().setValue(prescriptionData.getTemplateNote());
        prescriptionData.setDayAmount(prescriptionData.getCountDay());
        prescriptionData.calculateSingleDailyCourseDose();
    }

    public void fillHoldingFields(PrescriptionHoldingData holdingData, boolean isCopy) {
        int index = holdingData.getIndex();
        if (index > 0)
            clickAddHoldingRow();
        getHoldingField(index).findModalButtonClick();
        if (!isCopy)
            getHoldingModal().selectHolding(index, holdingData);
        else
            getHoldingModal().selectHolding(2, holdingData);

        holdingData.setMneiName(getMneiNameField(index).getText());
        if (holdingData.getCount() != null) {
            getCountField(index).setValue(holdingData.getCount().toPlainString());
            assertDoseCalculatedCorrectly(holdingData);
        } else {
            getDoseField(index).setValue(holdingData.getDose().toPlainString());
            assertCountCalculatedCorrectly(holdingData);
        }
        assertHoldingOutputFields(holdingData);
    }

    //Проверка полей модального окна
    public void assertForm(ServicesTemplatePrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        int expectedCountOfHoldingRows = prescriptionData.getHoldings().size();
        assertCountOfVisibleHoldingRows(actualCountOfHoldingRows, expectedCountOfHoldingRows);

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings())
            assertHoldingFields(holdingData);

        getAdministrationRouteField().assertValue_contains(prescriptionData.getAdministrationRoute());
        getPeriodicityField().assertValue_contains(prescriptionData.getPeriodicity());
        getVisitTermField().assertValue_contains(prescriptionData.getVisitTerm());
        getBeginDayField().assertValue(String.valueOf(prescriptionData.getBeginDay()));
        getCountDayField().assertValue(String.valueOf(prescriptionData.getCountDay()));
        getNoteFiled().assertValue(prescriptionData.getTemplateNote());
    }

    // Проверка полей Препарата
    private void assertHoldingFields(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        getHoldingField(index).assertValue_contains(holdingData.getHolding());
        getCountField(index).assertValue(holdingData.getCount().toPlainString());
        getDoseField(index).assertValue(holdingData.getDose().toPlainString());
        assertHoldingOutputFields(holdingData);
    }

    public void updateCommentField(ServicesTemplatePrescriptionData prescriptionData) {
        prescriptionData.setTemplateNote("редактирование");
        getNoteFiled().setValue(prescriptionData.getTemplateNote());
        getConfirmButton().click();
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

    private void calculateExpectedCount(PrescriptionHoldingData holdingData) {
        BigDecimal countValue = holdingData.getDose().divide(holdingData.getDosage(), 3, RoundingMode.HALF_UP);
        holdingData.setCount(countValue);
    }

    private void assertDoseCalculatedCorrectly(PrescriptionHoldingData holdingData) {
        calculateExpectedDose(holdingData);
        assertThat("Dose calculation assertion: not correct value",
                getDoseField(holdingData.getIndex()).getValue(),
                is(holdingData.getDose().toPlainString()));
    }

    private void assertCountCalculatedCorrectly(PrescriptionHoldingData holdingData) {
        calculateExpectedCount(holdingData);
        assertThat("Count calculation assertion: not correct value",
                getCountField(holdingData.getIndex()).getValue(),
                is(holdingData.getCount().toPlainString()));
    }

    private void assertHoldingOutputFields(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        getDosageWithMeasureField(index).assertFieldText(holdingData.getDosageWithMeasure());
    }

    //Заполнение полей модального окна (копирование)
    public void fillCopyForm(ServicesTemplatePrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        if (actualCountOfHoldingRows > 1) {
            while (actualCountOfHoldingRows > 1) {
                clickRemoveHoldingRow();
                actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
            }
            //assertFieldsClearedAfterHoldingRowWasRemoved();
        }

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            fillHoldingFields(holdingData, true);
        }
        prescriptionData.setAdministrationRoute(getAdministrationRouteField().getValue());
        getAdministrationRouteField().setValue(prescriptionData.getAdministrationRoute());
        getVisitTermField().setValue(prescriptionData.getVisitTerm());

        getBeginDayField().setValue(String.valueOf(prescriptionData.getBeginDay()));
        getCountDayField().setValue(String.valueOf(prescriptionData.getCountDay()));
        getNoteFiled().setValue(prescriptionData.getTemplateNote());
        prescriptionData.setDayAmount(prescriptionData.getCountDay());
        prescriptionData.calculateSingleDailyCourseDose();
    }

    private void assertFieldsClearedAfterHoldingRowWasRemoved() {
        clickAddHoldingRow();
        int indexOfClearedRow = getCountOfVisibleHoldingRows() - 1;
        getHoldingField(indexOfClearedRow).assertValue_equals("");
        getCountField(indexOfClearedRow).assertValue_equals(false, "");
        getDoseField(indexOfClearedRow).assertValue_equals(false, "");
        getMneiNameField(indexOfClearedRow).assertFieldText("");
        getDosageWithMeasureField(indexOfClearedRow).assertFieldText("");
        clickRemoveHoldingRow();
    }
}
