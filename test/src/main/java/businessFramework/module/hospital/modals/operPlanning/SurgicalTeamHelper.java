package businessFramework.module.hospital.modals.operPlanning;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

/**
 * @author agabdrakhmanova
 * @since 17.11.2015
 */
public class SurgicalTeamHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public SurgicalTeamHelper() {
        this.container = "main";
    }

    public SurgicalTeamHelper(String container) {
        this.container = container;
    }

    public Classifier getRole() {
        return getContainer().getForm().getClassifier("role");
    }

    public Classifier getEmployee() {
        return getContainer().getForm().getClassifier("employee");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
