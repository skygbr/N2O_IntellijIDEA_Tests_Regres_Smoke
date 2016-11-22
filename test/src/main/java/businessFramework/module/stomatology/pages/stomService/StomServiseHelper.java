package businessFramework.module.stomatology.pages.stomService;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by RTlabs on 25.07.2016.
 */
public class StomServiseHelper extends Page implements Values {
    public StomServiseHelper(ApplicationManager app){
        super(app);
    }

    public Container getContainerServiceAndProtocol(){
        return getRegion("single").getContainer("top");
    }
    public InputDate getBdate(){
        return getContainerServiceAndProtocol().getForm().getInputDate("bdate");
    }
    public InputCheckBox getIsUrgent(){
        return getContainerServiceAndProtocol().getForm().getInputCheckBox("isUrgent");
    }
    public Classifier getService(){
        return getContainerServiceAndProtocol().getForm().getClassifier("service");
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
}
