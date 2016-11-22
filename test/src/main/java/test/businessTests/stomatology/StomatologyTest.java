package test.businessTests.stomatology;

import businessFramework.entities.stomatology.ResultAdmissionDataStom;
import businessFramework.entities.stomatology.StomatologyAppointmentData;
import businessFramework.module.Values;
import businessFramework.module.stomatology.StomatologyManager;
import businessFramework.module.stomatology.modals.closeCase.StomCloseCaseModal;
import businessFramework.module.stomatology.modals.hospitalReferral.HospitalReferralModal;
import businessFramework.module.stomatology.modals.stomCert.StomCertModal;
import businessFramework.module.stomatology.modals.stomDiagnosis.StomDiagnosisModal;
import businessFramework.module.stomatology.modals.stomInspection.AddStomInspectionModal;
import businessFramework.module.stomatology.modals.stomInspection.StomInspectionModal;
import businessFramework.module.stomatology.modals.stomLaboratoryReferral.StomLaboratoryReferralModal;
import businessFramework.module.stomatology.modals.stomMedicalCard.AddStomMedicalCardHistoryModal;
import businessFramework.module.stomatology.modals.stomMedicalCard.StomMedicalCardModal;
import businessFramework.module.stomatology.modals.stomPrescription.StomPrescriptionModal;
import businessFramework.module.stomatology.modals.stomReceipt.StomReceiptModal;
import businessFramework.module.stomatology.modals.stomService.StomServiceModal;
import businessFramework.module.stomatology.modals.toothMaterial.ToothMaterialModal;
import businessFramework.module.stomatology.pages.refferal.StomReferralServicePage;
import businessFramework.module.stomatology.pages.resultAdmissionStom.ResultAdmissionPageStom;
import businessFramework.module.stomatology.pages.stomService.StomServicePage;
import businessFramework.module.stomatology.pages.stomatologyAppointment.StomatologyAppointmentPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StomatologyTest extends TestBase implements Values {
    StomatologyManager stomatologyManager;
    StomatologyAppointmentData stomatologyAppointmentData;
    ResultAdmissionPageStom resultAdmissionPageStom;
    ResultAdmissionDataStom resultAdmissionDataStom;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        stomatologyManager = new StomatologyManager();
        stomatologyAppointmentData = new StomatologyAppointmentData();
        resultAdmissionDataStom = new ResultAdmissionDataStom();

        //дата фильтра поиска записи пациента (случая)
        stomatologyAppointmentData.setAdmissionDate("10.10.2016");
        stomatologyAppointmentData.setPatientFIO("Стоматология Автотест Пациент");
        //Поля случая и посещения
        resultAdmissionDataStom.setMcCaseCareRegimen("Амбулаторный");
        resultAdmissionDataStom.setFundingSourceType("ОМС");
        resultAdmissionDataStom.setMcCaseType("Случай поликлинического обслуживания");
        resultAdmissionDataStom.setCareLevel("Другая");
        resultAdmissionDataStom.setCareProvidingForm("Плановая");
        resultAdmissionDataStom.setCareProvisionCondition("Общий");
        resultAdmissionDataStom.setCaseInitGoal("1 - Заболевание");
        resultAdmissionDataStom.setVisitPlace("в АПУ");
        resultAdmissionDataStom.setProfile("Терапия");
        resultAdmissionDataStom.setService("Прием");
        resultAdmissionDataStom.setMedicalCardPlaceName("В поликлинике");

    }

    @Test(description = "Открытие модуля 'Стоматология'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createStomCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        page.getHeader().chooseContext("Подразделение стоматологии");
        stomatologyManager.openStomatologyPage();
    }

    @Test(description = "Выбор записи и открытие результатов приема", dependsOnMethods = "beforeTest")
    public void step1_selectStomAppointment() {
        stomatologyManager.getStomatologyAppointmentPage().filterByDate(stomatologyAppointmentData.getAdmissionDate());
        stomatologyManager.getStomatologyAppointmentPage().clickStomatologyAppointmentResultAdmission();
        resultAdmissionPageStom = stomatologyManager.getResultAdmissionPagesStom();
    }

    @Test(description = "Заполнение полей случая и посещения", dependsOnMethods = "step1_selectStomAppointment")
    public void step2_createStomCaseAndVisit() {

        ResultAdmissionPageStom resultAdmissionPageStom = stomatologyManager.getResultAdmissionPagesStom();
        resultAdmissionPageStom.clickCreateNewCase();
        resultAdmissionPageStom.setValueToField(resultAdmissionDataStom);
        resultAdmissionPageStom.clickSaveCase();

    }

    @Test(description = "АМК", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step3_createMedicalCardPlace() {
        resultAdmissionPageStom.saveMedicalCard(resultAdmissionDataStom);
        resultAdmissionPageStom.clickMedicalCardHistory();
        StomMedicalCardModal stomMedicalCardModal = stomatologyManager.getStomMedicalCardModal();
        stomMedicalCardModal.addMedicalCardRowHistory();
        AddStomMedicalCardHistoryModal addMedicalCardHistoryModal = stomatologyManager.getAddMedicalCardHistoryModal();
        addMedicalCardHistoryModal.setValues();
        addMedicalCardHistoryModal.clickConfirm();
        stomMedicalCardModal.deleteMedicalCardRowHistory();
        resultAdmissionPageStom.closeAllModalsOnPage();
    }

    @Test(description = "Добавление осмотра", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step4_createStomInspection() {
        resultAdmissionPageStom.getTabs().clickTab("#dental-formula");
        resultAdmissionPageStom.clickAddInspection();
        StomInspectionModal stomInspectionModal = stomatologyManager.getStomInspectionModal();
        stomInspectionModal.createStomInspection();
        AddStomInspectionModal addStomInspectionModal = stomatologyManager.getAddStomInspectionModal();
        addStomInspectionModal.setValue();
        addStomInspectionModal.clickConfirm();
        stomInspectionModal.getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Изменение осмотра", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step5_editStomInspection() {
        StomInspectionModal stomInspectionModal = stomatologyManager.getStomInspectionModal();
        stomInspectionModal.getTable().chooseRowInTable(0);
        stomInspectionModal.editStomInspection();
        AddStomInspectionModal addStomInspectionModal = stomatologyManager.getAddStomInspectionModal();
        addStomInspectionModal.changeValue();
        addStomInspectionModal.clickConfirm();
        stomInspectionModal.getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Удвление осмотра", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step6_deleteStomInspection() {
        StomInspectionModal stomInspectionModal = stomatologyManager.getStomInspectionModal();
        stomInspectionModal.getTable().chooseRowInTable(0);
        stomInspectionModal.deleteStomInspection();
        stomInspectionModal.getTable().assertThatCountOfRowsIs(0);
        resultAdmissionPageStom.closeAllModalsOnPage();
    }

    @Test(description = "Добавление диагноза", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step7_createStomDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.clickCreateDiagnosisButton();
        StomDiagnosisModal stomDiagnosisModal = stomatologyManager.getStomDiagnosisModal();
        stomDiagnosisModal.setValue();
        stomDiagnosisModal.clickConfirm();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(1);
        resultAdmissionPageStom.clickCreateDiagnosisButton();
        stomDiagnosisModal.setValue();
        stomDiagnosisModal.clickConfirm();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование диагноза", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step8_editStomDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPageStom.clickUpdateDiagnosis();
        StomDiagnosisModal stomDiagnosisModal = stomatologyManager.getStomDiagnosisModal();
        stomDiagnosisModal.changeValue();
        stomDiagnosisModal.clickConfirm();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление диагноза", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 1)
    public void step9_deleteStomDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPageStom.clickDeleteDiagnosis();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление Услуги", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step10_createStomServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.clickCreateService();
        StomServiceModal stomServiceModal = stomatologyManager.getStomServiceModal();
        stomServiceModal.setValue();
        stomServiceModal.clickConfirm();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование услуг", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step11_editStomServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.getTableService().chooseRowInTable(1);
        resultAdmissionPageStom.clickUpdateService();
        StomServicePage stomServicePage = stomatologyManager.getStomServicePage();
        stomServicePage.editValue();
        stomServicePage.clickConfirm();
        stomServicePage.clickCancel();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление услуг", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step12_deleteStomServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.getTableService().chooseRowInTable(1);
        resultAdmissionPageStom.clickDeleteService();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(1);
    }


    @Test(description = "Добавление Расходного материала", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step13_createToothMaterial() {
        resultAdmissionPageStom.getTabs().clickTab("#tooth-material");
        resultAdmissionPageStom.clickCreateToothMaterialButton();
        ToothMaterialModal toothMaterialModal = stomatologyManager.getToothMaterialModal();
        toothMaterialModal.setValue();
        toothMaterialModal.clickConfirm();
        resultAdmissionPageStom.getContainerToothMaterial().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Копирование Расходного материала", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step14_copyToothMaterial() {
        resultAdmissionPageStom.getTabs().clickTab("#tooth-material");
        resultAdmissionPageStom.clickCopyToothMaterialButton();
        ToothMaterialModal toothMaterialModal = stomatologyManager.getToothMaterialModal();
        toothMaterialModal.copyValue();
        resultAdmissionPageStom.getDialog().getButton(CONFIRM_BUTTON).click();
        resultAdmissionPageStom.getContainerToothMaterial().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование Расходного материала", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step15_editToothMaterial() {
        resultAdmissionPageStom.getTabs().clickTab("#tooth-material");
        resultAdmissionPageStom.getTableToothMaterial().chooseRowInTable(0);
        resultAdmissionPageStom.clickUpdateToothMaterialButton();
        ToothMaterialModal toothMaterialModal = stomatologyManager.getToothMaterialModal();
        toothMaterialModal.updateValue();
        resultAdmissionPageStom.getContainerToothMaterial().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Удаление Расходного материала", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step16_deleteToothMaterial() {
        resultAdmissionPageStom.getTabs().clickTab("#tooth-material");
        resultAdmissionPageStom.clickDeleteAllToothMaterialButton();
    }

    @Test(description = "Добавление направления на услуги", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step17_createReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateReferral();
        StomReferralServicePage stomReferralServicePage = stomatologyManager.getReferralPage();
        stomReferralServicePage.setValue();
        stomReferralServicePage.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование направления на услуги", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step18_editReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(0);
        resultAdmissionPageStom.clickUpdateReferral();
        StomReferralServicePage stomReferralServicePage = stomatologyManager.getReferralPage();
        stomReferralServicePage.updateValue();
        stomReferralServicePage.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление направления на лаб исследования", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 2)
    public void step19_createLaboratoryReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateLaboratoryReferral();
        StomLaboratoryReferralModal stomLaboratoryReferralModal = stomatologyManager.getStomLaboratoryReferralModal();
        stomLaboratoryReferralModal.setValue();
        stomLaboratoryReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование направления на лаб исследования", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step20_editLaboratoryReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(1);
        resultAdmissionPageStom.clickUpdateLaboratoryReferral();
        StomLaboratoryReferralModal stomLaboratoryReferralModal = stomatologyManager.getStomLaboratoryReferralModal();
        stomLaboratoryReferralModal.editValue();
        stomLaboratoryReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Добавление направления на госпитализацию", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step21_createHospitalReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateHospReferral();
        HospitalReferralModal hospitalReferralModal = stomatologyManager.getHospitalReferralModal();
        hospitalReferralModal.setValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Редактирование направления на госпитализацию", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step22_editHospitalReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(2);
        resultAdmissionPageStom.clickUpdateHospitalReferral();
        HospitalReferralModal hospitalReferralModal = stomatologyManager.getHospitalReferralModal();
        hospitalReferralModal.changeValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Удаление всех направлений", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step23_deleteAllReferral() {
        resultAdmissionPageStom.deleteAllReferral();
    }

    @Test(description = "Добавление Назначения", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step24_createStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.clickCreatePrescription();
        StomPrescriptionModal stomPrescriptionModal = stomatologyManager.getPrescriptionModal();
        stomPrescriptionModal.setValue();
        stomPrescriptionModal.clickConfirm();
        resultAdmissionPageStom.getContainerPrescription().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Назначения", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step25_editStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.clickEditPrescription();
        StomPrescriptionModal stomPrescriptionModal = stomatologyManager.getPrescriptionModal();
        stomPrescriptionModal.changeValue();
        stomPrescriptionModal.clickConfirm();
    }

    @Test(description = "Подтверждение Назначения", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step26_confirmStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.getContainerPrescription().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
        resultAdmissionPageStom.clickConfirmPrescription();
    }

    @Test(description = "Удаление всех Назначений", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step27_deleteAllPrescription() {
        resultAdmissionPageStom.deleteAllPrescription();
    }

    @Test(description = "Добавление Рецепта", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step28_createStomGeneralReceipt() {
        resultAdmissionPageStom.getTabs().clickTab("#receipt");
        resultAdmissionPageStom.clickCreateGeneralReceipt();
        StomReceiptModal stomReceiptModal = stomatologyManager.getReceiptModal();
        stomReceiptModal.setValue();
        stomReceiptModal.clickConfirm();
        resultAdmissionPageStom.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Рецепта", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 3)
    public void step29_editStomGeneralReceipt() {
        resultAdmissionPageStom.getTabs().clickTab("#receipt");
        resultAdmissionPageStom.clickEditReceipt();
        StomReceiptModal stomReceiptModal = stomatologyManager.getReceiptModal();
        stomReceiptModal.updateValue();
        stomReceiptModal.clickConfirm();
        resultAdmissionPageStom.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Удаление всех рецептов", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step30_deleteAllStomReceipt() {
        resultAdmissionPageStom.deleteAllReceipt();
    }

    @Test(description = "Добавление Справки", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step31_createStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.clickCreateCert();
        StomCertModal stomCertModal = stomatologyManager.getCertModal();
        stomCertModal.setValues();
        stomCertModal.clickConfirm();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление Отказа", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step32_createStomRefusal() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.clickCreateRefusal();
        StomCertModal stomCertModal = stomatologyManager.getCertModal();
        stomCertModal.setValues();
        stomCertModal.clickConfirm();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Аннулирование Справки", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step33_annulStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.getTableCert().chooseRowInTable(0);
        resultAdmissionPageStom.clickAnnuleCert();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Отмена аннулирования", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step34_cancelAnnuledStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.getTableCert().chooseRowInTable(0);
        resultAdmissionPageStom.clickCancelAnnuledCert();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Закрыть случай", dependsOnMethods = "step2_createStomCaseAndVisit", priority = 4)
    public void step35_closeStomCase() {
        ResultAdmissionPageStom resultAdmissionPage = stomatologyManager.getResultAdmissionPagesStom();
        resultAdmissionPage.clickCloseCase();
        StomCloseCaseModal stomCloseCaseModal = stomatologyManager.getCloseCaseModal();
        stomCloseCaseModal.setValue();
        stomCloseCaseModal.clickConfirm();
    }

    @Test(description = "Переоткрыть случай", dependsOnMethods = "step35_closeStomCase", priority = 4)
    public void step36_reOpenStomCase() {
        resultAdmissionPageStom.clickReopenCase();
    }

    @Test(description = "Переход в Информацию по случаю", dependsOnMethods = "step36_reOpenStomCase", priority = 4)
    public void step37_informAboutStomCase() {
        resultAdmissionPageStom.clickGoCase();
    }

    @Test(description = "Добавление диагноза", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step30_caseCreateStomDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.clickCreateDiagnosisButton();
        StomDiagnosisModal stomDiagnosisModal = stomatologyManager.getStomDiagnosisModal();
        stomDiagnosisModal.setValue();
        stomDiagnosisModal.clickConfirm();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование диагноза", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step31_caseEditDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertColumnValuesIs("Вид", "Основной");
        // resultAdmissionPageStom.getTableDiagnosis().chooseRowInTable(1);
        resultAdmissionPageStom.clickUpdateDiagnosis();
        StomDiagnosisModal stomDiagnosisModal = stomatologyManager.getStomDiagnosisModal();
        stomDiagnosisModal.changeValue();
        stomDiagnosisModal.clickConfirm();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление диагноза", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step32_caseDeleteDiagnosis() {
        resultAdmissionPageStom.getTabs().clickTab("#diagnosis");
        resultAdmissionPageStom.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPageStom.clickDeleteDiagnosis();
        resultAdmissionPageStom.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(1);
    }


    @Test(description = "Добавление Услуги", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step33_caseCreateStomServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.clickCreateServiceInform();
        StomServiceModal stomServiceModal = stomatologyManager.getStomServiceModal();
        stomServiceModal.setValue();
        stomServiceModal.clickConfirm();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование услуг", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step34_caseEditServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.getTableService().chooseRowInTable(1);
        resultAdmissionPageStom.clickUpdateServiceInform();
        StomServicePage stomServicePage = stomatologyManager.getStomServicePage();
        stomServicePage.editValue();
        stomServicePage.clickConfirm();
        stomServicePage.clickCancel();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление услуг", dependsOnMethods = "step37_informAboutStomCase", priority = 2)
    public void step35_caseDeleteServices() {
        resultAdmissionPageStom.getTabs().clickTab("#service");
        resultAdmissionPageStom.getTableService().chooseRowInTable(1);
        resultAdmissionPageStom.clickDeleteServiceInform();
        resultAdmissionPageStom.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление направления на услуги", dependsOnMethods = "step37_informAboutStomCase", priority = 4)
    public void step36_caseCreateReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateReferral();
        StomReferralServicePage stomReferralServicePage = stomatologyManager.getReferralPage();
        stomReferralServicePage.setValue();
        stomReferralServicePage.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование направления на услуги", dependsOnMethods = "step37_informAboutStomCase", priority = 4)
    public void step37_caseEditReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(0);
        resultAdmissionPageStom.clickUpdateReferral();
        StomReferralServicePage stomReferralServicePage = stomatologyManager.getReferralPage();
        stomReferralServicePage.updateValue();
        stomReferralServicePage.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление направления на лаб исследования", dependsOnMethods = "step37_informAboutStomCase", priority = 4)
    public void step38_caseCreateLaboratoryReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateLaboratoryReferral();
        StomLaboratoryReferralModal stomLaboratoryReferralModal = stomatologyManager.getStomLaboratoryReferralModal();
        stomLaboratoryReferralModal.setValue();
        stomLaboratoryReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование направления на лаб исследования", dependsOnMethods = "step37_informAboutStomCase", priority = 4)
    public void step39_caseEditLaboratoryReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(1);
        resultAdmissionPageStom.clickUpdateLaboratoryReferral();
        StomLaboratoryReferralModal stomLaboratoryReferralModal = stomatologyManager.getStomLaboratoryReferralModal();
        stomLaboratoryReferralModal.editValue();
        stomLaboratoryReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Добавление направления на госпитализацию", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step40_caseCreateHospitalReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.clickCreateHospReferral();
        HospitalReferralModal hospitalReferralModal = stomatologyManager.getHospitalReferralModal();
        hospitalReferralModal.setValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Редактирование направления на госпитализацию", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step41_caseEditHospitalReferral() {
        resultAdmissionPageStom.getTabs().clickTab("#referral");
        resultAdmissionPageStom.getTableReferral().chooseRowInTable(2);
        resultAdmissionPageStom.clickUpdateHospitalReferral();
        HospitalReferralModal hospitalReferralModal = stomatologyManager.getHospitalReferralModal();
        hospitalReferralModal.changeValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPageStom.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Удаление всех направлений", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step42_caseDeleteAllReferral() {
        resultAdmissionPageStom.deleteAllReferral();
    }

    @Test(description = "Добавление Назначения", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step43_caseCreateStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.clickCreatePrescription();
        StomPrescriptionModal stomPrescriptionModal = stomatologyManager.getPrescriptionModal();
        stomPrescriptionModal.setValue();
        stomPrescriptionModal.clickConfirm();
        resultAdmissionPageStom.getContainerPrescription().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Назначения", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step44_caseEditStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.clickEditPrescription();
        StomPrescriptionModal stomPrescriptionModal = stomatologyManager.getPrescriptionModal();
        stomPrescriptionModal.changeValue();
        stomPrescriptionModal.clickConfirm();
    }

    @Test(description = "Подтверждение Назначения", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step45_caseConfirmStomPrescription() {
        resultAdmissionPageStom.getTabs().clickTab("#prescription");
        resultAdmissionPageStom.getContainerPrescription().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
        resultAdmissionPageStom.clickConfirmPrescription();
    }

    @Test(description = "Удаление всех Назначений", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step46_caseDeleteAllPrescription() {
        resultAdmissionPageStom.deleteAllPrescription();
    }

    @Test(description = "Добавление Рецепта", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step47_caseCreateStomGeneralReceipt() {
        resultAdmissionPageStom.getTabs().clickTab("#receipt");
        resultAdmissionPageStom.clickCreateGeneralReceipt();
        StomReceiptModal stomReceiptModal = stomatologyManager.getReceiptModal();
        stomReceiptModal.setValue();
        stomReceiptModal.clickConfirm();
        resultAdmissionPageStom.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Рецепта", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step48_caseEditStomGeneralReceipt() {
        resultAdmissionPageStom.getTabs().clickTab("#receipt");
        resultAdmissionPageStom.clickEditReceipt();
        StomReceiptModal stomReceiptModal = stomatologyManager.getReceiptModal();
        stomReceiptModal.updateValue();
        stomReceiptModal.clickConfirm();
        resultAdmissionPageStom.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Удаление всех рецептов", dependsOnMethods = "step37_informAboutStomCase", priority = 5)
    public void step49_caseDeleteAllStomReceipt() {
        resultAdmissionPageStom.deleteAllReceipt();
    }

    @Test(description = "Добавление Справки", dependsOnMethods = "step37_informAboutStomCase", priority = 6)
    public void step50_caseCreateStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.clickCreateCert();
        StomCertModal stomCertModal = stomatologyManager.getCertModal();
        stomCertModal.setValues();
        stomCertModal.clickConfirm();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Добавление Отказа", dependsOnMethods = "step37_informAboutStomCase", priority = 6)
    public void step51_caseCreateStomRefusal() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.clickCreateRefusal();
        StomCertModal stomCertModal = stomatologyManager.getCertModal();
        stomCertModal.setValues();
        stomCertModal.clickConfirm();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }

    @Test(description = "Аннулирование Справки", dependsOnMethods = "step37_informAboutStomCase", priority = 6)
    public void step52_caseAnnulStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.getTableCert().chooseRowInTable(2);
        resultAdmissionPageStom.clickAnnuleCert();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }

    @Test(description = "Отмена аннулирования", dependsOnMethods = "step37_informAboutStomCase", priority = 6)
    public void step53_caseCancelAnnuledStomCert() {
        resultAdmissionPageStom.getTabs().clickTab("#cert");
        resultAdmissionPageStom.getTableCert().chooseRowInTable(2);
        resultAdmissionPageStom.clickCancelAnnuledCert();
        resultAdmissionPageStom.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }

    @Test(description = "Отменить посещение", dependsOnMethods = "step37_informAboutStomCase", priority = 7, alwaysRun = true)
    public void step54_removeStomVisitAndAppointment() {
        stomatologyManager.openStomatologyPage();
        StomatologyAppointmentPage stomatologyAppointmentPage = stomatologyManager.getStomatologyAppointmentPage();
        stomatologyAppointmentPage.filterByDate(stomatologyAppointmentData.getAdmissionDate());
        stomatologyAppointmentPage.clickCancelStomVisit();
    }
}
