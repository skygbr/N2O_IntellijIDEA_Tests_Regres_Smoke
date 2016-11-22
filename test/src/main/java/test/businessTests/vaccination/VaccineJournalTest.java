package test.businessTests.vaccination;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.IndividPlanManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VaccineJournalTest extends TestBase implements Values {

    private IndividPlanManager individPlanManager;
    private IndividPlanData individPlanData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        individPlanManager = new IndividPlanManager();
        individPlanData = new IndividPlanData();

        individPlanData.setPatient("Вакцина Вакцина Вакцина");
        individPlanData.setCalendar("Национальный календарь прививок 2014");
        individPlanData.setClinic("МО Вакцинопрофилактика автотест");
        individPlanData.setResourse("Кириллов");
        individPlanData.setVaccine("H-B-ВАКС II");
        individPlanData.setPhase("V1");
        individPlanData.setSeries("Серия автотест");
        individPlanData.setBirthDate("01.01.2000");
        individPlanData.setInfection("Вирусный гепатит В");
        individPlanData.setVacDepartment("Вакцинопрофилактика");
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Назначение прививок пациенту по календарю", priority = 1)
    public void step1_vaccineModule()
    {
        individPlanManager.openIndividPlan();
        page.getHeader().chooseContext(individPlanData.getVacDepartment());

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
        individPlanManager.getVacineJournalPage().getVaccineModal().clickConfirmButton();
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
}

