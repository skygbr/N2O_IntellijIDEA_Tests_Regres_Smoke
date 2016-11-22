package test.businessTests.gibddMedicalExamination;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.GibddMedicalExaminationManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConclusionExecutionTest extends TestBase
{

    GibddMedicalExaminationManager gMEManager;
    GibddMedicalExaminationData gMEData;
    private String fullName;

    @BeforeClass
    public void initialize()
    {
        gMEData = new GibddMedicalExaminationData();
        gMEManager = new GibddMedicalExaminationManager();

        gMEData.setContextName("Подразделение для ОДОДСГ");
        gMEData.setCheckedEventName("ОДОДСГ");

        gMEData.setPatientsSearchBirthDate("01.01.1990");
        gMEData.setPatientsSearchDocumentNumber("1234567891");
        gMEData.setPatientsSearchName("Мигрант");
        gMEData.setPatientsSearchPatrName("Гибдд");
        gMEData.setPatientsSearchSurname("Диспансеризация");

        gMEData.setAddPatientReferenceNumber("123");
        gMEData.setAddPatientReferenceSeries("123");
        gMEData.setAddPatientCategoryTS("A");

        gMEData.setFioDriverCard("Диспансеризация Мигрант Гибдд");
        gMEData.setGenderDriverCard("Мужской");
        gMEData.setBirthDateDriverCard("01.01.1990");
        gMEData.setPassportDriverCard("12 34 567891");

        /** Данные для полей в модальном окне "Оказание услуги" */
        gMEData.setMainDiagnosisDoService("Z00.8 Другие общие осмотры");

        /** Данные для страниц "Врач" и "Комиссия" */
        gMEData.setEventNameDoctor("ОДОДСГ");
        gMEData.setDiseaseDoctor("Прочее");
        gMEData.setMainDiagnosisDoctor("Z00.8 Другие общие осмотры");

        List<String> services = new ArrayList<>();
        services.add("Услуга для врача терапевта");
        services.add("Услуга для врача хирурга");
        services.add("Услуга для врача невролога");
        services.add("Услуга для врача офтальмолога");
        services.add("Услуга для врача оториноларинголога");
        services.add("Услуга для врача психиатра-нарколога");
        gMEData.setServicesDoctor(services);

        Map<String, String> servicesAndResources  = new HashMap<>();
        servicesAndResources.put("Услуга для врача терапевта","Ресурс для врача терапевта");
        servicesAndResources.put("Услуга для врача хирурга","Ресурс для врача хирурга");
        servicesAndResources.put("Услуга для врача невролога","Ресурс для врача невролога");
        servicesAndResources.put("Услуга для врача офтальмолога","Ресурс для врача офтальмолога");
        servicesAndResources.put("Услуга для врача оториноларинголога","Ресурс для врача отоларинголога");
        servicesAndResources.put("Услуга для врача психиатра-нарколога","Ресурс для врача психиатра-нарколога");
        servicesAndResources.put("Услуга для врача-психиатра","Ресурс для врача-психиатра");
        gMEData.setServicesAndResourcesDoctor(servicesAndResources);


        fullName = gMEData.getPatientsSearchSurname() + " " + gMEData.getPatientsSearchName() + " " + gMEData.getPatientsSearchPatrName() + " (" + gMEData.getPatientsSearchBirthDate() + ")";
    }

    @Test (description = "Открытие модуля 'Освидетельствование для справки в ГИБДД' и страницы 'Регистратор'.")
    public void step1_openHospitalModule()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(gMEData.getContextName()); // выбрать контекст
        gMEManager.openDispGibddModule();                         //Открытие модуля Освидетельствование для справки в ГИБДД
        gMEManager.openRegistrator();                             //Открытие страницы Регистратор
    }

    @Test (description = "Выбор в дереве мероприятия 'ОДОДСГ'.", dependsOnMethods = "step1_openHospitalModule")
    public void step2_ChooseEvent()
    {
        gMEManager.getRegistratorPage().chooseEvent(gMEData.getCheckedEventName());
    }

    @Test (description = "Нажать кнопку 'Добавить пациента'. Проверить, что появилось модальное окно. Проверить, что в поле 'Дата выдачи бланка' заполнено текущее число.", dependsOnMethods = "step2_ChooseEvent")
    public void step3_ClickAddPatientButtonAndCheckModal()
    {
        gMEManager.getRegistratorPage().pressAddPatientButton();
        gMEManager.getEventCardPage().addPatientModal().assertCountOfModals(1);
        gMEManager.getEventCardPage().addPatientModal().checkModalHeader();
        gMEManager.getEventCardPage().addPatientModal().checkBlankDateValue();
    }

    @Test (description = "Открытие модального окна 'Поиск пациентов'.", dependsOnMethods = "step3_ClickAddPatientButtonAndCheckModal")
    public void step4_openPatientsSearchModal()
    {
        gMEManager.getEventCardPage().addPatientModal().pressFindButtonPatientClassifier();
        gMEManager.getEventCardPage().patientsSearchModal().checkModalHeader();
        gMEManager.getEventCardPage().patientsSearchModal().assertCountOfModals(2);
    }

    @Test (description = "Заполнение полей в модальном окне 'Поиск пациентов'.", dependsOnMethods = "step4_openPatientsSearchModal")
    public void step5_fillFieldsInPatientsSearchModal()
    {
        gMEManager.getEventCardPage().patientsSearchModal().fillFields(gMEData);
        gMEManager.getEventCardPage().patientsSearchModal().clickFindButton();
        gMEManager.getEventCardPage().patientsSearchModal().getPatientsSearchTable().assertThatCountOfRowsIs(1);

        Map<String, String> columnsAndValues = new HashMap<>();
        columnsAndValues.put("ФИО", // столбец так называется
                gMEData.getPatientsSearchSurname() + " " +
                gMEData.getPatientsSearchName() + " " +
                gMEData.getPatientsSearchPatrName());
        gMEManager.getEventCardPage().patientsSearchModal().checkTableValuesAfterSearch(columnsAndValues);
    }

    @Test (description = "Выберите найденного пациента и нажмите кнопку 'Выбрать'. Проверьте, что в модальном окне  в поле 'Пациент' отобразился выбранный нами пациент.", dependsOnMethods = "step5_fillFieldsInPatientsSearchModal")
    public void step6_checkFoundedRecord()
    {
        gMEManager.getEventCardPage().patientsSearchModal().getPatientsSearchTable().chooseRowInTable(0);
        gMEManager.getEventCardPage().patientsSearchModal().clickChooseButton();
        gMEManager.getEventCardPage().addPatientModal().checkValueInPatientClassifier(fullName);
    }

    @Test (description = "Заполнение полей на форме в модальном окне 'Добавить пациента', проверка успешного добавления.", dependsOnMethods = "step6_checkFoundedRecord")
    public void step7_fillFieldsAndCheckSuccessSaving()
    {

        gMEData.setAddPatientReferenceSeries(randomInt(5));
        gMEData.setAddPatientReferenceNumber(randomInt(5));

        Map<String, String> columnsAndValues = new HashMap<>();
        columnsAndValues.put("Серия справки", gMEData.getAddPatientReferenceSeries());
        columnsAndValues.put("Номер справки", gMEData.getAddPatientReferenceNumber());

        gMEManager.getEventCardPage().addPatientModal().fillFields(gMEData);
        gMEManager.getEventCardPage().addPatientModal().pressConfirmButton();
        gMEManager.getRegistratorPage().checkPatientsTableValues(columnsAndValues);
    }


    @Test (description = "Выбор мероприятия. Выбор записи в таблице, нажатие кнопки 'Карточка' и проверка данных в контейнере 'Общие сведения'.", dependsOnMethods = "step7_fillFieldsAndCheckSuccessSaving")
    public void step8_checkDataInCardPage()
    {
        gMEManager.getRegistratorPage().chooseEvent(gMEData.getCheckedEventName());               // выбрать мероприятие в дереве
        gMEManager.getRegistratorPage().getEventsListGibddRegistratorTable().chooseRowInTable(0); // выбрать первую строчку в таблице
        gMEManager.getRegistratorPage().pressDriverCardButton();                                  // Нажать кнопку "Карточка"
        gMEManager.getDriverCardPage().checkGeneralInformationData(gMEData);                      // Проверить значения на форме.
    }

    @Test (description = "Выбрать первую запись в таблице 'Осмотры и услуги' и нажать кнопку 'Оказать услугу'.", dependsOnMethods = "step8_checkDataInCardPage")
    public void step9_selectRecordInServiceTable_AndClickInspectButton()
    {
        gMEManager.getDriverCardPage().selectRecordInServiceTable(0); // Выбор первой строчки в таблице "Осмотры и услуги"
        gMEManager.getDriverCardPage().clickInspecButton();           // Нажать кнопку "Оказать услугу"
    }

    @Test (description = "Проверка, что открылось модальное окно 'Оказание услуги' и проверка данных на форме этого модального окна.", dependsOnMethods = "step9_selectRecordInServiceTable_AndClickInspectButton")
    public void step10_checkModalDoService()
    {
        gMEManager.getDriverCardPage().getDoServicePage().checkFieldsValues(gMEData); // Проверить значения в полях.
    }

    @Test (description = "Заполнение полей и сохранение. Проверка отображенного реультата.", dependsOnMethods = "step10_checkModalDoService")
    public void step11_fillFieldsAndCheckResult()
    {
        gMEManager.getDriverCardPage().getDoServicePage().setValuesAndSave();    // Устанавливает значения для полей "Годен" и "Ресурс" и нажимает кнопку "Сохранить"
        gMEManager.getDriverCardPage().getDoServicePage().checkSuccessMessage(); // Проверяет сообщение об успешном сохранении.
        gMEManager.getDriverCardPage().getDoServicePage().closeDoServiceModal(); // Закрывает модальное окно "Оказание услуги"
        gMEManager.getDriverCardPage().checkConcludeTableValues("A - Годен");    // Проверка столбца "Заключение" для первой записи в таблице в контейнере "Осмотры и услуги"
    }

    @Test (description = "Нажать кнопку 'Очистить' и проверить записи в таблице.", dependsOnMethods = "step11_fillFieldsAndCheckResult")
    public void step12_pressClearButtonAndCheckResult()
    {
        gMEManager.getDriverCardPage().pressClearButton();           // Нажать кнопку "Очистить"
        gMEManager.getDriverCardPage().checkAndApplyConfirmModal();  // нажмем кнопку "ОК" в предупреждающем модальном окне.
        gMEManager.getDriverCardPage().checkConcludeTableValues(""); // Проверка столца "Заключение" для первой записи в таблице в контейнере "Осмотры и услуги"
    }

    @Test(description = "Открыть спейс 'Врач'. Выбрать мероприятие и проверить услуги.", dependsOnMethods = "step12_pressClearButtonAndCheckResult")
    public void step13_selectAndAssertEvent()
    {
        gMEManager.openDoctor();
        gMEManager.getDoctorPage().selectEvent(gMEData);
        gMEManager.getDoctorPage().filterServices(gMEData);
    }

    @Test(description = "Проверить и выполнить все услуги.", dependsOnMethods = "step13_selectAndAssertEvent")
    public void step14_servicesExecution()
    {
        gMEManager.getDoctorPage().fillAllServices(gMEData);
    }

    @Test (description = "Открыть спейс коммиссия. Выбрать мероприятие.", dependsOnMethods = "step14_servicesExecution")
    public void step15_openPageAndSelectEvent()
    {
        gMEManager.openComission();
        gMEManager.getCommissionPage().selectEvent(gMEData);
    }

    @Test(description = "Выбрать пациента. Создание заключения.", dependsOnMethods = "step15_openPageAndSelectEvent")
    public void step16_selectPatientAndExecuteConclusion()
    {
        gMEManager.getCommissionPage().selectAndOpenPatientCard(gMEData);
        gMEManager.getDriverCardPage().assertConclusion(gMEData);
        gMEManager.getDriverCardPage().confirmConclusion();
        gMEManager.getDriverCardPage().closePage();
    }

    @Test(description = "Закрытие карточки пациента.", dependsOnMethods = "step16_selectPatientAndExecuteConclusion")
    public void step17_closeDriverCard()
    {
        gMEManager.getCommissionPage().closeCard();
    }

    @Test(description = "Удаление пациента.", dependsOnMethods = "step17_closeDriverCard", alwaysRun = true)
    public void step18_removePatient()
    {
        gMEManager.openRegistrator();
        gMEManager.getRegistratorPage().chooseEvent(gMEData.getCheckedEventName());
        gMEManager.getCommissionPage().removePatient(gMEData);
    }

}
