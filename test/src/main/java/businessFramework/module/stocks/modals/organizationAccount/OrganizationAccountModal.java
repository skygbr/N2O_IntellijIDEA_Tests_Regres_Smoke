package businessFramework.module.stocks.modals.organizationAccount;

import businessFramework.entities.stocks.OrganizationAccountData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationAccountModal implements Values {

    private OrganizationAccountHelper organizationAccountHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public OrganizationAccountModal() {
        this.organizationAccountHelper = new OrganizationAccountHelper();
    }

    public OrganizationAccountModal(OrganizationAccountHelper organizationAccountHelper) {
        this.organizationAccountHelper = organizationAccountHelper;
    }

    public void fillForm(OrganizationAccountData data) {
        organizationAccountHelper.getName().setValue(data.getName());
        organizationAccountHelper.getOrganizationAccount().setValue(data.getOrganizationAccount());
        organizationAccountHelper.getOpenDate().setValue(data.getOpenDate());
        organizationAccountHelper.getCloseDate().setValue(data.getCloseDate());
        organizationAccountHelper.getBankDetail().setValue(data.getCheckingAccount());
    }

    public void clickConfirmButton() {
        Button button = organizationAccountHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

}
