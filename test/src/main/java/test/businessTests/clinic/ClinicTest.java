package test.businessTests.clinic;

import businessFramework.entities.clinic.ClinicAppointmentData;
import businessFramework.entities.clinic.ResultAdmissionData;
import businessFramework.module.Values;
import businessFramework.module.clinic.ClinicManager;
import businessFramework.module.clinic.modals.hospitalReferral.HospitalReferralModal;
import businessFramework.module.clinic.modals.laboratoryReferral.LaboratoryReferralModal;
import businessFramework.module.clinic.modals.cert.CertModal;
import businessFramework.module.clinic.modals.clinicDiagnosis.ClinicDiagnosisModal;
import businessFramework.module.clinic.modals.closeCase.CloseCaseModal;
import businessFramework.module.clinic.modals.medicalCard.AddMedicalCardHistoryModal;
import businessFramework.module.clinic.modals.medicalCard.MedicalCardModal;
import businessFramework.module.clinic.modals.prescription.PrescriptionModal;
import businessFramework.module.clinic.modals.receipt.ReceiptModal;
import businessFramework.module.clinic.pages.clinicAppointment.ClinicAppointmentPages;
import businessFramework.module.clinic.pages.referral.ReferralServicePage;
import businessFramework.module.clinic.pages.resultAdmission.ResultAdmissionPage;
import businessFramework.module.clinic.modals.serviceAndProtocol.ServiceAndProtocolModal;
import businessFramework.module.clinic.pages.serviceAndProtocol.ServicePage;
import net.framework.autotesting.test.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 18.02.2016.
 */
public class ClinicTest extends TestBase implements Values{
    ClinicManager clinicManager;
    ResultAdmissionData resultAdmissionData;
    ResultAdmissionPage resultAdmissionPage;
    ClinicAppointmentData clinicAppointmentData;


    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        clinicManager = new ClinicManager();
        resultAdmissionData = new ResultAdmissionData();
        clinicAppointmentData = new ClinicAppointmentData();

        //Поля случая и посещения
        resultAdmissionData.setCaseInitGoal("1 - Заболевание");
        resultAdmissionData.setCareProvidingForm("Плановая");
        resultAdmissionData.setCareLevel("Другая");
        resultAdmissionData.setCareProvisionCondition("Общий");
       // resultAdmissionData.setMcCaseCareRegimen("Амбулаторный");
        resultAdmissionData.setFundingSourceType("ОМС");
        resultAdmissionData.setMcCaseType("Случай поликлинического обслуживания");
        resultAdmissionData.setCaseInitGoal("1 - Заболевание");

