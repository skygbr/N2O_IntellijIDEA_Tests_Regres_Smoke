package businessFramework.module.hospital.modals.prescription;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;

public class PrescriptionHelper extends Page implements Values {
    private Page page = Page.getInstance();

    public PrescriptionHelper(ApplicationManager app) {
        super(app);
    }

    public Container getMainContainer() {
        return page.getModal().getContainer("main");
    }

    public Classifier getHoldingField(int index) {
        return getMainContainer().getForm().getClassifier("holdings." + index + ".holding");
    }

    public InputText getCountField(int index) {
        return getMainContainer().getForm().getInputText("holdings." + index + ".count");
    }

    public InputText getDoseField(int index) {
        return getMainContainer().getForm().getInputText("holdings." + index + ".dose");
    }

    public OutputText getMneiNameField(int index) {
        return getMainContainer().getForm().getOutputText("holdings." + index + ".holding.mnei_name");
    }

    public InputCheckBox getIsPatientMedicamentCheckbox(int index) {
        return getMainContainer().getForm().getInputCheckBox("holdings." + index + ".is_patient_medicament");
    }

    public OutputText getDosageWithMeasureField(int index) {
        return getMainContainer().getForm().getOutputText("holdings." + index + ".holding.dose_with_measure");
    }

    public Classifier getAdministrationRouteField() {
        return getMainContainer().getForm().getClassifier("administrationRoute");
    }

    public Classifier getPeriodicityField() {
        return getMainContainer().getForm().getClassifier("prescriptionPeriodicity");
    }

    public Classifier getVisitTermField() {
        return getMainContainer().getForm().getClassifier("visitTerm");
    }

    public InputDate getBeginDateField() {
        return getMainContainer().getForm().getInputDate("periodBeginDt");
    }

    public InputDate getEndDateField() {
        return getMainContainer().getForm().getInputDate("periodEndDt");
    }

    public OutputText getDayAmountField() {
        return getMainContainer().getForm().getOutputText("dayAmount");
    }

    public OutputText getSingleDoseFiled() {
        return getMainContainer().getForm().getOutputText("singleDoseWithMeasure");
    }

    public OutputText getDailyDoseFiled() {
        return getMainContainer().getForm().getOutputText("dailyDoseWithMeasure");
    }

    public OutputText getCourseDoseFiled() {
        return getMainContainer().getForm().getOutputText("courseDoseWithMeasure");
    }

    public InputText getNoteFiled() {
        return getMainContainer().getForm().getInputText("note");
    }

    public Button getConfirmButton() {
        return getMainContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public int getCountOfVisibleHoldingRows() {
        return getMainContainer().findElements(By.cssSelector(".holdingRow:not(.n2o-hidden)")).size();
    }
}
