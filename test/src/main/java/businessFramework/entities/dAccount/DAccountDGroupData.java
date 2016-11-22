package businessFramework.entities.dAccount;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class DAccountDGroupData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Д-группа" */
    private String group;
    private String fromDt;
    private String amb;
    private String reason;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFromDt() {
        return fromDt;
    }

    public void setFromDt(String fromDt) {
        this.fromDt = fromDt;
    }

    public String getAmb() {
        return amb;
    }

    public void setAmb(String amb) {
        this.amb = amb;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public DAccountDGroupData clone() throws CloneNotSupportedException
    {
        return (DAccountDGroupData)super.clone();
    }
}
