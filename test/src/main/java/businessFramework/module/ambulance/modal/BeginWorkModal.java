package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class BeginWorkModal extends BeginWorkHelper implements Values
{
    public BeginWorkModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Подтверждение начала работы бригады
     * @param brigadeName имя бригады
     */
    public void confirmTeamReady(String brigadeName)
    {
        getJobTeamsRadio().radioButtonPress(brigadeName);
        getConfirmButton().click();
    }
}