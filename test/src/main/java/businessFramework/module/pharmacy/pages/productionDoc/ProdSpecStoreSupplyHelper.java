package businessFramework.module.pharmacy.pages.productionDoc;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProdSpecStoreSupplyHelper extends Page implements Values {


    public ProdSpecStoreSupplyHelper(ApplicationManager app)
    {
        super(app);
    }
    /**
     * Получает контейнер "batchList"
     * @return контейнер "batchList"
     */
    public Container getBatchListContainer()
    {
        return getContainer("batchList");
    }

    /**
     * @return получает таблицу в контейнере BatchList
     */
    public Table getBatchListTable()
    {
        return getBatchListContainer().getTable();
    }

     /* ----------------------------- Кнопки в контейнере "BatchList" на странице "Документы на изготовление" при создании спецификации ----------------------------- */

    /**
     * @return получает кнпоку "Добавить" в контейнере "BatchList"
     */
    public Button getAddSpecBatchListButton()
    {
        return getBatchListContainer().getButton(CREATE_BUTTON);
    }

       /**
     * @return Контейнер "Спецификации" на странице Док-ты на изготовление - добавление спецификации.
     */
    public Container getProdSpecContainer()
    {
        return getContainer("prodSpecList");
    }

    /**
     * @return Таблицу в контейнере "Спецификации"
     */
    public Table getSpecificationsTable()
    {
        return getProdSpecContainer().getTable();
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditSpecButton()
    {
        return getProdSpecContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }

    /**
     * Получение поля фильтра по полю "Наименование ЛС и ИМН"
     */

    public InputText getSpecModif() {
        return this.getBatchListContainer().getFilter().getInputText("filterHoldModif.name");
    }
}
