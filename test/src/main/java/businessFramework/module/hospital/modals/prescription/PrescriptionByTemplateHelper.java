package businessFramework.module.hospital.modals.prescription;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.CheckboxGrid;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrescriptionByTemplateHelper extends Page implements Values {
    private Page page = Page.getInstance();

    public PrescriptionByTemplateHelper(ApplicationManager app) {
        super(app);
    }

    public Container getMainContainer() {
        return page.getModal().getContainer("main");
    }

    public InputDate getPeriodField() {
        return getMainContainer().getForm().getInputDate("period");
    }

    public Classifier getTemplateField() {
        return getMainContainer().getForm().getClassifier("template");
    }

    public CheckboxGrid getTemplatePrescriptionsCheckboxGrid() {
        return getMainContainer().getForm().getCheckboxGrid("templatePrescriptions");
    }

    public Button getCloseButton() {
        return getMainContainer().getButton("n2o-custom-cancel");
    }

    public WebElement getPrescribeButton() {
        return getMainContainer().takeContainer().findElement(By.id("prescribe"));
    }

    public WebElement getConfirmButton() {
        return getMainContainer().takeContainer().findElement(By.id("confirm"));
    }

    public WebElement getCancelButton() {
        return getMainContainer().takeContainer().findElement(By.id("cancel"));
    }

}
