package businessFramework.module.stocks.modals.bankDetails;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by aisaev on 31.07.2015.
 */
public class BankDetailsHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public BankDetailsHelper()
    {
        this.container = "main";
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public InputText getCheckingAccount()
    {
        return this.getContainer().getForm().getInputText("checkingAccount");
    }

    public InputText getName()
    {
        return this.getContainer().getForm().getInputText("name");
    }

    public InputText getOpenDate()
    {
        return this.getContainer().getForm().getInputText("openDate");
    }

    public InputText getCloseDate()
    {
        return this.getContainer().getForm().getInputText("closeDate");
    }

    public Classifier getBank()
    {
        return this.getContainer().getForm().getClassifier("bank");
    }

    public Button getConfirmButton()
    {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
