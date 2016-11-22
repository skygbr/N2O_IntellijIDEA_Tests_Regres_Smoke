package businessFramework.module.stomatology.modals.stomLaboratoryReferral;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by RTlabs on 21.07.2016.
 */
public class StomLaboratoryReferralHelper implements Values{
    private Page page = Page.getInstance();

    public Container getContainerLaboratoryReferral() {
        return page.getModal().getContainer("main");
    }
    public Classifier getResearch(){
        return getContainerLaboratoryReferral().getForm().getClassifier("researchChild");
    }
    public Classifier getDiagnosis(){
        return getContainerLaboratoryReferral().getForm().getClassifier("diagnosis");
    }
    public Button getCancelButton() {
        return getContainerLaboratoryReferral().getButton(N2O_CANCEL_BUTTON);
    }

    public Button getConfirmButton() {
        return getContainerLaboratoryReferral().getButton(N2O_CONFIRM_BUTTON);
    }
}

