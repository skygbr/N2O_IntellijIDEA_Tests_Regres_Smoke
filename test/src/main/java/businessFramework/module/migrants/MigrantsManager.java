package businessFramework.module.migrants;


import businessFramework.module.migrants.pages.CommissionPage;
import businessFramework.module.migrants.pages.DoctorPage;
import businessFramework.module.migrants.pages.RegistratorPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

public class MigrantsManager
{

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Открытие модуля "Освидетельствование ИГ и ЛГ"
     */
    public void openMigrantsModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.dispMigrants");
    }

    /**
     * Открытие страницы "Регистратор"
     */
    public void openRegistratorPage()
    {
        openMigrantsModule();
        page.getHeader().openPage("dispMigrants.EventsListMigrantRegistrator");
    }

    /**
     * Открытие страницы "Врач"
     */
    public void openDoctorPage()
    {
        openMigrantsModule();
        page.getHeader().openPage("dispMigrants.EventsListMigrantDoctor");
    }

    /**
     * Открытие страницы "Врач"
     */
    public void openCommissionPage()
    {
        openMigrantsModule();
        page.getHeader().openPage("dispMigrants.EventsListMigrantCommission");
    }

    /**
     * Получение страницы "Регистратор"
     * @return страницу "Регистратор"
     */
    public RegistratorPage getRegistratorPage()
    {
        return new RegistratorPage(app);
    }

    /**
     * Получение страницы "Врач"
     * @return страницу "Врач"
     */
    public DoctorPage getDoctorPage()
    {
        return new DoctorPage(app);
    }

    /**
     * Получение страницы "Врач"
     * @return страницу "Врач"
     */
    public CommissionPage getCommissionPage()
    {
        return new CommissionPage(app);
    }
}
