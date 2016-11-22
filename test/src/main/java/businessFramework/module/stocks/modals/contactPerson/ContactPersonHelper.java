package businessFramework.module.stocks.modals.contactPerson;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactPersonHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public ContactPersonHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Classifier getType() {
        return this.getContainer().getForm().getClassifier("type");
    }

    public Classifier getEmployee() {
        return this.getContainer().getForm().getClassifier("employee");
    }

    public Classifier getDepartment() {
        return this.getContainer().getForm().getClassifier("dep");
    }

    public InputText getSurname() {
        return this.getContainer().getForm().getInputText("surname");
    }

    public InputText getName() {
        return this.getContainer().getForm().getInputText("name");
    }

    public InputText getPatrName() {
        return this.getContainer().getForm().getInputText("patrName");
    }

    public InputText getPositionName() {
        return this.getContainer().getForm().getInputText("positionName");
    }

    public InputDate getStartDate() {
        return this.getContainer().getForm().getInputDate("startDate");
    }

    public Classifier getGender() {
        return this.getContainer().getForm().getClassifier("gender");
    }

    public InputText getTelLandline() {
        return this.getContainer().getForm().getInputText("telLandline");
    }

    public InputText getTelMobile() {
        return this.getContainer().getForm().getInputText("telMobile");
    }

    public InputText getFax() {
        return this.getContainer().getForm().getInputText("fax");
    }

    public InputText getEmail() {
        return this.getContainer().getForm().getInputText("email");
    }

    public InputText getICQ() {
        return this.getContainer().getForm().getInputText("icq");
    }

    public InputText getSkype() {
        return this.getContainer().getForm().getInputText("skype");
    }

    public Button getConfirmButton() {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
