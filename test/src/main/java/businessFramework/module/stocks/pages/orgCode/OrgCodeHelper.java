package businessFramework.module.stocks.pages.orgCode;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrgCodeHelper extends Page implements Values {
    public OrgCodeHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainer() {
        return getRegion(SINGLE).getContainer("organizationCodes");
    }

    public Button getDeleteButton() {
        return getContainer().getButton(DELETE_BUTTON);
    }

    public Button getCreateButton() {
        return getContainer().getButton(CREATE_BUTTON);
    }

    public Button getUpdateButton() {
        return getContainer().getButton(UPDATE_BUTTON);
    }
}
