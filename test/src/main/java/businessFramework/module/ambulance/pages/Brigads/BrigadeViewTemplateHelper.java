package businessFramework.module.ambulance.pages.Brigads;


import businessFramework.module.Values;
import businessFramework.module.ambulance.modal.AddBrigadeViewTemplateModal;
import businessFramework.module.ambulance.modal.AddEmployeeModal;
import businessFramework.module.ambulance.modal.AddTransportToTemplateModal;
import businessFramework.module.ambulance.modal.EditBrigadeViewTemplateModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.meta.Table;

/**
 * Получение элементов на странице "Бригады: справочники - Шаблон вида бригады"
 */

public class BrigadeViewTemplateHelper extends Page implements Values
{
    public BrigadeViewTemplateHelper(ApplicationManager app)
    {
        super(app);
    }


    /* ----------------------------- Контейнер "Настройка вида бригады" ------------------------------ */

    /**
     * Получение контейнера "Настройка вида бригады"
     * @return контейнер "Настройка вида бригады"
     */
    public Container getBrigadeViewTemplateContainer()
    {
        return getContainer("team_template");
    }

    /**
     * Получение кнопки "Добавить"
     * @return кнопку "Добавить"
     */
    public Button getCreateBrigadeViewTemplateButton()
    {
        return getBrigadeViewTemplateContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditBrigateViewTemplateButton()
    {
        return getBrigadeViewTemplateContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопку "Удалить"
     */
    public Button getDeleteBrigateViewTemplateButton()
    {
        return getBrigadeViewTemplateContainer().getButton(DELETE_BUTTON);
    }


    /* ----------------------------- Получение модальных окон ------------------------------ */


    /**
     * Получение модального окна "Создать шаблон вида бригады" с этой страницы, тк его открытие происходит по нажатию кнопки "Добавить"
     * в контейнере "Настройка вида бригады" на этой странице.
     *
     * @return модальное окно "Создать шаблон вида бригады"
     */
    public AddBrigadeViewTemplateModal getAddBrigadeViewTemplateModal()
    {
        return new AddBrigadeViewTemplateModal(app);
    }

    /**
     * Получение модального окна "Добавить сотрудника в шаблон вида бригады 'ЛИН'" с этой страницы, тк его открытие происходит по нажатию кнопки "Добавить"
     * в контейнере "Сотрудники" на этой странице.
     *
     * @return модальное окно "Добавить сотрудника в шаблон вида бригады 'ЛИН'"
     */
    public AddEmployeeModal getAddEmployeeModal()
    {
        return new AddEmployeeModal(app);
    }

    /**
     * Получение модального окна "Добавить ТС в шаблон вида бригады 'ЛИН'" с этой страницы, тк его открытие происходит по нажатию кнопки "Добавить"
     * в контейнере "Транспорт" на этой странице.
     *
     * @return модальное окно "Добавить ТС в шаблон вида бригады 'ЛИН'"
     */
    public AddTransportToTemplateModal getAddTransportModal()
    {
        return new AddTransportToTemplateModal(app);
    }

    /**
     * Получение модального окна "Изменить шаблон вида бригады 'ЛИН'" с этой страницы, тк его открытие происходит по нажатию кнопки "Изменить"
     * в контейнере "Настройка вида бригады"  на этой странице.
     *
     * @return модальное окно "Изменить шаблон вида бригады 'ЛИН'"
     */
    public EditBrigadeViewTemplateModal getEditBrigadeViewTemplateModal()
    {
        return new EditBrigadeViewTemplateModal(app);
    }





    /* ----------------------------- Контейнер "Сотрудники" ------------------------------ */

    /**
     * Получение контейнера "Сотрудники"
     * @return контейнер "Сотрудники"
     */
    public Container getEmployeesContainer()
    {
        return getContainer("template_employer");
    }

    /**
     * Получение кнопки "Добавить"
     * @return кнопку "Добавить"
     */
    public Button getAddEmployeeButton()
    {
        return getEmployeesContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditEmployeeButton()
    {
        return getEmployeesContainer().getButton(UPDATE_BUTTON);
    }





    /* ----------------------------- Контейнер "Транспорт" ------------------------------ */

    /**
     * Получение контейнера "Транспорт"
     * @return контейнер "Транспорт"
     */
    public Container getTransportContainer()
    {
        return getContainer("template_transport");
    }

    /**
     * Получение кнопки "Добавить"
     * @return кнопку "Добавить"
     */
    public Button getAddTransportButton()
    {
        return getTransportContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditTransportButton()
    {
        return getTransportContainer().getButton(UPDATE_BUTTON);
    }


    /* --------------------------- Получение таблиц --------------------------- */

    /**
     * @return таблицу в контейнере "Настройка вида бригады"
     */
    public Table getSettingsBrigadeViewTable()
    {
        return getBrigadeViewTemplateContainer().getTable();
    }

    /**
     * @return таблицу в контейнере "Сотрудники"
     */
    public Table getEmployeesTable()
    {
        return getEmployeesContainer().getTable();
    }
}
