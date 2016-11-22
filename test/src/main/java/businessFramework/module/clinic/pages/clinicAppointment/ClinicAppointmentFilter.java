package businessFramework.module.clinic.pages.clinicAppointment;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ClinicAppointmentFilter extends ClinicAppointmentHelper {
    public ClinicAppointmentFilter(ApplicationManager app) {
        super(app);
    }

    public InputDate getAppointmentDate(){
        return getContainerAppointments().getFilter().getInputDate("dt");
    }
    public InputCheckBox getAppointmentIsNull(){
        return getContainerAppointments().getFilter().getInputCheckBox("appointmentIsNull");
    }

    public Classifier getCaseOpenDoctorSpeciality(){
        return getContainerCases().getFilter().getClassifier("clinicDoctorSpeciality");
    }
    public Classifier getCaseOpenDoctor(){
        return getContainerCases().getFilter().getClassifier("openDoctor");
    }
    public InputCheckBox getCaseIsClosed(){
        return getContainerCases().getFilter().getInputCheckBox("caseIsClosed");
    }

    public InputDate getHomeAppointmentDate(){
        return getContainerAppointmentAtHome().getFilter().getInputDate("dt");
    }
    public Classifier getPatient(){
        return getContainerAppointmentAtHome().getFilter().getClassifier("individual");
    }
    public MaskedInput getAgeBegin(){
        return getContainerAppointmentAtHome().getFilter().getMaskedInput("ageBegin");
    }
    public MaskedInput getAgeEnd(){
        return getContainerAppointmentAtHome().getFilter().getMaskedInput("ageEnd");
    }
    public InputText getPatientAddress(){
        return getContainerAppointmentAtHome().getFilter().getInputText("patientAddress");
    }
    public Classifier getCategory(){
        return getContainerAppointmentAtHome().getFilter().getClassifier("category");
    }
    public Classifier getReason(){
        return getContainerAppointmentAtHome().getFilter().getClassifier("reason");
    }
    public InputText getComplaints(){
        return getContainerAppointmentAtHome().getFilter().getInputText("complaints");
    }

}
