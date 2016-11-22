package businessFramework.module.clinic;

import businessFramework.module.clinic.modals.hospitalReferral.HospitalReferralModal;
import businessFramework.module.clinic.modals.laboratoryReferral.LaboratoryReferralModal;
import businessFramework.module.clinic.modals.cert.CertModal;
import businessFramework.module.clinic.modals.clinicDiagnosis.ClinicDiagnosisModal;
import businessFramework.module.clinic.modals.closeCase.CloseCaseModal;
import businessFramework.module.clinic.modals.medicalCard.AddMedicalCardHistoryModal;
import businessFramework.module.clinic.modals.medicalCard.MedicalCardModal;
import businessFramework.module.clinic.modals.modifyReception.ModifyReceptionModal;
import businessFramework.module.clinic.modals.prescription.PrescriptionModal;
import businessFramework.module.clinic.modals.receipt.ReceiptModal;
import businessFramework.module.clinic.modals.searchPatient.SearchPatientModal;
import businessFramework.module.clinic.modals.serviceAndProtocol.ServiceAndProtocolModal;
import businessFramework.module.clinic.pages.clinicAppointment.ClinicAppointmentPages;
import businessFramework.module.clinic.pages.referral.ReferralServicePage;
import businessFramework.module.clinic.pages.resultAdmission.ResultAdmissionPage;
import businessFramework.module.clinic.pages.serviceAndProtocol.ServicePage;
import businessFramework.module.hospital.modals.service.ServiceModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;


/**
 * Created by asamoilov on 20.08.2015.
 */
public class ClinicManager {
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Открытие модуля "Поликлиника"
    public void openClinicModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.clinic");
    }


    public void openClinicPage() {
        this.openClinicModule();
        page.getHeader().openPage("clinic.clinicAppointment");
    }

    //Получение страницы Рабочий стол врача/медсестры
    public ClinicAppointmentPages getClinicAppointmentPages(){
        return new ClinicAppointmentPages(app);
    }

    //Получение страницы Результаты приема
    public ResultAdmissionPage getResultAdmissionPages(){
        return new ResultAdmissionPage(app);
    }

    //Получение Формы Диагноза
    public ClinicDiagnosisModal getClinicDiagnosisModal(){
        return new ClinicDiagnosisModal();
    }

    //Получение Формы Направления
    public ReferralServicePage getReferralPage(){
        return new ReferralServicePage(app);
    }
    public LaboratoryReferralModal getLaboratoryReferralModal() {
        return new LaboratoryReferralModal();
    }
    public HospitalReferralModal getHospitalReferralModal() {
        return new HospitalReferralModal();
    }
    //Получение Формы Назначения
    public PrescriptionModal getPrescriptionModal(){
        return new PrescriptionModal();
    }
    //Получение формы Рецепта
    public ReceiptModal getReceiptModal(){
        return new ReceiptModal();
    }
    //ПОлучение формы Справки
    public CertModal getCertModal(){
        return new CertModal();
    }
    //получение формы Закрытия случая
    public CloseCaseModal getCloseCaseModal(){
        return new CloseCaseModal();
    }
    public ModifyReceptionModal getModifyReceptionModal(){
        return new ModifyReceptionModal();
    }
    //получение формы истории АМК
    public MedicalCardModal getMedicalCardModal(){
        return new MedicalCardModal();
    }
    //получение формы добавления Истории АМК
    public AddMedicalCardHistoryModal getAddMedicalCardHistoryModal(){
        return new AddMedicalCardHistoryModal();
    }
    //получение формы поиска пациента "без записи"
    public SearchPatientModal getSearchPatienModal(){
        return new SearchPatientModal();
    }
    //Получение модальной формы Услуг и протоколов
    public ServiceAndProtocolModal getServiceModal(){
        return new ServiceAndProtocolModal();
    }
    //Получение страницы редактирования Услуг и протоколов
    public ServicePage getServicePage(){
        return new ServicePage(app);
    }

}
