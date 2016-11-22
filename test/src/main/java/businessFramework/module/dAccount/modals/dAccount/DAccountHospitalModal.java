package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.entities.dAccount.DAccountHospitalData;
import net.framework.autotesting.meta.components.Button;

public class DAccountHospitalModal extends DAccountHospitalHelper
{
    private DAccountHospitalHelper helper;

    public DAccountHospitalModal()
    {
        this.helper = new DAccountHospitalHelper();
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
     * Устанавливает значения в поля
     */
    public void setValuesToFields(DAccountHospitalData hospitalData){
        helper.getAdmissionDtField().setValue(hospitalData.getAdmission_dt());
        helper.getOutcomeDtField().setValue(hospitalData.getOutcome_date());
        helper.getDiagField().setValue(hospitalData.getDiagName());
        helper.getGoalField().setValue(hospitalData.getGoalName());
    }

    /**
     * Проверяет значения в полях
     */
    public void checkFieldsValues(DAccountHospitalData hospitalData){
        helper.getAdmissionDtField().assertValue_equals(hospitalData.getAdmission_dt());
        helper.getOutcomeDtField().assertValue_equals(hospitalData.getOutcome_date());
        helper.getDiagField().assertValue_equals(hospitalData.getDiagName());
        helper.getGoalField().assertValue_equals(hospitalData.getGoalName());
    }
}
