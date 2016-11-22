package businessFramework.module.gibddMedicalExamination.modals.CloseCard;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class CloseCardHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public CloseCardHelper() {
        this.container = "main";
    }

    public CloseCardHelper(String container) {
        this.container = container;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Classifier getReason()
    {
        return getContainer().getForm().getClassifier("reason");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
