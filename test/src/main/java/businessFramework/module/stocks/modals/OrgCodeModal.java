package businessFramework.module.stocks.modals;

import businessFramework.entities.stocks.OrganizationCodesData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * @author lgalimova
 * @since 07.07.2015
 */
public class OrgCodeModal implements Values
{
    private OrgCodeHelper orgCodeHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public OrgCodeModal()
    {
        this.orgCodeHelper = new OrgCodeHelper();
    }

    /**
     * Заполнение кода организации
     */
    public void fillFormWrong(OrganizationCodesData data)
    {
        orgCodeHelper.getCodeType().setValue(data.getOrgCodeType());
        orgCodeHelper.getCode().setValue(data.getOrgCodeWrong());
        orgCodeHelper.getIssueDate().setValue(data.getOrgCodeIssueDate());
        orgCodeHelper.getCode().getValidations().assertErrorValidation(true);
    }

    /**
     * Заполнение кода организации
     */
    public void fillForm(OrganizationCodesData data)
    {
        orgCodeHelper.getCodeType().setValue(data.getOrgCodeType());
        orgCodeHelper.getCode().setValue(data.getOrgCode());
        orgCodeHelper.getIssueDate().setValue(data.getOrgCodeIssueDate());
        orgCodeHelper.getCode().getValidations().assertErrorValidation(false);
    }

    public void clickConfirmButton()
    {
        Button button = orgCodeHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }
}
