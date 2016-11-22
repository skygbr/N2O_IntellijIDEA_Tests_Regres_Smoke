package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

public class RemoveDAccountModal extends RemoveDAccountHelper
{

    public RemoveDAccountModal(ApplicationManager app)
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
    public void setValuesToFields(String removeReason, String reasonDescription){
        getRemoveReasonField().setValue(removeReason);
        getRemoveDescriptionField().setValue(reasonDescription);
    }
}
