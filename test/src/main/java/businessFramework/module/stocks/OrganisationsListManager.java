package businessFramework.module.stocks;

import businessFramework.module.stocks.pages.organizationsList.OrganizationsListPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * Created by aisaev on 03.08.2015.
 */
public class OrganisationsListManager {

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Открытие модуля Список организаций
    public void openOrganisationList() {
        app.getNavigationHelper().openPageWithModule("modules.organizationsList");
    }

    //Открытие главной старницы
    public void openMainPage() {
        app.getNavigationHelper().openMainPage();
    }

    //Выбор контекста
    public void chooseContext(String context) {
        Page page = Page.getInstance();
        page.getHeader().chooseContext(context);
    }


    //Получение страницы Список организаций
    public OrganizationsListPage getOrganizationsListPage() {
        return new OrganizationsListPage(app);
    }
}
