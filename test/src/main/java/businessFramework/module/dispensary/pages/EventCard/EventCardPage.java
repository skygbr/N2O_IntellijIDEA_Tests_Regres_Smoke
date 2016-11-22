package businessFramework.module.dispensary.pages.EventCard;

import businessFramework.module.dispensary.modal.SetModel.SetModelModal;
import businessFramework.module.dispensary.modal.addPatient.AddPatientModal;
import businessFramework.module.dispensary.modal.patientsSearch.PatientsSearchModal;
import businessFramework.module.dispensary.modal.setModelAllServices.SetModelAllServicesModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class EventCardPage extends EventCardHelper {
    public EventCardPage(ApplicationManager app) {
        super(app);
    }

    // Сравнивает данные в полях на странице "Карточка мероприятия"
    public void comparingFieldsData(String checkedEventName,
                                    String checkedEventType,
                                    String checkedBeginDate,
                                    String checkedEndDate,
                                    String checkedStandart,
                                    String checkedOrganisationName,
                                    String checkedFundingType) {
        getEventName().assertValue(checkedEventName);
        getEventType().assertValue_equals(checkedEventType);
        getBeginDate().assertValue(getBeginDate().getValue(), checkedBeginDate);
        getEndDate().assertValue(getEndDate().getValue(), checkedEndDate);
        getStandart().assertValue_equals(checkedStandart);
        getOrganisationName().assertValue_equals(checkedOrganisationName);
        getFundingType().assertValue_equals(checkedFundingType);
    }

    // Проверяет, задизейблено ли поле "Стандарт лечения"
    public void assertThatStandartFieldIsDisabled() {
        getStandart().assertThatComboboxIsDisabled();
    }

    // Заполнить данные в полях на странице "Карточка мероприятия"
    public void fullFieldsValues(String changedEventName, String changedEventType, String checkedFundingType, String changedBeginDate, String changedEndDate, String checkedStandard) {
        getEventName().setValue(changedEventName);
        getEventType().setValue(changedEventType);
        getFundingType().setValue(checkedFundingType);
        getBeginDate().setValue(changedBeginDate);
        getEndDate().setValue(changedEndDate);
        getStandart().setValue(checkedStandard);

    }
    // Изменить данные в полях на странице "Карточка мероприятия"
    public void changeFieldsValues(String changedEventName, String changedBeginDate, String changedEndDate) {
        getEventName().setValue(changedEventName);
        getBeginDate().setValue(changedBeginDate);
        getEndDate().setValue(changedEndDate);
    }

    // Нажать кнопку "Сохранить"
    public void pressSaveButton() {
        getSaveButton().click();
    }

    // Нажать кнопку "Изменить"
    public void pressEditButton() {
        getEditButton().click();
    }

    // Нажать кнопку "Назад"
    public void pressBackButton() {
        getBackButton().click();
    }

    // Проверка, что появилось сообщение об успешном сохранении
    public void checkSuccessMessage() {
        getForm().getAlerts().assertSuccessAlertIsPresent();
    }


    /* ---------------------- Контейнер "Пациенты" ------------------------ */

    // Открытие контейнера "Пациенты"
    public void checkPatientsContainer() {
        getContainerPatients().clickContainer();
    }

    //Нажимает кнопку "Отобрать пациентов" в контейнере "Пациенты"
    public void pressSelectPatientsButton() {
        getButtonSelectPatients().click();
        getConfirmModalAfterSelectPatients().getButton(N2O_CONFIRM_BUTTON).click();
    }

    // Проверка, что в контейнере 'Пациенты' отобрался нужный пациент.
    public void checkSelectedPatientInPatientsTable(Map<String, String> patients) {
        int countOfTableElements = getPatientsTable().getCountRowsInTable(true);
        for (HashMap.Entry<String, String> entry : patients.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            for (int i = 0; i < countOfTableElements; i++) {
                assertThat(getPatientsTable().getRowColumnIntersectionValue(i, key, true), containsString(value));
            }
        }
    }


    /* ---------------------- Контейнер "Модель пациента" ------------------------ */

    // Проверка, что появилось сообщение об успешном сохранении в правом регионе ( контейнер Модель пациента)
    public void checkPatientModelSuccessMessage() {
        getContainerPatientModel().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    // Проверка количества записей в таблице "Модель пациента"
    public void assertCountOfRecordsInPatientModelTable(int count) {
        getPatientModelTable().assertNoRecords();
    }

    // Нажимает кнопку "Добавить" в контейнере "Модель пациента" (открывается модальное окно setModelModal)
    public void pressAddButton() {
        getAddButton().click();
    }

    // Нажимает кнопку "Удалить" в контейнере "Модель пациента"
    public void pressPatientModelDeleteButton() {
        getPatientModelDeleteButton().click(); // Нажать кнопку "Удалить" в контейнере "Модель пациента"
        getConfirmModalAfterDeletePatientModel().getButton(CONFIRM_BUTTON).click(); // Нажать кнопку "Да" в подтверждающем удаление модальном окне.
    }

    // Получение количества записей в контейнере "Модель пациента"
    public int getCountOfRecordsPatientModel() {
        return getContainerPatientModel().getTable().getCountRowsInTable(true);
    }

    // Получение записи по номеру строки в контейнере "Модель пациента"
    public String getPatientModelRecord(int rowNumber) {
        return getContainerPatientModel().getTable().getRowValueInTable(rowNumber, true);
    }

    // Сравнение значений в строках в контейнере "Модель пациента"
    public void compareRowsCountAfterDelete(int before, int after) {
        assertThat("Before delete was " + before + " rows in table, but after delete must be less, but have" + after + " rows.", before - 1, equalTo(after));
    }

    /**
     * Проверка, что в таблице есть/нет переданное значение
     *
     * @param value          значение, которое ожидается в таблице
     * @param expectedResult ожидаемый результат
     */
    public void checkValueInTable(String value, Boolean expectedResult) {
        Boolean found = false;
        List<String> columnValues = getContainerPatientModel().getTable().getColumnValues("Наименование");
        for (String columnValue : columnValues) {
            if (columnValue.equals(value)) {
                found = true;
                break;
            }
        }
        assertThat(found, equalTo(expectedResult));
    }

    /**
     * Получение модального окна Модель пациента
     *
     * @return модальное окно "Модель пациента"
     */
    public SetModelModal setModelModal() {
        return new SetModelModal(app);
    }

    /**
     * Получение модального окна "Добавить пациента"
     *
     * @return модальное окно "Добавить пациента"
     */
    public AddPatientModal addPatientModal() {
        return new AddPatientModal(app);
    }

    // Получение модального окна "Поиск пациентов”
    public PatientsSearchModal patientsSearchModal() {
        return new PatientsSearchModal(app);
    }

    // Проверка, что значение модели пациента, которое было выбрано в окне "Список моделей пациента" соответствует значению, которое присутствует в таблице
    // в контейнере "Модель пациента" на странице "Карточка мероприятия"
    public void checkRecordInTablePatientModelContainer(String recordToCheck) {
        getContainerPatientModel().getTable().assertThatCountOfRowsIs(1);
        getContainerPatientModel().getTable().assertThatColumnValueIsEqualToGetted(getContainerPatientModel().getTable().getRowColumnIntersectionValue(0, "Наименование", true), recordToCheck);
    }

    /* -------------------------------------- Контейнер "Услуги" ---------------------------------------- */

    // Выбор первой услуги
    public void selectService(int count) {
        getServicesTable().chooseRowInTable(count);
    }

    // Нажатие кнопки "Назначить модель всем услугам"
    public void pressAttachModelButton() {
        getSetModelToAllServicesButton().click();
    }

    // Получение модального окна "Задать модель" (всем услугам)
    public SetModelAllServicesModal setModelAllServicesModal() {
        return new SetModelAllServicesModal(app);
    }

    // Проверка, что в контейнере 'Услуги' у всех записей услуг отображена выбранная модель пациента.
    public void checkSelectedModelInServicesTableForAllServices(String model1, String model2) {
        int countOfTableElements = getServicesTable().getCountRowsInTable(true);

        for (int i = 0; i < countOfTableElements; i++) {
            if (i == 0) { // В первой строчке по тест-дизайну будет две модели пациента.
                assertThat(getServicesTable().getRowColumnIntersectionValue(i, "Модель пациента", true), containsString(model1));
                assertThat(getServicesTable().getRowColumnIntersectionValue(i, "Модель пациента", true), containsString(model2));
            } else {
                assertThat(getServicesTable().getRowColumnIntersectionValue(i, "Модель пациента", true), equalTo(model1));
            }
        }
    }

    // Удаление всех моделей пациента у всех услуг из списка услуг в таблице
    public void deleteAllPatientsModels() {
        Table servicesTable = getServicesTable();

        int nextPages = servicesTable.getPages().size();

        for (int i = 0; i < nextPages; i++) {
            if (i != 0) servicesTable.chooseNextPage(); //на первом проходе не переключаем страницу
            int countOfRecords = servicesTable.getCountRowsInTable(true);
            for (int j = 0; j < countOfRecords; j++) {
                servicesTable.chooseRowInTable(j);// нажать на строчку в таблице услуг
                if (getContainerPatientModel().getTable().getCountRowsInTable(true) > 0) {
                    getPatientModelDeleteButton().click();
                    getConfirmModalAfterDeletePatientModel().getButton(CONFIRM_BUTTON).click(); // Нажать кнопку "Да" в подтверждающем удаление модальном окне.
                }
                getContainerPatientModel().getTable().assertNoRecords();
            }
        }
        getContainerServicesEventCard().clickDropdownToggle("Обновить");
    }
}
