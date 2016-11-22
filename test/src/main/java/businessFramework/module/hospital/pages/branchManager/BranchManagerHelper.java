package businessFramework.module.hospital.pages.branchManager;


import businessFramework.module.Values;
import businessFramework.module.hospital.modals.assignDoctor.AssignDoctorModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class BranchManagerHelper extends Page implements Values
{
    public BranchManagerHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainerMdHistory()
    {
        return getRegion(SINGLE).getContainer("mdHistory");
    }

    public AssignDoctorModal getAssignDoctor()
    {
        return new AssignDoctorModal();
    }

    public Button getDepartmentInfoButton()
    {
        return getContainerMdHistory().getButton("departmentInfo");
    }

    public Button getDoctorWorkloadButton()
    {
        return getContainerMdHistory().getButton("doctorWorkload");
    }

    public Button getAssignDoctorButton()
    {
        return getContainerMdHistory().getButton("assignDoctor");
    }

    public Button getMedicalHistoryButton()
    {
        return getContainerMdHistory().getButton("medicalHistory");
    }

    public Button getChangeDiagnosisButton()
    {
        return getContainerMdHistory().getButton("changeDiagnosis");
    }

    public Button getCancelDischargeButton()
    {
        return getContainerMdHistory().getButton("reopen");
    }

    public Button getAddPhysicalButton()
    {
        return getContainerMdHistory().getButton("addPhysical");
    }

    public Button getCommissionReferralButton()
    {
        return getContainerMdHistory().getButton("create");
    }

}
