package businessFramework.module.pharmacy;


import businessFramework.module.pharmacy.pages.applications.PharmacyApplicationsPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

public class PharmacyApplicationsManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Открытие модуля Аптека
     */
    public void openPharmacyModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.inventory");
    }

    /**
     * @return Получение страницы "Заявки"
     */
    public PharmacyApplicationsPage getPharmacyApplicationsPage()
    {
        return new PharmacyApplicationsPage(app);
    }

    /**
     * Открытие страницы "Заявки"
     */
    public void openPharmacyApplicationsPage() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.applicationDocList");
    }
}
