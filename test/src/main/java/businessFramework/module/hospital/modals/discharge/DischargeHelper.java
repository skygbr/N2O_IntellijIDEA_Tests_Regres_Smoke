package businessFramework.module.hospital.modals.discharge;

import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 15.05.2015
 */
public class DischargeHelper implements Values {
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public DischargeHelper() {

    }


    public Classifier getBedProfile() {
        return page.getModal().getForm().getClassifier("bedProfile");
    }

    public Button getDischargeButton() {
        return page.getModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public InputDate getOutcomeDate() {
        return page.getModal().getForm().getInputDate("outcomeDate");
    }

    public Classifier getStepResult() {
        return page.getModal().getForm().getClassifier("stepResult");
    }

    public Classifier getOutcome() {
        return page.getModal().getForm().getClassifier("outcome");
    }

    public Classifier getCareLevel() {
        return page.getModal().getForm().getClassifier("careLevel");
    }

    public Diagnosis getFinalDiagnosis() {
        return new Diagnosis(app, page.getModal().getForm().getFormElement(), "finalDiagnosis");
    }

//    public Classifier getFinalDiagnosis() {
//            return page.getModal().getForm().getClassifier("finalDiagnosis");
//        }

    public Classifier getRankIn() {
        return page.getModal().getForm().getClassifier("rankin");
    }

    public InputDate getDeathDate() {
        return page.getModal().getForm().getInputDate("deathDate");
    }

    public Classifier getDeathEmployee() {
        return page.getModal().getForm().getClassifier("deathEmployee");
    }

    //filled fields
    public InputDate getAdmissionDate() {
        return page.getModal().getForm().getInputDate("admissionDate");
    }

    public Classifier getCurCoefCriteria0() {
        return page.getModal().getForm().getClassifier("stepCurCoefCritList.0.coefCriteriaId");
    }

    public InputText getCurCoefVal0() {
        return page.getModal().getForm().getInputText("stepCurCoefCritList.0.val");
    }

    public Classifier getCurCoefCriteria1() {
        return page.getModal().getForm().getClassifier("stepCurCoefCritList.1.coefCriteriaId");
    }

    public InputText getCurCoefVal1() {
        return page.getModal().getForm().getInputText("stepCurCoefCritList.1.val");
    }

}
