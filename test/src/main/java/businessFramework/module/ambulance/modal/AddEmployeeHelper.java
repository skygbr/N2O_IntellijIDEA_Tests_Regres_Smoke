package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Добавить сотрудника в шаблон вида бригады 'ЛИН'"
 */
public class AddEmployeeHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public AddEmployeeHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getAddEmployeeModal()
    {
        return page.getModal();
    }



    /* --------------------------- Получение полей --------------------------- */

    /**
     * Получение поля "Роль"
     *
     * @return поле "Роль"
     */
    public Classifier getRoleField()
    {
        return getAddEmployeeModal().getForm().getClassifier("res_role");
    }

    /**
     * Получение поля "Категория персонала"
     *
     * @return поле "Категория персонала"
     */
    public Classifier getPersonalCategory()
    {
        return getAddEmployeeModal().getForm().getClassifier("position_category");
    }

    /**
     * Получение поля "Рабочее место"
     * @return поле "Рабочее место"
     */
    public InputText getWorkingPlaceField()
    {
        return getAddEmployeeModal().getForm().getInputText("work_place");
    }

    /**
     * Получение поля "Специальность"
     * @return поле "Специальность"
     */
    public Classifier getSpetialityField()
    {
        return getAddEmployeeModal().getForm().getClassifier("speciality");
    }

    /**
     * Получение поля "Должность"
     * @return поле "Должность"
     */
    public Classifier getPositionField()
    {
        return getAddEmployeeModal().getForm().getClassifier("position_role");
    }

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveEmployeeButton()
    {
        return getAddEmployeeModal().getButton(N2O_CONFIRM_BUTTON);
    }


}
