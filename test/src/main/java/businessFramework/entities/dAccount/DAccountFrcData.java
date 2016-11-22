package businessFramework.entities.dAccount;

public class DAccountFrcData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Принудительное лечение" */
    private String frcKind;
    private String orderNumber;
    private String orderDt;
    private String closeDt;

    public String getFrcKind() {
        return frcKind;
    }

    public void setFrcKind(String frcKind) {
        this.frcKind = frcKind;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(String orderDt) {
        this.orderDt = orderDt;
    }

    public String getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(String closeDt) {
        this.closeDt = closeDt;
    }

    @Override
    public DAccountFrcData clone() throws CloneNotSupportedException
    {
        return (DAccountFrcData)super.clone();
    }
}
