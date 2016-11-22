package businessFramework.module.hospital.pages.nurseDepart;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class NurseDepartHelper extends Page implements Values
{
    public NurseDepartHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerPatientList()
    {
        return getContainer("patientList");
    }

    public Container getContainerBedList()
    {
        return getContainer("bedList");
    }

    public Container getContainerHospitalRecordList()
    {
        return getContainer("hospitalRecordList");
    }

    public Button getCreateBedResourceButton()
    {
        return getContainerBedList().getButton("create");
    }

    public Button getUpdateBedResourceButton()
    {
        return getContainerBedList().getButton("update");
    }

    public Button getDeleteBedResourceButton()
    {
        return getContainerBedList().getButton("delete");
    }

    public Button getCreateHospitalRecordButton()
    {
        return getContainerHospitalRecordList().getButton("create");
    }

    public Button getEditHospitalRecordButton()
    {
        return getContainerHospitalRecordList().getButton("update");
    }

    public Button getDeleteHospitalButton()
    {
        return getContainerHospitalRecordList().getButton("delete");
    }

    public Button getMedicalHistoryButton()
    {
        return getContainerPatientList().getButton("medicalHistory");
    }

    public Button getDischargeButton()
    {
        return getContainerPatientList().getButton("discharge");
    }
}
