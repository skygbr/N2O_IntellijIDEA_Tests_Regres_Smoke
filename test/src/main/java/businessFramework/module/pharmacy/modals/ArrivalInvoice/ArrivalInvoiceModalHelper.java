package businessFramework.module.pharmacy.modals.ArrivalInvoice;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ArrivalInvoiceModalHelper extends Page implements Values
{
    public ArrivalInvoiceModalHelper(ApplicationManager app)
    {
        super(app);
    }

    private Page page = Page.getInstance();

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getArrInvoiceModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ---------------------- Поля на форме модального окна "Приходная накладная" ----------------------------- */

    /* -------------------------------- Внешние реквизиты ----------------------------------------- */

    /**
     * @return поле Тип документа
     */
    public Classifier getExtDocumentType()
    {
        return  getModal().getForm().getClassifier("extDocType");
    }

    /**
     * @return поле Префикс-номер
     */
    public InputText getExtDocumentNumber()
    {
        return  getModal().getForm().getInputText("extDocNumber");
    }

    /**
     * @return поле Дата
     */
    public InputDate getExtDocumentDate()
    {
        return getModal().getForm().getInputDate("extDocDate");
    }

    /* --------------------------------- Внутренние реквизиты ---------------------------------------- */

    /**
     * @return поле Тип документа
     */
    public Classifier getIntDocumentType()
    {
        return  getModal().getForm().getClassifier("docType");
    }

    /**
     * @return поле Префикс-номер
     */
    public InputText getIntDocumentNumber()
    {
        return  getModal().getForm().getInputText("docNumber");
    }

    /**
     * @return поле Дата
     */
    public InputDate getIntDocumentDate()
    {
        return getModal().getForm().getInputDate("docDate");
    }

    /* --------------------------------- Поставщик ---------------------------------------- */

    /**
     * @return поле Поставщик
     */
    public Classifier getContractor()
    {
        return getModal().getForm().getClassifier("contractor");
    }

    /**
     * @return поле Грузоотправитель
     */
    public Classifier getShipper()
    {
        return getModal().getForm().getClassifier("shipper");
    }

    /* --------------------------------- Получатель ---------------------------------------- */

    /**
     * @return поле Склад
     */
    public Classifier getRecipient()
    {
        return getModal().getForm().getClassifier("recipient");
    }

    /**
     * @return поле Складская операция
     */
    public Classifier getStoreOperation()
    {
        return getModal().getForm().getClassifier("storeOpr");
    }

    /**
     * @return поле Финансирование
     */
    public SelectTree getFundSource()
    {
        return getModal().getForm().getSelectTree("fundSource");
    }

    public Classifier getFundSources()
    {
        return getModal().getForm().getClassifier("fundSource");
    }

     /* ------------------------------------------------------------------------------------------ */

    /**
     * @return поле Сумма плановая(руб.)
     */
    public InputText getAmountPlanned()
    {
        return  getModal().getForm().getInputText("amountPlan");
    }

    /**
     * @return поле Сумма фактическая (руб.)
     */
    public InputText getAmountFact()
    {
        return  getModal().getForm().getInputText("amountFact");
    }

    /**
     * @return поле Префикс-номер контракта
     */
    public InputText getContractNumber()
    {
        return  getModal().getForm().getInputText("baseDoc.number");
    }

    /**
     * @return поле Дата контракта
     */
    public InputDate getContractDate()
    {
        return getModal().getForm().getInputDate("baseDoc.date");
    }

    /**
     * @return поле Контракт/Договор
     */
    public Classifier getContract()
    {
        return getModal().getForm().getClassifier("baseDoc");
    }

    /**
     * @return поле Способ закупки
     */
    public Classifier getProcurementMethod()
    {
        return getModal().getForm().getClassifier("procurementMethod");
    }

    /**
     * @return поле Примечание
     */
    public TextArea getNote()
    {
        return  getModal().getForm().getTextArea("note");
    }

    /* ------------------------------------ Кнопки ----------------------------*/

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveArrInvoiceButton()
    {
        return getArrInvoiceModal().getButton(N2O_CONFIRM_BUTTON);
    }
}