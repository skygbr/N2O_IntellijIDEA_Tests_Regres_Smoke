package businessFramework.module.stomatology.modals.stomMedicalCard;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class AddStomMedicalCardHistoryHelper implements Values{
    private Page page = Page.getInstance();
    public Container getContainerAddMedicalCardHistory(){
        return page.getModal().getContainer("main");
    }

    public Button getCancelButton(){
        return getContainerAddMedicalCardHistory().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerAddMedicalCardHistory().getButton(N2O_CONFIRM_BUTTON);
    }
    public Classifier getPlaceMedicalCard(){
        return getContainerAddMedicalCardHistory().getForm().getClassifier("place");
    }
}
