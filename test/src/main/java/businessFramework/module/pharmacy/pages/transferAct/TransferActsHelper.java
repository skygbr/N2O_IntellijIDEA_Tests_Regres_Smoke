package businessFramework.module.pharmacy.pages.transferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActsHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public TransferActsHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получает контейнер "Акты переброски"
     * @return контейнер "Акты переброски"
     */
    public Container getTransferActListContainer()
    {
        return getContainer("transferActList");
    }

    /**
     * Получает контейнер "Спецификации"
     * @return контейнер "Спецификации"
     */
    public Container getTransferActSpecContainer()
    {
        return getContainer("transferSpecList");
    }


    /**
     * @return Получает таблицу "Акты переброски" в контейнере TransferActList
     */
    public Table getTransferActListTable()
    {
        return getTransferActListContainer().getTable();
    }

    /* -----------------------------  Фильтр на странице "Акты переброски" ----------------------------- */

    /**
     * Получает фильтр в контейнере "Акты переброски"
     * @return фильтр в контейнере "Акты переброски"
     */
    public Filter getFilterTransferAct()
    {
        return getTransferActListContainer().getFilter();
    }
    /**
     * @return Поле "Дата документа" в фильтре
     */
    public InputDate getDocumentDate()
    {
        return getFilterTransferAct().getInputDate("docDate");
    }

    /**
     * @return Поле "Номер документа" в фильтре
     */
    public InputText getDocumentNumber() {
        return getFilterTransferAct().getInputText("docNumber");
    }

    /* ----------------------------- Кнопки в контейнере "Акты переброски" на странице "Акты переброски" ----------------------------- */

    /**
     * @return кнпоку "Добавить" на странице "Акты переброски"
     */
    public Button getAddTransferActButton()
    {
        return getTransferActListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить" на странице "Акты переброски"
     */
    public Button getEditTransferActButton()
    {
        return getTransferActListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Копировать" на странице "Акты переброски"
     */
    public Button getCopyTransferActButton()
    {
        return getTransferActListContainer().getButton(COPY_BUTTON);
    }

    /**
     * @return кнопку "Просмотр" на странице "Акты переброски"
     */
    public Button getViewTransferActButton()
    {
        return getTransferActListContainer().getButton(VIEW_BUTTON);
    }

    /**
     * @return кнопку "Провести" на странице "Акты переброски"
     */
    public Button getExecuteTransferActButton()
    {
        return getTransferActListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Удалить" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public Button getDeleteTransferActButton()
    {
        return getTransferActListContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return кнопку "Принять" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public Button getAcceptTransferActButton(){
        return getTransferActListContainer().getButton(ACCEPT_BUTTON);
    }

    /**
     *@retun кнопку "Отменить прием" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public Button getRevertAcceptTransferActButton(){
        return getTransferActListContainer().getButton(REVERT_ACCEPT_BUTTON);
    }

    /**
     * @return кнопку "Вернуть" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public Button getCancelExecutionTransferActButton()
    {
        return getTransferActListContainer().getButton(CANCEL);
    }

    /* ----------------------------- Кнопки в контейнере "Спецификация" на странице "Акты переброски" ----------------------------- */

    /**
     * @return кнопку "Добавить" в контейнере "Спецификация"
     */
    public Button getAddSpecificationButton()
    {
        return getTransferActSpecContainer().getButton(CREATE_BUTTON);
    }


    /**
     * @return окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Акты переброски" в контейнере "Акты переброски"
     */
    public Dialog getConfirmModal()
    {
        return page.getDialog(); // Получает последнее активное модальное окно ( ожидается окно с надписью "Предупреждение" после нажатия на кнопку "Удалить" на странице "Акты переброски" в контейнере "Акты переброски")
    }


}
