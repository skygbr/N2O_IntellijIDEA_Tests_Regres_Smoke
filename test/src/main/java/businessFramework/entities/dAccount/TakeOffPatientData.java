package businessFramework.entities.dAccount;

public class TakeOffPatientData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Снятие пациента с учёта" */
    private String unregDate;
    private String reason;

    public String getUnregDate() {
        return unregDate;
    }

    public void setUnregDate(String unregDate) {
        this.unregDate = unregDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public TakeOffPatientData clone() throws CloneNotSupportedException
    {
        return (TakeOffPatientData)super.clone();
    }
}
