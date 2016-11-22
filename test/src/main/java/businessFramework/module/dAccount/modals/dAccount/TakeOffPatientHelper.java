package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class TakeOffPatientHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    public TakeOffPatientHelper()
    {
        this.container = "c1";
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
     * @return Дата "Дата снятия с учета"
     */
    public InputDate getUnregDateField()
    {
        return getDAccountModal().getForm().getInputDate("unregDate");
    }

    /**
     * @return Классифаер "Причина прекращения наблюдения
     */
    public Classifier getReasonField()
    {
        return getDAccountModal().getForm().getClassifier("reason");
    }
}
