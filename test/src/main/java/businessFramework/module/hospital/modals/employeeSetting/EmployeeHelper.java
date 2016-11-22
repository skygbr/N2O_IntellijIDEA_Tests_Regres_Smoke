package businessFramework.module.hospital.modals.employeeSetting;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.CheckboxGrid;
import net.framework.autotesting.meta.components.Classifier;

/**
 * @author agabdrakhmanova
 * @since 01.09.2015
 */
public class EmployeeHelper implements Values {
    private String container;
    private Page page = Page.getInstance();
    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public EmployeeHelper()
    {
        this.container = "main";
    }

    public EmployeeHelper(String container)
    {
        this.container = container;
    }

    public Classifier getRole(){return getContainer().getForm().getClassifier("role");}

    public Classifier getEmployeeIndiv(){return getContainer().getForm().getClassifier("employeeIndiv");}

    public CheckboxGrid getEmployeeCheckboxGrid() {
        return getContainer().getForm().getCheckboxGrid("employee");
    }


    public Button getConfirmButton() {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
