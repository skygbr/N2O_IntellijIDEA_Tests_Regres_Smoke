package businessFramework.module.migrants.modals;

import junit.framework.Assert;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Модальное окно "Список моделей пациента".
 * Вызывается с модального окна "Назначить модель" путем нажатия кнопки "Лупа" в компоненте "Модель пациента"
 */
public class PatientModelsListModal extends PatientModalsListHelper
{

    public PatientModelsListModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Выбирает первую запись в списке моделей пациента
     */
    public void selectRecordInPatientsListTable(Integer rowNumber)
    {
        if (rowNumber != null)
        {
            getModelsTable().chooseRowInTable(rowNumber);
        }
        else
        {
            getModelsTable().chooseRowInTable(0);
        }
    }

    /**
     * Нажать кнопку "Выбрать"
     */
    public void clickChooseModelButton()
    {
        getChooseModelButton().click();
    }


    /**
     * Получает значение первой записи в списке моделей пациента
     * @return значение первой записи в списке моделей пациента
     */
    public String getSelectedModelValue()
    {
        return getModelsTable().getColumnValues(NAME_COLUMN).get(0);
    }

    /**
     * Выбор модели, которая не установлена ни в качетсве базовой, ни в качестве Модели пациента для данной услуги.
     *
     * @param firstModel модель пациента (которая была установлена в шаге "Создание модели пациента" данного теста)
     * @param baseModels список базовых моделей(берется со страницы "Карточка мероприятия", табилца "услуги")
     *
     * @return Модель, которая удовлетворяет условиям, указанным в описании метода.
     */
    public String selectNotSettedModel(String firstModel, List<String> baseModels)
    {
        String foundPatientModel = null;
        List<String> listOfPatientModels = getModelsTable().getColumnValues(NAME_COLUMN);

        for (String patientModelRecord: listOfPatientModels)
        {
            for (String baseModel: baseModels)
            {
                if (!patientModelRecord.equals(baseModel) && !patientModelRecord.equals(firstModel))
                {
                    foundPatientModel = patientModelRecord;
                    return foundPatientModel;
                }
            }
        }

        Assert.fail(String.format("Не найдена подходящая модель пациента. \n Необходимо, чтоб модель пациента была не равна ни одной базовой модели в таблице 'Услуги' и не равна %s", firstModel));
        return foundPatientModel;
    }


    /**
     * Проверяет, что в таблице "Список моделей пациента" есть запись, которая нам нужна.
     *
     * @param modelName значение столбца "Наименование" искомой записи
     * @return номер строки с найденной записью.
     */
    public int checkListOfPatientModelsTableValues(String modelName)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (modelName != null)
        {
            columnsAndValues.put(NAME_COLUMN, modelName);
        }

        return getModelsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }


}
