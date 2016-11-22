package businessFramework.module.hospital.modals.employeeSetting;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.CheckboxGrid;

/**
 * @author agabdrakhmanova
 * @since 02.09.2015
 */
public class EmployeeServiceHelper implements Values {
    private String container;
    private Page page = Page.getInstance();
    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public EmployeeServiceHelper()
    {
        this.container = "serviceList";
    }
}
