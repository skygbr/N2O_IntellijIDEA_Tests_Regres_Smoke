package businessFramework.module.pharmacy.modals.ExpenseInvoice;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ExpenseInvoiceModalHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public ExpenseInvoiceModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getExpInvoiceModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ---------------------- Поля на форме модального окна "Расходная накладная" ----------------------------- */

    /* ---------------------- Реквизиты документа ------------------------------------------------------------- */
    /**
     * @return Поле "Тип документа"
     */
    public Classifier getDocumentTypeField()
    {
        return getExpInvoiceModal().getForm().getClassifier("docType");
    }

    /**
     * @return Поле "Номер"
     */
    public InputText getNumberField()
    {
        return getExpInvoiceModal().getForm().getInputText("docNumber");
    }

    /**
     * @return Поле "Дата"
     */
    public InputDate getDateField()
    {
        return getExpInvoiceModal().getForm().getInputDate("docDate");
    }

    /* ---------------------- Документ основания -------------------------------------------------------------- */

    /**
     * @return Поле "Требование"
     */
    public Classifier getRequirementField()
    {
        return getExpInvoiceModal().getForm().getClassifier("orderDoc");
    }

    /**
     * @return Поле "Доверенность"
     */
    public Classifier getTrustField()
    {
        return getExpInvoiceModal().getForm().getClassifier("trustDoc");
    }

    /* ---------------------- Складские операции -------------------------------------------------------------- */

    /**
     * @return Поле "Отправитель"
     */
    public Classifier getSenderField()
    {
        return getExpInvoiceModal().getForm().getClassifier("sendStore");
    }

    /**
     * @return Поле "Получатель"
     */
    public Classifier getRecipientField()
    {
        return getExpInvoiceModal().getForm().getClassifier("recStore");
    }

    /**
     * @return Поле "МОЛ отправителя"
     */
    public Classifier getSenderMOLField()
    {
        return getExpInvoiceModal().getForm().getClassifier("sendRespEmpPos");
    }

    /**
     * @return Поле "МОЛ получателя"
     */
    public Classifier getRecipientMOLField()
    {
        return getExpInvoiceModal().getForm().getClassifier("recRespEmpPos");
    }

    /**
     * @return Поле "Операция расхода"
     */
    public Classifier getChargeOperationField()
    {
        return getExpInvoiceModal().getForm().getClassifier("storeOprExp");
    }

    /**
     * @return Поле "Операция прихода"
     */
    public Classifier getArrivalOperationField()
    {
        return getExpInvoiceModal().getForm().getClassifier("storeOprArr");
    }

    /* ---------------------- Источники финансирования -------------------------------------------------------- */

    /**
     * @return Поле "Источник финансирования"
     */
    public SelectTree getFinancingSourceTypeField()
    {
        return getExpInvoiceModal().getForm().getSelectTree("fundSource");
    }

    /* ---------------------- Дополнительно ------------------------------------------------------------------- */

    /**
     * @return Поле "Товарная группа"
     */
    public Classifier getProductGroupField()
    {
        return getExpInvoiceModal().getForm().getClassifier("comGroup");
    }

    /**
     * @return Поле "Примечание"
     */
    public TextArea getCommentField()
    {
        return getExpInvoiceModal().getForm().getTextArea("note");
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveExpInvoiceButton()
    {
        return getExpInvoiceModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
