package businessFramework.module.hospital.pages.employeeSetting;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 01.09.2015
 */
public class EmployeeSettingHelper extends Page implements Values {
    public EmployeeSettingHelper(ApplicationManager app) {
        super(app);
    }

    public Container getEmployeesContainer() {
        return getRegion(LEFT).getContainer("employeeList");
    }

    public Container getEmployeeServicesContainer() {
        return getRegion(RIGHT).getContainer("employeeServices");
    }

    public Button getAddRoleButton() {
        return getEmployeesContainer().getButton("assignRole");
    }

    public Button getDeleteRoleButton() {
        return getEmployeesContainer().getButton("deleteRole");
    }

    public Button getAddServiceButton() {
        return getEmployeeServicesContainer().getButton("create");
    }

    public Button getCopyServicesButton() {
        return getEmployeeServicesContainer().getButton("copy");
    }

    public Button getDeleteServiceButton() {
        return getEmployeeServicesContainer().getButton("delete");
    }

}
