package businessFramework.module.hospital.pages.hospitalReferral;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HospitalReferralHelper extends Page implements Values {
    protected HospitalReferralHelper(ApplicationManager app) {
        super(app);
    }

    // Список

    protected Container getContainerReferrals() {
        return getRegion(TOP).getContainer("hospReferrals");
    }

    protected Table getTableReferrals() {
        return getContainerReferrals().getTable();
    }

    // Список: фильтр

    protected Filter getTableReferralsFilter() {
        return getContainerReferrals().getFilter();
    }

    protected InputDate getFilterDtField() {
        return getTableReferralsFilter().getInputDate("referralDate");
    }

    protected InputText getFilterNumberField() {
        return getTableReferralsFilter().getInputText("number");
    }

    protected Classifier getFilterRefTypeField() {
        return getTableReferralsFilter().getClassifier("referralType");
    }

    protected Classifier getFilterPatientField() {
        return getTableReferralsFilter().getClassifier("patient");
    }

    protected Classifier getFilterDiagnosisField() {
        return getTableReferralsFilter().getClassifier("diagnosis");
    }

    protected Classifier getFilterRefOrgField() {
        return getTableReferralsFilter().getClassifier("referralOrganization");
    }

    protected Classifier getFilterStatusField() {
        return getTableReferralsFilter().getClassifier("status");
    }

    protected InputCheckBox getFilterCitoCheckBox() {
        return getTableReferralsFilter().getInputCheckBox("isCito");
    }

    // Форма

    protected Container getReferralFormContainer() {
        return getRegion(SINGLE).getContainer("main");
    }

    protected Form getReferralForm() {
        return getReferralFormContainer().getForm();
    }

    protected Classifier getPatientField() {
        return getReferralForm().getClassifier("patient");
    }

    // Форма: блок Направлен из

    protected Classifier getRefOrgRoleField() {
        return getReferralForm().getClassifier("referralOrganizationRole");
    }

    protected Classifier getRefOrgField() {
        return getReferralForm().getClassifier("referralOrganization");
    }

    protected Classifier getRefDepField() {
        return getReferralForm().getClassifier("referralDepartment");
    }

    protected Classifier getRefEmployeeField() {
        return getReferralForm().getClassifier("referralEmployee");
    }

    // Форма: блок Направлен в

    protected Classifier getRecvOrgField() {
        return getReferralForm().getClassifier("recvOrganization");
    }

    protected Classifier getRecvDepField() {
        return getReferralForm().getClassifier("recvDepartment");
    }

    protected Classifier getRecvEmployeeField() {
        return getReferralForm().getClassifier("recvEmployee");
    }

    //  Форма: блок Основные данные

    protected InputDate getRefDateField() {
        return getReferralForm().getInputDate("referralDate");
    }

    protected InputText getOrderNumberField() {
        return getReferralForm().getInputText("orderNumber");
    }

    protected WebElement getOrderNumberLink() {
        return findElement(By.className("n2o-links-action_link"), getOrderNumberField().takeContainer());
    }

    protected InputCheckBox getCitoCheckBox() {
        return getReferralForm().getInputCheckBox("cito");
    }

    protected Classifier getRefTypeField() {
        return getReferralForm().getClassifier("referralType");
    }

    protected Classifier getRecvRegimenField() {
        return getReferralForm().getClassifier("recvRegimen");
    }

    protected Classifier getFinancialTypeField() {
        return getReferralForm().getClassifier("financialType");
    }

    protected InputText getRefCommentField() {
        return  getReferralForm().getInputText("referralComment");
    }

    // Форма: Диагноз

    protected Classifier getRefDiagnosisField() {
        return getReferralForm().getClassifier("referralDiagnosis");
    }

    protected InputText getDiagnosisCommentField() {
        return  getReferralForm().getInputText("referralDiagnosisComment");
    }

    // Форма: Статус

    protected OutputText getStatusOutput() {
        return getReferralForm().getOutputText("status.name");
    }


    // Форма: кнопки

    public Button getConfirmButton() {
        return this.getReferralFormContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getEditButton() {
        return this.getReferralFormContainer().getButton(SAVE_BUTTON);
    }

    public Button getBackButton() {
        return getButton(BACK);
    }

}