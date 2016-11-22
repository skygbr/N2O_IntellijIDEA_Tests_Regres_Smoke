package businessFramework.module.pharmacy.pages.expenceInvoice;


import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExecuteDocumentModal;
import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExpenseInvoiceModal;
import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ExpenseInvoicePage extends ExpenseInvoiceHelper
{
    public ExpenseInvoicePage(ApplicationManager app)
    {
        super(app);
    }

    public int row = 0;

    /* ------------------------------ Действия с фильтром на странице "Расходные накладные" ----------------------------------*/

    /**
     * Открывает фильтр в контейнере "Расходные накладные"
     */
    public void openFilterForExpInvoice()
    {
        getExpInvoiceListContainer().showFilter();
    }

    /**
     * Проверка значения в поле дат
     */
    public void checkDatesValues()
    {
        String beginValue = getDocumentDate().getBeginValue();  // 01.01.2015
        String endValue = getDocumentDate().getEndValue();      // 01.04.2015

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("MM.yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String expectedBeginValue = "01." + formatBegin.format(nowDate);
        String expectedEndValue = formatEnd.format(nowDate);

        assertThat(beginValue, equalTo(expectedBeginValue));
        assertThat(endValue, equalTo(expectedEndValue));

    }

    /**
     * Фильтрация таблицы "Расходные документы" по номеру документа
     * @param documentNumber номер документа
     */
    public void filterExpenseInvoiceByNumber(String documentNumber)
    {
        getDocumentNumber().setValue(documentNumber);
        getFilterExpInvoice().clickFindButton();
    }

    /* ------------------------------ Нажатие кнопок на странице "Расходные накладные" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Расходные накладные"
     */
    public void clickAddExpInvoiceButton()
    {
        getAddExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Расходные накладные"
     */
    public void clickEditExpInvoiceButton()
    {
        getEditExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Копировать" в контейнере "Расходные накладные"
     */
    public void clickCopyExpInvoiceButton()
    {
        getCopyExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр" в контейнере "Расходные накладные"
     */
    public void clickViewExpInvoiceButton()
    {
        getViewExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Провести" в контейнере "Расходные накладные"
     */
    public void clickExecuteExpInvoiceButton()
    {
        getExecuteExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Расходные накладные"
     */
    public void clickDeleteExpInvoiceButton()
    {
        getDeleteExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Вернуть" в контейнере "Расходные накладные" на странице "Расходные накладные"
     */
    public void clickCancelExecutionExpInvoiceButton()
    {
        getCancelExecutionExpInvoiceButton().click();
    }

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификация"
     */
    public void clickAddSpecificationButton()
    {
        getAddSpecificationButton().click();
    }

    /* -------------------- Расходная накладная ------------------------- */

    /**
     * Получение модального окна "Расходная накладная " в этом классе, тк это модальное окно открывается со страницы "Расходные накладные".
     */
    public ExpenseInvoiceModal getExpenseInvoiceModal()
    {
        return new ExpenseInvoiceModal(app);
    }


    /**
     * Получение страницы "Создание спецификации" в этом классе, тк эта страница открывается со страницы "Расходные накладные".
     * @return страницу "Создание спецификации"
     */
    public ExpInvoiceCreateSpecPage getExpInvoiceCreateSpecPage()
    {
        return new ExpInvoiceCreateSpecPage(app);
    }

    /**
     * Проверяет значение в тех столбцах таблицы, значения для которых указаны в @param
     *
     * @param numberValue           № накладной
     * @param dateValue             Дата
     * @param senderValue           Отправитель
     * @param arrivalOperationValue Операция прихода
     * @param recipientValue        Получатель
     * @param chargeOperationValue  Операция расхода
     * @param sumAmountValue        Фактическая сумма по спецификациям
     *
     * @return номер строчки в таблице, которая подходит по этим данным.
     */
    public int checkTableValues(String numberValue, String dateValue, String senderValue, String arrivalOperationValue, String recipientValue, String chargeOperationValue, String sumAmountValue, String executed)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null)            { columnsAndValues.put("№ накладной", numberValue);}
        if (dateValue != null)              { columnsAndValues.put("Дата", dateValue);}
        if (senderValue != null)            { columnsAndValues.put("Отправитель", senderValue);}
        if (arrivalOperationValue != null ) { columnsAndValues.put("Операция прихода", arrivalOperationValue);}
        if (recipientValue != null)         { columnsAndValues.put("Получатель", recipientValue);}
        if (chargeOperationValue != null)   { columnsAndValues.put("Операция расхода", chargeOperationValue);}
        if (sumAmountValue != null)         { columnsAndValues.put("Фактическая", sumAmountValue);}
        if (executed != null)               { columnsAndValues.put("Проведён", executed);}

        row = getExpInvoiceListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    public void getTableRecordByNumber(String numberValue) {
        Map<String, String> columnsAndValues = new HashMap<>();
        if (numberValue != null) {
            columnsAndValues.put("№ накладной", numberValue);
        }
        getExpInvoiceListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * @return Получение модального окна "Проводка документа" в этом классе, тк это модальное окно открывается со страницы "Расходные накладные".
     */
    public ExecuteDocumentModal getExecuteExpInvoiceModal()
    {
        return new ExecuteDocumentModal(app);
    }



}
