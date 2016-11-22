package businessFramework.module.dispensary.pages.Events;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.Tree;
import net.framework.autotesting.meta.components.Button;

public class EventsHelper extends Page implements Values{
    public EventsHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получение контейнера с деревом слева на странице
     * @return контейнер EventsList
     */
    public Container getContainerGibddRegistrator()
    {
        return getRegion(LEFT).getContainer("EventsList");
    }

    /**
     * Получение дерева из контейнера EventsList
     * @return дерево из контейнера EventsList
     */
    public Tree getEventsListGibddRegistratorTree()
    {
        return getContainerGibddRegistrator().getTree();
    }

    /*----------------------- Контейнер Мероприятия -----------------------*/

    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateEventButton()
    {
        return getContainerGibddRegistrator().getButton(UPDATE_BUTTON);
    }


    /**
     * Получение кнопки "Создать"
     * @return кнопка "Создать"
     */
    public Button getCreateEventButton()
    {
        return getContainerGibddRegistrator().getButton(CREATE_BUTTON);
    }

    /* --------------------- Контейнер Пациенты --------------------------- */

    /**
     * Получение контейнера с таблицей Пациенты справа на странице
     * @return контейнер Пациенты справа на странице
     */
    public Container getContainerPatients()
    {
        return getRegion(RIGHT).getContainer("orphansEventPatients");
    }

    /**
     * Получение таблицы со списком пациентов
     * @return таблицу со списком пациентов
     */
    public Table getEventsListTable()
    {
        return getContainerPatients().getTable();
    }

    /**
     * Получение кнопки "Соглашение"
     * @return кнопка "Соглашение"
     */
    public Button getAgreementButton()
    {
        return getContainerPatients().getButton("agreementMinors");
    }
    /**
     * Получение кнопки "Карточка"
     * @return кнопку "Карточка"
     */
    public Button getCardButton()
    {
        return getContainerPatients().getButton("card");
    }
}
