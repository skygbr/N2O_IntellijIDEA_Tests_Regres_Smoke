package businessFramework.module.stomatology.pages.stomatologyAppointment;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class StomatologyAppointmentPage extends StomatologyAppointmentHelper{
    public StomatologyAppointmentPage(ApplicationManager app) {
        super(app);
    }
    public StomatologyAppointmentFilter getFilter()
    {
        return new StomatologyAppointmentFilter(app);
    }
    public void clickStomatologyAppointmentResultAdmission(){
        Button button = getResultButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Результаты приема");
    }
    public void filterByDate(String date){
        getFilter().getAppointmentDate().setValue(date);
        getContainerAppointments().getFilter().clickFindButton();
    }
    public void clickCancelStomVisit(){
        Button button = getCancelVisitButton();
        getContainerAppointments().getTable().assertColumnValuesIs("Время", "12:00");
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCreateNoRecordAppointment(){
        Button button = getCreateNoRecordAppointmentButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Без записи");
    }
    public void clickCancelStomVisitNoRecord(){
        Button button = getCancelVisitButton();
        getContainerAppointments().getTable().chooseRowInTableByColumnValue("Талон №", "Без Записи");
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCancelAppointmenNoRecord(){
        Button button = getCancelAppointmenButton();
        getContainerAppointments().getTable().chooseRowInTableByColumnValue("Талон №", "Без Записи");
        button.assertIsDisplayed(true);
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

}
