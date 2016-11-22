package businessFramework.module.hospital.modals.servicesTemplate;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.06.2015
 */
public class ServicesTemplateServiceHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public ServicesTemplateServiceHelper() {
        this.container = "main";
    }

    public ServicesTemplateServiceHelper(String cotainer) {
        this.container = cotainer;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Classifier getScheduleSelectionType() {
        return getContainer().getForm().getClassifier("scheduleSelectionType");
    }

    public InputText getRestriction() {
        return getContainer().getForm().getInputText("restriction");
    }

    public Classifier getService() {
        return getContainer().getForm().getClassifier("service");
    }

    public Classifier getResGroup() {
        return getContainer().getForm().getClassifier("resGroup");
    }

    public Classifier getDepartment() {
        return getContainer().getForm().getClassifier("department");
    }

    public Classifier getDistrict() {
        return getContainer().getForm().getClassifier("district");
    }

    public Classifier getSpeciality() {
        return getContainer().getForm().getClassifier("speciality");
    }

    public Classifier getProfile() {
        return getContainer().getForm().getClassifier("profile");
    }

    public Classifier getFunding() {
        return getContainer().getForm().getClassifier("funding");
    }

    public InputText getQueue() {
        return getContainer().getForm().getInputText("queue");
    }

    public InputText getMaxInterval() {
        return getContainer().getForm().getInputText("maxInterval");
    }

    public Classifier getIndentMeasure() {
        return getContainer().getForm().getClassifier("indentMeasure");
    }

    public InputText getIndent() {
        return getContainer().getForm().getInputText("indent");
    }

    public Button getConfirmButton() {
        return getContainer().getButton(N2O_CONFIRM_BUTTON);
    }



    public FieldSet getMaxIntervalFieldSet() {
        return getContainer().getForm().getFieldSet(3);
    }

    public FieldSet getIndentFieldSet() {
        return getContainer().getForm().getFieldSet(4);
    }

    public FieldSet getRestrictionFieldSet() {
        return getContainer().getForm().getFieldSet(1);
    }

    public Button getCancelButton()
    {
        return getContainer().getButton(N2O_CANCEL_BUTTON);
    }


}
