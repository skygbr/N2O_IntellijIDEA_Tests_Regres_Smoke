package businessFramework.module.clinic.modals.clinicDiagnosis;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 17.02.2016.
 */
public class ClinicDiagnosisModal {
    private ClinicDiagnosisHelper clinicDiagnosisHelper;
    public ClinicDiagnosisModal(){
        clinicDiagnosisHelper = new ClinicDiagnosisHelper();
    }

    public void clickConfirm(){
        Button button = clinicDiagnosisHelper.getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = clinicDiagnosisHelper.getCancelButton();
        button.click();
    }

    public void setValue(){
        clinicDiagnosisHelper.getDiagnosis().setValue(1);
        clinicDiagnosisHelper.getStage().setValue("Клинический");
        clinicDiagnosisHelper.getDiseaseType().setValue(1);
    }
    public void changeValue(){
        clinicDiagnosisHelper.getDiagnosis().setValue(3);
        clinicDiagnosisHelper.getDiseaseType().setValue(0);
    }
}
