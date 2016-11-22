package businessFramework.module.stomatology.modals.stomReceipt;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 22.07.2016.
 */
public class StomReceiptModal extends StomReceiptHelper {
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }

    public void setValue(){
        getSeries().setValue("123");
        getNum().setValue("123");
        getFormType().setValue(1);
        getInn().setValue(1);
        getDosage().setValue("1");
        getUseMethod().setValue("Внутрь");
        getAdvice().setValue("autotest_acceptance");
    }
    public void updateValue(){
        getValidity().setValue("1 месяц");
        getSeries().setValue("1234");
        getNum().setValue("1234");
        getInn().setValue(3);
        getDosage().setValue("5");
        getUseMethod().setValue("Наружно");
    }
}
