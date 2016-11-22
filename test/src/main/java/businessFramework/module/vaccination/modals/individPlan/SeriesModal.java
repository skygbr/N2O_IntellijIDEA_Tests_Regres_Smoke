package businessFramework.module.vaccination.modals.individPlan;

import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

public class SeriesModal implements Values
{
    private IndividPlanHelper individPlanHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public SeriesModal()
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
     * Заполнение формы создания серии
     */
    public void fillSeriesModal(IndividPlanData individPlanData)
    {
        //todo проверить, что выбрана вакцина
        individPlanHelper.getName().setValue("Серия автотест " + page.getCurrentDateTime());
        individPlanHelper.getProducer().setValue(1);
        individPlanHelper.getProduceDate().setValue(page.getCurrentDate());
        individPlanHelper.getEndDate().setValue(page.addDays(page.getCurrentDate(), 366));
    }


}
