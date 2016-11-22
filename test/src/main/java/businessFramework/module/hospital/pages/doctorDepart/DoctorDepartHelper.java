package businessFramework.module.hospital.pages.doctorDepart;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DoctorDepartHelper extends Page implements Values
{
    public DoctorDepartHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerMedicalHistoryList()
    {
        return getContainer("medicalHistoryList");
    }

    public Container getContainerServiceRenderedList()
    {
        return getContainer("serviceRenderedList");
    }

    public Container getContainerPrescriptionsList() {
        return getContainer("prescriptionList");
    }

    public Button getDeletePrescriptionButton() {
        return getContainerPrescriptionsList().getButton(DELETE_BUTTON);
    }
}
