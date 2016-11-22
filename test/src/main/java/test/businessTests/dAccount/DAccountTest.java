package test.businessTests.dAccount;

import businessFramework.entities.dAccount.DAccountDGroupData;
import businessFramework.entities.dAccount.DAccountData;
import businessFramework.entities.dAccount.DAccountFrcData;
import businessFramework.entities.dAccount.DAccountFrcInvolExamData;
import businessFramework.entities.dAccount.DAccountHospitalData;
import businessFramework.entities.dAccount.DAccountRemissionData;
import businessFramework.entities.dAccount.TakeOffPatientData;
import businessFramework.module.dAccount.DAccountManager;
import businessFramework.module.dAccount.modals.dAccount.DAccountDGroupModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountEditModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountFrcInvolExamModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountFrcModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountFrcRecordModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountHospitalModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountModal;
import businessFramework.module.dAccount.modals.dAccount.DAccountRemissionModal;
import businessFramework.module.dAccount.modals.dAccount.RemoveDAccountModal;
import businessFramework.module.dAccount.modals.dAccount.TakeOffPatientModal;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 02.02.2016.
 */
public class DAccountTest extends TestBase {
    private DAccountManager dAccountManager;
    private DAccountData dAccountData;
    private DAccountData dAccountDataEdit;
    private TakeOffPatientData takeOffPatientData;
    private TakeOffPatientData takeOffPatientDataEdit;
    private String removeDAccountReason;
    private String removeDAccountReasonDesc;
    private DAccountDGroupData dGroupData;
    private DAccountDGroupData dGroupDataEdit;
    private DAccountRemissionData remissionData;
    private DAccountRemissionData remissionDataEdit;
    private DAccountHospitalData hospitalData;
    private DAccountHospitalData hospitalDataEdit;
    private DAccountFrcData frcData;
    private DAccountFrcData frcDataEdit;
    private DAccountFrcInvolExamData involExamData;
    private DAccountFrcInvolExamData involExamDataEdit;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        removeDAccountReason = "Другое (указать причину)";
        removeDAccountReasonDesc = "Описание причины удаления";

        dAccountManager = new DAccountManager();
        dAccountData = new DAccountData();

        dAccountData.setDepartmentForContext("Подразделение для автотестов Регистра и Фтизиатрии");
        dAccountData.setRegisterForContext("Регистр для автотестов");

        dAccountData.setRegDate(page.addDays(page.getCurrentDate(), -10));
        dAccountData.setPatient("Стационар Станислав Александрович");
        dAccountData.setClinicDistrict("Участок для автотестов");
        dAccountData.setAcStage("Впервые в жизни");
        dAccountData.setCondition("Добровольно");
        dAccountData.setPatState("Дееспособен");
        dAccountData.setHiv("Положительный");
        dAccountData.setHivDate(page.addDays(page.getCurrentDate(), -11));
        dAccountData.setGroup("0-А");
        dAccountData.setAmb("Обязательное лечение");
        dAccountData.setStage("Клинический");
        dAccountData.setDisease("Диагноз установлен в предыдущем году или ранее (-)");
        List<String> diagnosis = new ArrayList<>();
//        diagnosis.add("A00-B99 НЕКОТОРЫЕ ИНФЕКЦИОННЫЕ И ПАРАЗИТАРНЫЕ БОЛЕЗНИ");
//        diagnosis.add("A15-A19 ТУБЕРКУЛЕЗ");
//        diagnosis.add("A17.1 Менингеальная туберкулема G07*");
        diagnosis.add("A17 Туберкулез нервной системы");
        diagnosis.add("A17.0 Туберкулезный менингит G01*");
        dAccountData.setDiagnos(diagnosis);
        dAccountData.setClinicalForm("4. Туберкулома легких");
        dAccountData.setLocalization("10. Туберкулез прочих органов");
        dAccountData.setComplication("10. Туберкулез бронха");
        dAccountData.setFullDiagnosis("A17.0 1.1.1.1.1.1 Туберкулезный менингит G01*, туберкулез мозговых оболочек; без распада; поражен один орган; операция не проводилась; неосложненное течение; МБТ+ подтверждено бактериоскопически, с наличием или отсутствием роста культуры");

