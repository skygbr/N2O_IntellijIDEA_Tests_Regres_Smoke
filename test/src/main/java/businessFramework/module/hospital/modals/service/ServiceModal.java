package businessFramework.module.hospital.modals.service;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class ServiceModal implements Values {
    private ServiceHelper serviceHelper;

    public ServiceModal() {
        this.serviceHelper = new ServiceHelper();
    }

    public ServiceModal(String locator) {
        this.serviceHelper = new ServiceHelper(locator);
    }

    public void clickConfirmButton() {
        Button confirm = serviceHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void fillInspectionService(HospitalData hospitalData) {
        serviceHelper.getService().setValue(hospitalData.getService());
        serviceHelper.getDoctor().setValue(hospitalData.getDoctor());
    }

    public void fillOperationService(HospitalData hospitalData) {
        if (serviceHelper.getBdate().getValue().equals("__.__.____")) {
            serviceHelper.getBdate().setValue(hospitalData.getBdateService());
        }
        serviceHelper.getService().setValue(hospitalData.getService());
        serviceHelper.getDoctor().setValue(hospitalData.getDoctor());
    }

    /**
     * Проверка формы создания осмотра
     */
    public void assertServiceForm(HospitalData hospitalData) {
        serviceHelper.getService().assertValue_contains(hospitalData.getService());
        serviceHelper.getDoctor().assertValue_contains(hospitalData.getDoctor());
    }
}
