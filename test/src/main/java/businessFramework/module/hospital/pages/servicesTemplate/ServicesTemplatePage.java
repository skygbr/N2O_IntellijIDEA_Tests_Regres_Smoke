package businessFramework.module.hospital.pages.servicesTemplate;

import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplatePrescriptionData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateServiceData;
import businessFramework.module.hospital.modals.servicesTemplate.ServiceTemplateDiagnosisModal;
import businessFramework.module.hospital.modals.servicesTemplate.ServiceTemplateServiceShortFormModal;
import businessFramework.module.hospital.modals.servicesTemplate.ServicesTemplateModal;
import businessFramework.module.hospital.modals.servicesTemplate.ServicesTemplateServiceModal;
import net.framework.autotesting.ApplicationManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplatePage extends ServicesTemplateHelper {
    private Integer createdId;

    public ServicesTemplatePage(ApplicationManager app) {
        super(app);
    }

    public ServicesTemplateModal getServicesTemplateModal() {
        return new ServicesTemplateModal();
    }

    public ServiceTemplatePrescriptionModal getServicesTemplatePrescriptionModal() {
        return new ServiceTemplatePrescriptionModal(app);
    }

    public ServiceTemplateServiceShortFormModal getServiceTemplateServiceShortFormModal() {
        return new ServiceTemplateServiceShortFormModal();
    }

    public ServiceTemplateDiagnosisModal getServiceTemplateDiagnosisModal() {
        return new ServiceTemplateDiagnosisModal();
    }

    public ServicesTemplateServiceModal getServicesTemplateServiceModal() {
        return new ServicesTemplateServiceModal();
    }

    public void createAndUpdateServicesTemplate(ServicesTemplateData dataForCreate, ServicesTemplateData dataForEdit) {
        clickButtonOpeningModal(getServicesTemplateCreateButton(), "Шаблон модели лечения");
        getServicesTemplateModal().fillServicesTemplateForm(dataForCreate);
        getServicesTemplateModal().clickSaveServicesTemplate();
        saveTemplateId();

        getServicesTemplateUpdateButton().click();
        getServicesTemplateModal().assertServicesTemplateForm(dataForCreate);
        getServicesTemplateModal().fillServicesTemplateForm(dataForEdit);
        getServicesTemplateModal().clickSaveServicesTemplate();
    }

    private void saveTemplateId() {
        Matcher m = Pattern.compile("createdId=(\\d+)").matcher(getCurrentUrl());
        createdId = m.find() ? Integer.valueOf(m.group(1)) : null;
    }

    public void checkServiceTemplateValidation(ServicesTemplateData data) {
        clickButtonOpeningModal(getServicesTemplateUpdateButton(), "Шаблон модели лечения");
        getServicesTemplateModal().fillServicesTemplateForm(data);
        getServicesTemplateModal().clickSaveServicesTemplateWithValidationException("Шаблон содержит недействительные услуги: Услуга шаблона");
        getServicesTemplateModal().clickCancel();
        acceptAlert();
    }

    public void createAndUpdateServicesTemplateService(ServicesTemplateServiceData dataForCreate, ServicesTemplateServiceData dataForEdit) {
        clickButtonOpeningModal(getServicesTemplateServiceCreateButton(), "Услуга");
        getServicesTemplateServiceModal().fillServicesTemplateServiceForm(dataForCreate);
        getServicesTemplateServiceModal().clickSaveServicesTemplate();

        getServicesTemplateServiceUpdateButton().click();
        getServicesTemplateServiceModal().assertServicesTemplateServiceForm(dataForCreate);
        getServicesTemplateServiceModal().fillServicesTemplateServiceFormForEdit(dataForEdit);
        getServicesTemplateServiceModal().assertWhenScheduleSelectionTypeIsWithoutRecording();

        getServicesTemplateServiceModal().clickSaveServicesTemplate();
        getServicesTemplateServiceUpdateButton().click();
        getServicesTemplateServiceModal().assertServicesTemplateServiceForm(dataForEdit);
        getServicesTemplateServiceModal().assertWhenScheduleSelectionTypeIsWithoutRecording();

        getServicesTemplateServiceModal().clickCancel();

    }

    public void createServiceInShortForm(String service) {
        clickButtonOpeningModal(getServicesTemplateServiceShortFormCreateButton(), "Шаблон модели лечения. Услуги");
        getServiceTemplateServiceShortFormModal().addServiceToTemplate(service);
        getModal().closeModal();
    }

    public void deleteServiceInShortForm(String service) {
        clickButtonOpeningModal(getServicesTemplateServiceShortFormCreateButton(), "Шаблон модели лечения. Услуги");
        getServiceTemplateServiceShortFormModal().deleteServiceFromTemplate(service);
        getModal().closeModal();
    }

    public void createDiagnosis(String diagnosis) {
        clickButtonOpeningModal(getServicesTemplateDiagnosisCreateButton(), "Шаблон модели лечения. Диагнозы");
        getServiceTemplateDiagnosisModal().addDiagnosisToTemplate(diagnosis);
        getModal().closeModal();
    }

    public void deleteDiagnosisAcrossCheckBox(String diagnosis) {
        clickButtonOpeningModal(getServicesTemplateDiagnosisCreateButton(), "Шаблон модели лечения. Диагнозы");
        getServiceTemplateDiagnosisModal().deleteDiagnosisFromTemplate(diagnosis);
        getModal().closeModal();
    }

    public void deleteDiagnosisAcrossButton() {
        getServicesTemplateDiagnosisDeleteButton().click();
        getDialog().clickYes();
        getServicesTemplateDiagnosisContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteServicesTemplate() {
        getServicesTemplateContainer().getButton(DELETE_BUTTON).click();
        getModal().getButton(CONFIRM_BUTTON).click();
        getServicesTemplateTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteServicesTemplateService() {
        getServicesTemplateServiceContainer().getButton(DELETE_BUTTON).click();
        getDialog().clickYes();
        getServicesTemplateServiceTable().getAlerts().assertSuccessAlertIsPresent();
    }

    // Вкладка Препарат

    public void createHolding(ServicesTemplatePrescriptionData prescriptionData) {
        clickButtonOpeningModal(getServicesTemplateHoldingCreateButton(), "Шаблон модели лечения. Препарат");
        getServicesTemplatePrescriptionModal().assertDefaultValues();
        getServicesTemplatePrescriptionModal().fillForm(prescriptionData);
        getServicesTemplatePrescriptionModal().getConfirmButton().click();
        assertModalPresentOnPage(false);
        getServicesTemplateHoldingTable().getAlerts().assertSuccessAlertMessage("Данные сохранены");
    }

    public void assertHolding(ServicesTemplatePrescriptionData prescriptionData) {
        clickButtonOpeningModal(getServicesTemplateHoldingUpdateButton(), "Шаблон модели лечения. Препарат");
        getServicesTemplateHoldingTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        getServicesTemplatePrescriptionModal().assertForm(prescriptionData);
    }

    public void updateHolding(ServicesTemplatePrescriptionData prescriptionData) {
        getServicesTemplatePrescriptionModal().updateCommentField(prescriptionData);
        assertModalPresentOnPage(false);
        getServicesTemplateHoldingTable().getAlerts().assertSuccessAlertMessage("Данные сохранены");
    }

    public void copyHolding(ServicesTemplatePrescriptionData prescriptionData, ServicesTemplatePrescriptionData prescriptionData_copy) {
        clickButtonOpeningModal(getServicesTemplateHoldingCopyButton(), "Шаблон модели лечения. Препарат");
        getServicesTemplatePrescriptionModal().assertForm(prescriptionData);
        getServicesTemplatePrescriptionModal().fillCopyForm(prescriptionData_copy);
        getServicesTemplatePrescriptionModal().getConfirmButton().click();
        assertModalPresentOnPage(false);
        getServicesTemplateHoldingTable().getAlerts().assertSuccessAlertMessage("Данные сохранены");
    }

    public void deleteHolding() {
        getServicesTemplateHoldingDeleteButton().click();
        getDialog().clickYes();
        getServicesTemplateHoldingTable().getAlerts().assertSuccessAlertMessage("Препарат удаленен");
    }

    public void filterTemplateById() {
        openUrl(getFilterByIdUrl());
        getServicesTemplateContainer().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        getServicesTemplateContainer().getTable().assertThatCountOfRowsIs(1);
    }

    private String getFilterByIdUrl() {
        String baseUrl = app.getProperty("baseUrl").trim();
        baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        return baseUrl + "#hospital.servicesTemplate?servicesTemplate:filter:id=" + createdId;
    }
}
