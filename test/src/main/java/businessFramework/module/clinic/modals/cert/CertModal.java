package businessFramework.module.clinic.modals.cert;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 18.02.2016.
 */
public class CertModal extends CertHelper{

    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValues(){
        getRemark().setValue("autotest_acceptance");
    }
}
