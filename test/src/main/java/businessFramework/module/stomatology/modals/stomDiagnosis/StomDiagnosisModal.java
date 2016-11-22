package businessFramework.module.stomatology.modals.stomDiagnosis;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class StomDiagnosisModal extends StomDiagnosisHelper{


    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }

    public void setValue(){
        getToothNumber().setValue("1.1");
        getDiagnosis().setValue(1);
        getToothSurfaces().setValue(0);
        getDiseaseType().setValue(1);
    }
    public void changeValue(){
        getToothNumber().setValue("1.2");
        getDiagnosis().setValue(3);
        getToothSurface().setValue(1);
        getDiagnosisType().setValue(1);
        getDiseaseType().setValue(0);
    }
}
