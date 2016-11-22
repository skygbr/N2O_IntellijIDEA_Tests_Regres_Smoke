package test.businessTests.hospital;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.operation.planning.OperationPlanningPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperationPlanningTest extends TestBase {

    private HospitalManager hospitalManager;
    private OperationServiceData operationServiceData1;
    private OperationServiceData operationServiceData2;
    private OperationPlanningPage operationPlanningPage;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();

        operationServiceData1 = new OperationServiceData();
        operationServiceData1.setDepartment("Отделение экстренной госпитализации");
        operationServiceData1.setMedicalCase("№111autotest Стационар Тест Автотестович(01/01/2001)");

        operationServiceData1.setPlannedDate(page.addMinutes(page.getCurrentDateTime(), 30));
        operationServiceData1.setService("Операция(автотест)");
        operationServiceData1.setSurgeon("Автотестов Х. А., Хирург-автотест");
        operationServiceData1.setOperationRoom("Операционная(автотест)");
        operationServiceData1.setFinancialType("ОМС");
        operationServiceData1.setUrgent(true);

        operationServiceData2 = new OperationServiceData();
        operationServiceData2.setPlannedDate(page.addMinutes(page.getCurrentDateTime(), 30));
        operationServiceData2.setService("Операция(автотест)");
        operationServiceData2.setSurgeon("Автотестов Х. А., Хирург-автотест");
        operationServiceData2.setOperationRoom("Операционная(автотест)");
        operationServiceData2.setFinancialType("ОМС");
        operationServiceData2.setUrgent(false);
        operationServiceData2.setQueue("2");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Планирование операций'")
    public void openOperationPlanning() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext("Отделение экстренной госпитализации");
        hospitalManager.openOperationPlanning();
        operationPlanningPage = hospitalManager.getOperationPlanningPage();
        operationPlanningPage.deleteAllForDayOperations();
    }

    @Test(description = "1. Добавить операцию", dependsOnMethods = "openOperationPlanning")
    public void createPlannedOperation() {
        operationPlanningPage.createPlannedOperation(operationServiceData1);
    }

    @Test(description = "2. Изменить операцию", dependsOnMethods = "createPlannedOperation")
    public void updatePlannedOperation() {
        operationPlanningPage.updatePlannedOperation(operationServiceData1, operationServiceData2);
    }

    @Test(description = "3. Вернуть операцию", dependsOnMethods = "updatePlannedOperation")
    public void cancelOperation() {
        operationPlanningPage.cancelOperation();
    }

    @Test(description = "4. Отменить операцию", dependsOnMethods = "updatePlannedOperation")
    public void returnOperation() {
        operationPlanningPage.returnOperation();
    }

    @Test(description = "5. Запланировать", dependsOnMethods = "updatePlannedOperation")
    public void addQueueFromSchedule() {
        operationPlanningPage.addQueueFromSchedule();
    }

    @Test(description = "6. Удалить созданную операцию", dependsOnMethods = "addQueueFromSchedule")
    public void deletePlannedOperations() {
        operationPlanningPage.deleteAllForDayOperations();
    }

}
