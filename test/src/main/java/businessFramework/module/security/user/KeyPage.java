package businessFramework.module.security.user;

import businessFramework.entities.security.SecData;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/*
 /* @author enuzhdina 
 /* @since 12.01.2016
 */
public class KeyPage implements KeyValues {
    private Page page = Page.getInstance();
    private Container container = page.getContainer(container_id);

    public void createKey(SecData data){
        container.getButton(CREATE_BUTTON).click();
        page.getModal().getForm().getRadio(type_id).radioButtonPress(data.getKeyType());
        page.getModal().getForm().getClassifier(org_id).setValue(data.getOrganization());
        page.getModal().getForm().getMultiClassifier(roles_id).setValue(data.getRoleName());
        page.getModal().getForm().getMultiClassifier(groups_id).setValue(data.getGroupName());
        page.getModal().getForm().getInputText(name_id).setValue(data.getKeyName());
        page.getModal().getButton(N2O_CONFIRM_BUTTON).click();
        container.getTable().getAlerts().assertSuccessAlertIsPresent();
    }
}
