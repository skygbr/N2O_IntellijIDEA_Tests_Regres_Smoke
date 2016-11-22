package businessFramework.module.hospital.modals.createBedResource;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.modals.chooseBed.ChooseBedModal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class CreateBedResourceModal
{
    private CreateBedResourceHelper createBedResourceHelper;
    private Page page = Page.getInstance();

    public CreateBedResourceModal()
    {
        this.createBedResourceHelper = new CreateBedResourceHelper();
    }

    public CreateBedResourceModal(String locator)
    {
        this.createBedResourceHelper = new CreateBedResourceHelper(locator);
    }

    public ChooseBedModal getChooseBedModal()
    {
        return new ChooseBedModal();
    }

    public void clickConfirm()
    {
        Button button = createBedResourceHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void chooseBed(Boolean flag)
    {
        createBedResourceHelper.getBedResource().findModalButtonClick();
        page.assertModalPresentOnPage(true);
        page.getModal().assertModalHeader_contains("Выбор койки");
        getChooseBedModal().chooseBed(flag);
        clickConfirm();
    }

    public void assertAddBusyBed()
    {
        this.chooseBed(false);
        this.clickConfirm();
        createBedResourceHelper.getContainer().getForm().getAlerts().assertErrorAlertMessage("Выбранная койка занята на это время другой");
    }

    public void addFreeBed()
    {
        this.chooseBed(true);
    }

    public void setBeginDate(HospitalData hospitalData)
    {
        createBedResourceHelper.getBeginDate().setValueBySendKeys(hospitalData.getBeginDateBed());
    }

    public void assertDateTime(HospitalData hospitalData)
    {
        createBedResourceHelper.getBeginDate().assertThatDateContainsValue(hospitalData.getBeginDateBed());
    }
}
