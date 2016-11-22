package businessFramework.module.phthisiatry.modals;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
/**
 * Описывает модальное окно добавления врача.
 * Это модальное окно открывает выбор Врача
 *
 */
public class VrachSearchModal extends VrachSearchHelper
{
    public VrachSearchModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Добавить врача"
     */
    public void checkModalHeader()
    {
        getVrachSearchModal().assertModalHeader_equal("Врач");
    }

    /**
     * Нажатие кнопки "Лупа" в поле "Врач"
     */
    public void pressFindButtonVrach()
    {
        getVrach().findModalButtonClick();
    }

    /**
     * Проверка значения в классифаере "Врач" для модального окна
     * @param fullName - значение, которое ожидается в классифаере "Врач"
     */
    public void checkValueInVrach(String fullName)
    {
        getVrach().assertValue_equals(fullName);
    }

    /**
     * Заполнение полей значениями. Можно заполнять выборочно поля, для этого передать null как параметр в случае, если поле заполнять на надо.
     *
     * @param surname           Значение для поля "Фамилия"
     * @param name              Значение для поля "Имя"
     * @param patrName          Значение для поля "Отчество"
     * @param birthDate         Значение дял поля "Дата рождения"
     * @param posName           Значение для поля "Должность"
     */
    public void fillFields(String surname, String name, String patrName, String birthDate, String posName)
    {
        if (surname != null)        { getSurnameField().setValue(surname); }
        if (name != null)           { getNameField().setValue(name); }
        if (patrName != null)       { getPatrNameField().setValue(patrName); }
        if (birthDate != null)      { getBirthDateField().setValue(birthDate); }
        if (posName != null)        { getPosNameField().setValue(posName); }
    }

    /* ------------------ Нажатие кнопок в модальном окне ----------------- */

    /**
     * Нажатие кнопки "Найти"
     */
    public void clickSearchVrachButton()
    {
        getSearchVrachButton().click();
    }

    /**
     * Нажатие кнопки "Выбрать"
     */
    public void clickChooseVrachButton()
    {
        getChooseVrachButton().click();
    }

    /**
     * Проверяет, что в таблице "Поиск врача" есть запись, которая нам нужна.
     * Название столбца соединяет
     *
     * @param surname       Значение столбца "Наименование" искомой записи
     * @param name          Значение столбца "Наименование" искомой записи
     * @param patrName      Значение столбца "Наименование" искомой записи
     * @param birthDate     Значение столбца "Наименование" искомой записи
     *
     * @return номер строки с найденной записью.
     */
    public int checkFoundVrachListTableValues(String surname, String name, String patrName, String birthDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();
        String concatenatedFIO               = String.format("%s %s %s", surname, name, patrName, birthDate);

        if (concatenatedFIO != null)
        {
            columnsAndValues.put(VRACH_FIO, concatenatedFIO);
        }

        return getFoundVrachListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

    /**
     * Проверяет запись в таблице на соответствие ожидаемой
     */
    public int checkVrachListTableValues(String fio, String birthDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (fio != null)        { columnsAndValues.put(VRACH_FIO, fio); }
        if (birthDate != null)  { columnsAndValues.put(VRACH_BIRTHDATE, birthDate); }

        return getFoundVrachListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }

}
