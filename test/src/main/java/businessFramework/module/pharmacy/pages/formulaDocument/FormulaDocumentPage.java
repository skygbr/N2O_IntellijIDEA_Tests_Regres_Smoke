package businessFramework.module.pharmacy.pages.formulaDocument;

import businessFramework.entities.pharmacy.FormulaDocumentData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.FormulaDocument.FormulaDocumentModal;
import businessFramework.module.pharmacy.modals.FormulaDocument.FormulaSpecModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 31.10.2015
 */
public class FormulaDocumentPage extends FormulaDocumentHelper implements Values {

    public FormulaDocumentPage(ApplicationManager app)
    {
        super(app);
    }

    public FormulaDocumentModal getFormulaDocumentModal() {
        return new FormulaDocumentModal(app);
    }

    public FormulaSpecModal getFormulaSpecModal() {
        return new FormulaSpecModal(app);
    }

     /* ------------------------------ Нажатие кнопок в контейнере "Прописи" ----------------------------------*/

    /**
    * Нажимает кнопку "Добавить" в контейнере "Прописи"
    */
    public void clickAddFormulaDocButton() {
        getAddFormulaDocButton().click();
    }

    /**
    * Нажимает кнопку "Изменить" в контейнере "Прописи"
    */
    public void clickUpdateFormulaDocButton() {
        getUpdateFormulaDocButton().click();
    }

    /**
    * Нажимает кнопку "Удалить" в контейнере "Прописи"
    */
    public void clickDeleteFormulaDocButton() {
        getDeleteFormulaDocButton().click();
    }


      /* ------------------------------ Нажатие кнопок в контейнере "Спецификации" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификации"
     */
    public void clickAddFormulaSpecButton() {
        getAddFormulaSpecButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Спецификации"
     */
    public void clickUpdateFormulaSpecButton() {
        getUpdateFormulaSpecButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Спецификации"
     */
    public void clickDeleteFormulaSpecButton() {
        getDeleteFormulaSpecButton().click();
    }

    public int checkTableValues(FormulaDocumentData formulaDocumentData) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (formulaDocumentData.getName() != null)
            columnsAndValues.put("Пропись", formulaDocumentData.getName());

        if (formulaDocumentData.getModifName() != null)
            columnsAndValues.put("Наименование ЛС и ИМН", formulaDocumentData.getModifName());

        if (formulaDocumentData.getMneiQuantity() != null)
            columnsAndValues.put("Количество", formulaDocumentData.getMneiQuantity());

        if (formulaDocumentData.getUnitName() != null)
            columnsAndValues.put("Ед. изм.", formulaDocumentData.getUnitName());

        return getFormulaDocListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    public int checkSpecTableValues(FormulaDocumentData formulaDocumentData)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (formulaDocumentData.getSpecModifName() != null)
            columnsAndValues.put("Наименование ЛС и ИМН", formulaDocumentData.getSpecModifName());

        if (formulaDocumentData.getSpecMneiQuantity() != null)
            columnsAndValues.put("Количество", formulaDocumentData.getSpecMneiQuantity());

        if (formulaDocumentData.getSpecUnitName() != null)
            columnsAndValues.put("Ед. изм.", formulaDocumentData.getSpecUnitName());

        return getFormulaSpecListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}