package businessFramework.module.pharmacy;


import businessFramework.module.pharmacy.pages.expenceInvoice.ExpenseInvoicePage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

public class ExpenseInvoiceManager
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
     * @return Получение страницы "Расходные накладные"
     */
    public ExpenseInvoicePage getExpenseInvoicePage()
    {
        return new ExpenseInvoicePage(app);
    }

    /**
     * Открытие страницы "Расходные накладные"
     */
    public void openExpenseInvoice() {
        this.openPharmacyModule();
        page.getHeader().openSpaceAndPage("Документы", "inventory.expInvoiceList");
    }
}
