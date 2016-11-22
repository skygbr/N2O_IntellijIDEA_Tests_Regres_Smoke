package businessFramework.module.stocks.pages.contacts;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactsHelper extends Page implements Values {
    public ContactsHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerContacts() {
        return getRegion(SINGLE).getContainer("contacts");
    }

    public Button getDeleteContactsButton() {
        return getContainerContacts().getButton(DELETE_BUTTON);
    }

    public Button getCreateContactsButton() {
        return getContainerContacts().getButton(CREATE_BUTTON);
    }

    public Button getUpdateContactsButton() {
        return getContainerContacts().getButton(UPDATE_BUTTON);
    }
}
