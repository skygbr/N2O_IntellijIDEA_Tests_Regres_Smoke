package businessFramework.module.clinic.modals.clinicDiagnosis;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ClinicDiagnosisHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerClinicDiagnosis(){
        return page.getModal().getContainer("main");
    }

    public Classifier getDiagnosis(){
        return getContainerClinicDiagnosis().getForm().getClassifier("diagnosis");
    }
    public InputCheckBox getIsMainDiagnosis(){
        return getContainerClinicDiagnosis().getForm().getInputCheckBox("isMainDiagnos");
    }
    public Classifier getDiagnosisType(){
        return getContainerClinicDiagnosis().getForm().getClassifier("diagnosisType");
    }

    public Classifier getStage(){
        return getContainerClinicDiagnosis().getForm().getClassifier("stage");
    }
    public Classifier getDiseaseType(){
        return getContainerClinicDiagnosis().getForm().getClassifier("diseaseType");
    }
    public InputCheckBox getDiagnosisIsDAccounting(){
        return getContainerClinicDiagnosis().getForm().getInputCheckBox("diagnosis.isDAccounting");
    }
    public Classifier getInjuryType(){
        return getContainerClinicDiagnosis().getForm().getClassifier("injuryType");
    }
    public OutputText getResGroup(){
        return getContainerClinicDiagnosis().getForm().getOutputText("resGroup.name");
    }
    public InputDate getBDate(){
        return getContainerClinicDiagnosis().getForm().getInputDate("bdate");
    }
    public Button getCancelButton(){
        return getContainerClinicDiagnosis().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerClinicDiagnosis().getButton(N2O_CONFIRM_BUTTON);
    }

}
