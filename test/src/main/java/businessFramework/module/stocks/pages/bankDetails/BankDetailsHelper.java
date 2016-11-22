package businessFramework.module.stocks.pages.bankDetails;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 *Created by aisaev on 03.08.2015.
 */
public class BankDetailsHelper extends Page implements Values
{
    public BankDetailsHelper(ApplicationManager app)
    {
        super(app);
    }
    public Container getContainerBankDetails()
    {
        return getRegion(SINGLE).getContainer("bankDetails");
    }
    public Button getCreateBankDetailsButton()
    {
        return getContainerBankDetails().getButton(CREATE_BUTTON);
    }
    public Button getDeleteBankDetailButton()
    {
        return getContainerBankDetails().getButton(DELETE_BUTTON);
    }
    public Button getUpdateBankDetailButton()
    {
        return getContainerBankDetails().getButton(UPDATE_BUTTON);
    }
}
