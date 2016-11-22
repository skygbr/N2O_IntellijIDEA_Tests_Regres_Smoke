package businessFramework.module.hospital.pages.prescriptionExecution;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.Select;

/**
 * @author agabdrakhmanova
 * @since 03.12.2015
 */
public class PrescriptionServiceExecutionHelper extends Page implements Values {

    public PrescriptionServiceExecutionHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerPrescriptionServicesList() {
        return getRegion("service-execution").getContainer("serviceList");
    }

    public void clickToPrescriptionServicesRegion() {
        getContainer("tab2").clickContainer();
    }


    public Button getRenderButton() {
        return getContainerPrescriptionServicesList().getButton("render");
    }

    public Button getCancelRenderedButton() {
        return getContainerPrescriptionServicesList().getButton("cancelRendered");
    }

    public Button getRefusalButton() {
        return getContainerPrescriptionServicesList().getButton("refusal");
    }

    public Button getCreateRenderedButton() {
        return getContainerPrescriptionServicesList().getButton("createRendered");
    }

    public Button getEditRenderedButton() {
        return getContainerPrescriptionServicesList().getButton("editRendered");
    }

    public Button getRenderedWithProtocolButton() {
        return getContainerPrescriptionServicesList().getButton("renderedWithProtocol");
    }

    //Filter
    public Classifier getDepartmentFilter() {
        return getContainerPrescriptionServicesList().getFilter().getClassifier("department");
    }

    public Classifier getPatientFilter() {
        return getContainerPrescriptionServicesList().getFilter().getClassifier("patient");
    }

    public InputDate getPeriodFilter() {
        return getContainerPrescriptionServicesList().getFilter().getInputDate("period");
    }

    public Select getStatusFilter() {
        return getContainerPrescriptionServicesList().getFilter().getSelect("status");
    }
}
