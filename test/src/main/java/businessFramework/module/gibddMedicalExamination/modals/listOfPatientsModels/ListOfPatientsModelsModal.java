package businessFramework.module.gibddMedicalExamination.modals.listOfPatientsModels;

import businessFramework.module.gibddMedicalExamination.modals.patientModel.PatientModelModal;
import net.framework.autotesting.ApplicationManager;

public class ListOfPatientsModelsModal extends ListOfPatientsModelsHelper
{

    public ListOfPatientsModelsModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Создать" в модальном окне "Список моделей пациента"
     */
    public void clickAddButton()
    {
        getAddButton().click();
    }

    /**
     * Получение модального окна "Модель пациента"( получаем через модальное окно "Список моделей пациента ",
     * т.к. с этого окна происходит открытие модального окна "Модель пациента")
     * @return модальное окно "Модель пациента"
     */
    public PatientModelModal getPatientModelModal()
    {
        return new PatientModelModal(app);
    }

    /**
     * Открывает последнюю страницу в таблице через пейджинг
     */
    public void openLastPage()
    {
        getModelsListTable().clickLastPageNumber();
    }

    /**
     * Выбирает последнюю запись на странице
     */
    public void selectLastRecordOnPage()
    {
        int rowNumber = getModelsListTable().getCountRowsInTable(true);
        getModelsListTable().chooseRowInTable(rowNumber-1);
    }

    /* ----------------- Работа с контейнером "Модель пациента" в модальном окне "Список моделей пациента" ----------------- */

    /**
     * Проверка значения полей в контейнере "Модель пациента"
     * @param modelNameValue ожидаемое значение поля "Название модели"
     * @param socGroupField ожидаемое значение поля "Социальная группа"
     */
    public void checkFieldsValues(String modelNameValue, String socGroupField)
    {
        getModelNameField().assertValue(modelNameValue);
        getSocGroupField().assertValue_equals(socGroupField);
    }

      /* ----------------- Работа с контейнером "Пол и возраст" в модальном окне "Список моделей пациента" ----------------- */

    /**
     * Проверка данных в таблице в контейнере "Пол и возраст"
     * @param genderExpected Ожидаемое значение значения "Пол"
     * @param ageExpected Ожидаемое значение значения "Возраст"
     */
    public void checkGenderAndAgeContainer(String genderExpected, String ageExpected)
    {
        getGenderAndAgeContainer().clickContainer();
        getGenderAndAgeTable().assertThatCountOfRowsIs(1);
        String gender = getGenderAndAgeTable().getColumnValues("Пол").get(0);
        String age = getGenderAndAgeTable().getColumnValues("Возраст").get(0);

        getGenderAndAgeTable().assertThatColumnValueIsEqualToGetted(gender, genderExpected);
        getGenderAndAgeTable().assertThatColumnValueIsEqualToGetted(age, ageExpected);

    }

    /**
     *  Удаление записи из контейнера "Список моделей пациента"
     */
    public void pressDeleteButtonInListModelsContainer()
    {
        getDeleteButton().click();
        assertCountOfModals(3);
        getConfirmButtonWarningModal().clickWithAlertAcceptation();
    }

    /**
     *  Выбор записи в модальном окне "Список моделей пациента".
     */
    public void chooseRecord()
    {
        getModelsListTable().chooseRowInTable(1);
    }

    /**
     *  Получение первой записи из таблицы в модальном окне "Список моделей пациента".
     * @return первую запись из таблицы в модальном окне "Список моделей пациента".
     */
    public String getSelectedPatientModelRecordValue()
    {
        return getModelsListTable().getColumnValues("Наименование").get(1);
    }

    /**
     * Нажатие кнопки "Выбрать" в модальном окне "Список моделей пациента"
     */
    public void pressChooseButton()
    {
        getChooseButton().click();
    }

}
