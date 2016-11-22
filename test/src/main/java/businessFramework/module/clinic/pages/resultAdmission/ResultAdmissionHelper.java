package businessFramework.module.clinic.pages.resultAdmission;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.*;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ResultAdmissionHelper extends Page implements Values {
    public ResultAdmissionHelper(ApplicationManager app) {
        super(app);
    }

    //Инфо панель
    public Container getContainerPersonalDataOfThePatient(){
        return getRegion("top").getContainer("personalDataOfThePatient");
    }

    //Случай
    //actionMenu
    public Container getAdmissionCase(){
       return getRegion("center").getContainer("admissionCase");
    }
    public Button getCreateVisitButton(){
        return getAdmissionCase().getButton("createVisit");
    }
    public Button getSaveCaseButton(){
        return getAdmissionCase().getButton("createNewCase");
    }
    public Button getUpdateCaseButton(){
        return getAdmissionCase().getButton("updateCase");
    }
    public Button getRewriteCaseButton(){
        return getAdmissionCase().getButton("rewriteCase");
    }
    public Button getCloseCaseButton(){
        return getAdmissionCase().getButton("closeCase");
    }
    public Button getReopenCaseButton(){
        return getAdmissionCase().getButton("reopenCase");
    }
    public Button getGoCaseButton(){
        return getAdmissionCase().getButton("goCase");
    }
    public Button getPatientCardPlaceButton(){
        return getAdmissionCase().getButton("patientCardPlace");
    }
    public Button getAddCardPlaceButton(){
        return getAdmissionCase().getButton("addCardPlace");
    }

    //Компоненты
    public Classifier getMcCase(){
        return getAdmissionCase().getForm().getClassifier("mcCase");
    }
    public InputCheckBox getIsOpenMoreInfo(){
        return getAdmissionCase().getForm().getInputCheckBox("mcCase.openMoreInfo");
    }
    public InputDate getCaseCreateDate(){
        return getAdmissionCase().getForm().getInputDate("mcCase.caseCreateDate");
    }

    public Classifier getMcCaseType(){
        return getAdmissionCase().getForm().getClassifier("mcCase.caseType");
    }
    public Classifier getMcCaseCareRegimen(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careRegimen");
    }
    public Classifier getFundingSourceType(){
        return getAdmissionCase().getForm().getClassifier("mcCase.fundingSourceType");
    }
    public Classifier getMcCaseCareProvidingForm(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careProvidingForm");
    }
    public Classifier getMcCaseCaseInitGoal(){
        return getAdmissionCase().getForm().getClassifier("mcCase.caseInitGoal");
    }
    public Classifier getMcCaseCareLevel(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careLevel");
    }
    public Classifier getMcCaseCareProvisionCondition(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careProvisionCondition");
    }

    public Classifier getMcCaseAdmissionReason(){
        return getAdmissionCase().getForm().getClassifier("mcCase.admissionReason");
    }
    public Classifier getMcCaseReferral(){
        return getAdmissionCase().getForm().getClassifier("referral");
    }
    public InputDate getVisitDateTime(){
        return getAdmissionCase().getForm().getInputDate("visitDateTime");
    }
    public Classifier getVisitPlace(){
        return getAdmissionCase().getForm().getClassifier("mcCase.visitPlace");
    }
    public InputCheckBox getInitiatior(){
        return getAdmissionCase().getForm().getInputCheckBox("initiatior");
    }
    public Classifier getProfile(){
        return getAdmissionCase().getForm().getClassifier("mcCase.profile");
    }
    public Classifier getDiagnosis(){
        return getAdmissionCase().getForm().getClassifier("mcCase.diagnosis");
    }
    public Classifier getService(){
        return getAdmissionCase().getForm().getClassifier("mcCase.service");
    }
    public Classifier getDiseaseType(){
        return getAdmissionCase().getForm().getClassifier("mcCase.diseaseType");
    }
    public Classifier getMedicalCard() {
        return getAdmissionCase().getForm().getClassifier("place");
    }
    public Button getMedicalCardHistory(){
        return getAdmissionCase().getButton("patientCardPlace");
    }
    public Button getButtonCreateMedicalCard(){
        return getAdmissionCase().getButton("addCardPlace");
    }
    public Button getButtonDeleteMedicalCard(){
        return getAdmissionCase().getButton("deleteCardPlace");
    }


    //Копия посещения
    public Container getCopyVisit(){
        return getRegion("lastVisitCenter").getContainer("lastVisit");
    }
    public Button getCopyLastVisitButton(){
        return getCopyVisit().getButton("latVisit");
    }

    //ТАП
    public Container getTAP() {return getRegion("TAP").getContainer("ticketOutpatientCase");}
    public Button getSaveTAP(){
        return getTAP().getButton("Сохранить");
    }
    public Classifier getDiagnosTAP() {
        return getTAP().getForm().getClassifier("mcCase.diagnosis");
    }
    public Classifier getDiseaseTypeTAP() {
        return getTAP().getForm().getClassifier("mcCase.diseaseType");
    }

    //Компоненты Услуги,Протоколы
    public Container getContainerServicesAndProtocols(){
        return getRegion("bottom-right-tab-services").getContainer("servicesAndProtocols");
    }
    public Table getTableService(){
        return getContainerServicesAndProtocols().getTable();
    }
    public Button getCreateServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("createServiceAndProtocol");
    }
    public Button getUpdateServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("updateServiceAndProtocol");
    }
    public Button getDeleteServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("deleteServiceAndProtocol");
    }

    //Компоненты Диагнозы
    public Container getContainerDiagnosis(){
        return getRegion("bottom-right-tab-diagnosis").getContainer("diagnosis");
    }
    public Table getTableDiagnosis(){
        return getContainerDiagnosis().getTable();
    }
    public Button getCreateDiagnosisButton(){
        return getContainerDiagnosis().getButton("createDiagnosis");
    }
    public Button getUpdateDiagnosisButton(){
        return getContainerDiagnosis().getButton("updateDiagnosis");
    }
    public Button getDeleteDiagnosisButton(){
        return getContainerDiagnosis().getButton("deleteDiagnosis");
    }

    //Компоненты Направления
    public Container getContainerReferral(){
        return getRegion("bottom-right-tab-referral").getContainer("referral");
    }
    public Table getTableReferral(){
        return getContainerReferral().getTable();
    }
    public Button getCreateReferralButton(){
        return getContainerReferral().getButton("createReferral");
    }
    public Button getCreateLaboratoryReferralButton(){
        return getContainerReferral().getButton("createlaboratoryReferral");
    }
    public Button getCreateClinicReferralButton(){
        return getContainerReferral().getButton("createClinicReferral");
    }
    public Button getCreateHospReferralButton(){
        return getContainerReferral().getButton("hospReferral");
    }
    public Button getUpdateReferralButton(){
        return getContainerReferral().getButton("updateReferral");
    }
    public Button getUpdateLaboratoryReferralButton(){
        return getContainerReferral().getButton("updateLaboratoryReferral");
    }

    public Button getUpdateHospitalReferralButton(){
        return getContainerReferral().getButton("updateHospitalReferral");
    }

    public Button getDeleteReferralButton(){
        return getContainerReferral().getButton("deleteReferral");
    }


    //Компоненты Предварительная запись
    public Container getContainerPreEntry(){
        return getRegion("bottom-right-tab-referral").getContainer("pre-entry");
    }

    //Компоненты Назначения
    public Container getContainerPrescription(){
        return getRegion("bottom-right-tab-prescription").getContainer("prescription");
    }
    public Table getTablePrescrition(){
        return getContainerPrescription().getTable();
    }
    public Button getViewPrescriptionButton(){
        return getContainerPrescription().getButton("viewPrescription");
    }
    public Button getCreatePrescriptionButton(){
        return getContainerPrescription().getButton("createPrescription");
    }
    public Button getUpdatePrescriptionButton(){
        return getContainerPrescription().getButton("updatePrescription");
    }
    public Button getDeletePrescriptionButton(){
        return getContainerPrescription().getButton("deletePrescription");
    }
    public Button getConfirmPrescriptionButton(){
        return getContainerPrescription().getButton("confirmPrescription");
    }
    public Button getCancelPrescriptionButton(){
        return getContainerPrescription().getButton("cancelPrescription");
    }

    //Рецепты
    public Container getContainerReceipt(){
        return getRegion("bottom-right-tab-receipt").getContainer("receiptList");
    }
    public Table getTableReceipt(){
        return getContainerReceipt().getTable();
    }
    public Button getAddReceiptButton(){
        return getContainerReceipt().getButton("add");
    }
    public Button getCreateGeneralReceiptButton(){
        return getContainerReceipt().getButton("createGeneral");
    }
    public Button getUpdateReceiptButton(){
        return getContainerReceipt().getButton("update");
    }
    public Button getDeleteReceiptButton(){
        return getContainerReceipt().getButton("delete");
    }

    //Листы нетрудоспособности
    public Container getContaineSickList(){
        return getRegion("bottom-right-tab-requestSickList").getContainer("requestSickList");
    }
    public Button getRequestSickListButton(){
        return getContaineSickList().getButton("requestSickList");
    }
    public Button getAddSickListButton(){
        return getContaineSickList().getButton("add");
    }
    public Button getCreateSickListButton(){
        return getContaineSickList().getButton("createSickList");
    }
    public Button getUpdateSickListButton(){
        return getContaineSickList().getButton("updateSickList");
    }
    public Button getDeleteSickListButton(){
        return getContaineSickList().getButton("deleteSickList");
    }

    //Журнал прививок
    public Container getContaineVaccinations(){
        return getRegion("bottom-right-tab-vaccinations").getContainer("vaccinations");
    }
    public Button getAddInoculationButton(){
        return getContaineVaccinations().getButton("addInoculation");
    }
    public Button getAddMantuButton(){
        return getContaineVaccinations().getButton("addMantu");
    }
    public Button getUpdateVaccinationsButton(){
        return getContaineVaccinations().getButton("update");
    }
    public Button getDeleteVaccinationsButton(){
        return getContaineVaccinations().getButton("delete");
    }
    public Button getIndivPlanButton(){
        return getContaineVaccinations().getButton("indivPlan");
    }

    //Справки
    public Container getContaineСlinicCert(){
        return getRegion("bottom-right-tab-cert").getContainer("cert");
    }
    public Table getTableCert(){
        return getContaineСlinicCert().getTable();
    }
    public Button getViewCertButton(){
        return getContaineСlinicCert().getButton("view");
    }
    public Button getCreateCertButton(){
        return getContaineСlinicCert().getButton("createCert");
    }
    public Button getCreateRefusalButton(){
        return getContaineСlinicCert().getButton("createRefusal");
    }
    public Button getAnnuleCertButton(){
        return getContaineСlinicCert().getButton("annule");
    }
    public Button getCancelAnnuledCertButton(){
        return getContaineСlinicCert().getButton("cancelAnnuled");
    }

    //Проишествие
    public Container getContaineAccident(){
        return getRegion("bottom-right-tab-accident").getContainer("accident");
    }
    public Button getCreateAccidentButton(){
        return getContaineAccident().getButton("createAccident");
    }
    public Button getUpdateAccidentButton(){
        return getContaineAccident().getButton("updateAccident");
    }
    public Button getDeleteAccidentButton(){
        return getContaineAccident().getButton("deleteAccident");
    }
}
