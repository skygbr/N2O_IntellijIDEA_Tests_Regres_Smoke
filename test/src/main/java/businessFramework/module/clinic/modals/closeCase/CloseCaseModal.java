package businessFramework.module.clinic.modals.closeCase;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 18.02.2016.
 */
public class CloseCaseModal {
    private CloseCaseHelper closeCaseHelper;
    public CloseCaseModal(){
        closeCaseHelper = new CloseCaseHelper();
    }
    public void clickConfirm(){
        Button button = closeCaseHelper.getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = closeCaseHelper.getCancelButton();
        button.click();
    }
    public void setValue(){
        closeCaseHelper.getRepeatCount().setValue("Первично"); // TODO: 07.10.2016 Убрать после фикса бага  RMISDEV-4863
        closeCaseHelper.getStepResult().setValue(1);
        closeCaseHelper.getOutcome().setValue(0);
    }
}
