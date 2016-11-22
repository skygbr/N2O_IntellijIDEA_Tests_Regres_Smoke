package businessFramework.module.hospital.modals.service.operation;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

/**
 * @author agabdrakhmanova
 * @since 03.11.2015
 */
public class PlannedOperationModal implements Values {

    private PlannedOperationHelper plannedOperationHelper;

    public PlannedOperationModal() {
        this.plannedOperationHelper = new PlannedOperationHelper();
    }

    public PlannedOperationModal(String locator) {
        this.plannedOperationHelper = new PlannedOperationHelper(locator);
    }

    public void clickConfirmButton() {
        Button confirm = plannedOperationHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void fillForm(OperationServiceData data) {
        plannedOperationHelper.getHospitalRecord().setValue(data.getHospitalRecord());
        plannedOperationHelper.getPlannedDate().setValue(data.getPlannedDate());
        plannedOperationHelper.getUrgent().check(data.getUrgent());
        plannedOperationHelper.getService().setValue(data.getService());
        plannedOperationHelper.getSurgeon().setValue(data.getSurgeon());
        plannedOperationHelper.getOperationRoom().setValue(data.getOperationRoom());
        plannedOperationHelper.getFinancialType().setValue(data.getFinancialType());
    }

    public void assertForm(OperationServiceData data) {
        plannedOperationHelper.getHospitalRecord().assertValue_equals(data.getHospitalRecord());
        plannedOperationHelper.getPlannedDate().assertValue_equals(data.getPlannedDate());
        plannedOperationHelper.getUrgent().assertThatCheckboxIsChecked(true);
        plannedOperationHelper.getService().assertValue_equals(data.getService());
        plannedOperationHelper.getSurgeon().assertValue_equals(data.getSurgeon());
        plannedOperationHelper.getOperationRoom().assertValue_equals(data.getOperationRoom());
        plannedOperationHelper.getFinancialType().assertValue_equals(data.getFinancialType());
    }

}
