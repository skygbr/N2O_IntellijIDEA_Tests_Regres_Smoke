package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

public class DAccountRemissionHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public DAccountRemissionHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountRemissionModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountRemissionModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountRemissionModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Поле для даты "Дата начала ремиссии"
     */
    public InputDate getBeginDtField()
    {
        return getDAccountRemissionModal().getForm().getInputDate("begin_dt");
    }

    /**
     * @return Поле для даты "Дата окончания ремисси"
     */
    public InputDate getEndDtField()
    {
        return getDAccountRemissionModal().getForm().getInputDate("end_dt");
    }


    /**
     * @return Текстовое поле "Информация"
     */
    public InputText getInfoField()
    {
        return getDAccountRemissionModal().getForm().getInputText("info");
    }
}
