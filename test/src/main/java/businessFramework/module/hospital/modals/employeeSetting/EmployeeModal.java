package businessFramework.module.hospital.modals.employeeSetting;

import businessFramework.entities.hospital.EmployeeRoleData;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 01.09.2015
 */
public class EmployeeModal {
    private EmployeeHelper employeeHelper;
    private Page page = Page.getInstance();

    public EmployeeModal() {
        employeeHelper = new EmployeeHelper();
    }

    public void fillEmployeeRole(EmployeeRoleData data)
    {
        employeeHelper.getRole().setValue(data.getRole());
        employeeHelper.getEmployeeIndiv().setValue(data.getEmployee());
        employeeHelper.getEmployeeCheckboxGrid().chooseAllRows(true);
    }

    public void clickAddEmployeeRole() {
        clickConfirm();
    }

    public void clickCopyServices() {
        clickConfirm();
    }

    private void clickConfirm() {
        Button button = employeeHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertSuccessAlertIsPresent();
    }
}
