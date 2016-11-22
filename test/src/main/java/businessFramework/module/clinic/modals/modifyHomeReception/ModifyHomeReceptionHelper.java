package businessFramework.module.clinic.modals.modifyHomeReception;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ModifyHomeReceptionHelper implements Values {

    private Page page = Page.getInstance();

    public Container getContainer(){
        return page.getModal().getContainer("modifyHomeReception");
    }
    public Classifier getCancelReason(){
        return getContainer().getForm().getClassifier("cancelReason");
    }
    public Button getConfirmButton(){
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
