package businessFramework.module.hospital.modals.treatmentPlan;


import businessFramework.entities.hospital.TreatmentPlanData;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class TreatmentPlanModal {
    private Page page = Page.getInstance();
    private TreatmentPlanHelper helper;

    public TreatmentPlanModal(String locator) {
        helper = new TreatmentPlanHelper(locator);
    }

    public TreatmentPlanModal() {
        helper = new TreatmentPlanHelper();
    }

    public void fillForm(TreatmentPlanData data) {
        helper.getSymptomDate().setValue(data.getSymptomDate());
        helper.getFirstVisitDate().setValue(data.getFirstVisitDate());
        assertVisibilityOfOrgansOrClinicFormFields(false);
        helper.getDiagnosis().setValue(data.getDiagnosis());
        setValueOfOrgansOrClinicFormField(data);
        helper.getPatientGroup().setValue(data.getPatientGroup());
        helper.getCardNum().setValue(data.getCardNum());
        helper.getCourseNum().setValue(data.getCourseNum());
        helper.getCreateDate().setValue(data.getCreateDate());
        helper.getEndDate().setValue(data.getEndDate());
        helper.getDayAmount().assertFieldText(data.getDayAmount());
        helper.getChemoPhase().setValue(data.getChemoPhase());
        helper.getChemoRegimen().setValue(data.getChemoRegimen());
        if (helper.getPatientWeight().getValue().isEmpty())
            helper.getPatientWeight().setValue(data.getPatientWeight());
        else
            helper.getPatientWeight().assertIsDisabled(true);
        assertVisibilityOfOutcomeOrgAndEndDateFields(false);
        helper.getResult().setValue(data.getResult());
        setOutcomeOrgAndEndDateFieldsValues(data);
    }

    public void assertForm(TreatmentPlanData data, boolean isReadOnly) {
        helper.getSymptomDate().assertValue_contains(isReadOnly, data.getSymptomDate());
        helper.getFirstVisitDate().assertValue_contains(isReadOnly, data.getFirstVisitDate());
        helper.getDiagnosis().assertValue_equals(isReadOnly, data.getDiagnosis());
        assertValueOfOrgansOrClinicFormField(data, isReadOnly);
        helper.getPatientGroup().assertValue_contains(isReadOnly, data.getPatientGroup());
        helper.getCardNum().assertValue_equals(isReadOnly, data.getCardNum());
        helper.getCourseNum().assertValue_equals(isReadOnly, data.getCourseNum());
        helper.getCreateDate().assertValue_contains(isReadOnly, data.getCreateDate());
        helper.getEndDate().assertValue_contains(isReadOnly, data.getEndDate());
        helper.getDayAmount().assertFieldText(data.getDayAmount());
        helper.getChemoPhase().assertValue_contains(isReadOnly, data.getChemoPhase());
        helper.getChemoRegimen().assertValue_contains(isReadOnly, data.getChemoRegimen());
        helper.getPatientWeight().assertValue_equals(isReadOnly, data.getPatientWeight());
        helper.getResult().assertValue_contains(isReadOnly, data.getResult());
        assertOutcomeOrgAndEndDateFieldsValues(data, isReadOnly);
    }

    private void assertVisibilityOfOrgansOrClinicFormFields(boolean isReadOnly) {
        String diagnosisFieldValue = helper.getDiagnosis().getValue(isReadOnly);
        helper.getClinicForm().assertIsHidden(!diagnosisFieldValue.contains("10.1"));
        helper.getOrgans().assertIsHidden(isReadOnly, !diagnosisFieldValue.contains("10.2"));
    }

    private void setValueOfOrgansOrClinicFormField(TreatmentPlanData data) {
        assertVisibilityOfOrgansOrClinicFormFields(false);
        String diagnosisFieldValue = helper.getDiagnosis().getValue();
        if (diagnosisFieldValue.contains("10.1"))
            helper.getClinicForm().setValue(data.getClinicForm());
        if (diagnosisFieldValue.contains("10.2"))
            helper.getOrgans().setValue(data.getOrgans());
    }

    private void assertValueOfOrgansOrClinicFormField(TreatmentPlanData data, boolean isReadOnly) {
        assertVisibilityOfOrgansOrClinicFormFields(isReadOnly);
        String diagnosisFieldValue = helper.getDiagnosis().getValue(isReadOnly);
        if (diagnosisFieldValue.contains("10.1"))
            helper.getClinicForm().assertValue_equals(isReadOnly, data.getClinicForm());
        if (diagnosisFieldValue.contains("10.2"))
            helper.getOrgans().assertValue_contains(isReadOnly, data.getOrgans());
    }

    private void assertVisibilityOfOutcomeOrgAndEndDateFields(boolean isReadOnly) {
        String resultFieldValue = helper.getResult().getValue(isReadOnly);
        helper.getResultEndDate().assertIsHidden(resultFieldValue.isEmpty());
        helper.getOutcomeOrg().assertIsHidden(!resultFieldValue.equals("Выбыл"));
    }

    private void setOutcomeOrgAndEndDateFieldsValues(TreatmentPlanData data) {
        assertVisibilityOfOutcomeOrgAndEndDateFields(false);
        String resultFieldValue = helper.getResult().getValue();
        if (!resultFieldValue.isEmpty())
            helper.getResultEndDate().setValue(data.getResultEndDate());
        if (resultFieldValue.equals("Выбыл"))
            helper.getOutcomeOrg().setValue(data.getOutcomeOrg());
    }

    private void assertOutcomeOrgAndEndDateFieldsValues(TreatmentPlanData data, boolean isReadOnly) {
        assertVisibilityOfOutcomeOrgAndEndDateFields(isReadOnly);
        String resultFieldValue = helper.getResult().getValue(isReadOnly);
        if (!resultFieldValue.isEmpty())
            helper.getResultEndDate().assertValue_contains(isReadOnly, data.getResultEndDate());
        if (resultFieldValue.equals("Выбыл"))
            helper.getOutcomeOrg().assertValue_equals(isReadOnly, data.getOutcomeOrg());
    }

    public void clickSaveButton() {
        Button button = helper.getCreateSaveButton();
        if (!button.takeButton().isDisplayed())
            button = helper.getUpdateSaveButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertSuccessAlertIsPresent();
    }

    public void clickCancelButton() {
        Button button = helper.getCancelButton();
        button.assertIsEnabled();
        button.click();
    }


}
