package businessFramework.entities.vaccination;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Значения для справочника "Производители вакцин"
 */
public class VaccineProducerDictionaryData {

    private String doseDepartment;                // Контекст

    private String errorLabel;                    // Значение для поля "Наименование"
    private String errorFullName;                 // Значение для поля "Полное наименование"

    private String country;                       // Значение для поля "Страна"
    private String label;                         // Значение для поля "Наименование"
    private String fullName;                      // Значение для поля "Полное наименование"

    private String updateCountry;                 // Значение для изменения поля "Страна"
    private String updateLabel;                   // Значение для изменения поля "Наименование"
    private String updateLabelPart;               // Часть наименования для поиска в фильтре
    private String updateFullName;                // Значение для изменения поля "Полное наименование"
    private String updateFullNamePart;            // Часть полного наименования для поиска в фильтре

    public String getDoseDepartment()
    {
        return doseDepartment;
    }

    public void setDoseDepartment(String doseDepartment)
    {
        this.doseDepartment = doseDepartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getUpdateCountry() {
        return updateCountry;
    }

    public void setUpdateCountry(String updateCountry) {
        this.updateCountry = updateCountry;
    }

    public String getUpdateLabel() {
        return updateLabel;
    }

    public void setUpdateLabel(String updateLabel) {
        this.updateLabel = updateLabel;
    }

    public String getUpdateFullName() {
        return updateFullName;
    }

    public void setUpdateFullName(String updateFullName) {
        this.updateFullName = updateFullName;
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel = errorLabel;
    }

    public String getErrorFullName() {
        return errorFullName;
    }

    public void setErrorFullName(String errorFullName) {
        this.errorFullName = errorFullName;
    }

    public String getUpdateLabelPart() {
        return updateLabelPart;
    }

    public void setUpdateLabelPart(String updateLabelPart) {
        this.updateLabelPart = updateLabelPart;
    }

    public String getUpdateFullNamePart() {
        return updateFullNamePart;
    }

    public void setUpdateFullNamePart(String updateFullNamePart) {
        this.updateFullNamePart = updateFullNamePart;
    }
}
