package businessFramework.module.pharmacy.modals.TrustDocument;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author ydolgih
 * @since 20.11.2015
 */
public class TrustDocModalHelper implements Values {

    private Page page = Page.getInstance();
    private String container;

    public Modal getModal() {
        return page.getModal();
    }

    public TrustDocModalHelper() {
        this.container = "main";
    }

    /**
     * @return Поле "Тип документа"
     */
    public Classifier getType() {
        return getModal().getForm().getClassifier("docType");
    }

    /**
     * @return Поле "Номер"
     */
    public InputText getNumber() {
        return getModal().getForm().getInputText("docNumber");
    }

    /**
     * @return Поле "Дата выдачи"
     */
    public InputDate getIssueDate() {
        return getModal().getForm().getInputDate("issueDate");
    }

    /**
     * @return Поле "Дата окончания"
     */
    public InputDate getEndDate() {
        return getModal().getForm().getInputDate("endDate");

    }

    /**
     * @return Поле "Склад"
     */
    public Classifier getStore() {
        return getModal().getForm().getClassifier("store");

    }

    /**
     * @return Поле "Сотрудник"
     */
    public Classifier getEmployee() {
        return getModal().getForm().getClassifier("employeePos");

    }

    public Button getSaveButton() {
        return page.getModal().getButton(N2O_CONFIRM_BUTTON);
    }
}