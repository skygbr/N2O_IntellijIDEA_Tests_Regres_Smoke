package businessFramework.module.gibddMedicalExamination.pages.Registrator;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.Button;

public class RegistrationHelper extends Page implements Values
{

    public RegistrationHelper(ApplicationManager app)
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

    // --------------------- Контейнер Пациенты --------------------------- //


    /**
     * Получение контейнера с таблицей Пациенты на странице
     * @return контейнер gibddReference
     */
    public Container getContainerPatients()
    {
        return getRegion(RIGHT).getContainer("gibddReference");
    }

    /**
     * Получение контейнера с таблицей Список справок на странице
     * @return контейнер referenceCard
     */
    public Container getContainerSpravki()
    {
        return getRegion(RIGHT).getContainer("referenceCard");
    }

    /**
     * Получение таблицы со списком пациентов в контейнере gibddRefence
     * @return таблицу со списком пациентов в контейнере gibddRefence
     */
    public Table getEventsListGibddRegistratorTable()
    {
        return getContainerPatients().getTable();
    }

    /**
     * Получение таблицы со списком пациентов в контейнере referenceCard
     * @return таблицу со списком пациентов в контейнере referenceCard
     */
    public Table getEventsListGibddSpravkaRegistratorTable()
    {
        return getContainerSpravki().getTable();
    }

    /**
     * Получение кнопки "Добавить пациента"
     * @return кнопку "Добавить пациента"
     */
    public Button getAddPatientButton()
    {
        return getButton(ADD_DRIVER);
    }

    /**
     * Получение кнопки "Карточка"
     * @return кнопку "Карточка"
     */
    public Button getDriverCardButton()
    {
        return getContainerPatients().getButton(DRIVER_CARD);
    }

}
