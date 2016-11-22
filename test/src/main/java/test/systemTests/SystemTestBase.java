package test.systemTests;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.test.TestBase;

/**
 * @author operehod
 * @since 15.09.2015
 */
public class SystemTestBase extends TestBase {

    protected static Page page = Page.getInstance();
    protected static ApplicationManager app = ApplicationManager.getInstance();


    protected static void refreshPage() {
        String url = page.getCurrentUrl();
        page.openUrl("about:blank");
        page.openUrl(url);
    }

    protected static void openPage(String pageId) {
        page.openUrl(app.getProperty("baseUrl") + "#" + pageId);
        app.getNavigationHelper().login();
    }

    protected static Container getContainer(String region, String containerId) {
        Container container = page.getRegion(region).getContainer(containerId);
        if (!container.isActive())
            container.clickContainer();
        return container;
    }

}
