package businessFramework.module.stocks.modals.organization;

import businessFramework.entities.stocks.OrganizationData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationModal  implements Values {

    private OrganizationHelper organizationHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public OrganizationModal() {
        this.organizationHelper=new OrganizationHelper();
    }

    public OrganizationModal(OrganizationHelper organizationHelper) {
        this.organizationHelper = organizationHelper;
    }

    public void fillForm(OrganizationData data)
    {

        organizationHelper.getFullName().setValue(data.getFullName());
        organizationHelper.getShortName().setValue(data.getShortName());
        organizationHelper.getCode().setValue(data.getCode());
        organizationHelper.getParentOrg().setValue(data.getParentOrg());
        organizationHelper.getRegDate().setValue(data.getRegDate());
    }

    public void clickConfirmButton()
    {
        Button button = organizationHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

}
