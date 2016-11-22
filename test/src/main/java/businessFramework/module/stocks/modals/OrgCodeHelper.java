package businessFramework.module.stocks.modals;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * @author lgalimova
 * @since 07.07.2015
 */
public class OrgCodeHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public OrgCodeHelper()
    {
        this.container = "main";
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }


    public Classifier getCodeType()
    {
        return this.getContainer().getForm().getClassifier("codeType");
    }

    public InputText getCode()
    {
        return this.getContainer().getForm().getInputText("code");
    }

    public InputDate getIssueDate()
    {
        return this.getContainer().getForm().getInputDate("issueDate");
    }

    public Button getConfirmButton()
    {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
