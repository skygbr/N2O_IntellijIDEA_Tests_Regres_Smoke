package businessFramework.module.ambulance.pages.journal;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * Получение элементов на странице "Журнал"
 */

public class JournalHelper extends Page implements Values
{
    public JournalHelper(ApplicationManager app)
    {
        super(app);
    }
}