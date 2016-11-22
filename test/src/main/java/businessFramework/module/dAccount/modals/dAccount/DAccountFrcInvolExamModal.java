package businessFramework.module.dAccount.modals.dAccount;

import businessFramework.entities.dAccount.DAccountFrcInvolExamData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class DAccountFrcInvolExamModal implements Values
{
    private DAccountFrcInvolExamHelper helper;

    public DAccountFrcInvolExamModal()
    {
        this.helper = new DAccountFrcInvolExamHelper();
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
    public void setValuesToFields(DAccountFrcInvolExamData data){
        helper.getExamDtField().setValue(data.getExamDt());
        helper.getResultField().setValue(data.getResult());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountFrcInvolExamData data){
        helper.getExamDtField().assertValue_equals(data.getExamDt());
        helper.getResultField().assertValue(data.getResult());
    }
}
