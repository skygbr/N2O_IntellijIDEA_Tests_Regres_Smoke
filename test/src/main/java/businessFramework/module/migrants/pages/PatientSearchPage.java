package businessFramework.module.migrants.pages;

import businessFramework.module.migrants.modals.PatientSearchModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс описывает страницу "Поиск пациента"
 */
public class PatientSearchPage extends PatientSearchHelper
{
    public PatientSearchPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Лупа" в компоненте выбора пациента
     */
    public void clickSearchPatient()
    {
        getPatientSearchComponent().findModalButtonClick();
    }

    /**
     * Получение ссылки на модальное окно "Поиск пациентов" с этой страницы, т.к. с нее происходит открытие этого модального окна.
     * @return модальное окно "Поиск пациентов"
     */
    public PatientSearchModal getAddPatientModal()
    {
        return new PatientSearchModal(app);
    }

    /**
     * Проверяет, что значение в поле "Пациент" совпадает с ожидаемым
     * @param fullValue ожидаемое значение поля "Пациент"
     */
    public void checkThatPatientNameAppearsInField(String fullValue)
    {
        getPatientSearchComponent().assertValue_equals(fullValue);
    }

    /**
     * Проверяет запись в таблице на соответствие ожидаемой
     */
    public int checkTableValues(String fio, String birthDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (fio != null)        { columnsAndValues.put(PATIENT_FIO, fio); }
        if (birthDate != null)  { columnsAndValues.put(PATIENT_BIRTHDATE, birthDate); }

        return getFoundPatientsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Нажатие кнопки "Найти"
     */
    public void clickFindPatientButton()
    {
        getFindButton().click();
    }

    /**
     * Нажатие кнопки "Создать новую"
     */
    public void clickCreateNewCardButton()
    {
        getCreateNewCardButton().click();
    }

    /**
     * Нажатие кнопки "Назад"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }

}
