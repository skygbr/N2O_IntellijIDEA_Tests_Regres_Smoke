package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Создать наряд на бригаду"
 */
public class CreateJobForBrigadeHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public CreateJobForBrigadeHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getCreateTeamJobModal()
    {
        return page.getModal();
    }

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveTeamJobButton()
    {
        return getCreateTeamJobModal().getButton(N2O_CONFIRM_BUTTON);
    }


    /*-------------------------------- Получение полей --------------------------------*/

    /**
     * Получение поля "Станция"
     * @return поле "Станция"
     */
    public Classifier getStationField()
    {
        return getCreateTeamJobModal().getForm().getClassifier("station");
    }

    /**
     * Получение поля "Подстанция"
     * @return поле "Подстанция"
     */
    public Classifier getSubStationField()
    {
        return getCreateTeamJobModal().getForm().getClassifier("substation");
    }

    /**
     * Получение поля "Дата"
     * @return поле "Дата"
     */
    public InputDate getDateField()
    {
        return getCreateTeamJobModal().getForm().getInputDate("data");
    }

    /**
     * Получение поля "Бригада"
     * @return поле "Бригада"
     */
    public Classifier getBrigadeField()
    {
        return getCreateTeamJobModal().getForm().getClassifier("res_team");
    }
}
