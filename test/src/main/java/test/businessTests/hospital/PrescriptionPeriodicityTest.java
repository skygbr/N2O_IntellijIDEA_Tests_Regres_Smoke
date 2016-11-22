package test.businessTests.hospital;

import businessFramework.entities.hospital.PrescriptionPeriodicityData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.PrescriptionPeriodicity.PrescriptionPeriodicityPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PrescriptionPeriodicityTest extends TestBase {
    private HospitalManager hospitalManager;
    private PrescriptionPeriodicityData periodicityData;
    private PrescriptionPeriodicityData periodicityData_edit;
    private PrescriptionPeriodicityPage periodicityPage;

    @BeforeClass
    public void initialize() {
        hospitalManager = new HospitalManager();
        periodicityData = new PrescriptionPeriodicityData();
        periodicityData.setName("Только " + getCurrentDateTime());
        periodicityData.setCount(2);
        periodicityData.setInterval(0);

        periodicityData_edit = new PrescriptionPeriodicityData();
        periodicityData_edit.setName(periodicityData.getName() + " ред");
        periodicityData_edit.setCount(1);
        periodicityData_edit.setInterval(1);
        periodicityData_edit.setTimeArray(new String[]{"11:00", "13:00"});
    }

    @Test(description = "1. Периодичности назначения. Создание, редактирование")
    public void step1_prescriptionPeriodicity_createUpdate() {
        hospitalManager.openHospitalModule();
        hospitalManager.openPrescriptionPeriodicityPage();
        periodicityPage = hospitalManager.getPrescriptionPeriodicityPage();
        periodicityPage.addPeriodicity(periodicityData);
        periodicityPage.assertPeriodicity(periodicityData);
        periodicityPage.updatePeriodicity(periodicityData, periodicityData_edit);
    }

    @Test(description = "2. Время приема. Создание, редактирование",
            dependsOnMethods = "step1_prescriptionPeriodicity_createUpdate")
    public void step2_periodicityTime_createUpdate() {
        periodicityPage.addTime(periodicityData_edit.getName(), periodicityData_edit.getTimeArray()[0]);
        periodicityPage.assertTime(periodicityData_edit.getTimeArray()[0]);
        periodicityPage.assertCountOfTimeRows(1);
        periodicityPage.updateTime(periodicityData_edit.getTimeArray()[1]);
    }

    @Test(description = "3. Время приема. Проверка валидации на кол-во записей в таблице Время приема",
            dependsOnMethods = "step2_periodicityTime_createUpdate")
    public void step3_periodicityTime_checkCountValidation() {
        periodicityPage.addTime(periodicityData_edit.getName(), periodicityData_edit.getTimeArray()[0]);
        periodicityPage.assertTimeCountValidationMessage();
        periodicityPage.assertCountOfTimeRows(1);
    }

    @Test(description = "4. Время приема. Удаление",
            dependsOnMethods = "step3_periodicityTime_checkCountValidation", alwaysRun = true)
    public void step4_periodicityTime_remove() {
        periodicityPage.removeTimeRows(periodicityData_edit.getName());
    }

    @Test(description = "5. Периодичности назначения. Удаление",
            dependsOnMethods = "step4_periodicityTime_remove", alwaysRun = true)
    public void step5_prescriptionPeriodicity_remove() {
        periodicityPage.closeAllModalsOnPage();
        periodicityPage.removePeriodicity(periodicityData_edit);
    }

}
