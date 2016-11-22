package businessFramework.module.hospital.modals.diagnosis;


import businessFramework.entities.hospital.DiagnosisData;
import businessFramework.entities.hospital.HospitalData;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

public class DiagnosisModal
{
    private Page page = Page.getInstance();
    private DiagnosisHelper diagnosisHelper;

    public DiagnosisModal()
    {
        diagnosisHelper = new DiagnosisHelper();
    }

    public DiagnosisModal(String locator)
    {
        diagnosisHelper = new DiagnosisHelper(locator);
    }

    public void fillDiagnosisForm(DiagnosisData diagnosisData)
    {
        diagnosisHelper.getStage().setValue(diagnosisData.getStageDiagnosis());
        diagnosisHelper.getInputCheckBox().check(true);
        diagnosisHelper.getDiagnosis().searchValue(diagnosisData.getDiagnosisCode());
    }

    public void fillDiagnosisFormList(DiagnosisData diagnosisData)
    {
        diagnosisHelper.getStage().setValue(diagnosisData.getStageDiagnosis());
        diagnosisHelper.getInputCheckBox().check(true);
        diagnosisHelper.getDiagnosisList().setValue(diagnosisData.getDiagnosisCodeList());
    }

    private boolean isClassifierHidden(Classifier classifier) {
        return classifier.takeContainer().getAttribute("style").contains("display: none;");
    }

    public void fillNoteFieldOnForm(String note)
    {
        diagnosisHelper.getNote().setValue(note);
    }

    private String chooseValueForFeatureClassifierWithModal(Classifier classifier)
    {
        classifier.assertIsHidden(false);
        classifier.findModalButtonClick();
        page.assertModalPresentOnPage(true);
        String value = diagnosisHelper.getFeatureModal().selectFeature();
        page.getModal().assertModalHeader_contains("Диагнозы");
        return value;
    }

    public void clickSaveDiagnosis()
    {
        getSaveDiagnosisButton().click();
//        page.getAlerts().assertSuccessAlertIsPresent();
    }

    public Button getSaveDiagnosisButton()
    {
        Button button = diagnosisHelper.getSaveDiagnosisButton();
        button.assertIsEnabled();
        return button;
    }

    public void clickUpdateDiagnosis()
    {
        diagnosisHelper.getUpdateDiagnosisButton().click();
    }

    public void assertForm(DiagnosisData diagnosisData)
    {
        diagnosisHelper.getStage().assertValue_contains(diagnosisData.getStageDiagnosis());
        if (!diagnosisData.getDiagnosisTree().isEmpty())
            diagnosisHelper.getDiagnosis().assertValueContains(diagnosisData.getDiagnosisTree().get(diagnosisData.getDiagnosisTree().size() - 1));
    }

    public void assertFormList(DiagnosisData diagnosisData)
    {
        diagnosisHelper.getStage().assertValue_contains(diagnosisData.getStageDiagnosis());
        diagnosisHelper.getDiagnosisList().assertValue_equals(diagnosisData.getDiagnosisCodeList());
    }
}
