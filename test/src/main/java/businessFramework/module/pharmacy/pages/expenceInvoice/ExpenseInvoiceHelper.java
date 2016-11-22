package businessFramework.module.pharmacy.pages.expenceInvoice;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ExpenseInvoiceHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public ExpenseInvoiceHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получает контейнер "Расходные накладные"
     * @return контейнер "Расходные накладные"
     */
    public Container getExpInvoiceListContainer()
    {
        return getContainer("expInvoiceList");
    }

    /**
     * Получает контейнер "Спецификации"
     * @return контейнер "Спецификации"
     */
    public Container getExpSpecContainer()
    {
        return getContainer("expSpecList");
    }


    /**
     * @return Получает таблицу "Расходные накладные" в контейнере expInvoiceList
     */
    public Table getExpInvoiceListTable()
    {
        return getExpInvoiceListContainer().getTable();
    }

    /* -----------------------------  Фильтр на странице "Расходные накладные" ----------------------------- */

    /**
     * Получает фильтр в контейнере "Расходные накладные"
     * @return фильтр в контейнере "Расходные накладные"
     */
    public Filter getFilterExpInvoice()
    {
        return getExpInvoiceListContainer().getFilter();
    }
    /**
     * @return Поле "Дата документа" в фильтре
     */
    public InputDate getDocumentDate()
    {
        return getFilterExpInvoice().getInputDate("docDate");
    }

    /**
     * @return Поле "Номер документа" в фильтре
     */
    public InputText getDocumentNumber() {
        return getFilterExpInvoice().getInputText("docNumber");
    }

    /* ----------------------------- Кнопки в контейнере "Расходные накладные" на странице "Расходные накладные" ----------------------------- */

    /**
     * @return кнпоку "Добавить" на странице "Расходные накладные"
     */
    public Button getAddExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" на странице "Расходные накладные"
     */
    public Button getEditExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Копировать" на странице "Расходные накладные"
     */
    public Button getCopyExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(COPY_BUTTON);
    }

    /**
     * @return кнопку "Просмотр" на странице "Расходные накладные"
     */
    public Button getViewExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Провести" на странице "Расходные накладные"
     */
    public Button getExecuteExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Расходные накладные" на странице "Расходные накладные"
     */
    public Button getDeleteExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return кнопку "Вернуть" в контейнере "Расходные накладные" на странице "Расходные накладные"
     */
    public Button getCancelExecutionExpInvoiceButton()
    {
        return getExpInvoiceListContainer().getButton(CANCEL);
    }

    /* ----------------------------- Кнопки в контейнере "Спецификация" на странице "Расходные накладные" ----------------------------- */

    /**
     * @return кнопку "Добавить" в контейнере "Спецификация"
     */
    public Button getAddSpecificationButton()
    {
        return getExpSpecContainer().getButton(CREATE_BUTTON);
    }


    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Расходные накладные" в контейнере "Расходные накладные"
     */
    public Dialog getConfirmModal()
    {
        return page.getDialog(); // Получает последнее активное модальное окно ( ожидается окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Расходные накладные" в контейнере "Расходные накладные")
    }


}
