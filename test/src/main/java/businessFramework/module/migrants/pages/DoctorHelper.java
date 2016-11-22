package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class DoctorHelper extends Page implements Values {

    public DoctorHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение контейнера с деревом слева на странице
     * @return контейнер EventsList
     */
    public Container getContainerMigrantsRegistrator()
    {
        return getRegion(LEFT).getContainer("EventsList");
    }

    /**
     * Получение дерева из контейнера EventsList
     * @return дерево из контейнера EventsList
     */
    public Tree getEventsListMigrantsRegistratorTree()
    {
        return getContainerMigrantsRegistrator().getTree();
    }

    /**
     * Получение контейнера с таблицей "Осмотры и услуги"
     * @return контейнер Осмотры и услуги
     */
    public Container getContainerServices()
    {
        return getContainer("Services");
    }

    /**
     * Получение контейнера с таблицей "Оказание услуги"
     * @return контейнер Оказание услуги
     */
    public Container getContainerService()
    {
        return getContainer("Service");
    }

    /**
     * Получение кнопки "Редактировать"
     * @return кнопку "Редактировать"
     */
    public Button getUpdateButton()
    {
        return getContainerService().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Очистить"
     * @return кнопку "Очистить"
     */
    public Button getClearServiceButton()
    {
        return getContainerService().getButton("clearService");
    }

    /**
     * Получение поля "Организация"
     * @return поле "Организация"
     */
    public InputText getOwnerOrganisation()
    {
        return getContainerService().getForm().getInputText("owner_org");
    }

    /**
     * Получение поля "Дата"
     * @return поле "Дата"
     */
    public InputDate getExecutionDate()
    {
        return getContainerService().getForm().getInputDate("date");
    }

    public Classifier getResource() {
        return getContainerService().getForm().getClassifier("resource");
    }

    /**
     * Получение радиобаттона "Результат"
     * @return радиобаттон "Результат"
     */
    public Radio getResultRadio()
    {
        return getContainerService().getForm().getRadio("result");
    }

    /**
     * Получение кнопки "Подтведить"
     * @return кнопка "Подтведить"
     */
    public Button getConfirmButton()
    {
        return getContainerService().getButton(N2O_CONFIRM_BUTTON);
    }

}