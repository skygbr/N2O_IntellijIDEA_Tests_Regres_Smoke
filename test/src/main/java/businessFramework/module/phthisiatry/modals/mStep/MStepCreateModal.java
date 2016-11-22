package businessFramework.module.phthisiatry.modals.mStep;

import businessFramework.entities.phthisiatry.MStepData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import businessFramework.module.phthisiatry.modals.mStep.MStepCreateHelper;

/**
 * Created by bulat.garipov on 28.10.2016.
 */
public class MStepCreateModal extends MStepCreateHelper
{
    public MStepCreateModal(ApplicationManager app)
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
     * Устанавливает значения в полях
     */
    public void setValuesToFields(MStepData mStepData){
        getVrachField().setValue(mStepData.getVrach());
        getServiceField().setValue(mStepData.getService());
        getEquipField().setValue(mStepData.getEquip());
        getAdmissionDateField().setValue(mStepData.getAdmissionDate());
        getPlaceField().setValue(mStepData.getPlace());
        getProfileField().setValue(mStepData.getProfile());
        getInitGoalField().setValue(mStepData.getInitGoal());
        getDiseaseTypeField().setValue(mStepData.getDiseaseType());
        getMainDiagnosField().searchValue(mStepData.getDiagnosisCode());
        getClinicalFormField().setValue(mStepData.getClinicalForm());
        getLocalizationField().setValue(mStepData.getLocalization());
        getComplicationField().setValue(mStepData.getComplication());
    }
}
