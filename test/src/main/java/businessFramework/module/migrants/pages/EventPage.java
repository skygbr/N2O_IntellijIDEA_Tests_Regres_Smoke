package businessFramework.module.migrants.pages;

import junit.framework.Assert;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPage extends EventHelper
{
    public EventPage(ApplicationManager app)
    {
        super(app);
    }

    // --------------------- Контейнер "Карточка мероприятия" --------------------------- //


    /**
     * Проверка значений в полях на форме в контейнере “Карточка мероприятия”. Можно проверять не все поля, а некоторые. Которые не надо проверять, надо передавать как null.
     *
     * @param eventName     Значение поля "Наименование"
     * @param eventType     Значение поля "Вид мероприятия"
     * @param organization  Значение поля "Организация"
     * @param financingType Значение поля "Вид финансирования"
     * @param beginDate     Значение поля "Дата начала"
     * @param endDate       Значение поля "Дата окончания"
     * @param standart      Значение поля "Стандарт лечения"
     */
    public void checkFields(String eventName, String eventType, String organization, String financingType, String beginDate, String endDate, String standart)
    {
        if (eventName != null)      { getEventNameField().assertValue(eventName); }
        if (eventType != null)      { getEventTypeField().assertValue_equals(eventType);}
        if (organization != null)   { getOrganisationField().assertValue_equals(organization);}
        if (financingType != null)  { getFinancingTypeField().assertValue_equals(financingType);}
        if (beginDate != null)      { getBeginDateField().assertThatDateContainsValue(beginDate);}
        if (endDate != null)        { getEndDateField().assertThatDateContainsValue(endDate);}
        if (standart != null)       { getStandartField().assertValue_equals(standart);}
    }


    /**
     * Заполнение значений в полях на форме в контейнере “Карточка мероприятия”. Можно заполнять не все поля, а некоторые. Которые не надо заполнять, надо передавать как null.
     *
     * @param eventName     Значение поля "Наименование"
     * @param eventType     Значение поля "Вид мероприятия"
     * @param organization  Значение поля "Организация"
     * @param financingType Значение поля "Вид финансирования"
     * @param beginDate     Значение поля "Дата начала"
     * @param endDate       Значение поля "Дата окончания"
     * @param standart      Значение поля "Стандарт лечения"
     */
    public void fillFields(String eventName, String eventType, String organization, String financingType, String beginDate, String endDate, String standart)
    {
        if (eventName != null)      { getEventNameField().setValue(eventName); }
        if (eventType != null)      { getEventTypeField().setValue(eventType);}
        if (organization != null)   { getOrganisationField().setValue(organization);}
        if (financingType != null)  { getFinancingTypeField().setValue(financingType);}
        if (beginDate != null)      { getBeginDateField().setValue(beginDate);}
        if (endDate != null)        { getEndDateField().setValue(endDate);}
        if (standart != null)       { getStandartField().setValue(standart);}
    }

    /**
     * Проверка, что поля задизейблены. Можно проверять не все поля, а выборочно. Те поля, которые не нужно проверять, надо передавать как null.
     *
     * @param eventName         Поле "Наименование"
     * @param eventType         Поле "Вид мероприятия"
     * @param organization      Поле "Организация"
     * @param financingType     Поле "Вид финансирования"
     * @param beginDate         Поле "Дата начала"
     * @param endDate           Поле "Дата окончания"
     * @param standart          Поле "Стандарт лечения"
     */
    public void checkFieldsDisability(String eventName, String eventType, String organization, String financingType, String beginDate, String endDate, String standart)
    {
        if (eventName != null)      { getEventNameField().assertIsDisabled(true); }
        if (eventType != null)      { getEventTypeField().assertThatComboboxIsDisabled();}
        if (organization != null)   { getOrganisationField().assertThatComboboxIsDisabled();}
        if (financingType != null)  { getFinancingTypeField().assertThatComboboxIsDisabled();}
        if (beginDate != null)      { getBeginDateField().assertIsDisabled(true);}
        if (endDate != null)        { getEndDateField().assertIsDisabled(true);}
        if (standart != null)       { getStandartField().assertThatComboboxIsDisabled();}
    }

    /**
     * Нажатие кнопки "Сохранить" в контейнере “Карточка мероприятия”.
     */
    public void clickSaveButton()
    {
        getSaveEventButton().click();
        //todo в предупреждение нет необходимости
        //getConfirmModalPatientModel().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Нажатие кнопки "Изменить" в контейнере "Карточка мероприятия"
     */
    public void clickEditButton()
    {
        getEditButton().click();
    }



    // --------------------- Контейнер "Модель пациента" --------------------------- //

    /**
     * Нажатие кнопки "+" в контейнере "Модель пациента"
     */
    public void clickAddPatientModelButton()
    {
        getAddPatientModelButton().click();
    }

    /**
     * Нажатие кнпоки "х" в контейнере "Модель пациента"
     */
    public void clickDeletePatientModelButton()
    {
        getDeletePatientModelButton().click();
    }


    // --------------------- Кнопки в контейнере "Услуги" --------------------------- //

    /**
     * Нажатие кнопки "Задать модель всем услугам"
     */
    public void clickAttachModelButton()
    {
        getAttachModelToAllServicesButton().click();
    }


    // --------------------- Контейнер "Услуги" --------------------------- //

    /**
     * Проверка, что все значения в столбце "Модель пациента" в таблице "Услуги" равны ожидаемому значению.
     *
     * В первой строке по сценарию должно быть две модели пациента. Поэтому будем проверять первую строчку таким образом:
     *  - Получить одну строку и поделить по запятой ее на подстроки.
     *  - В каждой подстроке будет одно значение.
     *  - В итоге получим два значения, и одно из них должно быть равно ожидаемому.
     *
     * @param modelName ожидаемое значение.
     */
    public void checkThatModelSetToAllServices(String modelName)
    {

        String firstRowFullValue            = getServicesTable().getRowColumnIntersectionValue(0, PATIENT_MODEL, true); // полное значение первой строки столбца "Модель пациента"

        if (!firstRowFullValue.contains(modelName))
        {
            Assert.fail(String.format("Первая строка в таблице Услуги в столбце '%s' не содержит ожидаемого значения(%s). ", PATIENT_MODEL, modelName));
        }

        List<String> allBaseModels = getServicesTable().getColumnValues(PATIENT_MODEL);

        for (int i = 1; i< allBaseModels.size(); i++)
        {
            if(!allBaseModels.get(i).equals(modelName))
            {
                Assert.fail(String.format("Одно из значений(%s) в столбце '%s' не равно ожидаемому %s", allBaseModels.get(i), PATIENT_MODEL, modelName));
            }
        }
    }


    /**
     * Удаление всех моделей пациента.
     * Удаление происходит следующим образом:
     * - Для каждой строчки в таблице "Услуги" выбирается очередная строчка.
     * - Для этой строчки проверяется, что в таблице "Модель пациента" есть записи, и по одной эти записи удаляются.
     * После всех удалений происходит обновление таблицы "Услуги" путем нажатия на кнопку в выпадающем меню
     * И проверяется, что после обновления в столбце "Модель пациента" таблицы "Услуги" нет значений.
     */
    public void deleteAllPatientModels()
    {

        int countOfRowsInServicesTable = getServicesTable().getCountRowsInTable(true);

        for (int i = 0; i < countOfRowsInServicesTable; i++)
        {

            getServicesTable().chooseRowInTable(i);

            int size = getPatientModelTable().getCountRowsInTable(true);

            if (!getPatientModelTable().assertNoRecordsReturnResult() && (getPatientModelTable().getCountRowsInTable(true) > 0))
            {
                for (int j = 0; j < size; j++)
                {
                    int countBeforeDeleting = getPatientModelTable().getCountRowsInTable(true);

                    getPatientModelTable().chooseRowInTable(0);
                    clickDeletePatientModelButton();

                    getConfirmDeletePatientModelModal().assertModalHeader_equal("Предупреждение");
                    getConfirmDeletePMModalButton().click();

                    assertThat(getPatientModelTable().getCountRowsInTable(true), lessThan(countBeforeDeleting));
                }
            }

        }

        getContainerServices().clickDropdownToggle("Обновить");

        List<String> countOfRecordsInServicesTable_columnPM = getServicesTable().getColumnValues(PATIENT_MODEL);
        for (String columnValue: countOfRecordsInServicesTable_columnPM)
        {
            assertThat(columnValue, equalTo(""));
        }
    }

    /**
     * Проверяет, что в таблице "Модель пациента" есть запись, которая нам нужна.
     *
     * @param modelName значение столбца "Наименование" искомой записи
     * @return номер строки с найденной записью.
     */
    public int checkPatientModelTableValues(String modelName)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (modelName != null)
        {
            columnsAndValues.put(NAME_COLUMN, modelName);
        }

        return getPatientModelTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
