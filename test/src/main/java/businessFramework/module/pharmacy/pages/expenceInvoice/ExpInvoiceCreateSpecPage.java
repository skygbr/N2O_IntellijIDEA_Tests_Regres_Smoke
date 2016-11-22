package businessFramework.module.pharmacy.pages.expenceInvoice;


import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExpInvoiceSpecModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

public class ExpInvoiceCreateSpecPage extends ExpInvoiceCreateSpecHelper
{

    public int row = 0;

    public ExpInvoiceCreateSpecPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна добавления спецификации в этом классе, тк это модальное окно открывается со страницы "Создание спецификации".
     */
    public ExpInvoiceSpecModal getExpInvoiceSpecModal()
    {
        return new ExpInvoiceSpecModal(app);
    }

    /* --------------------- Действия при создании спецификации --------------------- */

    /**
     * Проверка значений в полях в фильтре при создании спецификации
     *
     * @param storeValue        Значение поля "Склад"
     * @param productGroupValue Значение поля "Товарная группа"
     * @param finSourceValue    Значение поля "Источник фин."
     */
    public void checkFilterFieldsValues(String storeValue, String productGroupValue, String finSourceValue)
    {
        if (storeValue != null)         { getStoreField_F().assertValue_equals(storeValue); }
        if (productGroupValue != null)  { getProductGroupField_F().assertValue_equals(productGroupValue); }
        if (finSourceValue != null)     { getFinSourceField_F().assertValue_equals(finSourceValue); }
    }

    /**
     * Устанавливает значения в поля в фильтре при создании спецификации и нажимает кнопку "Найти"
     *
     * @param nameLS_IMN    поле "Наименование ЛС и ИМН"
     * @param store         поле "Склад"
     * @param productGroup  поле "Товарная группа"
     * @param finSource     поле "Источник фин."
     */
    public void setFilterFieldsValuesAndPressFindBtn(String nameLS_IMN, String store, String productGroup, String finSource)
    {
        if (nameLS_IMN != null)     { getNameLS_IMNField_F().setValue(nameLS_IMN); }
        if (store != null)          { getStoreField_F().setValue(store); }
        if (productGroup != null)   { getProductGroupField_F().setValue(productGroup); }
        if (finSource != null)      { getFinSourceField_F().setValue(finSource); }

        getBatchListFilter().clickFindButton();
    }

    /**
     * Нажимает кнопку "Добавить" в контейнере BatchList при создании спецификации
     */
    public void clickAddSpecBatchListBtn()
    {
        getAddSpecBatchListButton().click();
    }


    /**
     * Проверяет значения полей в таблице "Спецификация" после добавления спецификации на странице "Расходные накладные - ... добавление спецификации"
     *
     * @param nameLS_IMN значение столбца "Наименование ЛС и ИМН"
     * @param creator    значение столбца "Производитель"
     * @param sold       значение столбца "Отпущено"
     * @param financing  значение столбца "Финансирование"
     * @param unit       значение столбца "Ед.изм."
     * @param price      значение столбца "Цена"
     * @param sum        значение столбца "Сумма"
     */

    public int checkTableValues(String nameLS_IMN, String creator, String sold, String financing, String unit, String price, String sum)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (nameLS_IMN != null)     { columnsAndValues.put("Наименование ЛС и ИМН", nameLS_IMN); }
        if (creator != null)        { columnsAndValues.put("Производитель", creator); }
        if (sold != null)           { columnsAndValues.put("Отпущено", sold); }
        if (financing != null)      { columnsAndValues.put("Финансирование", financing); }
        if (unit != null)           { columnsAndValues.put("Ед.изм.", unit); }
        if (price != null)          { columnsAndValues.put("Цена", price); }
        if (sum != null)            { columnsAndValues.put("Сумма", sum); }

        row = getSpecificationsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Спецификации" на странице "Расходные накладные - ... добавление спецификации"
     */
    public void clickEditSpecButton()
    {
        getEditSpecButton().click();
    }

    /**
     * Нажимает кнопку "Назад" на странице "Расходные накладные - ... добавление спецификации"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }
}
