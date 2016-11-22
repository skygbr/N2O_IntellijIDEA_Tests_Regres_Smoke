package businessFramework.entities.hospital.prescription;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class PrescriptionCancelData {
    private String cancelDt;
    private String cancelReason;

    public PrescriptionCancelData() {
    }

    public String getCancelDt() {
        return cancelDt;
    }

    public void setCancelDt(String cancelDt) {
        this.cancelDt = cancelDt;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
