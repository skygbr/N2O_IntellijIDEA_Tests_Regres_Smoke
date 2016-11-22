package test.businessTests.dispensary;

import businessFramework.entities.dispensary.DispensaryData;
import businessFramework.module.dispensary.DispensaryManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DispensaryPatientTest extends TestBase
{

    DispensaryManager dispensaryManager;
    DispensaryData dispensaryData;
    private String fullName;

    @BeforeClass
    public void initialize()
    {
        dispensaryData = new DispensaryData();
        dispensaryManager = new DispensaryManager();

        dispensaryData.setContextName("Подразделение для ОДОДСГ");
        dispensaryData.setCheckedEventName("Тестовое мероприятие сироты");
        dispensaryData.setCheckedEventYear("Мероприятия 2016 года");

        dispensaryData.setPatientsSearchBirthDate("01.01.1990");
        dispensaryData.setPatientsSearchDocumentNumber("1234567891");
        dispensaryData.setPatientsSearchName("Мигрант");
        dispensaryData.setPatientsSearchPatrName("Гибдд");
        dispensaryData.setPatientsSearchSurname("Диспансеризация");

        dispensaryData.setFioDriverCard("Диспансеризация Мигрант Гибдд");
        dispensaryData.setGenderDriverCard("Мужской");
        dispensaryData.setBirthDateDriverCard("01.01.1990");

        dispensaryData.setAppointmentName("Осмотр врача-педиатра");
        fullName = dispensaryData.getPatientsSearchSurname() + " " + dispensaryData.getPatientsSearchName() + " " + dispensaryData.getPatientsSearchPatrName() + " (" + dispensaryData.getPatientsSearchBirthDate() + ")";
    }

    @Test(description = "Удаление тестовых данных.")
    public void before_test()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(dispensaryData.getContextName());                                                           // выбрать контекст
        dispensaryManager.openEventsPage();                                                                                        //Открытие страницы Диспансеризация взрослого населения
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedEventYear()); // выбрать мероприятие в дереве
        while (dispensaryManager.getEventsPage().getEventsListTable().getCountRowsInTable(true)>0) {
            dispensaryManager.getEventsPage().getEventsListTable().chooseRowInTable(0);                                            // выбрать первую строчку в таблице
            dispensaryManager.getEventsPage().deletePatient();
        }
    }

    @Test(description = "Открытие модуля 'Диспансеризация детей сирот'.", dependsOnMethods = "before_test")
    public void step1_openHospitalModule()
    {
        dispensaryManager.openEventsPage();       //Открытие страницы ДТС
    }

    @Test (description = "Выбор в дереве мероприятия 'ОДОДСГ'.", dependsOnMethods = "step1_openHospitalModule")
    public void step2_ChooseEvent()
    {
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), dispensaryData.getCheckedEventYear());
    }

    @Test (description = "Нажать кнопку 'Добавить пациента'. Проверить, что появилось модальное окно. Проверить, что в поле 'Дата выдачи бланка' заполнено текущее число.", dependsOnMethods = "step2_ChooseEvent")
    public void step3_ClickAddPatientButtonAndCheckModal()
    {
        dispensaryManager.getEventsPage().pressAddPatientButton();
        dispensaryManager.getEventCardPage().addPatientModal().assertCountOfModals(1);
        dispensaryManager.getEventCardPage().addPatientModal().checkModalHeader();
    }

    @Test (description = "Открытие модального окна 'Поиск пациентов'.", dependsOnMethods = "step3_ClickAddPatientButtonAndCheckModal")
    public void step4_openPatientsSearchModal()
    {
        dispensaryManager.getEventCardPage().addPatientModal().pressFindButtonPatientClassifier();
        dispensaryManager.getEventCardPage().patientsSearchModal().checkModalHeader();
        dispensaryManager.getEventCardPage().patientsSearchModal().assertCountOfModals(2);
    }

    @Test (description = "Заполнение полей в модальном окне 'Поиск пациентов'.", dependsOnMethods = "step4_openPatientsSearchModal")
    public void step5_fillFieldsInPatientsSearchModal()
    {
        dispensaryManager.getEventCardPage().patientsSearchModal().fillFields(dispensaryData);
        dispensaryManager.getEventCardPage().patientsSearchModal().clickFindButton();
        dispensaryManager.getEventCardPage().patientsSearchModal().getPatientsSearchTable().assertThatCountOfRowsIs(1);

        Map<String, String> columnsAndValues = new HashMap<>();
        columnsAndValues.put("ФИО", // столбец таблицы для искомого пациента
                dispensaryData.getPatientsSearchSurname() + " " +
                        dispensaryData.getPatientsSearchName() + " " +
                        dispensaryData.getPatientsSearchPatrName());
        dispensaryManager.getEventCardPage().patientsSearchModal().checkTableValuesAfterSearch(columnsAndValues);
    }

    @Test (description = "Выберите найденного пациента и нажмите кнопку 'Выбрать'. Проверьте, что в модальном окне  в поле 'Пациент' отобразился выбранный нами пациент.", dependsOnMethods = "step5_fillFieldsInPatientsSearchModal")
    public void step6_checkFoundedRecord()
    {
        dispensaryManager.getEventCardPage().patientsSearchModal().getPatientsSearchTable().chooseRowInTable(0);
        dispensaryManager.getEventCardPage().patientsSearchModal().clickChooseButton();
        dispensaryManager.getEventCardPage().addPatientModal().checkValueInPatientClassifier(fullName);
    }

    @Test (description = "Заполнение полей на форме в модальном окне 'Добавить пациента', проверка успешного добавления.", dependsOnMethods = "step6_checkFoundedRecord")
    public void step7_fillFieldsAndCheckSuccessSaving()
    {
        dispensaryManager.getEventCardPage().addPatientModal().pressConfirmButton();
    }

    @Test (description = "Выбор мероприятия. Выбор записи в таблице, нажатие кнопки 'Карточка' и проверка данных в контейнере 'Общие сведения'.", dependsOnMethods = "step7_fillFieldsAndCheckSuccessSaving")
    public void step8_checkDataInCardPage()
    {
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), null); // выбрать мероприятие в дереве
        dispensaryManager.getEventsPage().getEventsListTable().chooseRowInTable(0); // выбрать первую строчку в таблице
        dispensaryManager.getEventsPage().pressAgreementButton();
        dispensaryManager.getEventsPage().getAgreementModal().fillDateField();
        dispensaryManager.getEventsPage().pressCardButton(); // Нажать кнопку "Карточка"
        dispensaryManager.getMedicalCardPage().checkGeneralInformationData(dispensaryData); // Проверить значения на форме.
    }

    @Test (description = "Выбрать первую запись в таблице 'Осмотры и услуги' и нажать кнопку 'Осмотр'", dependsOnMethods = "step8_checkDataInCardPage")
    public void step9_selectRecordInServiceTable_AndClickInspectButton()
    {
        dispensaryManager.getMedicalCardPage().selectRecordInServiceTable(0); // Выбор первой строчки в таблице "Осмотры и услуги"
        dispensaryManager.getMedicalCardPage().clickInspecButton(); // Нажать кнопку "Осмотр"
    }

    @Test (description = "Проверка, что открылось модальное окно 'Оказание услуги' и произвести выполнение осмотра.", dependsOnMethods = "step9_selectRecordInServiceTable_AndClickInspectButton")
    public void step10_executeExamination()
    {
        dispensaryManager.getMedicalCardPage().getExecuteExaminationPage().executeExamination();
    }

    @Test (description = "Удаление созданного диагноза.", dependsOnMethods = "step10_executeExamination")
    public void step11_deleteDiagnosis()
    {
        dispensaryManager.getMedicalCardPage().clickResultsTab();
        dispensaryManager.getMedicalCardPage().deleteDiagnosis();
        dispensaryManager.getMedicalCardPage().closePage();
    }

    @Test (description = "Удаление пациента из мероприятия.", dependsOnMethods = "step11_deleteDiagnosis")
    public void step12_deletePatient()
    {
        dispensaryManager.getEventsPage().chooseEvent(dispensaryData.getCheckedEventName(), null); // выбрать мероприятие в дереве
        dispensaryManager.getEventsPage().getEventsListTable().chooseRowInTable(0); // выбрать первую строчку в таблице
        dispensaryManager.getEventsPage().deletePatient();
    }
}
