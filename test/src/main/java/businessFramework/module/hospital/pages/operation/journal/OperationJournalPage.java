package businessFramework.module.hospital.pages.operation.journal;

import businessFramework.entities.hospital.OperationServiceData;
import businessFramework.entities.hospital.StoreSupplyData;
import businessFramework.entities.hospital.SurgicalTeamData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.module.hospital.modals.operPlanning.OperationPlanningModal;
import businessFramework.module.hospital.modals.operPlanning.SurgicalTeamModal;
import businessFramework.module.hospital.modals.prescription.OperationPrescriptionModal;
import businessFramework.module.hospital.modals.prescription.PrescriptionModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.test.DateUtil;

/**
 * @author agabdrakhmanova
 * @since 16.11.2015
 */
public class OperationJournalPage extends OperationJournalHelper {
    private OperationPlanningModal operationPlanningModal;
    private SurgicalTeamModal surgicalTeamModal;
    private OperationPrescriptionModal operationPrescriptionModal;

    public OperationJournalPage(ApplicationManager app) {
        super(app);
        operationPlanningModal = new OperationPlanningModal();
        surgicalTeamModal = new SurgicalTeamModal();
        operationPrescriptionModal = new OperationPrescriptionModal(app);
    }

    public void createPlannedOperation(OperationServiceData operationServiceData) {
        getOperationJournalContainer().clickDropdown("Еще", "Добавить операцию", "createPlannedOperation");
        assertModalPresentOnPage(true);
        operationPlanningModal.fillForm(operationServiceData, true);
        operationPlanningModal.clickConfirmButton();
        getOperationJournalContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deletePlannedOperation() {
        getOperationJournalContainer().clickDropdown("Еще", "Удалить", "delete");
        getDialog().clickYes();
        getOperationJournalContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void filterByDate(String dt) {
        getOperationJournalContainer().showFilter();
        String dtFilter = DateUtil.getDateWithoutTime(dt);
        getOperationJournalContainer().getFilter().getInputDate("plannedDate").setPeriod(dtFilter, dtFilter);
        getOperationJournalContainer().getFilter().clickFindButton();
    }

    public void render() {
        getRenderButton().assertIsDisplayed(true);
        getCancelRenderButton().assertIsDisplayed(false);
        getSurgicalTeamContainer().assertThatContainerIsHidden(true);

        getRenderButton().click();
        getOperationJournalContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        checkAfterRender();
    }

    public void cancelRender() {
        getRenderButton().assertIsDisplayed(false);
        getCancelRenderButton().assertIsDisplayed(true);

        getCancelRenderButton().click();
        getDialog().clickYes();

        getOperationJournalContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        getOperationJournalContainer().getTable().assertIconInRowOnColumn(0, "", "icomoon-clock");
        getRenderButton().assertIsDisplayed(true);
        getCancelRenderButton().assertIsDisplayed(false);
        getSurgicalTeamContainer().assertThatContainerIsHidden(true);
    }

    public void checkAfterRender() {
        getOperationJournalContainer().getTable().assertIconInRowOnColumn(0, "", "icomoon-checkmark");
        getRenderButton().assertIsDisplayed(false);
        getCancelRenderButton().assertIsDisplayed(true);
        getSurgicalTeamContainer().assertThatContainerIsHidden(false);
    }

    //Surgical Team
    public void addEmployeeToSurgicalTeam(SurgicalTeamData surgicalTeamData) {
        getAddEmployeeToSurgicalTeamButton().assertIsEnabled();
        getAddEmployeeToSurgicalTeamButton().click();
        assertModalPresentOnPage(true);
        surgicalTeamModal.saveForm(surgicalTeamData);
        getSurgicalTeamContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void updateEmployeeInSurgicalTeam(SurgicalTeamData surgicalTeamData1, SurgicalTeamData surgicalTeamData2) {
        getUpdateEmployeeInSurgicalTeamButton().assertIsEnabled();
        getUpdateEmployeeInSurgicalTeamButton().click();
        assertModalPresentOnPage(true);
        surgicalTeamModal.assertForm(surgicalTeamData1);
        surgicalTeamModal.saveForm(surgicalTeamData2);
        getSurgicalTeamContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void deleteEmployeeFromTeam() {
        getDeleteEmployeeFromSurgicalTeamButton().assertIsEnabled();
        getDeleteEmployeeFromSurgicalTeamButton().click();
        getDialog().clickYes();
        getSurgicalTeamContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        getSurgicalTeamContainer().getTable().assertThatCountOfRowsIs(0);
    }

    //Prescription
    public void createPrescription(PrescriptionData prescriptionData, StoreSupplyData storeSupplyData) {
        getAddPrescriptionButton().assertIsEnabled();
        getAddPrescriptionButton().click();
        assertModalPresentOnPage(true);
        operationPrescriptionModal.create(prescriptionData, storeSupplyData);

        getPrescriptionListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void checkBalance(StoreSupplyData storeSupplyData, int difference) {
        getAddPrescriptionButton().click();
        assertModalPresentOnPage(true);
        operationPrescriptionModal.checkBalanceAfterWriteOff(storeSupplyData, difference);
        getModal().closeModal();
    }

    public void deletePrescription()
    {
        getDeletePrescriptionButton().assertIsEnabled();
        getDeletePrescriptionButton().click();
        getDialog().clickYes();
        getPrescriptionListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

    public void checkCancelRenderAfterWriteOff() {
        getCancelRenderButton().assertIsDisplayed(true);

        getCancelRenderButton().click();
        getDialog().clickYes();

        getOperationJournalContainer().getTable().getAlerts().assertErrorAlertMessage("Для отмены необходимо отменить списание расходных материалов");
    }

}