package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Radio;

public class BeginWorkHelper extends Page implements Values
{
    public BeginWorkHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение группы радиобаттонов "Бригады"
     * @return группа радиобаттонов "Бригады"
     */
    public Radio getJobTeamsRadio()
    {
        return getModal().getForm().getRadio("brg");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопка "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getModal().getButton(N2O_CONFIRM_BUTTON);
    }
}