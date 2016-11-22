package businessFramework.module.dispensary.modal.editAppointments;

import businessFramework.entities.dispensary.DispensaryData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class EditAppointmentsModal extends EditAppointmentsHelper implements Values {

    public EditAppointmentsModal(ApplicationManager app) {
        super(app);
    }

    public void addAppointment(DispensaryData dispensaryData)
    {
        getUpdateButton().click();
        getExaminations().check(dispensaryData.getAppointmentName(), true);
        getSaveButton().click();
        getEditAppointmentsModal().getForm().getAlerts().assertSuccessAlertIsPresent();
        getEditAppointmentsModal().closeModal();
    }
}