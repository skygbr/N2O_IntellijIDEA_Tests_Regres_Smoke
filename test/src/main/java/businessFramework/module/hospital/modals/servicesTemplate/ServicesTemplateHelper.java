package businessFramework.module.hospital.modals.servicesTemplate;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplateHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public ServicesTemplateHelper()
    {
        this.container = "main";
    }

    public ServicesTemplateHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }

    public InputText getName()
    {
        return getContainer().getForm().getInputText("name");
    }

    public Classifier getStandart() {
        return getContainer().getForm().getClassifier("standard");
    }

    public Radio getType() {
        return  getContainer().getForm().getRadio("type");
    }

    public TextArea getNote()
    {
        return getContainer().getForm().getTextArea("note");
    }

    public InputDate getPeriod()
    {
        return getContainer().getForm().getInputDate("period");
    }

    public Button getConfirmButton()
    {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getContainer().getButton(N2O_CANCEL_BUTTON);
    }

}
