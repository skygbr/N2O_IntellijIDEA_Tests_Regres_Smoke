package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.StoreSupplyData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.Values;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NurseDepartTest_OnceExecution extends TestBase {

    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private PrescriptionData prescriptionData;
    private StoreSupplyData storeSupplyData;


    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        prescriptionData = new PrescriptionData();
        storeSupplyData = new StoreSupplyData();
        PrescriptionHoldingData prescriptionHoldingData = new PrescriptionHoldingData();

        hospitalData.setPatient("Стационар Списание Напациента");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setAdmissionDate("24.03.2016");
        hospitalData.setDiagnosis("A03.8 Другой шигеллез");
        hospitalData.setUid("273");

        prescriptionHoldingData.setHolding("Мукалтин");
        prescriptionHoldingData.setCount(new BigDecimal(1));

        prescriptionData.setHoldings(new ArrayList<>());
        prescriptionData.getHoldings().add(prescriptionHoldingData);
        prescriptionData.setAdministrationRoute("Перорально");
        prescriptionData.setPeriodicity("1 раз в день");
        prescriptionData.setVisitTerm("Не имеет значения");
        prescriptionData.setPeriodBeginDt(getCurrentDate() + " 06:00");
        prescriptionData.setPeriodEndDt(getDateBeforeAfterCurrent(1) + " 05:59");
        prescriptionData.setEmployee("Нуждина Е. А.");

        storeSupplyData.setHoldingName(prescriptionHoldingData.getHolding());
        storeSupplyData.setComGroup("Лекарственные средства");
        storeSupplyData.setStoreName("Склад отделения экстренной госпитализации");
        storeSupplyData.setFundingSource("Средства граждан");
    }

    @Test(description = "Подготовка тестовых данных: удаление списанных препаратов")
    public void beforeTest() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openNurseDepartment();
        hospitalManager.getNurseDepartPage().filterByPatient(hospitalData);
        hospitalManager.getNurseDepartPage().deleteAllExecutedOncePrescriptions();
    }

    @Test(description = "Открытие страницы Медсестра стационара",
            dependsOnMethods = "beforeTest")
    public void step1_openPage() {
        hospitalManager.openNurseDepartment();
    }

    @Test(description = "Проверка пациента в модуле Медсестра стационара",
            dependsOnMethods = "step1_openPage")
    public void step2_assertPatientInNursePage() {
        hospitalManager.getNurseDepartPage().filterByPatient(hospitalData);
        hospitalManager.getNurseDepartPage().getContainerPatientList().getTable().assertThatTableContainsOnlyXRows(1);
        assertThat(String.format("Can't find patient %s in department", hospitalData.getPatient()),
                hospitalManager.getNurseDepartPage().getContainerPatientList().getTable().getRowColumnIntersectionValue(0, Values.PATIENT_FIELD, true),
                is(hospitalData.getPatient()));
    }

    @Test(description = "Списание на пациента. Добавить назначение",
            dependsOnMethods = "step2_assertPatientInNursePage", priority = 0)
    public void step3_addExecutedOncePrescription() {
        hospitalManager.getNurseDepartPage().addExecutedOncePrescription(hospitalData, prescriptionData, storeSupplyData);
    }

    @Test(description = "Списание на пациента. Проверить баланс на складе",
            dependsOnMethods = "step3_addExecutedOncePrescription", priority = 0)
    public void step4_assertStoreBalance_afterExecution() {
        hospitalManager.getNurseDepartPage().assertStoreBalanceChanged(storeSupplyData, -1);
    }

    @Test(description = "Списание на пациента. Проверить баланс препарата на складе после списания",
            dependsOnMethods = "step4_assertStoreBalance_afterExecution", priority = 0)
    public void step5_assertExecutedOncePrescription() {
        hospitalManager.getNurseDepartPage().assertExecutedOncePrescription(prescriptionData);
    }

    @Test(description = "Списание на пациента. Удалить назначение",
            dependsOnMethods = "step5_assertExecutedOncePrescription", priority = 0)
    public void step6_deleteExecutedOncePrescription() {
        hospitalManager.getNurseDepartPage().deleteExecutedOncePrescription();
    }

    @Test(description = "Списание на пациента. Проверить баланс препарата на складе после удаления назначения",
            dependsOnMethods = "step6_deleteExecutedOncePrescription", priority = 0)
    public void step7_assertStoreBalance_afterRemovingPrescription() {
        hospitalManager.getNurseDepartPage().assertStoreBalanceChanged(storeSupplyData, 1);
    }

}
