package businessFramework.module.hospital.pages.service;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.PhysicalCopyData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionServiceData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.test.DateUtil;

public class ServicePage extends ServiceHelper implements Values {

    private AddResultToServicePageHelper addResultToServicePageHelper;

    public ServicePage(ApplicationManager app) {
        super(app);
        addResultToServicePageHelper = new AddResultToServicePageHelper(app);
    }

    public void clickConfirmButton() {
        Button confirm = getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void clickBackButton() {
        Button back = getBackButton();
        back.assertIsEnabled();
        back.click();
    }

    public void assertCountServices(int count) {
         getService().assertCountDropdownValuesIs(count);
    }

    public void fillInspectionService(HospitalData hospitalData) {
        getDoctor().setValue(hospitalData.getDoctor());
        getService().setValue(hospitalData.getService());
    }

    public void saveServiceBDateValue(HospitalData hospitalData){
        hospitalData.setBdateService(getBdate().getValue());
    }

    public void fillOperationService(HospitalData hospitalData) {
        if (getBdate().getValue().equals("")) {
            getBdate().setValue(hospitalData.getBdateService());
        }
        getService().setValue(hospitalData.getService());
        getDoctor().setValue(hospitalData.getDoctor());
    }

    /**
     * Проверка формы создания осмотра
     */
    public void assertServiceForm(HospitalData hospitalData) {
        getService().assertValue_contains(hospitalData.getService());
        getDoctor().assertValue_contains(hospitalData.getDoctor());
    }

    /**
     * Проведение осмотра
     */
    public void fillServiceForm(HospitalData hospitalData, int count)
    {
        assertCountServices(count);
        fillInspectionService(hospitalData);
        clickConfirmButton();
    }

    public void assertPhysicalCopyForm(String service, String doctor)
    {
        getService().assertValue_contains(service);
        getDoctor().assertValue_contains(doctor);
    }

    public void copyPhysical(PhysicalCopyData physicalCopyData)
    {
        assertPhysicalCopyForm(physicalCopyData.getService(), physicalCopyData.getDoctorFromContext());
        clickConfirmButton();
        getAlerts().assertSuccessAlertIsPresent();
        assertPhysicalCopyForm(physicalCopyData.getService(), physicalCopyData.getDoctor());
    }

    public void fillAddResultToServiceForm(HospitalData hospitalData)
    {
        addResultToServicePageHelper.getDoctor().setValue(hospitalData.getDoctor());
        addResultToServicePageHelper.getService().setValue(hospitalData.getService());
        clickConfirmButton();
    }

    public void checkAfterAddResultToService(HospitalData hospitalData)
    {
        addResultToServicePageHelper.getService().assertValue_contains(hospitalData.getService());
        addResultToServicePageHelper.getDoctor().assertValue_contains(hospitalData.getDoctor());
        addResultToServicePageHelper.clickBackButton();
    }

    public void checkAddResultFormAfterCancelRendered()
    {
        addResultToServicePageHelper.getService().assertValue_contains("");
        addResultToServicePageHelper.getRenderedDate().assertValue_contains("");
    }

    /**
     * Внести результат для услуги, созданной через назначение. Проверить, что поля заполнились правильно и оказать.
     */
    public void checkPrescriptionServiceFormAndRender(PrescriptionServiceData data)
    {
        addResultToServicePageHelper.getService().assertValue_equals(data.getService());
        addResultToServicePageHelper.getRenderedDate().assertValue_equals(data.getGeneratedFirstDate());
        addResultToServicePageHelper.getHospitalRecord().assertValue_equals(data.getHospitalRecord());
        addResultToServicePageHelper.getFinancialType().setValue(data.getFinancialType());

        clickConfirmButton();
//        addResultToServicePageHelper.getAlerts().assertSuccessAlertIsPresent();
        clickBackButton();
    }

    public void assertPrescriptionServiceForm(HospitalData hospitalData) {
        addResultToServicePageHelper.getService().assertValue_contains(hospitalData.getService());
        addResultToServicePageHelper.getHospitalRecord().assertValue_contains(hospitalData.getDepartment());
        addResultToServicePageHelper.getRenderedDate().assertValue_equals(hospitalData.getBdateService());
    }

}
