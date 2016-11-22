package businessFramework.module.pharmacy.pages.transferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActCreateSpecHelper  extends Page implements Values {
    public TransferActCreateSpecHelper(ApplicationManager app)
    {
        super(app);
    }

     /* ----------------------------- Фильтр при создании спецификации на странице "Акты переброски"  и поля в нем ----------------------------- */


    /**
     * Получает контейнер "batchList"
     * @return контейнер "batchList"
     */
    public Container getBatchListContainer()
    {
        return getContainer("batchList");
    }

    /**
     * @return Фильтр при создании спецификации на странице "Акты переброски"
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

    /* ----------------------------- Кнопки в контейнере "BatchList" на странице "Акты переброски" при создании спецификации ----------------------------- */

    /**
     * @return получает кнпоку "Добавить" в контейнере "BatchList"
     */
    public Button getAddSpecBatchListButton()
    {
        return getBatchListContainer().getButton(CREATE_BUTTON);
    }

    /* --------------- Контейнер "Спецификации" на странице "Акты переброски / Расходная накладная: №... от .... Добавление спецификации."----------- */

    /**
     * @return Контейнер "Спецификации" на странице Акты переброски - добавление спецификации.
     */
    public Container getTransferActSpecContainer()
    {
        return getContainer("transferSpecList");
    }

    /**
     * @return Таблицу в контейнере "Спецификации" на странице Акты переброски - добавление спецификации.
     */
    public Table getSpecificationsTable()
    {
        return getTransferActSpecContainer().getTable();
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditSpecButton()
    {
        return getTransferActSpecContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }

}
