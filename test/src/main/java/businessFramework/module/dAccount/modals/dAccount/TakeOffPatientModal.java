package businessFramework.module.dAccount.modals.dAccount;

import businessFramework.entities.dAccount.TakeOffPatientData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class TakeOffPatientModal implements Values
{
    private TakeOffPatientHelper helper;

    public TakeOffPatientModal()
    {
        this.helper = new TakeOffPatientHelper();
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
    public void setValuesToFields(TakeOffPatientData data){
        helper.getReasonField().setValue(data.getReason());
        helper.getUnregDateField().setValue(data.getUnregDate());
    }
}
