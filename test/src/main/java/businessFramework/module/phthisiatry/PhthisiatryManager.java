package businessFramework.module.phthisiatry;

import businessFramework.module.pharmacy.pages.arrivalInvoice.ArrivalInvoicePage;
import businessFramework.module.pharmacy.pages.refbooks.holding.HoldingListPage;
import businessFramework.module.pharmacy.pages.refbooks.storeList.StoreListPage;
import businessFramework.module.pharmacy.pages.requestSpecifications.RequestSpecificationsPage;
import businessFramework.module.pharmacy.pages.requests.RequestsPage;
import businessFramework.module.phthisiatry.pages.PhthisiatryPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;


public class PhthisiatryManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * @return Получение страницы "Поликлинический прием"
     */
    public PhthisiatryPage getPhthisiatryPage()
    {
        return new PhthisiatryPage(app);
    }

    /**
     * Открытие модуля "Фтизиатрия"
     */
    public void openPhthisiatryModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.phthisiatry");
    }

    /**
     * Открытие страницы "Поликлинический прием"
     */
    public void openPhthisiatryPage()
    {
        this.openPhthisiatryModule();
        page.getHeader().openPage("phthisiatry.phthisiatryReception");
    }
}