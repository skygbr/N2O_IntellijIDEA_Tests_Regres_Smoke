package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.nurseDepart.NurceDepartValues;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class NurseDepartTest extends TestBase {

    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private HospitalData hospitalData1;
    private HospitalData hospitalData2;


    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();

        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setAdmissionDepartment("Приемное отделение");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setProfile("Хирургия");
        hospitalData.setCareRegimen("Стационар круглосуточный");
        hospitalData.setDiagnosis("Холера");
        hospitalData.setBedProfile("хирургические для взрослых");
        hospitalData.setOutcomeDate(page.getCurrentDateTime());
        hospitalData.setStepResult("Переведён на другой профиль коек");
        hospitalData.setNextDepartment("Отделение экстренной госпитализации");
        hospitalData.setNextCareRegiment("Стационар круглосуточный");
        hospitalData.setNextFinancialType("Бюджет федеральный");
        hospitalData.setNextProfile("Абдоминальная хирургия");
        hospitalData.setAdmissionDate(page.getCurrentDateTime());
        hospitalData.setUid("191");
        hospitalData.setBeginDateBed(page.addMinutes(page.getCurrentDateTime(), 5));

        List<String> diagnosisTree = new ArrayList<>();
        diagnosisTree.add("D50-D89 БОЛЕЗНИ КРОВИ, КРОВЕТВОРНЫХ ОРГАНОВ И ОТДЕЛЬНЫЕ НАРУШЕНИЯ, ВОВЛЕКАЮЩИЕ ИММУННЫЙ МЕХАНИЗМ");
        diagnosisTree.add("D50-D53 АНЕМИИ, СВЯЗАННЫЕ С ПИТАНИЕМ");
        diagnosisTree.add("D50 Железодефицитная анемия");
        diagnosisTree.add("D50.1 Сидеропеническая дисфагия");
        hospitalData.setDiagnosisTree(diagnosisTree);
        hospitalData.setDiagnosisCode("D50.1");

        hospitalData1 = hospitalData.clone();
        hospitalData1.setDoctor("Нуждина Е. А., Врач стационара");
        hospitalData1.setFinancialType("Средства граждан");
        hospitalData1.setAdmissionDepartment("Отделение экстренной госпитализации");
        hospitalData1.setOutcome("Улучшение");
        hospitalData1.setNextBedProfile("абдоминальной хирургии");
        hospitalData1.setComplexityLevel("1");
        hospitalData1.setDeviationReason("Отклонение");
        hospitalData1.setBeginDateBed(page.addMinutes(page.getCurrentDateTime(), 20));

        hospitalData2 = hospitalData1.clone();
        hospitalData2.setFinancialType("Бюджет федеральный");
        hospitalData2.setCareRegimen("Стационар круглосуточный");
        hospitalData2.setProfile("Абдоминальная хирургия");
        hospitalData2.setBedProfile("абдоминальной хирургии");
        hospitalData2.setDiagnosisTree(diagnosisTree);

        hospitalData2.setDoctor("");
    }

    @Test(description = "Подготовка тестовых данных: удаление коек и движений по отделениям пациента, если такие существуют")
    public void beforeTest()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openNurseDepartment();
        hospitalManager.getNurseDepartPage().filterByPatient(hospitalData);
        hospitalManager.getNurseDepartPage().deleteAllSendToDepartment();
        hospitalManager.getNurseDepartPage().deleteAllBeds();
    }

    @Test(description = "Открытие страницы Медсестра стационара", dependsOnMethods = "beforeTest")
    public void step1_openPage()
    {
        hospitalManager.openNurseDepartment();
    }

    @Test(description = "Проверка пациента в модуле Медсестра стационара", dependsOnMethods = "step1_openPage")
    public void step2_assertPatientInNursePage()
    {
        hospitalManager.getNurseDepartPage().filterByPatient(hospitalData);
        hospitalManager.getNurseDepartPage().getContainerPatientList().getTable().assertThatTableContainsOnlyXRows(1);
        assertThat(String.format("Can't find patient %s in department", hospitalData.getPatient()),
                hospitalManager.getNurseDepartPage().getContainerPatientList().getTable().getRowColumnIntersectionValue(0, Values.PATIENT_FIELD, true),
                is(hospitalData.getPatient()));
    }

    @Test(description = "Добавление койки", dependsOnMethods = "step2_assertPatientInNursePage", priority = 1)
    public void step3_openAddBedModal()
    {
        hospitalManager.getNurseDepartPage().clickCreateBed();
    }

    @Test(description = "Добавление занятой койки", dependsOnMethods = "step3_openAddBedModal", priority = 1)
    public void step4_assertAddBusyBed()
    {
        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().assertAddBusyBed();
    }

    @Test(description = "Добавление свободной койки", dependsOnMethods = "step3_openAddBedModal", priority = 2)
    public void step5_addFreeBed()
    {

        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().addFreeBed();
        hospitalManager.getNurseDepartPage().getContainerBedList().getTable().assertThatTableContainsOnlyXRows(1);
        hospitalData.setBed(hospitalManager.getNurseDepartPage().getContainerBedList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.ROOM, true));
        assertThat("End date room doesn't equal empty",
                hospitalManager.getNurseDepartPage().getContainerBedList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.DATE_END, true), is(""));
    }

    @Test(description = "Редактирование свободной койки", dependsOnMethods = "step5_addFreeBed")
    public void step6_editBed()
    {
        hospitalManager.getNurseDepartPage().getContainerBedList().getTable().chooseRowInTable(0);
        hospitalManager.getNurseDepartPage().clickUpdateBed();
        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().setBeginDate(hospitalData);
        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().addFreeBed();
        hospitalManager.getNurseDepartPage().getContainerBedList().getTable().assertThatTableContainsOnlyXRows(1);
        assertThat("Bed after edit doesn't change",
                hospitalManager.getNurseDepartPage().getContainerBedList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.DATE_END, true), not(hospitalData.getBed()));
    }

    @Test(description = "Добавление еще одной койки", dependsOnMethods = "step5_addFreeBed")
    public void step7_addSecondBed()
    {
        hospitalManager.getNurseDepartPage().closeAllModalsOnPage();
        hospitalManager.getNurseDepartPage().getContainerBedList().getTable().chooseRowInTable(0);
        hospitalManager.getNurseDepartPage().clickCreateBed();
        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().setBeginDate(hospitalData1);
        hospitalManager.getNurseDepartPage().getCreateBedResourceModal().addFreeBed();
        hospitalManager.getNurseDepartPage().getContainerBedList().getTable().assertThatTableContainsOnlyXRows(2);
        assertThat("End date first bed doesn't equal begin date second bed",
                hospitalManager.getNurseDepartPage().getContainerBedList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.DATE_END, true),
                is(hospitalManager.getNurseDepartPage().getContainerBedList().getTable().getRowColumnIntersectionValue(1, NurceDepartValues.DATE_BEGIN, true)));
    }

    @Test(description = "Проверка существования записи движения по отделениям", dependsOnMethods = "step5_addFreeBed")
    public void step8_assertSendToDepartmentInNursePage()
    {
        hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Создание новой записи движения по отделениям", dependsOnMethods = "step5_addFreeBed")
    public void step9_createSendToDepartmentInNursePage()
    {
        hospitalData1.setAdmissionDate(hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.DATE_IN, true));
        hospitalData1.setOutcomeDate(page.addMinutes(page.getCurrentDateTime(), 20));

        hospitalManager.getNurseDepartPage().createHospitalRecord(hospitalData1);
        hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().assertThatTableContainsOnlyXRows(2);
        assertThat("Date out in first hospital record doesn't equal date in second hospital record",
                hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().getRowColumnIntersectionValue(0, NurceDepartValues.DATE_OUT, true),
                is(hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().getRowColumnIntersectionValue(1, NurceDepartValues.DATE_IN, true)));
    }

    @Test(description = "Редактирование записи движения по отделениям", dependsOnMethods = "step9_createSendToDepartmentInNursePage")
    public void step10_editSendToDepartmentInNursePage()
    {
        hospitalData2.setAdmissionDate(hospitalData1.getOutcomeDate());
        hospitalManager.getNurseDepartPage().getContainerHospitalRecordList().getTable().chooseRowInTable(1);
        hospitalManager.getNurseDepartPage().editHospitalRecord(hospitalData2);
    }
}
