package businessFramework.module.ambulance.pages.settings;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;


/**
 * Получение элементов на странице "Настройки - Настройки распределения вызовов по диспетчерам"
 */


public class SettingsCallsByDispetchersHelper extends Page implements Values
{
    public SettingsCallsByDispetchersHelper(ApplicationManager app)
    {
        super(app);
    }
}
