package test.businessTests.hospital;

import businessFramework.entities.hospital.DiagnosisData;
import businessFramework.entities.hospital.DischargeData;
import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.DateUtil;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MedicalHistoryTest extends TestBase
{
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;

    private DischargeData dischargeData;
    private DischargeData dischargeData2;

    private DiagnosisData diagnosisData1;
    private DiagnosisData diagnosisData2;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();

        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setDoctor("Нуждина Е. А., Врач стационара");
        hospitalData.setDiagnosis("");
        hospitalData.setStageDiagnosis("Клинический");
        hospitalData.setAdmissionDepartment("Отделение экстренной госпитализации");
        hospitalData.setUid("191");

        diagnosisData1 = new DiagnosisData();
        diagnosisData1.setStageDiagnosis("Клинический");
        List<String> diagnosisTree1 = new ArrayList<>();
        diagnosisTree1.add("D50-D89 БОЛЕЗНИ КРОВИ, КРОВЕТВОРНЫХ ОРГАНОВ И ОТДЕЛЬНЫЕ НАРУШЕНИЯ, ВОВЛЕКАЮЩИЕ ИММУННЫЙ МЕХАНИЗМ");
        diagnosisTree1.add("D50-D53 АНЕМИИ, СВЯЗАННЫЕ С ПИТАНИЕМ");
        diagnosisTree1.add("D50 Железодефицитная анемия");
        diagnosisTree1.add("D50.0 Железодефицитная анемия вторичная вследствие потери крови хроническая");
        diagnosisData1.setDiagnosisTree(diagnosisTree1);
        diagnosisData1.setDiagnosisCode("D50.0");
        diagnosisData1.setDiagnosisCodeList("D50.0 Железодефицитная анемия вторичная вследствие потери крови хроническая");

        diagnosisData2 = new DiagnosisData();
        diagnosisData2.setStageDiagnosis("Патологоанатомический");
        List<String> diagnosisTree2 = new ArrayList<>();
        diagnosisTree2.add("D50-D89 БОЛЕЗНИ КРОВИ, КРОВЕТВОРНЫХ ОРГАНОВ И ОТДЕЛЬНЫЕ НАРУШЕНИЯ, ВОВЛЕКАЮЩИЕ ИММУННЫЙ МЕХАНИЗМ");
        diagnosisTree2.add("D50-D53 АНЕМИИ, СВЯЗАННЫЕ С ПИТАНИЕМ");
        diagnosisTree2.add("D50 Железодефицитная анемия");
        diagnosisTree2.add("D50.1 Сидеропеническая дисфагия");
        diagnosisData2.setDiagnosisTree(diagnosisTree2);
        diagnosisData2.setDiagnosisCode("D50.1");
        diagnosisData2.setDiagnosisCodeList("D50.1 Сидеропеническая дисфагия");

        dischargeData = new DischargeData();
        dischargeData.setStepResult("107 Лечение прервано по инициативе пациента");
        dischargeData.setOutcome("104 Ухудшение");
        dischargeData.setCareLevel("1 Первичная медико-санитарная помощь");
        dischargeData.setRankIn("Нет симптомов");
        dischargeData.setBedProfile("хирургические для взрослых");
        List<String> finalDiagnosisTree = new ArrayList<>();
        finalDiagnosisTree.add("D50-D89 БОЛЕЗНИ КРОВИ, КРОВЕТВОРНЫХ ОРГАНОВ И ОТДЕЛЬНЫЕ НАРУШЕНИЯ, ВОВЛЕКАЮЩИЕ ИММУННЫЙ МЕХАНИЗМ");
        finalDiagnosisTree.add("D50-D53 АНЕМИИ, СВЯЗАННЫЕ С ПИТАНИЕМ");
        finalDiagnosisTree.add("D52 Фолиеводефицитная анемия");
        finalDiagnosisTree.add("D52.0 Фолиеводефицитная анемия, связанная с питанием");
        dischargeData.setFinalDiagnosisTree(finalDiagnosisTree);
        dischargeData.setFinalDiagnosisCode("D52.0");

        dischargeData.setCoefCur0("Осложнение заболеваний");
        dischargeData.setCoefCurVal0("1");
        dischargeData.setCoefCur1("Развертывание индивидуального поста");
        dischargeData.setCoefCurVal1("2");

        dischargeData2 = new DischargeData();
        dischargeData2.setStepResult("307 Умер");
        dischargeData2.setOutcome("202 Улучшение");
        dischargeData2.setCareLevel("2 Скорая, в том числе специализированная, медицинская помощь");
        List<String> finalDiagnosisTree2 = new ArrayList<>();
        finalDiagnosisTree2.add("D50-D89 БОЛЕЗНИ КРОВИ, КРОВЕТВОРНЫХ ОРГАНОВ И ОТДЕЛЬНЫЕ НАРУШЕНИЯ, ВОВЛЕКАЮЩИЕ ИММУННЫЙ МЕХАНИЗМ");
        finalDiagnosisTree2.add("D50-D53 АНЕМИИ, СВЯЗАННЫЕ С ПИТАНИЕМ");
        finalDiagnosisTree2.add("D53 Другие анемии, связанные с питанием");
        finalDiagnosisTree2.add("D53.0 Анемия вследствие недостаточности белков");
        dischargeData2.setFinalDiagnosisTree(finalDiagnosisTree2);
        dischargeData2.setFinalDiagnosisCode("D53.0");

        dischargeData2.setDeathDate(getDateBeforeAfterCurrent(-1) + " 10:10");
        dischargeData2.setDeathEmployee("Нуждина Елена Александровна");
    }

    @Test(description = "Подготовка тестовых данных: удаление диагнозов пациента, если такие существуют")
    public void beforeTest() throws AWTException {
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        /**Настройки проверки(удаление лишних) данных Движения по отделениям и Движения по койкам*/
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openNurseDepartment();
        hospitalManager.getNurseDepartPage().filterByPatient(hospitalData);
        hospitalManager.getNurseDepartPage().deleteAllSendToDepartment();
        hospitalManager.getNurseDepartPage().deleteAllBeds();

        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().cancelDischarge();
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteAllDiagnosis();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().closePage();
        hospitalManager.sendKeyCtrl();
    }

    @Test(description = "Отркытие страницы Заведующий отделением", dependsOnMethods = "beforeTest")
    public void step1_openPage()
    {
        hospitalManager.openBranchManager();
    }

    @Test(description = "Открытие истории болезни", dependsOnMethods = "step1_openPage")
    public void step2_openMedicalHistory()
    {
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().assertMedicalHistory(hospitalData);
    }

    @Test(description = "Создание диагноза", dependsOnMethods = "step2_openMedicalHistory")
    public void step3_createDiagnosis()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createDiagnosis(diagnosisData1);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertCountDiagnosis(1);
    }

    @Test(description = "Редактирование диагноза", dependsOnMethods = "step3_createDiagnosis")
    public void step4_editDiagnosis()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerDiagnosisList().getTable().chooseRowInTable(0);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updateDiagnosis(diagnosisData2);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertCountDiagnosis(1);
    }

    @Test(description = "Выписать", dependsOnMethods = "step4_editDiagnosis")
    public void step5_discharge()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().discharge(dischargeData);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getCancelDischargeButton().assertIsDisplayed(true);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getEditDischargeButton().assertIsDisplayed(true);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getDischargeButton().assertIsDisplayed(false);

        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getOutcomeDate().assertFieldText(DateUtil.getDateWithoutTime(dischargeData.getOutcomeDate()));
    }

    @Test(description = "Редактировть выписку", dependsOnMethods = "step5_discharge")
    public void step6_editDischarge()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().editDischarge(dischargeData, dischargeData2);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getCancelDischargeButton().assertIsDisplayed(true);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getEditDischargeButton().assertIsDisplayed(true);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getDischargeButton().assertIsDisplayed(false);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getOutcomeDate().assertFieldText(DateUtil.getDateWithoutTime(dischargeData.getOutcomeDate()));
    }

    @Test(description = "Проверка валидации на изменение закрытой ИБ ", dependsOnMethods = "step6_editDischarge", enabled = false)
    public void step7_assertValidationOnUpdateClosedHistory()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertValidationOnUpdateClosedCase_diagnosis();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertValidationOnUpdateClosedCase_department(dischargeData.getFinalDiagnosisTree());
    }

    @Test(description = "Отмена выписки и проверка подтверждения очищения данных о смерти",
            dependsOnMethods = "step5_discharge", priority = 1, alwaysRun = true)
    public void step8_cancelDischarge()
    {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().closeAllModalsOnPage();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerHospitalRecords().clickContainer();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().cancelDischargeWithClearDeathDataAssertion();

        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getCancelDischargeButton().assertIsDisplayed(false);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getEditDischargeButton().assertIsDisplayed(false);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getDischargeButton().assertIsDisplayed(true);
    }
}
