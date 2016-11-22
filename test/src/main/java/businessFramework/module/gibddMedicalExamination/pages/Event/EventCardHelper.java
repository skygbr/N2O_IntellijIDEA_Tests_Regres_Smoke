package businessFramework.module.gibddMedicalExamination.pages.Event;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class EventCardHelper extends Page implements Values
{

    public EventCardHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainerEventCard()
    {
        return getRegion(TOP).getContainer("eventCard");
    }

    // Получение контейнера "Услуги"
    public Container getContainerServicesEventCard()
    {
        return getRegion(MIDDLE).getContainer("services");
    }

    // Получение контейнера "Модель пациента"
    public Container getContainerPatientModel()
    {
        return getRegion(RIGHT).getContainer("modelPatient");
    }

    // Получение текстового поля "Наименование" мероприятия
    public InputText getEventName()
    {
        return getContainerEventCard().getForm().getInputText("name");
    }

    // Получение классифаера "Вид мероприятия"
    public Classifier getEventType()
    {
        return getContainerEventCard().getForm().getClassifier("eventType");
    }

    // Получение классифаера "Организация"
    public Classifier getOrganisationName()
    {
        return getContainerEventCard().getForm().getClassifier("organization");
    }

    // Получение классифаера "Вид финансирования"
    public Classifier getFundingType()
    {
        return getContainerEventCard().getForm().getClassifier("fundingSourceType");
    }

    // Получение поля даты "Дата начала"
    public InputDate getBeginDate()
    {
        return getContainerEventCard().getForm().getInputDate("startDate");
    }

    // Получение поля даты "Дата окончания"
    public InputDate getEndDate()
    {
        return getContainerEventCard().getForm().getInputDate("endDate");
    }

    // Получение текстового поля "Стандарт лечения"
    public Classifier getStandart()
    {
        return getContainerEventCard().getForm().getClassifier("standard");
    }

    // Получение классифаера "МЭС"
    public Classifier getMes()
    {
        return getContainerEventCard().getForm().getClassifier("mes");
    }

    // Получение кнопки "Сохранить"
    public Button getSaveButton()
    {
        return getContainerEventCard().getButton(N2O_CONFIRM_BUTTON);
    }

    // Получение кнопки "Изменить"
    public Button getEditButton()
    {
        return getContainerEventCard().getButton(UPDATE_BUTTON);
    }

    // Получение формы
    public Form getEventCardForm()
    {
        return getContainerEventCard().getForm();
    }

    // Получение кнопки "Назад"
    public Button getBackButton()
    {
        return getButton(BACK);
    }

    // -------- КОНТЕЙНЕР "Услуги" --------

    // Получение таблицы услуг
    public Table getServicesTable()
    {
        return getContainerServicesEventCard().getTable();
    }

    // Получение кнопки "Задать модель всем услугам"
    public Button getSetModelToAllServicesButton()
    {
        return getContainerServicesEventCard().getButton(ATTACH_MODEL);
    }


    // -------- КОНТЕЙНЕР "Модель пациента" --------

    // Получение таблицы "Модель пациента"
    public Table getPatientModelTable()
    {
        return getContainerPatientModel().getTable();
    }

    // Получение кнопки "Добавить" в контейнере 'Модель пациента'
    public Button getAddButton()
    {
        return getContainerPatientModel().getButton(ADD_BUTTON);
    }

    // Получение кнопки "Удалить" в контейнере "Модель пациента"
    public Button getPatientModelDeleteButton()
    {
        return getContainerPatientModel().getButton(DELETE_BUTTON);
    }

    // Получение модального окна, подтверждающего удаление записи в контейнере "Модель пациента"
    public Modal getConfirmModalAfterDeletePatientModel()
    {
        getModal().assertModalHeader_equal("Предупреждение");
        return getModal();
    }

    // Получение модального окна, подтверждающего добавление мероприятия
    public Modal getConfirmModalEvent()
    {
        getModal().assertModalHeader_equal("Предупреждение");
        return getModal();
    }

}
