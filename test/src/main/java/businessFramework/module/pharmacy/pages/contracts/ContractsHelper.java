package businessFramework.module.pharmacy.pages.contracts;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ContractsHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public ContractsHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Контракты"
     * @return контейнер "Контракты"
     */
    public Container getContractsListContainer()
    {
        return getContainer("contractList");
    }

    /**
     * Получает контейнер "Спецификации"
     * @return контейнер "Спецификации"
     */
    public Container getSpecificationsListContainer()
    {
        return getContainer("contractSpecList");
    }

    /* -----------------------------  Фильтр на странице "Контракты" ----------------------------- */

    /**
     * Получает фильтр в контейнере "Контракты"
     * @return фильтр в контейнере "Контракты"
     */
    public Filter getFilterForContracts()
    {
        return getContractsListContainer().getFilter();
    }

    /**
     * @return Поле "Дата контракта" в фильтре
     */
    public InputDate getContractDate()
    {
        return getFilterForContracts().getInputDate("docDate");
    }


    /* -----------------------------  Таблица "Контракты" и кнопки на странице "Контракты" ----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateContractButton()
    {
        return getContractsListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditContractButton()
    {
        return getContractsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку Просмотр
     */
    public Button getViewContractButton()
    {
        return getContractsListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return Кнопку "Подтвердить"
     */
    public Button getApplyContractButton()
    {
        return getContractsListContainer().getButton(ACCEPT_BUTTON);
    }

    /**
     * @return Кнопку "Снять подтверждение"
     */
    public Button getRevertAcceptContractButton()
    {
        return getContractsListContainer().getButton(REVERT_ACCEPT_BUTTON);
    }

    /**
     * @return Кнопку "Исполнить"
     */
    public Button getExecuteContractButton() {
        return getContractsListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteContractButton()
    {
        return getContractsListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return таблицу в контейнере "Контракты"
     */
    public Table getContractsListTable()
    {
        return getContractsListContainer().getTable();
    }

     /* -----------------------------  Таблица "Спецификации" и кнопки на странице "Контракты" ----------------------------- */

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

    /**
     * @return кнопку "Изменить" в контейнере "Спецификация"
     */
    public Button getEditSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Снять подстверждение" в контейнере "Спецификация"
     */
    public Button getRevertAcceptSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(REVERT_ACCEPT_BUTTON);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Спецификация"
     */
    public Button getDeleteSpecificationButton()
    {
        return getSpecificationsListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "Подтвердить" на странице "Контракты
     */
    public Dialog getConfirmModal()
    {
        return page.getDialog(); // Получает последнее активное модальное окно ( ожидается окно с надписью "Предупреждение" после нажатия на кнопку "Подтвердить" на странице "Контракты")
    }

}
