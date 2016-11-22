package businessFramework.module.pharmacy.modals.TransferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActModalHelper extends Page implements Values {
    public TransferActModalHelper(ApplicationManager app) {
        super(app);
    }
    private Page page = Page.getInstance();

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getTransferActModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ---------------------- Поля на форме модального окна "Акты переброски" ----------------------------- */

    /* ---------------------- Реквизиты документа ------------------------------------------------------------- */
    /**
     * @return Поле "Тип документа"
     */
    public Classifier getDocumentTypeField()
    {
        return getTransferActModal().getForm().getClassifier("docType");
    }

    /**
     * @return Поле "Номер"
     */
    public InputText getNumberField()
    {
        return getTransferActModal().getForm().getInputText("docNumber");
    }

    /**
     * @return Поле "Дата"
     */
    public InputDate getDateField()
    {
        return getTransferActModal().getForm().getInputDate("docDate");
    }


    /* ---------------------- Складские операции -------------------------------------------------------------- */

    /**
     * @return Поле "Отправитель"
     */
    public Classifier getSenderField()
    {
        return getTransferActModal().getForm().getClassifier("sendStore");


    }

    /**
     * @return Поле "Получатель"
     */
    public Classifier getRecipientField()
    {
        return getTransferActModal().getForm().getClassifier("recStore");
    }

    /**
     * @return Поле "МОЛ отправителя"
     */
    public Classifier getSenderMOLField()
    {
        return getTransferActModal().getForm().getClassifier("sendRespEmpPos");
    }

    /**
     * @return Поле "МОЛ получателя"
     */
    public Classifier getRecipientMOLField()
    {
        return getTransferActModal().getForm().getClassifier("recRespEmpPos");
    }

    /**
     * @return Поле "Операция расхода"
     */
    public Classifier getChargeOperationField()
    {
        return getTransferActModal().getForm().getClassifier("storeOprExp");
    }

    /**
     * @return Поле "Операция прихода"
     */
    public Classifier getArrivalOperationField()
    {
        return getTransferActModal().getForm().getClassifier("storeOprArr");
    }

    /* ---------------------- Источники финансирования -------------------------------------------------------- */

    /**
     * @return Поле "Источник финансирования"
     */
    public SelectTree getFinancingSourceTypeField()
    {
        return getTransferActModal().getForm().getSelectTree("fundSource");
    }

    /* ---------------------- Дополнительно ------------------------------------------------------------------- */

    /**
     * @return Поле "Новый источник"
     */
    public Classifier getNewFundingSourceField()
    {
        return getTransferActModal().getForm().getClassifier("newFundSource");
    }

    /**
     * @return Поле "Примечание"
     */
    public TextArea getCommentField()
    {
        return getTransferActModal().getForm().getTextArea("note");
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveTransferActButton()
    {
        return getTransferActModal().getButton(N2O_CONFIRM_BUTTON);
    }
}