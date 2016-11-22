package businessFramework.module.stomatology.pages.stomService;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 25.07.2016.
 */
public class StomServicePage extends StomServiseHelper{
    public StomServicePage (ApplicationManager app){
        super(app);
    }
    public void clickConfirm(){
        Button button = getContainerServiceAndProtocol().getButton(N2O_CONFIRM_BUTTON);
        button.click();
    }
    public void clickCancel(){
        Button button = getContainerServiceAndProtocol().getButton(N2O_CANCEL_BUTTON);
        button.click();
    }
    public void editValue(){
        getIsUrgent().check(false);
        getQuantity().setValue("3");
        getFunding().setValue("ДМС");
    }
}
