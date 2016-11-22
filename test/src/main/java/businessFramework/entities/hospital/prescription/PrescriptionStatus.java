package businessFramework.entities.hospital.prescription;

public enum PrescriptionStatus {
    WAIT_CONFIRMATION(1),
    SCHEDULED(2),
    PERFORM(3),
    EXECUTED(4),
    CANCELLED(5);

    private int id;

    PrescriptionStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
