package businessFramework.module.dispensary;

import businessFramework.module.dispensary.pages.MedicalCard.MedicalCardPage;
import businessFramework.module.dispensary.pages.EventCard.EventCardPage;
import businessFramework.module.dispensary.pages.Events.EventsPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

public class DispensaryManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Получение страницы "Диспансеризация взрослого населения"
     *
     * @return страницу "Диспансеризация взрослого населения"
     */
    public EventsPage getEventsPage() {
        return new EventsPage(app);
    }

    /**
     * Получение страницы "Регистратор"
     *
     * @return страницу "Регистратор"
     */
    public MedicalCardPage getMedicalCardPage() {
        return new MedicalCardPage(app);
    }

    /**
     * Получение страницы "Катрочка мероприятия"
     *
     * @return страницу "Катрочка мероприятия"
     */
    public EventCardPage getEventCardPage() {
        return new EventCardPage(app);
    }

    /**
     * Открытие модуля "Диспансеризация взрослого населения"
     */
    public void openDispModule() {
        app.getNavigationHelper().openPageWithModule("modules.dispOrphans");
    }

    /**
     * Открытие страницы "Список мероприятий"
     */
    public void openEventsPage() {
        this.openDispModule();
        page.getHeader().openPage("dispOrphans.EventsListOrphans");
    }
}
