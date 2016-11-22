package businessFramework.module.stomatology.modals.stomService;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by elvira.ibragimova on 18.09.2016.
 */
public class StomServiceModal extends StomServiceHelper{
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getService().setValue("Прием");
        getQuantity().setValue("2");
        getFunding().setValue("ОМС");
    }
}
