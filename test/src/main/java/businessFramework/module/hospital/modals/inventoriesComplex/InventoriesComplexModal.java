package businessFramework.module.hospital.modals.inventoriesComplex;

import businessFramework.entities.hospital.prescription.PrescriptionData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.hospital.modals.inventories.InventoriesModal;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class InventoriesComplexModal extends InventoriesComplexHelper {

    public InventoriesComplexModal(ApplicationManager app) {
        super(app);
    }

    public InventoriesModal getInventoriesModal() {
        return new InventoriesModal();
    }

    public void fillForm(PrescriptionData prescriptionData) {
        assertCountOfVisibleHoldingRows(getCountOfVisibleHoldingRows(), prescriptionData.getHoldings().size());
        for (PrescriptionHoldingData holdingData : prescriptionData.getHoldings()) {
            assertHoldingAndFillCommodityStock(holdingData);
        }
        getButtonConfirm().click();
    }

    public void assertHoldingAndFillCommodityStock(PrescriptionHoldingData holdingData) {
        int index = holdingData.getIndex();
        String value = getHoldingField(index).getText();
        assertThat("Holding name assertion failed", value, containsString(holdingData.getHolding()));
        if (!holdingData.isPatientMedicament()) {
            getIsPatientMedicamentForSchedule(index).assertIsDisabled(false);
            getCommodityStockField(index).findModalButtonClick();
            getInventoriesModal().selectInventory_fromComplexForm(holdingData);
            if (getCommodityStockField(index).getValue().isEmpty()) {
                getIsPatientMedicamentForSchedule(index).check(true);
                holdingData.setPatientMedicament(true);
            }
            //assertThat(String.format("Field 'Товарный запас'(row %s) must be %s", index, !getCommodityStockField(index).getValue().isEmpty() ? "enabled" : "disabled" ), getCommodityStockField(index).isDisabled() == getCommodityStockField(index).getValue().isEmpty()); //todo Вернуть после решения https://jira.is-mis.ru/browse/RMISDEV-2503
        } else {
            getIsPatientMedicament(index).assertIsDisabled();
            getIsPatientMedicament(index).assertThatCheckboxIsChecked(true);
        }
    }

    private void assertCountOfVisibleHoldingRows(int actualCount, int expectedCount) {
        assertThat("Holding rows assertion: count of visible rows is not equal to expected",
                actualCount, is(expectedCount));
    }
}
