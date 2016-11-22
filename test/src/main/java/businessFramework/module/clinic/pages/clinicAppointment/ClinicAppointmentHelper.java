package businessFramework.module.clinic.pages.clinicAppointment;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 07.09.2015.
 */
public class ClinicAppointmentHelper extends Page implements Values {
    public ClinicAppointmentHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerAppointments(){
        return getRegion("top").getContainer("appointments");
    }
    public Container getContainerCases(){
        return getRegion("bottom").getContainer("cases");
    }
    public Container getContainerAppointmentAtHome(){
        return getRegion("top-home").getContainer("appointmentAtHome");
    }
    public Button getCreateNoRecordAppointmentButton(){
        return getContainerAppointments().getButton("createAppointment");
    }
    public Button getResultButton(){
        return getContainerAppointments().getButton("resultAdmission");
    }
    public Button getCancelVisitButton(){
        return getContainerAppointments().getButton("cancelVisit");
    }
    public Button getCancelAppointmenButton(){
        return getContainerAppointments().getButton("cancelAppointmen");
    }
    public Button getCancelNoRecordAppointmenButton(){
        return getContainerAppointments().getButton("cancelNoRecordAppointmen");
    }
    public Button getAppointmenModifyReceptionButton(){
        return getContainerAppointments().getButton("modifyReception");
    }
    public Button getAppointmenModifyNoRecordReceptionButton(){
        return getContainerAppointments().getButton("modifyNoRecordReception");
    }
    public Button getPlanedStateButton(){
        return getContainerAppointments().getButton("getPlanedState");
    }
    public Button getPlanedStateDidNotComeButton(){
        return getContainerAppointments().getButton("getPlanedState2");
    }
    public Button getDidNotComeStateButton(){
        return getContainerAppointments().getButton("getDidNotComeState");
    }

    public Button getHomeResultButton(){
        return getContainerAppointmentAtHome().getButton("resultAdmission");
    }
    public Button getHomeModifyReceptionButton(){
        return getContainerAppointmentAtHome().getButton("modifyReception");
    }

}
