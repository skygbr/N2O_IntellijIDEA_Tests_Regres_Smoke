package businessFramework.module.hospital.modals.bedSpace;

import businessFramework.entities.hospital.reservation.ReservationData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.Page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class BedSpaceModal implements Values {

    private Page page = Page.getInstance();
    private BedSpaceModalHelper helper;

    private static String reservationBeginsColumn =  "Запланировано (М/Ж)";
    private static String reservedColumn =  "Занято плановыми пациентами (М/Ж)";

    private int reservationBeginsCount_plannedDate;
    int reservedCount_plannedDate;
    int reservationBeginsCount_oneDayAfterPlannedDate;
    int reservedCount_oneDayAfterPlannedDate;

    public BedSpaceModal() {
        helper = new BedSpaceModalHelper();
    }

    public void assertHeader() {
        helper.getModal().assertModalHeader_equal("Состояние коечного фонда");
    }

    public void assertFilterValuesReceivedFromForm(ReservationData reservationData) {
        helper.getFilterDtField().assertThatBeginDateContainsValue(reservationData.getPlannedDate());
        helper.getFilterDtField().assertThatEndDateContainsValue(page.getDateBeforeAfterCurrent(6));
        helper.getFilterRegimenField().assertValue_contains(reservationData.getRegimen());
        helper.getFilterDepartmentField().assertValue_contains(reservationData.getDepartment());
        helper.getFilterProfileField().assertValue_contains(reservationData.getProfile());
        helper.getFilterBedProfileField().assertValue_contains(reservationData.getBedProfile());
    }

    public void choseAnotherFilterValues_assertListFiltered(ReservationData reservationData) {
        helper.getFilterDepartmentField().setValue(reservationData.getDepartment());
        helper.getFilterProfileField().setValue(reservationData.getProfile());
        helper.getFilterBedProfileField().setValue(reservationData.getBedProfile());
        helper.getGridTableFilter().clickFindButton();
        assertListWasFiltered(reservationData);
    }

    public void chooseDate() {
        helper.getGridTable().chooseRowInTable(3);
        helper.getConfirmButton().click();
    }

    public void assertListWasFiltered(ReservationData reservationData) {
        assertRowColumnValue(0, reservationData.getDepartment());
        assertRowColumnValue(1, reservationData.getProfile());
        assertRowColumnValue(2, reservationData.getBedProfile());
        assertRowColumnValue(3, reservationData.getPlannedDate().substring(0,5));

        helper.getGridTable().assertThatCountOfRowsIs(10); // 3 + 7 листьев
    }

    public void assertRowColumnValue(int row, String expectedValue) {
        String columnName = "Отделение/ Профиль/ Профиль койки/ Дата";
        String value = getRowColumnValue(row, columnName);
        assertThat("Column '" + columnName + "' value does not contain expected", value.toLowerCase(), containsString(expectedValue.toLowerCase()));
    }

    private String getRowColumnValue(int row, String columnName) {
        return helper.getGridTable().getRowValues(row, true).get(helper.getGridTable().getSerialNumberColumn(columnName) - 1);
    }

    private int getCountFromGrid(int row, String columnName) {
        return Integer.valueOf(getRowColumnValue(row, columnName).trim().split("\\(")[0]);
    }

    public void saveCount() {
        this.reservationBeginsCount_plannedDate = getCountFromGrid(3, reservationBeginsColumn);
        this.reservedCount_plannedDate = getCountFromGrid(3, reservedColumn);

        this.reservationBeginsCount_oneDayAfterPlannedDate = getCountFromGrid(4, reservationBeginsColumn);
        this.reservedCount_oneDayAfterPlannedDate = getCountFromGrid(3, reservedColumn);
    }

    public void assertBalanceChanged(ReservationData reservationData, int difference){
        assertHeader();
        assertListWasFiltered(reservationData);
        helper.getGridTable().chooseRowInTable(3);
        // день начала
        assertCount(3, reservationBeginsColumn, reservationBeginsCount_plannedDate + difference);
        assertCount(3, reservedColumn, reservedCount_plannedDate);
        // следующий день
        assertCount(4, reservationBeginsColumn, reservationBeginsCount_oneDayAfterPlannedDate);
        assertCount(4, reservedColumn, reservedCount_oneDayAfterPlannedDate + difference);
    }


    private void assertCount(int row, String columnName, int expectedCount) {
        int currentCount = getCountFromGrid(row, columnName);
        assertThat(String.format("Count was not correctly changed (column '%s', row %s).\n Current count = %s\n Expected count = %s",
                        "Запланировано (М/Ж)", row, currentCount, expectedCount),
                currentCount == expectedCount);
    }


    public void closeBedSpaceModal() {
        helper.getModal().closeModal();
    }
}