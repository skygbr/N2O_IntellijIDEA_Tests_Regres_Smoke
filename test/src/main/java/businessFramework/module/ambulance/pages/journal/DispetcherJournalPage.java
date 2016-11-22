package businessFramework.module.ambulance.pages.journal;

import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает страницу "Журнал диспетчера"
 */
public class DispetcherJournalPage extends DispetcherJournalHelper
{
    public DispetcherJournalPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие на кнопку "Создать"
     */
    public void clickCreateButton()
    {
        getCreateButton().click();
    }

}
