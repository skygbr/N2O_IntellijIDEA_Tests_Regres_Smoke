package businessFramework.module.ambulance.modal;

import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Добавить сотрудника в шаблон вида бригады 'ЛИН1'".
 * Это модальное окно открывается со страницы "Настройка вида бригады" по нажатию кнопки "Добавить" в контейнере "Сотрудники"
 */
public class AddEmployeeModal extends AddEmployeeHelper
{

    public AddEmployeeModal(ApplicationManager app)
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
        getAddEmployeeModal().assertModalHeader_equal(header);
    }

    /**
     * Заполнение полей
     *
     * @param role              Значение для поля "Роль"
     * @param personalCategory  Значение для поля "Категория персонала"
     * @param workingPlace      Занчение для поля "Рабочее место"
     * @param position          Значение для поля "Должность"
     * @param speciality        Значение для поля "Специальность"
     */
    public void fillFields(String role, String personalCategory, String workingPlace, String speciality, String position)
    {
        if (role != null)               { getRoleField().setValue(role); }
        if (personalCategory != null)   { getPersonalCategory().setValue(personalCategory); }
        if (workingPlace != null)       { getWorkingPlaceField().setValue(workingPlace); }
        if (speciality != null)         { getSpetialityField().setValue(speciality); }
        if (position != null)           { getPositionField().setValue(position); }
    }

    /**
     * Проверка значений полей
     *
     * @param role              Значение поля "Роль"
     * @param personalCategory  Значение поля "Категория персонала"
     * @param workingPlace      Занчение поля "Рабочее место"
     */
    public void checkFields(String role, String personalCategory, String workingPlace)
    {
        if (role != null)               { getRoleField().assertValue_equals(role); }
        if (personalCategory != null)   { getPersonalCategory().assertValue_contains(personalCategory); }
        if (workingPlace != null)       { getWorkingPlaceField().assertValue(workingPlace); }
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveEmployeeButton()
    {
        getSaveEmployeeButton().click();
    }

}
