package businessFramework.module.pharmacy.modals.Request;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class RequestHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public RequestHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getRequestModal() {
        return page.getModal();
    }

        /* ----------------- Поля в модальном окне "Контакт" ----------------- */

    /**
     * @return текстовое поле "номер"
     */
    public InputText getRequestNumber() {
        return getRequestModal().getForm().getInputText("docNumber");
    }

    /**
     * @return Поле даты "Дата*"
     */
    public InputDate getRequestDate() {
        return  getRequestModal().getForm().getInputDate("docDate");
    }

    /**
     * @return классифаер "Тип документа"
     */
    public Classifier getRequestDocumentType() {
        return getRequestModal().getForm().getClassifier("docType");
    }

    /**
     * @return классифаер "Склад-отправитель*"
     */
    public Classifier getRequestSendStore() {
        return getRequestModal().getForm().getClassifier("sendStore");
    }

    /**
     * @return классифаер "Склад-получатель*"
     */
    public Classifier getRequestStore() {
        return getRequestModal().getForm().getClassifier("recStore");
    }

    /**
     * @return классифаер "Финансирование"
     */
    public SelectTree getRequestFundingSource() {
        return getRequestModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return классифаер "Товарная группа"
     */
    public Classifier getRequestCommodityGroup() {
        return getRequestModal().getForm().getClassifier("comGroup");
    }

    /**
     * @return классифаер "Доверенность"
     */
    public Classifier getRequestTrustDocument() {
        return getRequestModal().getForm().getClassifier("trustDoc");
    }

    /**
     * @return кнопка "Сохранить"
     */
    public Button getSaveRequestButton() {
        return getRequestModal().getButton(N2O_CONFIRM_BUTTON);
    }
}