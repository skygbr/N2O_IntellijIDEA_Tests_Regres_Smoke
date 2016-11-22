package businessFramework.module.clinic.modals.receipt;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by asamoilov on 18.02.2016.
 */
public class ReceiptHelper implements Values {
    private Page page = Page.getInstance();

    public Container getContainerReceipt(){
        return page.getModal().getContainer("receipt");
    }
    public InputDate getiIssueDt(){
        return getContainerReceipt().getForm().getInputDate("issue_dt");
    }
    public Classifier getValidity(){
        return getContainerReceipt().getForm().getClassifier("validity");
    }
    public InputText getSeries(){
        return getContainerReceipt().getForm().getInputText("series");
    }
    public InputText getNum(){
        return getContainerReceipt().getForm().getInputText("num");
    }
    public Classifier getInn(){
        return getContainerReceipt().getForm().getClassifier("inn");
    }
    public InputText getTradeName(){
        return getContainerReceipt().getForm().getInputText("trade_name");
    }
    public Classifier getFormType(){
        return getContainerReceipt().getForm().getClassifier("form_type");
    }
    public InputText getDosage(){
        return getContainerReceipt().getForm().getInputText("dosage");
    }
    public InputText getUseMethod(){
        return getContainerReceipt().getForm().getInputText("use_method");
    }
    public TextArea getAdvice(){
        return getContainerReceipt().getForm().getTextArea("advice");
    }
    public Button getCancelButton(){
        return getContainerReceipt().getButton(N2O_CANCEL_BUTTON);
    }
    public Button getConfirmButton(){
        return getContainerReceipt().getButton(N2O_CONFIRM_BUTTON);
    }
}
