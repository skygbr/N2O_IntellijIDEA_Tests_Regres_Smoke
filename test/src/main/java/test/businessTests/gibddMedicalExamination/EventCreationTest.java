package test.businessTests.gibddMedicalExamination;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.GibddMedicalExaminationManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventCreationTest extends TestBase
{
    GibddMedicalExaminationManager gMEManager;
    GibddMedicalExaminationData gMEData;
    String selectedPatientModelValue = "";
    String classifierForAllModelsSelect = "";

    @BeforeClass
    public void initialize()
    {
        gMEData = new GibddMedicalExaminationData();
        gMEManager = new GibddMedicalExaminationManager();

        gMEData.setContextName("Подразделение для ОДОДСГ");

        // Данные для проверки значений в полях
        gMEData.setCheckedEventName("ОДОДСГ");
        gMEData.setCheckedEventType("Освидетельствование для справки в ГИБДД");
        gMEData.setCheckedOrganisationName("ОДОДСГ");
        gMEData.setCheckedBeginDate("01.01.2016");
        gMEData.setCheckedEndDate("31.12.2016");
        gMEData.setCheckedFundingType("Средства граждан");
        gMEData.setCheckedMes("J13 Пневмония");

        /// todo never do like this. names should be the same.
        if(app.getProperty("baseUrl").contains("rmis-test"))
        {
            gMEData.setCheckedStandart("Справка в ГИБДД"); // for rmis-test
        }
        else
        {
            gMEData.setCheckedStandart("Осмотр для справки в ГИБДД"); // for demo
        }

        // Данные для изменения значений в полях
        gMEData.setChangedBeginDate("02.02.2015");
        gMEData.setChangedEndDate("28.12.2015");
        gMEData.setChangedEventName("ОДОДСГ тестирование изменений");
        gMEData.setChangedMes("Бронхит");

        // Данные для полей в модальном окне "Модель пациента"
        gMEData.setPatientModelName("Наименование модели пациента для ОДОДСГ");
        gMEData.setPatientModelGender("Женский");
        gMEData.setPatientModelSocial("Работающие граждане");

        // Значение возраста
        gMEData.setAgeInModelsWindow("0,2,4, 0.0,0.2,0.4, 1.2");
    }

    @Test(description = "Открытие модуля Освидетельствование для справки в ГИБДД, контейнер Регистратор")
    public void step1_openHospitalModule()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(gMEData.getContextName());   // выбрать контекст
        gMEManager.openRegistrator();                               //Открытие страницы Регистратор
    }

    @Test(description = "Выбор в дереве мероприятия ОДОДСГ", dependsOnMethods = "step1_openHospitalModule")
    public void step2_chooseEvent()
    {
        gMEManager.getRegistratorPage().chooseEvent(gMEData.getCheckedEventName());
    }

    @Test(description = "Проверка, что в контейнере 'Пациенты' нет записей о пациентах", dependsOnMethods = "step2_chooseEvent")
    public void step3_checkPatientsContainer()
    {
        gMEManager.getRegistratorPage().assertNoRecordsInPatientContainer();
    }

    @Test(description = "Проверка значений полей в контейнере 'Карточка мероприятия'", dependsOnMethods = "step3_checkPatientsContainer")
    public void step4_checkValuesOfEventCardContainer()
    {
        gMEManager.getRegistratorPage().pressUpdateEventButton();
        gMEManager.getEventCardPage().comparingFieldsData(gMEData.getCheckedEventName(),
                gMEData.getCheckedEventType(),
                gMEData.getCheckedBeginDate(),
                gMEData.getCheckedEndDate(),
                gMEData.getCheckedStandart(),
                gMEData.getCheckedOrganisationName(),
                gMEData.getCheckedFundingType(),
                gMEData.getCheckedMes());
        gMEManager.getEventCardPage().assertThatStandartFieldIsDisabled();
    }

    @Test(description = "Изменение значений в полях на странице 'Карточка мероприятия', нажатие кнопки 'Сохранить', проверка сообщения об успешном сохранении и что внесенные изменения были сохранены", dependsOnMethods = "step4_checkValuesOfEventCardContainer")
    public void step5_changeFieldValuesSaveAndCheckSaving()
    {
        gMEManager.getEventCardPage().changeFieldsValues(gMEData.getChangedEventName(), gMEData.getChangedBeginDate(), gMEData.getChangedEndDate(), gMEData.getChangedMes());
        gMEManager.getEventCardPage().pressSaveButton();
        gMEManager.getEventCardPage().checkSuccessMessage();
        gMEManager.getEventCardPage().comparingFieldsData(gMEData.getChangedEventName(), null, gMEData.getChangedBeginDate(), gMEData.getChangedEndDate(), null, null, null, gMEData.getChangedMes());
    }

    @Test(description = "Вернуть значения полей в первоначальное состояние", dependsOnMethods = "step5_changeFieldValuesSaveAndCheckSaving", alwaysRun = true)
    public void step6_revertingChanges()
    {
        gMEManager.getEventCardPage().pressEditButton();
        gMEManager.getEventCardPage().changeFieldsValues(gMEData.getCheckedEventName(), gMEData.getCheckedBeginDate(), gMEData.getCheckedEndDate(), gMEData.getCheckedMes());
        gMEManager.getEventCardPage().pressSaveButton();
        gMEManager.getEventCardPage().checkSuccessMessage();
        gMEManager.getEventCardPage().comparingFieldsData(gMEData.getCheckedEventName(), null, gMEData.getCheckedBeginDate(), gMEData.getCheckedEndDate(), null, null, null, gMEData.getCheckedMes());
    }

    @Test(description = "Выбор услуги и проверка, что в контейнере 'Модель пациента' нет данных для отображения", dependsOnMethods = "step6_revertingChanges")
    public void step7_selectServiceAndCheckPatientModelContainerData()
    {
        gMEManager.getEventCardPage().selectService(0);
        gMEManager.getEventCardPage().assertCountOfRecordsInPatientModelTable(0);
    }

    @Test(description = "Нажать кнопку 'Добавить', проверить, что открылось модальное окно 'Назначить модель'", dependsOnMethods = "step7_selectServiceAndCheckPatientModelContainerData")
    public void step8_pressAddButtonAssertModalWindow()
    {
        gMEManager.getEventCardPage().pressAddButton();
        gMEManager.getEventCardPage().setModelModal().assertThatModalIsPresent(1, "Назначить модель");
    }

    @Test(description = "Нажать на кнопку поиска в классифаере 'Модель пациента', проверить, что открылось модальное окно 'Список моделей пациента'", dependsOnMethods = "step8_pressAddButtonAssertModalWindow")
    public void step9_clickFindButton_assertThatModalIsPresent()
    {
        gMEManager.getEventCardPage().setModelModal().pressFindButton();
        gMEManager.getEventCardPage().setModelModal().assertThatModalIsPresent(2, "Список моделей пациента");
    }

    @Test(description = "В модальном окне 'Список моделей пациента' выберите произвольную модель пациента и нажмите кнопку 'Выбрать'.", dependsOnMethods = "step9_clickFindButton_assertThatModalIsPresent")
    public void step10_selectRandomPatientModel()
    {
        gMEManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().chooseRecord();
        selectedPatientModelValue = gMEManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().getSelectedPatientModelRecordValue();
        gMEManager.getEventCardPage().setModelModal().getListOfPatientsModelsModal().pressChooseButton();
    }

    @Test(description = "Нажмите кнопку 'Подтвердить'. Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'.  Проверьте, что в контейнере 'Модель пациента' отобразилась выбранная нами модель.", dependsOnMethods = "step10_selectRandomPatientModel")
    public void step11_confirmChoosingModel()
    {
        gMEManager.getEventCardPage().setModelModal().clickApplyButton();
        gMEManager.getEventCardPage().assertCountOfModals(0);
        gMEManager.getEventCardPage().checkPatientModelSuccessMessage();
        gMEManager.getEventCardPage().checkRecordInTablePatientModelContainer(selectedPatientModelValue);
    }

    @Test(description = "В контейнере 'Услуги' нажать кнопку 'Задать модель всем услугам'. Проверьте, что открылось модальное окно 'Задать модель'.", dependsOnMethods = "step11_confirmChoosingModel")
    public void step12_setModelToAllServices()
    {
        gMEManager.getEventCardPage().pressAttachModelButton();
        gMEManager.getEventCardPage().assertCountOfModals(1);
        gMEManager.getEventCardPage().setModelAllServicesModal().getSetModelAllServicesModal().assertModalHeader_equal("Задать модель");
    }

    @Test(description = "Выберите произвольную модель и нажмите кнопку 'Подтвердить'.  Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'. Проверьте, что в контейнере 'Услуги' у всех записей услуг будет отображена выбранная модель пациента.", dependsOnMethods = "step12_setModelToAllServices")
    public void step13_chooseModelAndCheckResult()
    {
        gMEManager.getEventCardPage().setModelAllServicesModal().chooseModelInClassifier(); // Выбрать модель из списка в классифаере
        classifierForAllModelsSelect = gMEManager.getEventCardPage().setModelAllServicesModal().getSelectedModel();
        gMEManager.getEventCardPage().setModelAllServicesModal().pressApplyButton(); // нажать кнопку Подтвердить
        gMEManager.getEventCardPage().checkSuccessMessage();
        gMEManager.getEventCardPage().checkSelectedModelInServicesTableForAllServices(classifierForAllModelsSelect, selectedPatientModelValue);
    }

    @Test(description = "Удаление модели пациента", dependsOnMethods = "step13_chooseModelAndCheckResult")
    public void step14_deletingPatientModel()
    {
        gMEManager.getEventCardPage().getServicesTable().chooseRowInTable(0);
        int countOfRecordsBeforeDelete = gMEManager.getEventCardPage().getCountOfRecordsPatientModel(); // запомнить количество строк в таблице до удаления, чтоб дополнительно убедиться, что запись удалена.
        String firstRowValue = gMEManager.getEventCardPage().getPatientModelRecord(0); // Запомним значение удаленной записи

        gMEManager.getEventCardPage().pressPatientModelDeleteButton(); // Удалить запись

        int countOfRecordsAfterDelete = gMEManager.getEventCardPage().getCountOfRecordsPatientModel(); // Получим количество строк в таблице после удаления
        gMEManager.getEventCardPage().compareRowsCountAfterDelete(countOfRecordsBeforeDelete, countOfRecordsAfterDelete); // Сравним количество строк до и после удаления

        gMEManager.getEventCardPage().checkValueInTable(firstRowValue, false); // Проверим, что в списке значений таблицы "Модель пациента" нет записи, которая была удалена.
    }

    @Test(description = "Удаление всех моделей пациента у всех услуг", dependsOnMethods = "step14_deletingPatientModel")
    public void step15_deleteAllPatientModels()
    {
        gMEManager.getEventCardPage().deleteAllPatientsModels();
        gMEManager.getEventCardPage().pressBackButton();
    }

}
