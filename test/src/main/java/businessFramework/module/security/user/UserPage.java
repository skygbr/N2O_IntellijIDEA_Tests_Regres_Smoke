package businessFramework.module.security.user;

import businessFramework.entities.security.SecData;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/*
 /* @author enuzhdina 
 /* @since 12.01.2016
 */
public class UserPage implements UserValues {
    private KeyPage keyPage;
    private Page page = Page.getInstance();
    private Container container = page.getContainer(container_id);

    public void searchUser(SecData data) {
        container.getFilter().getInputText(login_id).setValue(data.getLogin());
        container.getFilter().getClassifier(org_id).setValue(data.getOrganization());
        container.getFilter().clickFindButton();
        container.getTable().assertThatCountOfRowsIs(1);
    }

    public void openAccessKey() {
        container.getButton("accessSettings").click();
    }

    public KeyPage getKeyPage() {
        if(keyPage == null)
            keyPage = new KeyPage();
        return keyPage;
    }
}
