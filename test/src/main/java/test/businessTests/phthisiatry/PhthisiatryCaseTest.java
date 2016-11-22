package test.businessTests.phthisiatry;

import businessFramework.entities.phthisiatry.MCaseData;
import businessFramework.entities.phthisiatry.MStepData;
import businessFramework.entities.phthisiatry.MRefData;
import businessFramework.module.phthisiatry.PhthisiatryManager;
import businessFramework.module.phthisiatry.modals.mCase.MCaseCreateModal;
import businessFramework.module.phthisiatry.modals.mCase.MCaseEditModal;
import businessFramework.module.phthisiatry.modals.mCase.MCaseCloseModal;
import businessFramework.module.phthisiatry.modals.mStep.MStepCreateModal;
import businessFramework.module.phthisiatry.modals.mStep.MStepEditModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefSetModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefEditModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefRenderedModal;
import businessFramework.module.phthisiatry.modals.VrachSearchModal;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhthisiatryCaseTest extends TestBase {
    private PhthisiatryManager phthisiatryManager;
    private MCaseData mCaseData;
    private MCaseData mCaseDataEdit;
    private MCaseData mCaseDataClose;
    private MStepData mStepData;
    private MStepData mStepDataEdit;
    private MRefData mRefData;
    private MRefData mRefDataEdit;
    private MRefData mRefRenderedData;

    String fullName;
    String surname;
    String name;
    String patrName;
    String birthDate;
    String posName;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        phthisiatryManager = new PhthisiatryManager();
        mCaseData = new MCaseData();

        mCaseData.setDepartmentForContext("Отделение экстренной госпитализации");

        mCaseData.setPatient("Стационар Станислав Александрович");
        mCaseData.setUid("12345");
        mCaseData.setCreateDate(page.getCurrentDate());
        mCaseData.setMdCaseDiagnos("A17.0+ Туберкулезный менингит (G01*)");
        mCaseData.setDiagnosisDate("03.09.2015");
        mCaseData.setRepeatCount("Первично");
        mCaseData.setCaseType("Случай поликлинического обслуживания");
        mCaseData.setCareRegimen("Амбулаторный");
        mCaseData.setCareLevel("Другая медицинская помощь");
        mCaseData.setFunding("ОМС");
        mCaseData.setInitGoal("Заболевание");
        mCaseData.setDiagnosisStage("Клинический");
        List<String> diagnosis = new ArrayList<>();
        diagnosis.add("A00-B99 НЕКОТОРЫЕ ИНФЕКЦИОННЫЕ И ПАРАЗИТАРНЫЕ БОЛЕЗНИ");
        diagnosis.add("A15-A19 ТУБЕРКУЛЕЗ");
        diagnosis.add("A17 Туберкулез нервной системы");
        diagnosis.add("A17.0+ Туберкулезный менингит (G01*)");
        mCaseData.setDiagnosis(diagnosis);
        mCaseData.setDiagnosisCode("A17.0");
        mCaseData.setClinicalForm("10. Туберкулезный плеврит (эмпиема плевры)");
        mCaseData.setLocalization("10. Туберкулез прочих органов");
        mCaseData.setComplication("10. Туберкулез бронха");

        mCaseDataEdit = mCaseData.clone();
        mCaseDataEdit.setClinicalForm("15. Туберкулез легких с пылевыми заболеваниями");
        mCaseDataEdit.setLocalization("15. Туберкулез ЦНС");
        mCaseDataEdit.setComplication("15. Почечная недостаточность");

        mCaseDataClose = mCaseData.clone();
        mCaseDataClose.setResultTreatment("108 Лечение прервано по инициативе ЛПУ");
        mCaseDataClose.setResultReason("Нарушение режима");
        mCaseDataClose.setDeviationReason("Отклонение от стандарта");
        mCaseDataClose.setDiagnosisStageClose("Клинический");
        List<String> diagnosisClose = new ArrayList<>();
        diagnosisClose.add("A00-B99 НЕКОТОРЫЕ ИНФЕКЦИОННЫЕ И ПАРАЗИТАРНЫЕ БОЛЕЗНИ");
        diagnosisClose.add("A15-A19 ТУБЕРКУЛЕЗ");
        diagnosisClose.add("A17 Туберкулез нервной системы");
        diagnosisClose.add("A17.1 Менингеальная туберкулема G07*");
        mCaseDataClose.setDiagnosis(diagnosisClose);
        mCaseDataClose.setDiagnosisCodeClose("A17.1");
        mCaseDataClose.setDiagnosisType("Сопутствующий");
        mCaseDataClose.setDiseaseType("Острое (+)");
        mCaseDataClose.setEstablishmentDate(page.getCurrentDate());

        mStepData = new MStepData();
        mStepData.setVrach("Автотест Фтизиатрия Посещение");
        mStepData.setService("Автотест услуга (не удалять)");
        mStepData.setEquip("Автотест-оборудование (100)");
        mStepData.setAdmissionDate(page.getCurrentDate());
        mStepData.setPlace("в АПУ");
        mStepData.setProfile("Фтизиатрия");
        mStepData.setInitGoal("Диспансерное наблюдение");
        mStepData.setDiseaseType("Острое (+)");
        List<String> diagnosisStep = new ArrayList<>();
        diagnosisStep.add("A00-B99 НЕКОТОРЫЕ ИНФЕКЦИОННЫЕ И ПАРАЗИТАРНЫЕ БОЛЕЗНИ");
        diagnosisStep.add("A15-A19 ТУБЕРКУЛЕЗ");
        diagnosisStep.add("A17 Туберкулез нервной системы");
        diagnosisStep.add("A17.0+ Туберкулезный менингит (G01*)");
        mStepData.setDiagnosis(diagnosisStep);
        mStepData.setDiagnosisCode("A17.0");
        mStepData.setClinicalForm("11. Первичный туберкулезный комплекс");
        mStepData.setLocalization("11. Генерализованный туберкулез (3 локализации и более)");
        mStepData.setComplication("11. Туберкулез верхних дыхательных путей");

        mStepDataEdit = mStepData.clone();
        List<String> diagnosisStepEdit = new ArrayList<>();
        diagnosisStepEdit.add("A00-B99 НЕКОТОРЫЕ ИНФЕКЦИОННЫЕ И ПАРАЗИТАРНЫЕ БОЛЕЗНИ");
        diagnosisStepEdit.add("A15-A19 ТУБЕРКУЛЕЗ");
        diagnosisStepEdit.add("A17 Туберкулез нервной системы");
        diagnosisStepEdit.add("A17.9 Туберкулез нервной системы неуточненный G99.8*");
        mStepDataEdit.setDiagnosis(diagnosisStepEdit);
        mStepDataEdit.setDiagnosisCode("A17.9");
        mCaseDataEdit.setClinicalForm("16. Состояние после операции по поводу легочного туберкулеза (А15)");
        mCaseDataEdit.setLocalization("16. Туберкулез мочеполовой системы");
        mCaseDataEdit.setComplication("16. Гипертония симптоматическая");

        mRefData = new MRefData();
        mRefData.setClinic("Стационар для автотестов");
        mRefData.setPlannedDate(page.getCurrentDate() + " 08:00");
        mRefData.setService("1 Автотест услуга (не удалять)");

        mRefDataEdit = mRefData.clone();
        mRefDataEdit.setCheckboxesIsUrgent(" СРОЧНО");
        mRefDataEdit.setClinic("Стационар для автотестов");
        mRefDataEdit.setFinancialType("Средства граждан");
        mRefDataEdit.setPlannedDate(page.getCurrentDate() + " 12:00");
        mRefDataEdit.setService("1 Автотест услуга (не удалять)");

        mRefRenderedData = new MRefData();
        mRefRenderedData.setRenderedDate(page.getCurrentDate() + " 00:00");
        mRefRenderedData.setVrach("Автотест Фтизиатрия Посещение");
        mRefRenderedData.setDiagnos("A00.9 Холера неуточненная");
        mRefRenderedData.setComment(randomChar(44));
        mRefRenderedData.setRefStatus("Оказана");

        // Данные для заполнения полей на форме в модальном окне поиска "Врач"
        fullName = "Автотест Фтизиатрия Посещение";
        surname = "Автотест";
        name = "Фтизиатрия";
        patrName = "Посещение";
        birthDate = "01.01.1989";
        posName = "Врач стационара";
    }

    @Test(description = "Открытие модуля 'Фтизиатрия'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(mCaseData.getDepartmentForContext());
        phthisiatryManager.openPhthisiatryPage();
        phthisiatryManager.getPhthisiatryPage().deleteCases(mCaseData);
   }

    @Test(description = "Создание случая", dependsOnMethods = "beforeTest", enabled = true)
    public void step1_createCase() {
        phthisiatryManager.getPhthisiatryPage().clickCreateCaseButton();
        MCaseCreateModal createCaseModal = phthisiatryManager.getPhthisiatryPage().getMCaseCreateModal();
        createCaseModal.assertCountOfModals(1);
        createCaseModal.setValuesToFields(mCaseData);
        createCaseModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkCaseSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().checkRecordInCasesTable(mCaseData.getUid(), mCaseData.getPatient(), mCaseData.getFunding());
    }

    @Test(description = "Фильтрация по полям для созданного случая", dependsOnMethods = "step1_createCase")
    public void step2_filterCase() {
        phthisiatryManager.getPhthisiatryPage().filterForCases(mCaseData);
        phthisiatryManager.getPhthisiatryPage().checkRecordInCasesTable(mCaseData.getUid(), mCaseData.getPatient(), mCaseData.getFunding());
        Table filterCaseTableModal = phthisiatryManager.getPhthisiatryPage().getCaseListTable();
        filterCaseTableModal.assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Редактирование случая", dependsOnMethods = "step2_filterCase", enabled = true)
    public void step3_updateCase() {
        phthisiatryManager.getPhthisiatryPage().clickEditCaseButton();
        MCaseEditModal editCaseModal = phthisiatryManager.getPhthisiatryPage().getMCaseEditModal();
        editCaseModal.assertCountOfModals(1);
        editCaseModal.setValuesToFields(mCaseDataEdit.getClinicalForm(), mCaseDataEdit.getLocalization(), mCaseDataEdit.getComplication());
        editCaseModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkCaseSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().clickEditCaseButton();
        editCaseModal.checkFieldsValues(mCaseDataEdit);
        editCaseModal.clickCancel();
    }

    @Test(description = "Создать посещение", dependsOnMethods = "step3_updateCase", enabled = true)
    public void step4_createStep() {
        phthisiatryManager.getPhthisiatryPage().clickCreateStepButton();
        MStepCreateModal createStepModal = phthisiatryManager.getPhthisiatryPage().getMStepCreateModal();
        createStepModal.assertCountOfModals(1);
        createStepModal.setValuesToFields(mStepData);
        createStepModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkStepSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().checkRecordInStepTable(mStepData.getAdmissionDate(), mStepData.getVrach(), mStepData.getService());
    }

    @Test(description = "Поиск через фильтр по полю врач(модальное окно) в случае", dependsOnMethods = "step4_createStep", enabled = true)
    public void step5_filterCaseVrach() {
        phthisiatryManager.getPhthisiatryPage().filterButtonVrach();
        VrachSearchModal vrachSearchModal = phthisiatryManager.getPhthisiatryPage().getVrachSearchModal();
        vrachSearchModal.assertCountOfModals(1);
        vrachSearchModal.checkModalHeader();
        vrachSearchModal.fillFields(surname, name, patrName, birthDate, posName);
        vrachSearchModal.clickSearchVrachButton();
        vrachSearchModal.clickChooseVrachButton();
        phthisiatryManager.getPhthisiatryPage().checkValueInVrachContainer(fullName);
        phthisiatryManager.getPhthisiatryPage().filterButtonSearch();
        phthisiatryManager.getPhthisiatryPage().checkRecordInCasesTable(mCaseData.getUid(), mCaseData.getPatient(), mCaseData.getFunding());
        Table filterCaseTableModal = phthisiatryManager.getPhthisiatryPage().getCaseListTable();
        filterCaseTableModal.assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Редактирование посещения", dependsOnMethods = "step5_filterCaseVrach", enabled = true)
    public void step6_updateStep() {
        phthisiatryManager.getPhthisiatryPage().clickEditStepButton();
        MStepEditModal editStepModal = phthisiatryManager.getPhthisiatryPage().getMStepEditModal();
        editStepModal.assertCountOfModals(1);
        editStepModal.setValuesToFields(mStepDataEdit);
        editStepModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkStepSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().clickEditStepButton();
        editStepModal.checkFieldsValues(mStepDataEdit);
        editStepModal.clickCancel();
        Table editStepTableModal = phthisiatryManager.getPhthisiatryPage().getStepListTable();
        editStepTableModal.assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Закрыть случай", dependsOnMethods = "step6_updateStep", enabled = true)
    public void step7_closeCase() {
        phthisiatryManager.getPhthisiatryPage().filterPacient(mCaseData);
        phthisiatryManager.getPhthisiatryPage().clickCloseCaseButton();
        MCaseCloseModal closeModal = phthisiatryManager.getPhthisiatryPage().getMCaseCloseModal();
        closeModal.assertCountOfModals(1);
        closeModal.setValuesToFields(mCaseDataClose);
        closeModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkRecordInReOpenCasesTable(mCaseData.getUid(), mCaseData.getPatient(), mCaseData.getFunding(), mCaseDataClose.getEstablishmentDate());
    }

    @Test(description = "Переоткрыть закрытый случай", dependsOnMethods = "step7_closeCase", enabled = true)
    public void step8_reOpenCase() {
        phthisiatryManager.getPhthisiatryPage().clickReOpenCaseButton();
        phthisiatryManager.getPhthisiatryPage().checkCaseSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().checkRecordInCasesTable(mCaseData.getUid(), mCaseData.getPatient(), mCaseData.getFunding());
        Table casesReOpen = phthisiatryManager.getPhthisiatryPage().getCaseListTable();
        casesReOpen.assertThatTableContainsOnlyXRows(1);
    }

    @Test(description = "Назначить Направления (Назначения)", dependsOnMethods = "step8_reOpenCase",  enabled = true)
    public void step9_setServiceReferral() {
        phthisiatryManager.getPhthisiatryPage().clickSetRefButton();
        MRefSetModal createRefModal = phthisiatryManager.getPhthisiatryPage().getMRefSetModal();
        createRefModal.assertCountOfModals(1);
        createRefModal.setValuesToFields(mRefData);
        createRefModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkRefSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().checkRecordInRefTable(mRefData.getClinic(), mRefData.getPlannedDate(), mRefData.getService());

        HashMap<String, String> refValue = new HashMap<>();
        refValue.put("Услуга", mRefData.getService());
        refValue.put("Дата планирования", mRefData.getPlannedDate());
        phthisiatryManager.getPhthisiatryPage().getRefListTable().chooseRowBySeveralColumnValues(refValue);
    }

    @Test(description = "Редактирование Направления (Назначения)", dependsOnMethods = "step9_setServiceReferral", enabled = true)
    public void step10_updateReferral() {
        phthisiatryManager.getPhthisiatryPage().clickEditRefButton();
        MRefEditModal editRefModal = phthisiatryManager.getPhthisiatryPage().getMRefEditModal();
        editRefModal.assertCountOfModals(1);
        editRefModal.setValuesToFields(mRefDataEdit);
        editRefModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkRefSuccessMessage();
        phthisiatryManager.getPhthisiatryPage().clickEditRefButton();
        editRefModal.checkFieldsValues(mRefDataEdit);
        editRefModal.clickCancel();
        Table editRefTableModal = phthisiatryManager.getPhthisiatryPage().getRefListTable();
        editRefTableModal.assertThatTableContainsOnlyXRows(2);
        HashMap<String, String> refValue = new HashMap<>();
        refValue.put("Услуга", mRefDataEdit.getService());
        refValue.put("Дата планирования", mRefDataEdit.getPlannedDate());
        editRefTableModal.chooseRowBySeveralColumnValues(refValue);
    }

    @Test(description = "Внести результат", dependsOnMethods = "step10_updateReferral", enabled = true)
    public void step11_RenderedReferral() {
        phthisiatryManager.getPhthisiatryPage().clickRenderedRefButton();
        MRefRenderedModal renderedRefModal = phthisiatryManager.getPhthisiatryPage().getMRefRenderedModal();
        renderedRefModal.assertCountOfModals(1);
        phthisiatryManager.getPhthisiatryPage().getMRefRenderedModal().getVrachField().findModalButtonClick();
        VrachSearchModal vrachSearchModal = phthisiatryManager.getPhthisiatryPage().getVrachSearchModal();
        vrachSearchModal.checkModalHeader();
        vrachSearchModal.fillFields(surname, name, patrName, birthDate, posName);
        vrachSearchModal.clickSearchVrachButton();
        vrachSearchModal.clickChooseVrachButton();
        vrachSearchModal.checkValueInVrach(fullName);
        renderedRefModal.setValuesToFields(mRefRenderedData);
        renderedRefModal.clickConfirm();
        phthisiatryManager.getPhthisiatryPage().checkRecordInRefRenderedTable(mRefData.getService(), mRefDataEdit.getPlannedDate(), mRefRenderedData.getRenderedDate(), mRefRenderedData.getRefStatus(), mRefData.getClinic());
    }

    @Test(description = "Фильтрация Направления (Назначения) по отделению", dependsOnMethods = "step11_RenderedReferral")
    public void step12_filterRef() {
        phthisiatryManager.getPhthisiatryPage().filterForRefs(mRefData);
        phthisiatryManager.getPhthisiatryPage().checkRecordInRefRenderedTable(mRefData.getService(), mRefDataEdit.getPlannedDate(), mRefRenderedData.getRenderedDate(), mRefRenderedData.getRefStatus(), mRefData.getClinic());
        Table filterRefTableModal = phthisiatryManager.getPhthisiatryPage().getRefListTable();
        filterRefTableModal.assertThatTableContainsOnlyXRows(2);
    }

//    @Test(description = "Нажатие кнопки 'Перейти в картотеку пациентов'" + "Проверка, что произошел переход на URL https://Стенд.is-mis.ru/pats/patients/new",
//            dependsOnMethods = "beforeTest", enabled = false)
//    public void step13_checkLinkButton() {
//        phthisiatryManager.getPhthisiatryPage().clickToPatientButton();
//        String expectedUrl = ".is-mis.ru/pats/patients/new";
//        page.assertCurrentUrlContains(expectedUrl, true);
//    }

    @Test(description = "Удаление посещения и случая", dependsOnMethods = "step12_filterRef", alwaysRun = true)
    public void step14_deleteCase() {
        phthisiatryManager.getPhthisiatryPage().clickDeleteStepButton();
        Table steps = phthisiatryManager.getPhthisiatryPage().getStepListTable();
        steps.assertNoRecords();
        phthisiatryManager.getPhthisiatryPage().clickDeleteCaseButton();
        Table cases = phthisiatryManager.getPhthisiatryPage().getCaseListTable();
        cases.assertNoRecords();
    }

}
