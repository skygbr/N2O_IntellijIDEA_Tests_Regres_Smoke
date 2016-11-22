package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;


/**
 * Получение элементов в модальном окне "Создать шаблон вида бригады"
 */
public class AddBrigadeViewTemplateHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public AddBrigadeViewTemplateHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getAddBrigadeViewTemplateModal()
    {
        return page.getModal();
    }

    /**
     * Получение поля "Код"
     * @return поле "Код"
     */
    public InputText getCodeField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getInputText("code");
    }

    /**
     * Получение поля "Наименование"
     * @return поле "Наименование"
     */
    public InputText getNameField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getInputText("name");
    }

    /**
     * Получение поля "Вид бригады"
     * @return поле "Вид бригады"
     */
    public Classifier getBrigadeKindField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getClassifier("team_kind");
    }

    /**
     * Получение поля "Вид наряда"
     * @return поле "Вид наряда"
     */
    public Classifier getJobKindField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getClassifier("job_kind");
    }

    /**
     * Получение поля "Тип бригады"
     * @return поле "Тип бригады"
     */
    public Classifier getBrigadeTypeField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getClassifier("team_type");
    }

    /**
     * Получение поля "Профиль"
     * @return поле "Профиль"
     */
    public Classifier getProfileField()
    {
        return getAddBrigadeViewTemplateModal().getForm().getClassifier("md_profile");
    }

    /**
     * Получение кнпоки "Сохранить"
     * @return кнпоку "Сохранить"
     */
    public Button getSaveBrigadeViewTemplateButton()
    {
        return getAddBrigadeViewTemplateModal().getButton(N2O_CONFIRM_BUTTON);
    }


}
