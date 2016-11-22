package businessFramework.module.hospital.modals.attendantIndivi;


import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class AttendantIndivHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public AttendantIndivHelper()
    {
        this.container = "individualRelationContainer";
    }

    public AttendantIndivHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public Classifier getIndiv()
    {
        return  getContainer().getForm().getClassifier("indiv");
    }

    public Radio getSearchType()
    {
        return getContainer().getForm().getRadio("searchType");
    }

    public Classifier getRelationSide()
    {
        return getContainer().getForm().getClassifier("relationSide");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getEditButton()
    {
        return getContainer().getButton(SAVE_BUTTON);
    }
}
