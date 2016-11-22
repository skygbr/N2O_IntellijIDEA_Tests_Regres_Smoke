package businessFramework.module.hospital.pages.informationDesk;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class InformationDeskFilter extends InformationDeskHelper
{
    public InformationDeskFilter(ApplicationManager app){
        super(app);
    }

    public Classifier getPatient()
    {
        return getContainerInformationDesk().getFilter().getClassifier("patient");
    }

    public InputCheckBox getState()
    {
        return getContainerInformationDesk().getFilter().getInputCheckBox("state");
    }
}
