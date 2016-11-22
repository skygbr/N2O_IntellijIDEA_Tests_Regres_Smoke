package businessFramework.module.hospital.modals.service;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.CheckboxGrid;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import org.openqa.selenium.By;

/**
 * @author agabdrakhmanova
 * @since 03.07.2015
 */
public class ServiceByTemplateHelper implements Values {

    private String container;
    private Page page = Page.getInstance();

    public ServiceByTemplateHelper() {
        this.container = "main";
    }

    public ServiceByTemplateHelper(String cotainer) {
        this.container = cotainer;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public InputDate getBeginDateTime() {
        return getContainer().getForm().getInputDate("beginDateTime");
    }

    public Classifier getTemplate() {
        return getContainer().getForm().getClassifier("template");
    }

    public CheckboxGrid getServiceCheckboxGrid() {
        return getContainer().getForm().getCheckboxGrid("service");
    }

    public Button getCloseButton() {
        return getContainer().getButton(N2O_CANCEL_BUTTON);
    }


}
