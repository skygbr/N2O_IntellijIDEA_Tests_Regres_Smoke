package businessFramework.module.migrants.pages;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Регистратор"
 */
public class RegistratorPage extends RegistratorHelper
{

    public RegistratorPage(ApplicationManager app)
    {
        super(app);
    }

     /**
     * Выбрать мероприятие "ОИГИЛГ"
     */
    public void chooseEvent(String eventName)
    {
        Tree tree = getEventsListMigrantsRegistratorTree();
        tree.chooseElementByText(eventName);
    }

    /**
     * Проверка количества записей в контейнере "Освидетельствование ИГ и ЛГ"
     */
    public void assertNoRecordsInMigrantsContainer()
    {
        getMigrantsRegistratorTable().assertNoRecords();
    }

    /**
     * Получение и нажатие кнопки Изменить
     */
    public void pressUpdateEventButton()
    {
        getUpdateEventButton().click();
    }

    /**
     * Нажатие кнопки "Назад"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }



    /*------------------------ Нажатие кнопок в контейнере "Освидетельствование ИГ и ЛГ” ---------------------*/

    /**
     * Нажатие кнопки "Добавить пациента"
     */
    public void clickAddPatientButton()
    {
        getAddPatientButton().click();
    }

    /**
     * Нажатие кнопки "Карточка"
     */
    public void clickCardButton()
    {
        getCardButton().click();
    }

    /**
     * Проверка значений в найденной записи в таблице "Освидетельствование ИГ и ЛГ" в контейнере migrantList
     *
     * @param fio       значение "ФИО"
     * @param birthDate значение "Дата рождения"
     *
     * @return номер строки, если найдена такая запись
     */
    public int checkPatientsTableValues(String fio, String birthDate)
    {
         Map<String, String> columnsAndValues = new HashMap<>();

        if (fio != null)        { columnsAndValues.put(PATIENT_FIO, fio); }
        if (birthDate != null)  { columnsAndValues.put(PATIENT_BIRTHDATE, birthDate); }

        return getMigrantsRegistratorTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }


    /**
     * Получение ссылки на страницу "Карточка мероприятия" с этой страницы, тк переход на нее происходит со страницы "Список мероприятий"
     * @return ссылку на страницу "Карточка мероприятия"
     */
    public EventPage getEventPage()
    {
        return new EventPage(app);
    }

     /**
     * Получение ссылки на страницу "Поиск пациента" с этой страницы, тк переход на нее происходит со страницы "Список мероприятий"
     *
     * @return ссылку на страницу "Карточка мероприятия".
     */
    public PatientSearchPage getPatientSearchPage()
    {
        return new PatientSearchPage(app);
    }



}
