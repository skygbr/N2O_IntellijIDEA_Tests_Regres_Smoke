package businessFramework.module.pharmacy.pages.arrivalInvoice;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.Table;


public class ArrivalInvoiceHelper extends Page implements Values
{

    String CREATE_EXP_INVOICE  = "create_exp_invoice";
    public ArrivalInvoiceHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getArrivalInvoicesContainer()
    {
        return getContainer("arrivalInvoices");
    }

    public Container getSpecificationsListContainer()
    {
        return getContainer("arrSpecList");
    }

     /* -----------------------------  Фильтр на странице "Приходные накладные" ----------------------------- */

    /**
     * Получает фильтр в контейнере "Приходные накладные"
     * @return фильтр в контейнере "Приходные накладные"
     */
    public Filter getFilterArrInvoice()
    {
        return getArrivalInvoicesContainer().getFilter();
    }

    /**
     * @return Поле "Дата документа" фильтра
     */
    public InputDate getFilterDocumentDate()
    {
        return getFilterArrInvoice().getInputDate("docDate");
    }

    /**
     * @return Поле "№" фильтра документа
     */
    public InputText getFilterDocumentNumber()
    {
        return getFilterArrInvoice().getInputText("docNumber");
    }

    /* -----------------------------  Компоненты в контейнере "Приходные накладные" ----------------------------- */

    public Table getArrivalInvoicesTable()
    {
        return getArrivalInvoicesContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" на странице "Приходные накладные"
     */
    public Button getAddArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" на странице "Приходные накладные"
     */
    public Button getEditArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Копировать" на странице "Приходные накладные"
     */
    public Button getCopyArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(COPY_BUTTON);
    }

    /**
     * @return кнопку "Просмотр" на странице "Приходные накладные"
     */
    public Button getViewArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Провести" на странице "Приходные накладные"
     */
    public Button getExecuteArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Приходные накладные"
     */
    public Button getDeleteArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return кнопку "Вернуть" в контейнере "Приходные накладные"
     */
    public Button getCancelExecutionArrInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(CANCEL);
    }

    /**
     * @return кнопку "Создать РН" в контейнере "Приходные накладные"
     */
    public Button getCreateExpInvoiceButton()
    {
        return getArrivalInvoicesContainer().getButton(CREATE_EXP_INVOICE);
    }

    /* ----------------------------- Компоненты в контейнере "Спецификация"  ----------------------------- */

    public Table getSpecificationsListTable()
    {
        return getSpecificationsListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" в контейнере "Спецификация"
     */
    public Button getAddSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" в контейнере "Спецификация"
     */
    public Button getUpdateSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Просмотр" в контейнере "Спецификация"
     */
    public Button getViewSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(VIEW_BUTTON);
    }
}