package test.businessTests.dispensary;

import businessFramework.entities.dispensary.DispensaryData;
import businessFramework.module.dispensary.DispensaryManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DispensaryOrphansEventTest extends TestBase {
    DispensaryManager dispensaryManager;
    DispensaryData dispensaryData;
    String selectedPatientModelValue = "";
    String classifierForAllModelsSelect = "";
    String dopModel1 = "Сироты. Прикрепление";
    String dopModel2 = "Сироты. Место учебы";

    @BeforeClass
    public void initialize() {
        dispensaryData = new DispensaryData();
        dispensaryManager = new DispensaryManager();

        dispensaryData.setContextName("Подразделение для ОДОДСГ");

        // Данные для заполнения значений в полях
        dispensaryData.setCheckedEventName("Тестовое мероприятие сироты "+getCurrentDateTime());
        dispensaryData.setCheckedEventType("Диспансеризация детей-сирот и детей, оставшихся без попечения родителей, в том числе усыновленных (удочеренных), принятых под опеку (попечительство) в приемную или патронатную семью");
        dispensaryData.setCheckedOrganisationName("ОДОДСГ");
        dispensaryData.setCheckedBeginDate("01.01.2016");
        dispensaryData.setCheckedEndDate("31.12.2016");
        dispensaryData.setCheckedFundingType("ОМС");
        dispensaryData.setCheckedStandart("Тестовый стандарт диспансеризация сирот");
        //Пациент, который попайдет в мероприятие при отборе
        dispensaryData.setPatientsSearchName("Сиротатестододсг");
        dispensaryData.setPatientsSearchSurname("Сиротатестододсг");
        dispensaryData.setPatientsSearchPatrName("Сиротатестододсг");
        dispensaryData.setPatientsSearchBirthDate("01.01.2001");
    }

    @Test(description = "Открытие модуля Диспансеризация детей-сирот")
    public void step1_openChildrenEventModule() {
        dispensaryManager.openEventsPage();       //Открытие страницы Диспансеризация детей-сирот
    }

    @Test(description = "Открытие формы создания нового мероприятия", dependsOnMethods = "step1_openChildrenEventModule")
    public void step2_openFormCreateEvent() {
        dispensaryManager.getEventsPage().pressCreateEventButton();      //Открытие формы создания нового мероприятия
    }

    @Test(description = "Заполнение полей формы", dependsOnMethods = "step2_openFormCreateEvent")
    public void step3_fullDataForCreateEvent() {
        dispensaryManager.getEventCardPage().fullFieldsValues(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedEventType(), dispensaryData.getCheckedFundingType(), dispensaryData.getCheckedBeginDate(), dispensaryData.getCheckedEndDate(), dispensaryData.getCheckedStandart());      //Открытие формы создания нового мероприятия
    }

    @Test(description = "Сохранение мероприятия", dependsOnMethods = "step3_fullDataForCreateEvent")
    public void step4_saveCreateEvent() {
        dispensaryManager.getEventCardPage().pressSaveButton();      //Сохранение мероприятия
    }

    @Test(description = "Выбор услуги и проверка, что в контейнере 'Модель пациента' нет данных для отображения", dependsOnMethods = "step4_saveCreateEvent")
    public void step5_selectServiceAndCheckPatientModelContainerData() {
        dispensaryManager.getEventCardPage().selectService(0);
        dispensaryManager.getEventCardPage().assertCountOfRecordsInPatientModelTable(0);
    }

    @Test(description = "В контейнере 'Услуги' нажать кнопку 'Задать модель всем услугам'. Проверьте, что открылось модальное окно 'Задать модель'.", dependsOnMethods = "step5_selectServiceAndCheckPatientModelContainerData")
    public void step6_setModelToAllServices() {
        dispensaryManager.getEventCardPage().pressAttachModelButton();
        dispensaryManager.getEventCardPage().assertCountOfModals(1);
        dispensaryManager.getEventCardPage().setModelAllServicesModal().getSetModelAllServicesModal().assertModalHeader_equal("Задать модель");
    }

    @Test(description = "Выберите модель  и нажмите кнопку 'Подтвердить'.  Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'. Проверьте, что в контейнере 'Услуги' у всех записей услуг будет отображена выбранная модель пациента.", dependsOnMethods = "step6_setModelToAllServices")
    public void step7_chooseModelAndCheckResult() {
        dispensaryManager.getEventCardPage().setModelAllServicesModal().chooseModelInClassifier(dopModel1); // Выбрать модель из списка в классифаере
        classifierForAllModelsSelect = dispensaryManager.getEventCardPage().setModelAllServicesModal().getSelectedModel();
        dispensaryManager.getEventCardPage().setModelAllServicesModal().pressApplyButton(); // нажать кнопку Подтвердить
        dispensaryManager.getEventCardPage().checkSuccessMessage();
        dispensaryManager.getEventCardPage().checkSelectedModelInServicesTableForAllServices(classifierForAllModelsSelect, selectedPatientModelValue);
    }

    @Test(description = "В контейнере 'Услуги' нажать кнопку 'Задать модель всем услугам'. Проверьте, что открылось модальное окно 'Задать модель'.", dependsOnMethods = "step7_chooseModelAndCheckResult")
    public void step8_setModelToAllServices() {
        dispensaryManager.getEventCardPage().pressAttachModelButton();
        dispensaryManager.getEventCardPage().assertCountOfModals(1);
        dispensaryManager.getEventCardPage().setModelAllServicesModal().getSetModelAllServicesModal().assertModalHeader_equal("Задать модель");
    }

    @Test(description = "Выберите модель  и нажмите кнопку 'Подтвердить'.  Проверьте, что появилось сообщение об успешном сохранении 'Данные сохранены'.", dependsOnMethods = "step8_setModelToAllServices")
    public void step9_chooseModelAndCheckResult()
    {
        dispensaryManager.getEventCardPage().setModelAllServicesModal().chooseModelInClassifier(dopModel2); // Выбрать модель из списка в классифаере
        classifierForAllModelsSelect = dispensaryManager.getEventCardPage().setModelAllServicesModal().getSelectedModel();
        dispensaryManager.getEventCardPage().setModelAllServicesModal().pressApplyButton(); // нажать кнопку Подтвердить
        dispensaryManager.getEventCardPage().checkSuccessMessage();
    }

    @Test(description = "Открытие вкладки 'Пациенты'.", dependsOnMethods = "step9_chooseModelAndCheckResult")
    public void step10_openPatientRegion() {
        dispensaryManager.getEventCardPage().checkPatientsContainer();
    }

    @Test(description = "Отбор пациентов. Убедиться, что появилось сообщение об успешном отборе", dependsOnMethods = "step10_openPatientRegion")
    public void step11_selectPatients() {
        dispensaryManager.getEventCardPage().pressSelectPatientsButton();
        dispensaryManager.getEventCardPage().checkSuccessMessage();
    }

    @Test(description = "Проверка отобранных пациентов", dependsOnMethods = "step11_selectPatients")
    public void step12_checkResult() {

        Map<String, String> columnsAndValues = new HashMap<>();
        columnsAndValues.put("ФИО", // столбец так называется
                dispensaryData.getPatientsSearchName() + " " +
                        dispensaryData.getPatientsSearchSurname() + " " +
                        dispensaryData.getPatientsSearchPatrName());
        columnsAndValues.put("Дата рождения", // столбец так называется
                dispensaryData.getPatientsSearchBirthDate()
        );
        dispensaryManager.getEventCardPage().checkSelectedPatientInPatientsTable(columnsAndValues);
    }

}
