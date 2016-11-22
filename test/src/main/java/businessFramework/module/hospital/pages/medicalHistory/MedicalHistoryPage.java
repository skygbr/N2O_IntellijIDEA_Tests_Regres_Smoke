package businessFramework.module.hospital.pages.medicalHistory;


import base.components.Diagnosis;
import businessFramework.entities.hospital.*;
import businessFramework.entities.hospital.prescription.PrescriptionCancelData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionServiceData;
import businessFramework.entities.hospital.prescription.PrescriptionStatus;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplatePrescriptionData;
import businessFramework.module.hospital.modals.diagnosis.DiagnosisModal;
import businessFramework.module.hospital.modals.discharge.DischargeModal;
import businessFramework.module.hospital.modals.hospitalizationInfo.HospitalizationInfoPage;
import businessFramework.module.hospital.modals.prescription.PrescriptionByTemplateModal;
import businessFramework.module.hospital.modals.prescription.PrescriptionCancelModal;
import businessFramework.module.hospital.modals.prescription.PrescriptionServiceModal;
import businessFramework.module.hospital.modals.service.operation.PlannedOperationModal;
import businessFramework.module.hospital.modals.prescription.PrescriptionModal;
import businessFramework.module.hospital.modals.prescriptionRead.PrescriptionReadModal;
import businessFramework.module.hospital.modals.service.ServiceByTemplateModal;
import businessFramework.module.hospital.modals.sicklist.SickListIssuedAnotherClinicModal;
import businessFramework.module.hospital.modals.treatmentPlan.TreatmentPlanModal;
import businessFramework.module.hospital.pages.service.ServicePage;
import businessFramework.module.hospital.pages.service.operation.AddResultToOperationPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import test.smoke.ErrorsSearchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MedicalHistoryPage extends MedicalHistoryHelper {
    public MedicalHistoryPage(ApplicationManager app) {
        super(app);
    }

    public DiagnosisModal getDiagnosisModal() {
        return new DiagnosisModal();
    }

    public PrescriptionModal getPrescriptionModal() {
        return new PrescriptionModal(app);
    }

    public PrescriptionByTemplateModal getPrescriptionByTemplateModal() {
        return new PrescriptionByTemplateModal(app);
    }

    public PrescriptionReadModal getPrescriptionReadModal() {
        return new PrescriptionReadModal(app);
    }

    public DischargeModal getDischargeModal() {
        return new DischargeModal();
    }

    public TreatmentPlanModal getTreatmentPlanModal() {
        return new TreatmentPlanModal();
    }

    public ServiceByTemplateModal getServiceByTemplateModal() {
        return new ServiceByTemplateModal();
    }

    public PlannedOperationModal getPlannedOperationModal() {
        return new PlannedOperationModal();
    }

    public AddResultToOperationPage getAddResultToOperationPage() {
        return new AddResultToOperationPage(app);
    }

    public ServicePage getServicePage()
    {
        return new ServicePage(app);
    }

    public PrescriptionServiceModal getPrescriptionServiceModal() {
        return new PrescriptionServiceModal();
    }
    public PrescriptionCancelModal getPrescriptionCancelModal() {
        return new PrescriptionCancelModal();
    }

    public SickListIssuedAnotherClinicModal getSickListIssuedAnotherClinicModal() {
        return new SickListIssuedAnotherClinicModal();
    }

    public HospitalizationInfoPage getHospitalizationInfoModal() {
        return new HospitalizationInfoPage("hospitalizationInfo");
    }

    public MedicalHistoryFilter getFilter() {
        return new MedicalHistoryFilter(app);
    }

    public void assertPatientData(HospitalData hospitalData) {
        getPatientName().assertFieldText(hospitalData.getPatient());
    }

    public void assertMedicalData(HospitalData hospitalData) {
        getUid().assertFieldText(hospitalData.getUid());
        getFinancialType().assertFieldText(hospitalData.getFinancialType());
        getDepartment().assertFieldText(hospitalData.getDepartment());
        getDiagnosisName().assertFieldText(hospitalData.getDiagnosis());
    }

    public void assertCountDiagnosis(int count) {
        this.getContainerDiagnosisList().clickContainer();
        assertThat(String.format("Diagnosis in table doesn't equal %s", count),
                this.getDiagnosisCount(), is(count));
    }

    public void assertCountServices(int count) {
        this.getContainerServices().clickContainer();
        assertThat(String.format("Count services in table doesn't equal %s", count),
                this.getServiceCount(), is(count));
    }

    public void assertCountSendToDepartment(int count) {
        this.getContainerHospitalRecords().clickContainer();
        assertThat(String.format("Count send to department in table doesn't equal %s", count),
                this.getSendToDepartmentCount(), is(count));
    }

    public void assertCountSendToBed(int count) {
        this.getContainerBedList().clickContainer();
        assertThat(String.format("Count sent to bed in table doesn't equal %s", count),
                this.getSendToBed(), is(count));
    }

    public void assertCountTreatmentPlans(int count) {
        this.getContainerTreatmentPlanList().clickContainer();
        assertThat(String.format("Количество планов лечения не соответствует ожидаемому(%s)", count),
                this.getTreatmentPlanCount(), is(count));
    }

    public void deleteAllDiagnosis() {
        this.getContainerDiagnosisList().clickContainer();
        while (getContainerDiagnosisList().getTable().getCountRowsInTable(true) > 0) {
            getContainerDiagnosisList().getTable().chooseRowInTable(0);
            clickDeleteDiagnosis();
            getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        }
    }

    public void deleteAllTreatmentPlans() {
        this.getContainerTreatmentPlanList().clickContainer();
        while (getContainerTreatmentPlanList().getTable().getCountRowsInTable(true) > 0) {
            getContainerTreatmentPlanList().getTable().chooseRowInTable(0);
            clickDeleteTreatmentPlan();
            getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        }
    }

    public void deleteAllPrescriptions() {
        this.getContainerPrescriptionList().clickContainer();
        this.findAllPrescriptions();
        while (getContainerPrescriptionList().getTable().getCountRowsInTable(true) > 0) {
            getContainerPrescriptionList().getTable().chooseRowInTable(0);
            clickDeletePrescription();
            getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        }
    }

    public void deleteChosenPrescription(PrescriptionData prescriptionData) {
        choosePrescription(prescriptionData);
        clickDeletePrescription();
        getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void findAllPrescriptions() {
        getContainerPrescriptionList().clickContainer();
        this.getContainerPrescriptionList().showFilter();
        this.getContainerPrescriptionList().getFilter().getInputCheckBox("all").check(true);
        this.getContainerPrescriptionList().getFilter().clickFindButton();
    }

    public void clickCreateDiagnosis() {
        clickButtonOpeningModal(getCreateDiagnosisButton(), "Диагнозы");
    }

    public void clickUpdateDiagnosis() {
        clickButtonOpeningModal(getEditDiagnosisButton(), "Диагнозы");
    }

    public void clickUpdateHospitalRecord() {
        clickButtonOpeningModal(getUpdateHospitalRecordButton(), "Движение по отделениям");
    }

    public void clickCreatePrescription() {
        getContainerPrescriptionList().clickDropdown("Добавить", "Назначение", "prescription");
    }

    public void clickCreatePrescriptionByTemplate() {
        getContainerPrescriptionList().clickDropdown("Добавить", "По шаблону", "prescriptionByTemplate");
    }

    public void clickEditPrescription() {
        clickButtonOpeningModal(getEditPrescriptionButton(), "Лекарственное назначение");
    }

    public void clickCopyPrescription() {
        clickButtonOpeningModal(getCopyPrescriptionButton(), "Лекарственное назначение");
    }

    public void clickReadPrescription() {
        clickButtonOpeningModal(getReadPrescriptionButton(), "Просмотр лекарственного назначения");
    }

    public void clickConfirmPrescription() {
        Button button = getConfirmPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(false);
    }

    public void clickDeletePrescription() {
        Button button = getDeletePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
        assertModalPresentOnPage(false);
    }

    public void clickCancelPrescription() {
        Button button = getCancelPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
    }

    public void clickResumePrescription() {
        Button button = getResumePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(false);
    }

    public void clickProlongPrescription() {
        Button button = getProlongPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
    }

    public void createDiagnosis(DiagnosisData diagnosisData) {
        getContainerDiagnosisList().clickContainer();
        clickCreateDiagnosis();
        getDiagnosisModal().fillDiagnosisFormList(diagnosisData);
        getDiagnosisModal().clickSaveDiagnosis();
    }

    public void updateDiagnosis(DiagnosisData diagnosisData) {
        clickUpdateDiagnosis();
        getDiagnosisModal().fillDiagnosisFormList(diagnosisData);
        getDiagnosisModal().clickSaveDiagnosis();
        clickUpdateDiagnosis();
        getDiagnosisModal().assertFormList(diagnosisData);
        getModal().closeModal();
    }

    public void assertValidationOnUpdateClosedCase_diagnosis() {
        getContainerDiagnosisList().clickContainer();
        clickUpdateDiagnosis();
        getDiagnosisModal().fillNoteFieldOnForm("тест");
        getDiagnosisModal().getSaveDiagnosisButton().click();
        assertValidationOnUpdateClosedCaseMessage();
    }

    public void assertValidationOnUpdateClosedCase_department(List<String> diagnosisTree) {
        getContainerHospitalRecords().clickContainer();
        clickUpdateHospitalRecord();
        new Diagnosis(app, getModal().getForm().getFormElement(), "diagnosis").setValue(diagnosisTree);
        getModal().getButton(N2O_CONFIRM_BUTTON).click();
        assertValidationOnUpdateClosedCaseMessage();
    }

    private void assertValidationOnUpdateClosedCaseMessage() {
        getModal().getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE_ON_UPDATE_CLOSED_CASE);
        getModal().closeModal();
    }

    public void createTreatmentPlan(TreatmentPlanData data) {
        getContainerTreatmentPlanList().clickContainer();
        clickButtonOpeningModal(getCreateTreatmentPlanButton(), "Добавить курс химиотерапии");
        getTreatmentPlanModal().fillForm(data);
        getTreatmentPlanModal().clickSaveButton();
    }

    public void assertTreatmentPlan(TreatmentPlanData data) {
        getContainerTreatmentPlanList().clickContainer();
        clickButtonOpeningModal(getUpdateTreatmentPlanButton(), "Редактировать курс химиотерапии");
        getTreatmentPlanModal().assertForm(data, false);
        getTreatmentPlanModal().clickCancelButton();
        assertModalPresentOnPage(false);
    }

    public void updateTreatmentPlan(TreatmentPlanData data) {
        clickButtonOpeningModal(getUpdateTreatmentPlanButton(), "Редактировать курс химиотерапии");
        getTreatmentPlanModal().fillForm(data);
        getTreatmentPlanModal().clickSaveButton();
        assertModalPresentOnPage(false);
    }

    public void viewTreatmentPlan(TreatmentPlanData data) {
        clickButtonOpeningModal(getViewTreatmentPlanButton(), "Курс химиотерапии");
        getTreatmentPlanModal().assertForm(data, true);
        getModal().closeModal();
        assertModalPresentOnPage(false);
    }

    public void createPrescription(PrescriptionData prescriptionData) {
        getContainerPrescriptionList().clickContainer();
        if (getContainerPrescriptionList().getTable().getCountRowsInTable(true) == 0)
            assertPrescriptionActionButtons(0);

        getContainerPrescriptionList().clickContainer();
        clickCreatePrescription();
        getPrescriptionModal().fillPrescriptionForm(prescriptionData);
        getPrescriptionModal().getConfirmButton().click();
        assertModalPresentOnPage(false);
        getContainerPrescriptionList().getTable().assertThatCountOfRowsIs(1);
        prescriptionData.setStatusId(PrescriptionStatus.WAIT_CONFIRMATION.getId());

        assertPrescriptionActionButtons(prescriptionData.getStatusId());

    }

    public void copyPrescription(PrescriptionData prescriptionData, PrescriptionData prescriptionData_copy) {
        getContainerPrescriptionList().clickContainer();
        choosePrescription(prescriptionData);
        clickCopyPrescription();
        getPrescriptionModal().assertPrescriptionForm(prescriptionData, true);
        getPrescriptionModal().fillPrescriptionCopyForm(prescriptionData_copy);
        getPrescriptionModal().getConfirmButton().click();
        getContainerPrescriptionList().getTable().assertThatCountOfRowsIs(2);
        prescriptionData_copy.setStatusId(PrescriptionStatus.WAIT_CONFIRMATION.getId());
    }

    public void readPrescription(PrescriptionData prescriptionData) {
        choosePrescription(prescriptionData);
        clickReadPrescription();
        getPrescriptionReadModal().assertPrescriptionInfo(prescriptionData);
        getPrescriptionReadModal().assertScheduleList(prescriptionData);
    }

    public void confirmPrescription(PrescriptionData prescriptionData) {
        choosePrescription(prescriptionData);
        clickConfirmPrescription();
        prescriptionData.setStatusId(PrescriptionStatus.SCHEDULED.getId());

        assertPrescriptionActionButtons(prescriptionData.getStatusId());
        assertStatus(prescriptionData);
    }

    public void assertPrescriptionStatus(PrescriptionData prescriptionData) {
        choosePrescription(prescriptionData);
        assertStatus(prescriptionData);
    }

    public void cancelPrescription(PrescriptionData prescriptionData) {
        choosePrescription(prescriptionData);
        clickCancelPrescription();
        getModal().assertModalHeader_equal("Отмена");
        getModal().getForm().getInputDate("cancelDt").assertValue_contains(getCurrentDate());
        getModal().getForm().getInputText("cancelReason").setValue("Отмена тест");
        Button btn = getModal().getContainer("main").getButton(N2O_CONFIRM_BUTTON);
        btn.assertIsEnabled();
        btn.click();
        assertModalPresentOnPage(false);
        prescriptionData.setStatusId(PrescriptionStatus.CANCELLED.getId());

        assertPrescriptionActionButtons(prescriptionData.getStatusId());
        assertRowColumnValue("Статус", "Отменено");
    }

    public void resumePrescription(PrescriptionData prescriptionData) {
        clickResumePrescription();
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

        assertPrescriptionActionButtons(prescriptionData.getStatusId());
        assertStatus(prescriptionData);
    }

    public void prolongPrescription(PrescriptionData prescriptionData) {
        clickProlongPrescription();
        getModal().assertModalHeader_equal("Продлить");
        getModal().getForm().getInputText("dayCount").setValue("1");
        Button btn = getModal().getContainer("main").getButton(N2O_CONFIRM_BUTTON);
        btn.assertIsEnabled();
        btn.click();
        assertModalPresentOnPage(false);
        prescriptionData.setStatusId(PrescriptionStatus.PERFORM.getId());

        assertPrescriptionActionButtons(prescriptionData.getStatusId());
        assertStatus(prescriptionData);
        assertRowColumnValue("Период по", getDateBeforeAfterCurrent(1));
    }

    private void assertStatus(PrescriptionData prescriptionData) {
        int index = getContainerPrescriptionList().getTable().getChosenRowNumber();
        Map<String, String> map = new HashMap<>();
        map.put("Статус", prescriptionData.getStatusName());
        getContainerPrescriptionList().getTable().assertThatRowColumnsIntersectionValueContains(index, map);
    }

    private void assertRowColumnValue(String columnName, String expectedText) {
        int index = getContainerPrescriptionList().getTable().getChosenRowNumber();
        Map<String, String> map = new HashMap<>();
        map.put(columnName, expectedText);
        getContainerPrescriptionList().getTable().assertThatRowColumnsIntersectionValueContains(index, map);
    }

    public void clickDeleteDiagnosis() {
        Button button = getDeleteDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickDeleteTreatmentPlan() {
        Button button = getDeleteTreatmentPlanButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }


    public void clickDischarge() {
        clickButtonOpeningModal(getDischargeButton(), "Выписать");
    }

    public void clickEditDischarge() {
        clickButtonOpeningModal(getEditDischargeButton(), "Выписать");
    }

    public void clickCancelDischarge() {
        Button button = getCancelDischargeButton();
        button.assertIsEnabled();
        button.click();
        getDialog().assertGeneralMessageContainsText("Вы уверены, что хотите переоткрыть случай ?");
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickDeleteHospitalRecord() {
        Button button = getDeleteHospitalRecordButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
    }

    public void deleteLastHospitalRecord() {
        getContainerHospitalRecords().clickContainer();
        int lastRecord = getContainerHospitalRecords().getTable().getCountRowsInTable(true);
        getContainerHospitalRecords().getTable().chooseRowInTable(lastRecord - 1);
        clickDeleteHospitalRecord();
    }

    public void discharge(DischargeData hospitalData) {
        getContainerHospitalRecords().clickContainer();
        clickDischarge();
        getDischargeModal().fillDischargeForm(hospitalData);
        getDischargeModal().clickSave();
        getContainerHospitalRecords().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void editDischarge(DischargeData savedDischargeData, DischargeData newDischargeData) {
        clickEditDischarge();
        getDischargeModal().assertForm(savedDischargeData);
        getDischargeModal().fillDischargeForm(newDischargeData);
        getDischargeModal().clickSave();
        //getModal().getAlerts().assertSuccessAlertIsPresent();  //todo сообщение об успешном сохранении исчезает раньше, чем проходит загрузка
        closeAllModalsOnPage();

        clickEditDischarge();
        getDischargeModal().assertForm(newDischargeData);
        getModal().closeModal();
    }


    public void cancelDischargeWithClearDeathDataAssertion() {
        clickCancelDischarge();
        getContainerHospitalRecords().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void assertPhysicalServiceExists(String columnName, String bdate) {
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put(columnName, bdate);
        getContainerServices().getTable().getRowNumberBySeveralColumnValues(columnValues, true);
    }

    public void assertPrescription(PrescriptionData prescriptionData) {
        getContainerPrescriptionList().clickContainer();
        choosePrescription(prescriptionData);
        clickEditPrescription();
        getPrescriptionModal().assertPrescriptionForm(prescriptionData, false);
    }

    public void updatePrescription(PrescriptionData prescriptionData) {
        getPrescriptionModal().updateCommentField(prescriptionData);
        assertModalPresentOnPage(false);
        prescriptionData.setStatusId(PrescriptionStatus.WAIT_CONFIRMATION.getId());
        getContainerPrescriptionList().getTable().assertThatCountOfRowsIs(1);
        assertStatus(prescriptionData);
    }

    private void choosePrescription(PrescriptionData prescriptionData) {
        Map<String, String> map = new HashMap<>();
        map.put("Условия", prescriptionData.getVisitTerm());
        map.put("Период с", prescriptionData.getPeriodBeginDt().substring(0, 10));
        map.put("Период по", prescriptionData.getPeriodEndDt().substring(0, 10));
        int index = getContainerPrescriptionList().getTable().getRowNumberBySeveralColumnValues(map, true);
        getContainerPrescriptionList().getTable().chooseRowInTable(index);
        assertStatus(prescriptionData);
    }


    //Добавление услуг по шаблону
    public void createServiceByTemplate(ServiceRenderedByTemplateData data) {
        getContainerPlannedAndRenderedServiceList().clickContainer();
        int sizeBeforeAdd = getContainerPlannedAndRenderedServiceList().getTable().getCountRowsInTable(true);
        int sizeAfterAdd = sizeBeforeAdd + data.getServiceNameList().size();
        clickButtonOnDropDown(getCreateServiceByTemplateButton());
        getServiceByTemplateModal().fillServiceByTemplateForm(data);
        getServiceByTemplateModal().clickAssign();
        getServiceByTemplateModal().checkServiceCheckboxGridForCreate(data);
        getModal().closeModal();
        getContainerPlannedAndRenderedServiceList().getTable().assertThatCountOfRowsIs(sizeAfterAdd);
    }

    public String getAdmissionDateFromHistoryMainData() {
         return getContainer("medicalHistoryContainerForm").getForm().getOutputText("admissionDate").getText().trim();
    }

    //Отмена
    public void cancel(ServiceRenderedByTemplateData data) {
        int rowSize = getContainerPlannedAndRenderedServiceList().getTable().getCountRowsInTable(true);
        clickButtonOnDropDown(getCreateServiceByTemplateButton());
        getServiceByTemplateModal().fillServiceByTemplateForm(data);
        getServiceByTemplateModal().clickAssign();

        getServiceByTemplateModal().unSelectServices(data);
        getServiceByTemplateModal().clickCancel();

        getServiceByTemplateModal().checkServiceCheckboxGridForCancel(data);
        getModal().closeModal();
        getContainerPlannedAndRenderedServiceList().getTable().assertThatCountOfRowsIs(rowSize);
    }

    public void clickButtonOnDropDown(Button button) {
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
    }

    public void deletePlannedServices() {
        deleteAllServices(getDeletePlannedServiceList());
    }

    public void deleteRenderedServices() {
        deleteAllServices(getDeleteRenderedServiceList());
    }

    private void deleteAllServices(Button button) {
        this.getContainerPlannedAndRenderedServiceList().clickContainer();
        while (getContainerPlannedAndRenderedServiceList().getTable().getCountRowsInTable(true) > 0) {
            getContainerPlannedAndRenderedServiceList().getTable().chooseRowInTable(0);
            clickDeleteService(button);
            getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        }
    }

    public void clickDeleteService(Button button) {
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void assertPrescriptionActionButtons(int statusId) {
        getCopyPrescriptionButton().assertIsDisplayed(true);

        if (statusId != 0)
            getCopyPrescriptionButton().assertIsEnabled();
        else
            getCopyPrescriptionButton().assertIsDisabled();

        getDeletePrescriptionButton().assertIsDisplayed(statusId == 1 || statusId == 2);
        getConfirmPrescriptionButton().assertIsDisplayed(statusId == 1);
        getReadPrescriptionButton().assertIsDisplayed(statusId > 1 && statusId < 6);
        getResumePrescriptionButton().assertIsDisplayed(statusId == 5);
        getProlongPrescriptionButton().assertIsDisplayed(statusId == 3);
        getCancelPrescriptionButton().assertIsDisplayed(statusId == 3);
    }


    //    Добавление больничного листа
    public void createSickListIssuedAnotherClinic(SickListIssuedAnotherClinicData sickListData) {
        getContainerSickList().clickContainer();
        clickButtonOpeningModal(getSickListIssuedAnotherClinicButton(), "Выдан в другом МО");
        getSickListIssuedAnotherClinicModal().fillForm(sickListData);
        getSickListIssuedAnotherClinicModal().clickSave();
        getContainerSickList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void updateSickListIssuedAnotherClinic(SickListIssuedAnotherClinicData sickListDataOld,
                                                  SickListIssuedAnotherClinicData sickListDataNew) {
        clickButtonOpeningModal(getEditSickListButton(), "Выдан в другом МО");
        getSickListIssuedAnotherClinicModal().assertForm(sickListDataOld);
        getSickListIssuedAnotherClinicModal().fillForm(sickListDataNew);
        getSickListIssuedAnotherClinicModal().clickSave();
//        getContainerSickList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteSickListIssuedAnotherClinic() {
        Button button = getDeleteSickListButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
    }

    //Информация о госпитализации
    public void updateHospitalizationInfo(HospitalData hospitalData)
    {
        getContainerHospitalizationInfo().clickContainer();
        Boolean status = getHospitalizationInfoModal().getNeedSickListCheckBox().getCheckBoxStatus();
        getHospitalizationInfoModal().getNeedSickListCheckBox().check(!status);

        getHospitalizationInfoModal().getCareProvidingForm().setValue(hospitalData.getCareProvidingForm());
        if ("экстренная".equals(hospitalData.getCareProvidingForm().toLowerCase().trim())) {
            getHospitalizationInfoModal().getDrunkennessType().assertIsHidden(false);
            getHospitalizationInfoModal().getDrunkennessType().setValue(hospitalData.getDrunkennessType());

            if("наркотическое".equals(hospitalData.getDrunkennessType().toLowerCase().trim())){
                getHospitalizationInfoModal().getNarcoticSubstance().assertIsHidden(false);
                getHospitalizationInfoModal().getNarcoticSubstance().setValue(hospitalData.getNarcoticSubstance());

                getHospitalizationInfoModal().getWhereFromDelivered().assertIsHidden(false);
                getHospitalizationInfoModal().getWhereFromDelivered().setValue(hospitalData.getWhereFromDelivered());
            } else {
                getHospitalizationInfoModal().getNarcoticSubstance().assertIsHidden(true);
                getHospitalizationInfoModal().getWhereFromDelivered().assertIsHidden(true);
            }
        } else {
            getHospitalizationInfoModal().getDrunkennessType().assertIsHidden(true);
            getHospitalizationInfoModal().getNarcoticSubstance().assertIsHidden(true);
            getHospitalizationInfoModal().getWhereFromDelivered().assertIsHidden(true);
        }

        getHospitalizationInfoModal().save();

        getContainerHospitalizationInfo().getForm().getAlerts().assertSuccessAlertIsPresent();
        getHospitalizationInfoModal().getNeedSickListCheckBox().assertThatCheckboxIsChecked(!status);
    }

    public void assertHospitalizationInfoForm(HospitalData hospitalData)
    {
        if ("экстренная".equals(hospitalData.getCareProvidingForm().toLowerCase().trim())) {

            getHospitalizationInfoModal().getDrunkennessType().assertIsHidden(false);
            getHospitalizationInfoModal().getDrunkennessType().assertValue_equals(hospitalData.getDrunkennessType());

            if ("наркотическое".equals(hospitalData.getDrunkennessType().toLowerCase().trim())) {
                getHospitalizationInfoModal().getNarcoticSubstance().assertIsHidden(false);
                getHospitalizationInfoModal().getNarcoticSubstance().assertValue(hospitalData.getNarcoticSubstance());

                getHospitalizationInfoModal().getWhereFromDelivered().assertIsHidden(false);
                getHospitalizationInfoModal().getWhereFromDelivered().assertValue(hospitalData.getWhereFromDelivered());
            }
        } else {
            getHospitalizationInfoModal().getDrunkennessType().assertIsHidden(true);
            getHospitalizationInfoModal().getNarcoticSubstance().assertIsHidden(true);
            getHospitalizationInfoModal().getWhereFromDelivered().assertIsHidden(true);
        }
    }
    //Движение по отделениям
    public void sendToDepartment() {
        getContainerHospitalRecords().clickContainer();
    }

    public void deleteAllSendToDepartment() {
        ErrorsSearchers errorsSearchers = new ErrorsSearchers();

        while (getContainerHospitalRecords().getTable().getCountRowsInTable(true) > 1) {
            int rowsCount = getContainerHospitalRecords().getTable().getCountRowsInTable(true);
            getContainerHospitalRecords().getTable().chooseRowInTable(rowsCount - 1);
            clickDeleteSendToDepartment();
            assertThat("Page have error message" + errorsSearchers.isErrorPresentsByContainerId("hospitalRecordList"), errorsSearchers.isErrorPresentsByContainerId("hospitalRecordList"), equalTo(""));
        }
    }

    public void clickDeleteSendToDepartment() {
        Button button = getDeleteHospitalButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    //Операции

    public void createPlannedOperation(OperationServiceData data) {
        getContainerPlannedAndRenderedServiceList().clickContainer();
        clickButtonOnDropDown(getCreatePlannedOperationButton());
        getPlannedOperationModal().fillForm(data);
        getPlannedOperationModal().clickConfirmButton();
//        getContainerPlannedAndRenderedServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void updatePlannedOperation(OperationServiceData oldData, OperationServiceData newData) {
        getContainerPlannedAndRenderedServiceList().clickContainer();
        clickButtonOpeningModal(getUpdatePlannedOperationButton(), "Направление на операцию");
        getPlannedOperationModal().assertForm(oldData);
        getPlannedOperationModal().fillForm(newData);
        getPlannedOperationModal().clickConfirmButton();
//        getContainerPlannedAndRenderedServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void addResultToOperationClick()
    {
        Button button = getCreateRenderedOperationButton();
        button.assertIsEnabled();
        button.click();
    }

    //Назначения
    public void createPrescriptionService(PrescriptionServiceData data) {
        getPrescriptionServiceList().clickContainer();
        getPrescriptionServiceList().showFilter();
        getPrescriptionServiceList().getFilter().getInputCheckBox("all").check(true);
        getPrescriptionServiceList().getFilter().clickFindButton();

        clickButtonOpeningModal(getCreatePrescriptionServiceButton(), "Назначение");
        getPrescriptionServiceModal().fillForm(data);
        getPrescriptionServiceModal().clickConfirmButton();
        getPrescriptionServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
        getPrescriptionServiceList().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
    }

    public void updatePrescriptionService(PrescriptionServiceData data1, PrescriptionServiceData data2) {
        clickButtonOpeningModal(getUpdatePrescriptionServiceButton(), "Назначение");
        getPrescriptionServiceModal().assertForm(data1);
        getPrescriptionServiceModal().fillForm(data2);
        getPrescriptionServiceModal().clickConfirmButton();
        getPrescriptionServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void confirmPrescriptionService(PrescriptionServiceData data2) {
        getConfirmPrescriptionServiceButton().assertIsDisplayed(true);
        getConfirmPrescriptionServiceButton().click();
        getPrescriptionServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
        getPrescriptionServiceList().getTable().assertColumnValuesIs("Статус", "Запланировано");
        getConfirmPrescriptionServiceButton().assertIsDisplayed(false);
        getCancelPrescriptionServiceButton().assertIsDisplayed(false);
    }

    public void deletePrescriptionService() {
        deleteAllServices(getDeleteRenderedServiceList());
        getPrescriptionServiceList().clickContainer();
        getPrescriptionServiceList().getTable().assertColumnValuesIs("Статус", "Ожидает подтверждения");
        getDeletePrescriptionServiceButton().assertIsEnabled();
        getDeletePrescriptionServiceButton().click();
        getDialog().clickYes();
        getPrescriptionServiceList().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void cancelPrescriptionService(PrescriptionCancelData prescriptionCancelData, String service) {
        clickButtonOpeningModal(getCancelPrescriptionServiceButton(), "Отмена");
        getPrescriptionCancelModal().cancel(prescriptionCancelData);
        getPrescriptionServiceList().getTable().assertColumnValuesIs("Статус", "Отменено");
    }

    public void checkPlannedServiceListAfterConfirmPrescription(PrescriptionServiceData data)
    {
        getContainerPlannedAndRenderedServiceList().clickContainer();
        getContainerPlannedAndRenderedServiceList().showFilter();
        getContainerPlannedAndRenderedServiceList().getFilter().getInputCheckBox("createdByPrescription").check(true);
        getContainerPlannedAndRenderedServiceList().getFilter().clickFindButton();
        getContainerPlannedAndRenderedServiceList().getTable().assertThatCountOfRowsIs(Integer.parseInt(data.getCount()));
    }

    public void checkPrescriptionServiceListAfterRenderService(PrescriptionServiceData data)
    {
        getContainerPlannedAndRenderedServiceList().getTable().chooseRowInTable(0);

        getCreateRenderedButton().assertIsEnabled();
        getCreateRenderedButton().click();
        getServicePage().checkPrescriptionServiceFormAndRender(data);

        getPrescriptionServiceList().clickContainer();
        getPrescriptionServiceList().getTable().assertColumnValuesIs("Статус", "Выполняется");
        getCancelPrescriptionServiceButton().assertIsDisplayed(true);
        getDeletePrescriptionServiceButton().assertIsDisplayed(false);
        getConfirmPrescriptionServiceButton().assertIsDisplayed(false);
    }

    public void checkPlannedServiceListAfterCancelPrescription(String service)
    {
        getContainerPlannedAndRenderedServiceList().clickContainer();
        //getContainerPlannedAndRenderedServiceList().getTable().assertThatCountOfRowsIs(1);
        getContainerPlannedAndRenderedServiceList().getTable().chooseRowInTable(0);
        getContainerPlannedAndRenderedServiceList().getTable().assertColumnValuesIs("Услуга", service);
        getContainerPlannedAndRenderedServiceList().getTable().assertColumnValuesIs("Статус", "Оказана");
    }

    public void createPrescriptionByTemplate(ServicesTemplatePrescriptionData prescriptionData, String templateName) {
        getContainerPrescriptionList().clickContainer();
        clickCreatePrescriptionByTemplate();
        getPrescriptionByTemplateModal().assertDefaultValues(prescriptionData);
        getPrescriptionByTemplateModal().prescribe(prescriptionData, templateName);
        getPrescriptionByTemplateModal().closeModal();

        assertPrescription(prescriptionData);
        closeAllModalsOnPage();
        deleteChosenPrescription(prescriptionData);
    }

    public void createAndConfirmPrescriptionByTemplate(ServicesTemplatePrescriptionData prescriptionData, String templateName) {
        int countBefore = getContainerPrescriptionList().getTable().getCountRowsInTable(true);
        clickCreatePrescriptionByTemplate();
        getPrescriptionByTemplateModal().prescribeAndConfirm(prescriptionData, templateName);
        getPrescriptionByTemplateModal().closeModal();
        getContainerPrescriptionList().getTable().assertThatCountOfRowsIs(countBefore + 1);
        choosePrescription(prescriptionData);
        deleteChosenPrescription(prescriptionData);
    }

    public void createConfirmAndCancelPrescriptionByTemplate(ServicesTemplatePrescriptionData prescriptionData, String templateName) {
        int countBefore = getContainerPrescriptionList().getTable().getCountRowsInTable(true);
        clickCreatePrescriptionByTemplate();
        getPrescriptionByTemplateModal().prescribeAndConfirmAndCancel(prescriptionData, templateName);
        getPrescriptionByTemplateModal().closeModal();
        getContainerPrescriptionList().getTable().assertThatCountOfRowsIs(countBefore);
    }
}
