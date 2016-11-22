package businessFramework.module.stomatology.modals.stomInspection;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by RTlabs on 02.08.2016.
 */
public class AddStomInspectionHelper implements Values{
    private Page page = Page.getInstance();
    public Container getContainerAddStomInspection(){
        return page.getModal().getContainer("main");
    }

    public Button getCancelButton(){
        return getContainerAddStomInspection().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerAddStomInspection().getButton(N2O_CONFIRM_BUTTON);
    }
    public Classifier getToothNumber(){
        return getContainerAddStomInspection().getForm().getClassifier("tooth");
    }
    public Classifier getSurface(){
        return getContainerAddStomInspection().getForm().getClassifier("surface");
    }
    public Classifier getDisease(){
        return getContainerAddStomInspection().getForm().getClassifier("disease");
    }
    public Classifier getMobility(){
        return getContainerAddStomInspection().getForm().getClassifier("mobility");
    }
}
