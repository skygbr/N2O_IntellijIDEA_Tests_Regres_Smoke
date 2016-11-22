package businessFramework.module.stomatology.pages.stomatologyAppointment;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.InputDate;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class StomatologyAppointmentFilter extends StomatologyAppointmentHelper {
    public StomatologyAppointmentFilter(ApplicationManager app) {
        super(app);
    }
    public InputDate getAppointmentDate(){
        return getContainerAppointments().getFilter().getInputDate("dt");
    }

}
