package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.prescription.PrescriptionCancelData;
import businessFramework.entities.hospital.prescription.PrescriptionServiceData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.prescriptionExecution.PrescriptionServiceExecutionPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 02.03.2016.
 */
public class MedicalHistoryPrescriptionServiceTest extends TestBase {
    private HospitalManager hospitalManager;

    private PrescriptionServiceData prescriptionServiceData1;
    private PrescriptionServiceData prescriptionServiceData2;
    private PrescriptionCancelData prescriptionCancelData;
    private HospitalData hospitalData;

    private PrescriptionServiceExecutionPage prescriptionServiceExecutionPage;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();

        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setDoctor("Нуждина Е. А., Врач стационара");
        hospitalData.setDiagnosis("");
        hospitalData.setStageDiagnosis("Клинический");
        hospitalData.setAdmissionDepartment("Отделение экстренной госпитализации");
        hospitalData.setUid("191");

        prescriptionCancelData = new PrescriptionCancelData();
        prescriptionCancelData.setCancelDt("30.11.2015 14:00");
        prescriptionCancelData.setCancelReason("Отмена автотест");

        prescriptionServiceData1 = new PrescriptionServiceData();
        prescriptionServiceData1.setService("Процедура(автотест)");
        prescriptionServiceData1.setDuration("10");
        prescriptionServiceData1.setSrvDurationUnit("мин.");
        prescriptionServiceData1.setPeriodicity("2 раза в день");
        prescriptionServiceData1.setVisitTerm("До еды");
        prescriptionServiceData1.setPeriodBeginDt("30.11.2015 15:00");
        prescriptionServiceData1.setPeriodEndDt("02.12.2015 22:00");
        prescriptionServiceData1.setExecution("Обязательно");
        prescriptionServiceData1.setNote("Запись создана из автотеста");
        prescriptionServiceData1.setCount("5");
        prescriptionServiceData1.setCaseInfo("№191, Стационар Второй Александрович (28.01.1988)");
        prescriptionServiceData1.setHospitalRecord(hospitalData.getDepartment());
        prescriptionServiceData1.setName("Процедура(автотест) 10 мин.");
        prescriptionServiceData1.setFinancialType("ОМС");

        prescriptionServiceData2 = new PrescriptionServiceData();
        prescriptionServiceData2.setName("Процедура(автотест) 10мин.");
        prescriptionServiceData2.setService("Процедура(автотест)");
        prescriptionServiceData2.setDuration("2");
        prescriptionServiceData2.setSrvDurationUnit("ч.");
        prescriptionServiceData2.setPeriodicity("2 раза в день");
        prescriptionServiceData2.setVisitTerm("После еды");
        prescriptionServiceData2.setPeriodBeginDt("30.11.2015 00:00");
        prescriptionServiceData2.setPeriodEndDt("01.12.2015 22:00");
        prescriptionServiceData2.setExecution("Обязательно");
        prescriptionServiceData2.setNote("Запись создана из автотеста");
        prescriptionServiceData2.setCount("4");
        prescriptionServiceData2.setCaseInfo("№191, Стационар Второй Александрович (28.01.1988)");
        prescriptionServiceData2.setHospitalRecord(hospitalData.getDepartment());
        prescriptionServiceData2.setGeneratedFirstDate("30.11.2015 08:00");
        prescriptionServiceData2.setFinancialType("ОМС");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Истории болезни'")
    public void openMedicalHistory() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        prescriptionServiceExecutionPage = hospitalManager.getPrescriptionServiceExecutionPage();
    }

    @Test(description = "Создание назначения процедуры",dependsOnMethods = "openMedicalHistory")
    public void createPrescriptionService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createPrescriptionService(prescriptionServiceData1);
    }

    @Test(description = "Изменить назначение процедуры",dependsOnMethods = "createPrescriptionService")
    public void updatePrescriptionService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updatePrescriptionService(prescriptionServiceData1, prescriptionServiceData2);
    }

    @Test(description = "Подтвердить назначения процедуры",dependsOnMethods = "updatePrescriptionService")
    public void confirmPrescriptionService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().confirmPrescriptionService(prescriptionServiceData2);
    }

    @Test(description = "Проверить, что после подтверждения назначения, создались услуги",dependsOnMethods = "confirmPrescriptionService")
    public void checkPlannedServiceListAfterConfirmPrescription() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().checkPlannedServiceListAfterConfirmPrescription(prescriptionServiceData2);
    }

    @Test(description = "Проверить изменения статуса назначения и доступность кнопок после выполнения назначенной услуги",
            dependsOnMethods = "checkPlannedServiceListAfterConfirmPrescription")
    public void checkPrescriptionServiceListAfterRenderService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().checkPrescriptionServiceListAfterRenderService(prescriptionServiceData2);
    }

    @Test(description = "Отменить назначение процедуры",dependsOnMethods = "checkPrescriptionServiceListAfterRenderService")
    public void cancelPrescriptionService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().cancelPrescriptionService
                (prescriptionCancelData, prescriptionServiceData2.getService());
    }

    @Test(description = "Проверить список назначенных услуг после отмены назначения",dependsOnMethods = "cancelPrescriptionService")
    public void checkPlannedServiceListAfterCancelPrescription() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().checkPlannedServiceListAfterCancelPrescription
                (prescriptionServiceData2.getService());
    }

    @Test(description = "Удалить назначение процедуры",dependsOnMethods = "checkPlannedServiceListAfterCancelPrescription")
    public void deletePrescriptionService() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deletePrescriptionService();
    }


}
