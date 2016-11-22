package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.entities.hospital.ServiceRenderedByTemplateData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bulat.garipov on 27.01.2016.
 */

public class MedicalHistory_Operation extends TestBase {
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private OperationServiceData operationServiceData1;
    private OperationServiceData operationServiceData2;
    private OperationServiceData operationServiceRenderedData;

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

        operationServiceData1 = new OperationServiceData();
        operationServiceData1.setHospitalRecord("Отделение экстренной госпитализации");
        operationServiceData1.setPlannedDate(page.addMinutes(page.getCurrentDateTime(), 30));
        operationServiceData1.setUrgent(true);
        operationServiceData1.setService("Операция(автотест)");
        operationServiceData1.setSurgeon("Автотестов Х. А., Хирург-автотест");
        operationServiceData1.setOperationRoom("Операционная(автотест)");
        operationServiceData1.setFinancialType("ОМС");

        operationServiceData2 = new OperationServiceData();
        operationServiceData2.setHospitalRecord("Отделение экстренной госпитализации");
        operationServiceData2.setPlannedDate(page.addMinutes(page.getCurrentDateTime(), 60));
        operationServiceData2.setUrgent(false);
        operationServiceData2.setService("Операция(автотест)");
        operationServiceData2.setSurgeon("Автотестов Х. А., Хирург-автотест");
        operationServiceData2.setOperationRoom("Операционная(автотест)");
        operationServiceData2.setFinancialType("Средства граждан");

        operationServiceRenderedData = new OperationServiceData();
        operationServiceRenderedData.setRenderedDate(page.addDays(page.getCurrentDateTime(), 1));
        operationServiceRenderedData.setUrgent(true);
        operationServiceRenderedData.setAnesthesiaType("Общая");
        operationServiceRenderedData.setComplicationType("Кровотечение");

    }

    @Test(description = "Выбор контекста, Открытие страницы 'Истории болезни'")
    public void step01_openMedicalHistory() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
    }

    @Test(description = "Создание плановой операции",dependsOnMethods = "step01_openMedicalHistory")
    public void step02_createPlannedOperation() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().sendToDepartment();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteAllSendToDepartment();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createPlannedOperation(operationServiceData1);
    }

    @Test(description = "Изменение плановой операции",dependsOnMethods = "step02_createPlannedOperation")
    public void step03_updatePlannedOperation() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updatePlannedOperation(operationServiceData1, operationServiceData2);
    }

    @Test(description = "Добавить результат",dependsOnMethods = "step03_updatePlannedOperation")
    public void step04_addResult() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().addResultToOperationClick();
        hospitalManager.getAddResultToOperationPage().assertForm(operationServiceData2);
        hospitalManager.getAddResultToOperationPage().save(operationServiceRenderedData);
        hospitalManager.getAddResultToOperationPage().assertForm(operationServiceRenderedData);
        hospitalManager.getAddResultToOperationPage().clickBackButton();
    }

    @Test(description = "Удалить",dependsOnMethods = "step04_addResult")
    public void step05_delete() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteRenderedServices();
    }

}
