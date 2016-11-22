package businessFramework.module.clinic.pages.resultAdmission;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by asamoilov on 17.02.2016.
 */
public class ResultAdmissionFilter extends ResultAdmissionHelper {
    public ResultAdmissionFilter(ApplicationManager app) {
        super(app);
    }

    public Classifier getStatusForClinicVaccinations(){
        return getContaineVaccinations().getFilter().getClassifier("statusForClinic");
    }
}
