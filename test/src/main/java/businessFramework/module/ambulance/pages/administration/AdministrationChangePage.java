package businessFramework.module.ambulance.pages.administration;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Класс описывает страницу "Администрирование - Смены"
 */
public class AdministrationChangePage extends AdministrationChangeHelper
{
    public AdministrationChangePage(ApplicationManager app)
    {
        super(app);
    }

    public void clickForceOpenButton()
    {
        Button button = getForcedOpenButton();
        button.assertIsEnabled();
        button.click();
    }
}

