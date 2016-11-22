package businessFramework.module.pharmacy.pages.requests;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class RequestsHelper extends Page implements Values {
    public RequestsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Возвращает контейнер "Требования"
     * @return кнотейнер "Требования"
     */
    public Container getRequestsListContainer()
    {
        return getContainer("requestDocList");
    }

    /**
     * Возвращает контейнер "Спецификации"
     * @return кнотейнер "Спецификации"
     */
    public Container getSpecificationsListContainer()
    {
        return getContainer("specList");
    }

        /* -----------------------------  Фильтр на странице "Требования" ----------------------------- */

    /**
     * Получает фильтр в контейнере "Требования"
     * @return фильтр в контейнере "Требования"
     */
    public Filter getFilterForRequests()
    {
        return getRequestsListContainer().getFilter();
    }

    /**
     * @return Поле "Дата контракта" в фильтре
     */
    public InputDate getFilterContractDate()
    {
        return getFilterForRequests().getInputDate("docDate");
    }

       /* -----------------------------  Таблица "Требования" и кнопки на странице "Требования" ----------------------------- */

    /**
     * @return таблицу в контейнере "Требования"
     */
    public Table getRequestsListTable()
    {
        return getRequestsListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateRequestButton()
    {
        return getRequestsListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditRequestButton()
    {
        return getRequestsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Копировать"
     */
    public Button getCopyRequestButton()
    {
        return getRequestsListContainer().getButton(COPY_BUTTON);
    }

    /**
     * @return кнопку Просмотр
     */
    public Button getViewRequestButton()
    {
        return getRequestsListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Утвердить"
     */
    public Button getApproveRequestButton()
    {
        return getRequestsListContainer().getButton("approve");
    }

    /**
     * @return кнопку "Отменить утверждение"
     */
    public Button getDisapproveRequestButton()
    {
        return getRequestsListContainer().getButton("not_approve");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteRequestButton()
    {
        return getRequestsListContainer().getButton(DELETE_BUTTON);
    }

     /* -----------------------------  Таблица "Спецификации" и кнопки на странице "Требования" ----------------------------- */

    /**
     * @return таблицу "Спецификации"
     */
    public Table getSpecificationsTable()
    {
        return getSpecificationsListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" в контейнере "Спецификация"
     */
    public Button getCreateSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(CREATE_BUTTON);
    }


}