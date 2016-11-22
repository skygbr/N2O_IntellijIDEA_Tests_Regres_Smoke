package businessFramework.module.vaccination.modals.individPlan;


import businessFramework.entities.vaccination.IndividPlanData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.pages.individPlan.IndividPlanHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class VaccineModal implements Values
{
    private IndividPlanHelper individPlanHelper;
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    public VaccineModal()
    {
        this.individPlanHelper = new IndividPlanHelper(app);
    }

    public void clickConfirmButtonNewForm()
    {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickConfirmButton()
    {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getModal().closeModal();
    }

    public void clickConfirmButtonAndConfirmDialog() {
        Button button = individPlanHelper.getConfirmButton();
        button.assertIsEnabled();
        button.click();
        page.getDialog().clickYes();
        page.getModal().closeModal();
    }

    public void clickSeriesLink()
    {
        Button link = individPlanHelper.getSeriesLink();
        link.assertIsEnabled();
        link.click();
        individPlanHelper.assertModalPresentOnPage(true);
        individPlanHelper.getModal().assertModalHeader_contains("Добавление серии");
    }

    public void clickNewDeny()
    {
        Button button = individPlanHelper.getNewDenyButton();
        button.assertIsEnabled();
        button.click();
        individPlanHelper.assertModalPresentOnPage(true);
        individPlanHelper.getModal().assertModalHeader_contains("Создание отвода");
    }

    /**
     * Проверка значений, заполненных из контекста, на форме создания прививки.
    */
    public void assertVaccineContextData(IndividPlanData individPlanData)
    {
        individPlanHelper.getClinic().assertValue_equals(individPlanData.getClinic());
        individPlanHelper.getResourse().assertValue_equals(individPlanData.getResourse());

        assertThat("Статус прививки не заполнен по умолчанию. Или заполнен не верно",
                individPlanHelper.getStatus().getActiveButtons().contains(individPlanHelper.getStatus().getButtonByDataValue("1")));
    }

    /**
     * Проверка валидации на обязательность полей на форме создания прививики
     */
    public void assertRequiredFields()
    {
        individPlanHelper.getVaccine().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        individPlanHelper.getPhase().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
    }

    /**
     * Проверка валидации на дату выполнения прививки
     */
    public void assertDoneDate()
    {
        individPlanHelper.getModal().getForm().getInputDate("date").getValidations().assertErrorValidationMessage("Дата выполнения прививки не может быть позже текущей даты.");
    }

    /**
     * Заполнение формы добавления прививки (назначение)
     */
    public void fillVaccineModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getVaccine().setValue(individPlanData.getVaccine());
        individPlanHelper.getPhase().setValue(individPlanData.getPhase());
    }

    /**
     * Заполнение формы добавления пробы (назначение)
     */
    public void fillProbeModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getVaccine().setValue(individPlanData.getProbe());
        individPlanHelper.getPhase().setValue(individPlanData.getProbePhase());
    }

    /**
     * Заполнение формы редактирования прививки (планирование)
     */
    public void fillPlanVaccineModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getModal().getForm().getButtonGroup("status").clickButtonByDataValue("2");
        individPlanHelper.getDose().setValue(1);
        individPlanHelper.getInputType().setValue(1);
    }

     /**
     * Заполнение формы редактирования пробы (планирование)
     */
    public void fillPlanProbeModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getModal().getForm().getButtonGroup("status").clickButtonByDataValue("2");
        individPlanHelper.getDose().setValue(0);
        individPlanHelper.getInputType().setValue(0);
    }

    /**
     * Заполнение формы редактирования прививки (выполнение)
     */
    public void fillDoneVaccineModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getModal().getForm().getButtonGroup("status").clickButtonByDataValue("3");
        individPlanHelper.getSeries().setValue(individPlanData.getSeries());
    }

    /**
     * Заполнение текущей даты выполнения на форме редактирования прививки
     */
    public void fillCorrectDateVaccineModal(IndividPlanData individPlanData)
    {
        individPlanHelper.getModal().getForm().getInputDate("date").setCalendarValue(page.getCurrentDate());
    }

    /**
     * Заполнение формы редактирования прививки (выполнение) из журнала прививок,
     */
    public void fillDoneVaccineModalFromJournal(IndividPlanData individPlanData)
    {
        individPlanHelper.getModal().getForm().getButtonGroup("status").clickButtonByDataValue("3");
        individPlanHelper.getSeries().setValue(individPlanData.getSeries());
        individPlanHelper.getDose().setValue(0);
        individPlanHelper.getInputType().setValue(0);
    }

    /**
     * Проверка заполнения инфекции, при выбранной вакцине
     */
    public void assertInfectionIsFill(String value)
    {
        String infectionTextValue = individPlanHelper.getModal().getForm().getOutputText("infection_text").getText();
        List<String> values = Arrays.asList(value);
        assertThat("Infection not equal to vaccine ", infectionTextValue, isIn(values));
    }

    /**
     * Проверка даты прививки, после отвода
     */
    public void assertVaccineDate()
    {
        individPlanHelper.getModal().getForm().getInputDate("date").assertThatDateContainsValue(page.addDays(page.getCurrentDate(), 1));
    }
}
