package test.businessTests.hospital;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PrescriptionExecutionTest extends TestBase {
    private static String VALIDATION_MESSAGE =
            "Удаление невозможно. В отделении/случае есть списанные препараты по лекарственному назначению";

    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private PrescriptionData prescriptionData;
    private PrescriptionData prescriptionData_copy;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        prescriptionData = new PrescriptionData();
        prescriptionData_copy = new PrescriptionData();

        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setAdmissionDepartment("Отделение экстренной госпитализации");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setDiagnosis("");
        hospitalData.setUid("191");

        PrescriptionHoldingData prescriptionHoldingData_1 = new PrescriptionHoldingData();
        prescriptionHoldingData_1.setIndex(0);
        prescriptionHoldingData_1.setHolding("Мукалтин");
        prescriptionHoldingData_1.setCount(new BigDecimal(1));
        prescriptionHoldingData_1.setPatientMedicament(false);

        PrescriptionHoldingData prescriptionHoldingData_2 = new PrescriptionHoldingData();
        prescriptionHoldingData_2.setIndex(1);
        prescriptionHoldingData_2.setHolding("Тауфон");
        prescriptionHoldingData_2.setCount(new BigDecimal(5));
        prescriptionHoldingData_2.setPatientMedicament(true);

        PrescriptionHoldingData prescriptionHoldingData_3 = new PrescriptionHoldingData();
        prescriptionHoldingData_3.setIndex(2);
        prescriptionHoldingData_3.setHolding("Тауфон");
        prescriptionHoldingData_3.setCount(new BigDecimal(2));
        prescriptionHoldingData_3.setPatientMedicament(false);

        prescriptionData.setHoldings(new ArrayList<>());
        prescriptionData.getHoldings().add(prescriptionHoldingData_1);
        prescriptionData.getHoldings().add(prescriptionHoldingData_2);
        prescriptionData.getHoldings().add(prescriptionHoldingData_3);
        prescriptionData.setAdministrationRoute("Перорально");
        prescriptionData.setPeriodicity("2 раза в день");
        prescriptionData.setTimes(2);
        prescriptionData.setVisitTerm("Не имеет значения");
        prescriptionData.setPeriodBeginDt(getCurrentDate() + " 00:00");
        prescriptionData.setPeriodEndDt(getCurrentDate() + " 23:59");
        prescriptionData.setDayAmount(1);
        prescriptionData.setEmployee("Нуждина Е. А.");
        prescriptionData.setNote("создание");

        prescriptionData_copy = prescriptionData.clone();
        prescriptionData_copy.setHoldings(new ArrayList<>());
        prescriptionData_copy.getHoldings().add(prescriptionHoldingData_1);
        prescriptionData_copy.setDayAmount(1);
        prescriptionData_copy.setNote("копирование");
        prescriptionData_copy.setVisitTerm("До еды");
    }

    @Test(description = "Подготовка тестовых данных: удаление лекарственных назначений пациента, если существуют")
    public void beforeTest() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        if (hospitalManager.getBranchManagerPage().getTable().getCountRowsInTable(true) > 0) {
            hospitalManager.getBranchManagerPage().cancelDischarge();
            hospitalManager.getBranchManagerPage().clickMedicalHistory();
            hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteAllPrescriptions();
        }
    }

    @Test(description = "Открытие страницы Заведующий отделением", dependsOnMethods = "beforeTest")
    public void step01_openPage() {
        hospitalManager.openBranchManager();
    }

    @Test(description = "Создание комплексного назначения", dependsOnMethods = "step01_openPage")
    public void step02_PrescriptionCreateUpdate() {
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createPrescription(prescriptionData);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertPrescription(prescriptionData);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updatePrescription(prescriptionData);
    }

    @Test(description = "Подтверждение комплексного назначения", dependsOnMethods = "step02_PrescriptionCreateUpdate")
    public void step03_PrescriptionConfirm() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().confirmPrescription(prescriptionData);
    }

    @Test(description = "Просмотр комплексного назначения", dependsOnMethods = "step03_PrescriptionConfirm")
    public void step04_PrescriptionRead() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().readPrescription(prescriptionData);
        hospitalManager.getBranchManagerPage().closeAllModalsOnPage();
    }

    @Test(description = "Копирование и подтверждение простого лекарственного назначения", dependsOnMethods = "step04_PrescriptionRead")
    public void step05_PrescriptionCopyAndConfirm() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().copyPrescription(prescriptionData, prescriptionData_copy);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertPrescription(prescriptionData_copy);
        hospitalManager.getBranchManagerPage().closeAllModalsOnPage();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().confirmPrescription(prescriptionData_copy);
    }

    @Test(description = "Процедурная медсестра. Проверка количества записей",dependsOnMethods = "step05_PrescriptionCopyAndConfirm")
    public void step06_PrescriptionExecutionPage_AssertCountOfRecords() {
        hospitalManager.openPrescriptionExecutionPage();
        hospitalManager.getPrescriptionExecutionPage().assertFilter(hospitalData);
        hospitalManager.getPrescriptionExecutionPage().findPatient(hospitalData, 1, prescriptionData.getPeriodBeginDt());
        hospitalManager.getPrescriptionExecutionPage().assertCountOfRecords(prescriptionData.getTimes() + prescriptionData_copy.getTimes());
    }

    @Test(description = "Выполнение и списание (простое) процедурной медсестрой", dependsOnMethods = "step06_PrescriptionExecutionPage_AssertCountOfRecords")
    public void step07_PrescriptionExecuteWithWriteOff() {

        hospitalManager.getPrescriptionExecutionPage().executeAndWriteOff(hospitalData, prescriptionData_copy);
        hospitalManager.getPrescriptionExecutionPage().assertExecuteAndWriteOff(hospitalData, prescriptionData_copy);
    }

    @Test(description = "Выполнение и списание (комплексное) процедурной медсестрой", dependsOnMethods = "step07_PrescriptionExecuteWithWriteOff")
    public void step08_PrescriptionExecuteWithWriteOff_complex() {
        hospitalManager.getPrescriptionExecutionPage().executeAndWriteOff(hospitalData, prescriptionData);
        hospitalManager.getPrescriptionExecutionPage().assertExecuteAndWriteOff(hospitalData, prescriptionData);
    }

    @Test(description = "Изменение даты выполнения процедурной медсестрой", dependsOnMethods = "step08_PrescriptionExecuteWithWriteOff_complex")
    public void step09_PrescriptionChangeExecuteDate() {
        hospitalManager.getPrescriptionExecutionPage().changeExecutionDate(prescriptionData);
    }

    @Test(description = "Отмена выполнения процедурной медсестрой", dependsOnMethods = "step09_PrescriptionChangeExecuteDate")
    public void step10_PrescriptionCancelExecute() {
        hospitalManager.getPrescriptionExecutionPage().cancelExecute(hospitalData, prescriptionData);
    }

    @Test(description = "Выполнение назначения процедурной медсестрой", dependsOnMethods = "step10_PrescriptionCancelExecute")
    public void step11_PrescriptionExecute() {
        hospitalManager.getPrescriptionExecutionPage().execute(hospitalData, prescriptionData);
        hospitalManager.getPrescriptionExecutionPage().cancelExecute(hospitalData, prescriptionData);
    }

    @Test(description = "Выполнение с препаратом пациента процедурной медсестрой и отмена выполнения", dependsOnMethods = "step11_PrescriptionExecute")
    public void step11_1_PrescriptionExecuteWithPatientMedicament() {
        hospitalManager.getPrescriptionExecutionPage().executeWithPatientMedicament(hospitalData, prescriptionData_copy);
    }

    @Test(description = "Отмена назначения процедурной медсестрой", dependsOnMethods = "step11_1_PrescriptionExecuteWithPatientMedicament")
    public void step12_PrescriptionCancelOne() {
        hospitalManager.getPrescriptionExecutionPage().cancelPrescription(hospitalData, prescriptionData);
    }

    @Test(description = "Проверка статусов", dependsOnMethods = "step12_PrescriptionCancelOne")
    public void step13_PrescriptionsStatusCheck() {
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().findAllPrescriptions();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertPrescriptionStatus(prescriptionData);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertPrescriptionStatus(prescriptionData_copy);
    }

    @Test(description = "Отмена назначения", dependsOnMethods = "step13_PrescriptionsStatusCheck")
    public void step14_PrescriptionCancel() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().cancelPrescription(prescriptionData);
    }

    @Test(description = "Возобновление назначения", dependsOnMethods = "step14_PrescriptionCancel")
    public void step15_PrescriptionResume() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().resumePrescription(prescriptionData);
    }

    @Test(description = "Продление назначения", dependsOnMethods = "step15_PrescriptionResume")
    public void step16_PrescriptionProlong() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().prolongPrescription(prescriptionData);
    }

    @Test(description = "Попытка удалить ЗОГ со списанным лекарством", dependsOnMethods = "step16_PrescriptionProlong")
    public void step17_attemptRemoveHospitalRecordWithWriteOffPreparation() {
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteLastHospitalRecord();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerHospitalRecords().getTable()
                .getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE);
    }

    @Test(description = "Попытка удалить случай со списанным лекарством",
            dependsOnMethods = "step17_attemptRemoveHospitalRecordWithWriteOffPreparation")
    public void step18_attemptRemoveCaseWithWriteOffPreparation() {
        hospitalManager.openAdmisDepart();
        hospitalManager.getAdmisDepartPage().deleteHospitalCaseByFilter(hospitalData);
        hospitalManager.getAdmisDepartPage().getContainerHospitalCases().getTable()
                .getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE);
    }

    @Test(description = "Отмена выполнения всех выполненных",
            dependsOnMethods = "step18_attemptRemoveCaseWithWriteOffPreparation", alwaysRun = true)
    public void step19_cancelAllPrescriptions() {
        hospitalManager.getPrescriptionExecutionPage().closeModals();
        hospitalManager.openPrescriptionExecutionPage();
        hospitalManager.getPrescriptionExecutionPage().findPatient(hospitalData, 0, getCurrentDate());
        hospitalManager.getPrescriptionExecutionPage().cancelExecute();
    }
}
