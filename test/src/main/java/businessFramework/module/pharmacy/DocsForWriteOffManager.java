package businessFramework.module.pharmacy;


import businessFramework.module.pharmacy.pages.documentsForCancellation.DocsForWriteOffPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

public class DocsForWriteOffManager
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
     * @return Получение страницы "Документы на списание"
     */
    public DocsForWriteOffPage getDocsForWriteOffPage()
    {
        return new DocsForWriteOffPage(app);
    }

    /**
     * Открытие страницы "Документы на списание"
     */
    public void openDocsForWriteOff() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.writeOffDocList");
    }
}
