package businessFramework.module.hospital.pages.hospitalReferral;

import businessFramework.entities.hospital.referral.HospReferralData;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HospitalReferralPage extends HospitalReferralHelper {

    public HospitalReferralPage(ApplicationManager app) {
        super(app);
    }

    public void createReferral(HospReferralData referralData) {
        getContainerReferrals().getButton(CREATE_BUTTON).click();
        fillAndConfirmReferralForm(referralData, true);
    }

    public void assertReferral(HospReferralData referralData) {
        getReferralForm().getAlerts().assertSuccessAlertIsPresent();
        getReferralForm().assertThatFormIsDisable();
        assertBreadcrumbContainsValue("Направление");

        getPatientField().assertValue_equals(referralData.getPatient());
        getRefOrgRoleField().assertValue_equals(referralData.getRefOrgRole());
        getRefOrgField().assertValue_equals(referralData.getRefOrg());
        getRefDepField().assertValue_contains(referralData.getRefDep());
        getRefEmployeeField().assertValue_contains(referralData.getRefEmployee());

        getRecvOrgField().assertValue_equals(referralData.getRecvOrg());
        getRecvDepField().assertValue_contains(referralData.getRecvDep());
        getRecvEmployeeField().assertValue_contains(referralData.getRecvEmployee());

        getRefDateField().assertValue_contains(referralData.getRefDate());
        getCitoCheckBox().assertThatCheckboxIsChecked(referralData.getCito());
        getRefTypeField().assertValue_equals(referralData.getRefType());
        getRecvRegimenField().assertValue_equals(referralData.getRecvRegimen());
        getFinancialTypeField().assertValue_equals(referralData.getFinType());
        getRefCommentField().assertValue(referralData.getRefComment());
        getOrderNumberField().assertValue(referralData.getOrderNumber());

        getRefDiagnosisField().assertValue_contains(referralData.getRefDiagnosis());
        getDiagnosisCommentField().assertValue(referralData.getRefDiagnosisComment());
    }

    public void backToReferralList() {
        getBackButton().click();
        assertBreadcrumbContainsValue("Журнал направлений");
    }

    public void findReferral(HospReferralData referralData) {
        getContainerReferrals().showFilter();
        getFilterDtField().setBeginDateValue(referralData.getRefDate());
        getFilterDtField().setEndDateValue(referralData.getRefDate());
        getFilterNumberField().setValue(referralData.getOrderNumber());
        getFilterRefTypeField().setValue(referralData.getRefType());
        getFilterPatientField().setValue(referralData.getPatient());
        getFilterDiagnosisField().setValue(referralData.getRefDiagnosis());
        getFilterRefOrgField().setValue(referralData.getRefOrg());
        getTableReferralsFilter().clickFindButton();

        getTableReferrals().assertThatCountOfRowsIs(1);
    }

    public void updateReferral(HospReferralData referralData) {
        getContainerReferrals().getButton(UPDATE_BUTTON).click();

        assertBreadcrumbContainsValue("Направление - " + referralData.getPatient());
        getReferralForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
        getReferralForm().assertThatFormIsEnabled();

        referralData.setRefComment("Редактирование");
        getRefCommentField().setValue(referralData.getRefComment());

        getConfirmButton().click();
    }

    private void fillAndConfirmReferralForm(HospReferralData referralData, boolean isCreate) {
        if (isCreate)
            assertFormDefaultValues();

        assertBreadcrumbContainsValue("Направление");
        getReferralForm().assertThatFormIsEnabled();
        getPatientField().setValue(referralData.getPatient());
        getRefOrgRoleField().setValue(referralData.getRefOrgRole());
        getRefOrgField().setValue(referralData.getRefOrg());
        getRefDepField().setValue(referralData.getRefDep());
        getRefEmployeeField().setValue(referralData.getRefEmployee());

        getRecvOrgField().setValue(referralData.getRecvOrgCode() + " " + referralData.getRecvOrg());
        getRecvDepField().setValue(referralData.getRecvDep());
        getRecvEmployeeField().setValue(referralData.getRecvEmployee());

        getRefDateField().setValue(referralData.getRefDate());
        getCitoCheckBox().check(referralData.getCito());
        getRefTypeField().setValue(referralData.getRefType());
        getRecvRegimenField().setValue(referralData.getRecvRegimen());
        getFinancialTypeField().setValue(referralData.getFinType());
        getRefCommentField().setValue(referralData.getRefComment());

        assertOrderNumberActionLinkIsEnabled(true);  // если направляющая МО = мо из контекста, заполнена дата и тип направлния
        getOrderNumberLink().click();
        assertOrderNumberIsNotEmpty();

        getOrderNumberField().setValue(referralData.getOrderNumber());

        getRefDiagnosisField().setValue(referralData.getRefDiagnosis());
        getDiagnosisCommentField().setValue(referralData.getRefDiagnosisComment());

        getConfirmButton().click();
    }

    private void assertFormDefaultValues() {
        getRefOrgRoleField().assertValue_equals("МО");
        getRefDateField().assertValue_equals(getCurrentDate());
        assertOrderNumberActionLinkIsEnabled(false);
        getStatusOutput().assertFieldText("Черновое");
    }

    private void assertOrderNumberActionLinkIsEnabled(boolean isEnabled)  {
        assertThat("Link 'Заполнить' expected to be " + (isEnabled ? "enabled" : "disabled"),
                getOrderNumberLink().getAttribute("class").contains("disabled"), is(!isEnabled));
    }

    private void assertOrderNumberIsNotEmpty()  {
        assertThat("Link 'Заполнить' expected to fill order number field " ,
                getOrderNumberField().getValue(), not(isEmptyOrNullString()));
    }


    public void removeReferral(HospReferralData referralData) {
        openFilteredList_theOnlyRecord(referralData);
        clickRemoveAssertSuccess();
    }

    public void removeReferralIfExist(HospReferralData referralData) {
        openUrl(getRefFilteredListUrl("number", referralData.getOrderNumber()));
        while (getTableReferrals().getCountRowsInTable(true) > 0){
            getTableReferrals().chooseRowInTable(0);
            clickRemoveAssertSuccess();
        }
        getContainerReferrals().showFilter();
        getTableReferralsFilter().clickClearButton();
    }

    public void removePatientReferrals(HospReferralData referralData) {
        openFilteredList_byPatient(referralData);
        while (getTableReferrals().getCountRowsInTable(true) > 0) {
            getTableReferrals().chooseRowInTable(0);
            clickRemoveAssertSuccess();
        }
        getContainerReferrals().showFilter();
        getTableReferralsFilter().clickClearButton();
    }

    private void clickRemoveAssertSuccess() {
        getContainerReferrals().getButton(DELETE_BUTTON).assertIsEnabled();
        getContainerReferrals().getButton(DELETE_BUTTON).click();
        getModal().getButton(CONFIRM_BUTTON).click();
        assertReferralsTableSuccessMessageExists();
    }

    private void openFilteredList_theOnlyRecord(HospReferralData referralData){
        openUrl(getRefFilteredListUrl("number", referralData.getOrderNumber()));
        getContainerReferrals().assertCountTable(1);
        getContainerReferrals().getTable().chooseRowInTable(0);
    }

    private void openFilteredList_byPatient(HospReferralData referralData){
        openUrl(getRefFilteredListUrl("patient:id", String.valueOf(referralData.getPatientId())));
    }

    private String getRefFilteredListUrl(String paramName, String paramValue) {
        String baseUrl = app.getProperty("baseUrl");
        baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        return baseUrl + "#hospital.hospReferralList?hospReferrals:filter:" +paramName + "=" + paramValue;
    }

    private void assertReferralsTableSuccessMessageExists() {
        getTableReferrals().getAlerts().assertSuccessAlertIsPresent();
    }
}
