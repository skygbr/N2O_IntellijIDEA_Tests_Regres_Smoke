package businessFramework.module.stomatology.modals.stomPrescription;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 22.07.2016.
 */
public class StomPrescriptionModal extends StomPrescriptionHelper {
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getService().setValue("Прием");
        getBeginPeriod().setValue("19.02.2016");
        getEndPeriod().setValue("20.02.2016");
        getPeriodicity().setValue("2 раза в день");
        getVisitTerm().setValue("Натощак");
    }
    public void changeValue(){
        getBeginPeriod().setValue("18.02.2016");
        getEndPeriod().setValue("21.02.2016");
        getPeriodicity().setValue("1 раз в день");
        getVisitTerm().setValue("До еды");
    }
}
