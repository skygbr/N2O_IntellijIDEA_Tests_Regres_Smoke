package businessFramework.module.hospital.modals.createBedResource;


import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class CreateBedResourceHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public CreateBedResourceHelper()
    {
        this.container = "main";
    }

    public CreateBedResourceHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getBedResource()
    {
        return getContainer().getForm().getClassifier("bedResource");
    }

    public InputDate getBeginDate()
    {
        return getContainer().getForm().getInputDate("beginDate");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
