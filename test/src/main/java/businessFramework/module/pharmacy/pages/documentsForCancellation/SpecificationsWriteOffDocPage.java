package businessFramework.module.pharmacy.pages.documentsForCancellation;


import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

public class SpecificationsWriteOffDocPage extends SpecificationsWriteOffDocHelper
{

    /** Страница спецификации */

    public SpecificationsWriteOffDocPage(ApplicationManager app)
    {
        super(app);
    }

    /** Номер ряда созданной записи в таблице "Спецификации" */
    public int row;

    /**
     * Проверяет значение полей на соответствие ожидаемым значениям (переданным в параметрах)
     *
     * @param nameLS_IMN        Ожидаемое значение поля "Наименование ЛС и ИМН"
     * @param store             Ожидаемое значение поля "Склад"
     * @param productGroup      Ожидаемое значение поля "Товарная группа"
     * @param financingType     Ожидаемое значение поля "Финансирование"
     */
    public void checkFieldsValues(String nameLS_IMN, String store, String productGroup, String financingType)
    {
        if ( nameLS_IMN != null)    { getNameLS_IMN_f().assertValue(nameLS_IMN);}
        if ( store != null)         { getStore_f().assertValue(store);}
        if ( productGroup != null)  { getProductGroup_f().assertValue(productGroup);}
        if ( financingType != null) { getFinancingType_f().assertValue(financingType);}
    }

    /**
     * Устанавливает значение в полях в фильтре на странице создания спецификации
     *
     * @param nameLS_IMN    значение для поля "Наименование ЛС и ИМН"
     * @param store         значение для поля "Склад"
     * @param productGroup  значение для поля "Товарная группа"
     * @param financingType значение для поля "Финансирование"
     */
    public void setFieldsValues(String nameLS_IMN, String store, String productGroup, String financingType)
    {
        if ( nameLS_IMN != null)    { getNameLS_IMN_f().setValue(nameLS_IMN);}
        if ( store != null)         { getStore_f().setValue(store);}
        if ( productGroup != null)  { getProductGroup_f().setValue(productGroup);}
        if ( financingType != null) { getFinancingType_f().setValue(financingType);}
    }


    /** ------------------------- Кнопки на странице спецификации ------------------------- */

    /**
     * Нажимает кнопку "Найти" на странице "Спецификации"
     */
    public void clickFindButton()
    {
        getBatchListContainer().getFilter().clickFindButton();
    }

    /**
     * Нажимает кнопку "Добавить" на странице "Спецификации" в контейнере "batchList"
     */
    public void clickAddButton()
    {
        getAddSpecButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" на странице "Спецификации" в контейнере "Спецификации"
     */
    public void clickEditSpecButton()
    {
        getEditSpecButton().click();
    }

    public void clickExecuteSpecButton(){ getExecuteSpecButton().click();}

    /** Действия c таблицей в контейнере "Спецификации" */

    public int checkTableValues(String nameLS_IMN_st, String creator_st, String count_st, String price_st, String sum_st, String financing_st, String unit_st)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( nameLS_IMN_st != null )    { columnsAndValues.put("Наименование ЛС и ИМН", nameLS_IMN_st);}
        if ( creator_st != null )       { columnsAndValues.put("Производитель", creator_st);}
        if ( count_st != null )         { columnsAndValues.put("Количество", count_st);}
        if ( unit_st != null )          { columnsAndValues.put("Ед. изм.", unit_st);}
        if ( price_st != null )         { columnsAndValues.put("Цена", price_st);}
        if ( sum_st != null )           { columnsAndValues.put("Сумма", sum_st);}
        if ( financing_st != null )     { columnsAndValues.put("Финансирование", financing_st);}

        row = getWriteOffSpecListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Нажимает кнопку "Назад"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }
}

