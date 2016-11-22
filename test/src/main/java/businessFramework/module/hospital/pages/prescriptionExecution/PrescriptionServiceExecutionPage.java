package businessFramework.module.hospital.pages.prescriptionExecution;

import businessFramework.entities.hospital.HospitalData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 03.12.2015
 */
public class PrescriptionServiceExecutionPage extends PrescriptionServiceExecutionHelper {
    public PrescriptionServiceExecutionPage(ApplicationManager app) {
        super(app);
    }
    private Page page = Page.getInstance();

    public void filter(HospitalData hospitalData, String dt)
    {
        clickToPrescriptionServicesRegion();
        getContainerPrescriptionServicesList().showFilter();
        getPeriodFilter().setPeriod(dt, dt);
        getDepartmentFilter().setValue(hospitalData.getDepartment());
        getStatusFilter().selectOption("");
        getPatientFilter().setValue(hospitalData.getPatient());
        getContainerPrescriptionServicesList().getFilter().clickFindButton();
    }

    public void execute()
    {
        getRenderButton().assertIsDisplayed(true);
        getCancelRenderedButton().assertIsDisplayed(false);
        getRefusalButton().assertIsDisplayed(true);
        getRenderButton().click();
        getContainerPrescriptionServicesList().getTable().getAlerts().assertSuccessAlertIsPresent();
        checkAfterRender();
    }

    public void checkAfterRender()
    {
        getContainerPrescriptionServicesList().getTable().assertIconInRowOnColumn(0, "", "icon-ok");
        getRenderButton().assertIsDisplayed(false);
        getRefusalButton().assertIsDisplayed(false);
        getCancelRenderedButton().assertIsDisplayed(true);
    }

    public void cancelRendered()
    {
        getCancelRenderedButton().click();
        getDialog().clickYes();
        getContainerPrescriptionServicesList().getTable().getAlerts().assertSuccessAlertIsPresent();
        getContainerPrescriptionServicesList().getTable().assertIconInRowOnColumn(0, "", "icon-time");
        getRenderButton().assertIsDisplayed(true);
        getCreateRenderedButton().assertIsDisplayed(true);
        getRefusalButton().assertIsDisplayed(true);
    }

    public void refusal(String reason)
    {
        getRefusalButton().click();
        assertModalPresentOnPage(true);
        getModal().getContainer("main").getForm().getTextArea("comment").setValue(reason);
        getModal().getContainer("main").getButton(N2O_CONFIRM_BUTTON).click();
        getContainerPrescriptionServicesList().getTable().getAlerts().assertSuccessAlertIsPresent();
        getContainerPrescriptionServicesList().getTable().assertIconInRowOnColumn(0, "", "icon-remove");
        getContainerPrescriptionServicesList().getTable().assertColumnValuesIs("Причина отмены", reason);
    }

}
