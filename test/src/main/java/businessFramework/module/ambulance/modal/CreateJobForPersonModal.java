package businessFramework.module.ambulance.modal;


import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Создать наряд на сотрудника в бригаде '7204 (19.06.2015)'"
 */
public class CreateJobForPersonModal extends CreateJobForPersonHelper
{
    public CreateJobForPersonModal(ApplicationManager app)
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
        getCreateJobForPersonModal().assertModalHeader_equal(header.toLowerCase());
    }


    /**
     * Проверка значений в полях
     *
     * @param date                      Значение для поля "Дата"
     * @param brigadeJob                Значение для поля "Наряд бригады"
     * @param hasTeamJob                Значение для поля "Команд в работе"
     * @param resourceKind              Значение для поля "Вид ресурса"
     * @param workingPlaceInTemplate    Значение для поля "Рабочее место в шаблоне"
     * @param role                      Значение для поля "Роль"
     * @param workingPlace2             Значение для поля "Рабочее место2"
     * @param resource                  Значение для поля "Ресурс"
     * @param jobKind                   Значение для поля "Вид наряда"
     * @param olderInJob                Значение для поля "Старший в наряде"
     * @param beginDateTime             Значение для поля "Дата/время начала наряда плановое"
     * @param endDateTime               Значение для поля "Дата/время окончания наряда плановое"
     */
    public void checkFields(String date, String brigadeJob, String hasTeamJob, String resourceKind,
                            String workingPlaceInTemplate, String role, String workingPlace2,
                            String resource, String jobKind, boolean olderInJob,
                            String beginDateTime, String endDateTime)
    {
        if ( date != null)                   { getDateField().assertValue_equals(date);}
        if ( brigadeJob != null)             { getBrigadeJobField().assertValue_equals(brigadeJob);}
        if ( hasTeamJob != null)             { getHasTeamJobField().assertValue(hasTeamJob);}
        if ( resourceKind != null)           { getResourceKindField().assertValue_equals(resourceKind);}
        if ( workingPlaceInTemplate != null) { getWorkingPlaceInTemplateField().assertValue_equals(workingPlaceInTemplate);}
        if ( role != null)                   { getRoleField().assertValue_equals(role);}
        if ( workingPlace2 != null)          { getWorkingPlace2Field().assertValue(workingPlace2);}
        if ( resource != null)               { getResourceField().assertValue_equals(resource);}
        if ( jobKind != null)                { getJobKindField().assertValue_equals(jobKind);}
        if ( olderInJob )                    { getOlderInJobField().assertThatCheckboxIsChecked(true);}
        if ( !olderInJob )                   { getOlderInJobField().assertThatCheckboxIsChecked(false);}
        if ( beginDateTime != null)          { getBeginDateTimeField().assertValue(beginDateTime);}
        if ( endDateTime!= null)             { getEndDateTimeField().assertValue(endDateTime);}
    }


    /**
     * Заполнение значений в полях
     *
     * @param date                      Значение для поля "Дата"
     * @param brigadeJob                Значение для поля "Наряд бригады"
     * @param hasTeamJob                Значение для поля "Команд в работе"
     * @param resourceKind              Значение для поля "Вид ресурса"
     * @param workingPlaceInTemplate    Значение для поля "Рабочее место в шаблоне"
     * @param role                      Значение для поля "Роль"
     * @param workingPlace2             Значение для поля "Рабочее место2"
     * @param resource                  Значение для поля "Ресурс"
     * @param jobKind                   Значение для поля "Вид наряда"
     * @param olderInJob                Значение для поля "Старший в наряде"
     * @param beginDateTime             Значение для поля "Дата/время начала наряда плановое"
     * @param endDateTime               Значение для поля "Дата/время окончания наряда плановое"
     */
    public void fillFields(String date, String brigadeJob, String hasTeamJob, String resourceKind,
                            String workingPlaceInTemplate, String role, String workingPlace2,
                            String resource, String jobKind, boolean olderInJob,
                            String beginDateTime, String endDateTime)
    {

        if ( date != null)                   { getDateField().setValue(date);}
        if ( brigadeJob != null)             { getBrigadeJobField().setValue(brigadeJob);}
        if ( hasTeamJob != null)             { getHasTeamJobField().setValue(hasTeamJob);}
        if ( resourceKind != null)           { getResourceField().setValue(resourceKind);}
        if ( workingPlaceInTemplate != null) { getWorkingPlaceInTemplateField().setValue(workingPlaceInTemplate);}
        if ( role != null)                   { getRoleField().setValue(role);}
        if ( workingPlace2 != null)          { getWorkingPlace2Field().setValue(workingPlace2);}
        if ( resource != null)               { getResourceField().setValue(resource);}
        if ( jobKind != null)                { getJobKindField().setValue(jobKind);}
        if ( olderInJob)                     { getOlderInJobField().check(true);}
        if ( beginDateTime != null)          { getBeginDateTimeField().setValue(beginDateTime);}
        if ( endDateTime!= null)             { getEndDateTimeField().setValue(endDateTime);}
        if ( resource != null)               { getResourceField().setValue(resource);}

    }

    /**
     * Заполнение значений в полях в модальном окне "Создать наряд на ТС в бригаде"
     *
     * @param date                      Значение для поля "Дата"
     * @param brigadeJob                Значение для поля "Наряд бригады"
     * @param hasTeamJob                Значение для поля "Команд в работе"
     * @param resourceKind              Значение для поля "Вид ресурса"
     * @param workingPlaceInTemplate    Значение для поля "Рабочее место в шаблоне"
     * @param role                      Значение для поля "Роль"
     * @param workingPlace2             Значение для поля "Рабочее место2"
     * @param resource                  Значение для поля "Ресурс"
     * @param jobKind                   Значение для поля "Вид наряда"
     * @param olderInJob                Значение для поля "Старший в наряде"
     * @param beginDateTime             Значение для поля "Дата/время начала наряда плановое"
     * @param endDateTime               Значение для поля "Дата/время окончания наряда плановое"
     * @param resources                 Значение для поля "Ресурс"
     */
    public void fillFieldsTS(String date, String brigadeJob, String hasTeamJob, String resourceKind,
                            String workingPlaceInTemplate, String role, String workingPlace2,
                            String resource, String jobKind, boolean olderInJob,
                            String beginDateTime, String endDateTime, String resources)
    {
        if ( date != null)                   { getDateField().setValue(date);}
        if ( brigadeJob != null)             { getBrigadeJobField().setValue(brigadeJob);}
        if ( hasTeamJob != null)             { getHasTeamJobField().setValue(hasTeamJob);}
        if ( resourceKind != null)           { getResourceField().setValue(resourceKind);}
        if ( workingPlaceInTemplate != null) { getWorkingPlaceInTemplateTSField().setValue(workingPlaceInTemplate);}
        if ( role != null)                   { getRoleField().setValue(role);}
        if ( workingPlace2 != null)          { getWorkingPlace2Field().setValue(workingPlace2);}
        if ( resource != null)               { getResourceField().setValue(resource);}
        if ( jobKind != null)                { getJobKindField().setValue(jobKind);}
        if ( olderInJob)                     { getOlderInJobField().check(true);}
        if ( beginDateTime != null)          { getBeginDateTimeField().setValue(beginDateTime);}
        if ( endDateTime!= null)             { getEndDateTimeField().setValue(endDateTime);}
        if ( resources != null)              { getResourceField().setValue(resource);}
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSavePersonJobButton()
    {
        getSavePersonJobButton().click();
    }


}
