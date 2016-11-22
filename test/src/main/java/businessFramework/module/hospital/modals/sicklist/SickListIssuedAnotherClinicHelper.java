package businessFramework.module.hospital.modals.sicklist;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author agabdrakhmanova
 * @since 29.10.2015
 */
public class SickListIssuedAnotherClinicHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public SickListIssuedAnotherClinicHelper() {
        this.container = "main";
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public InputDate getIssueDate()
    {
        return getContainer().getForm().getInputDate("issueDate");
    }

    public InputText getNumber()
    {
        return getContainer().getForm().getInputText("number");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
