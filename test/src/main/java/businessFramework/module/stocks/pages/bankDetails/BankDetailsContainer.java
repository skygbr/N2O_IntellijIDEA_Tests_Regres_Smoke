package businessFramework.module.stocks.pages.bankDetails;

import businessFramework.entities.stocks.BankDetailsData;
import businessFramework.module.Values;
import businessFramework.module.stocks.modals.bankDetails.BankDetailsModal;
import businessFramework.module.stocks.modals.bankDetails.bankRefbook.BankRefbookModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aisaev on 03.08.2015.
 */
public class BankDetailsContainer extends BankDetailsHelper implements Values
{
    public BankDetailsContainer(ApplicationManager app)
    {
        super(app);
    }

    public BankRefbookModal getBankRefbookModal() {
        return new BankRefbookModal(app);
    }

    public void clickCreateBankDetailsButton() {
        Button create = getCreateBankDetailsButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Банковские реквизиты");
    }

    public BankDetailsModal getBankDetailsModal() {
        return new BankDetailsModal();
    }

    public void findBankDetail(BankDetailsData bankDetailsData) {

        Table table = this.getContainerBankDetails().getTable();
        Map<String, String> map = new HashMap<>();
        map.put("Расчетный счет", bankDetailsData.getCheckingAccount());
        table.chooseRowBySeveralColumnValues(map);
    }

    public void deleteBankDetailIfExist(BankDetailsData bankDetailsData) {

        Table table = this.getContainerBankDetails().getTable();
        Map<String, String> map = new HashMap();
        map.put("Расчетный счет", bankDetailsData.getCheckingAccount());
        try {
            table.chooseRowBySeveralColumnValues(map);
        } catch (AssertionError e) {
            return;
        }
        this.clickDeleteBankDetailButton();
    }

    public void clickDeleteBankDetailButton() {
        Button delete = getDeleteBankDetailButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickUpdateBankDetailButton() {
        Button create = getUpdateBankDetailButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Банковские реквизиты");
    }

}
