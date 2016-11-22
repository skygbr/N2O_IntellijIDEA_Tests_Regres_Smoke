package businessFramework.module.phthisiatry.modals.mCase;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import businessFramework.entities.phthisiatry.MCaseData;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseEditModal extends MCaseEditHelper
{

    public MCaseEditModal(ApplicationManager app)
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
    public void setValuesToFields(String clinicalForm, String localization, String complication){
        getClinicalFormField().setValue(clinicalForm);
        getLocalizationField().setValue(localization);
        getComplicationField().setValue(complication);
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(MCaseData mCaseData){
        getNumberField().assertValue(mCaseData.getUid());
        getRepeatCountField().assertValue_equals(mCaseData.getRepeatCount());
        getCaseTypeField().assertValue_equals(mCaseData.getCaseType());
        getCareRegimenField().assertValue_equals(mCaseData.getCareRegimen());
        getCareLevelField().assertValue_equals(mCaseData.getCareLevel());
        getFundingField().assertValue_equals(mCaseData.getFunding());
        getInitGoalField().assertValue_equals(mCaseData.getInitGoal());
        getStageField().assertValue_equals(mCaseData.getDiagnosisStage());
        getClinicalFormField().assertValue_equals(mCaseData.getClinicalForm());
        getLocalizationField().assertValue_equals(mCaseData.getLocalization());
        getComplicationField().assertValue_equals(mCaseData.getComplication());
    }
}
