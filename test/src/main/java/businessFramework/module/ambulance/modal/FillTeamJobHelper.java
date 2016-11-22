package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Заполнить наряд на бригаду".
 */
public class FillTeamJobHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public FillTeamJobHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getFillTeamJobModal()
    {
        return page.getModal();
    }



    /* ----------------------------- Контейнер "Наряд на бригаду" ------------------------------ */

    /**
     * Получение контейнера "Наряд на бригаду"
     * @return контейнер "Наряд на бригаду"
     */
    public Container getTeamJobContainer()
    {
        return getFillTeamJobModal().getContainer("teamJob");
    }

    /**
     * Получение поля "Смена"
     * @return поле "Смена"
     */
    public InputText getSmenaField()
    {
        return getTeamJobContainer().getForm().getInputText("change.data");
    }

    /**
     * Получение поля "Дата/время начала наряда плановое"
     * @return поле "Дата/время начала наряда плановое"
     */
    public InputText getPlanningBeginDateTimeField()
    {
        return getTeamJobContainer().getForm().getInputText("planned_bdate");
    }

    /**
     * Получение поля "Дата/время начала наряда"
     * @return поле "Дата/время начала наряда"
     */
    public InputDate getBeginDateTimeField()
    {
        return getTeamJobContainer().getForm().getInputDate("bdate");
    }

    /**
     * Получение поля "Бригада"
     * @return поле "Бригада"
     */
    public InputText getBrigadeField()
    {
        return getTeamJobContainer().getForm().getInputText("res_team.name");
    }

    /**
     * Получение поля "Дата/время окончания наряда плановое"
     * @return поле "Дата/время окончания наряда плановое"
     */
    public InputText getPlannedEndDateTimeField()
    {
        return getTeamJobContainer().getForm().getInputText("planned_edate");
    }

    /**
     * Получение поля "Дата/время окончания наряда"
     * @return поле "Дата/время окончания наряда"
     */
    public InputDate getEndDateTimeField()
    {
        return getTeamJobContainer().getForm().getInputDate("edate");
    }


    /* ----------------------------- Контейнер "Сотрудники" ------------------------------ */

    /**
     * Получение контейнера "Сотрудники"
     * @return контейнер "Сотрудники"
     */
    public Container getEmployeesFillContainer()
    {
        return getContainer("team_job_resource_emp");
    }

    /**
     * Получение таблицы в контейнере "Сотрудники"
     * @return таблицу в контейнере "Сотрудники"
     */
    public Table getEmployeesFillTable()
    {
        return getEmployeesFillContainer().getTable();
    }

    /* ----------------------------- Контейнер "Транспортные средства" ------------------------------ */

    /**
     * Получение контейнера "Транспортные средства"
     * @return контейнер "Транспортные средства"
     */
    public Container getTransportFillContainer()
    {
        return getContainer("team_job_resource_trans");
    }

    /**
     * Получение таблицы в контейнере "Транспорт"
     * @return таблица в контейнере "Транспорт"
     */
    public Table getTransportFillTable()
    {
        return getTransportFillContainer().getTable();
    }
}
