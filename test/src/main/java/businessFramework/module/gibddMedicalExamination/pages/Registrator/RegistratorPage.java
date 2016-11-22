package businessFramework.module.gibddMedicalExamination.pages.Registrator;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

public class RegistratorPage extends RegistrationHelper
{

    public RegistratorPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Выбрать мероприятие "ОДОДСГ"
     */
    public void chooseEvent(String eventName)
    {
        Tree tree = getEventsListGibddRegistratorTree();
        tree.chooseElementByText(eventName);
    }

    /**
     * Проверка количества записей в контейнере "Пациенты"
     */
    public void assertNoRecordsInPatientContainer()
    {
        getEventsListGibddRegistratorTable().assertNoRecords();
    }


    /**
     * Нажатие кнопки "Добавить пациента"
     */
    public void pressAddPatientButton()
    {
        getAddPatientButton().click();
    }


        /* ------------------- Контейнер "Мероприятия" ------------------------- */

    /**
     * Получение и нажатие кнопки Изменить
     */
    public void pressUpdateEventButton()
    {
        getUpdateEventButton().click();
    }

    /* ------------------- Контейнер "Пациенты" ------------------------- */

    /**
     * Проверяет запись в таблице "Пациенты" на соответствие ожидаемой.
     *
     * @param columnsAndValues названия столбцов и данные этих столбцов
     */
    public void checkPatientsTableValues(Map<String, String> columnsAndValues)
    {
        int rowNumber = getEventsListGibddSpravkaRegistratorTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

        assertThat("Найденная запись не соответствует ожидаемой", rowNumber, equalTo(0));
    }

    /**
     * Нажатие кнопки "Карточка"
     */
    public void pressDriverCardButton()
    {
        getDriverCardButton().click();
    }

}
