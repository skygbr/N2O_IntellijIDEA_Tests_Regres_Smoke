package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountFrcData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class DAccountFrcRecordModal implements Values
{
    private DAccountFrcRecordHelper helper;

    public DAccountFrcRecordModal()
    {
        this.helper = new DAccountFrcRecordHelper();
    }

    public void clickConfirm()
    {
        Button button = helper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickCancel()
    {
        Button button = helper.getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Устанавливает значения в поля
     */
    public void setValuesToFields(DAccountFrcData data){
        helper.getFrcKindField().setValue(data.getFrcKind());
        helper.getOrderNumberField().setValue(data.getOrderNumber());
        helper.getOrderDtField().setValue(data.getOrderDt());
        helper.getCloseDtField().setValue(data.getCloseDt());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountFrcData data){
        helper.getFrcKindField().assertValue_equals(data.getFrcKind());
        helper.getOrderNumberField().assertValue(data.getOrderNumber());
        helper.getOrderDtField().assertValue_equals(data.getOrderDt());
        helper.getCloseDtField().assertValue_equals(data.getCloseDt());
    }
}
