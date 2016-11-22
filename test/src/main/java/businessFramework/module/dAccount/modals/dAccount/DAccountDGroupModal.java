package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountDGroupData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class DAccountDGroupModal implements Values
{
    private DAccountDGroupHelper helper;

    public DAccountDGroupModal()
    {
        this.helper = new DAccountDGroupHelper();
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
    public void setValuesToFields(DAccountDGroupData groupData){
        helper.getFromDtField().setValue(groupData.getFromDt());
        helper.getGroupField().setValue(groupData.getGroup());
        helper.getAmbField().setValue(groupData.getAmb());
        helper.getReasonField().setValue(groupData.getReason());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountDGroupData groupData){
        helper.getFromDtField().assertValue_equals(groupData.getFromDt());
        helper.getGroupField().assertValue_equals(groupData.getGroup());
        helper.getAmbField().assertValue_equals(groupData.getAmb());
        helper.getReasonField().assertValue_equals(groupData.getReason());
    }
}
