package test.businessTests.hospital;

import businessFramework.entities.hospital.EmployeeRoleData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.employeeSetting.EmployeeSettingPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 01.02.2015.
 */
public class EmployeeSettingTest extends TestBase {
    private HospitalManager hospitalManager;
    private EmployeeSettingPage employeeSettingPage;
    private EmployeeRoleData employeeRoleData;
    private String service = "Услуга для автотеста стационара";

    @BeforeClass
    public void initialize() {
        hospitalManager = new HospitalManager();
        employeeRoleData = new EmployeeRoleData();
        employeeRoleData.setRole("Врач");
        employeeRoleData.setEmployee("Автотестов А. А.");
        employeeRoleData.setCopyToEmployee("Автотестов2 А. А.");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Роли сотрудников'")
    public void step01_openServiceTemplate() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext("Отделение экстренной госпитализации");
        hospitalManager.openEmployeeSettingPage();
        employeeSettingPage = hospitalManager.getEmployeeSettingPage();
    }

    @Test(description = "Добавление роли для сотрудника", dependsOnMethods = "step01_openServiceTemplate")
    public void step02_addRole() {
        employeeSettingPage.addRole(employeeRoleData);
    }

    @Test(description = "Удаление роли сотрудника", dependsOnMethods = "step02_addRole")
    public void step03_deleteRole() {
        employeeSettingPage.deleteRole();
    }

    @Test(description = "Добавление услуг для сотрудника", dependsOnMethods = "step03_deleteRole")
    public void step04_addService() {
        employeeSettingPage.addService(service);
    }

    @Test(description = "Копировать услуги для других сотрудников", dependsOnMethods = "step04_addService")
    public void step05_copyServices() {
        employeeSettingPage.copyServicesToEmployee(employeeRoleData.getCopyToEmployee());
        employeeSettingPage.checkCopiedServices(employeeRoleData.getCopyToEmployee());
    }

    @Test(description = "Удаление услуги для сотрудника", dependsOnMethods = "step05_copyServices")
    public void step06_deleteService() {
        employeeSettingPage.deleteService();
    }

    @Test(description = "Удаление услуги сотрудника через чекбокс", dependsOnMethods = "step06_deleteService")
    public void step07_deleteServiceAcrossCheckbox() {
        employeeSettingPage.deleteServiceAcrossCheckbox(service);
    }
}
