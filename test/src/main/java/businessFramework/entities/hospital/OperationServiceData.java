package businessFramework.entities.hospital;

/**
 * Created by bulat.garipov on 02.02.2016.
 */
public class OperationServiceData {
    private String hospitalRecord;
    private String plannedDate;
    private Boolean urgent;
    private String service;
    private String surgeon;
    private String operationRoom;
    private String financialType;

    private String renderedDate;
    private String anesthesiaType;
    private String complicationType;

    private String queue;
    private String department;
    private String medicalCase;


    public OperationServiceData() {
    }

    public String getHospitalRecord() {
        return hospitalRecord;
    }

    public void setHospitalRecord(String hospitalRecord) {
        this.hospitalRecord = hospitalRecord;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getOperationRoom() {
        return operationRoom;
    }

    public void setOperationRoom(String operationRoom) {
        this.operationRoom = operationRoom;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getRenderedDate() {
        return renderedDate;
    }

    public void setRenderedDate(String renderedDate) {
        this.renderedDate = renderedDate;
    }

    public String getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(String anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public String getComplicationType() {
        return complicationType;
    }

    public void setComplicationType(String complicationType) {
        this.complicationType = complicationType;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(String medicalCase) {
        this.medicalCase = medicalCase;
    }
}
