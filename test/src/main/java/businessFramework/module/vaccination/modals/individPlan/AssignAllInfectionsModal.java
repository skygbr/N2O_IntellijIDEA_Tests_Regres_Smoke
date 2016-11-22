package businessFramework.module.vaccination.modals.individPlan;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class AssignAllInfectionsModal implements Values
{
    private IndividPlanHelper individPlanHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public AssignAllInfectionsModal()
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
        page.getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Заполнение формы назначения всех прививок
     */
    public void fillAssignAllInfectionsForm(IndividPlanData individPlanData)
    {
        individPlanHelper.getAssignAllInfectionsDate().setEndDateValue(page.addDays(page.getCurrentDate(), 29280));
    }

    /**
     * Проверка заполнения даты рождения в периоде
     */
    public void assertPeriodBeginIsFill(String value)
    {
//        individPlanHelper.getAssignAllInfectionsDate().setEndDateValue(page.addDays(page.getCurrentDate(), 29280));
//        String currentValue = individPlanHelper.getAssignAllInfectionsDate().assertValue_equals("");
          String beginValue = individPlanHelper.getAssignAllInfectionsDate().getBeginValue();
          List<String> values = Arrays.asList(value);
          assertThat("Begin date not equal to birth date", beginValue, isIn(values));
    }

}
