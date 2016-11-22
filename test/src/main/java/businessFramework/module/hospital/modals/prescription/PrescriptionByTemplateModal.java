package businessFramework.module.hospital.modals.prescription;

import businessFramework.entities.hospital.prescription.PrescriptionStatus;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplatePrescriptionData;
import net.framework.autotesting.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.hamcrest.MatcherAssert.assertThat;


public class PrescriptionByTemplateModal extends PrescriptionByTemplateHelper implements PrescriptionByTemplateValues {

    public PrescriptionByTemplateModal(ApplicationManager app) {
        super(app);
    }

    public void assertDefaultValues(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData) {
        assertThat("Begin date contains wrong value", getPeriodField().getBeginValue().contains(getCurrentDate()));
        getTemplatePrescriptionsCheckboxGrid().assertIsDisplayed(false);
    }

    private void fillMainFields(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData, String templateName) {

        getTemplateField().setValue(templateName);
        getPeriodField().setCalendarPeriodEnd(getDateBeforeAfterCurrent(servicesTemplatePrescriptionData.getCountDay()
                + servicesTemplatePrescriptionData.getBeginDay() + 1));

        servicesTemplatePrescriptionData.setPeriodBeginDt(getDateBeforeAfterCurrent(servicesTemplatePrescriptionData.getBeginDay() - 1));
        servicesTemplatePrescriptionData.setPeriodEndDt(getDateBeforeAfterCurrent(servicesTemplatePrescriptionData.getBeginDay() + servicesTemplatePrescriptionData.getCountDay() - 1));

        //clickByCoordinates(10, 10); //клик в пустое место по координатам
        sleep(3);
        app.getBaseHelperWithWebDriver().useKeys(Keys.ESCAPE);

        getTemplatePrescriptionsCheckboxGrid().assertIsDisplayed(true);
        getTemplatePrescriptionsCheckboxGrid().chooseRowInTable(0, true);
        assertStatus(NOT_PRESCRIBED);
    }

    private void prescribe(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData) {
        getPrescribeButton().click();
        assertErrorNorPresent();
        assertStatus(WAIT_CONFIRMATION);
        servicesTemplatePrescriptionData.setStatusId(PrescriptionStatus.WAIT_CONFIRMATION.getId());
    }

    public void prescribe(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData, String templateName) {
        fillMainFields(servicesTemplatePrescriptionData, templateName);
        assertConfirmValidation();
        assertCancelValidation();
        prescribe(servicesTemplatePrescriptionData);
        //assertPrescribeValidation();
    }

    public void prescribeAndConfirm(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData, String templateName) {
        fillMainFields(servicesTemplatePrescriptionData, templateName);
        prescribe(servicesTemplatePrescriptionData);
        getConfirmButton().click();
        assertErrorNorPresent();
        assertStatus(SCHEDULED);
        servicesTemplatePrescriptionData.setStatusId(PrescriptionStatus.SCHEDULED.getId());
    }

    public void prescribeAndConfirmAndCancel(ServicesTemplatePrescriptionData servicesTemplatePrescriptionData, String templateName) {
        prescribeAndConfirm(servicesTemplatePrescriptionData, templateName);
        getCancelButton().click();
        assertErrorNorPresent();
        assertStatus(NOT_PRESCRIBED);
    }

    public void closeModal() {
        getCloseButton().click();
        sleep(3);
        getAlerts().acceptAlertIfPresent();
        assertModalPresentOnPage(false);
    }

    private void assertStatus(String status) {
        getTemplatePrescriptionsCheckboxGrid().getRowValues(0).contains(status);
    }

    private void assertErrorNorPresent() {
        getMainContainer().getForm().getAlerts().assertErrorAlertAndStacktraceArePresent(false);
    }

    public void assertPrescribeValidation() {
        getPrescribeButton().click();
        sleep(1);
        getMainContainer().getForm().getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE_ALREADY_PRESCRIBED);
    }

    public void assertConfirmValidation() {
        getConfirmButton().click();
        sleep(1);
        getMainContainer().getForm().getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE_NOT_PRESCRIBED);
    }

    public void assertCancelValidation() {
        getCancelButton().click();
        sleep(1);
        getMainContainer().getForm().getAlerts().assertErrorAlertMessage(VALIDATION_MESSAGE_NOT_PRESCRIBED);
    }
}
