package businessFramework.module.stomatology.pages.stomatologyAppointment;

import businessFramework.module.Values;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class StomatologyAppointmentHelper extends Page implements Values {
    public StomatologyAppointmentHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerAppointments(){
        return getRegion("top").getContainer("appointments");
    }
    public Container getContainerCases(){
        return getRegion("bottom").getContainer("cases");
    }
    public Button getResultButton(){
        return getContainerAppointments().getButton("resultAdmission");
    }
    public Button getCancelVisitButton(){
        return getContainerAppointments().getButton("cancelVisit");
    }
    public Button getCreateNoRecordAppointmentButton(){
        return getContainerAppointments().getButton("createAppointment");
    }
    public Button getCancelAppointmenButton(){
        return getContainerAppointments().getButton("cancelAppointment");
    }
}
