package businessFramework.module.ambulance.pages.Brigads;


import businessFramework.module.Values;
import businessFramework.module.ambulance.modal.CreateTransportModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Select;

/**
 * Получение элементов на странице "Бригады: справочники - Транспортное средство"
 */

public class TransportHelper extends Page implements Values
{
    public TransportHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера "Картотека транспортных средств"
     * @return контейнер "Картотека транспортных средств"
     */
    public Container getTransportContainer()
    {
        return getContainer("transport");
    }

    /**
     * Получение таблицы в контейнере "Картотека транспортных средств"
     * @return таблицу в контейнере "Картотека транспортных средств"
     */
    public Table getTransportTable()
    {
        return getTransportContainer().getTable();
    }

    /**
     * Получение кнопки "Добавить"
     * @return кнопку "Добавить"
     */
    public Button getCreateTransportButtton()
    {
        return getTransportContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditCreatedTransportButton()
    {
        return getTransportContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопку "Удалить"
     */
    public Button getDeleteTransportButton()
    {
        return getTransportContainer().getButton(DELETE_BUTTON);
    }

    /*------------------------------- Фильтр в контейнере "Картотека транспортных средств" ------------------------*/

    /**
     * Получение селектора "Действующий"
     * @return селектор "Действующий"
     */
    public Select getFilterActive()
    {
        return getTransportContainer().getFilter().getSelect("active");
    }

    /* ----------------------------- Получение модальных окон ------------------------------ */

    /**
     * Получение модального окна "Добавить карточку ТС" с этой страницы, тк его открытие происходит по нажатию кнопки "Создать"
     * в контейнере "Картотека транспортных средств" на этой странице.
     *
     * @return модальное окно "Добавить карточку ТС"
     */
    public CreateTransportModal getCreateTransportModal()
    {
        return new CreateTransportModal(app);
    }

}
