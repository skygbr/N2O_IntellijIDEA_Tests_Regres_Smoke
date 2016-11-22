package businessFramework.module.security.template;

import businessFramework.entities.security.SecData;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

import java.util.HashMap;
import java.util.Map;

/*
 /* @author enuzhdina 
 /* @since 17.12.2015
 */
public class TemplatePage implements TemplateValues {
    private Page page = Page.getInstance();
    private Container container = page.getContainer(container_id);

    public void createTemplate(SecData data) {
        container.getButton(CREATE_BUTTON).click();
        page.assertModalPresentOnPage(true);
        page.getModal().getForm().getInputText(code_id).setValue(data.getTemplateCode());
        page.getModal().getForm().getInputText(name_id).setValue(data.getTemplateName());
        page.getModal().getButton(N2O_CONFIRM_BUTTON).click();
        container.getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteTemplate(SecData data) {
        searchTemplate(data);
        for (int i = 0; i < container.getTable().getCountRowsInTable(true); i++) {
            container.getButton(DELETE_BUTTON).click();
            page.getDialog().clickYes();
            container.getTable().assertThatCountOfRowsIs(0);
        }
    }

    public void searchTemplate(SecData data) {
        container.showFilter();
        container.getFilter().getInputText(code_id).setValue(data.getTemplateCode());
        container.getFilter().getInputText(name_id).setValue(data.getTemplateName());
        container.getFilter().clickFindButton();
    }

    private Map<String, String> getTableColumns(SecData data) {
        Map<String, String> result = new HashMap<>();
        result.put(name_column, data.getTemplateName());
        result.put(code_column, data.getTemplateCode());
        result.put(type_column, data.getTemplateType());
        return result;
    }
}
