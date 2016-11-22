package businessFramework.module.stocks.modals.bankDetails;

import businessFramework.entities.stocks.BankDetailsData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 31.07.2015.
 */
public class BankDetailsModal implements Values {
    private BankDetailsHelper bankDetailsHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public BankDetailsModal() {
        this.bankDetailsHelper = new BankDetailsHelper();
    }


    public void clickConfirmButton() {
        Button button = bankDetailsHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void fillForm(BankDetailsData data) {
        bankDetailsHelper.getCheckingAccount().setValue(data.getCheckingAccount());
        bankDetailsHelper.getName().setValue(data.getName());
        bankDetailsHelper.getOpenDate().setValue(data.getOpenDate());
        bankDetailsHelper.getCloseDate().setValue(data.getCloseDate());

    }

    public void clickBank() {
        bankDetailsHelper.getBank().findModalButtonClick();
    }


}
