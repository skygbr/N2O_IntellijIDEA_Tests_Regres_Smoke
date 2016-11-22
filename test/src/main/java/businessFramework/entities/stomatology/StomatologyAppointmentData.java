package businessFramework.entities.stomatology;

/**
 * Created by bulat.garipov on 27.07.2016.
 */
public class StomatologyAppointmentData {
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
