package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class DAccountHospitalHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    protected DAccountHospitalHelper()
    {
        this.container = "c1";
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getDAccountHospitalModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getDAccountHospitalModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getDAccountHospitalModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Поле для даты "Дата поступления"
     */
    public InputDate getAdmissionDtField()
    {
        return getDAccountHospitalModal().getForm().getInputDate("admission_dt");
    }

    /**
     * @return Поле для даты "Дата выбытия"
     */
    public InputDate getOutcomeDtField()
    {
        return getDAccountHospitalModal().getForm().getInputDate("outcome_date");
    }

    /**
     * @return Классифаер "Основной диагноз"
     */
    public Classifier getDiagField()
    {
        return getDAccountHospitalModal().getForm().getClassifier("diag");
    }

    /**
     * @return Классифаер "Цель госпитализации"
     */
    public Classifier getGoalField()
    {
        return getDAccountHospitalModal().getForm().getClassifier("goal");
    }
}
