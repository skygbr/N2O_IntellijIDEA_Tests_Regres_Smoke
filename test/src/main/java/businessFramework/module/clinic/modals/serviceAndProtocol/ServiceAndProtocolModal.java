package businessFramework.module.clinic.modals.serviceAndProtocol;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 17.02.2016.
 */
public class ServiceAndProtocolModal extends ServiceAndProtocolHelper{

    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getIsUrgent().check(true);
        getService().setValue("Осмотр");
        getFunding().setValue("ОМС");
    }
}
