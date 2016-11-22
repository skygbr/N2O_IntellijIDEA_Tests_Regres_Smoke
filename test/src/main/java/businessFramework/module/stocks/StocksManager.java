package businessFramework.module.stocks;

import businessFramework.module.stocks.pages.AdministrDataPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * @author lgalimova
 * @since 07.07.2015
 */
public class StocksManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Открытие модуля Обеспечение
    public void openStocksModule() {
        app.getNavigationHelper().openPageWithModule("modules.stocks");
    }

    //Получение страницы Административные данные
    public AdministrDataPage getAdministrDataPage() {
        return new AdministrDataPage(app);
    }


    //Открытие страницы Административные данные
    public void openAdministrData() {
        this.openStocksModule();
//        page.getHeader().openSpaceAndPage("Административные данные", "stocks.administrativeData");
    }

    //Открытие страницы Административные данные
    public void openOrgCodesSection() {

    }
}
