package businessFramework.module.stocks.modals.contacts;

import businessFramework.entities.stocks.*;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactsModal implements Values {

    private ContactsHelper contactsHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public ContactsModal() {
        this.contactsHelper = new ContactsHelper();
    }

    public ContactsModal(ContactsHelper ContactsHelper) {
        this.contactsHelper = ContactsHelper;
    }

    public void fillForm(ContactsData data) {
        contactsHelper.getValue().setValue(data.getValue());
        contactsHelper.getContactType().setValue(data.getContactType());
        contactsHelper.getNote().setValue(data.getNote());
//        contactsHelper.getIsMain().(data.getCloseDate());
//        contactsHelper.getBankDetail().setValue(data.getCheckingAccount());
    }

    public void clickConfirmButton() {
        Button button = contactsHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

}
