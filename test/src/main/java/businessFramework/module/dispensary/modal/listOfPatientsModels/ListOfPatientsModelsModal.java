package businessFramework.module.dispensary.modal.listOfPatientsModels;

import net.framework.autotesting.ApplicationManager;

public class ListOfPatientsModelsModal extends ListOfPatientsModelsHelper
{

    public ListOfPatientsModelsModal(ApplicationManager app)
    {
        super(app);
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
