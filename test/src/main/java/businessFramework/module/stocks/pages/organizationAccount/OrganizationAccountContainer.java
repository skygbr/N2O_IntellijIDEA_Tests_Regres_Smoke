package businessFramework.module.stocks.pages.organizationAccount;

import businessFramework.entities.stocks.OrganizationAccountData;
import businessFramework.module.Values;
import businessFramework.module.stocks.modals.organizationAccount.OrganizationAccountModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationAccountContainer extends OrganizationAccountHelper implements Values {
    public OrganizationAccountContainer(ApplicationManager app) {
        super(app);
    }

    public void deleteOrganizationAccountIfExist(OrganizationAccountData data) {
        Table table = this.getContainerOrganizationAccount().getTable();
        Map<String, String> map = new HashMap<>();
        map.put("Лицевой счет", data.getOrganizationAccount());
        try {
            table.chooseRowBySeveralColumnValues(map);
        } catch (AssertionError e) {
            return;
        }
        this.clickDeleteOrganizationAccountButton();
    }

    public void clickDeleteOrganizationAccountButton() {
        Button delete = getDeleteOrganizationAccountButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickCreateOrganizationAccountButton() {
        Button create = getCreateOrganizationAccountButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Лицевые счета");
    }

    public OrganizationAccountModal getOrganizationAccountModal() {
        return new OrganizationAccountModal();
    }

    public void clickUpdateOrganizationAccountButton() {
        Button create = getUpdateOrganizationAccountButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Лицевые счета");
    }

    public void clickConfirmButton() {
        Button confirm = getCreateOrganizationAccountButton();
        confirm.assertIsEnabled();
        confirm.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Лицевые счета");
    }

    public void findOrganizationAccount(OrganizationAccountData organizationAccountData) {
        Table table = this.getContainerOrganizationAccount().getTable();
        Map<String, String> map = new HashMap();
        map.put("Лицевой счет", organizationAccountData.getOrganizationAccount());
        table.chooseRowBySeveralColumnValues(map);
    }


}
