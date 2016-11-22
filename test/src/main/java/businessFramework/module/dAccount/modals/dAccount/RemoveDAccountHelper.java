package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

public class RemoveDAccountHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public RemoveDAccountHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Классифаер "Причина удаления"
     */
    public Classifier getRemoveReasonField()
    {
        return getDAccountModal().getForm().getClassifier("rmv_reason");
    }

    /**
     * @return Поле для даты "Описание причины удаления"
     */
    public InputText getRemoveDescriptionField()
    {
        return getDAccountModal().getForm().getInputText("rmv_descr");
    }
}
