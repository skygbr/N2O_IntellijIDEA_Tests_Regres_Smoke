package businessFramework.module.stomatology.modals.stomDiagnosis;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class StomDiagnosisHelper implements Values {

    private Page page = Page.getInstance();

    public Container getContainerStomDiagnosis(){
        return page.getModal().getContainer("main");
    }
    public Classifier getToothNumber(){
        return getContainerStomDiagnosis().getForm().getClassifier("tooth");
    }
    public Classifier getDiagnosis(){
        return getContainerStomDiagnosis().getForm().getClassifier("diagnosis");
    }
    //при создании диагноза
    public Classifier getToothSurfaces(){
        return getContainerStomDiagnosis().getForm().getClassifier("toothSurfaces");
    }
    //при редактировании диагноза
    public Classifier getToothSurface(){
        return getContainerStomDiagnosis().getForm().getClassifier("toothSurface");
    }

    public InputCheckBox getIsMainDiagnosis(){
        return getContainerStomDiagnosis().getForm().getInputCheckBox("isMainDiagnos");
    }
    public Classifier getDiagnosisType(){
        return getContainerStomDiagnosis().getForm().getClassifier("diagnosisType");
    }

    public Classifier getStage(){
        return getContainerStomDiagnosis().getForm().getClassifier("stage");
    }
    public Classifier getDiseaseType(){
        return getContainerStomDiagnosis().getForm().getClassifier("diseaseType");
    }
    public InputCheckBox getDiagnosisIsDAccounting(){
        return getContainerStomDiagnosis().getForm().getInputCheckBox("diagnosis.isDAccounting");
    }
    public Classifier getInjuryType(){
        return getContainerStomDiagnosis().getForm().getClassifier("injuryType");
    }
    public OutputText getResGroup(){
        return getContainerStomDiagnosis().getForm().getOutputText("resGroup.name");
    }
    public InputDate getBDate(){
        return getContainerStomDiagnosis().getForm().getInputDate("bdate");
    }
    public Button getCancelButton(){
        return getContainerStomDiagnosis().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerStomDiagnosis().getButton(N2O_CONFIRM_BUTTON);
    }

}
