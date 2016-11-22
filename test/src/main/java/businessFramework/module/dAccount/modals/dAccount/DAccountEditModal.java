package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

public class DAccountEditModal implements Values
{
    private DAccountEditHelper helper;

    public DAccountEditModal()
    {
        this.helper = new DAccountEditHelper();
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
    public void setValuesToFields(DAccountData dAccountData){
        helper.getRegDateField().setValue(dAccountData.getRegDate());
        helper.getClinicDistrictField().setValue(dAccountData.getClinicDistrict());
        helper.getAcStageField().setValue(dAccountData.getAcStage());
        helper.getConditionField().setValue(dAccountData.getCondition());
        helper.getPatStateField().setValue(dAccountData.getPatState());
        helper.getHivField().setValue(dAccountData.getHiv());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountData dAccountData){
        helper.getRegDateField().assertValue_equals(dAccountData.getRegDate());
        helper.getClinicDistrictField().assertValue_equals(dAccountData.getClinicDistrict());
        helper.getAcStageField().assertValue_equals(dAccountData.getAcStage());
        helper.getConditionField().assertValue_equals(dAccountData.getCondition());
        helper.getPatStateField().assertValue_equals(dAccountData.getPatState());
        helper.getHivField().assertValue_equals(dAccountData.getHiv());
    }
}
