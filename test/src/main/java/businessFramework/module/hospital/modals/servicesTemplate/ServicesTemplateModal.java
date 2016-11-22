package businessFramework.module.hospital.modals.servicesTemplate;

import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateData;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplateModal {

    private ServicesTemplateHelper servicesTemplateHelper;
    private Page page = Page.getInstance();

    public ServicesTemplateModal() {
        servicesTemplateHelper = new ServicesTemplateHelper();
    }

    public ServicesTemplateModal(String locator) {
        servicesTemplateHelper = new ServicesTemplateHelper(locator);
    }

    public void assertServicesTemplateForm (ServicesTemplateData data)
    {
        servicesTemplateHelper.getName().assertValue(data.getName());
        servicesTemplateHelper.getStandart().assertValue_equals(data.getStandard());
        servicesTemplateHelper.getType().assertThatRadioButtonSelected(data.getType() ,true);
        servicesTemplateHelper.getNote().assertValue(data.getNote());
        servicesTemplateHelper.getPeriod().assertThatBeginDateContainsValue(data.getBeginDate());
        servicesTemplateHelper.getPeriod().assertThatEndDateContainsValue(data.getEndDate());
    }

    public void fillServicesTemplateForm(ServicesTemplateData data)
    {
        servicesTemplateHelper.getName().setValue(data.getName());
        servicesTemplateHelper.getStandart().setValue(data.getStandard());
        servicesTemplateHelper.getType().radioButtonPress(data.getType());
        servicesTemplateHelper.getNote().setValue(data.getNote());
        servicesTemplateHelper.getPeriod().setPeriod(data.getBeginDate(), data.getEndDate());
    }

    public void clickSaveServicesTemplate()
    {
        Button button = servicesTemplateHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertSuccessAlertIsPresent();
    }

    public void clickSaveServicesTemplateWithValidationException(String msg)
    {
        Button button = servicesTemplateHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertErrorAlertMessage(msg);
    }

    public void clickCancel()
    {
        Button button = servicesTemplateHelper.getCancelButton();
        button.assertIsEnabled();
        button.click();
    }
}
