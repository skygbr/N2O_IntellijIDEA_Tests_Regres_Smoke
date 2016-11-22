package businessFramework.module.hospital.modals.refusal;


import businessFramework.entities.hospital.HospitalData;
import net.framework.autotesting.meta.components.Button;


public class RefusalModal
{
    private RefusalHelper refusalHelper;

    public RefusalModal()
    {
        this.refusalHelper = new RefusalHelper();
    }

    public RefusalModal(String locator)
    {
        this.refusalHelper = new RefusalHelper(locator);
    }

    public void clickConfirmButton()
    {
        Button button = refusalHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void openSection()
    {
        refusalHelper.getContainer().assertThatContainerIsHidden(false);
        refusalHelper.getContainer().clickContainer();
    }

    public void assertPatientDataForm(HospitalData hospitalData)
    {
        refusalHelper.getPatientName().assertFieldText(hospitalData.getPatient());
        refusalHelper.getFinancialTypeName().assertFieldText(hospitalData.getFinancialType());
    }

    public void fillForm(HospitalData hospitalData)
    {
        refusalHelper.getRefusalDate().setValueBySendKeys(hospitalData.getRefusalDate());
        if(refusalHelper.getUid().getValue().isEmpty())
            refusalHelper.getUid().setValue(hospitalData.getUid());
        refusalHelper.getStepResultReason().setValue(hospitalData.getStepResultReason());
        refusalHelper.getRefusalEmployee().setValue(hospitalData.getRefusalEmployee());
        refusalHelper.getStepResult().setValue(hospitalData.getStepResult());
        refusalHelper.getRegimen().setValue(hospitalData.getCareRegimen());
        refusalHelper.getProfile().setValue(hospitalData.getProfile());
    }

    public void assertForm(HospitalData hospitalData)
    {
        refusalHelper.getRefusalDate().assertThatDateContainsValue(hospitalData.getRefusalDate());
        refusalHelper.getUid().assertValue(hospitalData.getUid());
        refusalHelper.getRefusalEmployee().assertValue_contains(hospitalData.getRefusalEmployee());
        refusalHelper.getStepResultReason().assertValue_contains(hospitalData.getStepResultReason());
        refusalHelper.getStepResult().assertValue_contains(hospitalData.getStepResult());
        refusalHelper.getRegimen().assertValue_contains(hospitalData.getCareRegimen());
        refusalHelper.getProfile().assertValue_contains(hospitalData.getProfile());
    }
}
