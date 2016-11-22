package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.TreatmentPlanData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MedicalHistory_TreatmentPlanTest extends TestBase {
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;

    private TreatmentPlanData treatmentPlanData;
    private TreatmentPlanData treatmentPlanData1;


    @BeforeClass
    public void initialize() {
        hospitalManager = new HospitalManager();

        hospitalData = new HospitalData();
        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setDepartment("Отделение экстренной госпитализации");

        treatmentPlanData = new TreatmentPlanData();
        treatmentPlanData.setSymptomDate(getDateBeforeAfterCurrent(-2));
        treatmentPlanData.setFirstVisitDate(getDateBeforeAfterCurrent(-1));
        treatmentPlanData.setDiagnosis("10.1 Лёгочный туберкулёз");
        treatmentPlanData.setClinicForm(randomChar(3));
        treatmentPlanData.setPatientGroup("11.2 рецидив");
        treatmentPlanData.setCardNum(randomInt(100, 999, 3));
        treatmentPlanData.setCourseNum(randomInt(1000, 9999, 4));
        treatmentPlanData.setCreateDate(getCurrentDate());
        treatmentPlanData.setEndDate(getDateBeforeAfterCurrent(3));
        treatmentPlanData.setDayAmount("4");
        treatmentPlanData.setChemoPhase("интенсивной");
        treatmentPlanData.setChemoRegimen("12.1 режим 1");
        treatmentPlanData.setPatientWeight("60");
        treatmentPlanData.setResult("снят");
        treatmentPlanData.setOutcomeOrg(randomChar(3));
        treatmentPlanData.setResultEndDate(getDateBeforeAfterCurrent(4));

        treatmentPlanData1 = new TreatmentPlanData();
        treatmentPlanData1.setSymptomDate(getDateBeforeAfterCurrent(-3));
        treatmentPlanData1.setFirstVisitDate(getDateBeforeAfterCurrent(-2));
        treatmentPlanData1.setDiagnosis("10.2 Внелёгочный туберкулёз");
        treatmentPlanData1.setOrgans("кожа");
        treatmentPlanData1.setPatientGroup("11.6 прочие");
        treatmentPlanData.setCardNum(randomInt(1000, 9999, 4));
        treatmentPlanData1.setCourseNum(randomInt(100, 999, 3));
        treatmentPlanData1.setCreateDate(getDateBeforeAfterCurrent(-1));
        treatmentPlanData1.setEndDate(getDateBeforeAfterCurrent(4));
        treatmentPlanData1.setDayAmount("6");
        treatmentPlanData1.setChemoPhase("продолжения");
        treatmentPlanData1.setChemoRegimen("12.2 режим 2");
        treatmentPlanData1.setResult("Выбыл");
        treatmentPlanData1.setOutcomeOrg(randomChar(3));
        treatmentPlanData1.setResultEndDate(getDateBeforeAfterCurrent(5));
    }


    @Test(description = "Отркытие страницы Заведующий отделением")
    public void step1_openPage() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openBranchManager();
    }

    @Test(description = "Открытие истории болезни",
            dependsOnMethods = "step1_openPage")
    public void step2_openMedicalHistory() {
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().cancelDischarge();
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertPatientData(hospitalData);
    }

    @Test(description = "Создание плана лечения",
            dependsOnMethods = "step2_openMedicalHistory")
    public void step3_createTreatmentPlan() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createTreatmentPlan(treatmentPlanData);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertCountTreatmentPlans(1);
    }

    @Test(description = "Проверка добавленного плана лечения",
            dependsOnMethods = "step3_createTreatmentPlan")
    public void step4_assertCreatedTreatmentPlan() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerTreatmentPlanList().getTable().chooseRowInTable(0);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertTreatmentPlan(treatmentPlanData);
    }

    @Test(description = "Редактирование  и проверка отредактированного плана лечения",
            dependsOnMethods = "step4_assertCreatedTreatmentPlan")
    public void step5_editTreatmentPlan() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerTreatmentPlanList().getTable().chooseRowInTable(0);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updateTreatmentPlan(treatmentPlanData1);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertCountTreatmentPlans(1);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertTreatmentPlan(treatmentPlanData1);
    }

    @Test(description = "Просмотр плана лечения",
            dependsOnMethods = "step5_editTreatmentPlan")
    public void step6_viewTreatmentPlan() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getContainerTreatmentPlanList().getTable().chooseRowInTable(0);
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().viewTreatmentPlan(treatmentPlanData1);
    }

    @Test(description = "Удаление плана лечения",
            dependsOnMethods = "step6_viewTreatmentPlan")
    public void step7_removeTreatmentPlan() {
        hospitalManager.getBranchManagerPage().closeAllModalsOnPage();
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteAllTreatmentPlans();
    }
}
