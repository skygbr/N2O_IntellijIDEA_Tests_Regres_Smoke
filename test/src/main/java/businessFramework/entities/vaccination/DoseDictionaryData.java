package businessFramework.entities.vaccination;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Значения для справочника "Дозировки"
 */
public class DoseDictionaryData {

    private String doseDepartment;

    /* ------------------- Контейнер "Дозировки" ------------------- */

    private String count;               // Значение для поля "Доза"
    private String doseType;            // Значение для поля "Единица измерения"
    private String code;                // Значение для поля "Код"
    private String eCode;               // Значение для поля "Дополнительный код"

    private String updateCount;         // Значение для изменения поля "Доза"
    private String updateDoseType;      // Значение для изменения поля "Единица измерения"
    private String updateCode;          // Значение для изменения поля "Код"
    private String updateECode;         // Значение для изменения поля "Дополнительный код"

    /* ------------------- Контейнер "Единицы измерения ------------------- */

    private String doseTypeCode;        // Значение для поля "Код"
    private String doseTypeLabel;       // Значение для поля "Единица измерения"

    private String updateDoseTypeCode;  // Значение для изменения поля "Код"
    private String updateDoseTypeLabel; // Значение для изменения поля "Единица измерения"

    public String getDoseDepartment()
    {
        return doseDepartment;
    }

    public void setDoseDepartment(String doseDepartment)
    {
        this.doseDepartment = doseDepartment;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(String updateCount) {
        this.updateCount = updateCount;
    }

    public String getUpdateDoseType() {
        return updateDoseType;
    }

    public void setUpdateDoseType(String updateDoseType) {
        this.updateDoseType = updateDoseType;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public String getUpdateECode() {
        return updateECode;
    }

    public void setUpdateECode(String updateECode) {
        this.updateECode = updateECode;
    }

    public String getDoseTypeCode() {
        return doseTypeCode;
    }

    public void setDoseTypeCode(String doseTypeCode) {
        this.doseTypeCode = doseTypeCode;
    }

    public String getDoseTypeLabel() {
        return doseTypeLabel;
    }

    public void setDoseTypeLabel(String doseTypeLabel) {
        this.doseTypeLabel = doseTypeLabel;
    }

    public String getUpdateDoseTypeCode() {
        return updateDoseTypeCode;
    }

    public void setUpdateDoseTypeCode(String updateDoseTypeCode) {
        this.updateDoseTypeCode = updateDoseTypeCode;
    }

    public String getUpdateDoseTypeLabel() {
        return updateDoseTypeLabel;
    }

    public void setUpdateDoseTypeLabel(String updateDoseTypeLabel) {
        this.updateDoseTypeLabel = updateDoseTypeLabel;
    }
}
