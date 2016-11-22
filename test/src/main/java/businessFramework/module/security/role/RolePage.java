package businessFramework.module.security.role;

import businessFramework.entities.security.SecData;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/*
 /* @author enuzhdina 
 /* @since 11.01.2016
 */
public class RolePage implements RoleValues {
    private Page page = Page.getInstance();
    private Container container = page.getContainer(container_id);

    public void createRole(SecData data){
        container.getButton(CREATE_BUTTON).click();
        page.assertModalPresentOnPage(true);
        page.getModal().getForm().getRadio(type_id).radioButtonPress(data.getRoleType());
        page.getModal().getForm().getGroupMultiClassifier(template_id).setValue(data.getTemplateName());
        page.getModal().getForm().getInputText(name_id).setValue(data.getRoleName());
        page.getModal().getButton(N2O_CONFIRM_BUTTON).click();
        container.getTable().getAlerts().assertSuccessAlertIsPresent();
    }


    public void deleteRole(SecData data) {
        searchRole(data);
        for (int i = 0; i < container.getTable().getCountRowsInTable(true); i++) {
            container.getButton(DELETE_BUTTON).click();
            page.getDialog().clickYes();
        }
        while (container.getTable().getCountRowsInTable(true)>0){
            container.getTable().chooseRowInTable(0);
            container.getButton(DELETE_BUTTON).click();
            page.getDialog().clickYes();
        }
    }

    public void searchRole(SecData data){
        container.showFilter();
        container.getFilter().getClassifier(org_id).setValue(data.getOrganization());
        container.getFilter().getInputText(name_id).setValue(data.getRoleName());
        container.getFilter().clickFindButton();
        container.getTable().assertThatRowColumnsIntersectionValueContains(0, getTableColumns(data));
    }

        private Map<String, String> getTableColumns(SecData data){
        Map<String, String> result = new HashMap<>();
        result.put(name_column, data.getRoleName());
        return result;
    }
}
