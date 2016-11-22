package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * Получение элементов в модальном окне "Изменить шаблон вида бригады 'ЛИН'"
 */
public class EditBrigadeViewTemplateHelper extends Page implements Values
{

    private Page page = Page.getInstance();


    public EditBrigadeViewTemplateHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getEditBrigadeViewTemplateModal()
    {
        return page.getModal();
    }

    /**
     * Получение контейнера "Состав сотрудников"
     * @return контейнер "Состав сотрудников"
     */
    public Container getEmployeesGroupContainer()
    {
        return getEditBrigadeViewTemplateModal().getContainer("template_employer");
    }

    /**
     * Получение контейнера "Состав транспорта"
     * @return контейнер "Состав транспорта"
     */
    public Container getTransportGroupContainer()
    {
        return getEditBrigadeViewTemplateModal().getContainer("template_transport");
    }

    /* ----------------------------- Получение таблиц ------------------------------ */

    /**
     * Получение таблицы "Состав сотрудников"
     * @return таблицу "Состав сотрудников"
     */
    public Table getEmployeesGroupTable()
    {
        return getEmployeesGroupContainer().getTable();
    }

    /**
     * Получение таблицы "Состав транспорта"
     * @return таблицу "Состав транспорта"
     */
    public Table getTranportGroupTable()
    {
        return getTransportGroupContainer().getTable();
    }

    /**
     * Получение поля "Наименование"
     * @return поле "Наименование"
     */
    public InputText getNameField()
    {
        return getEditBrigadeViewTemplateModal().getForm().getInputText("name");
    }

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveEditedBrigadeViewTemplateButton()
    {
        return getEditBrigadeViewTemplateModal().getButton(N2O_CONFIRM_BUTTON);
    }

}
