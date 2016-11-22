package test.businessTests.hospital;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.entities.hospital.StoreSupplyData;
import businessFramework.entities.hospital.SurgicalTeamData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.operation.journal.OperationJournalPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bulat.garipov on 01.03.2016.
 */
public class OperationJournalTest extends TestBase {

    private HospitalManager hospitalManager;
    private OperationServiceData operationServiceData;
    private SurgicalTeamData surgicalTeamData1;
    private SurgicalTeamData surgicalTeamData2;
    private PrescriptionData prescriptionData;
    private StoreSupplyData storeSupplyData;
    private OperationJournalPage operationJournalPage;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();

        operationServiceData = new OperationServiceData();
        operationServiceData.setDepartment("Отделение экстренной госпитализации");
        operationServiceData.setMedicalCase("№111autotest Стационар Тест Автотестович(01/01/2001)");

        operationServiceData.setPlannedDate(page.addMinutes(page.getCurrentDateTime(), 30));
        operationServiceData.setService("Операция(автотест)");
        operationServiceData.setSurgeon("Автотестов Х. А., Хирург-автотест");
        operationServiceData.setOperationRoom("Операционная(автотест)");
        operationServiceData.setFinancialType("ОМС");
        operationServiceData.setUrgent(true);

        surgicalTeamData1 = new SurgicalTeamData();
        surgicalTeamData1.setRole("Врач");
        surgicalTeamData1.setEmployee("Нуждина Е. А., Врач стационара");

        surgicalTeamData2 = new SurgicalTeamData();
        surgicalTeamData2.setRole("Хирург");
        surgicalTeamData2.setEmployee("Автотестов Х. А., Хирург-автотест");

        PrescriptionHoldingData prescriptionHoldingData = new PrescriptionHoldingData();
        prescriptionHoldingData.setHolding("Мукалтин");
        prescriptionHoldingData.setCount(new BigDecimal(1));

        prescriptionData = new PrescriptionData();
        prescriptionData.setHoldings(new ArrayList<>());
        prescriptionData.getHoldings().add(prescriptionHoldingData);
        prescriptionData.setAdministrationRoute("Перорально");
        prescriptionData.setEmployee("Нуждина Е. А.");

        storeSupplyData = new StoreSupplyData();
        storeSupplyData.setHoldingName(prescriptionHoldingData.getHolding());
        storeSupplyData.setStoreName("Склад отделения экстренной госпитализации");
        storeSupplyData.setFundingSource("Средства граждан");

    }

    @Test(description = "Выбор контекста, Открытие страницы 'Журнал операций'")
    public void openOperationJournal() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext("Отделение экстренной госпитализации");
        hospitalManager.openOperationJournal();
        operationJournalPage = hospitalManager.getOperationJournalPage();
    }

    @Test(description = "1. Добавить операцию", dependsOnMethods = "openOperationJournal")
    public void createPlannedOperation() {
        operationJournalPage.createPlannedOperation(operationServiceData);
    }

    @Test(description = "2. Найти созданную операцию в списке", dependsOnMethods = "createPlannedOperation")
    public void filterByDate() {
        operationJournalPage.filterByDate(operationServiceData.getPlannedDate());
    }

    @Test(description = "3. Выполнить", dependsOnMethods = "filterByDate")
    public void render() {
        operationJournalPage.render();
    }

    @Test(description = "4. Отменить выполнение", dependsOnMethods = "render")
    public void cancelRender() {
        operationJournalPage.cancelRender();
    }

    @Test(description = "5. Выполнить услугу через 'Внести протокол' и после отменить выполнение", dependsOnMethods = "cancelRender")
    public void renderThroughProtocol() {
        operationJournalPage.getCreateRenderOperationButton().click();
        hospitalManager.getAddResultToOperationPage().assertForm(operationServiceData);
        hospitalManager.getAddResultToOperationPage().save(operationServiceData);
        hospitalManager.getAddResultToOperationPage().assertForm(operationServiceData);
        hospitalManager.getAddResultToOperationPage().clickBackButton();
        operationJournalPage.checkAfterRender();
    }

    @Test(description = "6. Проверить опер. бригаду. В списке должна быть 1 запись", dependsOnMethods = "renderThroughProtocol")
    public void checkSurgicalTeamAfterRender() {
        operationJournalPage.getSurgicalTeamContainer().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "7. Удалить сотрудника из опер. бригады", dependsOnMethods = "checkSurgicalTeamAfterRender")
    public void deleteEmployeeFromTeam() {
        operationJournalPage.deleteEmployeeFromTeam();
    }

    @Test(description = "8. Добавить сотрудника в опер. бригаду", dependsOnMethods = "deleteEmployeeFromTeam")
    public void addEmployeeToSurgicalTeam() {
        operationJournalPage.addEmployeeToSurgicalTeam(surgicalTeamData1);
    }

    @Test(description = "9. Редактировать сотрудника", dependsOnMethods = "addEmployeeToSurgicalTeam")
    public void editEmployee() {
        operationJournalPage.updateEmployeeInSurgicalTeam(surgicalTeamData1, surgicalTeamData2);
    }

    @Test(description = "10. Добавить расходные материалы", dependsOnMethods = "checkSurgicalTeamAfterRender")
    public void createPrescription() {
        operationJournalPage.createPrescription(prescriptionData, storeSupplyData);
    }

    @Test(description = "11. Проверить кол-во на складе после создания", dependsOnMethods = "createPrescription")
    public void checkBalanceAfterCreate() {
        operationJournalPage.checkBalance(storeSupplyData, -1);
    }

    @Test(description = "12. Проверить невозможность отменить выполнение после списания препарата", dependsOnMethods = "checkBalanceAfterCreate")
    public void checkCancelRenderAfterWriteOff() {
        operationJournalPage.checkCancelRenderAfterWriteOff();
    }

    @Test(description = "13.  Удалить расходные материалы", dependsOnMethods = "checkBalanceAfterCreate")
    public void deletePrescription() {
        operationJournalPage.deletePrescription();
    }

    @Test(description = "14.  Проверить кол-во препарата на складе после удаления", dependsOnMethods = "deletePrescription")
    public void checkBalanceAfterDelete() {
        operationJournalPage.checkBalance(storeSupplyData, 1);
    }

    @Test(description = "15. Отменить выполнение после всех проверок и удаление операции", dependsOnMethods = "checkBalanceAfterDelete")
    public void cancelAfterRender() {
        operationJournalPage.cancelRender();
        operationJournalPage.deletePlannedOperation();

    }
}
