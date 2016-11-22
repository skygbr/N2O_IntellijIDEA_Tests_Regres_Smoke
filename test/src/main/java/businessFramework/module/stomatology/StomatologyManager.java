package businessFramework.module.stomatology;

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
import businessFramework.module.stomatology.modals.stomSearchPatient.StomSearchPatientModal;
import businessFramework.module.stomatology.modals.stomService.StomServiceModal;
import businessFramework.module.stomatology.modals.toothMaterial.ToothMaterialModal;
import businessFramework.module.stomatology.pages.refferal.StomReferralServicePage;
import businessFramework.module.stomatology.pages.resultAdmissionStom.ResultAdmissionPageStom;
import businessFramework.module.stomatology.pages.stomService.StomServicePage;
import businessFramework.module.stomatology.pages.stomatologyAppointment.StomatologyAppointmentPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class StomatologyManager {

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Открытие модуля "Стоматология"
    public void openStomatologyModule() {
        app.getNavigationHelper().openPageWithModule("modules.stomatology");
    }

    public void openStomatologyPage() {
        this.openStomatologyModule();
        page.getHeader().openPage("stomatology.stomatologyAppointment");
    }
     // Получение страницы Рабочий стол врача/медсестры
    public StomatologyAppointmentPage getStomatologyAppointmentPage(){
        return new StomatologyAppointmentPage(app);
    }
    //Получение страницы Результаты приема
    public ResultAdmissionPageStom getResultAdmissionPagesStom(){
        return new ResultAdmissionPageStom(app);
    }
    //получение формы истории АМК
    public StomMedicalCardModal getStomMedicalCardModal(){
        return new StomMedicalCardModal();
    }
    //получение формы добавления Истории АМК
    public AddStomMedicalCardHistoryModal getAddMedicalCardHistoryModal(){
        return new AddStomMedicalCardHistoryModal();
    }
    //Получение формы Осмотра Зубной формулы
    public StomInspectionModal getStomInspectionModal(){
        return new StomInspectionModal();
    }
    //Получение формы добавления осмотра
    public AddStomInspectionModal getAddStomInspectionModal(){
        return new AddStomInspectionModal();
    }
    //Получение Формы Диагноза
    public StomDiagnosisModal getStomDiagnosisModal(){
        return new StomDiagnosisModal();
    }
    //Получение Формы Расходные материалы
    public ToothMaterialModal getToothMaterialModal(){
        return new ToothMaterialModal();
    }
    //Получение Формы Направления
    public StomReferralServicePage getReferralPage(){
        return new StomReferralServicePage(app);
    }
    public StomLaboratoryReferralModal getStomLaboratoryReferralModal() {
        return new StomLaboratoryReferralModal();
    }
    public HospitalReferralModal getHospitalReferralModal() {
        return new HospitalReferralModal();
    }
    //Получение Формы закрытия случая
    public StomCloseCaseModal getCloseCaseModal(){
        return new StomCloseCaseModal();
    }

    public StomPrescriptionModal getPrescriptionModal(){
        return new StomPrescriptionModal();
    }
    //Получение формы Рецепта
    public StomReceiptModal getReceiptModal(){
        return new StomReceiptModal();
    }

    //Получение формы Справки
    public StomCertModal getCertModal(){
        return new StomCertModal();
    }
    //получение формы поиска пациента "без записи"
    public StomSearchPatientModal getSearchPatienModal(){
        return new StomSearchPatientModal();
    }
    //Получение формы Услуг и протоколов
    public StomServiceModal getStomServiceModal(){
        return new StomServiceModal();
    }
    //Получение страницы редактирования Услуг и протоколов
    public StomServicePage getStomServicePage(){
        return new StomServicePage(app);
    }
}

