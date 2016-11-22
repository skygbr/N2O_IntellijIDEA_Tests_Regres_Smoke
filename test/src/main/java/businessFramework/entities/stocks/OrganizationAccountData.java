package businessFramework.entities.stocks;

/**
 * Created by aisaev on 04.08.2015.
 */
public class OrganizationAccountData {

    private String organizationAccount;
    private String name;
    private String openDate;
    private String closeDate;
    private String checkingAccount;

    public String getOrganizationAccount() {
        return organizationAccount;
    }

    public void setOrganizationAccount(String organizationAccount) {
        this.organizationAccount = organizationAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}
