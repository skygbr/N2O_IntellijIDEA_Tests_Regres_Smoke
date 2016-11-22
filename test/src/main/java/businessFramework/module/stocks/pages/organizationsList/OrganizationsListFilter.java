package businessFramework.module.stocks.pages.organizationsList;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.InputText;

public class OrganizationsListFilter extends OrganizationsListHelper
{
    public OrganizationsListFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputText getFullName()
    {
        return this.getOrganizationsListContainer().getFilter().getInputText("fullName");
    }


    public InputText getShortName()
    {
        return this.getOrganizationsListContainer().getFilter().getInputText("shortName");
    }

    public InputText getCode()
    {
        return this.getOrganizationsListContainer().getFilter().getInputText("code");
    }
}
