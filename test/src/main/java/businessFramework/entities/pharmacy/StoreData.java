package businessFramework.entities.pharmacy;

/**
 * Created by bulat.garipov on 25.02.2016.
 */
public class StoreData {

    /**
     * Данные для выбора контекста
     */
    private String departmentForContext;

    /**
     * Дата закрытия периода
     */
    private String closingDateString;

    /**
     * Данные для алертов
     */
    private String successSetStoreClosingDateAlertMessage = "Дата закрытия периода установлена";

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getSuccessSetStoreClosingDateAlertMessage() {
        return successSetStoreClosingDateAlertMessage;
    }

    public void setSuccessSetStoreClosingDateAlertMessage(String successSetStoreClosingDateAlertMessage) {
        this.successSetStoreClosingDateAlertMessage = successSetStoreClosingDateAlertMessage;
    }

    public String getClosingDateString() {
        return closingDateString;
    }

    public void setClosingDateString(String closingDateString) {
        this.closingDateString = closingDateString;
    }
}
