package businessFramework.module.hospital.pages.prescriptionOnceExecution;


import businessFramework.entities.hospital.StoreSupplyData;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class HoldingBalanceModal extends PrescriptionOnceExecutionHelper implements PrescriprionOnceExecutionValues {

    public HoldingBalanceModal(ApplicationManager app) {
        super(app);
    }

    private void assertHeader() {
        getModal().assertModalHeader_equal(MODAl_HOLDING_BALANCE_TITLE);
    }

    private void filterHolding(StoreSupplyData data) {
        getFilterHoldingField().setValue(data.getHoldingName());
        getComGroupField().setValue(data.getComGroup());
        getFundSourceField().setValue(data.getFundingSource());
        getStoreField().setValue(data.getStoreName());
        getModalFilter().clickFindButton();
        assertListWasFiltered(data);
    }

    private void assertListWasFiltered(StoreSupplyData data) {
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put(COLUMN_STORE, data.getStoreName());
        columnValues.put(COLUMN_MODIFICATION, data.getHoldingName());
        columnValues.put(COLUMN_FUNDING_SOURCE, data.getFundingSource());

        for (int i_row = 0; i_row < getStoreBalanceTable().getCountRowsInTable(true); i_row++)
            getStoreBalanceTable().assertThatRowColumnsIntersectionValueContains(i_row, columnValues);
    }

    private int getBalance(int row) {
        String value = getStoreBalanceTable().getRowColumnIntersectionValue(row, "Остаток", true).trim();
        return Integer.valueOf(value.split("\\s+")[0]);
    }

    public void assertBalanceChanged(StoreSupplyData data, int difference){
        assertHeader();
        filterHolding(data);
        getStoreBalanceTable().chooseRowInTable(0);
        int currentBalance = getBalance(0);
        assertThat(String.format("%s was not written off. Balance was not correctly changed.\n Current balance = %s\n Expected balance = %s",
                        data.getHoldingName(), currentBalance, data.getBalance()),
                currentBalance == data.getBalance() + difference);
        data.setBalance(currentBalance);
        getModal().getButton(CANCEL).click();
    }

    public void chooseHolding(StoreSupplyData data){
        assertHeader();
        filterHolding(data);
        getStoreBalanceTable().chooseRowInTable(0);
        data.setBalance(getBalance(0));
        getModal().getButton(CONFIRM_BUTTON).click();
    }
}