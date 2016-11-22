package businessFramework.module.hospital.pages.nurseDepart;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class NurseDepartFilter extends NurseDepartHelper
{
    public NurseDepartFilter(ApplicationManager app)
    {
        super(app);
    }

    public Classifier getPatient()
    {
        return getContainerPatientList().getFilter().getClassifier("patient");
    }
}
