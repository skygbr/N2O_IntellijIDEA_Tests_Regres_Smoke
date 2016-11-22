package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class DAccountDGroupHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    protected DAccountDGroupHelper()
    {
        this.container = "c1";
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountDGroupModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountDGroupModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountDGroupModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Поле для даты "Дата начала лечения"
     */
    public InputDate getFromDtField()
    {
        return getDAccountDGroupModal().getForm().getInputDate("from_dt");
    }

    /**
     * @return Классифаер "Д-группа"
     */
    public Classifier getGroupField()
    {
        return getDAccountDGroupModal().getForm().getClassifier("group");
    }

    /**
     * @return Классифаер "Вид амбулаторной помощи"
     */
    public Classifier getAmbField()
    {
        return getDAccountDGroupModal().getForm().getClassifier("amb");
    }

    /**
     * @return Классифаер "Причина прекращения наблюдения"
     */
    public Classifier getReasonField()
    {
        return getDAccountDGroupModal().getForm().getClassifier("reason");
    }

}
