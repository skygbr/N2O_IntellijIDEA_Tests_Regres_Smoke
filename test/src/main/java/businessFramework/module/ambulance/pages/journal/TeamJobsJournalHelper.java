package businessFramework.module.ambulance.pages.journal;


import businessFramework.module.Values;
import businessFramework.module.ambulance.modal.*;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Получение элементов на странице "Наряд - Журнал нарядов"
 */


public class TeamJobsJournalHelper extends Page implements Values
{
    public TeamJobsJournalHelper(ApplicationManager app)
    {
        super(app);
    }

    /* ----------------------------- Получение контейнеров ------------------------------ */

    /**
     * Получение контейнера "Сотрудники"
     * @return контейнер "Сотрудники"
     */
    public Container getTeamJobsEmployeesContainer()
    {
        return getContainer("employee");
    }

    /**
     * Получение контейнера "Транспортные средства"
     * @return контейнер "Транспортные средства"
     */
    public Container getTeamJobsTransportContainer()
    {
        return getContainer("transport");
    }

    /**
     * Получение контейнера "Журнал нарядов бригад"
     * @return контейнер "Журнал нарядов бригад"
     */
    public Container getTeamJobsJournalContainer()
    {
        return getContainer("team_job");
    }




    /* ----------------------------- Получение таблиц------------------------------ */

    /**
     * Получение таблицы в контейнере "Журнал нарядов бригад"
     * @return таблицу в контейнере "Журнал нарядов бригад"
     */
    public Table getJobTeamTable()
    {
        return getTeamJobsJournalContainer().getTable();
    }


    /**
     * Получение таблицы в контейнере "Сотрудники"
     * @return таблицу в контейнере "Сотрудники"
     */
    public Table getEmployeesTable()
    {
        return getTeamJobsEmployeesContainer().getTable();
    }

    /**
     * Получение таблицы в контейнере "Транспорт"
     * @return таблицу в контейнере "Транспорт"
     */
    public Table getTransportsTable()
    {
        return getTeamJobsTransportContainer().getTable();
    }



    /* ----------------------------- Получение кнопок ------------------------------ */

    /**
     * Получение кнопки "Создать" в контейнере "Журнал нарядов бригад"
     * @return кнопку "Создать" в контейнере "Журнал нарядов бригад"
     */
    public Button getCreateTeamJobButton()
    {
        return getTeamJobsJournalContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Создать" в контейнере "Сотрудники"
     * @return кнопку "Создать" в контейнере "Сотрудники"
     */
    public Button getCreateTeamJobEmployeeButton()
    {
        return getTeamJobsEmployeesContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить" в контейнере "Сотрудники"
     * @return кнопку "Изменить" в контейнере "Сотрудники"
     */
    public Button getEditTeamJobEmployeeButton()
    {
        return getTeamJobsEmployeesContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Создать" в контейнере "Транспортные средства"
     * @return кнопку "Создать" в контейнере "Транспортные средства"
     */
    public Button getCreateTransportTeamJobButton()
    {
        return getTeamJobsTransportContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Заполнить" в контейнере "Журнал нарядов бригад"
     * @return кнопку "Заполнить" в контейнере "Журнал нарядов бригад"
     */
    public Button getFillTeamJobButton()
    {
        return getTeamJobsJournalContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Отклонение" в контейнере "Сотрудники"
     * @return кнопку "Отклонение" в контейнере "Сотрудники"
     */
    public Button getRefuseButton()
    {
        return getTeamJobsEmployeesContainer().getButton("deviation");
    }

    /**
     * Получение кнопки "Подписать" в контейнере "Сотрудники"
     * @return кнопку "Подписать" в контейнере "Сотрудники"
     */
    public Button getReadyButton()
    {
        return getTeamJobsEmployeesContainer().getButton("ready");
    }


    /**
     * Получение кнопки "Начало работы" в контейнере "Журнал нарядов бригад"
     * @return кнопку "Начало работы" в контейнере "Журнал нарядов бригад"
     */
    public Button getTeamReadyButton()
    {
        return getTeamJobsJournalContainer().getButton("ready");
    }

    /* ----------------------------- Получение модальных окон ------------------------------ */


    /**
     * Получение модального окна "Создать наряд на бригаду" с этой страницы, тк его открытие происходит по нажатию кнопки "Добавить"
     * в контейнере "team_job" на этой странице.
     *
     * @return модальное окно "Создать наряд на бригаду"
     */
    public CreateJobForBrigadeModal getCreateJobForBrigadeModal ()
    {
        return new CreateJobForBrigadeModal(app);
    }

    /**
     * Получение модального окна "Создать наряд на сотрудника в бригаде " с этой страницы, тк его открытие происходит по нажатию кнопки "Добавить"
     * в контейнере "Сотрудники" на этой странице.
     *
     * @return модальное окно "Создать наряд на сотрудника в бригаде"
     */
    public CreateJobForPersonModal getCreateJobForPersonModal()
    {
        return new CreateJobForPersonModal(app);
    }

    /**
     * Получение модального окна "Заполнить наряд на бригаду" с этой страницы, тк его открытие происходит по нажатию кнопки "Заполнить"
     * в контейнере "Журнал нарядов бригад" на этой странице.
     *
     * @return модальное окно "Заполнить наряд на бригаду"
     */
    public FillTeamJobModal getFillTeamJobModal()
    {
        return new FillTeamJobModal(app);
    }

    /**
     * Получение модального окна "Заполнить наряд на бригаду" с этой страницы, тк его открытие происходит по нажатию кнопки "Заполнить"
     * в контейнере "Журнал нарядов бригад" на этой странице.
     *
     * @return модальное окно "Заполнить наряд на бригаду"
     */
    public RefuseWorkModal getRefuseWorkModal()
    {
        return new RefuseWorkModal(app);
    }

    /**
     * Получение модального окна "Начало работы" с этой страницы, тк его открытие происходит на этой странице.
     *
     * @return модальное окно "Начало работы"
     */
    public BeginWorkModal getBeginWorkModal()
    {
        return new BeginWorkModal(app);
    }

}
