package businessFramework.module.hospital.pages.branchManager;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import businessFramework.module.dAccount.pages.CommissionReferralPage;
import businessFramework.module.hospital.modals.assignDoctor.AssignDoctorModal;
import businessFramework.module.hospital.modals.departmentInfo.DepartmentInfoModal;
import businessFramework.module.hospital.modals.doctorHistory.DoctorHistoryModal;
import businessFramework.module.hospital.modals.loadDoctors.LoadDoctorsModal;
import businessFramework.module.hospital.pages.medicalHistory.MedicalHistoryPage;
import businessFramework.module.hospital.pages.service.ServicePage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import java.util.Map;

public class BranchManagerPage extends BranchManagerHelper implements Values
{
    public BranchManagerPage(ApplicationManager app) {
        super(app);
    }

    public DepartmentInfoModal getDepartmentInfoModal()
    {
        return new DepartmentInfoModal();
    }

    public LoadDoctorsModal getLoadDoctorsModal()
    {
        return new LoadDoctorsModal();
    }

    public AssignDoctorModal getAssignDoctorModal()
    {
        return new AssignDoctorModal();
    }

    public DoctorHistoryModal getDoctorHistoryModal()
    {
        return new DoctorHistoryModal();
    }

    public CommissionReferralPage getCommissionReferralPage() {
        return new CommissionReferralPage(app);
    }

    public MedicalHistoryPage getMedicalHistoryPage()
    {
        return new MedicalHistoryPage(app);
    }

    public BranchManagerFilter getFilter()
    {
        return new BranchManagerFilter(app);
    }

    /**
     * Получение страницы Создания услуги
     *
     * @return страница создния услуги
     */
    public ServicePage getServicePage()
    {
        return new ServicePage(app);
    }

    public void clickDepartmentInfo()
    {
        Button button = getDepartmentInfoButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Информация");
        getModal().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void clickCommissionReferralButton()
    {
        getContainerMdHistory().getDropdownByText("Еще").click();
        Button button = getCommissionReferralButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("на ЦВКК");
    }


    public void clickDoctorWorkload()
    {
        Button button = getDoctorWorkloadButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Загруженность врачей");
        getModal().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void clickAssignDoctor()
    {
        Button button = getAssignDoctorButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Назначить врача");
        getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void clickAddPhysical()
    {
        getContainerMdHistory().getDropdownByText("Еще").click();
        Button button = getAddPhysicalButton();
        button.assertIsEnabled();
        button.click();
        assertBreadcrumbContainsValue("Осмотр");
        getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void addPhysical(HospitalData hospitalData)
    {
        clickAddPhysical();
        getServicePage().fillInspectionService(hospitalData);
        getServicePage().saveServiceBDateValue(hospitalData);
        getServicePage().clickConfirmButton();
        getServicePage().clickBackButton();
    }

    public void assertPhysicalDisplayedInMedicalHistory(HospitalData hospitalData)
    {
        clickMedicalHistory();
        getMedicalHistoryPage().getContainerServices().clickContainer();
        getMedicalHistoryPage().assertPhysicalServiceExists("Дата", hospitalData.getBdateService());
    }

    public void clickDoctorHistory()
    {
        getContainerMdHistory().clickDropdown("", "История смены врачей", "doctorHistory");
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("История смены врачей");
        getModal().getTable().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void clickMedicalHistory()
    {
        Button button = getMedicalHistoryButton();
        button.assertIsEnabled();
        button.click();
        String text = "История болезни";
        assertBreadcrumbContainsValue(text);
    }

    public void clickChangeDiagnosis()
    {
        Button button = getChangeDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Смена диагноза");
        getModal().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void assertDepartmentInfo(Map<String, String> map, HospitalData hospitalData)
    {
        clickDepartmentInfo();
        getDepartmentInfoModal().assertDepartmentInfo(map, hospitalData);
        getModal().closeModal();
    }

    public void assertDoctorWorkload(Map<String, String> map, HospitalData hospitalData)
    {
        clickDoctorWorkload();
        getModal().closeModal();
    }

    public void assignDoctor(HospitalData hospitalData)
    {
        clickAssignDoctor();
        getAssignDoctorModal().assignDoctor(hospitalData);
    }

    public void assertMedicalHistory(HospitalData hospitalData)
    {
        clickMedicalHistory();
        getMedicalHistoryPage().assertPatientData(hospitalData);
        getMedicalHistoryPage().assertMedicalData(hospitalData);
    }

    public void filterByPatient(HospitalData hospitalData)
    {
        getContainerMdHistory().showFilter();
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getFilter().getShowClosedCases().check(true);
        getContainerMdHistory().getFilter().clickFindButton();
    }

    public void cancelDischarge()
    {
        String dischargeDate = getContainerMdHistory().getTable().getRowColumnIntersectionValue(0, "Дата выписки", true);
        int rowsCount = getContainerMdHistory().getTable().getCountRowsInTable(true);
        if (rowsCount > 0 && !dischargeDate.equals(""))
        {
            getContainerMdHistory().clickDropdown("Еще", "Отмена выписки", "reopen");
            getDialog().clickYes();
            getAlerts().assertSuccessAlertMessage("Случай переоткрыт.");
        }
    }
}
