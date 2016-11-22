package businessFramework.module.hospital.pages.nurseDepart;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.StoreSupplyData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.module.hospital.modals.createBedResource.CreateBedResourceModal;
import businessFramework.module.hospital.modals.movingDepartment.MovingDepartmentModal;
import businessFramework.module.hospital.pages.prescriptionOnceExecution.PrescriptionOnceExecutionPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import test.smoke.ErrorsSearchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NurseDepartPage extends NurseDepartHelper implements NurceDepartValues {
    private Page page = Page.getInstance();

    public NurseDepartPage(ApplicationManager app) {
        super(app);
    }

    public NurseDepartFilter getFilter() {
        return new NurseDepartFilter(app);
    }

    public CreateBedResourceModal getCreateBedResourceModal() {
        return new CreateBedResourceModal();
    }

    public MovingDepartmentModal getMovingDepartmentModal() {
        return new MovingDepartmentModal();
    }

    public PrescriptionOnceExecutionPage getPrescriptionOnceExecutionPage() {
        return new PrescriptionOnceExecutionPage(app);
    }

    public void filterByPatient(HospitalData hospitalData) {
        getContainerPatientList().showFilter();
        getFilter().getPatient().setValue(hospitalData.getPatient());
        getContainerPatientList().getFilter().clickFindButton();
    }

    public void deleteAllSendToDepartment() {
        ErrorsSearchers errorsSearchers = new ErrorsSearchers();

        while (getContainerHospitalRecordList().getTable().getCountRowsInTable(true) > 1) {
            int rowsCount = getContainerHospitalRecordList().getTable().getCountRowsInTable(true);
            getContainerHospitalRecordList().getTable().chooseRowInTable(rowsCount - 1);
            clickDeleteSendToDepartment();
            assertThat("Page have error message" + errorsSearchers.isErrorPresentsByContainerId("hospitalRecordList"), errorsSearchers.isErrorPresentsByContainerId("hospitalRecordList"), equalTo(""));
        }
    }

    public void deleteAllBeds() {
        while (getContainerBedList().getTable().getCountRowsInTable(true) > 0) {
            getContainerBedList().getTable().chooseRowInTable(0);
            clickDeleteBed();
        }
    }

    public void clickCreateBed() {
        Button button = getCreateBedResourceButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Регистрация койки");
    }

    public void clickUpdateBed() {
        Button button = getUpdateBedResourceButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Регистрация койки");
    }

    public void clickDeleteBed() {
        Button button = getDeleteBedResourceButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void clickCreateSendToDepartment() {
        Button button = getCreateHospitalRecordButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Движение по отделениям");
    }

    public void clickEditSendToDepartment() {
        Button button = getEditHospitalRecordButton();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Движение по отделениям");
    }

    public void clickDeleteSendToDepartment() {
        Button button = getDeleteHospitalButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    public void createBed(HospitalData hospitalData) {
        clickCreateBed();
        getCreateBedResourceModal().addFreeBed();
    }

    public void createHospitalRecord(HospitalData hospitalData) {
        clickCreateSendToDepartment();
        getMovingDepartmentModal().assertCurrentDepartment(hospitalData);
        getMovingDepartmentModal().fillNextDepartment(hospitalData);
        getMovingDepartmentModal().clickStandardsTab();
        getMovingDepartmentModal().fillStandards(hospitalData);
        getMovingDepartmentModal().clickConfirmButton();
        page.assertModalPresentOnPage(false);
    }

    public void editHospitalRecord(HospitalData hospitalData) {
        clickEditSendToDepartment();
        getMovingDepartmentModal().assertCurrentDepartment(hospitalData);
        getMovingDepartmentModal().clickConfirmButton();
        page.assertModalPresentOnPage(false);
    }

    private void clickExecuteOnceButton() {
        getContainerPatientList().clickDropdown("Еще", "Списать на пациента", "executionOnce");
        page.assertBreadcrumbContainsValue("Списать на пациента");
    }

    public void deleteAllExecutedOncePrescriptions() {
        clickExecuteOnceButton();
        getPrescriptionOnceExecutionPage().removeAllPrescriptions();
        returnToNurseDepartPage();
    }

    public void deleteExecutedOncePrescription() {
        getPrescriptionOnceExecutionPage().removePrescription();
        getPrescriptionOnceExecutionPage().assertPrescriptionsCount(0);
    }

    public void returnToNurseDepartPage() {
        getButton(BACK).click();
    }

    public void addExecutedOncePrescription(HospitalData patient, PrescriptionData prescription, StoreSupplyData storeSupply) {
        clickExecuteOnceButton();
        getPrescriptionOnceExecutionPage().assertInfoPanel(patient);
        getPrescriptionOnceExecutionPage().addExecutedOncePrescription(prescription, storeSupply);
    }

    public void assertStoreBalanceChanged(StoreSupplyData storeSupply, int difference) {
        getPrescriptionOnceExecutionPage().assertStoreBalanceChanged(storeSupply, difference);
    }

    public void assertExecutedOncePrescription(PrescriptionData prescription) {
        getPrescriptionOnceExecutionPage().assertPrescriptionTableRowValues(0, prescription);
    }
}
