package businessFramework.module.hospital.modals.inventories;

import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.Table;

public class InventoriesModal implements Values {
    private InventoriesHelper inventoriesHelper;

    public InventoriesModal() {
        inventoriesHelper = new InventoriesHelper();
    }

    public void selectInventory(PrescriptionHoldingData holdingData) {
        inventoriesHelper.getContainer().getTable().chooseRowInTable(0);
        saveHoldingExecutionData(holdingData);
        inventoriesHelper.getExecuteButton().click();
        inventoriesHelper.getContainer().getTable().getAlerts().assertSuccessAlertMessage(MESSAGE_SUCCESS);
        inventoriesHelper.closeInventoriesModal();
    }

    public void selectInventory_fromComplexForm(PrescriptionHoldingData holdingData) {
        if (inventoriesHelper.getContainer().getTable().getCountRowsInTable(true) > 0) {
            inventoriesHelper.getContainer().getTable().chooseRowInTable(0);
            saveHoldingExecutionData(holdingData);
            inventoriesHelper.getConfirmButton().click();
        } else {
            inventoriesHelper.getCancelButton().click();
        }
    }

    private void saveHoldingExecutionData(PrescriptionHoldingData holdingData) {
        Table table = inventoriesHelper.getContainer().getTable();
        int index = table.getChosenRowNumber();
        holdingData.setStore(table.getRowColumnIntersectionValue(index, "Склад", true));
        holdingData.setModification(table.getRowColumnIntersectionValue(index, "Модификация", true));
    }
}