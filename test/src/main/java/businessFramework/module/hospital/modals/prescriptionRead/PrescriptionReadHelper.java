package businessFramework.module.hospital.modals.prescriptionRead;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Form;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.OutputText;
import org.openqa.selenium.By;

public class PrescriptionReadHelper extends Page implements Values {
    private Page page = Page.getInstance();

    public PrescriptionReadHelper(ApplicationManager app) {
        super(app);
    }

    public Container getTopContainer() {
        return page.getModal().getContainer("main");
    }

    public Form getTopForm() {
        return getTopContainer().getForm();
    }

    public OutputText getAdministrationRouteField() {
        return getTopForm().getOutputText("administrationRoute");
    }

    public OutputText getPeriodicityField() {
        return getTopForm().getOutputText("prescriptionPeriodicity.name");
    }

    public OutputText getVisitTermField() {
        return getTopForm().getOutputText("visitTerm");
    }

    public OutputText getDayAmountWithDatesField() {
        return getTopForm().getOutputText("dayAmountWithDates");
    }

    public OutputText getDoctorField() {
        return getTopForm().getOutputText("doctor");
    }

    public OutputText getHoldingField(int index) {
        return getTopForm().getOutputText("holdings." + index + ".name_holding");
    }

    public OutputText getSingleDoseField(int index) {
        return getTopForm().getOutputText("holdings." + index + ".single_dose");
    }

    public OutputText getDailyDoseField(int index) {
        return getTopForm().getOutputText("holdings." + index + ".daily_dose");
    }

    public OutputText getCourseDoseField(int index) {
        return getTopForm().getOutputText("holdings." + index + ".course_dose");
    }

    public int getCountOfVisibleHoldingRows() {
        return getTopContainer().findElements(By.cssSelector(".holdingRow:not(.n2o-hidden)")).size();
    }

    // Список

    public Container getBottomContainer() {
        return page.getModal().getContainer("prescriptionExecutionList");
    }

    public Table getBottomTable() {
        return getBottomContainer().getTable();
    }
}
