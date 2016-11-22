package businessFramework.module.stocks.modals.organization;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganizationHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public OrganizationHelper()
    {
        this.container = "main";
    }
    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }
    public InputText getCode()
    {
        return this.getContainer().getForm().getInputText("code");
    }
    public InputText getFullName()
    {
        return this.getContainer().getForm().getInputText("fullName");
    }
    public InputText getShortName()
    {
        return this.getContainer().getForm().getInputText("shortName");
    }
    public Classifier getParentOrg()
    {
        return this.getContainer().getForm().getClassifier("parentOrg");
    }
    public InputDate getRegDate()
    {
        return this.getContainer().getForm().getInputDate("regDate");
    }
    public Button getConfirmButton()
    {
        return this.getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
