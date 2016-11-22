package businessFramework.module.gibddMedicalExamination.pages.Doctor;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class DoctorFilter extends DoctorHelper
{
    public DoctorFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputText getPatient()
    {
        return getContainerServicesList().getFilter().getInputText("fio");
    }

}
