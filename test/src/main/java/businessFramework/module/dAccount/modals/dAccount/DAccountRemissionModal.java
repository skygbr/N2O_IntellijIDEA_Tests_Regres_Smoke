package businessFramework.module.dAccount.modals.dAccount;

import businessFramework.entities.dAccount.DAccountRemissionData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

public class DAccountRemissionModal extends DAccountRemissionHelper
{

    public DAccountRemissionModal(ApplicationManager app)
    {
        super(app);
    }

    public void clickConfirm()
    {
        Button button = getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickCancel()
    {
        Button button = getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Устанавливает значения в поля
     */
    public void setValuesToFields(DAccountRemissionData data){
        getBeginDtField().setValue(data.getBeginDt());
        getEndDtField().setValue(data.getEndDt());
        getInfoField().setValue(data.getInfo());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountRemissionData data){
        getBeginDtField().assertValue_equals(data.getBeginDt());
        getEndDtField().assertValue_equals(data.getEndDt());
        getInfoField().assertValue(data.getInfo());
    }
}
