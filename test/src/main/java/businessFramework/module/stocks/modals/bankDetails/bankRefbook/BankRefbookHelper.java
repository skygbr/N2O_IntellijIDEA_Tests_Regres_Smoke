package businessFramework.module.stocks.modals.bankDetails.bankRefbook;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by aisaev on 31.07.2015.
 */
public class BankRefbookHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public BankRefbookHelper() {
        this.container = "main";
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public InputText getName() {
        return this.getContainer().getFilter().getInputText("name");
    }

    public Classifier getBank() {
        return this.getContainer().getForm().getClassifier("bank");
    }

    public Button getConfirmButton() {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
