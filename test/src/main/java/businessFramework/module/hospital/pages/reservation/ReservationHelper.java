package businessFramework.module.hospital.pages.reservation;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReservationHelper extends Page implements Values {
    protected ReservationHelper(ApplicationManager app) {
        super(app);
    }

    // Список

    protected Container getGridContainer() {
        return getContainer("reservationList");
    }

    protected Table getGridTable() {
        return getGridContainer().getTable();
    }

    // Список: фильтр

    protected Filter getGridTableFilter() {
        return getGridContainer().getFilter();
    }

    protected InputDate getFilterDtField() {
        return getGridTableFilter().getInputDate("plannedDate");
    }

    protected Classifier getFilterDepartmentField() {
        return getGridTableFilter().getClassifier("department");
    }

    protected Classifier getFilterProfileField() {
        return getGridTableFilter().getClassifier("profile");
    }

    protected Classifier getFilterPatientField() {
        return getGridTableFilter().getClassifier("patient");
    }

    protected Classifier getFilterStatusField() {
        return getGridTableFilter().getClassifier("status");
    }

    // Форма

    protected Container getFormContainer() {
        return getRegion(SINGLE).getContainer("main");
    }

    protected Form getReservationForm() {
        return getFormContainer().getForm();
    }

    protected Classifier getPatientField() {
        return getReservationForm().getClassifier("patient");
    }

    // Форма: направление

    protected Classifier getReferralField() {
        return getReservationForm().getClassifier("rreferral");
    }

    protected WebElement getReferralActionButton() {
        return findElement(By.className("n2o-links-action_link"), getReferralField().takeContainer());
    }

    protected Classifier getRefOrgRoleField() {
        return getReservationForm().getClassifier("referralOrganizationRole");
    }

    protected Classifier getRefOrgField() {
        return getReservationForm().getClassifier("referralOrganization");
    }

    protected Classifier getRefDepField() {
        return getReservationForm().getClassifier("refDepartment");
    }

    protected InputDate getRefDateField() {
        return getReservationForm().getInputDate("referralDate");
    }

    protected InputText getOrderNumberField() {
        return getReservationForm().getInputText("orderNumber");
    }

    protected WebElement getOrderNumberLink() {
        return findElement(By.className("n2o-links-action_link"), getOrderNumberField().takeContainer());
    }

    protected Classifier getRefDiagnosisField() {
        return getReservationForm().getClassifier("referralDiagnosis");
    }

    protected InputText getDiagnosisCommentField() {
        return  getReservationForm().getInputText("referralDiagnosisComment");
    }

    // Форма: Планирование

    protected InputDate getPlannedDateField() {
        return getReservationForm().getInputDate("plannedDate");
    }

    protected WebElement getBedSpaceButton() {
        return findElement(By.className("n2o-links-action_link"), getReservationForm().getClassifier("bedSpace").takeContainer());
    }

    protected Classifier getDepartmentField() {
        return getReservationForm().getClassifier("department");
    }

    protected Classifier getRegimenField() {
        return getReservationForm().getClassifier("regimen");
    }

    protected Classifier getProfileField() {
        return getReservationForm().getClassifier("profile");
    }

    protected Classifier getBedProfileField() {
        return getReservationForm().getClassifier("bedProfile");
    }

    protected InputText getDurationField() {
        return  getReservationForm().getInputText("duration");
    }

    protected WebElement getDurationActionButton() {
        return findElement(By.className("n2o-links-action_link"), getDurationField().takeContainer());
    }

    protected InputText getAvgBedDaysField() {
        return getReservationForm().getInputText("avgBedDays");
    }

    protected InputDate getIssuePlannedDateField() {
        return getReservationForm().getInputDate("issuePlannedDate");
    }

    protected Classifier getFinTypeField() {
        return getReservationForm().getClassifier("financialType");
    }

    // Форма: Статус

    protected OutputText getStatusField() {
        return getReservationForm().getOutputText("status.name");
    }

    // Форма: кнопки

    public Button getConfirmButton() {
        return this.getFormContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getEditButton() {
        return this.getFormContainer().getButton(SAVE_BUTTON);
    }

    public Button getBackButton() {
        return getButton(BACK);
    }

    public Button getFormEditButton() {
        return this.getFormContainer().getButton("n2o-action-bulk-table");
    }

}