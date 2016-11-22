package businessFramework.module.pharmacy.pages.applications;


import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PharmacyApplicationsPage extends PharmacyApplicationsHelper
{
    public PharmacyApplicationsPage(ApplicationManager app)
    {
        super(app);
    }

    public int rowApp;
    public int rowSpec;

    /**
     * Открывает фильтр в контейнере "Расходные накладные"
     */
    public void openFilterForApplicationsList()
    {
        getApplicationDocListContainer().showFilter();
    }

    /**
     * Проверка значения в поле дат
     */
    public void checkDatesValues()
    {
        String beginValue = getDocDateField().getBeginValue();
        String endValue = getDocDateField().getEndValue();

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("MM.yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String expectedBeginValue = "01." + formatBegin.format(nowDate);
        String expectedEndValue = formatEnd.format(nowDate);

        assertThat(beginValue, equalTo(expectedBeginValue));
        assertThat(endValue, equalTo(expectedEndValue));

    }

    public void checkFilterFieldsValues(String docStatus)
    {
        if (docStatus != null) { getDocStatusField().assertValue(docStatus);}
    }

    /** ---------------------------- Кнопки в контейнере "Заявки" ---------------------------- */

    /**
     * Нажимает кнопку "Добавить"
     */
    public void clickAddAppButton()
    {
        getAddApplicationButton().click();
    }

    /**
     * Нажимает кнопку "Изменить"
     */
    public void clickEditAppButton()
    {
        getUpdateApplicationButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр"
     */
    public void clickViewAppButton()
    {
        getViewApplicationButton().click();
    }

    /**
     * Нажимает кнопку "Удалить"
     */
    public void clickDeleteAppButton()
    {
        getDeleteApplicationButton().click();
    }

    /** ---------------------------- Кнопки в контейнере "Спецификации" ---------------------------- */

    /**
     * Нажимает кнопку "Добавить"
     */
    public void clickAddSpecButton()
    {
        getAddSpecButton().click();
    }

    /**
     * Нажимает кнопку "Изменить"
     */
    public void clickEditSpecButton()
    {
        getEditSpecButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр"
     */
    public void clickViewSpecButton()
    {
        getViewSpecButton().click();
    }

    /**
     * Нажимает кнопку "Утвердить"
     */
    public void clickApproveButton()
    {
        getApproveAppButton().click();
    }

    /**
     * Нажимает кнпоку "Отменить утверждение"
     */
    public void clickCancelApproveButton()
    {
        getCancelApproveAppButton().click();
    }

    /**
     * Проверяет значения в столбцах в таблице "Заявки" на соответствие ожидаемым
     *
     * @param appType       ожидаемое значение столбца "Тип"
     * @param prefixNumber  ожидаемое значение столбца "Номер"
     * @param date          ожидаемое значение столбца "Дата"
     * @param year          ожидаемое значение столбца "Год"
     * @param department    ожидаемое значение столбца "Подразделение"
     * @param store         ожидаемое значение столбца "Склад"
     * @param status        ожидаемое значение столбца "Финансирование"
     * @param financing     ожидаемое значение столбца "Тов. группа"
     * @param productGroup  ожидаемое значение столбца "Статус"
     *
     * @return номер строчки, найденной по этим параметрам
     */
    public int checkAppTableValues(String appType, String prefixNumber, String date, String year, String department, String store, String status, String financing, String productGroup)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( appType != null)       { columnsAndValues.put("Тип", appType);}
        if ( prefixNumber != null)  { columnsAndValues.put("Номер", prefixNumber);}
        if ( date != null)          { columnsAndValues.put("Дата", date);}
        if ( year != null)          { columnsAndValues.put("Год", year);}
        if ( department != null)    { columnsAndValues.put("Подразделение", department);}
        if ( store != null)         { columnsAndValues.put("Склад", store);}
        if ( financing != null)     { columnsAndValues.put("Финансирование", financing);}
        if ( productGroup != null)  { columnsAndValues.put("Тов. группа", productGroup);}
        if ( status != null)        { columnsAndValues.put("Статус", status);}

        rowApp = getApplicationsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return rowApp;
    }

    /**
     * Проверяет значения в столбцах в таблице "Спецификации" на соответствие ожидаемым
     *
     * @param nameLS_IMN    ожидаемое значение столбца "Наименование ЛС и ИМН"
     * @param count         ожидаемое значение столбца "Количество"
     * @param unit          ожидаемое значение столбца "Ед.изм."
     * @param price         ожидаемое значение столбца "Цена"
     * @param sum           ожидаемое значение столбца "Сумма"
     *
     * @return номер строчки, найденной по этим параметрам
     */
    public int checkSpecTableValues(String nameLS_IMN, String count, String unit, String price, String sum)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( nameLS_IMN != null)    { columnsAndValues.put("Наименование ЛС и ИМН", nameLS_IMN);}
        if ( count != null)         { columnsAndValues.put("Количество", count);}
        if ( unit != null)          { columnsAndValues.put("Ед.изм.", unit);}
        if ( price != null)         { columnsAndValues.put("Цена", price);}
        if ( sum != null)           { columnsAndValues.put("Сумма", sum);}

        rowSpec = getSpecificationsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return rowSpec;
    }
}
