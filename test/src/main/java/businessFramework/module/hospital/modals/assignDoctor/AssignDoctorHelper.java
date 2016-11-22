package businessFramework.module.hospital.modals.assignDoctor;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;


public class AssignDoctorHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public AssignDoctorHelper()
    {
        this.container = "assignDoctorContainerForm";
    }

    public AssignDoctorHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getDoctor()
    {
        return getContainer().getForm().getClassifier("doctor");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
