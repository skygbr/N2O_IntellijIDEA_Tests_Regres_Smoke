package businessFramework.module.vaccination.pages.individPlan;


import businessFramework.module.Values;
import businessFramework.module.vaccination.VaccinationValues;
import businessFramework.module.vaccination.modals.individPlan.AssignAllInfectionsModal;
import businessFramework.module.vaccination.modals.individPlan.RollbackModal;
import businessFramework.module.vaccination.modals.individPlan.SeriesModal;
import businessFramework.module.vaccination.modals.individPlan.VaccineModal;
import businessFramework.module.vaccination.modals.individPlan.DenyModal;
import businessFramework.module.vaccination.modals.individPlan.SchemeTemplateModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class IndividPlanPage extends IndividPlanHelper implements VaccinationValues
{

    public IndividPlanPage(ApplicationManager app)
    {
        super(app);
    }

    public void clickFormButton()
    {
        Button create = getFormedButton();
        create.assertIsEnabled();
        create.click();
    }

    public void clickAssignAllInfectionsButton()
    {
        Button create = getAssignAllInfectionsButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Назначить прививки от всех инфекций");
    }


    public AssignAllInfectionsModal getAssignAllInfectionsModal()
    {
        return new AssignAllInfectionsModal();
    }

    public RollbackModal getRollbackModal()
    {
        return new RollbackModal();
    }

    public SchemeTemplateModal getSchemeTemplateModal()
    {
        return new SchemeTemplateModal();
    }

    public VaccineModal getVaccineModal()
    {
        return new VaccineModal();
    }

    public SeriesModal getSeriesModal()
    {
        return new SeriesModal();
    }

    public DenyModal getDenyModal()
    {
        return new DenyModal();
    }

    public void clickRollbackButton()
    {
        Button create = getRollbackButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Отменить назначения от всех инфекций");
    }

    public void clickAddSchemeTemplateButton()
    {
        Button create = getAddSchemeTemplateButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Задать схему");
    }

    public void clickAddInoculationButton()
    {
        Button create = getAddInoculationButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Создание прививки");
    }

    public void clickAddProbaButton()
    {
        Button create = getAddProbaButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Создание пробы");
    }


    public void clickEditButton()
    {
        Button edit = getEditButton();
        edit.assertIsEnabled();
        edit.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Редактирование прививки");
    }

    public void clickEditProbeButton()
    {
        Button edit = getEditButton();
        edit.assertIsEnabled();
        edit.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Редактирование манту");
    }


    public void clickDeleteButton()
    {
        Button delete = getDeleteButton();
        delete.assertIsEnabled();
        delete.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Предупреждение");
        getModal().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Установка фокуса на первой ячейки таблицы
     */
    public void setFocusOnTheFirstSlot()
    {
      WebElement scroll = findElement(By.cssSelector(".n2o-grid-container_table"));
      scroll.sendKeys(Keys.PAGE_UP);
        scroll.sendKeys(Keys.PAGE_UP);//повторный скролл сделан, после того как первый перестал скроллить до конца таблицу
          scroll.sendKeys(Keys.PAGE_UP);//повторный скролл сделан, после того как первый перестал скроллить до конца таблицу

      WebElement slot = getContainerIndividPlanTable().findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
      click(slot);
    }

    /**
     * Cкроллинг календаря вниз до текущей даты
     */
    public void scrollPageDown()
    {
        WebElement scrollDown = findElement(By.cssSelector(".n2o-grid-container_table"));
        scrollDown.sendKeys(Keys.PAGE_DOWN);
    }

    /**
     * Установка фокуса на ячейки со статусом "Назначено"
     */
    public void setFocusAssignVaccineSlot()
    {
        click(getContainerIndividPlanTable().findElement(By.cssSelector(ASSIGNED)));
    }

    /**
     * Установка фокуса на ячейки со статусом "Запланировано"
     */
    public void setFocusPlanVaccineSlot()
    {
        click(getContainerIndividPlanTable().findElement(By.cssSelector(PLANNED)));
    }
    /**
     * Установка фокуса на ячейки со статусом "Выполнено"
     */
    public void setFocusDoneVaccineSlot()
    {
        click(getContainerIndividPlanTable().findElement(By.cssSelector(DONE)));
    }

    /**
     * Проверка, что на форме есть прививки со статусом "Сформировано" и нет с другими статусами
     */

    public void assertFormBeforeAllAssign()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(FORMED), true);

//        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(".status-1, .status-666, .status-2, .status-3"), false);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(ASSIGNED), false);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(OVERDUE), false);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(PLANNED), false);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(DONE), false);
    }

    /**
     * Проверка, что на форме есть прививки со статусами "Назначено" и "Просрочено" и нет со статусом "Сформировано"
     */
    public void assertFormAfterAllAssign()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(ASSIGNED), true);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(OVERDUE), true);
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(FORMED), false);
    }


    /**
     * Проверка, что на форме есть прививка со статусами "Назначено"
     */
    public void assertThatVaccineIsAssign()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(ASSIGNED), true);
    }

    /**
     * Проверка, что на форме есть прививка, назначенная по схеме
     */
    public void  assertThatVaccineIsAssignByScheme()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(ASSIGNED_BY_SCHEME), true);
        assertThat (getContainerIndividPlanTable().findElement(By.cssSelector(ASSIGNED_BY_SCHEME)).getText(), is(CALENDAR_VACCINE));
    }

    /**
     * Проверка, что на форме есть прививка со статусами "Запланировано"
     */
    public void assertThatVaccineIsPlanning()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(PLANNED), true);

    }

    /**
     * Проверка, что на форме есть прививка со статусами "Выполнено"
     */
    public void assertThatVaccineIsDone()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(DONE), true);

    }

    /**
     * Проверка, что на форме есть прививки со статусами "Просрочено"
     */
    public void assertFormAfterAllAssignGroupOfRisk()
    {
        getContainerIndividPlanTable().assertThatElementPresent(By.cssSelector(OVERDUE), true);

    }

}
