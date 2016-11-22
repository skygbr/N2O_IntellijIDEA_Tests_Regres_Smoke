package businessFramework.module.hospital.pages.reservation;

import businessFramework.entities.hospital.referral.HospReferralData;
import businessFramework.entities.hospital.reservation.ReservationData;
import businessFramework.module.hospital.modals.bedSpace.BedSpaceModal;
import net.framework.autotesting.ApplicationManager;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReservationPage extends ReservationHelper {

    public ReservationPage(ApplicationManager app) {
        super(app);
    }


    public void create_onExistingReferral(ReservationData reservationData) {
        getGridContainer().getButton(CREATE_BUTTON).click();
        fillAndConfirmForm(reservationData);
    }

    private void fillAndConfirmForm(ReservationData reservationData) {

        assertBreadcrumbContainsValue("Заявка на плановую госпитализацию");
        getReservationForm().assertThatFormIsEnabled();

        getPatientField().setValue(reservationData.getPatient());

        getReferralActionButton().click();

        getReferralField().setValue(reservationData.getExistingReferral().getOrderNumber());
        assertFieldsFilledAfterChoosingReferral(reservationData.getExistingReferral());

        getPlannedDateField().setValue(reservationData.getPlannedDate());
        getDepartmentField().setValue(reservationData.getDepartment());
        getRegimenField().setValue(reservationData.getRegimen());
        getProfileField().setValue(reservationData.getProfile());
        getBedProfileField().setValue(reservationData.getBedProfile());

        assertIssuePlannedDateCalculate(reservationData);

        getFinTypeField().setValue(reservationData.getFinancialType());

        getStatusField().assertFieldText("Регистрация");
        getConfirmButton().click();
        reservationData.setStatus("Зарегистрирована");
    }

    public void updateReservation(ReservationData reservationData) {

        getReferralField().removeValue();
        getReferralActionButton().click();
        fillReferralFields(reservationData.getNewReferral());

        getPlannedDateField().setValue(reservationData.getPlannedDate());
        getDepartmentField().setValue(reservationData.getDepartment());
        getRegimenField().setValue(reservationData.getRegimen());
        getProfileField().setValue(reservationData.getProfile());
        getBedProfileField().setValue(reservationData.getBedProfile());
        assertIssuePlannedDateCalculate_withEmptyDuration(reservationData);
        getFinTypeField().setValue(reservationData.getFinancialType());

        getStatusField().assertFieldText("Зарегистрирована");
        getConfirmButton().click();
    }

    public void bedSpaceTest(ReservationData reservationData, ReservationData reservation_bedSpace, HospReferralData referralData) {
        getGridContainer().getButton(UPDATE_BUTTON).click();
        assertBreadcrumbContainsValue("Заявка на плановую госпитализацию - " + reservationData.getPatient());
        getReservationForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        getReservationForm().assertThatFormIsEnabled();

        openBedSpace();

        BedSpaceModal bedSpaceModal = new BedSpaceModal();
        bedSpaceModal.assertHeader();
        bedSpaceModal.assertFilterValuesReceivedFromForm(reservationData);
        bedSpaceModal.assertListWasFiltered(reservationData);
        bedSpaceModal.choseAnotherFilterValues_assertListFiltered(reservation_bedSpace);
        bedSpaceModal.saveCount();
        bedSpaceModal.chooseDate();

        assertModalPresentOnPage(false);
        assertValuesReceivedFromBedSpace(reservation_bedSpace);
        getIssuePlannedDateField().assertValue_equals("");
        assertIssuePlannedDateCalculate_withEmptyDuration(reservation_bedSpace);
        getConfirmButton().click();

        getReservationForm().getAlerts().assertSuccessAlertIsPresent();
        assertBreadcrumbContainsValue("Заявка на плановую госпитализацию");
        getReservationForm().assertThatFormIsDisable();
        getFormEditButton().click();
        reservation_bedSpace.setStatus("Зарегистрирована");

        openBedSpace();
        bedSpaceModal.assertBalanceChanged(reservation_bedSpace, 1);
        bedSpaceModal.closeBedSpaceModal();
    }

    private void openBedSpace() {
        getBedSpaceButton().click();
        sleep(5); // todo remove after bugfix
        assertModalPresentOnPage(true);
    }

    private void assertValuesReceivedFromBedSpace(ReservationData reservationData) {
        getPlannedDateField().assertValue_contains(reservationData.getPlannedDate());
        getDepartmentField().assertValue_contains(reservationData.getDepartment());
        getProfileField().assertValue_contains(reservationData.getProfile());
        getBedProfileField().assertValue_contains(reservationData.getBedProfile());
    }

    private void fillReferralFields(HospReferralData referralData) {
        getRefOrgRoleField().setValue(referralData.getRefOrgRole());
        getRefOrgField().setValue(referralData.getRefOrg());
        getRefDepField().setValue(referralData.getRefDep());
        getRefDateField().setValue(referralData.getRefDate());
        assertReferralNumerator();
        getOrderNumberField().setValue(referralData.getOrderNumber());
        getRefDiagnosisField().setValue(referralData.getRefDiagnosis());
        getDiagnosisCommentField().setValue(referralData.getRefDiagnosisComment());
    }

    private void assertReferralNumerator() {
        assertOrderNumberActionLinkIsEnabled(true);
        getOrderNumberLink().click();
        assertOrderNumberIsNotEmpty();
    }

    public void assertFieldsFilledAfterChoosingReferral(HospReferralData referralData) {
        assertReadOnlyReferralFields(referralData);
        getDepartmentField().assertValue_contains(referralData.getRecvDep());
        getRegimenField().assertValue_contains(referralData.getRecvRegimen());
        getFinTypeField().assertValue_equals(referralData.getFinType());
    }

    public void assertReadOnlyReferralFields(HospReferralData referralData) {
        getRefOrgRoleField().assertValue_contains(referralData.getRefOrgRole());
        getRefOrgField().assertValue_contains(referralData.getRefOrg());
        getRefDepField().assertValue_contains(referralData.getRefDep());
        getRefDateField().assertValue_contains(referralData.getRefDate());
        getOrderNumberField().assertValue(referralData.getOrderNumber());
        assertOrderNumberActionLinkIsEnabled(false);
        getRefDiagnosisField().assertValue_contains(referralData.getRefDiagnosis());
        getDiagnosisCommentField().assertValue(referralData.getRefComment());
    }

    public void assertIssuePlannedDateCalculate_withEmptyDuration(ReservationData reservationData) {
        getDurationField().clearValue();
        // Cредняя длительность. скрытое поле. Значеие из настроек
        String avgBedDaysValue =  findElement(By.tagName("input"), getAvgBedDaysField().takeContainer()).getAttribute("value").trim();
        reservationData.setAvgBedDays(Integer.valueOf(avgBedDaysValue));
        getDurationActionButton().click();
        getDurationField().assertValue(String.valueOf(reservationData.getAvgBedDays()));
        // Алгоритм 1 - ONLY_OUTCOME_DAY
        String expectedCalculatedDate = getDateBeforeAfterCurrent(reservationData.getAvgBedDays());
        getIssuePlannedDateField().assertValue_contains(expectedCalculatedDate);
        reservationData.setDuration(Integer.valueOf(getDurationField().getValue()));
        reservationData.setIssuePlannedDate(getIssuePlannedDateField().getValue());
    }

    public void assertIssuePlannedDateCalculate(ReservationData reservationData) {
        getDurationField().setValue(String.valueOf(reservationData.getDuration()));

        getDurationActionButton().click();
        getDurationField().assertValue(String.valueOf(reservationData.getDuration()));
        // Алгоритм 1 - ONLY_OUTCOME_DAY
        String expectedCalculatedDate = getDateBeforeAfterCurrent(reservationData.getDuration());
        getIssuePlannedDateField().assertValue_contains(expectedCalculatedDate);
        reservationData.setIssuePlannedDate(getIssuePlannedDateField().getValue());
    }


    public void assertForm(ReservationData reservationData, HospReferralData referralData) {
        getReservationForm().getAlerts().assertSuccessAlertIsPresent();
        assertBreadcrumbContainsValue("Заявка на плановую госпитализацию");
        getReservationForm().assertThatFormIsDisable();
        getFormEditButton().click();

        getPatientField().assertValue_equals(referralData.getPatient());

        getReferralField().assertValue_contains(referralData.getOrderNumber());
        getReferralActionButton().click();
        assertReadOnlyReferralFields(referralData);

        getPlannedDateField().assertValue_equals(reservationData.getPlannedDate());
        getDepartmentField().assertValue_equals(reservationData.getDepartment());
        getRegimenField().assertValue_equals(reservationData.getRegimen());
        getProfileField().assertValue_equals(reservationData.getProfile());
        getBedProfileField().assertValue_contains(reservationData.getBedProfile());
        getDurationField().assertValue(String.valueOf(reservationData.getDuration()));
        getIssuePlannedDateField().assertValue_equals(reservationData.getIssuePlannedDate());
        getFinTypeField().assertValue_contains(reservationData.getFinancialType());
        getStatusField().assertFieldText(reservationData.getStatus());
    }

    public void backToGrid() {
        getBackButton().click();
        assertBreadcrumbContainsValue("Журнал очереди на госпитализацию");
    }

    public void findReservation(ReservationData reservationData) {
        getGridContainer().showFilter();
        getFilterDtField().setBeginDateValue(getCurrentDate());
        getFilterDtField().setEndDateValue(getCurrentDate());
        getFilterDepartmentField().setValue(reservationData.getDepartment());
        getFilterProfileField().setValue(reservationData.getProfile());
        getFilterPatientField().setValue(reservationData.getPatient());
        getFilterStatusField().setValue(reservationData.getStatus());

        getGridTableFilter().clickFindButton();
        getGridTable().assertThatCountOfRowsIs(1);
    }

    private void assertOrderNumberActionLinkIsEnabled(boolean isEnabled)  {
        assertThat("Link 'Заполнить' expected to be " + (isEnabled ? "enabled" : "disabled"),
                getOrderNumberLink().getAttribute("class").contains("disabled"), is(!isEnabled));
    }

    private void assertOrderNumberIsNotEmpty()  {
        assertThat("Link 'Заполнить' expected to fill order number field " ,
                getOrderNumberField().getValue(), not(isEmptyOrNullString()));
    }


    public void remove(ReservationData reservationData) {
        getGridContainer().showFilter();
        getGridTableFilter().clickClearButton();
        openFilteredList_byPatient(reservationData);
        getGridTable().assertThatCountOfRowsIs(1);
        clickRemoveAssertSuccess();
    }

    public void removePatientReservations(ReservationData reservationData) {
        openFilteredList_byPatient(reservationData);
        while (getGridTable().getCountRowsInTable(true) > 0) {
            getGridTable().chooseRowInTable(0);
            clickRemoveAssertSuccess();
        }
        getGridContainer().showFilter();
        getGridTableFilter().clickClearButton();
    }

    private void clickRemoveAssertSuccess() {
        getGridContainer().getButton(DELETE_BUTTON).assertIsEnabled();
        getGridContainer().getButton(DELETE_BUTTON).click();
        getModal().getButton(CONFIRM_BUTTON).click();
        getGridTable().getAlerts().assertSuccessAlertIsPresent();
        getGridTable().assertThatCountOfRowsIs(0);
    }


    private void openFilteredList_byPatient(ReservationData reservationData){
        openUrl(getRefFilteredListUrl("patient:id", String.valueOf(reservationData.getPatientId())));
    }

    private String getRefFilteredListUrl(String paramName, String paramValue) {
        String baseUrl = app.getProperty("baseUrl");
        baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        return baseUrl + "#hospital.reservationList?reservationList:filter:" + paramName + "=" + paramValue;
    }
}