        dAccountDataEdit = dAccountData.clone();
        dAccountDataEdit.setRegDate(page.addDays(page.getCurrentDate(), -3));
        dAccountDataEdit.setAcStage("Повторно, ранее состоял на учете");
        dAccountDataEdit.setCondition("Принудительно");
        dAccountDataEdit.setPatState("Недееспособен");
        dAccountDataEdit.setHiv("Отрицательный");

        dGroupData = new DAccountDGroupData();
        dGroupData.setAmb("Активное диспансерное наблюдение");
        dGroupData.setFromDt(page.addDays(page.getCurrentDate(), -5));
        dGroupData.setGroup("0-А");
        dGroupDataEdit = dGroupData.clone();
        dGroupDataEdit.setFromDt(page.addDays(page.getCurrentDate(), -8));
        dGroupDataEdit.setGroup("2 А");
        dGroupDataEdit.setAmb("Консультативно-лечебная помощь");
        dGroupDataEdit.setReason("Выздоровление");

        remissionData = new DAccountRemissionData();
        remissionData.setBeginDt(page.addDays(page.getCurrentDate(), -5));
        remissionData.setEndDt(page.addDays(page.getCurrentDate(), -3));
        remissionData.setInfo("Динамика отрицательная");
        remissionDataEdit = remissionData.clone();
        remissionDataEdit.setEndDt(page.addDays(page.getCurrentDate(), -1));
        remissionDataEdit.setInfo("Динамика положительная");

        hospitalData = new DAccountHospitalData();
        hospitalData.setAdmission_dt(page.addDays(page.getCurrentDate(), 1));
        hospitalData.setOutcome_date(page.addDays(page.getCurrentDate(), 10));
        hospitalData.setDiagName("A00.9 Холера неуточненная");
        hospitalData.setGoalName("Военная");
        hospitalDataEdit = hospitalData.clone();
        hospitalDataEdit.setDiagName("A01.0 Брюшной тиф");
        hospitalDataEdit.setGoalName("Лечение");

        takeOffPatientData = new TakeOffPatientData();
        takeOffPatientData.setUnregDate(page.addDays(page.getCurrentDate(), 15));
        takeOffPatientData.setReason("Выздоровление");
        takeOffPatientDataEdit = takeOffPatientData.clone();
        takeOffPatientDataEdit.setUnregDate(page.addDays(page.getCurrentDate(), 16));

        frcData = new DAccountFrcData();
        frcData.setFrcKind("Амбулаторное");
        frcData.setOrderNumber("123");
        frcData.setOrderDt(page.addDays(page.getCurrentDate(), 1));
        frcData.setCloseDt(page.addDays(page.getCurrentDate(), 21));
        frcDataEdit = frcData.clone();
        frcDataEdit.setOrderDt(page.addDays(page.getCurrentDate(), 2));
        frcDataEdit.setCloseDt(page.addDays(page.getCurrentDate(), 22));

