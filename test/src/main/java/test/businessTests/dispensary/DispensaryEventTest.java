package test.businessTests.dispensary;

import businessFramework.entities.dispensary.DispensaryData;
import businessFramework.module.dispensary.DispensaryManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DispensaryEventTest extends TestBase
{
    DispensaryManager dispensaryManager;
    DispensaryData dispensaryData;
    String selectedPatientModelValue = "";
    String classifierForAllModelsSelect = "";

    @BeforeClass
    public void initialize()
    {
        dispensaryData = new DispensaryData();
        dispensaryManager = new DispensaryManager();

        dispensaryData.setContextName("Подразделение для ОДОДСГ");

        // Данные для проверки значений в полях
        dispensaryData.setCheckedEventName("Тестовое мероприятие сироты");
        dispensaryData.setCheckedEventYear("Мероприятия 2016 года");
        dispensaryData.setCheckedEventType("Диспансеризация детей-сирот и детей, оставшихся без попечения родителей, в том числе усыновленных (удочеренных), принятых под опеку (попечительство) в приемную или патронатную семью");
        dispensaryData.setCheckedOrganisationName("ОДОДСГ");
        dispensaryData.setCheckedBeginDate("01.01.2016");
        dispensaryData.setCheckedEndDate("31.12.2016");
        dispensaryData.setCheckedFundingType("ОМС");
        dispensaryData.setCheckedStandart("Тестовый стандарт диспансеризация сирот");

        // Данные для изменения значений в полях
        dispensaryData.setChangedBeginDate("02.02.2016");
        dispensaryData.setChangedEndDate("28.12.2016");
        dispensaryData.setChangedEventName("Тестовое мероприятие измененное");
    }

    @Test(description = "Удаление тестовых данных")
    public void before_test()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(dispensaryData.getContextName()); // выбрать контекст
        dispensaryManager.openEventsPage();       //Открытие страницы Диспансеризация взрослого населения
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedEventYear()); // выбрать мероприятие в дереве
        while (dispensaryManager.getEventsPage().getEventsListTable().getCountRowsInTable(true)>0) {
            dispensaryManager.getEventsPage().getEventsListTable().chooseRowInTable(0); // выбрать первую строчку в таблице
            dispensaryManager.getEventsPage().deletePatient();
        }
    }

    @Test(description = "Открытие модуля Диспансеризация взрослого населения", dependsOnMethods = "before_test")
    public void step1_openHospitalModule()
    {
        dispensaryManager.openEventsPage();       //Открытие страницы Диспансеризация взрослого населения
    }

    @Test(description = "Выбор в дереве мероприятия Тестовое мероприятие", dependsOnMethods = "step1_openHospitalModule")
    public void step2_chooseEvent()
    {
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedEventYear());
    }

    @Test(description = "Проверка, что в контейнере 'Пациенты' нет записей о пациентах", dependsOnMethods = "step2_chooseEvent")
    public void step3_checkPatientsContainer()
    {
        dispensaryManager.getEventsPage().assertNoRecordsInPatientContainer();
    }

    @Test(description = "Проверка значений полей в контейнере 'Карточка мероприятия'", dependsOnMethods = "step3_checkPatientsContainer")
    public void step4_checkValuesOfEventCardContainer()
    {
        dispensaryManager.getEventsPage().pressUpdateEventButton();
        dispensaryManager.getEventCardPage().comparingFieldsData(dispensaryData.getCheckedEventName(),
                dispensaryData.getCheckedEventType(),
                dispensaryData.getCheckedBeginDate(),
                dispensaryData.getCheckedEndDate(),
                dispensaryData.getCheckedStandart(),
                dispensaryData.getCheckedOrganisationName(),
                dispensaryData.getCheckedFundingType());
        dispensaryManager.getEventCardPage().assertThatStandartFieldIsDisabled();
    }

    @Test(description = "Изменение значений в полях на странице 'Карточка мероприятия', нажатие кнопки 'Сохранить', проверка сообщения об успешном сохранении и что внесенные изменения были сохранены", dependsOnMethods = "step4_checkValuesOfEventCardContainer")
    public void step5_changeFieldValuesSaveAndCheckSaving()
    {
        dispensaryManager.getEventCardPage().changeFieldsValues(dispensaryData.getChangedEventName(), dispensaryData.getChangedBeginDate(), dispensaryData.getChangedEndDate());
        dispensaryManager.getEventCardPage().pressSaveButton();
        dispensaryManager.getEventCardPage().getDialog().clickYes();
        dispensaryManager.getEventCardPage().checkSuccessMessage();
        dispensaryManager.getEventCardPage().comparingFieldsData(dispensaryData.getChangedEventName(), null, dispensaryData.getChangedBeginDate(), dispensaryData.getChangedEndDate(), null, null, null);
    }

    @Test(description = "Вернуть значения полей в первоначальное состояние", dependsOnMethods = "step5_changeFieldValuesSaveAndCheckSaving", alwaysRun = true)
    public void step6_revertingChanges()
    {
        dispensaryManager.getEventCardPage().pressEditButton();
        dispensaryManager.getEventCardPage().changeFieldsValues(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedBeginDate(), dispensaryData.getCheckedEndDate());
        dispensaryManager.getEventCardPage().pressSaveButton();
        dispensaryManager.getEventCardPage().getDialog().clickYes();
        dispensaryManager.getEventCardPage().checkSuccessMessage();
        dispensaryManager.getEventCardPage().comparingFieldsData(dispensaryData.getCheckedEventName(), null, dispensaryData.getCheckedBeginDate(), dispensaryData.getCheckedEndDate(), null, null, null);
    }

    @Test(description = "Выбор услуги и проверка, что в контейнере 'Модель пациента' нет данных для отображения", dependsOnMethods = "step6_revertingChanges")
    public void step7_selectServiceAndCheckPatientModelContainerData()
    {
        dispensaryManager.getEventCardPage().selectService(0);
        dispensaryManager.getEventCardPage().assertCountOfRecordsInPatientModelTable(0);
    }

    @Test(description = "Нажать кнопку 'Добавить', проверить, что открылось модальное окно 'Назначить модель'", dependsOnMethods = "step7_selectServiceAndCheckPatientModelContainerData")
    public void step8_pressAddButtonAssertModalWindow()
    {
        dispensaryManager.getEventCardPage().pressAddButton();
        dispensaryManager.getEventCardPage().setModelModal().assertThatModalIsPresent(1, "Назначить модель");
    }

    @Test(description = "Нажать на кнопку поиска в классифаере 'Модель пациента', проверить, что открылось модальное окно 'Список моделей пациента'", dependsOnMethods = "step8_pressAddButtonAssertModalWindow")
    public void step9_clickFindButton_assertThatModalIsPresent()
    {
        dispensaryManager.getEventCardPage().setModelModal().pressFindButton();
        dispensaryManager.getEventCardPage().setModelModal().assertThatModalIsPresent(2, "Список моделей пациента");
    }

    @Test(description = "В модальном окне 'Список моделей пациента' выберите произвольную модель пациента и нажмите кнопку 'Выбрать'.", dependsOnMethods = "step9_clickFindButton_assertThatModalIsPresent")
    public void step10_selectRandomPatientModel()
    {
        dispensaryManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().chooseRecord();
        selectedPatientModelValue = dispensaryManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().getSelectedPatientModelRecordValue();
        dispensaryManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().pressChooseButton();
    }

    @Test(description = "Нажмите кнопку 'Подтвердить'. Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'.  Проверьте, что в контейнере 'Модель пациента' отобразилась выбранная нами модель.", dependsOnMethods = "step10_selectRandomPatientModel")
    public void step11_confirmChoosingModel()
    {
        dispensaryManager.getEventCardPage().setModelModal().clickApplyButton();
        dispensaryManager.getEventCardPage().assertCountOfModals(0);
        dispensaryManager.getEventCardPage().checkPatientModelSuccessMessage();
        dispensaryManager.getEventCardPage().checkRecordInTablePatientModelContainer(selectedPatientModelValue);
    }

    @Test(description = "В контейнере 'Услуги' нажать кнопку 'Задать модель всем услугам'. Проверьте, что открылось модальное окно 'Задать модель'.", dependsOnMethods = "step11_confirmChoosingModel")
    public void step12_setModelToAllServices()
    {
        dispensaryManager.getEventCardPage().pressAttachModelButton();
        dispensaryManager.getEventCardPage().assertCountOfModals(1);
        dispensaryManager.getEventCardPage().setModelAllServicesModal().getSetModelAllServicesModal().assertModalHeader_equal("Задать модель");
    }

    @Test(description = "Выберите произвольную модель и нажмите кнопку 'Подтвердить'.  Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'. Проверьте, что в контейнере 'Услуги' у всех записей услуг будет отображена выбранная модель пациента.", dependsOnMethods = "step12_setModelToAllServices")
    public void step13_chooseModelAndCheckResult()
    {
        dispensaryManager.getEventCardPage().setModelAllServicesModal().chooseModelInClassifier(); // Выбрать модель из списка в классифаере
        classifierForAllModelsSelect = dispensaryManager.getEventCardPage().setModelAllServicesModal().getSelectedModel();
        dispensaryManager.getEventCardPage().setModelAllServicesModal().pressApplyButton(); // нажать кнопку Подтвердить
        dispensaryManager.getEventCardPage().checkSuccessMessage();
        dispensaryManager.getEventCardPage().checkSelectedModelInServicesTableForAllServices(classifierForAllModelsSelect, selectedPatientModelValue);
    }

    @Test(description = "Удаление модели пациента", dependsOnMethods = "step13_chooseModelAndCheckResult")
    public void step14_deletingPatientModel()
    {
        dispensaryManager.getEventCardPage().getServicesTable().chooseRowInTable(0);
        int countOfRecordsBeforeDelete = dispensaryManager.getEventCardPage().getCountOfRecordsPatientModel(); // запомнить количество строк в таблице до удаления, чтоб дополнительно убедиться, что запись удалена.
        String firstRowValue = dispensaryManager.getEventCardPage().getPatientModelRecord(0); // Запомним значение удаленной записи

        dispensaryManager.getEventCardPage().pressPatientModelDeleteButton(); // Удалить запись

        int countOfRecordsAfterDelete = dispensaryManager.getEventCardPage().getCountOfRecordsPatientModel(); // Получим количество строк в таблице после удаления
        dispensaryManager.getEventCardPage().compareRowsCountAfterDelete(countOfRecordsBeforeDelete, countOfRecordsAfterDelete); // Сравним количество строк до и после удаления

        dispensaryManager.getEventCardPage().checkValueInTable(firstRowValue, false); // Проверим, что в списке значений таблицы "Модель пациента" нет записи, которая была удалена.
    }

    @Test(description = "Удаление всех моделей пациента у всех услуг", dependsOnMethods = "step14_deletingPatientModel")
    public void step15_deleteAllPatientModels()
    {
        dispensaryManager.getEventCardPage().deleteAllPatientsModels();
        dispensaryManager.getEventCardPage().pressBackButton();
    }
}
