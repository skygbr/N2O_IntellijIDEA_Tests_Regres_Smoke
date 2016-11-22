package businessFramework.module.hospital.pages.employeeSetting;

import businessFramework.entities.hospital.EmployeeRoleData;
import businessFramework.module.hospital.modals.employeeSetting.EmployeeModal;
import businessFramework.module.hospital.modals.employeeSetting.EmployeeServiceModal;
import net.framework.autotesting.ApplicationManager;

/**
 * @author agabdrakhmanova
 * @since 01.09.2015
 */
public class EmployeeSettingPage extends EmployeeSettingHelper {
    private EmployeeModal employeeModal;
    private EmployeeServiceModal employeeServiceModal;

    public EmployeeSettingPage(ApplicationManager app) {
        super(app);
        employeeModal = new EmployeeModal();
        employeeServiceModal = new EmployeeServiceModal();
    }

    public void addRole(EmployeeRoleData data) {
        clickButtonOpeningModal(getAddRoleButton(), "Назначить роль сотрудникам");
        employeeModal.fillEmployeeRole(data);
        employeeModal.clickAddEmployeeRole();

        getEmployeesContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        getEmployeesContainer().showFilter();
        getEmployeesContainer().getFilter().getClassifier("employeeIndiv").setValue(data.getEmployee());
        getEmployeesContainer().getFilter().clickFindButton();
        getEmployeesContainer().getTable().assertThatCountOfRowsIs(1);
    }

    public void deleteRole() {
        getDeleteRoleButton().click();
        getModal().getButton(CONFIRM_BUTTON).click();
        getEmployeesContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void addService(String service) {
        clickButtonOpeningModal(getAddServiceButton(), "Выбор услуг");
        employeeServiceModal.addService(service);
        getModal().closeModal();
        getEmployeeServicesContainer().getTable().assertThatCountOfRowsIs(2);
    }

    public void deleteService() {
        getDeleteServiceButton().click();
        getModal().getButton(CONFIRM_BUTTON).click();
        getEmployeeServicesContainer().getTable().assertThatCountOfRowsIs(1);
        getEmployeeServicesContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteServiceAcrossCheckbox(String service) {
        clickButtonOpeningModal(getAddServiceButton(), "Выбор услуг");
        employeeServiceModal.deleteService(service);
        getModal().closeModal();
        getEmployeeServicesContainer().getTable().assertThatCountOfRowsIs(0);
    }

    public void copyServicesToEmployee(String employee)
    {
        clickButtonOpeningModal(getCopyServicesButton(), "Выбор сотрудников");
        employeeServiceModal.chooseEmployeesForServicesCopy(employee);
        employeeModal.clickCopyServices();
        getEmployeeServicesContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void checkCopiedServices(String employee)
    {
        getEmployeesContainer().showFilter();
        getEmployeesContainer().getFilter().getClassifier("employeeIndiv").setValue(employee);
        getEmployeesContainer().getFilter().clickFindButton();
        getEmployeesContainer().getTable().assertThatCountOfRowsIs(1);

        getEmployeeServicesContainer().getTable().assertThatCountOfRowsIs(2);
    }

}
