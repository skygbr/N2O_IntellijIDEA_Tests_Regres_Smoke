package businessFramework.module.dispensary.pages.EventCard;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.*;

public class EventCardHelper extends Page implements Values{

    public EventCardHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainerEventCard()
    {
        return getRegion(TOP).getContainer("eventCard");
    }

    /**
     * Получение контейнера "Услуги"
     *
     * @return
     */
    public Container getContainerServicesEventCard()
    {
        return getRegion(MIDDLE).getContainer("services");
    }

    /*Получение контейнера Пациенты*/

    public Container getContainerPatients()
    {
        return getRegion(TOP).getContainer("patients");
    }

    public Button getButtonSelectPatients () {
        return getContainerPatients().getButton(SELECT_PATIENTS);
    }

    /**
     * Получение модального окна, подтверждающего отбор пациентов в контейнере "Пациенты"
     *
     * @return
     */
    public Modal getConfirmModalAfterSelectPatients()
    {
        getModal().assertModalHeader_equal("вы уверены?");
        return getModal();
    }

    /**
     * Получение таблицы пациентов
     *
     * @return
     */
    public Table getPatientsTable()
    {
        return getContainerPatients().getTable();
    }


    /**
     * Получение контейнера "Модель пациента"
     *
     * @return
     */
    public Container getContainerPatientModel()
    {
        return getRegion(RIGHT).getContainer("modelPatient");
    }

    /**
     * Получение текстового поля "Наименование" мероприятия
     *
     * @return
     */
    public InputText getEventName()
    {
        return getContainerEventCard().getForm().getInputText("name");
    }

    /**
     * Получение классифаера "Вид мероприятия"
     *
     * @return
     */
    public Classifier getEventType()
    {
        return getContainerEventCard().getForm().getClassifier("eventType");
    }

    /**
     * Получение классифаера "Организация"
     *
     * @return
     */
    public Classifier getOrganisationName()
    {
        return getContainerEventCard().getForm().getClassifier("organization");
    }

    /**
     * Получение классифаера "Вид финансирования"
     *
     * @return
     */
    public Classifier getFundingType()
    {
        return getContainerEventCard().getForm().getClassifier("fundingSourceType");
    }

    /**
     * Получение поля даты "Дата начала"
     *
     * @return
     */
    public InputDate getBeginDate()
    {
        return getContainerEventCard().getForm().getInputDate("startDate");
    }

    /**
     * Получение поля даты "Дата окончания"
     *
     * @return
     */
    public InputDate getEndDate()
    {
        return getContainerEventCard().getForm().getInputDate("endDate");
    }

    /**
     * Получение текстового поля "Стандарт лечения"
     *
     * @return
     */
    public Classifier getStandart()
    {
        return getContainerEventCard().getForm().getClassifier("standard");
    }

    /**
     * Получение кнопки "Сохранить"
     *
     * @return
     */
    public Button getSaveButton()
    {
        return getContainerEventCard().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     *
     * @return
     */
    public Button getEditButton()
    {
        return getContainerEventCard().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Назад"
     *
     * @return
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }

    // -------- КОНТЕЙНЕР "Услуги" -------- //

    /**
     * Получение таблицы услуг
     *
     * @return
     */
    public Table getServicesTable()
    {
        return getContainerServicesEventCard().getTable();
    }

    /**
     * Получение кнопки "Задать модель всем услугам"
     *
     * @return
     */
    public Button getSetModelToAllServicesButton()
    {
        return getContainerServicesEventCard().getButton(ATTACH_MODEL);
    }


    // -------- КОНТЕЙНЕР "Модель пациента" -------- //

    /**
     * Получение таблицы "Модель пациента"
     *
     * @return
     */
    public Table getPatientModelTable()
    {
        return getContainerPatientModel().getTable();
    }

    /**
     * Получение кнопки "Добавить" в контейнере 'Модель пациента'
     *
     * @return
     */
    public Button getAddButton()
    {
        return getContainerPatientModel().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Удалить" в контейнере "Модель пациента"
     *
     * @return
     */
    public Button getPatientModelDeleteButton()
    {
        return getContainerPatientModel().getButton(DELETE_BUTTON);
    }

    /**
     * Получение модального окна, подтверждающего удаление записи в контейнере "Модель пациента"
     *
     * @return
     */
    public Modal getConfirmModalAfterDeletePatientModel()
    {
        getModal().assertModalHeader_equal("Предупреждение");
        return getModal();
    }

}
