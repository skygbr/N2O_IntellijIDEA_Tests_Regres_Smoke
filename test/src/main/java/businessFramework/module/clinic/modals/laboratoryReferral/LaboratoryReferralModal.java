package businessFramework.module.clinic.modals.laboratoryReferral;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 15.07.2016.
 */
public class LaboratoryReferralModal extends LaboratoryReferralHelper{

    public void setValue(){
        getResearch().setValue(0);
    }
    public void editValue(){
        getDiagnosis().setValue("H61.2");
    }
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
}
