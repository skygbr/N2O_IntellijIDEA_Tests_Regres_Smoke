package businessFramework.module.stocks.pages.organizationAccount;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationAccountHelper extends Page implements Values {
    public OrganizationAccountHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerOrganizationAccount() {
        return getRegion(SINGLE).getContainer("organizationAccount");
    }

    public Button getDeleteOrganizationAccountButton() {
        return getContainerOrganizationAccount().getButton(DELETE_BUTTON);
    }

    public Button getCreateOrganizationAccountButton() {
        return getContainerOrganizationAccount().getButton(CREATE_BUTTON);
    }

    public Button getUpdateOrganizationAccountButton() {
        return getContainerOrganizationAccount().getButton(UPDATE_BUTTON);
    }
}
