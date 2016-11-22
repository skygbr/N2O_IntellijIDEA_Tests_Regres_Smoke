package businessFramework.module.stocks.modals.bankDetails.bankRefbook;

import businessFramework.entities.stocks.BankDetailsData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 31.07.2015.
 */
public class BankRefbookModal extends Page implements Values {
    private BankRefbookHelper bankRefbookHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public BankRefbookModal(ApplicationManager app) {
        super(app);
        this.bankRefbookHelper = new BankRefbookHelper();
    }

    public void clickConfirmButton() {
        Button button = bankRefbookHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void fillForm(BankDetailsData data) {
        bankRefbookHelper.getName().setValue(data.getCheckingAccount());
    }

    public Container getContainer() {
        return bankRefbookHelper.getContainer();
    }

    public void chooseFirstRowInTable() {
        getContainer().getTable().chooseRowInTable(0);
    }

    public Button getConfirmButton() {
        return getButton(CONFIRM_BUTTON);
    }

    public void clickChooseButton() {
        getConfirmButton().click();
    }
}
