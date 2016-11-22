package businessFramework.module.phthisiatry.modals.mCase;

import businessFramework.entities.phthisiatry.MCaseData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseCreateModal extends MCaseCreateHelper
{

    public MCaseCreateModal(ApplicationManager app)
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
    public void setValuesToFields(MCaseData mCaseData){
        getPatientField().setValue(mCaseData.getPatient());
        getUidField().setValue(mCaseData.getUid());
        getRepeatCountField().setValue(mCaseData.getRepeatCount());
        getCaseTypeField().setValue(mCaseData.getCaseType());
        getCareRegimenField().setValue(mCaseData.getCareRegimen());
        getCareLevelField().setValue(mCaseData.getCareLevel());
        getFundingField().setValue(mCaseData.getFunding());
        getInitGoalField().setValue(mCaseData.getInitGoal());
        getStageField().setValue(mCaseData.getDiagnosisStage());
        getMainDiagnosField().searchValue(mCaseData.getDiagnosisCode());
        getClinicalFormField().setValue(mCaseData.getClinicalForm());
        getLocalizationField().setValue(mCaseData.getLocalization());
        getComplicationField().setValue(mCaseData.getComplication());
    }
}
