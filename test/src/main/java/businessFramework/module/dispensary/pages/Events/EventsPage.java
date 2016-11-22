package businessFramework.module.dispensary.pages.Events;

import businessFramework.module.Values;
import businessFramework.module.dispensary.modal.agreement.AgreementModal;
import businessFramework.module.dispensary.modal.editAppointments.EditAppointmentsModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Tree;


public class EventsPage extends EventsHelper implements Values {
    public EventsPage(ApplicationManager app) {
        super(app);
    }


    /**
     * Выбор тестового мероприятия
     * @param eventName Название мероприятия
     * @param year Название родительской ноды в дереве, если мероприятие доступно сразу передать значение null
     */
    public void chooseEvent(String eventName, String year)
    {
        Tree tree = getEventsListGibddRegistratorTree();
        if (year!=null) {
            tree.chooseElementByText(year);
            tree.chooseElementByText(eventName);
        }
        else {
            tree.chooseElementByText(eventName);
        }
    }

    /**
     * Проверка количества записей в контейнере "Пациенты"
     */
    public void assertNoRecordsInPatientContainer()
    {
        getEventsListTable().assertNoRecords();
    }

    /**
     * Нажатие кнопки "Добавить пациента"
     */
    public void pressAddPatientButton()
    {
        getContainerPatients().clickDropdown("Еще", "Добавить пациента", "addPatient");
    }

    /* ------------------- Контейнер "Мероприятия" ------------------------- */

    /**
     * Получение и нажатие кнопки Изменить
     */
    public void pressUpdateEventButton()
    {
        getUpdateEventButton().click();
    }


    /**
     * Получение и нажатие кнопки Создать
     */
    public void pressCreateEventButton()
    {
        getCreateEventButton().click();
    }



    /* ------------------- Контейнер "Пациенты" ------------------------- */

    public void deletePatient()
    {
        getContainerPatients().clickDropdown("Еще", "Удалить пациента", "removePatient");
        getDialog().clickYes();
        getContainerPatients().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Нажатие кнопки "Карточка"
     */
    public void pressCardButton()
    {
        getCardButton().click();
    }

    /**
     * Нажатие кнопки "Согласие"
     */
    public void pressAgreementButton()
    {
        getAgreementButton().click();
    }

    /**
     * Нажатие кнопки "Изменить назначения"
     */
    public void pressEditAppointmentsButton()
    {
        getContainerPatients().clickDropdown("Еще", "Просмотр назначений", "editPresFroPatient3");
    }

    /**
     * Получение модального окна "Согласие"
     * @return модальное окно "Согласие"
     */
    public AgreementModal getAgreementModal() {
        return new AgreementModal(app);
    }

    /**
     * Получение модального окна "Изменить назначения"
     * @return модальное окно "Изменить назначения"
     */
    public EditAppointmentsModal getEditAppointmentsModal() {
        return new EditAppointmentsModal(app);
    }
}