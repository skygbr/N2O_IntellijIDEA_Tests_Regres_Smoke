package businessFramework.module.ambulance.modal;


import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Создать наряд на бригаду".
 * Это модальное окно открывается со страницы "наряд - Журнал нарядов" по кнопке "Создать" в контейнере team_job
 */
public class CreateJobForBrigadeModal extends CreateJobForBrigadeHelper
{
    public CreateJobForBrigadeModal(ApplicationManager app)
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
        getCreateTeamJobModal().assertModalHeader_equal(header.toLowerCase());
    }


    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveJobTeamButton()
    {
        getSaveTeamJobButton().click();
    }

    /**
     * Проверка значений в полях
     *
     * @param station       Значение поля "Станция"
     * @param subStation    Значение поля "Подстанция
     * @param date          Значение поля "Дата"
     * @param brigade       Значение поля "Бригада"
     */
    public void checkFields(String station, String subStation, String date, String brigade)
    {
        if (station != null )   { getStationField().assertValue_equals(station); }
        if (subStation != null) { getSubStationField().assertValue_equals(subStation); }
        if (date != null)       { getDateField().assertValue_equals(date); }
        if (brigade != null)    { getBrigadeField().assertValue_equals(brigade); }
    }

    /**
     * Установка значений в поля
     *
     * @param station       Значение для поля "Станция"
     * @param subStation    Значение для поля "Подстанция
     * @param date          Значение для поля "Дата"
     * @param brigade       Значение для поля "Бригада"
     */
    public void fillFields(String station, String subStation, String date, String brigade)
    {
        if (station != null )   { getStationField().setValue(station); }
        if (subStation != null) { getSubStationField().setValue(subStation); }
        if (date != null)       { getDateField().setValue(date); }
        if (brigade != null)    { getBrigadeField().setValue(brigade); }
    }
}
