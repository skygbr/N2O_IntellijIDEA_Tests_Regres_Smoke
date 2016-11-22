package businessFramework.module.clinic.pages.clinicAppointment;

import businessFramework.module.clinic.pages.resultAdmission.ResultAdmissionPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ClinicAppointmentPages extends ClinicAppointmentHelper {
    public ClinicAppointmentPages(ApplicationManager app){
        super(app);
    }
    public ResultAdmissionPage getResultAdmissionPage(){
        return new ResultAdmissionPage(app);
    }
    public ClinicAppointmentFilter getFilter()
    {
        return new ClinicAppointmentFilter(app);
    }

    // В Поликлинике
    public void clickCreateNoRecordAppointment(){
        Button button = getCreateNoRecordAppointmentButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Без записи");
    }
    public void clickClinicAppointmentResultAdmission(){
        Button button = getResultButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Результаты приема");
    }
    public void clickCancelVisitNoRecord(){
        Button button = getCancelVisitButton();
        getContainerAppointments().getTable().chooseRowInTableByColumnValue("Талон №", "Без Записи");
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCancelVisit(){
        Button button = getCancelVisitButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
      //  getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCancelAppointmen(){
        Button button = getCancelAppointmenButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsDisplayed(true);
        button.click();
    }
    public void clickCancelAppointmenNoRecord(){
        Button button = getCancelAppointmenButton();
        getContainerAppointments().getTable().chooseRowInTableByColumnValue("Талон №", "Без Записи");
        button.assertIsDisplayed(true);
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }
    public void clickCancelNoRecordAppointmen(){
        Button button = getCancelNoRecordAppointmenButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickAppointmenModifyReception(){
        Button button = getAppointmenModifyReceptionButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
    }
    public void clickAppointmenModifyNoRecordReception(){
        Button button = getAppointmenModifyNoRecordReceptionButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
    }
    public void clickPlanedState(){
        Button button = getPlanedStateButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickPlanedStateDidNotCome(){
        Button button = getPlanedStateDidNotComeButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickDidNotComeState(){
        Button button = getDidNotComeStateButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    // На дому
    public void clickHomeAppointmentResultAdmission(){
        Button button = getResultButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Результаты приема");
    }
    public void clickModifyReceptionHomeAppointment(){
        Button button = getHomeModifyReceptionButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.click();
    }
    public void filterByDate(String date){
        getFilter().getAppointmentDate().setValue(date);
        getContainerAppointments().getFilter().clickFindButton();
    }
}
