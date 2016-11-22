package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.entities.phthisiatry.MRefData;
import businessFramework.module.phthisiatry.modals.mRef.MRefEditHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by bulat.garipov on 31.10.2016.
 */
public class MRefEditModal extends MRefEditHelper {

    public MRefEditModal(ApplicationManager app) {
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
    public void setValuesToFields(MRefData mRefData){
        getCheckboxesIsUrgentField().check(mRefData.getCheckboxesIsUrgent(), true); // Отметить чекбокс "СРОЧНО"
        getFinancialTypeField().setValue(mRefData.getFinancialType());
        getPlannedDateField().setValue(mRefData.getPlannedDate());
        getServiceField().setValue(mRefData.getService());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(MRefData mRefData) {
        getCheckboxesIsUrgentField().assertThatCheckboxIsChecked(true);
        getClinicField().assertValue_equals(mRefData.getClinic());
        getFinancialTypeField().assertValue_equals(mRefData.getFinancialType());
        getPlannedDateField().assertValue_equals(mRefData.getPlannedDate());
        getServiceField().assertValue_equals(mRefData.getService());
    }
}
