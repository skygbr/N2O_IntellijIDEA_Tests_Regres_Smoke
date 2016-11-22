package businessFramework.module.stocks.modals.contactPerson;

import businessFramework.entities.stocks.ContactPersonData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactPersonModal implements Values {

    private ContactPersonHelper contactPersonHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public ContactPersonModal() {
        this.contactPersonHelper = new ContactPersonHelper();
    }

    public ContactPersonModal(ContactPersonHelper ContactPersonHelper) {
        this.contactPersonHelper = ContactPersonHelper;
    }

    public void fillForm(ContactPersonData data) {
        contactPersonHelper.getName().setValue(data.getName());
        contactPersonHelper.getEmail().setValue(data.getEmail());
       //contactPersonHelper.getEmployee().setValue(data.getE);
        contactPersonHelper.getFax().setValue(data.getFax());
        contactPersonHelper.getGender().setValue(data.getGender());
        contactPersonHelper.getICQ().setValue(data.getIcq().toString());
        contactPersonHelper.getPatrName().setValue(data.getPatrName());
        contactPersonHelper.getSurname().setValue(data.getSurname());
        contactPersonHelper.getSkype().setValue(data.getSkype());
        contactPersonHelper.getTelLandline().setValue(data.getTelLandline());
        contactPersonHelper.getType().setValue(data.getType());
        contactPersonHelper.getPositionName().setValue(data.getPositionName());
    }

    public void clickConfirmButton() {
        Button button = contactPersonHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

}
