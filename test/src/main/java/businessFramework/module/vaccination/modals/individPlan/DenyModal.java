package businessFramework.module.vaccination.modals.individPlan;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class DenyModal implements Values
{
    private IndividPlanHelper individPlanHelper;
//    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public DenyModal()
    {
        this.individPlanHelper = new IndividPlanHelper(app);
    }

    /**
     * Нажатие кнопки n2o-confirm
     */
    public void clickConfirmButton()
    {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        //page.getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Заполнение формы отвода
     */
    public void fillDenyModal(IndividPlanData individPlanData)
    {
        //todo проверки
        individPlanHelper.getReason().setValue(1);
        individPlanHelper.getDenyNumber().setValue("1");
        individPlanHelper.getDenyPeriodType().selectOption(Values.DAY_VALUE);
    }

}
