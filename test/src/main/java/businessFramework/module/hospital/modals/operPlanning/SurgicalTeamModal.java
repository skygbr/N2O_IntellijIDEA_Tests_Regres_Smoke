package businessFramework.module.hospital.modals.operPlanning;

import businessFramework.entities.hospital.SurgicalTeamData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 17.11.2015
 */
public class SurgicalTeamModal {
   private SurgicalTeamHelper surgicalTeamHelper;

    public SurgicalTeamModal() {
        surgicalTeamHelper = new SurgicalTeamHelper();
    }

    public void saveForm(SurgicalTeamData surgicalTeamData)
    {
        surgicalTeamHelper.getRole().setValue(surgicalTeamData.getRole());
        surgicalTeamHelper.getEmployee().setValue(surgicalTeamData.getEmployee());
        surgicalTeamHelper.getConfirmButton().click();
    }

    public void assertForm(SurgicalTeamData surgicalTeamData)
    {
        surgicalTeamHelper.getRole().assertValue_equals(surgicalTeamData.getRole());
        surgicalTeamHelper.getEmployee().assertValue_equals(surgicalTeamData.getEmployee());
    }
}
