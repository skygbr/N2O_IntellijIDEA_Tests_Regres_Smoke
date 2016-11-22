package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import businessFramework.module.migrants.modals.AttachModelModal;
import businessFramework.module.migrants.modals.SetModelModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class EventHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public EventHelper(ApplicationManager app)
    {
        super(app);
    }

    /* --------------------- Контейнер "Карточка мероприятия" --------------------------- */

    /**
     * Получение контейнера "Карточка мероприятия"
     *
     * @return контейнер "Карточка мероприятия"
     */
    public Container getContainerEventCard()
    {
        return getContainer("eventCard");
    }

    /* --------------------- Поля в контейнере "Карточка мероприятия" --------------------------- */

    /**
     * Получение текстового поля "Наименование"
     * @return поле "Наименование"
     */
    public InputText getEventNameField()
    {
        return getContainerEventCard().getForm().getInputText("name");
    }

    /**
     * Получение поля "Вид мероприятия"
     * @return поле "Вид мероприятия"
     */
    public Classifier getEventTypeField()
    {
        return getContainerEventCard().getForm().getClassifier("eventType");
    }

    /**
     * Получение поля "Организация"
     * @return поле "Организация"
     */
    public Classifier getOrganisationField()
    {
        return getContainerEventCard().getForm().getClassifier("organization");
    }

    /**
     * Получение поля "Вид финансирования"
     * @return поле "Вид финансирования"
     */
    public Classifier getFinancingTypeField()
    {
        return getContainerEventCard().getForm().getClassifier("fundingSourceType");
    }

    /**
     * Получение поля "Дата начала"
     * @return поле "Дата начала"
     */
    public InputDate getBeginDateField()
    {
        return getContainerEventCard().getForm().getInputDate("startDate");
    }

    /**
     * Получение поля "Дата окончания"
     * @return поле "Дата окончания"
     */
    public InputDate getEndDateField()
    {
        return getContainerEventCard().getForm().getInputDate("endDate");
    }

    /**
     * Получение поля "Стандарт лечения"
     * @return поле "Стандарт лечения"
     */
    public Classifier getStandartField()
    {
        return getContainerEventCard().getForm().getClassifier("standard");
    }


    /* --------------------- Кнопки в контейнере "Карточка мероприятия" --------------------------- */

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveEventButton()
    {
        return getContainerEventCard().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditButton()
    {
        return getContainerEventCard().getButton(UPDATE_BUTTON);
    }


    /* --------------------- Контейнер "Услуги" --------------------------- */

    /**
     * Получение контейнера "Услуги"
     * @return контейнер "Услуги"
     */
    public Container getContainerServices()
    {
        return getContainer("services");
    }

    /**
     * Получение таблицы в контейнере "Услуги"
     * @return таблицу в контейнере "Услуги"
     */
    public Table getServicesTable()
    {
        return getContainerServices().getTable();
    }

    /* --------------------- Кнопки в контейнере "Услуги" --------------------------- */


    /**
     * Получение кнопки "Задать модель всем услугам"
     * @return Кнопку "Задать модель всем услугам"
     */
    public Button getAttachModelToAllServicesButton()
    {
        return getContainerServices().getButton(ATTACH_MODEL);
    }



    /* --------------------- Контейнер "Модель пациента" --------------------------- */

    /**
     * Получение контейнера "Модель пациента"
     * @return контейнер "Модель пациента"
     */
    public Container getContainerPatientModel()
    {
        return getContainer("modelPatient");
    }

    /**
     * Получение таблицы в контейнере "Модель пациента"
     * @return таблицу в контейнере "Модель пациента"
     */
    public Table getPatientModelTable()
    {
        return getContainerPatientModel().getTable();
    }

    /**
     * Получение кнопки "+" в контейнере "Модель пациента"
     * @return кнопку "+" в контейнере "Модель пациента"
     */
    public Button getAddPatientModelButton()
    {
        return getContainerPatientModel().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "х" в контейнере "Модель пациента"
     * @return кнопку "х" в контейнере "Модель пациента"
     */
    public Button getDeletePatientModelButton()
    {
        return getContainerPatientModel().getButton(DELETE_BUTTON);
    }

    /* --------------------- Модальные окна, открываемые с этой страницы --------------------------- */

    /**
     * Модальное окно "Установить модель" вызывается из этого класса, тк открывается со страницы "Карточка мероприятия"
     * @return Модальное окно "Установить модель"
     */
    public SetModelModal getSetModelModal()
    {
        return new SetModelModal(app);
    }

    /**
     * Модальное окно "Задать модель" вызывается из этого класса, тк открывается со страницы "Карточка мероприятия"
     * @return Модальное окно "Задать модель"
     */
    public AttachModelModal getAttachModelModal()
    {
        return new AttachModelModal(app);
    }

    /**
     * Возвращает последнее активное модальное окно. Ожидается, что это окно предупреждения после удаления модели пациента.
     * @return последнее активное модальное окно.
     */
    public Modal getConfirmDeletePatientModelModal()
    {
        return page.getModal();
    }

    public Button getConfirmDeletePMModalButton()
    {
        return getConfirmDeletePatientModelModal().getButton(CONFIRM_BUTTON);
    }

    /**
     * Получение модального окна, подтверждающего создание "Модели пациента"
     *
     * @return
     */
    public Modal getConfirmModalPatientModel()
    {
        getModal().assertModalHeader_equal("Предупреждение");
        return getModal();
    }


}
