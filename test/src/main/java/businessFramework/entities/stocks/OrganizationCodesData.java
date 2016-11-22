package businessFramework.entities.stocks;

/**
 * Created by bulat.garipov on 20.12.2015.
 */
public class OrganizationCodesData
{
    private String contextName; // Название контекста
    private String orgCodeType;
    private String orgCode;
    private String orgCodeWrong;
    private String orgCodeIssueDate;

    public String getContextName()
    {
        return contextName;
    }

    public void setContextName(String contextName)
    {
        this.contextName = contextName;
    }

    public String getOrgCodeType()
    {
        return orgCodeType;
    }

    public void setOrgCodeType(String orgCodeType)
    {
        this.orgCodeType = orgCodeType;
    }

    public String getOrgCode()
    {
        return orgCode;
    }

    public void setOrgCode(String orgCode)
    {
        this.orgCode = orgCode;
    }

    public String getOrgCodeIssueDate()
    {
        return orgCodeIssueDate;
    }

    public void setOrgCodeIssueDate(String orgCodeIssueDate)
    {
        this.orgCodeIssueDate = orgCodeIssueDate;
    }

    public String getOrgCodeWrong()
    {
        return orgCodeWrong;
    }

    public void setOrgCodeWrong(String orgCodeWrong)
    {
        this.orgCodeWrong = orgCodeWrong;
    }
}
