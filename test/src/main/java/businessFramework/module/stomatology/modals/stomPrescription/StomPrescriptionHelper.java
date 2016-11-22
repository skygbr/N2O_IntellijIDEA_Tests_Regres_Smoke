package businessFramework.module.stomatology.modals.stomPrescription;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by RTlabs on 22.07.2016.
 */
public class StomPrescriptionHelper implements Values{
    private Page page = Page.getInstance();

    public Container getContainerPrescription(){
        return page.getModal().getContainer("main");
    }
    public InputText getServicePrescriptionName(){
        return getContainerPrescription().getForm().getInputText("service.prescriptionName");
    }
    public Classifier getService(){
        return getContainerPrescription().getForm().getClassifier("service");
    }
    public InputDate getBeginPeriod(){
        return getContainerPrescription().getForm().getInputDate("period.begin");
    }
    public InputDate getEndPeriod(){
        return getContainerPrescription().getForm().getInputDate("period.end");
    }
    public MaskedInput getDuration(){
        return getContainerPrescription().getForm().getMaskedInput("duration");
    }
    public InputText getPrescriptionCount(){
        return getContainerPrescription().getForm().getInputText("prescriptionCount");
    }
    public Classifier getPeriodicity(){
        return getContainerPrescription().getForm().getClassifier("periodicity");
    }
    public Classifier getVisitTerm(){
        return getContainerPrescription().getForm().getClassifier("visitTerm");
    }
    public Button getCancelButton(){
        return getContainerPrescription().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerPrescription().getButton(N2O_CONFIRM_BUTTON);
    }
}
