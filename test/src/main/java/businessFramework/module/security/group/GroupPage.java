package businessFramework.module.security.group;

import businessFramework.entities.security.SecData;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

import java.util.HashMap;
import java.util.Map;

/*
 /* @author enuzhdina 
 /* @since 12.01.2016
 */
public class GroupPage implements GroupValues {
    private Page page = Page.getInstance();
    private Container container = page.getContainer(container_id);

    public void createGroup(SecData data){
        container.getButton(CREATE_BUTTON).click();
        page.assertModalPresentOnPage(true);
        page.getModal().getForm().getClassifier(org_id).setValue(data.getOrganization());
        page.getModal().getForm().getInputText(name_id).setValue(data.getGroupName());
        page.getModal().getButton(N2O_CONFIRM_BUTTON).click();
        container.getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteGroup(SecData data) {
        searchGroup(data);
        for (int i = 0; i < container.getTable().getCountRowsInTable(true); i++) {
            container.getButton(DELETE_BUTTON).click();
            page.getDialog().clickYes();
            container.getTable().assertThatCountOfRowsIs(0);
        }
    }

    public void searchGroup(SecData data){
        container.showFilter();
        container.getFilter().getClassifier(org_id).setValue(data.getOrganization());
        container.getFilter().getInputText(name_id).setValue(data.getGroupName());
        container.getFilter().clickFindButton();

        container.getTable().assertThatCountOfRowsIs(1);
        container.getTable().assertThatRowColumnsIntersectionValueContains(0, getTableColumns(data));
    }

    private Map<String, String> getTableColumns(SecData data){
        Map<String, String> result = new HashMap<>();
        result.put(name_column, data.getGroupName());
        result.put(org_column, data.getOrganization());
        return result;
    }

}
