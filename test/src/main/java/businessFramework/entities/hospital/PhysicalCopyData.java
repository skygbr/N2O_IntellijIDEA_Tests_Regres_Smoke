package businessFramework.entities.hospital;

/**
 * Created by bulat.garipov on 02.02.2016.
 */
public class PhysicalCopyData {
    private String service;
    private String bdate;
    private String doctorFromContext;
    private String doctor;

    public PhysicalCopyData() {
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getDoctorFromContext() {
        return doctorFromContext;
    }

    public void setDoctorFromContext(String doctorFromContext) {
        this.doctorFromContext = doctorFromContext;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
