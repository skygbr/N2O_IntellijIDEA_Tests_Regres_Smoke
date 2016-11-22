package businessFramework.module.stocks.pages.mainInformation;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by aisaev on 03.08.2015.
 */
public class MainInformationHelper extends Page implements Values {
    public MainInformationHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainer() {
        return getRegion(SINGLE).getContainer("basicInformation");
    }

    public Button getConfirmButton() {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }


    public InputText getCode() {
        return this.getContainer().getForm().getInputText("code");
    }
    public InputText getFullName() {
        return this.getContainer().getForm().getInputText("fullName");
    }
    public InputText getShortName() {
        return this.getContainer().getForm().getInputText("shortName");
    }
    public InputText getRegDate() {
        return this.getContainer().getForm().getInputText("regDate");
    }

}
