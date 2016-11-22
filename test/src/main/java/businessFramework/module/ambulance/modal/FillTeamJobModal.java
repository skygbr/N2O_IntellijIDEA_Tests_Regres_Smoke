package businessFramework.module.ambulance.modal;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;


/**
 * Страница описывает модальное окно "Заполнить наряд на бригаду".
 * Это модалььное окно открывается со страницы "Журнал нарядов бригад" по кнопке "Заполнить"
 */
public class FillTeamJobModal extends FillTeamJobHelper
{
    public FillTeamJobModal(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Проверка заголовка модального окна на эквивалентность ожидаемому
     *
     * @param header ожидаемый заголовок модального окна
     */
    public void checkModalHeader(String header)
    {
        getFillTeamJobModal().assertModalHeader_equal(header);
    }

    /**
     * Проверяет значения в полях на эквивалентность ожидаемым
     *
     * @param smena                     Значение поля "Смена"
     * @param brigade                   Значение поля "Бригада"
     * @param planningBeginDateTime     Значение поля "Дата/время начала наряда плановое"
     * @param planningEndDateTime       Значение поля "Дата/время окончания наряда плановое"
     */
    public void checkFields(String smena, String brigade, String planningBeginDateTime, String planningEndDateTime)
    {
        if ( smena != null)                     { getSmenaField().assertValue(smena); }
        if ( brigade != null)                   { getBrigadeField().assertValue(brigade); }
        if ( planningBeginDateTime != null )    { getPlanningBeginDateTimeField().assertValue(planningBeginDateTime); }
        if ( planningEndDateTime != null)       { getPlannedEndDateTimeField().assertValue(planningEndDateTime); }
    }

    /**
     * Проверяет, есть ли в таблице "Сотрудники" строка с необходимыми значениями
     *
     * @param workingPlaceEMPFill   Значение столбца "Рабочее место"
     * @param surnameEMPFill        Значение столбца "Фамилия"
     * @param nameEMPFill           Значение столбца "Имя"
     * @param patrNameEMPFill       Значение столбца "Отчество"
     * @param startDateTimeEMPFill  Значение столбца "Начало"
     * @param endDateTimeEMPFill    Значение столбца "Окончание"
     * @param breakEMPFill          Значение столбца "Отклонение1"
     * @param replaceEMPFill        Значение столбца "Замена"
     *
     * @return
     */
    public int checkEmpTableValues(String workingPlaceEMPFill, String surnameEMPFill, String nameEMPFill, String patrNameEMPFill,
                                   String startDateTimeEMPFill, String endDateTimeEMPFill, String breakEMPFill, String replaceEMPFill)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlaceEMPFill != null)   { columnsAndValues.put(WORKING_PLACE_FILL, workingPlaceEMPFill);}
        if ( surnameEMPFill != null)        { columnsAndValues.put(SURNAME_FILL, surnameEMPFill); }
        if ( nameEMPFill != null)           { columnsAndValues.put(NAME_FILL, nameEMPFill); }
        if ( patrNameEMPFill != null)       { columnsAndValues.put(PATRNAME_FILL, patrNameEMPFill); }
        if ( startDateTimeEMPFill != null)  { columnsAndValues.put(BEGIN_DATE_TIME_FILL, startDateTimeEMPFill); }
        if ( endDateTimeEMPFill != null)    { columnsAndValues.put(END_DATE_TIME_FILL, endDateTimeEMPFill); }
        if ( breakEMPFill != null)          { columnsAndValues.put(BREAK_FILL, breakEMPFill); }
        if ( replaceEMPFill != null)        { columnsAndValues.put(REPLACE_FILL, replaceEMPFill); }

        return getEmployeesFillTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Проверяет, есть ли в таблице "Транспортные средства" строка с необходимыми значениями
     *
     * @param workingPlaceTSFill    Значение столбца "Рабочее место"
     * @param resourceTSFill        Значение столбца "Ресурс"
     * @param startDateTimeTSFill   Значение столбца "Начало"
     * @param endDateTimeTSFill     Значение столбца "Окончание"
     * @param breakTSFill           Значение столбца "Отклонение1"
     * @param replaceTSFill         Значение столбца "Замена"
     *
     * @return
     */
    public int checkTSTableValues(String workingPlaceTSFill,  String resourceTSFill,
                                  String startDateTimeTSFill, String endDateTimeTSFill, String breakTSFill, String replaceTSFill)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( workingPlaceTSFill != null)   { columnsAndValues.put(WORKING_PLACE_FILL, workingPlaceTSFill);}
        if ( resourceTSFill != null)       { columnsAndValues.put(RESOURCE_NAME, resourceTSFill); }
        if ( startDateTimeTSFill != null)  { columnsAndValues.put(BEGIN_DATE_TIME_FILL, startDateTimeTSFill); }
        if ( endDateTimeTSFill != null)    { columnsAndValues.put(END_DATE_TIME_FILL, endDateTimeTSFill); }
        if ( breakTSFill != null)          { columnsAndValues.put(BREAK_FILL, breakTSFill); }
        if ( replaceTSFill != null)        { columnsAndValues.put(REPLACE_FILL, replaceTSFill); }

        return getTransportFillTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getFillTeamJobModal().closeModal();
    }
}
