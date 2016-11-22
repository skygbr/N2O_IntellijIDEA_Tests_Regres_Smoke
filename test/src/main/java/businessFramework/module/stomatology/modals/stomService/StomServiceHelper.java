package businessFramework.module.stomatology.modals.stomService;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by elvira.ibragimova on 18.09.2016.
 */
public class StomServiceHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerServiceAndProtocol(){
        return page.getModal().getContainer("top");
    }
    public InputDate getBdate(){
        return getContainerServiceAndProtocol().getForm().getInputDate("bdate");
    }
    public InputCheckBox getIsUrgent(){
        return getContainerServiceAndProtocol().getForm().getInputCheckBox("isUrgent");
    }
    public Classifier getService(){
        return getContainerServiceAndProtocol().getForm().getClassifier("rootService");
    }
    public InputText getQuantity(){
        return getContainerServiceAndProtocol().getForm().getInputText("quantity");
    }
    public InputText getDuration(){
        return getContainerServiceAndProtocol().getForm().getInputText("duration");
    }
    public Classifier getDurationMeasure(){
        return getContainerServiceAndProtocol().getForm().getClassifier("durationMeasure");
    }
    public Classifier getDiagnosis(){
        return getContainerServiceAndProtocol().getForm().getClassifier("diagnosis");
    }
    public Classifier getFunding(){
        return getContainerServiceAndProtocol().getForm().getClassifier("funding");
    }
    public InputText getCost(){
        return getContainerServiceAndProtocol().getForm().getInputText("cost");
    }
    public InputText getTotalCost(){
        return getContainerServiceAndProtocol().getForm().getInputText("totalCost");
    }
    public Button getCancelButton(){
        return getContainerServiceAndProtocol().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerServiceAndProtocol().getButton(N2O_CONFIRM_BUTTON);
    }
}
