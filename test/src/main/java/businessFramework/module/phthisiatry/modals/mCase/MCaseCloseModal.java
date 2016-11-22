package businessFramework.module.phthisiatry.modals.mCase;

import businessFramework.entities.phthisiatry.MCaseData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseCloseModal extends MCaseCloseHelper
{
    public MCaseCloseModal(ApplicationManager app)
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
     * Устанавливает значения в поля без выбора основного диагноза
     */
    public void setValuesToFields(MCaseData mCaseData){
        getResultTreatmentField().setValue(mCaseData.getResultTreatment());
        getResultReasonField().setValue(mCaseData.getResultReason());
        getDeviationReasonField().setValue(mCaseData.getDeviationReason());
        getDiagnosField().searchValue(mCaseData.getDiagnosisCode());
        getDiagnosisTypeField().setValue(mCaseData.getDiagnosisType());
        getDiseaseTypeField().setValue(mCaseData.getDiseaseType());
        getEstablishmentDateField().setValue(mCaseData.getEstablishmentDate());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(MCaseData mCaseData){
        getResultTreatmentField().assertValue_equals(mCaseData.getResultTreatment());
        getResultReasonField().assertValue_equals(mCaseData.getResultReason());
        getDeviationReasonField().assertValue_equals(mCaseData.getDeviationReason());
        getDiagnosField().assertValueContains(mCaseData.getDiagnosisCode());
        getDiagnosisTypeField().assertValue_equals(mCaseData.getDiagnosisType());
        getDiseaseTypeField().assertValue_equals(mCaseData.getDiseaseType());
        getEstablishmentDateField().assertValue_equals(mCaseData.getEstablishmentDate());

    }
}
