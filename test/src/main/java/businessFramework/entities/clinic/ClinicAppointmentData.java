package businessFramework.entities.clinic;

/**
 * Created by bulat.garipov on 07.06.2016.
 */
public class ClinicAppointmentData {

    private String patientFIO;
    private String admissionDate;

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getPatientFIO() {
        return patientFIO;
    }

    public void setPatientFIO(String patientFIO) {
        this.patientFIO = patientFIO;
    }
}
