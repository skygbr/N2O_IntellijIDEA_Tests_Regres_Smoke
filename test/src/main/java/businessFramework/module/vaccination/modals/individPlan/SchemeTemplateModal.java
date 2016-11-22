package businessFramework.module.vaccination.modals.individPlan;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class SchemeTemplateModal implements Values
{
    private IndividPlanHelper individPlanHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public SchemeTemplateModal()
    {
        this.individPlanHelper = new IndividPlanHelper(app);
    }

    public void clickConfirmButton()
    {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        //page.getAlerts().assertSuccessAlertIsPresent();
    }


    /**
     * Заполнение формы задания схемы (период: текущая дата - текущая дата +  )
     */
    public void fillSchemeTemplateForm(IndividPlanData individPlanData)
    {
        individPlanHelper.getScheme().setValue(individPlanData.getSchema());
        individPlanHelper.getPeriodDate().setBeginDateValue(page.getCurrentDate());
        individPlanHelper.getPeriodDate().setEndDateValue(page.addDays(page.getCurrentDateTime(), 720));
    }
}
