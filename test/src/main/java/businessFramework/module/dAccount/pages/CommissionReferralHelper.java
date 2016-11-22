package businessFramework.module.dAccount.pages;

import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author agabdrakhmanova
 * @since 15.01.2016
 */
public class CommissionReferralHelper extends Page implements Values {

    private String container;

    public CommissionReferralHelper(ApplicationManager app) {
        super(app);
        this.container = "c1";
    }

    public Container getContainer() {
        return getContainer(container);
    }

    public Classifier getPatient() {
        return getContainer().getForm().getClassifier("patient");
    }

    public Classifier getRecvOrganization() {
        return getContainer().getForm().getClassifier("recv_organization");
    }

    public InputText getOrderNumber() {
        return getContainer().getForm().getInputText("order_number");
    }

    public InputDate getReferralDate() {
        return getContainer().getForm().getInputDate("referral_date");
    }

    public Classifier getGoal() {
        return getContainer().getForm().getClassifier("goal");
    }

    public Classifier getClinicalForm() {
        return getContainer().getForm().getClassifier("clinicalForm");
    }

    public Diagnosis getDiagnosisTree() {
        return new Diagnosis(app, getContainer().getForm().getFormElement(), "main_diagnos");
    }
    public Button getConfirmButton() {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
