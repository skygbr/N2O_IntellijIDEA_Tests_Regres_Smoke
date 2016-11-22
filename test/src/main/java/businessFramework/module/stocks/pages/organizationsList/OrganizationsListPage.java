package businessFramework.module.stocks.pages.organizationsList;

import businessFramework.entities.stocks.OrganizationData;
import businessFramework.module.stocks.modals.organization.OrganizationModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationsListPage extends OrganizationsListHelper {

    public OrganizationsListPage(ApplicationManager app) {
        super(app);
    }

    public OrganizationModal getOrgModal()
    {
        return new OrganizationModal();
    }

    public OrganizationsListFilter getFilter()
    {
        return new OrganizationsListFilter(app);
    }


    public void deleteOrganizationByFilter(OrganizationData organizationData) {

        findOrganization(organizationData);
        Table table = this.getOrganizationsListContainer().getTable();
        int result = table.getCountRowsInTable(true);

        try {
            assertThat("Get organization by filter", result, is(1));
        } catch (AssertionError e) {
            return;
        }
        table.chooseRowInTable(0);
        this.clickDeleteOrganizationButton();

    }

    public void findOrganization(OrganizationData organizationData) {
        getFilter().getFullName().setValue(organizationData.getFullName());
        getFilter().getShortName().setValue(organizationData.getShortName());
        getFilter().getCode().setValue(organizationData.getCode());
        this.getOrganizationsListContainer().getFilter().clickFindButton();
    }
    public void clickDeleteOrganizationButton()
    {
        Button delete = getDeleteButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickDeleteOrgButton()
    {
        Button delete = getDeleteButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }
}