        resultAdmissionData.setProfile("Терапия");
        resultAdmissionData.setVisitPlace("в АПУ");
        resultAdmissionData.setDiagnosis("B59 Пневмоцистоз");
        resultAdmissionData.setService("Осмотр");
        resultAdmissionData.setDiseaseType("1");
        resultAdmissionData.setMedicalCardPlaceName("В поликлинике");
        //Дата случая (поиск в фильтре)
        clinicAppointmentData.setAdmissionDate("10.10.2016");
    }

    @Test(description = "Открытие модуля 'Поликлиника'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        page.getHeader().chooseContext("Подразделение поликлиники");
        clinicManager.openClinicPage();
    }

    @Test(description = "Выбор записи и открытие результатов приема", dependsOnMethods = "beforeTest")
    public void step1_1_selectAppointment() {
        clinicManager.getClinicAppointmentPages().filterByDate(clinicAppointmentData.getAdmissionDate());
        clinicManager.getClinicAppointmentPages().clickClinicAppointmentResultAdmission();
        resultAdmissionPage = clinicManager.getResultAdmissionPages();
    }


    @Test(description = "Заполнение полей случая и посещения", dependsOnMethods = "step1_1_selectAppointment")
    public void step1_2_createCaseAndVisit() {
        ResultAdmissionPage resultAdmissionPage = clinicManager.getResultAdmissionPages();
        resultAdmissionPage.clickCreateNewCase();
        resultAdmissionPage.setValueToField(resultAdmissionData);
        resultAdmissionPage.clickSaveCase();

    }

    @Test(description = "АМК", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 1)
    public void step1_3_createMedicalCardPlace() {
        resultAdmissionPage.saveMedicalCard(resultAdmissionData);
        resultAdmissionPage.clickMedicalCardHistory();
        MedicalCardModal medicalCardModal = clinicManager.getMedicalCardModal();
        medicalCardModal.addMedicalCardRowHistory();
        AddMedicalCardHistoryModal addMedicalCardHistoryModal = clinicManager.getAddMedicalCardHistoryModal();
        addMedicalCardHistoryModal.setValues();
        addMedicalCardHistoryModal.clickConfirm();
        medicalCardModal.deleteMedicalCardRowHistory();
        resultAdmissionPage.closeAllModalsOnPage();
    }

    @Test(description = "Добавление услуг", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_4_createServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.clickCreateService();
        ServiceAndProtocolModal serviceAndProtocolModal = clinicManager.getServiceModal();
        serviceAndProtocolModal.setValue();
        serviceAndProtocolModal.clickConfirm();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование услуг", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_5_editServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.getTableService().chooseRowInTable(1);
        resultAdmissionPage.clickUpdateService();
        ServicePage servicePage = clinicManager.getServicePage();
        servicePage.editValue();
        servicePage.clickConfirm();
        servicePage.clickCancel();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление услуг", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_6_deleteServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.getTableService().chooseRowInTable(1);
        resultAdmissionPage.clickDeleteService();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление диагноза", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_7_createDiagnosis() {
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.clickCreateDiagnosisButton();
        ClinicDiagnosisModal clinicDiagnosisModal = clinicManager.getClinicDiagnosisModal();
        clinicDiagnosisModal.setValue();
        clinicDiagnosisModal.clickConfirm();
         resultAdmissionPage.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Редактирование диагноза", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_8_updateDiagnosis() {
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPage.clickUpdateDiagnosis();
        ClinicDiagnosisModal clinicDiagnosisModal = clinicManager.getClinicDiagnosisModal();
        clinicDiagnosisModal.changeValue();
        clinicDiagnosisModal.clickConfirm();
        resultAdmissionPage.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

     @Test(description = "Удаление диагноза", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 2)
    public void step1_9_deleteDiagnosis(){
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPage.clickDeleteDiagnosis();
        resultAdmissionPage.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(1);
    }

   @Test(description = "Добавление направления на услуги", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step1_10_createReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateReferral();
        ReferralServicePage referralServicePage = clinicManager.getReferralPage();
        referralServicePage.setValue();
        referralServicePage.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }
    @Test(description = "Редактирование направления на услуги", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step1_11_updateReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(0);
        resultAdmissionPage.clickUpdateReferral();
        ReferralServicePage referralServicePage = clinicManager.getReferralPage();
        referralServicePage.updateValue();
        referralServicePage.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }
    @Test(description = "Добавление направления на лаб исследования", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step1_12_createLaboratoryReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateLaboratoryReferral();
        LaboratoryReferralModal laboratoryReferralModal = clinicManager.getLaboratoryReferralModal();
        laboratoryReferralModal.setValue();
        laboratoryReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование направления на лаб исследования", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 4)
    public void step1_13_editLaboratoryReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(1);
        resultAdmissionPage.clickUpdateLaboratoryReferral();
        LaboratoryReferralModal laboratoryReferralModal = clinicManager.getLaboratoryReferralModal();
        laboratoryReferralModal.editValue();
        laboratoryReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Добавление направления на госпитализацию", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 4)
    public void step1_14_createHospitalReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateHospReferral();
        HospitalReferralModal hospitalReferralModal = clinicManager.getHospitalReferralModal();
        hospitalReferralModal.setValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }
    @Test(description = "Редактирование направления на госпитализацию", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 4)
    public void step1_15_editHospitalReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(2);
        resultAdmissionPage.clickUpdateHospitalReferral();
        HospitalReferralModal hospitalReferralModal = clinicManager.getHospitalReferralModal();
        hospitalReferralModal.changeValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Удаление всех направлений", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 4)
    public void step1_16_deleteAllReferral(){
        resultAdmissionPage.deleteAllReferral();
    }

    @Test(description = "Добавление Назначения", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 5)
    public void step1_17_createPrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.clickCreatePrescription();
        PrescriptionModal prescriptionModal = clinicManager.getPrescriptionModal();
        prescriptionModal.setValue();
        prescriptionModal.clickConfirm();

    }
    @Test(description = "Редактирование Назначения", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 5)
    public void step1_18_editPrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.clickEditPrescription();
        PrescriptionModal prescriptionModal = clinicManager.getPrescriptionModal();
        prescriptionModal.changeValue();
        prescriptionModal.clickConfirm();
    }
    @Test(description = "Подтверждение Назначения", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 5)
    public void step1_19_confirmPrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.getContainerPrescription().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
        resultAdmissionPage.clickConfirmPrescription();
    }

    @Test(description = "Удаление всех Назначений", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 6)
    public void step1_20_deleteAllPrescription(){
        resultAdmissionPage.deleteAllPrescription();
    }

    @Test(description = "Добавление Рецепта", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 7)
    public void step1_21_createGeneralReceipt() {
        resultAdmissionPage.getTabs().clickTab("#receipt");
        resultAdmissionPage.clickCreateGeneralReceipt();
        ReceiptModal receiptModal = clinicManager.getReceiptModal();
        receiptModal.setValue();
        receiptModal.clickConfirm();
        resultAdmissionPage.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Рецепта", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 7)
    public void step1_22_editGeneralReceipt() {
        resultAdmissionPage.getTabs().clickTab("#receipt");
        resultAdmissionPage.clickEditReceipt();
        ReceiptModal receiptModal = clinicManager.getReceiptModal();
        receiptModal.updateValue();
        receiptModal.clickConfirm();
        resultAdmissionPage.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Удаление всех рецептов", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 8)
    public void step1_23_deleteAllReceipt() {
        resultAdmissionPage.deleteAllReceipt();
    }

/*
    @Test(description = "Добавление заявки ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 8)
    public void step1_24_() {

    }
    @Test(description = "Добавление ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 8)
    public void step1_25_() {

    }
    @Test(description = "Изменение ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 8)
    public void step1_26_() {

    }
    @Test(description = "Удаление ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 8)
    public void step1_27_() {

    }
    */

    @Test(description = "Добавление Справки", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 9)
    public void step1_28_createCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.clickCreateCert();
        CertModal certModal = clinicManager.getCertModal();
        certModal.setValues();
        certModal.clickConfirm();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление Отказа", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 9)
    public void step1_29_createRefusal() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.clickCreateRefusal();
        CertModal certModal = clinicManager.getCertModal();
        certModal.setValues();
        certModal.clickConfirm();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Аннулирование Справки", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 9)
    public void step1_30_annulCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.getTableCert().chooseRowInTable(0);
        resultAdmissionPage.clickAnnuleCert();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Отмена аннулирования", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 9)
    public void step1_31_cancelAnnuledCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.getTableCert().chooseRowInTable(0);
        resultAdmissionPage.clickCancelAnnuledCert();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(2);
    }


    @Test(description = "Закрыть случай", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 9)
    public void step1_32_closeCase() {

        ResultAdmissionPage resultAdmissionPage = clinicManager.getResultAdmissionPages();
        resultAdmissionPage.clickCloseCase();
        CloseCaseModal closeCaseModal = clinicManager.getCloseCaseModal();
        closeCaseModal.setValue();
        closeCaseModal.clickConfirm();
        //resultAdmissionPage.getDialog().getButton(CONFIRM_BUTTON).click();

    }

    @Test(description = "Переоткрыть случай", dependsOnMethods = "step1_32_closeCase", priority = 10)
    public void step1_33_reOpenCase() {
        resultAdmissionPage.clickReopenCase();
    }

    @Test(description = "Переход в Информацию по случаю", dependsOnMethods = "step1_33_reOpenCase", priority = 9)
    public void step1_34_informAboutCase() {
        resultAdmissionPage.clickGoCase();
    }

    @Test(description = "ТАП", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_1_TAP() {
        resultAdmissionPage.getDiagnosTAP().setValue("H50.5 Гетерофория");
        resultAdmissionPage.getDiseaseTypeTAP().setValue("40 - Прочее (для Z00-Z99)");
        resultAdmissionPage.clickSaveTAP();
    }

    @Test(description = "Добавление услуг", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_2_caseCreateServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.clickCreateService();
        ServiceAndProtocolModal serviceAndProtocolModal = clinicManager.getServiceModal();
        serviceAndProtocolModal.setValue();
        serviceAndProtocolModal.clickConfirm();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование услуг", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_3_caseEditServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.getTableService().chooseRowInTable(1);
        resultAdmissionPage.clickUpdateService();
        ServicePage servicePage = clinicManager.getServicePage();
        servicePage.editValue();
        servicePage.clickConfirm();
        servicePage.clickCancel();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление услуг", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_4_caseDeleteServices() {
        resultAdmissionPage.getTabs().clickTab("#service");
        resultAdmissionPage.getTableService().chooseRowInTable(1);
        resultAdmissionPage.clickDeleteService();
        resultAdmissionPage.getContainerServicesAndProtocols().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Добавление диагноза", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_5_caseCreateDiagnosis() {
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.clickCreateDiagnosisButton();
        ClinicDiagnosisModal clinicDiagnosisModal = clinicManager.getClinicDiagnosisModal();
        clinicDiagnosisModal.setValue();
        clinicDiagnosisModal.clickConfirm();
        resultAdmissionPage.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование диагноза", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_6_caseUpdateDiagnosis() {
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.getTableDiagnosis().chooseRowInTable(1);  // TODO: 13.08.2016 изменить на 0 после исправления бага с предварительным диагнозом
        resultAdmissionPage.clickUpdateDiagnosis();
        ClinicDiagnosisModal clinicDiagnosisModal = clinicManager.getClinicDiagnosisModal();
        clinicDiagnosisModal.changeValue();
        clinicDiagnosisModal.clickConfirm();
        resultAdmissionPage.getContainerDiagnosis().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "Удаление диагноза", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_7_caseDeleteDiagnosis(){
        resultAdmissionPage.getTabs().clickTab("#diagnosis");
        resultAdmissionPage.getTableDiagnosis().chooseRowInTable(0);
        resultAdmissionPage.clickDeleteDiagnosis();
    }
    @Test(description = "Добавление направления на услуги", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_8_caseCreateReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateReferral();
        ReferralServicePage referralServicePage = clinicManager.getReferralPage();
        referralServicePage.setValue();
        referralServicePage.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }
    @Test(description = "Редактирование направления на услуги", dependsOnMethods = "step1_34_informAboutCase", priority = 1)
    public void step2_9_caseUpdateReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(0);
        resultAdmissionPage.clickUpdateReferral();
        ReferralServicePage referralServicePage = clinicManager.getReferralPage();
        referralServicePage.updateValue();
        referralServicePage.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(1);
    }
    @Test(description = "Добавление направления на лаб исследования", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_10_caseCreateLaboratoryReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateLaboratoryReferral();
        LaboratoryReferralModal laboratoryReferralModal = clinicManager.getLaboratoryReferralModal();
        laboratoryReferralModal.setValue();
        laboratoryReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Редактирование направления на лаб исследования", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_11_caseEditLaboratoryReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(1);
        resultAdmissionPage.clickUpdateLaboratoryReferral();
        LaboratoryReferralModal laboratoryReferralModal = clinicManager.getLaboratoryReferralModal();
        laboratoryReferralModal.editValue();
        laboratoryReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(2);
    }
    @Test(description = "Добавление направления на госпитализацию", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_12_caseCreateHospitalReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.clickCreateHospReferral();
        HospitalReferralModal hospitalReferralModal = clinicManager.getHospitalReferralModal();
        hospitalReferralModal.setValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }
    @Test(description = "Редактирование направления на госпитализацию", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_13_caseEditHospitalReferral() {
        resultAdmissionPage.getTabs().clickTab("#referral");
        resultAdmissionPage.getTableReferral().chooseRowInTable(2);
        resultAdmissionPage.clickUpdateHospitalReferral();
        HospitalReferralModal hospitalReferralModal = clinicManager.getHospitalReferralModal();
        hospitalReferralModal.changeValue();
        hospitalReferralModal.clickConfirm();
        resultAdmissionPage.getContainerReferral().getTable().assertThatCountOfRowsIs(3);
    }
    @Test(description = "Удаление всех направлений", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_14_caseDeleteAllReferral(){
        resultAdmissionPage.deleteAllReferral();
    }

    @Test(description = "Добавление Назначения", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_15_caseCreatePrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.clickCreatePrescription();
        PrescriptionModal prescriptionModal = clinicManager.getPrescriptionModal();
        prescriptionModal.setValue();
        prescriptionModal.clickConfirm();
    }
    @Test(description = "Редактирование Назначения", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_16_caseEditPrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.clickEditPrescription();
        PrescriptionModal prescriptionModal = clinicManager.getPrescriptionModal();
        prescriptionModal.changeValue();
        prescriptionModal.clickConfirm();

    }
    @Test(description = "Подтверждение Назначения", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_17_caseConfirmPrescription() {
        resultAdmissionPage.getTabs().clickTab("#prescription");
        resultAdmissionPage.getContainerPrescription().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
        resultAdmissionPage.clickConfirmPrescription();
    }

    @Test(description = "Удаление всех Назначений", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_18_caseDeleteAllPrescription(){
        resultAdmissionPage.deleteAllPrescription();
    }

    @Test(description = "Добавление Рецепта", dependsOnMethods = "step1_34_informAboutCase", priority = 2)
    public void step2_19_caseCreateGeneralReceipt() {
        resultAdmissionPage.getTabs().clickTab("#receipt");
        resultAdmissionPage.clickCreateGeneralReceipt();
        ReceiptModal receiptModal = clinicManager.getReceiptModal();
        receiptModal.setValue();
        receiptModal.clickConfirm();
        resultAdmissionPage.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Редактирование Рецепта", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_20_caseEditGeneralReceipt() {
        resultAdmissionPage.getTabs().clickTab("#receipt");
        resultAdmissionPage.clickEditReceipt();
        ReceiptModal receiptModal = clinicManager.getReceiptModal();
        receiptModal.updateValue();
        receiptModal.clickConfirm();
        resultAdmissionPage.getContainerReceipt().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "Удаление всех рецептов", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_21_caseDeleteAllReceipt() {
        resultAdmissionPage.deleteAllReceipt();
    }

    /*
    @Test(description = "Добавление заявки ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step2_22_() {

    }
    @Test(description = "Добавление ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step2_23_() {

    }
    @Test(description = "Изменение ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step2_24_() {

    }
    @Test(description = "Удаление ЛН", dependsOnMethods = "step1_2_createCaseAndVisit", priority = 3)
    public void step2_25_() {

    }
    */
    @Test(description = "Добавление Справки", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_26_caseCreateCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.clickCreateCert();
        CertModal certModal = clinicManager.getCertModal();
        certModal.setValues();
        certModal.clickConfirm();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(3);
    }

    @Test(description = "Добавление Отказа", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_27_caseCreateRefusal() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.clickCreateRefusal();
        CertModal certModal = clinicManager.getCertModal();
        certModal.setValues();
        certModal.clickConfirm();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }
    @Test(description = "Аннулирование Справки", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_28_caseAnnulStomCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.getTableCert().chooseRowInTable(2);
        resultAdmissionPage.clickAnnuleCert();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }
    @Test(description = "Отмена аннулирования", dependsOnMethods = "step1_34_informAboutCase", priority = 3)
    public void step2_29_caseCancelAnnuledCert() {
        resultAdmissionPage.getTabs().clickTab("#cert");
        resultAdmissionPage.getTableCert().chooseRowInTable(2);
        resultAdmissionPage.clickCancelAnnuledCert();
        resultAdmissionPage.getContaineСlinicCert().getTable().assertThatCountOfRowsIs(4);
    }

    @Test(description = "Отменить посещение", dependsOnMethods = "step1_34_informAboutCase", priority = 4 , alwaysRun = true)
    public void step2_30_removeVisit() {
        clinicManager.openClinicPage();
        ClinicAppointmentPages clinicAppointmentPages = clinicManager.getClinicAppointmentPages();
        clinicAppointmentPages.filterByDate(clinicAppointmentData.getAdmissionDate());
        clinicAppointmentPages.clickCancelVisit();
        //clinicAppointmentPages.clickCancelAppointmen();

    }
}


