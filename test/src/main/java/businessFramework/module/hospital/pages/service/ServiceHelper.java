package businessFramework.module.hospital.pages.service;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ServiceHelper extends Page implements Values
{

    public ServiceHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainer()
    {
        return getContainer("main");
    }

    public InputDate getBdate()
    {
        return getContainer().getForm().getInputDate("bdate");
    }

    public Classifier getService()
    {
        return getContainer().getForm().getClassifier("service");
    }

    public Classifier getHospitalRecord()
    {
        return getContainer().getForm().getClassifier("hospitalRecord");
    }

    public Classifier getDoctor()
    {
        return getContainer().getForm().getClassifier("doctor");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getBackButton()
    {
        return getButton("back");
    }
}
