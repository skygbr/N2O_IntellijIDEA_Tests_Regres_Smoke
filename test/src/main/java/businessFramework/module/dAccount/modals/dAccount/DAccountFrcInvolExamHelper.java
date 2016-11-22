package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.TextArea;


public class DAccountFrcInvolExamHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    protected DAccountFrcInvolExamHelper()
    {
        this.container = "c1";
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountFrcInvolExamModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountFrcInvolExamModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountFrcInvolExamModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Поле для даты "Дата"
     */
    public InputDate getExamDtField()
    {
        return getDAccountFrcInvolExamModal().getForm().getInputDate("exam_dt");
    }

    /**
     * @return Текстовое поле "Результат"
     */
    public TextArea getResultField()
    {
        return getDAccountFrcInvolExamModal().getForm().getTextArea("result");
    }

}
