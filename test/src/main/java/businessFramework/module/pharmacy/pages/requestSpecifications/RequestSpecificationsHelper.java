package businessFramework.module.pharmacy.pages.requestSpecifications;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class RequestSpecificationsHelper extends Page implements Values {
    public RequestSpecificationsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Возвращает контейнер Партии
     * @return кнотейнер Партии
     */
    public Container getBatchListContainer(){
        return getContainer("batchList");
    }

    /**
     * Возвращает контейнер "Спецификации"
     * @return кнотейнер "Спецификации"
     */
    public Container getSpecificationsListContainer(){
        return getContainer("requestSpecList");
    }

           /* -----------------------------  Фильтр на странице "Спецификации" ----------------------------- */

    /**
     * Получает фильтр в контейнере Партии
     * @return фильтр в контейнере Партии
     */
    public Filter getFilterForBatchList()
    {
        return getBatchListContainer().getFilter();
    }

    /**
     * @return Поле "Наименование ЛС и ИМН" в фильтре
     */
    public InputText getFilterModificationName()
    {
        return getFilterForBatchList().getInputText("holdModif.name");
    }

    /**
     * @return классифаер "Товарная группа" в фильтре
     */
    public InputText getFilterCommodityGroup()
    {
        return getFilterForBatchList().getInputText("doc.comGroup.name");
    }

    /**
     * @return классифаер "Финансирование" в фильтре
     */
    public InputText getFilterFundingSource()
    {
        return getFilterForBatchList().getInputText("doc.fundSource.name");
    }

    /**
     * @return чекбокс "Наличие в аптеке" в фильтре
     */
    public InputCheckBox getFilterExistsInPharmacyCheckBox() {
        return getFilterForBatchList().getInputCheckBox("existsInPharmacy");
    }

           /* -----------------------------  Таблица Партии и кнопки в контейнере Партии ----------------------------- */

    /**
     * @return таблицу в контейнере Партии
     */
    public Table getBatchListTable()
    {
        return getBatchListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddSpecificationButton()
    {
        return getBatchListContainer().getButton(CREATE_BUTTON);
    }

    /* -----------------------------  Таблица "Спецификации" и кнопки в контейнере "Спецификации" ----------------------------- */

    /**
     * @return таблицу в контейнере "Спецификации"
     */
    public Table getSpecificationsListTable()
    {
        return getSpecificationsListContainer().getTable();
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getUpdateSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Просмотр"
     */
    public Button getViewSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteSpecificationButton()
    {
        return getBatchListContainer().getButton(DELETE_BUTTON);
    }


}