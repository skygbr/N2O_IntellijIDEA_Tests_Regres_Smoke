package businessFramework.module.stocks.pages.orgCode;

import businessFramework.entities.stocks.OrganizationCodesData;
import businessFramework.module.Values;
import businessFramework.module.stocks.modals.OrgCodeModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aisaev on 03.08.2015.
 */
public class OrgCodeContainer extends OrgCodeHelper implements Values {

    public OrgCodeContainer(ApplicationManager app) {
        super(app);
    }

    public OrgCodeModal getOrgCodeModal()
    {
        return new OrgCodeModal();
    }

    public void clickCreateOrgCodeButton()
    {
        Button create = getCreateButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Код учреждения");
    }

    public void deleteOrgCode(OrganizationCodesData data)
    {
        Table table = this.getContainer().getTable();
        Map<String, String> map = new HashMap<>();
        map.put("Значение", data.getOrgCode());
        map.put("Тип кода", data.getOrgCodeType());
        try
        {
            table.chooseRowBySeveralColumnValues(map);
        }
        catch (AssertionError e)
        {
            return;
        }
        this.clickDeleteOrgCodeButton();
    }

    public void clickDeleteOrgCodeButton()
    {
        Button delete = getDeleteButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }
}
