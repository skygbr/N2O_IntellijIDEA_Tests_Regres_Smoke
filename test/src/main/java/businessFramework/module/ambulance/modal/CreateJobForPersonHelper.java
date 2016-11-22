package businessFramework.module.ambulance.modal;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Получение элементов с модального окна  "Создать наряд на сотрудника в бригаде '7204 (19.06.2015)'"
 */
public class CreateJobForPersonHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public CreateJobForPersonHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getCreateJobForPersonModal()
    {
        return page.getModal();
    }


    /*-------------------------------- Получение полей --------------------------------*/

    /**
     * Получение поля "Дата"
     * @return поле "Дата"
     */
    public InputDate getDateField()
    {
        return getCreateJobForPersonModal().getForm().getInputDate("data");
    }

    /**
     * Получение поля "Наряд бригады"
     * @return поле "Наряд бригады"
     */
    public Classifier getBrigadeJobField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("team_job");
    }

    /**
     * Получение поля "Вид ресурса"
     * @return поле "Вид ресурса"
     */
    public Classifier getResourceKindField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("res_kind");
    }

    /**
     * Получение поля "Рабочее место в шаблоне"
     * @return поле "Рабочее место в шаблоне"
     */
    public Classifier getWorkingPlaceInTemplateField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("res_role");
    }

    /**
     * Получение поля "Рабочее место в шаблоне" ( в м. окне "Создать наряд на ТС в бригаде" )
     * @return поле "Рабочее место в шаблоне"
     */
    public Classifier getWorkingPlaceInTemplateTSField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("template_transport");
    }

    /**
     * Получение поля "Роль"
     * @return поле "Роль"
     */
    public Classifier getRoleField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("res_role");
    }

    /**
     * Получение поля "Рабочее место 2"
     * @return поле "Рабочее место 2"
     */
    public InputText getWorkingPlace2Field()
    {
        WebElement inputFieldElement = getCreateJobForPersonModal().getForm().findElement(By.cssSelector(":not(.n2o-hidden)[data-field-id='workplace']"));
        String dataInstanceId = inputFieldElement.getAttribute("data-instance-id");
        return new InputText(app, inputFieldElement, "workplace", dataInstanceId);
    }

    /**
     * Получение поля "Ресурс"
     * @return поле "Ресурс"
     */
    public Classifier getResourceField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("resource");
    }

    /**
     * Получение поля "Ресурс"
     * @return поле "Ресурс"
     */
    public InputText getHasTeamJobField()
    {
        return getCreateJobForPersonModal().getForm().getInputText("has_team_job");
    }

    /**
     * Получение поля "Вид наряда"
     * @return поле "Вид наряда"
     */
    public Classifier getJobKindField()
    {
        return getCreateJobForPersonModal().getForm().getClassifier("job_kind");
    }

    /**
     * Получение поля "Старший в наряде"
     * @return поле "Старший в наряде"
     */
    public InputCheckBox getOlderInJobField()
    {
        return getCreateJobForPersonModal().getForm().getInputCheckBox("is_head");
    }

    /**
     * Получение поля "Дата/время начала наряда плановое"
     * @return поле "Дата/время начала наряда плановое"
     */
    public InputText getBeginDateTimeField()
    {
        return getCreateJobForPersonModal().getForm().getInputText("planned_bdate");
    }

    /**
     * Получение поля "Дата/время окончания наряда плановое"
     * @return поле "Дата/время окончания наряда плановое"
     */
    public InputText getEndDateTimeField()
    {
        return getCreateJobForPersonModal().getForm().getInputText("planned_edate");
    }


    /*-------------------------------- Получение кнопок --------------------------------*/

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSavePersonJobButton()
    {
        return getCreateJobForPersonModal().getButton(N2O_CONFIRM_BUTTON);
    }

}
