package test.businessTests.vaccinationWithGeneration;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.IndividPlanManager;
import net.framework.autotesting.entities.UserData;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VaccineJournalTest extends TestBase implements Values {

    private IndividPlanManager individPlanManager;
    private IndividPlanData individPlanData;
    private UserData user;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        individPlanManager = new IndividPlanManager();
        individPlanData = new IndividPlanData();
        user = new UserData();

        user.setUser("VaccineJournalTest");
        user.setPassword("xL62U88r");

        individPlanData.setPatient("VaccineJournalTest VaccineJournalTest VaccineJournalTest");
        individPlanData.setCalendar("VaccineJournalTest");
        individPlanData.setResourse("VaccineJournalTest");
        individPlanData.setVaccine("VaccineJournalTest");
        individPlanData.setPhase("V");
        individPlanData.setSeries("VaccineJournalTest");
        individPlanData.setBirthDate("01.01.1990");
        individPlanData.setInfection("VaccineJournalTest");
    }

    @Test(description = "Создание тестовых данных и вход в n2o")
    public void beforeTest() {
        app.executeLiquibase("changelog/vaccination/201606071653_insert_VaccineJournalTest.xml");
        app.getNavigationHelper().openMainPage(user);
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Назначение прививок пациенту по календарю", dependsOnMethods = "beforeTest", priority = 1)
    public void step1_vaccineModule()
    {
        individPlanManager.openIndividPlan();

        individPlanManager.getIndividPlanPage().getPatient().setValue(individPlanData.getPatient());
        individPlanManager.getIndividPlanPage().getCalendar().setValue(individPlanData.getCalendar());
        individPlanManager.getIndividPlanPage().clickFormButton();
        individPlanManager.getIndividPlanPage().clickAssignAllInfectionsButton();
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().fillAssignAllInfectionsForm(individPlanData);
        individPlanManager.getIndividPlanPage().getAssignAllInfectionsModal().clickConfirmButton();
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика", dependsOnMethods = "step1_vaccineModule", priority = 1)
    public void step2_openVaccineJournal()
    {
        individPlanManager.openVacineJournal();
    }

    @Test(description = "Фильтрация назначенных прививок по пациенту", dependsOnMethods = "step2_openVaccineJournal", priority = 1)
    public void step3_vaccineFilter()
    {
        individPlanManager.getVacineJournalPage().filterByPatient(individPlanData);
    }

    @Test(description = "Проверка, что есть записи. Проверка данных.", dependsOnMethods = "step3_vaccineFilter", priority = 1)
    public void step4_assertTableData()
    {
        individPlanManager.getVacineJournalPage().assertTableData1(individPlanData);

        individPlanManager.getVacineJournalPage().filterByPatientDate(individPlanData);
        individPlanManager.getVacineJournalPage().assertTableData2(individPlanData);
    }

    @Test(description = "Открытие формы на редактирование", dependsOnMethods = "step4_assertTableData", priority = 1)
    public void step5_openForm()
    {
        individPlanManager.getVacineJournalPage().clickEditButton();
        individPlanManager.getVacineJournalPage().getVaccineModal().fillDoneVaccineModalFromJournal(individPlanData);
        individPlanManager.getVacineJournalPage().getVaccineModal().clickConfirmButtonAndConfirmDialog();
    }

    @Test(description = "Проверка отображаения выполненной прививки на списке журнала", dependsOnMethods = "step5_openForm", priority = 1)
    public void step6_assertTableData() {

        individPlanManager.getVacineJournalPage().assertTableData3(individPlanData);
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика и отмена назначенных прививок", dependsOnMethods = "step6_assertTableData", alwaysRun = true)
    public void step_openVaccineModule()
    {
        individPlanManager.openIndividPlan();
        individPlanManager.getIndividPlanPage().getPatient().setValue(individPlanData.getPatient());
        individPlanManager.getIndividPlanPage().getCalendar().setValue(individPlanData.getCalendar());
        individPlanManager.getIndividPlanPage().clickFormButton();
        individPlanManager.getIndividPlanPage().clickRollbackButton();
        individPlanManager.getIndividPlanPage().getRollbackModal().fillRollbackForm(individPlanData);
        individPlanManager.getIndividPlanPage().getRollbackModal().clickConfirmButton();
    }

    @Test(description = "Удаление выполненной прививки", dependsOnMethods = "step6_assertTableData", priority = 2, alwaysRun = true)
    public void step_deleteDoneVaccine()
    {
        individPlanManager.getIndividPlanPage().setFocusDoneVaccineSlot();
        individPlanManager.getIndividPlanPage().clickDeleteButton();
    }

    @Test(description = "Выход из n2o", dependsOnMethods = "step_deleteDoneVaccine", alwaysRun = true)
    public void afterTest_logout() {
        page.getHeader().logOut();
    }

    @Test(description = "Удаление тестовых данных и выход из n2o", dependsOnMethods = "afterTest_logout", alwaysRun = true)
    public void afterTest_generation() {
        app.executeLiquibase("changelog/vaccination/201606071719_delete_VaccineJournalTest.xml");
    }
}

