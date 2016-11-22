package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class CommissionHelper extends Page implements Values {

    public CommissionHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение контейнера с деревом слева на странице
     * @return контейнер EventsList
     */
    public Container getContainerMigrantsCommission()
    {
        return getRegion(LEFT).getContainer("EventsList");
    }

    /**
     * Получение дерева из контейнера EventsList
     * @return дерево из контейнера EventsList
     */
    public Tree getEventsListMigrantsCommissionTree()
    {
        return getContainerMigrantsCommission().getTree();
    }

    /**
     * Получение таблицы "Освидетельствование ИГ и ЛГ" в контейнере migrantList
     * @return таблицу "Освидетельствование ИГ и ЛГ" в контейнере migrantList
     */
    public Table getMigrantsCommissionTable()
    {
        return getContainerPatients().getTable();
    }

    /* --------------------- Контейнер "Освидетельствование ИГ и ЛГ" --------------------------- */


    /**
     * Получение контейнера с таблицей "Освидетельствование ИГ и ЛГ" справа на странице.
     * @return контейнер migrantList
     */
    public Container getContainerPatients()
    {
        return getRegion(RIGHT).getContainer("migrantList");
    }

    /**
     * Получение кнопки "Добавить пациента"
     * @return кнопку "Добавить пациента"
     */
    public Button getAddPatientButton()
    {
        return getContainerPatients().getButton(SEARCH_BUTTON);
    }

    /**
     * Получение кнопки "Карточка"
     * @return кнопку "Карточка"
     */
    public Button getCardButton()
    {
        return getContainerPatients().getButton(CARD_BUTTON);
    }

    /**
     * Получение кнопки "Удалить пациента"
     * @return кнопку "Удалить пациента"
     */
    public Button getDeletePatientButton()
    {
        return getContainerPatients().getButton("removePatient");
    }

    /**
     * Получение ссылки на страницу "Карточка ИГ и ЛГ" с этой страницы, тк переход на страницу "Карточка ИГ и ЛГ"  происходит с этой страницы по нажатию кнпоки
     * "Карточка" в контейнере Освидетельствование ИГ и ЛГ
     *
     * @return ссылку на страницу "Карточка ИГ и ЛГ"
     */
    public PatientCardPage getPatientCardPage()
    {
        return new PatientCardPage(app);
    }

}