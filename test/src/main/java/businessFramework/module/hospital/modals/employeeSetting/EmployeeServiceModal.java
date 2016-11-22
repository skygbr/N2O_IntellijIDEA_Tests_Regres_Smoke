package businessFramework.module.hospital.modals.employeeSetting;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 02.09.2015
 */
public class EmployeeServiceModal {
    private EmployeeServiceHelper employeeServiceHelper;
    private EmployeeHelper employeeHelper;

    private Page page = Page.getInstance();

    public EmployeeServiceModal() {
        employeeServiceHelper = new EmployeeServiceHelper();
        employeeHelper = new EmployeeHelper();
    }

    public void addService(String service)
    {
        Container container = employeeServiceHelper.getContainer();
        container.getFilter().getInputText("serviceNameCode").setValue(service);
        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(2);

        container.getTable().chooseCheckboxInRow(0, "", true);
        container.getTable().chooseCheckboxInRow(1, "", true);
    }

    public void deleteService(String service)
    {
        Container container = employeeServiceHelper.getContainer();
        container.getFilter().getInputText("serviceNameCode").setValue(service);
        container.getFilter().getSelect("choice").selectOption("Свои");
        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(1);

        container.getTable().chooseCheckboxInRow(0, "", true);
    }

    public void chooseEmployeesForServicesCopy(String employee)
    {
        employeeHelper.getEmployeeIndiv().setValue(employee);
        employeeHelper.getEmployeeCheckboxGrid().chooseAllRows(true);
    }

}
