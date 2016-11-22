package businessFramework.module.migrants.modals;


import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Описывает модальное окно добавления пациента.
 * Это модальное окно открывается со страницы "Карточка мероприятия" по нажатию кнопки "Добавить пациента" в контейнере "Освидетельствование ИГ и ЛГ"
 *
 */
public class PatientSearchModal extends PatientSearchModalHelper
{
    public PatientSearchModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверяет заголовок модального окна на эквивалентность строке, переданной в параметре header
     * @param header ожидаемый заголовок модального окна."
     */
    public void checkModalHeader(String header)
    {
        getPatientSearchModal().assertModalHeader_equal(header);
    }


    /**
     * Заполнение полей значениями. Можно заполнять выборочно поля, для этого передать null как параметр в случае, если поле заполнять на надо.
     *
     * @param surname           Значение для поля "Фамилия"
     * @param name              Значение для поля "Имя"
     * @param patrName          Значение для поля "Отчество"
     * @param birthDate         Значение дял поля "Дата рождения"
     * @param documentNumber    Значение для поля "Номер документа"
     */
    public void fillFields(String surname, String name, String patrName, String birthDate, String documentNumber)
    {
        if (surname != null)        { getSurnameField().setValue(surname); }
        if (name != null)           { getNameField().setValue(name); }
        if (patrName != null)       { getPatrNameField().setValue(patrName); }
        if (birthDate != null)      { getBirthDateField().setValue(birthDate); }
        if (documentNumber != null) { getDocumentNumberField().setValue(documentNumber); }
    }

    /* ------------------ Нажатие кнопок в модальном окне ----------------- */

    /**
     * Нажатие кнопки "Найти"
     */
    public void clickSearchPatientButton()
    {
        getSearchPatientButton().click();
    }

    /**
     * Нажатие кнопки "Выбрать"
     */
    public void clickChoosePatientButton()
    {
        getChoosePatientButton().click();
    }

    /**
     * Проверяет, что в таблице "Поиск пациентов" есть запись, которая нам нужна.
     * Название столбца соединяет
     *
     * @param surname       Значение столбца "Наименование" искомой записи
     * @param name          Значение столбца "Наименование" искомой записи
     * @param patrName      Значение столбца "Наименование" искомой записи
     * @param birthDate     Значение столбца "Наименование" искомой записи
     *
     * @return номер строки с найденной записью.
     */
    public int checkFoundPatientsListTableValues(String surname, String name, String patrName, String birthDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();
        String concatenatedFIO               = String.format("%s %s %s", surname, name, patrName, birthDate);

        if (concatenatedFIO != null)
        {
            columnsAndValues.put(PATIENT_FIO, concatenatedFIO);
        }

        return getFoundPatientsListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
