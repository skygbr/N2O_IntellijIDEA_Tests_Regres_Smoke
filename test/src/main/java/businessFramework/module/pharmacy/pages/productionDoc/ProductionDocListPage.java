package businessFramework.module.pharmacy.pages.productionDoc;

import businessFramework.entities.pharmacy.ProdDocData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExecuteDocumentModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Dialog;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProductionDocListPage  extends ProductionDocListHelper implements Values {
    public ProductionDocListPage(ApplicationManager app)
    {
        super(app);
    }

     /* ------------------------------ Нажатие кнопок в контейнере "Документы" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Документы"
     */
    public void clickAddProdDocButton() {
        getAddDocButton().click();
    }

    /**
     * Нажимает кнопку "Провести" в контейнере "Документы"
     */
    public void clickExecuteProdDocButton() {
        getExecuteDocButton().click();
    }

    /**
     * Нажимает кнопку "Отменить проводку" в контейнере "Документы"
     */
    public void clickCancelProdDocButton() {
        getCancelDocButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Документы"
     */
    public void clickUpdateProdDocButton() {
        getUpdateDocButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Документы"
     */
    public void clickDeleteProdDocButton() {
        getDeleteDocButton().click();
    }

    /**
     * Получение модального окна "Проведение документа"
     */
    public ExecuteDocumentModal getExecuteDocumentModal()
    {
        return new ExecuteDocumentModal(app);
    }


      /* ------------------------------ Нажатие кнопок в контейнере "Спецификации" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификации"
     */
    public void clickAddSpecButton() {
        getAddSpecButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Спецификации"
     */
    public void clickDeleteSpecButton() {
        getDeleteSpecButton().click();
    }

    public int checkDocTableValues(ProdDocData prodDocData) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (prodDocData.getDocNumber() != null)
            columnsAndValues.put("№", prodDocData.getDocNumber());
        if (prodDocData.getStatusExecuted() != null)
            columnsAndValues.put("", prodDocData.getStatusExecuted());
        if (prodDocData.getFormattedAmount() != null)
            columnsAndValues.put("Сумма", prodDocData.getFormattedAmount());
        return getProdDocListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    public ProdSpecStoreSupplyPage getProdSpecStoreSupplyPage()
    {
        return new ProdSpecStoreSupplyPage(app);
    }

    public int checkSpecTableValues(ProdDocData data) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (data.getSpecModif() != null) columnsAndValues.put("Наименование ЛС и ИМН", data.getSpecModif());
        if (data.getSpecSeries() != null) columnsAndValues.put("Серия", data.getSpecSeries());
        if (data.getSpecMneiQuantity() != null) columnsAndValues.put("Количество", data.getSpecMneiQuantity());
        if (data.getSpecFormattedPrice() != null) columnsAndValues.put("Цена", data.getSpecFormattedPrice());
        if (data.getSpecAmountFormatted() != null) columnsAndValues.put("Сумма", data.getSpecAmountFormatted());

        return getProdSpecListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "Удалить"
     */
    public Dialog getConfirmModal()
    {
        return getDialog();
    }

}