package businessFramework.module.hospital.modals.servicesTemplate;

import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateServiceData;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplateServiceModal {
    private ServicesTemplateServiceHelper servicesTemplateServiceHelper;
    private Page page = Page.getInstance();

    public ServicesTemplateServiceModal() {
        servicesTemplateServiceHelper = new ServicesTemplateServiceHelper();
    }

    public ServicesTemplateServiceModal(String locator) {
        servicesTemplateServiceHelper = new ServicesTemplateServiceHelper(locator);
    }

    public void assertServicesTemplateServiceForm (ServicesTemplateServiceData data)
    {
        servicesTemplateServiceHelper.getScheduleSelectionType().assertValue_contains(data.getScheduleSelectionType());
        servicesTemplateServiceHelper.getRestriction().assertValue(data.getRestriction());
        servicesTemplateServiceHelper.getService().assertValue_contains(data.getService());
        servicesTemplateServiceHelper.getResGroup().assertValue_contains(data.getResGroup());

        servicesTemplateServiceHelper.getDepartment().assertValue_contains(data.getDepartment());
        servicesTemplateServiceHelper.getDistrict().assertValue_contains(data.getDistrict());
        servicesTemplateServiceHelper.getSpeciality().assertValue_contains(data.getSpeciality());
        servicesTemplateServiceHelper.getProfile().assertValue_contains(data.getProfile());
        servicesTemplateServiceHelper.getFunding().assertValue_contains(data.getFunding());

        servicesTemplateServiceHelper.getQueue().assertValue(data.getQueue());
        servicesTemplateServiceHelper.getMaxInterval().assertValue(data.getMaxInterval());
        servicesTemplateServiceHelper.getIndentMeasure().assertValue_contains(data.getIndentMeasure());
        servicesTemplateServiceHelper.getIndent().assertValue(data.getIndent());

    }

    public void fillServicesTemplateServiceForm(ServicesTemplateServiceData data)
    {
        servicesTemplateServiceHelper.getScheduleSelectionType().setValue(data.getScheduleSelectionType());
        servicesTemplateServiceHelper.getRestriction().setValue(data.getRestriction());
        servicesTemplateServiceHelper.getService().setValue(data.getService());
        servicesTemplateServiceHelper.getResGroup().setValue(data.getResGroup());

        servicesTemplateServiceHelper.getDepartment().setValue(data.getDepartment());
        servicesTemplateServiceHelper.getDistrict().setValue(data.getDistrict());
        servicesTemplateServiceHelper.getSpeciality().setValue(data.getSpeciality());
        servicesTemplateServiceHelper.getProfile().setValue(data.getProfile());
        servicesTemplateServiceHelper.getFunding().setValue(data.getFunding());

        servicesTemplateServiceHelper.getQueue().setValue(data.getQueue());
        servicesTemplateServiceHelper.getMaxInterval().setValue(data.getMaxInterval());
        servicesTemplateServiceHelper.getIndent().setValue(data.getIndent());
        servicesTemplateServiceHelper.getIndentMeasure().setValue(data.getIndentMeasure());
    }

    public void fillServicesTemplateServiceFormForEdit(ServicesTemplateServiceData data)
    {
        servicesTemplateServiceHelper.getScheduleSelectionType().setValue(data.getScheduleSelectionType());
        servicesTemplateServiceHelper.getService().setValue(data.getService());
    }

    public void assertWhenScheduleSelectionTypeIsWithoutRecording()
    {
        servicesTemplateServiceHelper.getResGroup().assertIsHidden(true);
        servicesTemplateServiceHelper.getDepartment().assertIsHidden(true);
        servicesTemplateServiceHelper.getDistrict().assertIsHidden(true);
        servicesTemplateServiceHelper.getSpeciality().assertIsHidden(true);
        servicesTemplateServiceHelper.getProfile().assertIsHidden(true);
        servicesTemplateServiceHelper.getFunding().assertIsHidden(true);
        servicesTemplateServiceHelper.getQueue().assertIsHidden(true);

        servicesTemplateServiceHelper.getIndentFieldSet().assertFieldsetIsHidden(true);
        servicesTemplateServiceHelper.getMaxIntervalFieldSet().assertFieldsetIsHidden(true);
        servicesTemplateServiceHelper.getRestrictionFieldSet().assertFieldsetIsHidden(true);

    }

    public void clickSaveServicesTemplate()
    {
        Button button = servicesTemplateServiceHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertSuccessAlertIsPresent();
    }

    public void clickCancel()
    {
        Button button = servicesTemplateServiceHelper.getCancelButton();
        button.assertIsEnabled();
        button.click();
    }
}
