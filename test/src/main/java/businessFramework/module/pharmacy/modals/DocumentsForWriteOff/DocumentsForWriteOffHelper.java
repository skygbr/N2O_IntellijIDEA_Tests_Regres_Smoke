package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DocumentsForWriteOffHelper extends Page implements Values
{
    /** Модальное окно - "Документ на списание" */

    private Page page = Page.getInstance();

    public DocumentsForWriteOffHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDocForWriteOffModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /** ----------------- Поля в модальном окне ---------------------*/

    /**
     * @return поле "Тип документа"
     */
    public Classifier getDocType_f()
    {
        return getDocForWriteOffModal().getForm().getClassifier("docType");
    }

    /**
     * @return поле "Номер"
     */
    public InputText getNumber_f()
    {
        return getDocForWriteOffModal().getForm().getInputText("docNumber");
    }

    /**
     * @return поле "Дата"
     */
    public InputDate getDate_f()
    {
        return getDocForWriteOffModal().getForm().getInputDate("docDate");
    }

    /**
     * @return поле "Склад"
     */
    public Classifier getStore_f()
    {
        return getDocForWriteOffModal().getForm().getClassifier("sendStore");
    }

    /**
     * @return поле "Операция расхода"
     */
    public Classifier getStoreOperation_f()
    {
        return getDocForWriteOffModal().getForm().getClassifier("storeOpr");
    }

    /**
     * @return поле "Источник финансирования"
     */
    public SelectTree getFinancingSource_f()
    {
        return getDocForWriteOffModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return поле "Причина списания"
     */
    public Classifier getReason_f()
    {
        return getDocForWriteOffModal().getForm().getClassifier("reason");
    }

    /**
     * @return поле "Товарная группа"
     */
    public Classifier getProductGroup_f()
    {
        return getDocForWriteOffModal().getForm().getClassifier("comGroup");
    }

    /**
     * @return поле "Примечание"
     */
    public TextArea getComment_f()
    {
        return getDocForWriteOffModal().getForm().getTextArea("note");
    }

    /**
     * @return кнопку "Подтвердить"
     */
    public Button getApplyDocButton()
    {
        return getDocForWriteOffModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
