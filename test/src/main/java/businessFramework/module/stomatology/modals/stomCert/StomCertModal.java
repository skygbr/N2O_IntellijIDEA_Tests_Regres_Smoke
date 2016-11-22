package businessFramework.module.stomatology.modals.stomCert;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 22.07.2016.
 */
public class StomCertModal extends StomCertHelper{
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
