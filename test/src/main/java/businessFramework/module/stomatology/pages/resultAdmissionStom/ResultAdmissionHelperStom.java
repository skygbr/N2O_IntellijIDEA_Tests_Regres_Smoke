package businessFramework.module.stomatology.pages.resultAdmissionStom;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class ResultAdmissionHelperStom extends Page implements Values {
    public ResultAdmissionHelperStom(ApplicationManager app) {
        super(app);
    }
    //Случай
    //actionMenu
    public Container getAdmissionCase(){
        return getRegion("center").getContainer("admissionCase");
    }
    public Button getCreateVisitButton(){
        return getAdmissionCase().getButton("createVisit");
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

    public Classifier getMcCase(){
        return getAdmissionCase().getForm().getClassifier("mcCase");
    }
    public Classifier getMcCaseCaseInitGoal(){
        return getAdmissionCase().getForm().getClassifier("mcCase.caseInitGoal");
    }
    public Classifier getMcCaseType(){
        return getAdmissionCase().getForm().getClassifier("mcCase.caseType");
    }
    public Classifier getMcCaseCareRegimen(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careRegimen");
    }
    public Classifier getProfile(){
        return getAdmissionCase().getForm().getClassifier("mcCase.profile");
    }

    public Classifier getMcCaseCareProvisionCondition(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careProvisionCondition");
    }
    public Classifier getFundingSourceType(){
        return getAdmissionCase().getForm().getClassifier("mcCase.fundingSourceType");
    }
    public Classifier getMcCaseCareLevel(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careLevel");
    }
    public Classifier getService(){
        return getAdmissionCase().getForm().getClassifier("mcCase.service");
    }
    public Classifier getMcCaseCareProvidingForm(){
        return getAdmissionCase().getForm().getClassifier("mcCase.careProvidingForm");
    }
    public Classifier getVisitPlace(){
        return getAdmissionCase().getForm().getClassifier("mcCase.visitPlace");
    }
    public Button getSaveCaseButton(){
        return getAdmissionCase().getButton("createNewCase");
    }
    public Classifier getMedicalCard() {
        return getAdmissionCase().getForm().getClassifier("place");
    }
    public Button getMedicalCardHistory(){
        return getAdmissionCase().getButton("patientCardPlace");
    }
    //Копия посещения
    public Container getCopyVisit(){
        return getRegion("lastVisitCenter").getContainer("lastVisit");
    }
    public Button getCopyLastVisitButton(){
        return getCopyVisit().getButton("latVisit");
    }
    //Зубная формула
    public Container getContainerDentalFormula(){
        return getRegion("bottom-right-tab-dental-formula").getContainer("dental-formula");
    }
    public Button getAddInspection(){
        return getContainerDentalFormula().getButton("inspection");
    }
    //Компоненты Услуги,Протоколы
    public Container getContainerServicesAndProtocols(){
        return getRegion("bottom-right-tab-services").getContainer("servicesAndProtocols");
    }
    public Button getCreateServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("createToothService");
    }
    public Button getUpdateServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("updateToothService");
    }
    public Button getDeleteServiceAndProtocolButton(){
        return getContainerServicesAndProtocols().getButton("deleteToothService");
    }
    //Компоненты Услуги,Протоколы - Информация по случаю
    public Button getCreateServiceInformButton(){
        return getContainerServicesAndProtocols().getButton("createServiceAndProtocol");
    }
    public Button getUpdateServiceInformButton(){
        return getContainerServicesAndProtocols().getButton("updateServiceAndProtocol");
    }
    public Button getDeleteServiceInformButton(){
        return getContainerServicesAndProtocols().getButton("deleteServiceAndProtocol");
    }

    //Диагнозы
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
    //расходные материалы
    public Container getContainerToothMaterial(){
        return getRegion("bottom-right-tab-tooth-material").getContainer("tooth-material");
    }

    public Table getTableToothMaterial(){
        return getContainerToothMaterial().getTable();
    }
    public Button getCreateToothMaterialButton(){
        return getContainerToothMaterial().getButton("createToothMaterial");
    }
    public Button getCopyToothMaterialButton(){
        return getContainerToothMaterial().getButton("createToothMaterialCopy");
    }
    public Button getUpdateToothMaterialButton(){
        return getContainerToothMaterial().getButton("updateToothMaterial");
    }
    public Button getDeleteToothMaterialButton(){
        return getContainerToothMaterial().getButton("deleteToothMaterial");
    }
    //КОмпонент Направления
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
}
