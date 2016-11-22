package businessFramework.module.vaccination.modals.individPlan;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class RollbackModal implements Values
{
    private IndividPlanHelper individPlanHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public RollbackModal()
    {
        this.individPlanHelper = new IndividPlanHelper(app);
    }

    public void clickConfirmButton()
    {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getAlerts().assertSuccessAlertIsPresent();
    }


    /**
     * Заполнение формы отмены всех прививок
     */
    public void fillRollbackForm(IndividPlanData individPlanData)
    {
        individPlanHelper.getPeriodDate().setEndDateValue(page.addDays(page.getCurrentDateTime(), 29350));
    }

}
