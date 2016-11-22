package businessFramework.entities.pharmacy;

/**
 * Created by bulat.garipov on 20.02.2016.
 */
public class FormulaDocumentData {

    /** Данные для выбора контекста */
    private String departmentForContext;

    /**Поля формы Прописи*/
    String name;
    String modifName;
    String mneiQuantity;
    String note;
    String unitName;

    /**Поля формы Спецификации*/
    String specModifName;
    String specMneiQuantity;
    String specUnitName;

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModifName() {
        return modifName;
    }

    public void setModifName(String modifName) {
        this.modifName = modifName;
    }

    public String getMneiQuantity() {
        return mneiQuantity;
    }

    public void setMneiQuantity(String mneiQuantity) {
        this.mneiQuantity = mneiQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSpecMneiQuantity() {
        return specMneiQuantity;
    }

    public void setSpecMneiQuantity(String specMneiQuantity) {
        this.specMneiQuantity = specMneiQuantity;
    }

    public String getSpecModifName() {
        return specModifName;
    }

    public void setSpecModifName(String specModifName) {
        this.specModifName = specModifName;
    }

    public String getSpecUnitName() {
        return specUnitName;
    }

    public void setSpecUnitName(String specUnitName) {
        this.specUnitName = specUnitName;
    }
}