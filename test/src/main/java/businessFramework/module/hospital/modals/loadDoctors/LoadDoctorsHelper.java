package businessFramework.module.hospital.modals.loadDoctors;


import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.Classifier;

public class LoadDoctorsHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public LoadDoctorsHelper()
    {
        this.container = "doctorWorkload";
    }

    public LoadDoctorsHelper(String container)
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
