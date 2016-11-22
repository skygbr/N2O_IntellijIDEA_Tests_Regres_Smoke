package businessFramework.module.hospital.modals.service;


import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ServiceHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public ServiceHelper()
    {
        this.container = "main";
    }

    public ServiceHelper(String cotainer)
    {
        this.container = cotainer;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public InputDate getBdate()
    {
        return getContainer().getForm().getInputDate("bdate");
    }

    public Classifier getService()
    {
        return getContainer().getForm().getClassifier("service");
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
