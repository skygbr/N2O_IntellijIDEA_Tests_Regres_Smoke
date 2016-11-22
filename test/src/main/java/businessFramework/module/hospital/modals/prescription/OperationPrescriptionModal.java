package businessFramework.module.hospital.modals.prescription;

import businessFramework.entities.hospital.StoreSupplyData;
import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.module.hospital.modals.medicament.HoldingModal;
import businessFramework.module.hospital.pages.prescriptionOnceExecution.HoldingBalanceModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

/**
 * @author agabdrakhmanova
 * @since 18.11.2015
 */
public class OperationPrescriptionModal extends OperationPrescriptionHelper {

    private HoldingBalanceModal holdingBalanceModal;

    public OperationPrescriptionModal(ApplicationManager app) {
        holdingBalanceModal = new HoldingBalanceModal(app);
    }

    public void create(PrescriptionData prescriptionData, StoreSupplyData storeSupplyData) {
        getHolding().findModalButtonClick();
        holdingBalanceModal.chooseHolding(storeSupplyData);
        getHolding().assertValue_contains(storeSupplyData.getHoldingName());
        getCount().setValue(String.valueOf(prescriptionData.getHoldings().get(0).getCount()));
        assertAutoFieldFields();
        getAdministrationRoute().setValue(prescriptionData.getAdministrationRoute());
        getConfirmButton().click();
    }


    public void checkBalanceAfterWriteOff(StoreSupplyData storeSupplyData, int difference) {
        getHolding().findModalButtonClick();
        holdingBalanceModal.assertBalanceChanged(storeSupplyData, difference);
    }

    //    duplicate method in PrescriptionOnceExecutionPage
    private void assertAutoFieldFields() {
        assertFieldValueIsNotEmpty(getDose().getValue(), "Доза");
        assertFieldValueIsNotEmpty(getDoseWithMeasureField().getText(), "Дозировка");
        assertFieldValueIsNotEmpty(getMneiNameField().getText(), "Основная ед.изм.");
    }

    private void assertFieldValueIsNotEmpty(String value, String label) {
        assertThat(String.format("Field '%s' value is expected to be not null or empty", label),
                value, not(isEmptyOrNullString()));
    }
}
