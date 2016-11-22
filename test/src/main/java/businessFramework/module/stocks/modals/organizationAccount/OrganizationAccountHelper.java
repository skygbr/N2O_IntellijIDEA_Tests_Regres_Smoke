package businessFramework.module.stocks.modals.organizationAccount;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationAccountHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public OrganizationAccountHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public InputText getName() {
        return this.getContainer().getForm().getInputText("name");
    }

    public InputText getOrganizationAccount() {
        return this.getContainer().getForm().getInputText("organizationAccount");
    }

    public Classifier getBankDetail() {
        return this.getContainer().getForm().getClassifier("bankDetail");
    }

    public InputDate getOpenDate() {
        return this.getContainer().getForm().getInputDate("openDate");
    }

    public InputDate getCloseDate() {
        return this.getContainer().getForm().getInputDate("closeDate");
    }

    public Button getConfirmButton() {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
