package businessFramework.module.stocks.pages.organizationsList;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationsListHelper extends Page implements Values {

    public OrganizationsListHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    public Container getOrganizationsListContainer()
    {
        return getContainer("list");
    }

    public Button getCreateOrgButton()
    {
        return getOrganizationsListContainer().getButton(CREATE_BUTTON);
    }

    public Button getDeleteButton()
    {
        return getOrganizationsListContainer().getButton(DELETE_BUTTON);
    }

    public Button getUpdateOrgButton()
    {
        return getOrganizationsListContainer().getButton(UPDATE_BUTTON);
    }
}
