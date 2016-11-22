package businessFramework.module.stomatology.modals.stomLaboratoryReferral;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 21.07.2016.
 */
public class StomLaboratoryReferralModal extends StomLaboratoryReferralHelper{


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
