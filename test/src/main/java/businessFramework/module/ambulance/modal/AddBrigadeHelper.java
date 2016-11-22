package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Создать бригаду"
 */
public class AddBrigadeHelper extends Page implements Values
{

    private Page page = Page.getInstance();


    public AddBrigadeHelper(ApplicationManager app)
    {
        super(app);
    }



    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getAddBrigadeModal()
    {
        return page.getModal();
    }





    /* ------------------- Получение полей ------------------- */

    /**
     * Получение поля "Подстанция"
     * @return поле "Подстанция"
     */
    public Classifier getSubstationField()
    {
        return getAddBrigadeModal().getForm().getClassifier("substation");
    }

    /**
     * Получение поля "Шаблон"
     * @return поле "Шаблон"
     */
    public Classifier getTemplateField()
    {
        return getAddBrigadeModal().getForm().getClassifier("team_template_setting");
    }

    /**
     * Получение поля "Вид наряда"
     * @return поле "Вид наряда"
     */
    public Classifier getJobKindField()
    {
        return getAddBrigadeModal().getForm().getClassifier("job_kind");
    }

    /**
     * Получение поля "Вид бригады"
     * @return поле "Вид бригады"
     */
    public Classifier getBrigadeKindField()
    {
        return getAddBrigadeModal().getForm().getClassifier("team_kind");
    }

    /**
     * Получение поля "Тип бригады"
     * @return поле "Тип бригады"
     */
    public Classifier getBrigadeTypeField()
    {
        return getAddBrigadeModal().getForm().getClassifier("team_type");
    }

    /**
     * Получение поля "Бригада"
     * @return поле "Бригада"
     */
    public InputText getBrigadeNameField()
    {
        return getAddBrigadeModal().getForm().getInputText("name");
    }

    /**
     * Получение поля "Код рации"
     * @return поле "Код рации"
     */
    public InputText getRadioCodeField()
    {
        return getAddBrigadeModal().getForm().getInputText("radio_code");
    }

    /**
     * Получение поля "Начало работы бригады"
     * @return поле "Начало работы бригады"
     */
    public InputDate getStartBrigadeWorkTimeField()
    {
        return getAddBrigadeModal().getForm().getInputDate("change.btime");
    }

    /**
     * Получение поля "Окончание работы бригады"
     * @return поле "Окончание работы бригады"
     */
    public InputDate getEndBrigadeWorkTimeField()
    {
        return getAddBrigadeModal().getForm().getInputDate("change.etime");
    }

    /**
     * Получение поля "Мед. профиль"
     * @return поле "Мед. профиль"
     */
    public Classifier getMedProfileField()
    {
        return getAddBrigadeModal().getForm().getClassifier("md_profile");
    }

    /**
     * Получение поля "Профиль"
     * @return поле "Профиль"
     */
    public Classifier getProfileField()
    {
        return getAddBrigadeModal().getForm().getClassifier("amb_profile");
    }

    /**
     * Получение поля "Начало действия"
     * @return поле "Начало действия"
     */
    public InputDate getBeginActionField()
    {
        return getAddBrigadeModal().getForm().getInputDate("bdate");
    }

    /**
     * Получение поля "Окончание действия"
     * @return поле "Окончание действия"
     */
    public InputDate getEndActionField()
    {
        return getAddBrigadeModal().getForm().getInputDate("edate");
    }



    /* ------------------- Получение кнопок ------------------- */

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveBrigadeButton()
    {
        return getAddBrigadeModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
