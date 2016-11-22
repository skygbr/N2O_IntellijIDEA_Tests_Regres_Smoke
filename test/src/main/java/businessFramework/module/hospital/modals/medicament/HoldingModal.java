package businessFramework.module.hospital.modals.medicament;

import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import net.framework.autotesting.meta.Table;

import java.util.HashMap;
import java.util.Map;

public class HoldingModal {
    private HoldingHelper holdingHelper;

    public HoldingModal() {
        holdingHelper = new HoldingHelper();
    }

    public Table getHoldingTable() {
        return holdingHelper.getHoldingListContainer().getTable();
    }

    //Выбор препарата
    public void selectHolding(PrescriptionHoldingData holdingData) {
        filterHolding(holdingData);
        getHoldingTable().chooseRowInTable(0);
        saveHoldingDoseageAndMeasure(0, holdingData);
        holdingHelper.getButtonConfirm().click();
    }

    //Выбор препарата по индексу строки в табл
    public void selectHolding(Integer index, PrescriptionHoldingData holdingData) {
        getHoldingTable().chooseRowInTable(index);
        saveHoldingName(index, holdingData);
        saveHoldingDoseageAndMeasure(index, holdingData);
        holdingHelper.getButtonConfirm().click();
    }

    private void saveHoldingDoseageAndMeasure(int rowIndex, PrescriptionHoldingData holdingData) {
        String dosageAndMeasure = getHoldingTable().getRowColumnIntersectionValue(rowIndex, "Доза", true).trim();
        String doseValue = dosageAndMeasure.split(" ")[0];
        holdingData.setDosage(doseValue);
        holdingData.setDoseMeasure(dosageAndMeasure.replace(doseValue, "").trim());
    }

    private void saveHoldingName(int rowIndex, PrescriptionHoldingData holdingData) {
        String name = getHoldingTable().getRowColumnIntersectionValue(rowIndex, "Наименование", true).trim();
        holdingData.setHolding(name.split(",")[0].trim());
    }

    private void filterHolding(PrescriptionHoldingData holdingData) {
        holdingHelper.getFilterHoldingField().setValue(holdingData.getHolding());
        holdingHelper.getModalFilter().clickFindButton();
        assertListWasFiltered(holdingData);
    }

    private void assertListWasFiltered(PrescriptionHoldingData holdingData) {
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put("Наименование", holdingData.getHolding());

        for (int i_row = 0; i_row < holdingHelper.getHoldingListTable().getCountRowsInTable(true); i_row++)
            holdingHelper.getHoldingListTable().assertThatRowColumnsIntersectionValueContains(i_row, columnValues);
    }

}