package businessFramework.module.stocks.pages;

import businessFramework.module.Values;
import businessFramework.module.stocks.pages.bankDetails.BankDetailsContainer;
import businessFramework.module.stocks.pages.contacts.ContactsContainer;
import businessFramework.module.stocks.pages.mainInformation.MainInformationContainer;
import businessFramework.module.stocks.pages.orgCode.OrgCodeContainer;
import businessFramework.module.stocks.pages.organizationAccount.OrganizationAccountContainer;
import businessFramework.module.stocks.pages.contactPerson.ContactPersonContainer;
import net.framework.autotesting.ApplicationManager;


/**
 * @author lgalimova
 * @since 07.07.2015
 */
public class AdministrDataPage extends AdministrDataHelper implements Values
{
    public AdministrDataPage(ApplicationManager app)
    {
        super(app);
    }

    public BankDetailsContainer getBankDetailsContainer()
    {
        return new BankDetailsContainer(app);
    }
    public OrganizationAccountContainer getOrganizationAccountContainer() {
        return new OrganizationAccountContainer(app);
    }
    public MainInformationContainer getMainInformationContainer() {
        return new MainInformationContainer(app);
    }

    public OrgCodeContainer getOrgCodeContainer() {
        return new OrgCodeContainer(app);
    }

    public ContactsContainer getContactsContainer() {
        return new ContactsContainer(app);
    }

    public ContactPersonContainer getContactPersonContainer() {
        return new ContactPersonContainer(app);
    }
}
