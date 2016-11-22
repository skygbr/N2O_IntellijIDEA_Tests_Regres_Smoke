package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Добавить ТС в шаблон вида бригады 'ЛИН'"
 */
public class AddTransportToTemplateHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public AddTransportToTemplateHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getAddTransportModal()
    {
        return page.getModal();
    }


    /*-------------------------------- Получение полей --------------------------------*/

    /**
     * Получение поля "Роль"
     * @return поле "Роль"
     */
    public Classifier getTransportRoleField()
    {
        return getAddTransportModal().getForm().getClassifier("res_role");
    }

    /**
     * Получение поля "Рабочее место"
     * @return поле "Рабочее место"
     */
    public InputText getTransportWorkingPlaceField()
    {
        return getAddTransportModal().getForm().getInputText("work_place");
    }

    /**
     * Получение поля "Тип ТС"
     * @return поле "Тип ТС"
     */
    public Classifier getTS_TypeField()
    {
        return getAddTransportModal().getForm().getClassifier("transport_type");
    }

    /**
     * Получение поля "Вид оснащения"
     * @return поле "Вид оснащения"
     */
    public Classifier getEquipmentKindField()
    {
        return getAddTransportModal().getForm().getClassifier("transport_equipment");
    }

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveTransportButton()
    {
        return getAddTransportModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
