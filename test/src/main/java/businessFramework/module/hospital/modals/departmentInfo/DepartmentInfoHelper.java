package businessFramework.module.hospital.modals.departmentInfo;

import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;

public class DepartmentInfoHelper
{
    private String container;
    private Page page = Page.getInstance();

    public DepartmentInfoHelper()
    {
        this.container = "departmentInfo";
    }

    public DepartmentInfoHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getDepartment()
    {
        return page.getModal().getFilter().getClassifier("department");
    }
}
