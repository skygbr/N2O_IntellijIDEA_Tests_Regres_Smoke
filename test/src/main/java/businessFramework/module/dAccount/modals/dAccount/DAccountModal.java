package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

public class DAccountModal extends DAccountHelper
{

    public DAccountModal(ApplicationManager app)
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
    public void setValuesToFields(DAccountData dAccountData){
        getRegDateField().setValue(dAccountData.getRegDate());
        getPatientField().setValue(dAccountData.getPatient());
        getClinicDistrictField().setValue(dAccountData.getClinicDistrict());
        getAcStageField().setValue(dAccountData.getAcStage());
        getConditionField().setValue(dAccountData.getCondition());
        getPatStateField().setValue(dAccountData.getPatState());
        getHivField().setValue(dAccountData.getHiv());
        getHivDateField().setValue(dAccountData.getHivDate());
        getGroupField().setValue(dAccountData.getGroup());
        getAmbField().setValue(dAccountData.getAmb());
        getStageField().setValue(dAccountData.getStage());
        getDiseaseField().setValue(dAccountData.getDisease());
        getMainDiagnosField().setValue(dAccountData.getDiagnos());
        getClinicalFormField().setValue(dAccountData.getClinicalForm());
        getLocalizationField().setValue(dAccountData.getLocalization());
        getComplicationField().setValue(dAccountData.getComplication());
    }
}
