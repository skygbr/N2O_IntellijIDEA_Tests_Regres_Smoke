package businessFramework.module.pharmacy.pages.arrivalInvoice;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.ArrivalInvoice.ArrivalInvoiceModal;
import businessFramework.module.pharmacy.modals.ArrivalInvoiceSpecification.ArrivalInvoiceSpecificationModal;
import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExecuteDocumentModal;
import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExpenseInvoiceModal;
import businessFramework.module.pharmacy.pages.ArrivalInvoiceSpecifications.ArrivalInvoiceSpecificationsPage;
import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ArrivalInvoicePage extends ArrivalInvoiceHelper implements Values
{
    public ArrivalInvoicePage(ApplicationManager app)
    {
        super(app);
    }

    /* ------------------------------ Действия с фильтром на странице "Приходные накладные" ----------------------------------*/

    /**
     * Открывает фильтр в контейнере "Приходные накладные"
     */
    public void openFilterForArrInvoice()
    {
        getArrivalInvoicesContainer().showFilter();
    }

    /**
     * Проверка значения в поле дат
     */
    public void checkFilterDatesValues()
    {
        String beginValue = getFilterDocumentDate().getBeginValue();  // 01.01.2015
        String endValue = getFilterDocumentDate().getEndValue();      // 01.04.2015

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("MM.yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String expectedBeginValue = "01." + formatBegin.format(nowDate);
        String expectedEndValue = formatEnd.format(nowDate);

        assertThat(beginValue, equalTo(expectedBeginValue));
        assertThat(endValue, equalTo(expectedEndValue));

    }

    /**
     * Фильтрация таблицы "Приходные документы" по номеру документа
     *
     * @param documentNumber номер документа
     */
    public void filterArrivalInvoiceByNumber(String documentNumber) {
        getFilterDocumentNumber().setValue(documentNumber);
        getFilterArrInvoice().clickFindButton();
    }

    /* ------------------------------ Нажатие кнопок на странице "Приходные накладные" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Приходные накладные"
     */
    public void clickAddArrInvoiceButton()
    {
        getAddArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Приходные накладные"
     */
    public void clickEditArrInvoiceButton()
    {
        getEditArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Копировать" в контейнере "Приходные накладные"
     */
    public void clickCopyArrInvoiceButton()
    {
        getCopyArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр" в контейнере "Приходные накладные"
     */
    public void clickViewArrInvoiceButton()
    {
        getViewArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Провести" в контейнере "Приходные накладные"
     */
    public void clickExecuteArrInvoiceButton()
    {
        getExecuteArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Провести" в контейнере "Приходные накладные"
     */
    public void clickCreateExpInvoiceButton()
    {
        getCreateExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Приходные накладные"
     */
    public void clickDeleteArrInvoiceButton()
    {
        getDeleteArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Вернуть" в контейнере "Приходные накладные"
     */
    public void clickCancelExecutionArrInvoiceButton()
    {
        getCancelExecutionArrInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификация"
     */
    public void clickAddSpecificationButton()
    {
        getAddSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Спецификация"
     */
    public void clickUpdateSpecificationButton()
    {
        getUpdateSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр" в контейнере "Спецификация"
     */
    public void clickViewSpecificationButton()
    {
        getViewSpecificationButton().click();
    }

    /* -------------------- Приходная накладная ------------------------- */

    /**
     * Получение модального окна "Приходная накладная " в этом классе, тк это модальное окно открывается со страницы "Приходные накладные".
     */
    public ArrivalInvoiceModal getArrivalInvoiceModal()
    {
        return new ArrivalInvoiceModal(app);
    }

    /**
     * Получение страницы "Создание спецификации" в этом классе, тк эта страница открывается со страницы "Приходные накладные".
     *
     * @return страницу "Создание спецификации"
     */
    public ArrivalInvoiceSpecificationsPage getArrivalInvoiceSpecificationsPage()
    {
        return new ArrivalInvoiceSpecificationsPage(app);
    }

    /**
     * Получение модального окна "Спецификация" в этом классе, тк это модальное окно открывается со страницы "Приходные накладные".
     */
    public ArrivalInvoiceSpecificationModal getArrivalInvoiceSpecificationModal()
    {
        return new ArrivalInvoiceSpecificationModal(app);
    }

    /**
     * Получение модального окна "Проведение накладной" в этом классе, тк это модальное окно открывается со страницы "Приходные накладные".
     */
    public ExecuteDocumentModal getExecuteArrivalInvoiceModal()
    {
        return new ExecuteDocumentModal(app);
    }

    /**
     * Получение модального окна "Проведение накладной" в этом классе, тк это модальное окно открывается со страницы "Приходные накладные".
     */
    public ExpenseInvoiceModal getCreateExpInvoiceModal()
    {
        return new ExpenseInvoiceModal(app);
    }

    /**
     * Проверяет значение в тех столбцах таблицы, значения для которых указаны в @param
     *
     * @param numberValue           №
     * @param dateValue             Дата
     * @param executionDateValue    Проводка
     * @param recipientValue        Получатель
     * @param contractorValue       Поставщик
     * @param plannedAmountValue    Плановая
     * @param executedAmountValue   Фактическая
     * @param contract              Договор/контракт
     * @param invoiceValue          Тов. накл.
     * @param financingValue        Финансирование
     * @return номер строки в таблице, которая подходит под данные
     */
    public int checkInvoiceTableValues(String numberValue, String dateValue, String executionDateValue, String recipientValue,
                                       String contractorValue, String plannedAmountValue, String executedAmountValue,
                                       String contract, String invoiceValue, String financingValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null)            { columnsAndValues.put("№", numberValue);}
        if (dateValue != null)              { columnsAndValues.put("Дата", dateValue);}
        if (executionDateValue != null)     { columnsAndValues.put("Проводка", executionDateValue);}
        if (recipientValue != null )        { columnsAndValues.put("Получатель", recipientValue);}
        if (contractorValue !=null)         { columnsAndValues.put("Поставщик", contractorValue);}
        if (plannedAmountValue != null)     { columnsAndValues.put("Плановая", plannedAmountValue);}
        if (executedAmountValue != null)    { columnsAndValues.put("Фактическая", executedAmountValue);}
        if (contract != null)               { columnsAndValues.put("Договор/контракт", contract);}
        if (invoiceValue != null)           { columnsAndValues.put("Тов. накл.", invoiceValue);}
        if (financingValue != null)         { columnsAndValues.put("Финансирование", financingValue);}

        return getArrivalInvoicesTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

    /* -------------------- Спецификация ------------------------- */

    /**
     * Проверяет значение в тех столбцах таблицы, значения для которых указаны в @param
     *
     * @param modification      Наименование ЛС и ИМН
     * @param producer          Производитель
     * @param series            Серия партии
     * @param expireDate        Срок годности
     * @param quantity          Количество
     * @param measure           Ед.изм.
     * @param price             Цена
     * @param contractPrice     Цена контракта
     * @param amount            Сумма
     *
     * @return номер строки в таблице, которая подходит под данные
     */
    public int checkSpecificationsTableValues(String modification, String producer, String series, String expireDate,
                                String quantity, String measure, String price, String contractPrice, String amount)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (modification != null)   { columnsAndValues.put("Наименование ЛС и ИМН", modification);}
        if (producer != null)       { columnsAndValues.put("Производитель", producer);}
        if (series != null)         { columnsAndValues.put("Серия партии", series);}
        if (expireDate != null )    { columnsAndValues.put("Срок годности", expireDate);}
        if (quantity !=null)        { columnsAndValues.put("Количество", quantity);}
        if (measure != null)        { columnsAndValues.put("Ед.изм.", measure);}
        if (price != null)          { columnsAndValues.put("Цена", price);}
        if (contractPrice != null)  { columnsAndValues.put("Цена контракта", contractPrice);}
        if (amount != null)         { columnsAndValues.put("Сумма", amount);}

        return getSpecificationsListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

}