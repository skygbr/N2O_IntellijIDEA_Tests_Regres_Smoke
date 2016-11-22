package test.businessTests.hospital;


import businessFramework.entities.hospital.DiagnosisData;
import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest extends TestBase {
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private HospitalData hospitalData1;

    private DiagnosisData diagnosisData1;
    private DiagnosisData diagnosisData2;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalData = new HospitalData();
        hospitalManager = new HospitalManager();
        hospitalData.setPatient("Статистик Ярослав Андреевич");
        hospitalData.setAdmissionDepartment("Приемное отделение статистики");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setCareProvidingForm("Неотложная");
        hospitalData.setInitGoal("Реабилитация");
        hospitalData.setTransportingType("Передвигается самостоятельно");
        hospitalData.setCareLevel("Высокотехнологичная медицинская помощь");
        hospitalData.setUid(randomInt(1));

        hospitalData.setStepDepartment("Отделение гастроэнтерологии");
        hospitalData.setProfile("Гастроэнтерология");
        hospitalData.setCareRegimen("Стационар круглосуточный");
        hospitalData.setStepResult("Лечение прервано по инициативе пациента");
        hospitalData.setBedProfile("гастроэнтерологические для взрослых");

        hospitalData.setService("Операция на удаление вируса");
        hospitalData.setDoctor("Фадеева Е. Ю., Врач-вирусолог");

        hospitalData.setStageDiagnosis("Заключительный");
        hospitalData.setDiagnosis("G00.3 Стафилококковый менингит");
        hospitalData.setOutcome("Улучшение");
        hospitalData.setCaseType("");


        hospitalData1 = hospitalData.clone();
        hospitalData1.setFinancialType("Средства граждан");
        hospitalData1.setCareProvidingForm("Плановая");
        hospitalData1.setInitGoal("Профилактика");
        hospitalData1.setTransportingType("На носилках");
        hospitalData1.setCareLevel("Скорая, в том числе специализированная, медицинская помощь");
        hospitalData1.setUid(randomInt(1));

        hospitalData1.setStepDepartment("Отделение вирусологии");
        hospitalData1.setProfile("Аллергология и иммунология");
        hospitalData1.setCareRegimen("Стационар дневной в больничном учреждении");
        hospitalData1.setStepResult("Переведён в др. ЛПУ");
        hospitalData1.setBedProfile("аллергологические для взрослых");

        hospitalData1.setService("Операция на легкие");
        hospitalData1.setDoctor("Федорин И. П., Врач-гастроэнтеролог");

        hospitalData1.setStageDiagnosis("Направительный");
        hospitalData1.setDiagnosis("A03.8 Другой шигеллез");
        hospitalData1.setOutcome("Улучшение");

        diagnosisData1 = new DiagnosisData();
        diagnosisData1.setStageDiagnosis("Заключительный");
        diagnosisData1.setDiagnosis("G00.3 Стафилококковый менингит");
        List<String> diagnosisTree1 = new ArrayList<>();
        diagnosisTree1.add("G00-G99 БОЛЕЗНИ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree1.add("G00-G09 ВОСПАЛИТЕЛЬНЫЕ БОЛЕЗНИ ЦЕНТРАЛЬНОЙ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree1.add("G00 Бактериальный менингит, не классифицированный в других рубриках");
        diagnosisTree1.add("G00.3 Стафилококковый менингит");
        diagnosisData1.setDiagnosisTree(diagnosisTree1);
        diagnosisData1.setDiagnosisCode("G00.3");

        diagnosisData2 = new DiagnosisData();
        diagnosisData2.setStageDiagnosis("Направительный");
        diagnosisData2.setDiagnosis("F17.0 Психические и поведенческие расстройства, вызванные употреблением табака - острая интоксикация");
        List<String> diagnosisTree2 = new ArrayList<>();
        diagnosisTree2.add("G00-G99 БОЛЕЗНИ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree2.add("G00-G09 ВОСПАЛИТЕЛЬНЫЕ БОЛЕЗНИ ЦЕНТРАЛЬНОЙ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree2.add("G03 Менингит, обусловленный другими и неуточненными причинами");
        diagnosisTree2.add("G03.1 Хронический менингит");
        diagnosisData2.setDiagnosisTree(diagnosisTree2);
        diagnosisData2.setDiagnosisCode("G03.1");

    }

    @Test(description = "Удаление случая")
    public void beforeTest() {
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext("Приемное отделение статистики");
        hospitalManager.openStatistic();
        hospitalManager.getStatisticsPage().deleteHospitalCase(hospitalData1);
    }

    @Test(description = "Создание случая госпитализации", dependsOnMethods = "beforeTest")
    public void step1_createStatisticCard() {
        hospitalManager.openStatistic();
        hospitalManager.getStatisticsPage().createHospitalCard(hospitalData);
    }

    @Test(description = "Проверка формы создания статистической карты", dependsOnMethods = "step1_createStatisticCard")
    public void step2_assertEditStatisticCard() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().assertForm(hospitalData);
    }

    @Test(description = "Редактирование статистической карты", dependsOnMethods = "step1_createStatisticCard")
    public void step3_editStatisticCard() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().closePage();
        hospitalManager.getStatisticsPage().filterHospitalCase(hospitalData);
        hospitalManager.getStatisticsPage().getContainerStatisticalMapList().getTable().assertThatTableContainsOnlyXRows(1);
        hospitalManager.getStatisticsPage().editHospitalCard(hospitalData1);
    }

    @Test(description = "Проверка формы после редактирования", dependsOnMethods = "step3_editStatisticCard")
    public void step4_assertEditStatisticCard() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().assertForm(hospitalData1);
    }

    @Test(description = "Движение по отделениям", dependsOnMethods = "step4_assertEditStatisticCard")
    public void step5_createSendToDepartment() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDepartmentOperations().clickContainer();
        hospitalData.setOutcomeDate(page.addMinutes(page.getCurrentDateTime(), 15));
        hospitalManager.getStatisticsPage().getStatisticCardPage().createSendToDepartment(hospitalData);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerHospitalRecordList().getTable().assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Проверка формы после создания", dependsOnMethods = "step5_createSendToDepartment")
    public void step6_assertFormAfterCreate() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerHospitalRecordList().getTable().chooseRowInTable(0);
        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateSendToDepartmentButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getMovingToDepartmentModal().assertStatisticSendToDepartment(hospitalData);
    }

    @Test(description = "Редактирование движения по отделениям", dependsOnMethods = "step5_createSendToDepartment")
    public void step7_editSendToDepartment() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().closeAllModalsOnPage();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerHospitalRecordList().getTable().chooseRowInTable(0);
        hospitalData1.setOutcomeDate(hospitalData.getOutcomeDate());
        hospitalManager.getStatisticsPage().getStatisticCardPage().editSendToDepartment(hospitalData1);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerHospitalRecordList().getTable().assertThatTableContainsOnlyXRows(1);

        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateSendToDepartmentButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getMovingToDepartmentModal().assertStatisticSendToDepartment(hospitalData1);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getModal().closeModal();
    }

    @Test(description = "Создание услуги", dependsOnMethods = "step5_createSendToDepartment")
    public void step8_createService() {
        hospitalData.setBdateService(page.getCurrentDate());
        hospitalManager.getStatisticsPage().getStatisticCardPage().createService(hospitalData);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerServiceRenderedList().getTable().assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Проверка формы улсуги после ее создания", dependsOnMethods = "step8_createService", priority = 1)
    public void step9_assertServiceFormAfterCreate() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerServiceRenderedList().getTable().chooseRowInTable(0);
        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateServiceButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getServiceModal().assertServiceForm(hospitalData);
    }

    @Test(description = "Редактировнаие услуги", dependsOnMethods = "step8_createService", priority = 2)
    public void step10_editService() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().closeAllModalsOnPage();
        hospitalData1.setBdateService(hospitalData.getBdateService());
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerServiceRenderedList().getTable().chooseRowInTable(0);
        hospitalManager.getStatisticsPage().getStatisticCardPage().editService(hospitalData1);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerServiceRenderedList().getTable().assertThatTableContainsOnlyXRows(1);

        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerServiceRenderedList().getTable().chooseRowInTable(0);
        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateServiceButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getServiceModal().assertServiceForm(hospitalData1);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getModal().closeModal();
    }

    @Test(description = "Создание диагноза", dependsOnMethods = "step8_createService", priority = 3)
    public void step11_createDiagnosis() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().createDiagnosis(diagnosisData1);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDiagnosisList().getTable().assertThatTableContainsOnlyXRows(3);
    }

    @Test(description = "Проверка формы диагноза после создания", dependsOnMethods = "step11_createDiagnosis")
    public void step12_assertDiagnosisAfterCreate() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDiagnosisList().getTable().chooseRowInTable(2);
        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateDiagnosisButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getDiagnosisModal().assertForm(diagnosisData1);
    }

    @Test(description = "Редактирование диагноза", dependsOnMethods = "step11_createDiagnosis")
    public void step13_editDiagnosis() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().closeAllModalsOnPage();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDiagnosisList().getTable().chooseRowInTable(2);
        hospitalManager.getStatisticsPage().getStatisticCardPage().editDiagnosis(diagnosisData2);
        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDiagnosisList().getTable().assertThatTableContainsOnlyXRows(3);

        hospitalManager.getStatisticsPage().getStatisticCardPage().getContainerDiagnosisList().getTable().chooseRowInTable(2);
        hospitalManager.getStatisticsPage().getStatisticCardPage().clickUpdateDiagnosisButton();
        hospitalManager.getStatisticsPage().getStatisticCardPage().getDiagnosisModal().assertForm(diagnosisData2);
    }

    @Test(description = "Проверка данных на главной странице", dependsOnMethods = "step13_editDiagnosis")
    public void step14_assertMainStatisticPage() {
        hospitalManager.getStatisticsPage().getStatisticCardPage().closeAllModalsOnPage();
        hospitalManager.getStatisticsPage().getStatisticCardPage().closePage();
        hospitalManager.getStatisticsPage().getContainerHospitalRecords().getTable().assertThatTableContainsOnlyXRows(1);
        hospitalManager.getStatisticsPage().getContainerServices().getTable().assertThatTableContainsOnlyXRows(1);
    }
}
