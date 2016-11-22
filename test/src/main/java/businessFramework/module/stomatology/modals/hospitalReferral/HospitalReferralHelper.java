package businessFramework.module.stomatology.modals.hospitalReferral;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by elvira.ibragimova on 24.09.2016.
 */
public class HospitalReferralHelper implements Values {

    private Page page = Page.getInstance();
    public Container getContainer(){
        return page.getModal().getContainer("main");
    }
    public Classifier getOrganization(){
        return getContainer().getForm().getClassifier("recvOrganization");
    }
    public Classifier getRegimen(){
        return getContainer().getForm().getClassifier("recvRegimen");
    }
    public Classifier getFinancialType(){
        return getContainer().getForm().getClassifier("financialType");
    }
    public InputText getReferralComment(){
        return getContainer().getForm().getInputText("referralComment");
    }
    public Classifier getReferralDiagnosis(){
        return getContainer().getForm().getClassifier("referralDiagnosis");
    }

    public InputText getReferralDiagnosisComment(){
        return getContainer().getForm().getInputText("referralDiagnosisComment");
    }
    public Button getConfirmButton(){
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
    public Button getCancelButton(){
        return getContainer().getButton(N2O_CANCEL_BUTTON);
    }
}
