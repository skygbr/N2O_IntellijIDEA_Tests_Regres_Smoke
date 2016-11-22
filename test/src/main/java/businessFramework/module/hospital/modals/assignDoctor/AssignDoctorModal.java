package businessFramework.module.hospital.modals.assignDoctor;


import businessFramework.entities.hospital.HospitalData;
import net.framework.autotesting.meta.components.Button;

public class AssignDoctorModal
{
    private AssignDoctorHelper assignDoctorHelper;

    public AssignDoctorModal()
    {
        this.assignDoctorHelper = new AssignDoctorHelper();
    }

    public AssignDoctorModal(String locator)
    {
        this.assignDoctorHelper = new AssignDoctorHelper(locator);
    }

    public void assignDoctor(HospitalData hospitalData)
    {
        assignDoctorHelper.getDoctor().setValue(hospitalData.getDoctor());
        this.clickConfirm();
    }

    public void clickConfirm()
    {
        Button button = assignDoctorHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }
}
