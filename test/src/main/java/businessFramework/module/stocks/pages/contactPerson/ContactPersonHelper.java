package businessFramework.module.stocks.pages.contactPerson;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class ContactPersonHelper extends Page implements Values {
    public ContactPersonHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerContactPerson() {
        return getRegion(SINGLE).getContainer("contactPerson");
    }

    public Button getDeleteContactPersonButton() {
        return getContainerContactPerson().getButton(DELETE_BUTTON);
    }

    public Button getCreateContactPersonButton() {
        return getContainerContactPerson().getButton(CREATE_BUTTON);
    }

    public Button getUpdateContactPersonButton() {
        return getContainerContactPerson().getButton(UPDATE_BUTTON);
    }
}
