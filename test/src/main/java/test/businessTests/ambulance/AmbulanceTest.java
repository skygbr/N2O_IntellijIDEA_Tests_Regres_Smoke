package test.businessTests.ambulance;

import businessFramework.entities.ambulance.AmbulanceData;
import businessFramework.module.Values;
import businessFramework.module.ambulance.AmbulanceManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class AmbulanceTest extends TestBase implements Values
{
    AmbulanceManager aM;
    AmbulanceData aData;
    int brigadeTemplateViewRow;
    int employeeRow;
    int tsRow;
    int transportCreatedRow;
    int brigadeCreated1Row;
    int brigadeCreated2Row;
    int createdJob1;
    int createdJob2;
    String beginDateTime;
    String endDateTime;

    String beginDateTime_brigada1_doctor1;
    String endDateTime_brigada1_doctor1;
    String beginDateTime_brigada1_doctor2;
    String endDateTime_brigada1_doctor2;
    String beginDateTime_brigada1_driver;
    String endDateTime_brigada1_driver;
    String beginDateTime_brigada1_TS;
    String endDateTime_brigada1_TS;

    String beginDateTime_brigada2_doctor1;
    String endDateTime_brigada2_doctor1;
    String beginDateTime_brigada2_doctor2;
    String endDateTime_brigada2_doctor2;
    String beginDateTime_brigada2_driver;
    String endDateTime_brigada2_driver;
    String beginDateTime_brigada2_TS;
    String endDateTime_brigada2_TS;

    int jobTeamEmployeeDoctorRow;
    int jobTeamEmployeeDoctorRow2;

    @BeforeClass
    public void initialize() throws ParseException
    {
        aData = new AmbulanceData();
        aM = new AmbulanceManager();

        // Выбор контекста
        aData.setContextName("Подразделение для автотестов СНМП");

        // Заголовок модального окна
        aData.setAddBrigadeViewTemplateModalHeader("Создать шаблон вида бригады");

        // Данные для заполнения полей в модальном окне "Создать шаблон вида бригады"
        aData.setCodeValue(randomInt(4));
        aData.setCode2Value(randomInt(4));
        aData.setNameValue("ЛИН");
        aData.setName2Value("ЛИН2");
        aData.setRadioCode2(randomInt(4));
        aData.setNameEdited("ЛИНЕЙН");
        aData.setBrigadeKindValue("Выездная бригада");
        aData.setJobKindValue("В бригаде");
        aData.setBrigadeTypeValue("Врачебная");

        if (app.getProperty("baseUrl").contains("test12"))
        {
            aData.setProfileValue("диетологии");
        }
        else
        {
            aData.setProfileValue("Диетология");
        }

        // Заголовок модального окна
        aData.setAddEmployeeModalHeader(String.format("Добавить сотрудника в шаблон вида бригады '%s'", aData.getNameValue()));
        aData.setEditEmployeeModalHeader(String.format("Изменить сотрудника в шаблоне вида бригады '%s'", aData.getNameValue()));

        // Сообщения об успешном сохранении
        aData.setSuccessBrigadeViewTemplateMessage("Данные сохранены");
        aData.setSuccessEmployeeAddingMessage("Данные сохранены");
        aData.setSuccessEmployeeEditingMessage("Данные сохранены");
        aData.setSuccessTransportAddingMessage("Данные сохранены");
        aData.setSuccessTransportCreatingMessage("Данные сохранены");
        aData.setSuccessTransportEditingMessage("Данные сохранены");
        aData.setSuccessBrigadeCreatingMessage("Данные сохранены");
        aData.setSuccessJobTeamCreatingMessage("Данные сохранены");
        aData.setSuccessJobPersonCreatingMessage("Данные сохранены");

        // Данные для заполнения полей в модальном окне "Создать шаблон вида бригады"
        aData.setDoctor1Role("Врач");
        aData.setDoctor1PersonalCategoryCombobox("Врач");
        aData.setDoctor2PersonalCategoryCombobox("Врач");

        // todo  использовать файлы для каждого региона и сервера свой
        if (app.getProperty("baseUrl").contains("test12"))
        {
            aData.setDoctor1PersonalCategory("Врач");

        }
        else
        {
            aData.setDoctor1PersonalCategory("Врач (специалист с высшим медицинским образованием)");
        }

        aData.setDoctor1WorkingPlace("Врач");

        aData.setDoctor2Role("Врач");
        //aData.setDoctor2PersonalCategory("Врач");

        if (app.getProperty("baseUrl").contains("test12"))
        {
            aData.setDoctor2PersonalCategory("Врач");

        }
        else
        {
            aData.setDoctor2PersonalCategory("Врач (специалист с высшим медицинским образованием)");
        }

        //aData.setDoctor2PersonalCategory("Врач (специалист с высшим медицинским образованием)");
        aData.setDoctor2Speciality("Кардиолог");    // Специальность
        aData.setDoctor2Position("врач-кардиолог"); // Должность
        aData.setDoctor2WorkingPlace("Врач");

        aData.setDriverRole("Водитель старший");
        aData.setDriverWorkingPlace("Водитель старший");

        aData.setAddTransportModalHeader(String.format("Добавить ТС в шаблон вида бригады '%s'", aData.getNameValue()));
        aData.setEditTransportModalHeader(String.format("Изменить ТС в шаблоне вида бригады '%s'", aData.getNameValue()));
        aData.setEditBrigadeViewTemplateModalHeader(String.format("Изменить шаблон вида бригады '%s'", aData.getNameValue()));

        // Данные для заполнения полей в модальном окне "Добавить ТС в шаблон вида бригады 'ЛИН'"
        aData.setTransportRole("Транспорт");
        aData.setTransportWorkingPlace("Транспорт");
        aData.setTsType("Автомобиль");
        aData.setEquipmentKind("Перевозка");
        aData.setEquipmentKindEdited("Перевозка");

        aData.setRadioCode(randomInt(4));
        aData.setBeginWorkTime("08:00");
        aData.setEndWorkTime("08:00");
        aData.setMedProfile(aData.getProfileValue());
        aData.setProfile("Врачебная общепрофильная");
        aData.setBrigadeName2(randomChar(4));
        aData.setBrigadeName(randomChar(5));

        aData.setAddBrigadeModalHeader("Создать бригаду");
        aData.setCreateTransportModalHeader("Добавить карточку ТС");

        aData.setCreateTransportNumber(String.format("%s", String.format("А%sАА", randomInt(3))));
        aData.setCreateTransportNumber2(String.format("%s", String.format("А%sАА", randomInt(3))));
        aData.setCheckTransportNumber(String.format("%s RUS", aData.getCreateTransportNumber()));
        aData.setCheckTransportNumber2(String.format("%s RUS", aData.getCreateTransportNumber2()));
        aData.setCreateTransportCategory("B");
        aData.setCreateTransportCategoryEdited("C");
        aData.setCreateTransportEquipmentKind("Линейный");

        aData.setEditTransportCardModalHeader(String.format("Изменить карточку ТС '%s'", aData.getCreateTransportNumber()));

    /* ------------------------ Значения для полей в модальном окне "Создать наряд на бригаду" ---------------------- */
        aData.setAddTeamJobModalHeader("Создать наряд на бригаду");
        aData.setJobStation("ОДАСНМП");
        aData.setJobSubStation("Подразделение для автотестов СНМП");
        aData.setJobDate(getCurrentDate());

    /* ------------------------ Значения для полей в модальном окне "Создать наряд на сотрудника в бригаде1" ---------------------- */
        aData.setAddJobPersonModalHeader(String.format("Создать наряд на сотрудника в бригаде '%s%s (%s)'", aData.getCodeValue(), aData.getBrigadeName(), getCurrentDate()));
        aData.setAddJobPerson2ModalHeader(String.format("Создать наряд на сотрудника в бригаде '%s%s (%s)'", aData.getCodeValue(), aData.getBrigadeName2(), getCurrentDate()));
        aData.setBrigadeJob(String.format("%s%s(%s)", aData.getCodeValue(), aData.getBrigadeName(), aData.getJobDate()));
        aData.setBrigadeJob2(String.format("%s%s(%s)", aData.getCodeValue(), aData.getBrigadeName2(), aData.getJobDate()));
        aData.setHasTeamJob("");
        aData.setResourceKind("Сотрудник");
        aData.setResourceKindTransport("Транспорт");
        aData.setWorkingPlaceInTemplate("Врач");
        aData.setWorkingPlaceInTemplateDriver("Водитель старший");
        aData.setWorkingPlace2("Врач");
        aData.setWorkingPlace2Driver("Водитель");
        aData.setResource1("Врач1 Д. А.");
        aData.setResource2("Врач2 Д. А.");
        aData.setResource3("Водитель1 Д. А.");
        aData.setResource4("Колбаскин К. К.");
        aData.setResource5("Водитель2 Д. А.");

        aData.setEditJobPersonModalHeader(String.format("Изменить наряд на сотрудника '%s' в бригаде '%s (%s)'", aData.getResource1(), aData.getCodeValue() + aData.getBrigadeName(), getCurrentDate()));
        aData.setEditJobPerson2ModalHeader(String.format("Изменить наряд на сотрудника '%s' в бригаде '%s (%s)'", aData.getResource1(), aData.getCodeValue() + aData.getBrigadeName2(), getCurrentDate()));

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" на странице "Журнал нарядов бригад"---------------------- */
        aData.setJobTeamStartFlag("+");

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" на странице "Журнал нарядов бригад"---------------------- */
        aData.setResource1Full(String.format("20573: %s(Штатное расписание для прототипа \"Врачи\")", aData.getResource1()));
        aData.setResource2Full(String.format("22546: %s(Штатное расписание для прототипа \"Врачи\")", aData.getResource2()));
        aData.setResource3Full(String.format("21674: %s(Штатное расписание для прототипа \"Водитель\")", aData.getResource3()));
        aData.setResource4Full(String.format("20854: %s(Штатное расписание для прототипа \"Врачи\")", aData.getResource4()));
        aData.setResource5Full(String.format("21675: %s(Штатное расписание для прототипа \"Водитель\")", aData.getResource5()));
        aData.setWorkplaceColumnName("Рабочее место");
        aData.setWorkplaceName("Врач");

    /* ------------------------ Значения для полей в модальном окне "Создать наряд на сотрудника в бригаде" ---------------------- */
        aData.setRefusalDeviation("Заболел");
    /* ------------------------ Значения для полей в модальном окне "Создать наряд на ТС в бригаде" ---------------------- */

        aData.setAddJobTSModalHeader(String.format("Создать наряд на ТС в бригаде '%s (%s)'", aData.getCodeValue() + aData.getBrigadeName(), getCurrentDate()));
        aData.setAddJobTS2ModalHeader(String.format("Создать наряд на ТС в бригаде '%s (%s)'", aData.getCodeValue() + aData.getBrigadeName2(), getCurrentDate()));

        aData.setFillJobToBrigade1ModalHeader(String.format("Заполнить наряд на бригаду '%s (%s)'", aData.getCodeValue() + aData.getBrigadeName(), getCurrentDate()));
        aData.setFillJobToBrigade2ModalHeader(String.format("Заполнить наряд на бригаду '%s (%s)'", aData.getCodeValue() + aData.getBrigadeName2(), getCurrentDate()));

    /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду"( бригада 1) ---------------------- */
        aData.setWorkingPlaceEMP_doctor_Fill_1("Врач");
        aData.setSurnameEMP_doctor_Fill_1("Врач2");
        aData.setNameEMP_doctor_Fill_1("Для");
        aData.setPatrNameEMP_doctor_Fill_1("Автотестов СНМП");
        //aData.setBreakEMP_doctor_Fill_1("");
        //aData.setReplaceEMP_doctor_Fill_1("");

        aData.setWorkingPlaceEMP_driver_Fill_1("Водитель старший");
        aData.setSurnameEMP_driver_Fill_1("Водитель1");
        aData.setNameEMP_driver_Fill_1("Для");
        aData.setPatrNameEMP_driver_Fill_1("Автотестов СНМП");

        aData.setWorkingPlaceTSFill_1("Транспорт");

        /* ------------------------ Значения для столбцов в таблице "Сотрудники" в модальном окне "Заполнить наряд на бригаду"( бригада 2) ---------------------- */
        aData.setWorkingPlaceEMP_doctor_Fill_2("Врач");
        aData.setSurnameEMP_doctor_Fill_2("Колбаскин");
        aData.setNameEMP_doctor_Fill_2("Колбаскин");
        aData.setPatrNameEMP_doctor_Fill_2("Колбаскин");
        //aData.setBreakEMP_doctor_Fill_1("");
        //aData.setReplaceEMP_doctor_Fill_1("");

        aData.setWorkingPlaceEMP_driver_Fill_2("Водитель старший");
        aData.setSurnameEMP_driver_Fill_2("Водитель2");
        aData.setNameEMP_driver_Fill_2("Для");
        aData.setPatrNameEMP_driver_Fill_2("Автотестов СНМП");

        aData.setWorkingPlaceTSFill_2("Транспорт");

        aData.setColorOfRow("#B94A48");
        aData.setChangeBeginTime("08:00:00");
        aData.setChangeEndTime("08:00:00");
        aData.setColorOfOpenedRow("#468847");

        /*------------------------- Значения для фильтра на странице Транспортное средство -------------------------------------------------------------*/
        aData.setActiveTransportFilter("действующий");
    }

    /**
     * Добавляет 10 минут к дате
     *
     * @param date текущая дата
     *
     * @return
     * @throws ParseException
     */
    public String add10MinutesToDate(String date) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date d = df.parse(date);
        d = new Date(d.getTime() + 10 * 60 * 1000);
        return df.format(d);
    }

    /**
     * Добавляет 8 часов к дате
     *
     * @param date текущая дата
     *
     * @return
     * @throws ParseException
     */
    public String add8HoursToDate(String date) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date d = df.parse(date);
        d = new Date(d.getTime() + 8 * 60 * 60 * 1000);
        return df.format(d);
    }

    /**
     * Добавляет 1 день к дате и времени
     *
     * @param date текущая дата
     *
     * @return
     * @throws ParseException
     */
    public String add1DayToDateTime(String date) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date d = df.parse(date);
        d = new Date(d.getTime() + 24 * 60 * 60 * 1000);
        return df.format(d);
    }

    /**
     * Добавляет 1 день к дате и времени
     *
     * @param date текущая дата
     *
     * @return
     * @throws ParseException
     */
    public String add1DayToDate(String date) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date d = df.parse(date);
        d = new Date(d.getTime() + 24 * 60 * 60 * 1000);
        return df.format(d);
    }

    @Test (description = "Открытие модуля 'Скорая помощь' и удаление лишних данных")
    public void step1_openAmbulanceModule()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(aData.getContextName()); // выбрать контекст
        aM.openAmbulanceModule();

        aM.openBrigadsPage();
        aM.getBrigadsPage().deleteAllBrigades();

        aM.openBrigadeViewTemplatePage();
        aM.getBrigadeViewTemplatePage().deleteAllBrigadesTemplates();

        aM.openTransportPage();
        aM.getTransportPage().deleteAllTransports(aData.getActiveTransportFilter());
    }

    @Test (description = "Открытие страницы 'Шаблон вида бригады'", dependsOnMethods = "step1_openAmbulanceModule")
    public void step2_OpenBrigadaViewTemplatePage()
    {
        aM.openBrigadeViewTemplatePage();
    }

    @Test (description = "Создание вида бригады", dependsOnMethods = "step2_OpenBrigadaViewTemplatePage")
    public void step3_createBrigadeTemplateView()
    {
        aM.getBrigadeViewTemplatePage().clickAddBrigadeViewTemplateButton(); // Нажать кнопку “Добавить” в контейнере "Настройка вида бригады"

        aM.getBrigadeViewTemplatePage().getAddBrigadeViewTemplateModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddBrigadeViewTemplateModal().checkModalHeader(aData.getAddBrigadeViewTemplateModalHeader());

        aM.getBrigadeViewTemplatePage().getAddBrigadeViewTemplateModal().fillFields(aData.getCodeValue(), aData.getNameValue(), aData.getBrigadeKindValue(), aData.getJobKindValue(), aData.getBrigadeTypeValue(), aData.getProfileValue());
        aM.getBrigadeViewTemplatePage().getAddBrigadeViewTemplateModal().clickSaveBrigadeViewTemplateButton();

        aM.getBrigadeViewTemplatePage().getAddBrigadeViewTemplateModal().assertCountOfModals(0);

        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessBrigadeViewTemplateMessage());
    }

    @Test (description = "Создание сотрудников - Врач", dependsOnMethods = "step3_createBrigadeTemplateView")
    public void step4_create_employeeDoctor()
    {
        brigadeTemplateViewRow = aM.getBrigadeViewTemplatePage().checkTableBrigadeTemplateViewValues(aData.getCodeValue(), aData.getNameValue(), aData.getBrigadeKindValue(), aData.getJobKindValue(), aData.getBrigadeTypeValue(), aData.getProfileValue());
        aM.getBrigadeViewTemplatePage().getSettingsBrigadeViewTable().chooseRowInTable(brigadeTemplateViewRow); // 	В контейнере "Настройка вида бригады" Выберите созданную запись.

        aM.getBrigadeViewTemplatePage().clickAddEmployeeButton();
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().checkModalHeader(aData.getAddEmployeeModalHeader());

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().fillFields(aData.getDoctor1Role(), aData.getDoctor1PersonalCategoryCombobox(), null, null, null);
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().checkFields(aData.getDoctor1Role(), aData.getDoctor1PersonalCategory(), aData.getDoctor1WorkingPlace());
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().clickSaveEmployeeButton();

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(0);
        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessEmployeeAddingMessage());
    }

    @Test (description = "Создание сотрудников - Водитель старший", dependsOnMethods = "step4_create_employeeDoctor")
    public void step5_createEmployeeDriver()
    {
        aM.getBrigadeViewTemplatePage().getSettingsBrigadeViewTable().chooseRowInTable(brigadeTemplateViewRow); // 	В контейнере "Настройка вида бригады" Выберите созданную запись.
        aM.getBrigadeViewTemplatePage().clickAddEmployeeButton();

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().checkModalHeader(aData.getAddEmployeeModalHeader());

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().fillFields(aData.getDriverRole(), null, null, null, null);
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().checkFields(aData.getDriverRole(), null, aData.getDriverWorkingPlace());
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().clickSaveEmployeeButton();

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(0);
        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessEmployeeAddingMessage());
    }

    @Test (description = "Изменение рабочего места 'Врач'", dependsOnMethods = "step5_createEmployeeDriver")
    public void step6_createEmployeeCardiologDoctor()
    {
        aM.getBrigadeViewTemplatePage().getSettingsBrigadeViewTable().chooseRowInTable(brigadeTemplateViewRow); // 	В контейнере "Настройка вида бригады" Выберите созданную запись.

        employeeRow = aM.getBrigadeViewTemplatePage().checkTableEmployeesValues(aData.getDoctor1WorkingPlace(), aData.getDoctor1Role(), aData.getDoctor1PersonalCategory(), null);
        aM.getBrigadeViewTemplatePage().getEmployeesTable().chooseRowInTable(employeeRow);
        aM.getBrigadeViewTemplatePage().clickEditEmployeeButton();

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().checkModalHeader(aData.getEditEmployeeModalHeader());

        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().fillFields(null, aData.getDoctor2PersonalCategoryCombobox(), null, aData.getDoctor2Speciality(), aData.getDoctor2Position());
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().clickSaveEmployeeButton();
        aM.getBrigadeViewTemplatePage().getAddEmployeeModal().assertCountOfModals(0);

        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessEmployeeEditingMessage());
        aM.getBrigadeViewTemplatePage().checkTableEmployeesValues(aData.getDoctor2WorkingPlace(), aData.getDoctor2Role(), aData.getDoctor2PersonalCategory(), aData.getDoctor2Position());
    }

    @Test (description = "Добавление транспорта", dependsOnMethods = "step6_createEmployeeCardiologDoctor")
    public void step7_transportAdding()
    {
        aM.getBrigadeViewTemplatePage().getTransportContainer().clickContainer(); // Перейдите в контейнер "Транспорт"
        aM.getBrigadeViewTemplatePage().clickAddTransportButton();

        aM.getBrigadeViewTemplatePage().getAddTransportModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddTransportModal().checkModalHeader(aData.getAddTransportModalHeader());
        aM.getBrigadeViewTemplatePage().getAddTransportModal().fillFields(aData.getTransportRole(), aData.getTransportWorkingPlace(), aData.getTsType(), aData.getEquipmentKind());

        aM.getBrigadeViewTemplatePage().getAddTransportModal().clickSaveTransportButton();
        aM.getBrigadeViewTemplatePage().getAddTransportModal().assertCountOfModals(0);

        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportAddingMessage());
    }

    @Test (description = "Изменение транспорта", dependsOnMethods = "step7_transportAdding")
    public void step8_changeTransport()
    {
        tsRow = aM.getBrigadeViewTemplatePage().checkTableTransportValues(aData.getTransportRole(), aData.getTransportWorkingPlace(), aData.getTsType(), aData.getEquipmentKind());
        aM.getBrigadeViewTemplatePage().getTransportTable().chooseRowInTable(tsRow);
        aM.getBrigadeViewTemplatePage().clickEditTransportButton();


        aM.getBrigadeViewTemplatePage().getAddTransportModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getAddTransportModal().checkModalHeader(aData.getEditTransportModalHeader());
        aM.getBrigadeViewTemplatePage().getAddTransportModal().fillFields(null, null, null, aData.getEquipmentKindEdited());

        aM.getBrigadeViewTemplatePage().getAddTransportModal().clickSaveTransportButton();
        aM.getBrigadeViewTemplatePage().getAddTransportModal().assertCountOfModals(0);

        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportAddingMessage());

        aM.getBrigadeViewTemplatePage().checkTableTransportValues(aData.getTransportRole(), aData.getTransportWorkingPlace(), aData.getTsType(), aData.getEquipmentKindEdited());
    }

    @Test (description = "Проверка шаблона бригады", dependsOnMethods = "step8_changeTransport")
    public void step9_checkBrigadeViewTemplate()
    {
        brigadeTemplateViewRow = aM.getBrigadeViewTemplatePage().checkTableBrigadeTemplateViewValues(aData.getCodeValue(), aData.getNameValue(), aData.getBrigadeKindValue(), aData.getJobKindValue(), aData.getBrigadeTypeValue(), aData.getProfileValue());
        aM.getBrigadeViewTemplatePage().clickEditBrigadeViewTemplateButton();

        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().assertCountOfModals(1);
        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().checkModalHeader(aData.getEditBrigadeViewTemplateModalHeader());

        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().checkEmployeesGroupTableValues(aData.getDoctor2WorkingPlace(), aData.getDoctor2Role(), aData.getDoctor2PersonalCategory(), aData.getDoctor2Position());
        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().checkEmployeesGroupTableValues(aData.getDriverWorkingPlace(), aData.getDriverRole(), null, null);
        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().checkTransportGroupTableValues(aData.getTransportWorkingPlace(), aData.getTransportRole(), aData.getTsType(), aData.getEquipmentKindEdited());

        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().fillFields(aData.getNameEdited());

        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().clickSaveButton();
        aM.getBrigadeViewTemplatePage().getEditBrigadeViewTemplateModal().assertCountOfModals(0);

        aM.getBrigadeViewTemplatePage().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportAddingMessage());

        aM.getBrigadeViewTemplatePage().checkTableBrigadeTemplateViewValues(aData.getCodeValue(), aData.getNameEdited(), aData.getBrigadeKindValue(), aData.getJobKindValue(), aData.getBrigadeTypeValue(), aData.getProfileValue());
    }

    @Test (description = "Создание бригады1", dependsOnMethods = "step9_checkBrigadeViewTemplate")
    public void step10_brigade1Creating()
    {
        aM.openBrigadsPage();
        aM.getBrigadsPage().clickAddBrigadeButton();

        aM.getBrigadsPage().getAddBrigadeModal().assertCountOfModals(1);
        aM.getBrigadsPage().getAddBrigadeModal().checkModalHeader(aData.getAddBrigadeModalHeader());

        aM.getBrigadsPage().getAddBrigadeModal().fillFields(aData.getCodeValue(), null, null,  null);
        aM.getBrigadsPage().getAddBrigadeModal().checkFieldsValues(aData.getJobKindValue(), aData.getBrigadeKindValue(), aData.getBrigadeTypeValue(), aData.getCodeValue(), aData.getBeginWorkTime(), aData.getEndWorkTime(), aData.getMedProfile());

        aM.getBrigadsPage().getAddBrigadeModal().fillFields(null, aData.getProfile(), aData.getRadioCode(), aData.getBrigadeName());
        aM.getBrigadsPage().getAddBrigadeModal().clickSaveBrigadeButton();
        aM.getBrigadsPage().getAddBrigadeModal().assertCountOfModals(0);
        aM.getBrigadsPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessBrigadeCreatingMessage());

        brigadeCreated1Row = aM.getBrigadsPage().checkTableValues(aData.getCodeValue() + aData.getBrigadeName(), aData.getBrigadeKindValue(), aData.getBrigadeTypeValue(), aData.getRadioCode());
    }

    @Test (description = "Создание бригады2", dependsOnMethods = "step10_brigade1Creating")
    public void step11_brigade2Creating()
    {
        aM.openBrigadsPage();
        aM.getBrigadsPage().clickAddBrigadeButton();

        aM.getBrigadsPage().getAddBrigadeModal().assertCountOfModals(1);
        aM.getBrigadsPage().getAddBrigadeModal().checkModalHeader(aData.getAddBrigadeModalHeader());

        aM.getBrigadsPage().getAddBrigadeModal().fillFields(aData.getCodeValue(), null, null, null );
        aM.getBrigadsPage().getAddBrigadeModal().checkFieldsValues( aData.getJobKindValue(), aData.getBrigadeKindValue(), aData.getBrigadeTypeValue(), aData.getCodeValue(), aData.getBeginWorkTime(), aData.getEndWorkTime(), aData.getMedProfile());

        aM.getBrigadsPage().getAddBrigadeModal().fillFields(null, aData.getProfile(), aData.getRadioCode2(), aData.getBrigadeName2());
        aM.getBrigadsPage().getAddBrigadeModal().clickSaveBrigadeButton();
        aM.getBrigadsPage().getAddBrigadeModal().assertCountOfModals(0);
        aM.getBrigadsPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessBrigadeCreatingMessage());

        brigadeCreated2Row = aM.getBrigadsPage().checkTableValues(aData.getCodeValue() + aData.getBrigadeName2(), aData.getBrigadeKindValue(), aData.getBrigadeTypeValue(), aData.getRadioCode2());
    }

    @Test (description = "Создание транспортного средства", dependsOnMethods = "step11_brigade2Creating")
    public void step12_creatingTransport()
    {
        aM.openTransportPage();
        aM.getTransportPage().clickCreateTransportButton();

        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(1);
        aM.getTransportPage().getCreateTransportModal().checkModalHeader(aData.getCreateTransportModalHeader());

        aM.getTransportPage().getCreateTransportModal().fillFields(aData.getCreateTransportNumber(), aData.getCreateTransportEquipmentKind(), null);
        aM.getTransportPage().getCreateTransportModal().checkFields(true);
        aM.getTransportPage().getCreateTransportModal().clickSaveCreatedTransportButton();

        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(0);
        aM.getTransportPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportCreatingMessage());

        transportCreatedRow = aM.getTransportPage().checkTransportTableValues(aData.getCheckTransportNumber(), aData.getCreateTransportCategory(), aData.getTsType(), aData.getCreateTransportEquipmentKind());
    }

    @Test (description = "Проверка созданного транспортного средства", dependsOnMethods = "step12_creatingTransport")
    public void step13_checkingCreatedTransport()
    {
        aM.getTransportPage().getTransportTable().chooseRowInTable(transportCreatedRow);
        aM.getTransportPage().clickEditCreatedTransportButton();

        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(1);
        aM.getTransportPage().getCreateTransportModal().checkModalHeader(aData.getEditTransportCardModalHeader());
        aM.getTransportPage().getCreateTransportModal().checkFieldsDisability();
        aM.getTransportPage().getCreateTransportModal().clickEditCreatedTSButton();
        aM.getTransportPage().getCreateTransportModal().fillFields(null, null, aData.getCreateTransportCategoryEdited());
        aM.getTransportPage().getCreateTransportModal().clickSaveCreatedTransportButton();
        aM.getTransportPage().getCreateTransportModal().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportEditingMessage());
        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(1);
        aM.getTransportPage().getCreateTransportModal().closeModal();
    }

    @Test (description = "Создание транспортного средства2", dependsOnMethods = "step13_checkingCreatedTransport")
    public void step14_creatingTransport2()
    {
        aM.openTransportPage();
        aM.getTransportPage().clickCreateTransportButton();

        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(1);
        aM.getTransportPage().getCreateTransportModal().checkModalHeader(aData.getCreateTransportModalHeader());

        aM.getTransportPage().getCreateTransportModal().fillFields(aData.getCreateTransportNumber2(), aData.getCreateTransportEquipmentKind(), null);
        aM.getTransportPage().getCreateTransportModal().checkFields(true);
        aM.getTransportPage().getCreateTransportModal().clickSaveCreatedTransportButton();

        aM.getTransportPage().getCreateTransportModal().assertCountOfModals(0);
        aM.getTransportPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessTransportCreatingMessage());

        transportCreatedRow = aM.getTransportPage().checkTransportTableValues(aData.getCheckTransportNumber2(), aData.getCreateTransportCategory(), aData.getTsType(), aData.getCreateTransportEquipmentKind());
    }

    @Test (description = "Создание 'Наряда'", dependsOnMethods = "step14_creatingTransport2")
    public void step15_teamCreating()
    {
        aM.openTeamJournalPage();
        aM.getTeamJobsJournalPage().clickCreateTeamButton();

        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().checkModalHeader(aData.getAddTeamJobModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().checkFields(aData.getJobStation(), aData.getJobSubStation(), aData.getJobDate(), null);
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().fillFields(null, null, null, aData.getCodeValue()+ aData.getBrigadeName());

        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().clickSaveJobTeamButton();
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobTeamCreatingMessage());
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().assertCountOfModals(0);

        createdJob1 = aM.getTeamJobsJournalPage().checkJobTeamTableValues(aData.getCodeValue() + aData.getBrigadeName(), aData.getJobDate());
    }

    @Test (description = "Добавление сотрудников в наряд 1 - врач1", dependsOnMethods = "step15_teamCreating")
    public void step16_addEmployeesToJobTeam_1() throws ParseException
    {
        aM.getTeamJobsJournalPage().getJobTeamTable().chooseRowInTable(createdJob1);
        aM.getTeamJobsJournalPage().clickCreateEmployeeTeamJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobPersonModalHeader());

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields(getCurrentDate(), aData.getBrigadeJob(), null, aData.getResourceKind(), null, null, null, null, null, false, aData.getBeginDateTime(), aData.getEndDateTime());

        beginDateTime_brigada1_doctor1 = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada1_doctor1   = add10MinutesToDate(beginDateTime_brigada1_doctor1);

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, aData.getWorkingPlaceInTemplate(), null, null, null, aData.getJobKindValue(), false, beginDateTime_brigada1_doctor1, endDateTime_brigada1_doctor1);// тут добавить день к началу

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, null, null, null, aData.getResource1(), null, true, null, null);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().clickSavePersonJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());

        System.out.println(aData.getWorkingPlace2()+  aData.getResource1Full() + beginDateTime_brigada1_doctor1 + endDateTime_brigada1_doctor1);
        jobTeamEmployeeDoctorRow = aM.getTeamJobsJournalPage().checkEmployeesTableValues(aData.getWorkingPlace2(), beginDateTime_brigada1_doctor1/** + ":00"*/, endDateTime_brigada1_doctor1/** + ":00"*/);
    }

    @Test(description = "Добавление сотрудников в наряд1 - изменение врач1 на врач2", dependsOnMethods = "step16_addEmployeesToJobTeam_1", enabled = false)
    public void step17_addEmployeesToJobTeam_2() throws ParseException
    {
        aM.getTeamJobsJournalPage().getEmployeesTable().chooseRowInTable(0);
        aM.getTeamJobsJournalPage().getEmployeesTable().chooseRowInTable(jobTeamEmployeeDoctorRow);

        //TODO кнопка изменить не доступна для нарядов на сотрудников, изменен механизм работы.
        aM.getTeamJobsJournalPage().clickEditEmployeeTeamJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getEditJobPersonModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields( getCurrentDate(), aData.getBrigadeJob(), null, aData.getResourceKind(), null, null, null, aData.getResource1(), aData.getJobKindValue(), true, aData.getBeginDateTime(), aData.getEndDateTime());

        beginDateTime_brigada1_doctor2 = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada1_doctor2   = add10MinutesToDate(beginDateTime_brigada1_doctor2);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, null, null, null, aData.getResource2(), null, false, beginDateTime_brigada1_doctor2, endDateTime_brigada1_doctor2);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().clickSavePersonJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());

        aM.getTeamJobsJournalPage().checkEmployeesTableValues(aData.getWorkingPlace2(), beginDateTime_brigada1_doctor2 + ":00", endDateTime_brigada1_doctor2 + ":00");
    }

    @Test(description = "Добавление сотрудников в наряд - водитель", dependsOnMethods = "step16_addEmployeesToJobTeam_1")
    public void step18_addEmployeesToJobTeam_3() throws ParseException
    {
        aM.getTeamJobsJournalPage().clickCreateEmployeeTeamJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobPersonModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields( getCurrentDate(), null, null, aData.getResourceKind(), null, null, null, null, null, false, aData.getBeginDateTime(), aData.getEndDateTime());

        beginDateTime_brigada1_driver = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada1_driver   = add10MinutesToDate(beginDateTime_brigada1_driver); // Прибавляется к дате окончания 10 минут
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, aData.getBrigadeJob(), null, null, aData.getWorkingPlaceInTemplateDriver(), null, null, null,aData.getJobKindValue(), false, beginDateTime_brigada1_driver, endDateTime_brigada1_driver);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, null, null, null, aData.getResource3(), null, false, null, null);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().clickSavePersonJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());
        //aM.getTeamJobsJournalPage().checkEmployeesTableValues(aData.getDriverWorkingPlace(), aData.getResource3Full(), beginDateTime_brigada1_driver + ":00", endDateTime_brigada1_driver + ":00");
    }

    @Test (description = "Добавление транспортного средства1 в наряд 1", dependsOnMethods = "step18_addEmployeesToJobTeam_3")
    public void step19_addTransoprtToJobTeam() throws ParseException
    {
        beginDateTime_brigada1_TS = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada1_TS = add10MinutesToDate(beginDateTime_brigada1_TS);

        aM.getTeamJobsJournalPage().getTeamJobsTransportContainer().clickContainer();
        aM.getTeamJobsJournalPage().clickCreateTransportTeamJobButton();
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobTSModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields(
                getCurrentDate(), null, null, aData.getResourceKindTransport(),
                null, null, null, null,
                null, false, getCurrentDate() + " 08:00", add1DayToDateTime(getCurrentDate() + " 08:00"));
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFieldsTS(null, aData.getBrigadeJob(), null, null, aData.getTransportWorkingPlace(), null, null, aData.getCreateTransportNumber(), aData.getJobKindValue(), false, beginDateTime_brigada1_TS, endDateTime_brigada1_TS, aData.getCreateTransportNumber());
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().clickSaveJobTeamButton();
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());

        aM.getTeamJobsJournalPage().checkTransportTableValues(aData.getTransportWorkingPlace(), aData.getCreateTransportNumber(), beginDateTime_brigada1_TS/** + ":00"*/, endDateTime_brigada1_TS/** + ":00"*/);
    }

    @Test (description = "Создание 'Наряда'2", dependsOnMethods = "step19_addTransoprtToJobTeam")
    public void step20_team2Creating()
    {
        aM.openTeamJournalPage();

        aM.getTeamJobsJournalPage().clickCreateTeamButton();

        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().checkModalHeader(aData.getAddTeamJobModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().checkFields(aData.getJobStation(), aData.getJobSubStation(), aData.getJobDate(), null);
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().fillFields(null, null, null, aData.getCodeValue() + aData.getBrigadeName2());

        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().clickSaveJobTeamButton();
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobTeamCreatingMessage());
        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().assertCountOfModals(0);
        createdJob2 = aM.getTeamJobsJournalPage().checkJobTeamTableValues(aData.getCodeValue() + aData.getBrigadeName2(), aData.getJobDate());

        aM.getTeamJobsJournalPage().getJobTeamTable().chooseRowInTable(createdJob2);
    }

    @Test (description = "Добавление сотрудников в наряд 2 - врач1", dependsOnMethods = "step20_team2Creating")
    public void step21_addEmployeesToJobTeam2_doctor() throws ParseException
    {
        aM.getTeamJobsJournalPage().getTeamJobsEmployeesContainer().clickContainer();
        aM.getTeamJobsJournalPage().clickCreateEmployeeTeamJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobPerson2ModalHeader());

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields(getCurrentDate(), aData.getBrigadeJob2(), null, aData.getResourceKind(), null, null, null, null, null, false, aData.getBeginDateTime(), aData.getEndDateTime());

        beginDateTime_brigada2_doctor1 = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada2_doctor1   = add10MinutesToDate(beginDateTime_brigada2_doctor1);// Прибавляется к дате окончания 10 минут

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, aData.getWorkingPlaceInTemplate(), null, null, null, null, false, beginDateTime_brigada2_doctor1, endDateTime_brigada2_doctor1);// тут добавить день к началу

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, null, null, null, aData.getResource2(), aData.getJobKindValue(), true, null, null);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().clickSavePersonJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());

        //jobTeamEmployeeDoctorRow2 = aM.getTeamJobsJournalPage().checkEmployeesTableValues(aData.getWorkingPlace2(), aData.getResource1Full(), beginDateTime_brigada2_doctor1 + ":00", endDateTime_brigada2_doctor1 + ":00");
    }

    @Test(description = "Добавление сотрудников в наряд - водитель", dependsOnMethods = "step21_addEmployeesToJobTeam2_doctor")
    public void step22_addEmployeesToJobTeam2_driver() throws ParseException
    {
        aM.getTeamJobsJournalPage().clickCreateEmployeeTeamJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobPerson2ModalHeader());

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields( getCurrentDate(), aData.getBrigadeJob2(), null, aData.getResourceKind(), null, null, null, null, null, false, aData.getBeginDateTime(), aData.getEndDateTime());

        beginDateTime_brigada2_driver = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada2_driver   = add10MinutesToDate(beginDateTime_brigada2_driver); // Прибавляется к дате окончания 10 минут

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, aData.getWorkingPlaceInTemplateDriver(), null, null, null, aData.getJobKindValue(), false, beginDateTime_brigada2_driver, endDateTime_brigada2_driver);

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFields(null, null, null, null, null, null, null, aData.getResource5(), null, false, null, null);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().clickSavePersonJobButton();

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());
        //aM.getTeamJobsJournalPage().checkEmployeesTableValues(aData.getWorkingPlaceInTemplateDriver(), aData.getResource5Full(), beginDateTime_brigada2_driver + ":00", endDateTime_brigada2_driver + ":00");
    }

    @Test (description = "Добавление транспортного средства в наряд 2", dependsOnMethods = "step22_addEmployeesToJobTeam2_driver")
    public void step23_addTransoprtToJobTeam2() throws ParseException
    {
        aM.getTeamJobsJournalPage().getTeamJobsTransportContainer().clickContainer();
        aM.getTeamJobsJournalPage().clickCreateTransportTeamJobButton();
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkModalHeader(aData.getAddJobTS2ModalHeader());
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().checkFields( getCurrentDate(), null, null, aData.getResourceKindTransport(), null, null, null, null, null, false, getCurrentDate() + " 08:00", add1DayToDateTime(getCurrentDate()+ " 08:00"));

        beginDateTime_brigada2_TS = add8HoursToDate(getCurrentDateTime());
        endDateTime_brigada2_TS   = add10MinutesToDate(beginDateTime_brigada2_TS); // Прибавляется к дате окончания 10 минут

        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().fillFieldsTS(null, aData.getBrigadeJob2(), null, null, aData.getTransportWorkingPlace(), null, null, aData.getCreateTransportNumber2(), aData.getJobKindValue(), false, beginDateTime_brigada2_TS, endDateTime_brigada2_TS, aData.getCreateTransportNumber2());

        aM.getTeamJobsJournalPage().getCreateJobForBrigadeModal().clickSaveJobTeamButton();
        aM.getTeamJobsJournalPage().getCreateJobForPersonModal().assertCountOfModals(0);
        aM.getTeamJobsJournalPage().getAlerts().assertSuccessAlertMessage(aData.getSuccessJobPersonCreatingMessage());
        /**Убрал значение у beginDateTime_brigada2_TS + ":00", endDateTime_brigada2_TS + ":00" <+ ":00"> - в таблице данные без данных значений*/
        aM.getTeamJobsJournalPage().checkTransportTableValues(aData.getTransportWorkingPlace(), aData.getCreateTransportNumber2(), beginDateTime_brigada2_TS/** + ":00"*/, endDateTime_brigada2_TS/** + ":00"*/);
    }

    @Test (description = "Проверка созданных записей", dependsOnMethods = "step23_addTransoprtToJobTeam2")
    public void step24_checkingCreatedRecords()
    {
        // Бригада 1
        int foundedRow = aM.getTeamJobsJournalPage().checkJobTeamTableValues(aData.getCodeValue() + aData.getBrigadeName(), getCurrentDate());
        aM.getTeamJobsJournalPage().getJobTeamTable().chooseRowInTable(foundedRow);
        aM.getTeamJobsJournalPage().clickFillTeamJobButton();

        aM.getTeamJobsJournalPage().getFillTeamJobModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkModalHeader(aData.getFillJobToBrigade1ModalHeader());

        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkFields(getCurrentDate(), aData.getCodeValue() + aData.getBrigadeName(), beginDateTime, endDateTime);

        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkEmpTableValues(aData.getWorkingPlaceEMP_driver_Fill_1(), aData.getSurnameEMP_driver_Fill_1(), aData.getNameEMP_driver_Fill_1(), aData.getPatrNameEMP_driver_Fill_1(), beginDateTime_brigada1_driver + ":00", endDateTime_brigada1_driver + ":00", null, null);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkTSTableValues(aData.getWorkingPlaceTSFill_1(), aData.getResourceTSFill_1(), beginDateTime_brigada1_TS + ":00", endDateTime_brigada1_TS + ":00", null, null);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().closeModal();

        // Бригада 2
        int foundedRow2 = aM.getTeamJobsJournalPage().checkJobTeamTableValues(aData.getCodeValue() + aData.getBrigadeName2(), getCurrentDate());
        aM.getTeamJobsJournalPage().getJobTeamTable().chooseRowInTable(foundedRow2);
        aM.getTeamJobsJournalPage().clickFillTeamJobButton();

        aM.getTeamJobsJournalPage().getFillTeamJobModal().assertCountOfModals(1);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkModalHeader(aData.getFillJobToBrigade2ModalHeader());

        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkFields(getCurrentDate(), aData.getCodeValue() + aData.getBrigadeName2(), beginDateTime, endDateTime);

        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkEmpTableValues(aData.getWorkingPlaceEMP_driver_Fill_2(), aData.getSurnameEMP_driver_Fill_2(), aData.getNameEMP_driver_Fill_2(), aData.getPatrNameEMP_driver_Fill_2(), beginDateTime_brigada2_driver + ":00", endDateTime_brigada2_driver + ":00", null, null);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().checkTSTableValues(aData.getWorkingPlaceTSFill_2(), aData.getResourceTSFill_2(), beginDateTime_brigada2_TS + ":00", endDateTime_brigada2_TS + ":00", null, null);
        aM.getTeamJobsJournalPage().getFillTeamJobModal().closeModal();
    }

    @Test(description = "Отклонение записи", dependsOnMethods = "step24_checkingCreatedRecords")
    public void step25_deny_record() throws ParseException
    {
        aM.openAdministrationChangesPage();
        aM.getAdministrationChangePage().getChangesTable().chooseRowInTable(0);

        // Проверка цвета текста в каждой ячейке таблицы
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_STATION,      aData.getJobStation(),           aData.getColorOfRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(JOB_SUBSTATION,      aData.getContextName(),          aData.getColorOfRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_BEGIN_DATE,   getCurrentDate(),                aData.getColorOfRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_BEGIN_TIME,   aData.getChangeBeginTime(),      aData.getColorOfRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_END_DATE,     add1DayToDate(getCurrentDate()), aData.getColorOfRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_END_TIME,     aData.getChangeEndTime(),        aData.getColorOfRow());

        aM.getAdministrationChangePage().clickForceOpenButton();
        aM.getAdministrationChangePage().getChangesTable().getAlerts().assertSuccessAlertIsPresent();

        // Проверка цвета текста в каждой ячейке таблицы после принудительного начала
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_STATION,      aData.getJobStation(),           aData.getColorOfOpenedRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(JOB_SUBSTATION,      aData.getContextName(),          aData.getColorOfOpenedRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_BEGIN_DATE,   getCurrentDate(),                aData.getColorOfOpenedRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_BEGIN_TIME,   aData.getChangeBeginTime(),      aData.getColorOfOpenedRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_END_DATE,     add1DayToDate(getCurrentDate()), aData.getColorOfOpenedRow());
        aM.getAdministrationChangePage().getChangesTable().assertColorTextInTableByColumnValue(CHANGE_END_TIME,     aData.getChangeEndTime(),        aData.getColorOfOpenedRow());
        aM.openTeamJournalPage();

        HashMap<String, String> startFlagValue = new HashMap<>();
        startFlagValue.put("", aData.getJobTeamStartFlag());
        aM.getTeamJobsJournalPage().getJobTeamTable().chooseRowBySeveralColumnValues(startFlagValue);

        HashMap<String, String> workplaceValue = new HashMap<>();
        workplaceValue.put(aData.getWorkplaceColumnName(), aData.getWorkplaceName());
        aM.getTeamJobsJournalPage().getEmployeesTable().chooseRowBySeveralColumnValues(workplaceValue);
    }
}