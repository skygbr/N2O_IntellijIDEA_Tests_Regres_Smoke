package businessFramework.module.hospital.modals.prescriptionRead;

import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import net.framework.autotesting.ApplicationManager;
import org.openqa.selenium.By;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class PrescriptionReadModal extends PrescriptionReadHelper {

    public PrescriptionReadModal(ApplicationManager app) {
        super(app);
    }

    //Проверка полей модального окна Просмотр лекарственного назначения (верхний контейнер)
    public void assertPrescriptionInfo(PrescriptionData prescriptionData) {
        int actualCountOfHoldingRows = getCountOfVisibleHoldingRows();
        int expectedCountOfHoldingRows = prescriptionData.getHoldings().size();
        assertCountOfVisibleHoldingRows(actualCountOfHoldingRows, expectedCountOfHoldingRows);

        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings())
            assertHoldingFields(holdingData, prescriptionData.getTimes(), prescriptionData.getDayAmount());

        getAdministrationRouteField().assertFieldText(prescriptionData.getAdministrationRoute());
        getPeriodicityField().assertFieldText(prescriptionData.getPeriodicity());
        getVisitTermField().assertFieldText(prescriptionData.getVisitTerm());
        getDayAmountWithDatesField().assertFieldText(prescriptionData.getDayAmount()
                + " (" + prescriptionData.getPeriodBeginDt() + " - " + prescriptionData.getPeriodEndDt() + ")");
        getDoctorField().assertFieldText(prescriptionData.getEmployee());
    }

    // Проверка полей Препарата
    private void assertHoldingFields(PrescriptionHoldingData holdingData, int times, int dayAmount) {
        int index = holdingData.getIndex();
        getHoldingField(index).assertFieldText(holdingData.getHolding());
        getSingleDoseField(index).assertFieldText(holdingData.getDoseWithMeasure());
        getDailyDoseField(index).assertFieldText(holdingData.getDose().multiply(new BigDecimal(times)) + " " + holdingData.getDoseMeasure());
        getCourseDoseField(index).assertFieldText(holdingData.getDose().
                multiply(new BigDecimal(times)).
                multiply(new BigDecimal(dayAmount)) + " " + holdingData.getDoseMeasure());
    }

    //Заполнение полей модального окна Лекарственное назначение
    public void assertScheduleList(PrescriptionData prescriptionData) {
        int expectedCountOfRowsInTable = prescriptionData.getTimes() * prescriptionData.getDayAmount();

        if (expectedCountOfRowsInTable <= 10) {
            getBottomTable().assertThatCountOfRowsIs(expectedCountOfRowsInTable);
        } else {
            String actualCountText = findElement(By.cssSelector(".n2o-paging-text span"),
                    getBottomContainer().takeContainer()).getText().trim();

            assertThat("Table count text is not equal to expected",
                    actualCountText, is("Всего " + expectedCountOfRowsInTable + " записи"));
        }
    }

    private void assertCountOfVisibleHoldingRows(int actualCount, int expectedCount) {
        assertThat("Holding rows assertion: count of visible rows is not equal to expected",
                actualCount, is(expectedCount));
    }
}
