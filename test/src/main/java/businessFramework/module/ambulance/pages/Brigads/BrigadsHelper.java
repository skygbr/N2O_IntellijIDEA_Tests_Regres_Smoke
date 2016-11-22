package businessFramework.module.ambulance.pages.Brigads;


import businessFramework.module.Values;
import businessFramework.module.ambulance.modal.AddBrigadeModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Получение элементов на странице "Бригады: справочники - Бригады"
 */

public class BrigadsHelper extends Page implements Values
{
    public BrigadsHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера "Бригады"
     * @return контейнер "Бригады"
     */
    public Container getBrigadsContainer()
    {
        return getContainer("res_team");
    }

    /**
     * Получение кнопки "Создать"
     * @return кнопку "Создать"
     */
    public Button getAddBrigadeButton()
    {
       return getBrigadsContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getUpdateBrigadeButton()
    {
        return getBrigadsContainer().getButton(UPDATE_BUTTON);
    }


    /* ----------------------------- Получение модальных окон ------------------------------ */

    /**
     * Получение модального окна "Создать бригаду" с этой страницы, тк его открытие происходит по нажатию кнопки "Создать"
     * в контейнере "Бригады" на этой странице.
     *
     * @return модальное окно "Создать бригаду"
     */
    public AddBrigadeModal getAddBrigadeModal()
    {
        return new AddBrigadeModal(app);
    }

    /**
     * Получение контейнера "Бригады"
     * @return контейнер "Бригады"
     */
    public Container getBrigadeContainer()
    {
        return getContainer("res_team");
    }

    /**
     * Получение таблицы в контейнере "Бригады"
     * @return таблицу в контейнере "Бригады"
     */
    public Table getBrigadeTable()
    {
        return getBrigadeContainer().getTable();
    }

}