        involExamData = new DAccountFrcInvolExamData();
        involExamData.setExamDt(page.addDays(page.getCurrentDate(), 12));
        involExamData.setResult("Результат");
        involExamDataEdit = involExamData.clone();
        involExamDataEdit.setExamDt(page.addDays(page.getCurrentDate(), 15));
        involExamDataEdit.setResult("результат1");
    }

    @Test(description = "Открытие модуля 'Регистр'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(dAccountData.getDepartmentForContext());
        dAccountManager.openRegisterPage();
    }

    @Test(description = "Проверка фильтра Регистр", dependsOnMethods = "beforeTest")
    public void step1_selectRegister() {
        dAccountManager.getRegisterPage().setRegisterFilter(dAccountData.getRegisterForContext());
        dAccountManager.openTreatmentPlanPage();
        assert dAccountManager.getTreatmentPlanPage().checkRegisterFilter(dAccountData.getRegisterForContext());
        dAccountManager.openRegisterPage();
    }

    @Test(description = "Удаление сущ. случаев диспансеризации и постановка пациента на учёт", dependsOnMethods = "beforeTest")
    public void step2_createAccount() {
        dAccountManager.getRegisterPage().setFilterPatient(dAccountData.getPatient());
        if (dAccountManager.getRegisterPage().getAccountListTable().getCountRowsInTable(true) > 0) {
            dAccountManager.getRegisterPage().getAccountListTable().chooseRowInTable(0);
            dAccountManager.getRegisterPage().clickDeleteAccountButton();
            RemoveDAccountModal removeDAccountModal = dAccountManager.getRegisterPage().getRemoveDAccountModal();
            removeDAccountModal.assertCountOfModals(1);
            removeDAccountModal.setValuesToFields(removeDAccountReason, removeDAccountReasonDesc);
            removeDAccountModal.clickConfirm();
        }
        dAccountManager.getRegisterPage().clickCreateAccountButton();
        DAccountModal createModal = dAccountManager.getRegisterPage().getDAccountCreateModal();
        createModal.assertCountOfModals(1);
        createModal.setValuesToFields(dAccountData);
        createModal.clickConfirm();
        dAccountManager.getRegisterPage().checkSuccessMessage();
        dAccountManager.getRegisterPage().checkRecordInAccountTable(dAccountData.getPatient(), dAccountData.getRegDate(),
                dAccountData.getFullDiagnosis(), dAccountData.getGroup());
    }

    @Test(description = "Редактирование карты д-учёта", dependsOnMethods = "step2_createAccount")
    public void step3_updateAccount() {
        dAccountManager.getRegisterPage().clickEditAccountButton();
        DAccountEditModal editModal = dAccountManager.getRegisterPage().getDAccountEditModal();
        editModal.setValuesToFields(dAccountDataEdit);
        editModal.clickConfirm();
        dAccountManager.getRegisterPage().checkSuccessMessage();
        dAccountManager.getRegisterPage().clickEditAccountButton();
        editModal.checkFieldsValues(dAccountDataEdit);
        editModal.clickCancel();
    }

    @Test(description = "Создание и изменение Д-группы", dependsOnMethods = "step3_updateAccount")
    public void step4_createAndUpdateDGroup() {
        dAccountManager.getRegisterPage().clickAccountHistoryButton();
        dAccountManager.getAccountHistoryPage().clickDGroupTab();
        dAccountManager.getAccountHistoryPage().clickEditDGroupButton();
        DAccountDGroupModal updateModal = dAccountManager.getAccountHistoryPage().getDAccountDGroupModal();
        updateModal.setValuesToFields(dGroupDataEdit);
        updateModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkDGroupSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInDGroupTable(dGroupDataEdit.getGroup(), dGroupDataEdit.getFromDt(),
                dGroupDataEdit.getAmb(), dGroupDataEdit.getReason());
        dAccountManager.getAccountHistoryPage().clickCreateDGroupButton();
        DAccountDGroupModal createModal = dAccountManager.getAccountHistoryPage().getDAccountDGroupModal();
        createModal.setValuesToFields(dGroupData);
        createModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkDGroupSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInDGroupTable(dGroupData.getGroup(), dGroupData.getFromDt(),
                dGroupData.getAmb(), dGroupData.getReason());
    }

    @Test(description = "Создание, изменение и удаление Динамики состояния", dependsOnMethods = "step4_createAndUpdateDGroup")
    public void step5_createUpdateDeleteRemission() {
        dAccountManager.getAccountHistoryPage().clickRemissionTab();
        dAccountManager.getAccountHistoryPage().clickCreateRemissionButton();
        DAccountRemissionModal createModal = dAccountManager.getAccountHistoryPage().getDAccountRemissionModal();
        createModal.assertCountOfModals(1);
        createModal.setValuesToFields(remissionData);
        createModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkRemissionSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInRemissionTable(remissionData.getBeginDt(),
                remissionData.getEndDt(), remissionData.getInfo());
        dAccountManager.getAccountHistoryPage().clickEditRemissionButton();
        DAccountRemissionModal updateModal = dAccountManager.getAccountHistoryPage().getDAccountRemissionModal();
        updateModal.assertCountOfModals(1);
        updateModal.setValuesToFields(remissionDataEdit);
        updateModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkRemissionSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInRemissionTable(remissionDataEdit.getBeginDt(),
                remissionDataEdit.getEndDt(), remissionDataEdit.getInfo());
        dAccountManager.getAccountHistoryPage().clickDeleteRemissionButton();
        Table dAccountRemissions = dAccountManager.getAccountHistoryPage().getRemissionListTable();
        dAccountRemissions.assertNoRecords();
    }

    @Test(description = "Создание, изменение и удаление Сведения о госпитализациях", dependsOnMethods = "step5_createUpdateDeleteRemission")
    public void step6_createUpdateDeleteHospital() {
        dAccountManager.getAccountHistoryPage().clickHospitalTab();
        dAccountManager.getAccountHistoryPage().clickCreateHospitalButton();
        DAccountHospitalModal createModal = dAccountManager.getAccountHistoryPage().getDAccountHospitalModal();
        createModal.setValuesToFields(hospitalData);
        createModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkHospitalSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInHospitalTable(hospitalData.getAdmission_dt(),
                hospitalData.getOutcome_date(), hospitalData.getDiagName(), hospitalData.getGoalName());
        dAccountManager.getAccountHistoryPage().clickEditHospitalButton();
        DAccountHospitalModal updateModal = dAccountManager.getAccountHistoryPage().getDAccountHospitalModal();
        updateModal.setValuesToFields(hospitalDataEdit);
        updateModal.clickConfirm();
        dAccountManager.getAccountHistoryPage().checkHospitalSuccessMessage();
        dAccountManager.getAccountHistoryPage().checkRecordInHospitalTable(hospitalDataEdit.getAdmission_dt(),
                hospitalDataEdit.getOutcome_date(), hospitalDataEdit.getDiagName(), hospitalDataEdit.getGoalName());
        dAccountManager.getAccountHistoryPage().clickDeleteHospitalButton();
        Table dAccountHospitals = dAccountManager.getAccountHistoryPage().getHospitalListTable();
        dAccountHospitals.assertNoRecords();
    }

    @Test(description = "Создание, изменение и удаление Информация о принудительном лечении", dependsOnMethods = "step6_createUpdateDeleteHospital")
    public void step7_createUpdateDeleteFrc() {
        dAccountManager.openRegisterPage();
        dAccountManager.getRegisterPage().setFilterPatient(dAccountData.getPatient());
        dAccountManager.getRegisterPage().clickFrcButton();
        DAccountFrcModal frcModal = dAccountManager.getRegisterPage().getDAccountFrcModal();
        frcModal.assertCountOfModals(1);
        frcModal.clickCreateFrcButton();
        DAccountFrcRecordModal frcRecordModal= frcModal.getDAccountFrcRecordModal();
        frcRecordModal.setValuesToFields(frcData);
        frcRecordModal.clickConfirm();
        frcModal.checkFrcSuccessMessage();
        frcModal.checkRecordInFrcTable(frcData.getFrcKind(),
                frcData.getOrderNumber(), frcData.getOrderDt(), frcData.getCloseDt());
        frcModal.clickEditFrcButton();
        DAccountFrcRecordModal editFrcRecordModal= frcModal.getDAccountFrcRecordModal();
        editFrcRecordModal.setValuesToFields(frcDataEdit);
        editFrcRecordModal.clickConfirm();
        frcModal.checkFrcSuccessMessage();
        frcModal.checkRecordInFrcTable(frcDataEdit.getFrcKind(),
                frcDataEdit.getOrderNumber(), frcDataEdit.getOrderDt(), frcDataEdit.getCloseDt());
        frcModal.clickDeleteFrcButton();
        Table dAccountFrcs = frcModal.getFrcListTable();
        dAccountFrcs.assertNoRecords();
    }

    @Test(description = "Создание, изменение и удаление Информация о недобровольном освидетельствовании", dependsOnMethods = "step7_createUpdateDeleteFrc")
    public void step8_createUpdateDeleteFrcInvolExam() {
        DAccountFrcModal frcModal = dAccountManager.getRegisterPage().getDAccountFrcModal();
        frcModal.assertCountOfModals(1);
        frcModal.clickCreateFrcInvolExamButton();
        DAccountFrcInvolExamModal frcInvolExamModal= frcModal.getDAccountFrcInvolExamModal();
        frcInvolExamModal.setValuesToFields(involExamData);
        frcInvolExamModal.clickConfirm();
        frcModal.checkFrcInvolExamSuccessMessage();
        frcModal.checkRecordInFrcInvolExamTable(involExamData.getExamDt(), involExamData.getResult());
        frcModal.clickEditFrcInvolExamButton();
        DAccountFrcInvolExamModal frcInvolExamModalEdit= frcModal.getDAccountFrcInvolExamModal();
        frcInvolExamModalEdit.setValuesToFields(involExamDataEdit);
        frcInvolExamModalEdit.clickConfirm();
        frcModal.checkFrcInvolExamSuccessMessage();
        frcModal.checkRecordInFrcInvolExamTable(involExamDataEdit.getExamDt(), involExamDataEdit.getResult());
        frcModal.clickDeleteFrcInvolExamButton();
        Table dAccountFrcInvolExams = frcModal.getFrcInvolExamListTable();
        dAccountFrcInvolExams.assertNoRecords();
        frcModal.close();
    }

    @Test(description = "Снятие пациента с учёта", dependsOnMethods = "step8_createUpdateDeleteFrcInvolExam")
    public void step9_takeOffPatient() {
        dAccountManager.getRegisterPage().clickTakeOffPatientButton();
        TakeOffPatientModal takeOffPatientModal= dAccountManager.getRegisterPage().getTakeOffPatientModal();
        takeOffPatientModal.setValuesToFields(takeOffPatientData);
        takeOffPatientModal.clickConfirm();
        dAccountManager.getRegisterPage().checkUnregInfoInAccountTable(dAccountData.getPatient(),
                takeOffPatientData.getUnregDate(), takeOffPatientData.getReason());
        dAccountManager.getRegisterPage().clickUpdateTakeOffPatientButton();
        TakeOffPatientModal updateTakeOffPatientModal= dAccountManager.getRegisterPage().getTakeOffPatientModal();
        updateTakeOffPatientModal.setValuesToFields(takeOffPatientDataEdit);
        updateTakeOffPatientModal.clickConfirm();
        dAccountManager.getRegisterPage().checkUnregInfoInAccountTable(dAccountDataEdit.getPatient(),
                takeOffPatientDataEdit.getUnregDate(), takeOffPatientDataEdit.getReason());
    }

    @Test(description = "Удаление карты д-учёта", dependsOnMethods = "step9_takeOffPatient")
    public void step10_removeDAccount() {
        dAccountManager.getRegisterPage().clickDeleteAccountButton();
        RemoveDAccountModal removeDAccountModal= dAccountManager.getRegisterPage().getRemoveDAccountModal();
        removeDAccountModal.assertCountOfModals(1);
        removeDAccountModal.setValuesToFields(removeDAccountReason, removeDAccountReasonDesc);
        removeDAccountModal.clickConfirm();
        Table cases = dAccountManager.getRegisterPage().getAccountListTable();
        cases.assertNoRecords();
    }

    @Test(description = "Восстановление карты д-учёта", dependsOnMethods = "step10_removeDAccount")
    public void step11_restoreDAccount() {
        dAccountManager.openDAccountRegisterDeletedPage();
        dAccountManager.getDeletedRegisterPage().clickRestoreAccountButton();
        Table register = dAccountManager.getDeletedRegisterPage().getRestoreAccountListTable();
        /**Убрал проверку assertNoRecords т.к. после повторного прогона у пациента остается более 1-й Удаленной записи - А удалить эти записи возможность есть только в LSD*/
//        register.assertNoRecords();
    }
}
