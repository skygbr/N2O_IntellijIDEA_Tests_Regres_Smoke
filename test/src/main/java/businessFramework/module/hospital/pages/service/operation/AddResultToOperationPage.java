package businessFramework.module.hospital.pages.service.operation;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import test.smoke.PageDescription;

/**
 * @author agabdrakhmanova
 * @since 05.11.2015
 */
public class AddResultToOperationPage extends Page {

    private AddResultToOperationPageHelper helper;

    public AddResultToOperationPage(ApplicationManager app) {
        super(app);
        helper = new AddResultToOperationPageHelper(app);
    }

    public void clickConfirmButton() {
        Button confirm = helper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void clickBackButton() {
        Button back = getButton("back");
        back.assertIsEnabled();
        back.click();
    }

    public void save(OperationServiceData data)
    {
        fillForm(data);
        clickConfirmButton();
        //getAlerts().assertSuccessAlertIsPresent();
    }

    public void fillForm(OperationServiceData data) {
        helper.getRenderedDate().setValue(data.getPlannedDate());
        helper.getUrgent().check(data.getUrgent());
        helper.getService().setValue(data.getService());
        helper.getSurgeon().setValue(data.getSurgeon());
        helper.getOperationRoom().setValue(data.getOperationRoom());
        helper.getFinancialType().setValue(data.getFinancialType());
        helper.getService().setValue(data.getService());
        helper.getAnesthesiaType().setValue(data.getAnesthesiaType());
        helper.getComplicationType().setValue(data.getComplicationType());
    }

    public void assertForm(OperationServiceData data) {
        helper.getHospitalRecord().assertValue_equals(data.getHospitalRecord());
        helper.getRenderedDate().assertValue_equals(data.getPlannedDate());
        helper.getUrgent().assertThatCheckboxIsChecked(data.getUrgent());
        helper.getService().assertValue_equals(data.getService());
        helper.getSurgeon().assertValue_equals(data.getSurgeon());
        helper.getOperationRoom().assertValue_equals(data.getOperationRoom());
        helper.getFinancialType().assertValue_equals(data.getFinancialType());
        helper.getService().assertValue_equals(data.getService());
        helper.getAnesthesiaType().assertValue_equals(data.getAnesthesiaType());
        helper.getComplicationType().assertValue_equals(data.getComplicationType());
    }
}
