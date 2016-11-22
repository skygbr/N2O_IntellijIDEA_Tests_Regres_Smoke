package businessFramework.module.clinic.modals.cert;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;


/**
 * Created by asamoilov on 18.02.2016.
 */
public class CertHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerCert(){
        return page.getModal().getContainer("main");
    }

    public InputText getNumber(){
        return getContainerCert().getForm().getInputText("number");
    }
    public InputDate getCreationDate(){
        return getContainerCert().getForm().getInputDate("creationDate");
    }
    public Classifier getPatient(){
        return getContainerCert().getForm().getClassifier("patient");
    }
    public Classifier getMcase(){
        return getContainerCert().getForm().getClassifier("mcase");
    }
    public Classifier getReceiver(){
        return getContainerCert().getForm().getClassifier("receiver");
    }
    public InputText getRemark(){
        return getContainerCert().getForm().getInputText("remark");
    }

    public Button getCancelButton(){
        return getContainerCert().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerCert().getButton(N2O_CONFIRM_BUTTON);
    }
}
