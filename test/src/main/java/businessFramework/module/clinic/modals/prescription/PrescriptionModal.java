package businessFramework.module.clinic.modals.prescription;

import businessFramework.entities.clinic.ResultAdmissionData;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 18.02.2016.
 */
public class PrescriptionModal extends PrescriptionHelper{

    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getService().setValue(1);
        getBeginPeriod().setValue("19.02.2016");
        getEndPeriod().setValue("20.02.2016");
        getPeriodicity().setValue("1 раз в день");
        getVisitTerm().setValue("До еды");
    }
    public void changeValue(){
        getService().setValue(0);
        getBeginPeriod().setValue("19.02.2016");
        getEndPeriod().setValue("21.02.2016");
        getPeriodicity().setValue("2 раза в день");
        getVisitTerm().setValue("Натощак");
    }
}
