package businessFramework.module.pharmacy.modals.ProductionDocument;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 12.11.2015
 */
public class ProdDocModalHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public ProdDocModalHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     *
     * @return Это модальное окно
     */
    public Modal getProdDocModal() {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton()
    {
        return getProdDocModal().getButton(N2O_CONFIRM_BUTTON);
    }


    /** ---------------- Поля на форме в модальном окне "Документ на изготовление" ---------------- */

    /**
     * @return поле "Тип документа"
     */
    public Classifier getDocTypeField() {
        return getProdDocModal().getForm().getClassifier("docType");
    }

    /**
     * @return поле "Номер"
     */
    public InputText getDocNumberField() {
        return getProdDocModal().getForm().getInputText("docNumber");
    }

    /**
     * @return поле "Дата"
     */
    public InputDate getDocDateField() {
        return getProdDocModal().getForm().getInputDate("docDate");
    }

    /**
     * @return поле "Тип основания"
     */
    public Classifier getBaseDocTypeField() {
        return getProdDocModal().getForm().getClassifier("baseDocType");
    }

    /**
     * @return поле "Номер основания"
     */
    public InputText getBaseDocNumberField() {
        return getProdDocModal().getForm().getInputText("baseDocNumber");
    }

    /**
     * @return поле "Пропись"
     */
    public Classifier getFormulaDocField() {
        return getProdDocModal().getForm().getClassifier("formulaDoc");
    }

    /**
     * @return поле "Дата основания"
     */
    public InputDate getBaseDateField() {
        return getProdDocModal().getForm().getInputDate("baseDocDate");
    }


    /**
     * @return поле "Склад"
     */
    public Classifier getStoreField() {
        return getProdDocModal().getForm().getClassifier("sendStore");
    }

    /**
     * @return поле "Финансирование"
     */
    public SelectTree getFundSourceField() {
        return getProdDocModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return поле "Модификация
     */
    public Classifier getModifField() {
        return getProdDocModal().getForm().getClassifier("modif");
    }

    /**
     * @return поле "Операция прихода"
     */
    public Classifier getArrivalOperationField() {
        return getProdDocModal().getForm().getClassifier("arrStoreOpr");
    }

    /**
     * @return поле "Операция расхода"
     */
    public Classifier getExpOperationField() {
        return getProdDocModal().getForm().getClassifier("expStoreOpr");
    }

    /**
     * @return поле "Кол-во МНЕИ"
     */
    public InputText getMneiQuantity() {
        return getProdDocModal().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле "Кол-во"
     */
    public InputText getQuantity() {
        return getProdDocModal().getForm().getInputText("quantity");
    }

    /**
     * @return поле "Цена"
     */
    public InputText getPriceField() {
        return getProdDocModal().getForm().getInputText("price");
    }

    /**
     * @return поле "Сумма"
     */
    public InputText getAmountField() {
        return getProdDocModal().getForm().getInputText("amount");
    }

    /**
     * @return поле "Серия"
     */
    public InputText getSeriesField() {
        return getProdDocModal().getForm().getInputText("series");
    }

    /**
     * @return поле "Сертификат"
     */
    public InputText getCertificatefield() {
        return getProdDocModal().getForm().getInputText("certificate");
    }

    /**
     * @return поле "Срок годности"
     */
    public InputDate getExpireDateField() {
        return getProdDocModal().getForm().getInputDate("expireDate");
    }

    /**
     * @return поле "Дата производства"
     */
    public InputDate getProdDateField() {
        return getProdDocModal().getForm().getInputDate("prodDate");
    }

    /**
     * @return поле "Примечание"
     */
    public InputText getNoteField() {
        return getProdDocModal().getForm().getInputText("note");
    }

    /**
     * @return поле "Номер документа при типе Изгот."
     */
    public Classifier getAppProdDocNumberField() {
        return getProdDocModal().getForm().getClassifier("appProdDocNumber");
    }
}
