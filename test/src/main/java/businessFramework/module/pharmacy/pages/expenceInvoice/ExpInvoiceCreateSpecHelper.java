package businessFramework.module.pharmacy.pages.expenceInvoice;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ExpInvoiceCreateSpecHelper extends Page implements Values
{
    public ExpInvoiceCreateSpecHelper(ApplicationManager app)
    {
        super(app);
    }

     /* ----------------------------- Фильтр при создании спецификации на странице "Расходные накладные"  и поля в нем ----------------------------- */


    /**
     * Получает контейнер "batchList"
     * @return контейнер "batchList"
     */
    public Container getBatchListContainer()
    {
        return getContainer("batchList");
    }

    /**
     * @return Фильтр при создании спецификации на странице "Расходные накладные"
     */
    public Filter getBatchListFilter()
    {
        return getBatchListContainer().getFilter();
    }

    /**
     * @return поле "Наименование ЛС и ИМН"
     */
    public InputText getNameLS_IMNField_F()
    {
        return getBatchListFilter().getInputText("filterHoldModif.name");
    }

    /**
     * @return поле "Склад"
     */
    public Classifier getStoreField_F()
    {
        return getBatchListFilter().getClassifier("doc.sendStore");
    }

    /**
     * @return поле "Товарная группа"
     */
    public Classifier getProductGroupField_F()
    {
        return getBatchListFilter().getClassifier("comGroup");
    }

    /**
     * @return поле "Источник фин."
     */
    public Classifier getFinSourceField_F()
    {
        return getBatchListFilter().getClassifier("fundSource");
    }

    /**
     * @return получает таблицу в контейнере BatchList
     */
    public Table getBatchListTable()
    {
        return getBatchListContainer().getTable();
    }

    /* ----------------------------- Кнопки в контейнере "BatchList" на странице "Расходные накладные" при создании спецификации ----------------------------- */

    /**
     * @return получает кнпоку "Добавить" в контейнере "BatchList"
     */
    public Button getAddSpecBatchListButton()
    {
        return getBatchListContainer().getButton(CREATE_BUTTON);
    }

    /* --------------- Контейнер "Спецификации" на странице "Расходные накладные / Расходная накладная: №... от .... Добавление спецификации."----------- */

    /**
     * @return Контейнер "Спецификации" на странице Расходные накладные - добавление спецификации.
     */
    public Container getExpSpecContainer()
    {
        return getContainer("expSpecList");
    }

    /**
     * @return Таблицу в контейнере "Спецификации" на странице Расходные накладные - добавление спецификации.
     */
    public Table getSpecificationsTable()
    {
        return getExpSpecContainer().getTable();
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditSpecButton()
    {
        return getExpSpecContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }

}
