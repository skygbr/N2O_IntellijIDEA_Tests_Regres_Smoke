package businessFramework.module.stomatology.modals.closeCase;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 21.07.2016.
 */
public class StomCloseCaseModal extends StomCloseCaseHelper{

    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
      //  getRepeatCount().setValue("Первично"); // TODO: 07.10.2016 убрать после фикса бага  RMISDEV-4863
        getStepResult().setValue(1);
        getOutcome().setValue(0);
    }
}
