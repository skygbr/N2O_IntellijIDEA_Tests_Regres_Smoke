package businessFramework.module.ambulance.pages.Brigads;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;


import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Бригады: справочники - Шаблон вида бригады"
 */
public class BrigadeViewTemplatePage extends BrigadeViewTemplateHelper
{
    public BrigadeViewTemplatePage(ApplicationManager app)
    {
        super(app);
    }


    /* ----------------------------- Контейнер "Настройка вида бригады" ------------------------------ */

    /**
     * Нажатие кнопки "Добавить"
     */
    public void clickAddBrigadeViewTemplateButton()
    {
        sleep(5); //todo решение т.к. контейнер не успевает прогрузится
        getCreateBrigadeViewTemplateButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditBrigadeViewTemplateButton()
    {
        getEditBrigateViewTemplateButton().click();
    }

    /**
     * Проверка значений в строке таблицы.
     *
     * @param code          Значение столбца "Код"
     * @param name          Значение столбца "Наименование"
     * @param brigadeKind   Значение столбца "Вид бригады"
     * @param jobKind       Значение столбца "Вид наряда"
     * @param brigadeType   Значение столбца "Профиль"
     * @param profile       Значение столбца "Тип бригады"
     *
     * @return номер ряда таблицы, в котором найдена данная запись
     */
    public int checkTableBrigadeTemplateViewValues(String code, String name, String brigadeKind, String jobKind, String brigadeType, String profile)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if ( code != null)          { columnsAndValues.put(CODE, code); }
        if ( name != null)          { columnsAndValues.put(NAME_COLUMN, name);}
        if ( brigadeKind != null)   { columnsAndValues.put(BRIGADE_KIND, brigadeKind);}
        if ( jobKind != null)       { columnsAndValues.put(JOB_KIND, jobKind);}
        if ( brigadeType != null)   { columnsAndValues.put(BRIGADE_TYPE, brigadeType);}
        if ( profile != null)       { columnsAndValues.put(PROFILE, profile);}

        return getSettingsBrigadeViewTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Удаление всех шаблонов вида бригады
     */
    public void deleteAllBrigadesTemplates()
    {
        int templatesCount = getSettingsBrigadeViewTable().getCountRowsInTable(true);
        for (int i = 0; i < templatesCount; i++)
        {
            getSettingsBrigadeViewTable().chooseRowInTable(0);
            getDeleteBrigateViewTemplateButton().click();
            getDialog().clickYes();
            getSettingsBrigadeViewTable().getAlerts().assertSuccessAlertIsPresent();
            getSettingsBrigadeViewTable().assertThatCountOfRowsIs(templatesCount - i - 1);
        }
    }


    /* ----------------------------- Контейнер "Сотрудники" ------------------------------ */

    /**
     * Нажатие кнопки "Добавить"
     */
    public void clickAddEmployeeButton()
    {
        getAddEmployeeButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditEmployeeButton()
    {
        getEditEmployeeButton().click();
    }

    /**
     * Проверка значений в строке таблицы.
     *
     * @param workingPlace      Значение столбца "Рабочее место"
     * @param role              Значение столбца "Роль"
//     * @param speciality        Значение столбца "Специальность"
     * @param personalCategory  Значение столбца "Категория персонала"
     * @param position          Значение столбца "Должность"
     *
     * @return номер ряда таблицы, в котором найдена данная запись
     */
    public int checkTableEmployeesValues(String workingPlace, String role, String personalCategory, String position)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlace != null)      { columnsAndValues.put(WORKING_PLACE, workingPlace); }
        if ( role != null)              { columnsAndValues.put(ROLE, role);}
        if ( personalCategory != null)  { columnsAndValues.put(PERSONAL_CATEGORY, personalCategory);}
        if ( position != null)          { columnsAndValues.put(POSITION, position);}

        return getEmployeesTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }



    /* ----------------------------- Контейнер "Транспорт" ------------------------------ */

    /**
     * Получение таблицы в контейнере "Траспорт"
     * @return таблицу в контейнере "Траспорт"
     */
    public Table getTransportTable()
    {
        return getTransportContainer().getTable();
    }

    /**
     * Нажатие кнопки "Добавить"
     */
    public void clickAddTransportButton()
    {
        getAddTransportButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditTransportButton()
    {
        getEditTransportButton().click();
    }

    /**
     * Проверка значений в строке таблицы.
     *
     * @param role              Значение столбца "Роль"
     * @param workingPlace      Значение столбца "Рабочее место"
     * @param tsType            Значение столбца "Рабочее место"
     * @param equipmentKind     Значение столбца "Должность"
     *
     * @return номер ряда таблицы, в котором найдена данная запись
     */
    public int checkTableTransportValues(String role, String workingPlace, String tsType, String equipmentKind)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if ( role != null)              { columnsAndValues.put(ROLE, role);}
        if ( workingPlace != null)      { columnsAndValues.put(WORKING_PLACE, workingPlace); }
        if ( tsType != null)            { columnsAndValues.put(TS_TYPE, tsType); }
        if ( equipmentKind != null)     { columnsAndValues.put(EQUIPMENT_KIND, equipmentKind); }

        return getTransportTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

}
