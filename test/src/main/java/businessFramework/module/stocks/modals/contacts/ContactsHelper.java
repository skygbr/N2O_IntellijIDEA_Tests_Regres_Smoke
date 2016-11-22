package businessFramework.module.stocks.modals.contacts;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactsHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public ContactsHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public InputText getValue() {
        return this.getContainer().getForm().getInputText("value");
    }

    public InputText getNote() {
        return this.getContainer().getForm().getInputText("note");
    }

    public Classifier getContactType() {
        return this.getContainer().getForm().getClassifier("contactType");
    }

    public InputCheckBox getIsMain() {
        return this.getContainer().getForm().getInputCheckBox("isMain");
    }

    public Button getConfirmButton() {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
