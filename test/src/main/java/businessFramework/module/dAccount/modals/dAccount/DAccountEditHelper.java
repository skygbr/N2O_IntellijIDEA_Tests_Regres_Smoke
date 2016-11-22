package businessFramework.module.dAccount.modals.dAccount;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class DAccountEditHelper implements Values
{
    private Page page = Page.getInstance();
    private String container;

    public DAccountEditHelper()
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
     * @return Поле для даты "Дата постановки на учет"
     */
    public InputDate getRegDateField()
    {
        return getDAccountModal().getForm().getInputDate("regDate");
    }

    /**
     * @return Классифаер "Участок"
     */
    public Classifier getClinicDistrictField()
    {
        return getDAccountModal().getForm().getClassifier("clinicDistrict");
    }

    /**
     * @return Классифаер "Этап взятия на учёт"
     */
    public Classifier getAcStageField()
    {
        return getDAccountModal().getForm().getClassifier("ac_stage");
    }

    /**
     * @return Классифаер "Условия постановки на Д-учёт"
     */
    public Classifier getConditionField()
    {
        return getDAccountModal().getForm().getClassifier("cond");
    }

    /**
     * @return Классифаер "Юридический статус пациента"
     */
    public Classifier getPatStateField()
    {
        return getDAccountModal().getForm().getClassifier("patState");
    }

    /**
     * @return Классифаер "Результат обследования на ВИЧ"
     */
    public Classifier getHivField()
    {
        return getDAccountModal().getForm().getClassifier("hiv");
    }

    /**
     * @return Поле для даты "Дата постановки диагноза ВИЧ"
     */
    public InputDate getHivDateField()
    {
        return getDAccountModal().getForm().getInputDate("hivDate");
    }
}
