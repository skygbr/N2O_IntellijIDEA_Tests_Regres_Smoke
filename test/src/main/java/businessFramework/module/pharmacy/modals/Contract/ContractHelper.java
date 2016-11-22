package businessFramework.module.pharmacy.modals.Contract;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ContractHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public ContractHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getContractModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ----------------- Поля в модальном окне "Контакт" ----------------- */

    /**
     * @return Классифаер "Тип документа"
     */
    public Classifier getDocumentType()
    {
        return getContractModal().getForm().getClassifier("finContractType");
    }

    /**
     * @return Текстовое поле "Номер"
     */
    public InputText getNumberField()
    {
        return getContractModal().getForm().getInputText("number");
    }

    /**
     * @return Текстовое поле "Наименование"
     */
    public InputText getNameField()
    {
        return getContractModal().getForm().getInputText("name");
    }

    /**
     * @return Поле даты "Дата договора"
     */
    public InputDate getContractDateField()
    {
        return getContractModal().getForm().getInputDate("docDate");
    }

    /**
     * @return Поле даты "Действует"
     */
    public InputDate getValidDateField()
    {
        return getContractModal().getForm().getInputDate("validDate");
    }

    /**
     * @return Поле даты "Начало действия"
     */
    public InputDate getBeginDateField()
    {
        return getContractModal().getForm().getInputDate("validDate_begin");
    }

    /**
     * @return Поле даты "Окончание действия"
     */
    public InputDate getEndDateField()
    {
        return getContractModal().getForm().getInputDate("validDate_end");
    }

    /**
     * @return Текстовое поле "Сумма"
     */
    public InputText getSumField()
    {
        return getContractModal().getForm().getInputText("sum");
    }

    /**
     * @return Классифаер "Финансирование"
     */
    public SelectTree getFinancingField()
    {
        return getContractModal().getForm().getSelectTree("fundSource");
    }

    /**
     * @return Классифаер "Поставщик"
     */
    public Classifier getProviderField()
    {
        return getContractModal().getForm().getClassifier("provider");
    }

    /**
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getContractModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * @return текстареа "Комментарий"
     */
    public TextArea getCommentField()
    {
        return getContractModal().getForm().getTextArea("comment");
    }
}
