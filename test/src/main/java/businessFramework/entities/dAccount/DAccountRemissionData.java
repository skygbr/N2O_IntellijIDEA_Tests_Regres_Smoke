package businessFramework.entities.dAccount;

public class DAccountRemissionData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Динамика состояния" */
    private String beginDt;
    private String endDt;
    private String info;

    public String getBeginDt() {
        return beginDt;
    }

    public void setBeginDt(String beginDt) {
        this.beginDt = beginDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public DAccountRemissionData clone() throws CloneNotSupportedException
    {
        return (DAccountRemissionData)super.clone();
    }
}
