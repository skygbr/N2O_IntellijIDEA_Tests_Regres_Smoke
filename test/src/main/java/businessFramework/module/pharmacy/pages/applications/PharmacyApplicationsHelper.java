package businessFramework.module.pharmacy.pages.applications;


import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.PharmacyApplications.ApplicationModal;
import businessFramework.module.pharmacy.modals.PharmacyApplications.CreateAppSpecModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class PharmacyApplicationsHelper extends Page implements Values
{
    /** Страница "Заявки" */
    public PharmacyApplicationsHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * @return контейнер "Заявки"
     */
    public Container getApplicationDocListContainer()
    {
        return getContainer("applicationDocList");
    }

    /**
     * @return контейнер "Спецификации"
     */
    public Container getSpecificationsContainer()
    {
        return getContainer("appSpecList");
    }

    /**
     * @return таблицу в контейнере "Заявки"
     */
    public Table getApplicationsTable()
    {
        return getApplicationDocListContainer().getTable();
    }

    /**
     * @return таблицу в контейнере "Спецификации"
     */
    public Table getSpecificationsTable()
    {
        return getSpecificationsContainer().getTable();
    }

    /** ---------------------------- Поля в фильтре ---------------------------- */

    /**
     * @return поле "Дата документа"
     */
    public InputDate getDocDateField()
    {
        return getApplicationDocListContainer().getFilter().getInputDate("docDate");
    }

    /**
     * @return поле "Статус"
     */
    public Select getDocStatusField()
    {
        return getApplicationDocListContainer().getFilter().getSelect("status");
    }

    /** ---------------------------- Кнопки в контейнере "Заявки" ---------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddApplicationButton()
    {
        return getApplicationDocListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getUpdateApplicationButton()
    {
        return getApplicationDocListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteApplicationButton()
    {
        return getApplicationDocListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return кнопку "Консолидировать"
     */
    public Button getConsolidateApplicationButton()
    {
        return getApplicationDocListContainer().getButton(CONSOLIDATE);
    }

    /**
     * @return кнопку "Просмотр"
     */
    public Button getViewApplicationButton()
    {
        return getApplicationDocListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * Получаем модальное окно "Создание заявки" с этой страницы, тк с этой страницы оно открывается
     * @return модальное окно "Создание заявки"
     */
    public ApplicationModal getApplicationModal()
    {
        return new ApplicationModal(app);
    }

    /**
     * Получаем модальное окно добавления спецификации с этой страницы, тк с этой страницы оно открывается
     * @return модальное окно добавления спецификации
     */
    public CreateAppSpecModal getCreateAppSpecModal()
    {
        return new CreateAppSpecModal(app);
    }

    /** ---------------------------- Кнопки в контейнере "Спецификации" ---------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getAddSpecButton()
    {
        return getSpecificationsContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditSpecButton()
    {
        return getSpecificationsContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Просмотр"
     */
    public Button getViewSpecButton()
    {
        return getSpecificationsContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Утвердить"
     */
    public Button getApproveAppButton()
    {
        return getApplicationDocListContainer().getButton(APPROVE);
    }

    /**
     * @return кнопку "Отменить утверждение"
     */
    public Button getCancelApproveAppButton()
    {
        return getApplicationDocListContainer().getButton(CANCEL_APPROVE);
    }
}
