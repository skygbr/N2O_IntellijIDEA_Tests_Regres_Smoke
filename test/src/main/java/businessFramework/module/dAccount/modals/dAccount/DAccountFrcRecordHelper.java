package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

public class DAccountFrcRecordHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    protected DAccountFrcRecordHelper()
    {
        this.container = "c1";
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountFrcRecordModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountFrcRecordModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountFrcRecordModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Классифаер "Вид принудительного лечения"
     */
    public Classifier getFrcKindField()
    {
        return getDAccountFrcRecordModal().getForm().getClassifier("frc_kind");
    }

    /**
     * @return Текстовое поле "Номер постановления суда"
     */
    public InputText getOrderNumberField()
    {
        return getDAccountFrcRecordModal().getForm().getInputText("order_number");
    }

    /**
     * @return Поле для даты "Дата решения суда о постановлении на принудительное лечение"
     */
    public InputDate getOrderDtField()
    {
        return getDAccountFrcRecordModal().getForm().getInputDate("order_dt");
    }

    /**
     * @return Поле для даты "Дата окончания принудительного лечения"
     */
    public InputDate getCloseDtField()
    {
        return getDAccountFrcRecordModal().getForm().getInputDate("close_dt");
    }

}
