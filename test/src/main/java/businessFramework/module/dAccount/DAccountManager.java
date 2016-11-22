package businessFramework.module.dAccount;

import businessFramework.module.dAccount.pages.DAccountHistoryPage;
import businessFramework.module.dAccount.pages.DeletedRegisterPage;
import businessFramework.module.dAccount.pages.RegisterPage;
import businessFramework.module.dAccount.pages.TreatmentPlanPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;


public class DAccountManager
{
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * @return Получение страницы "Регистр"
     */
    public RegisterPage getRegisterPage()
    {
        return new RegisterPage(app);
    }

    /**
     * @return Получение страницы "История заболевания"
     */
    public DAccountHistoryPage getAccountHistoryPage()
    {
        return new DAccountHistoryPage(app);
    }


    /**
     * @return Получение страницы "План лечения и наблюдения"
     */
    public TreatmentPlanPage getTreatmentPlanPage()
    {
        return new TreatmentPlanPage(app);
    }

    /**
     * @return Получение страницы "Удаленные записи"
     */
    public DeletedRegisterPage getDeletedRegisterPage()
    {
        return new DeletedRegisterPage(app);
    }

    /**
     * Открытие модуля "Регистр"
     */
    public void openRegisterModule()
    {
        app.getNavigationHelper().openPageWithModule("modules.dAccount");
    }

    /**
     * Открытие страницы "Регистр"
     */
    public void openRegisterPage()
    {
        this.openRegisterModule();
        page.getHeader().openPage("dAccount.dAccountRegister");
    }

    /**
     * Открытие страницы "План лечения и наблюдения"
     */
    public void openTreatmentPlanPage()
    {
        this.openRegisterModule();
        page.getHeader().openPage("dAccount.dAccountTreatment");
    }

    /**
     * Открытие страницы "Удаленные записи"
     */
    public void openDAccountRegisterDeletedPage()
    {
        this.openRegisterModule();
        page.getHeader().openPage("dAccount.dAccountRegisterDeleted");
    }

    /**
     * Открытие страницы "Мониторинг тяжелобольных"
     */
    public void openDAccountMonitorSeriouslyPage()
    {
        this.openRegisterModule();
        page.getHeader().openPage("dAccount.dAccountMonitorSeriously");
    }
}