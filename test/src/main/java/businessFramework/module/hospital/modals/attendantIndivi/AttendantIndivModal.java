package businessFramework.module.hospital.modals.attendantIndivi;


import businessFramework.entities.hospital.HospitalData;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class AttendantIndivModal implements AttendantIndivValues
{
    private Page page = Page.getInstance();
    private AttendantIndivHelper attendantIndivHelper;

    public AttendantIndivModal()
    {
        this.attendantIndivHelper = new AttendantIndivHelper();
    }

    public void clickConfirmButton()
    {
        Button confirm = attendantIndivHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
        page.assertModalPresentOnPage(false);
    }

    public void searchIndiv(HospitalData hospitalData)
    {
        attendantIndivHelper.getIndiv().setValue(hospitalData.getAttendantSNILS(),hospitalData.getAttendantIndivFullFIO());
    }

    public void fillForm(HospitalData hospitalData)
    {
        this.searchIndiv(hospitalData);
        attendantIndivHelper.getRelationSide().setValue(0);
        this.clickConfirmButton();
    }
}
