package businessFramework.module.phthisiatry.modals.mStep;

import businessFramework.entities.phthisiatry.MStepData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import businessFramework.module.phthisiatry.modals.mStep.MStepEditHelper;

/**
 * Created by bulat.garipov on 28.10.2016.
 */
public class MStepEditModal extends MStepEditHelper {

    public MStepEditModal(ApplicationManager app) {
        super(app);
    }

    public void clickConfirm() {
        Button button = getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickCancel() {
        Button button = getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Устанавливает значения в полях
     */
    public void setValuesToFields(MStepData mStepData){
//        getAdmissionDateField().setValue(mStepData.getAdmissionDate());
//        getVrachField().setValue(mStepData.getVrach());
//        getEquipField().setValue(mStepData.getEquip());
//        getPlaceField().setValue(mStepData.getPlace());
//        getProfileField().setValue(mStepData.getProfile());
//        getInitGoalField().setValue(mStepData.getInitGoal());
//        getDiseaseTypeField().setValue(mStepData.getDiseaseType());
        getMainDiagnosField().searchValue(mStepData.getDiagnosisCode());
        getClinicalFormField().setValue(mStepData.getClinicalForm());
        getLocalizationField().setValue(mStepData.getLocalization());
        getComplicationField().setValue(mStepData.getComplication());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(MStepData mStepData) {
        getAdmissionDateField().assertValue_equals(mStepData.getAdmissionDate());
        getVrachField().assertValue_contains(mStepData.getVrach());
        //TODO очищается не обязаетельное поле Оборудование при повторном редактировании "Посещения" RMISDEV-5478
        //getEquipField().assertValue_equals(mStepData.getEquip());
        getPlaceField().assertValue_equals(mStepData.getPlace());
        getProfileField().assertValue_equals(mStepData.getProfile());
        getInitGoalField().assertValue_equals(mStepData.getInitGoal());
        getDiseaseTypeField().assertValue_equals(mStepData.getDiseaseType());
        getMainDiagnosField().assertValueContains(mStepData.getDiagnosisCode());
        getClinicalFormField().assertValue_equals(mStepData.getClinicalForm());
        getLocalizationField().assertValue_equals(mStepData.getLocalization());
        getComplicationField().assertValue_equals(mStepData.getComplication());
    }
}
