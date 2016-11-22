package businessFramework.entities.vaccination;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Значения для справочника "Причины медицинского отвода"
 */
public class DenyReasonDictionaryData {

    private String doseDepartment;                          // Значение для поля "Код"

    private String code;                          // Значение для поля "Код"
    private String label;                         // Значение для поля "Наименование"

    private Boolean permanently;                  // Значение для поля "Признак постоянности отвода"
    private Boolean diagnos;                      // Значение для поля "Наличие диагноза"
    private Boolean diagnosRequired;              // Значение для поля "Обязательность диагноза"

    private String updateCode;                    // Значение для изменения поля "Код"
    private String updateLabel;                   // Значение для изменения поля "Наименование"

    private Boolean updatePermanently;            // Значение для изменения поля "Признак постоянности отвода"
    private Boolean updateDiagnos;                // Значение для изменения поля "Наличие диагноза"
    private Boolean updateDiagnosRequired;        // Значение для изменения поля "Обязательность диагноза"

    public String getDoseDepartment()
    {
        return doseDepartment;
    }

    public void setDoseDepartment(String doseDepartment)
    {
        this.doseDepartment = doseDepartment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUpdateCode() {
        return updateCode;
    }

    public void setUpdateCode(String updateCode) {
        this.updateCode = updateCode;
    }

    public String getUpdateLabel() {
        return updateLabel;
    }

    public void setUpdateLabel(String updateLabel) {
        this.updateLabel = updateLabel;
    }

    public Boolean getPermanently() {
        return permanently;
    }

    public void setPermanently(Boolean permanently) {
        this.permanently = permanently;
    }

    public Boolean getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(Boolean diagnos) {
        this.diagnos = diagnos;
    }

    public Boolean getDiagnosRequired() {
        return diagnosRequired;
    }

    public void setDiagnosRequired(Boolean diagnosRequired) {
        this.diagnosRequired = diagnosRequired;
    }

    public Boolean getUpdatePermanently() {
        return updatePermanently;
    }

    public void setUpdatePermanently(Boolean updatePermanently) {
        this.updatePermanently = updatePermanently;
    }

    public Boolean getUpdateDiagnos() {
        return updateDiagnos;
    }

    public void setUpdateDiagnos(Boolean updateDiagnos) {
        this.updateDiagnos = updateDiagnos;
    }

    public Boolean getUpdateDiagnosRequired() {
        return updateDiagnosRequired;
    }

    public void setUpdateDiagnosRequired(Boolean updateDiagnosRequired) {
        this.updateDiagnosRequired = updateDiagnosRequired;
    }
}
