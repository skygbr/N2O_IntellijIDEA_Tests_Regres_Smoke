package businessFramework.module.stocks.pages.contacts;

import businessFramework.entities.stocks.*;
import businessFramework.module.Values;
import businessFramework.module.stocks.modals.contacts.ContactsModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactsContainer extends ContactsHelper implements Values {

    private static final String CONTACTS="Контакты";

    public ContactsContainer(ApplicationManager app) {
        super(app);
    }

    public void deleteContactsIfExist(ContactsData data) {
        Table table = this.getContainerContacts().getTable();
        Map<String, String> map = new HashMap<>();
        map.put(CONTACTS, data.getValue());
        try {
            table.chooseRowBySeveralColumnValues(map);
        } catch (AssertionError e) {
            return;
        }
        this.clickDeleteContactsButton();
    }

    public void clickDeleteContactsButton() {
        Button delete = getDeleteContactsButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickCreateContactsButton() {
        Button create = getCreateContactsButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains(CONTACTS);
    }

    public ContactsModal getContactsModal() {
        return new ContactsModal();
    }

    public void clickUpdateContactsButton() {
        Button create = getUpdateContactsButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains(CONTACTS);
    }

    public void clickConfirmButton() {
        Button confirm = getCreateContactsButton();
        confirm.assertIsEnabled();
        confirm.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains(CONTACTS);
    }

    public void findContacts(ContactsData contactsData) {
        Table table = this.getContainerContacts().getTable();
        Map<String, String> map = new HashMap();
        map.put("Значение", contactsData.getValue());
        table.chooseRowBySeveralColumnValues(map);
    }


}
