package businessFramework.module.hospital.modals.sicklist;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.SickListIssuedAnotherClinicData;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 29.10.2015
 */
public class SickListIssuedAnotherClinicModal {
    private Page page = Page.getInstance();

    private SickListIssuedAnotherClinicHelper helper;

    public SickListIssuedAnotherClinicModal() {
        this.helper = new SickListIssuedAnotherClinicHelper();
    }

    public void clickConfirmButton()
    {
        Button button = helper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void assertForm(SickListIssuedAnotherClinicData data)
    {
        helper.getIssueDate().assertValue_equals(data.getIssueDate());
        helper.getNumber().assertValue(data.getNumber());
    }

    public void fillForm(SickListIssuedAnotherClinicData data)
    {
        helper.getIssueDate().setValue(data.getIssueDate());
        helper.getNumber().setValue(data.getNumber());
    }

    public void clickSave()
    {
        Button button = helper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }
}
