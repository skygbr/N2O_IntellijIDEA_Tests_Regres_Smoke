package businessFramework.module.ambulance.pages.journal;



import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Наряд - Журнал нарядов"
 */

public class TeamJobsJournalPage extends TeamJobsJournalHelper
{
    public TeamJobsJournalPage(ApplicationManager app)
    {
        super(app);
    }

    /* ----------------------------- Контейнер "журнал нарядов бригад" ------------------------------ */

    /**
     * Нажатие кнопки "Создать"
     */
    public void clickCreateTeamButton()
    {
        getCreateTeamJobButton().click();
    }

    /**
     * Нажатие кнопки "Заполнить"
     */
    public void clickFillTeamJobButton()
    {
        getFillTeamJobButton().click();
    }

    /**
     * Нажатие кнопки "Начало работы"
     */
    public void clickTeamReadyButton()
    {
        getTeamReadyButton().click();
    }


    /* ----------------------------- Контейнер "Сотрудники" ------------------------------ */

    /**
     * Нажатие кнопки "Создать"
     */
    public void clickCreateEmployeeTeamJobButton()
    {
        getCreateTeamJobEmployeeButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditEmployeeTeamJobButton()
    {
        getEditTeamJobEmployeeButton().click();
    }

    /**
     * Нажатие кнопки "Отклонение"
     */
    public void clickRefuseButton()
    {
        getRefuseButton().click();
    }

    /**
     * Нажатие кнопки "Подписать"
     */
    public void clickReadyButton()
    {
        getReadyButton().click();
    }

    /* ----------------------------- Контейнер "Транспортные средства" ------------------------------ */

    /**
     * Нажатие кнопки "Создать"
     */
    public void clickCreateTransportTeamJobButton()
    {
        getCreateTransportTeamJobButton().click();
    }


    /**
     * Проверка, есть ли заданная запись в таблице
     *
     * @param brigade       Значение столбца "Бригада"
     * @param date          Значение столбца "Смена"
     *
     * @return номер ряда строки таблицы, в котором эта запись была найдена
     */
    public int checkJobTeamTableValues(String brigade, String date)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( date != null)          { columnsAndValues.put(JOB_DATE, date);}
        if ( brigade != null)       { columnsAndValues.put(BRIGADE_NAME, brigade); }

        return getJobTeamTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }


    /**
     * Проверка, есть ли заданная запись в таблице
     *
     * @param workingPlace2     Значение столбца "Рабочее место"
     * @param beginDateTime     Значение столбца "Начало"
     * @param endDateTime       Значение столбца "Окончание"
     *
     * @return номер ряда строки таблицы, в котором эта запись была найдена
     */
    public int checkEmployeesTableValues(String workingPlace2, String beginDateTime, String endDateTime)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlace2 != null)   { columnsAndValues.put(WORKING_PLACE, workingPlace2); }
        if ( beginDateTime != null)   { columnsAndValues.put(BEGIN_DATE_TIME, beginDateTime);}
        if ( endDateTime != null)     { columnsAndValues.put(END_DATE_TIME, endDateTime);}

        return getEmployeesTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }


    /**
     * Проверка, есть ли заданная запись в таблице
     *
     * @param workingPlace2     Значение столбца "Рабочее место"
     * @param resource          Значение столбца "Ресурс"
     * @param beginDateTime     Значение столбца "Начало"
     * @param endDateTime       Значение столбца "Окончание"
     *
     * @return номер ряда строки таблицы, в котором эта запись была найдена
     */
    public int checkTransportTableValues(String workingPlace2, String resource, String beginDateTime, String endDateTime)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlace2 != null)   { columnsAndValues.put(WORKING_PLACE, workingPlace2); }
        if ( resource != null)        { columnsAndValues.put(RESOURCE_NAME, resource);}
        if ( beginDateTime != null)   { columnsAndValues.put(BEGIN_DATE_TIME, beginDateTime);}
        if ( endDateTime != null)     { columnsAndValues.put(END_DATE_TIME, endDateTime);}

        return getTransportsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
