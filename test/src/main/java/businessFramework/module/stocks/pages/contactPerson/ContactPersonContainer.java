package businessFramework.module.stocks.pages.contactPerson;

import businessFramework.entities.stocks.ContactPersonData;
import businessFramework.module.Values;
import businessFramework.module.stocks.modals.contactPerson.ContactPersonModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactPersonContainer extends ContactPersonHelper implements Values {

   // private static final String CONTACTS="Контакты";

    public ContactPersonContainer(ApplicationManager app) {
        super(app);
    }

    public void deleteContactPersonIfExist(ContactPersonData data) {
        Table table = this.getContainerContactPerson().getTable();
        Map<String, String> map = new HashMap<>();
        map.put("Телефон", data.getTelLandline());
        map.put("ФИО", data.getSurname()+" "+data.getName()+" "+data.getPatrName());
        try {
            table.chooseRowBySeveralColumnValues(map);
        } catch (AssertionError e) {
            return;
        }
        this.clickDeleteContactPersonButton();
    }

    public void clickDeleteContactPersonButton() {
        Button delete = getDeleteContactPersonButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickCreateContactPersonButton() {
        Button create = getCreateContactPersonButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Персоналии");
    }

    public ContactPersonModal getContactPersonModal() {
        return new ContactPersonModal();
    }

    public void clickUpdateContactPersonButton() {
        Button create = getUpdateContactPersonButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Персоналии");
    }

    public void clickConfirmButton() {
        Button confirm = getCreateContactPersonButton();
        confirm.assertIsEnabled();
        confirm.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Персоналии");
    }

    public void findContactPerson(ContactPersonData data) {
        Table table = this.getContainerContactPerson().getTable();
        Map<String, String> map = new HashMap();
        map.put("Телефон", data.getTelLandline());
        map.put("ФИО", data.getSurname()+" "+data.getName()+" "+data.getPatrName());
        table.chooseRowBySeveralColumnValues(map);
    }


}
