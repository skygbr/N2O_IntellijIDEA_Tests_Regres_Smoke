package businessFramework.module.hospital.pages.doctorDepart;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class DoctorDepartFilter extends DoctorDepartHelper
{
    public DoctorDepartFilter(ApplicationManager app) {
        super(app);
    }

    public Classifier getPatient()
    {
        return getContainerMedicalHistoryList().getFilter().getClassifier("patient");
    }

    public InputCheckBox getShowClosedCasesCheckbox() {
        return getContainerMedicalHistoryList().getFilter().getInputCheckBox("showClosedCases");
    }
}
