package test.businessTests.migrantsWithGeneration;


import businessFramework.entities.migrants.MigrantsData;
import businessFramework.module.migrants.MigrantsManager;
import net.framework.autotesting.entities.UserData;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RegistratorTest extends TestBase
{

    private MigrantsData md;
    private MigrantsManager mm;
    String selectedModel1;
    String selectedModel2;
    public int foundPatientDataRecord;
    public String arrivedValue;
    public String purposeValue;
    private UserData user;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        md = new MigrantsData();
        mm = new MigrantsManager();

        user = new UserData();

        user.setUser("RegistratorTest");
        user.setPassword("xL62U88r");

        // Наименование контекста
        md.setContextName("RegistratorTest");


        // Данные в полях на форме в контейнере “Карточка мероприятия”
        md.setEventName("RegistratorTest");                              // Название мероприятия
        md.setEventTypeValue("Освидетельствование ИГ и ЛГ");             // Значение поля "Вид мероприятия"
        md.setOrganisationValue("RegistratorTest");                      // Значение поля "Организация"
        md.setFinancingTypeValue("RegistratorTest");                     // Значение поля "Вид финансирования"
        md.setBeginDateValue("01.01.2016");                              // Значение поля "Дата начала"
        md.setEndDateValue("31.12.2016");                                // Значение поля "Дата окончания"
        md.setStandartValue("RegistratorTest");                          // Значение поля "Стандарт лечения"

        // Данные для изменения значений на форме в контейнере "Карточка мероприятия"
        md.setEventNameValueEdited("RegistratorTest_upd");
        md.setBeginDateValueEdited("02.02.2016");
        md.setEndDateValueEdited("28.12.2016");

        // Текст сообщения об успешном сохранении данных на форме в контейнере "Карточка мероприятия"
        md.setSuccessEditingEventAlertMessage("Данные сохранены");

        // Текст сообщения об успешном сохранении данных на странице "Добавить пациента" на форме в контейнере "Общие данные"
        md.setSuccessSavingCommonDataAlertMessage("Данные сохранены");

        // Текст сообщения об успешном сохранении данных на странице "Добавить пациента" на форме в контейнере "Общие данные"
        md.setSuccessSavingServiceAlertMessage("Данные сохранены");

        // Заголовок модального окна "Назначить модель"
        md.setSetModelModalHeader("Назначить модель");

        // Заголовок модального окна "Задать модель"
        md.setAttachModelModalHeader("Задать модель");

        // Заголовок модального окна "Список моделей пациента"
        md.setPatientModelsListHeader("Список моделей пациента");

        // Заголовок модального окна "Поиск пациентов"
        md.setSearchPatientModalHeader("Поиск пациентов");

        // Данные для заполнения полей на форме в модальном окне "Поиск пациентов"
        md.setPatientSearchSurname("RegistratorTestPat");
        md.setPatientSearchName("RegistratorTestPat");
        md.setPatientSearchPatrName("RegistratorTestPat");
        md.setPatientSearchBirthDate("01.01.1980");
        md.setPatientSearchDocNumber("9207878986");

        // Данные для заполнение полей в модальном окне "Выполнение услуги"
        md.setServiceExecutionOrganisation("RegistratorTest");

        //Данные для заполнение полей в контейнере "Заключение"
        md.setConclusionSertificateNumber(randomInt(6));
        md.setConclusionNumber(randomInt(6));

        //Данные для заполнение полей в модальном окне "Закрытие карты"
        md.setClosingCardReason("Выдано, здоров");

        //Данные для проверки значений в таблице на странице "Комиссия"
        md.setConclusionStatus("Закрыта");
    }

    @Test (description = "Удаление тестовых данных")
    public void before_test()
    {
        app.executeLiquibase("changelog/migrants/201610041424_insert_RegistratorTest.xml");
        app.getNavigationHelper().openMainPage(user);
        page.getHeader().chooseContext(md.getContextName());   // Выбрать контекст
        mm.openMigrantsModule();
        mm.openCommissionPage();
        mm.getCommissionPage().chooseEvent(md.getEventName());
        while (mm.getCommissionPage().getMigrantsCommissionTable().getCountRowsInTable(true)>0) {
            mm.getCommissionPage().getMigrantsCommissionTable().chooseRowInTable(0);
            mm.getCommissionPage().clickDeletePatientButton();
            mm.getCommissionPage().getMigrantsCommissionTable().getAlerts().assertSuccessAlertIsPresent();
        }
    }

    @Test (description = "Создание мероприятия")
    public void step1_createEvent()
    {
        mm.openRegistratorPage();
        mm.getRegistratorPage().chooseEvent(md.getEventName());
        mm.getRegistratorPage().assertNoRecordsInMigrantsContainer();

        mm.getRegistratorPage().pressUpdateEventButton();

        mm.getRegistratorPage().getEventPage().checkFieldsDisability(null, null, null, null, null, null, md.getStandartValue());
        mm.getRegistratorPage().getEventPage().checkFields(md.getEventName(), md.getEventTypeValue(), md.getOrganisationValue(), md.getFinancingTypeValue(), md.getBeginDateValue(), md.getEndDateValue(), md.getStandartValue());
    }

    @Test(description = "Изменение мероприятия", dependsOnMethods = "step1_createEvent")
    public void step2_changeEvent()
    {
        mm.getRegistratorPage().getEventPage().fillFields(md.getEventNameValueEdited(),null, null, null, md.getBeginDateValueEdited(), md.getEndDateValueEdited(), null);
        mm.getRegistratorPage().getEventPage().clickSaveButton();
        mm.getRegistratorPage().getEventPage().getAlerts().assertSuccessAlertMessage(md.getSuccessEditingEventAlertMessage());
        mm.getRegistratorPage().getEventPage().checkFields(md.getEventNameValueEdited(), md.getEventTypeValue(), md.getOrganisationValue(), md.getFinancingTypeValue(), md.getBeginDateValueEdited(), md.getEndDateValueEdited(), md.getStandartValue());

        mm.getRegistratorPage().getEventPage().clickEditButton();
        mm.getRegistratorPage().getEventPage().fillFields(md.getEventName(),null, null, null, md.getBeginDateValue(), md.getEndDateValue(), null);
        mm.getRegistratorPage().getEventPage().clickSaveButton();
        mm.getRegistratorPage().getEventPage().getAlerts().assertSuccessAlertMessage(md.getSuccessEditingEventAlertMessage());
        mm.getRegistratorPage().getEventPage().checkFields(md.getEventName(), md.getEventTypeValue(), md.getOrganisationValue(), md.getFinancingTypeValue(), md.getBeginDateValue(), md.getEndDateValue(), md.getStandartValue());

    }

    @Test (description = "Создание модели пациента", dependsOnMethods = "step2_changeEvent")
    public void step3_creatingPatientModel()
    {

        mm.getRegistratorPage().getEventPage().getServicesTable().chooseRowInTable(0);
        mm.getRegistratorPage().getEventPage().getPatientModelTable().assertNoRecords();

        mm.getRegistratorPage().getEventPage().clickAddPatientModelButton();

        mm.getRegistratorPage().getEventPage().getSetModelModal().assertCountOfModals(1);
        mm.getRegistratorPage().getEventPage().getSetModelModal().checkModalHeader(md.getSetModelModalHeader());

        mm.getRegistratorPage().getEventPage().getSetModelModal().clickSearchButton();
        mm.getRegistratorPage().getEventPage().getSetModelModal().getPatientListModelModal().assertCountOfModals(2);
        mm.getRegistratorPage().getEventPage().getSetModelModal().getPatientListModelModal().checkModalHeader(md.getPatientModelsListHeader());

        mm.getRegistratorPage().getEventPage().getSetModelModal().getPatientListModelModal().selectRecordInPatientsListTable(0);

        // Получим значение, которое было выбрано в таблице "Список моделей пациента"
        selectedModel1 = mm.getRegistratorPage().getEventPage().getSetModelModal().getPatientListModelModal().getSelectedModelValue();

        mm.getRegistratorPage().getEventPage().getSetModelModal().getPatientListModelModal().clickChooseModelButton();

        mm.getRegistratorPage().getEventPage().getSetModelModal().checkFields(selectedModel1);
        mm.getRegistratorPage().getEventPage().getSetModelModal().clickApplySettingModelButton();

        mm.getRegistratorPage().getEventPage().checkPatientModelTableValues(selectedModel1);
    }

    @Test(description = "Задать модель всем услугам", dependsOnMethods = "step3_creatingPatientModel")
    public void step4_settingModelToAllServices()
    {

        mm.getRegistratorPage().getEventPage().clickAttachModelButton();
        mm.getRegistratorPage().getEventPage().assertCountOfModals(1);
        mm.getRegistratorPage().getEventPage().getAttachModelModal().checkModalHeader(md.getAttachModelModalHeader());
        mm.getRegistratorPage().getEventPage().getAttachModelModal().clickFindModelButton();
        mm.getRegistratorPage().getEventPage().assertCountOfModals(2);
        mm.getRegistratorPage().getEventPage().getAttachModelModal().getPatientListModelModal().checkModalHeader(md.getPatientModelsListHeader());


        List<String> patientModelsList  = mm.getRegistratorPage().getEventPage().getServicesTable().getColumnValues("Базовая модель");

         // Найдем первую запись, которая не равна selectedModel1 и не равна ни одному значению в колонке "Базовая модель".
        selectedModel2                  = mm.getRegistratorPage().getEventPage().getAttachModelModal().getPatientListModelModal().selectNotSettedModel(selectedModel1, patientModelsList);
        int numberOfRecord              = mm.getRegistratorPage().getEventPage().getAttachModelModal().getPatientListModelModal().checkListOfPatientModelsTableValues(selectedModel2);                                // Получим номер строки записи, которая не равна selectedModel1

        mm.getRegistratorPage().getEventPage().getAttachModelModal().getPatientListModelModal().selectRecordInPatientsListTable(numberOfRecord); // Выберем эту запись


        mm.getRegistratorPage().getEventPage().getAttachModelModal().getPatientListModelModal().clickChooseModelButton();

        mm.getRegistratorPage().getEventPage().getAttachModelModal().checkFields(selectedModel2);
        mm.getRegistratorPage().getEventPage().getAttachModelModal().clickApplyAttachModelButton();

        mm.getRegistratorPage().getEventPage().getAlerts().assertSuccessAlertMessage(md.getSuccessEditingEventAlertMessage());

        mm.getRegistratorPage().getEventPage().checkThatModelSetToAllServices(selectedModel2);
    }

    @Test(description = "Удаление модели", dependsOnMethods = "step4_settingModelToAllServices")
    public void step5_deletePatientModel()
    {
        mm.getRegistratorPage().getEventPage().deleteAllPatientModels();
        mm.getRegistratorPage().clickBackButton();
    }

    @Test(description = "Добавление пациента", dependsOnMethods = "step5_deletePatientModel")
    public void step6_addPatient()
    {
        mm.getRegistratorPage().clickAddPatientButton();
        mm.getRegistratorPage().getPatientSearchPage().clickSearchPatient();

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().assertCountOfModals(1);
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().checkModalHeader(md.getSearchPatientModalHeader());

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().fillFields(md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName(), md.getPatientSearchBirthDate(), md.getPatientSearchDocNumber());
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().clickSearchPatientButton();

        // Проверим, что в таблице есть запись, которая была найдена.
        int foundPatientDataRow = mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().checkFoundPatientsListTableValues(md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName(), md.getPatientSearchBirthDate());
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().getFoundPatientsListTable().chooseRowInTable(foundPatientDataRow);
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientModal().clickChoosePatientButton();

        String fullValue = String.format("%s %s %s (%s)", md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName(), md.getPatientSearchBirthDate());
        mm.getRegistratorPage().getPatientSearchPage().checkThatPatientNameAppearsInField(fullValue);

        mm.getRegistratorPage().getPatientSearchPage().clickFindPatientButton();
        String fio = String.format("%s %s %s", md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName());
        mm.getRegistratorPage().getPatientSearchPage().checkTableValues(fio, md.getPatientSearchBirthDate());
    }


    @Test(description = "Создание новой карточки", dependsOnMethods = "step6_addPatient")
    public void step7_createNewCard()
    {
        mm.getRegistratorPage().getPatientSearchPage().clickCreateNewCardButton();
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().checkCommonValues(md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName(), md.getPatientSearchBirthDate());

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().fillFieldsPatient(md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName());
        // Запомним значения в полях "Прибыл из" и "Цель получения справки", чтобы впоследствии их проверить на странице "Карточка ИГ и ЛГ"
        List<String> requiredValues = mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().fillRequiredFields();

        arrivedValue = requiredValues.get(0);
        purposeValue = requiredValues.get(1);

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().clickConfirmCommonValuesButton();

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().getAlerts().assertSuccessAlertIsPresent();
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().getAlerts().assertSuccessAlertMessage(md.getSuccessSavingCommonDataAlertMessage());
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().selectServicesInServicesContainer();
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().clickConfirmServiceButton();

        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().getAlerts().assertSuccessAlertIsPresent();
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().getAlerts().assertSuccessAlertMessage(md.getSuccessSavingServiceAlertMessage());
        mm.getRegistratorPage().getPatientSearchPage().getAddPatientCardPage().clickBackButton();
        mm.getRegistratorPage().getPatientSearchPage().clickBackButton();

        foundPatientDataRecord =  mm.getRegistratorPage().checkPatientsTableValues(String.format("%s %s %s", md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName()), md.getPatientSearchBirthDate());
    }

    @Test(description = "Работа с картой", dependsOnMethods = "step7_createNewCard")
    public void step8_workWithCard()
    {
        mm.getRegistratorPage().getMigrantsRegistratorTable().chooseRowInTable(foundPatientDataRecord);
        mm.getRegistratorPage().clickCardButton();
        mm.getRegistratorPage().getPatientCardPage().clickGeneralInfoContainer();
        mm.getRegistratorPage().getPatientCardPage().checkFieldsValues(arrivedValue, purposeValue);
        mm.getRegistratorPage().getPatientCardPage().checkCommonInfo(md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName(), md.getPatientSearchBirthDate());

        mm.getRegistratorPage().getPatientCardPage().getServicesAndViewTable().chooseRowInTable(0);
        mm.getRegistratorPage().getPatientCardPage().clickExecuteServiceButton();
        mm.getRegistratorPage().getPatientCardPage().getServiceExecutionPage().assertFieldsValues(md.getServiceExecutionOrganisation());
        mm.getRegistratorPage().getPatientCardPage().getServiceExecutionPage().executeService();
    }

    @Test(description = "Проведение осмотров в спейсе Врач", dependsOnMethods = "step8_workWithCard")
    public void step9_executingServiceInDoctorPage()
    {
        mm.openDoctorPage();
        mm.getDoctorPage().chooseEvent(md.getEventName());
        mm.getDoctorPage().getContainerServices().getTable().chooseRowInTable(0);
        mm.getDoctorPage().clearService();
        mm.getDoctorPage().executeService();
    }

    @Test(description = "Проведение и удаление заключения", dependsOnMethods = "step9_executingServiceInDoctorPage")
    public void step10_conclusionExecution()
    {
        mm.openCommissionPage();
        mm.getCommissionPage().chooseEvent(md.getEventName());
        mm.getCommissionPage().getMigrantsCommissionTable().assertThatCountOfRowsIs(1);
        mm.getCommissionPage().clickCardButton();
        mm.getCommissionPage().getPatientCardPage().assertConclusionDates();
        mm.getCommissionPage().getPatientCardPage().executeConclussion(md.getConclusionSertificateNumber(),md.getConclusionNumber());
        mm.getCommissionPage().getPatientCardPage().clickCloseCardButton();
        mm.getCommissionPage().getPatientCardPage().getClosingCardModal().assertAndConfirmClosing(md.getClosingCardReason());
        mm.getCommissionPage().getPatientCardPage().getConclusionContainer().getForm().getAlerts().assertSuccessAlertIsPresent();
        mm.getCommissionPage().getPatientCardPage().closePage();
        foundPatientDataRecord =  mm.getCommissionPage().checkPatientsTableValues(String.format("%s %s %s", md.getPatientSearchSurname(), md.getPatientSearchName(), md.getPatientSearchPatrName()),
                md.getPatientSearchBirthDate(), md.getConclusionStatus(), md.getClosingCardReason());
        mm.getCommissionPage().getMigrantsCommissionTable().chooseRowInTable(foundPatientDataRecord);
        mm.getCommissionPage().clickDeletePatientButton();
        mm.getCommissionPage().getMigrantsCommissionTable().getAlerts().assertSuccessAlertIsPresent();
    }

    @Test(description = "Выход из n2o", dependsOnMethods = "step10_conclusionExecution", alwaysRun = true)
    public void afterTest_logout() {
        page.getHeader().logOut();
    }

    @Test(description = "Удаление тестовых данных", dependsOnMethods = "afterTest_logout", alwaysRun = true)
    public void afterTest_generation() {
        app.executeLiquibase("changelog/migrants/201610041430_delete_RegistratorTest.xml");
    }
}
