package test.businessTests.examination;

import base.components.CommonMethodsHelper;
import businessFramework.entities.examination.CaseForExamData;
import businessFramework.entities.examination.ExamCardData;

import businessFramework.module.examination.ExamManager;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CaseForExaminationFilterTest extends TestBase {
    private CommonMethodsHelper methodsHelper = new CommonMethodsHelper(ApplicationManager.getInstance());

    private ExamManager examManager;
    private CaseForExamData caseForExamData;
    private ExamCardData cardData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        examManager     = new ExamManager();
        caseForExamData = new CaseForExamData();
        cardData        = new ExamCardData();

        caseForExamData.setCaseType("Случай госпитализаци");
        caseForExamData.setOpenDate("01.01.2016");
        caseForExamData.setCloseDate("20.01.2016");
        caseForExamData.setLastStepDepartment("Отделение экстренной госпитализации");
        caseForExamData.setDoctor("Нуждина Е.А.");
        caseForExamData.setPatient("Стационар Автотестов Автотестович");
        caseForExamData.setSocGroup("Работающий");
        caseForExamData.setAgeGroup("Взрослое население");
        caseForExamData.setMainDiagCode("Q92.2");
        caseForExamData.setMainDiagName("Большая частичная трисомия");
        caseForExamData.setOutAndClinicDiagDifferent(true);
        caseForExamData.setAdmissionAndClinicDiagDifferent(true);
        caseForExamData.setPatAndClinicDiagDifferent(true);
        caseForExamData.setResultCode("301");
        caseForExamData.setResult("Лечение завершено");
        caseForExamData.setRepeatCaseDuringLastMonths(2);
        caseForExamData.setDurationIsMoreThanPlanned(80); // чем МЭС
        caseForExamData.setDurationIsLessThanPlanned(82); // чем Стд
        caseForExamData.setUid("2examautotest");
        caseForExamData.setDuration(19);
        caseForExamData.setStdDuration(100);
        caseForExamData.setMesDuration(10);

        cardData.setExpert("Нуждина Е.А.");
        cardData.setLevel("1-я ступень");
    }

    @Test(description = "Выбор контекста")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        methodsHelper.chooseContextByHeadingAndText(page.getHeader(), "Врач стационара", "Отделение экстренной госпитализации");
        examManager.openExaminationModule();
    }

    @Test(description = "Открыть 'Экспертиза качества медицинской помощи' - 'Поиск случаев, подлежащих экспертизе'", dependsOnMethods = "beforeTest")
    public void step01_openFilterForExaminationTab() {
        examManager.openQualityExamination();
        examManager.getQualityExaminationPage().openCasesForExamFilterTab();
    }

    @Test(description = "Проверить фильтр (дефолтные значения и отображение полей)", dependsOnMethods = "step01_openFilterForExaminationTab")
    public void step02_assertFilterFields() {
        examManager.getQualityExaminationPage().assertCasesForExaminationFilter();
    }

    @Test(description = "Найти случай", dependsOnMethods = "step02_assertFilterFields")
    public void step03_findCase() {
        examManager.getQualityExaminationPage().findCase(caseForExamData);
    }

    @Test(description = "Кнопка 'Создать ЭК'", dependsOnMethods = "step03_findCase")
    public void step04_createExamCardButton() {
        examManager.getQualityExaminationPage().createExamCardButtonTest();
    }

    @Test(description = "Кнопка 'Открыть случай' (ИБ)", dependsOnMethods = "step03_findCase")
    public void step05_openCaseButtonTest() {
        examManager.getQualityExaminationPage().openCaseButtonTest();
    }

    @Test(description = "Кнопка 'Без замечаний'", dependsOnMethods = "step05_openCaseButtonTest")
    public void step06_noRemarksButtonTest() {
        examManager.getQualityExaminationPage().noRemarksBtnTest(caseForExamData, cardData);
    }

    @Test(description = "Список карт по случаю. Кнопки Изменить, Удалить", dependsOnMethods = "step06_noRemarksButtonTest", alwaysRun = true)
    public void step07_cardsForCaseList_ButtonsTests() {
        page.closeAllModalsOnPage();
        examManager.getQualityExaminationPage().updateAndDeleteButtonsTest_cardsForCaseList(caseForExamData);
    }
}
