package businessFramework.module.pharmacy.pages.documentsForCancellation;


import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.DocumentsForWriteOff.SpecWriteOffDocModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class SpecificationsWriteOffDocHelper extends Page implements Values
{
    public SpecificationsWriteOffDocHelper(ApplicationManager app)
    {
        super(app);
    }

    /* -------------------------------- Контейнер "Партии" -------------------------------- */
    /**
     * @return контейнер "Партии"
     */
    public Container getBatchListContainer()
    {
        return getContainer("batchList");
    }

    /**
     * @return таблицу в контейнере "Партии" (batchList)
     */
    public Table getBatchListTable()
    {
        return getBatchListContainer().getTable();
    }

    /**
     * @return поле "Наименование ЛС и ИМН"
     */
    public InputText getNameLS_IMN_f()
    {
        return getBatchListContainer().getFilter().getInputText("filterHoldModif.name");
    }

    /**
     * @return поле "Склад"
     */
    public InputText getStore_f()
    {
        return getBatchListContainer().getFilter().getInputText("doc.sendStore.name");
    }

    /**
     * @return поле "Товарная группа"
     */
    public InputText getProductGroup_f()
    {
        return getBatchListContainer().getFilter().getInputText("doc.comGroup.name");
    }

    /**
     * @return поле "Финансирование"
     */
    public InputText getFinancingType_f()
    {
        return getBatchListContainer().getFilter().getInputText("doc.fundSource.name");
    }

    /**
     * @return кнопку "Добавить" в контейнере "batchList"
     */
    public Button getAddSpecButton()
    {
        return getBatchListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return модальное окно создания спецификации с этой страницы, тк с этой страницы оно открывается
     */
    public SpecWriteOffDocModal getSpecWriteOffDocModal()
    {
        return new SpecWriteOffDocModal(app);
    }


    /* ----------------------------- Контейнер "Спецификации" ----------------------- */

    /**
     * @return контейнер "Спецификации"
     */
    public Container getWriteOffSpecListContainer()
    {
        return getContainer("writeOffSpecList");
    }

    /**
     * @return таблицу в контейнере "Спецификации"
     */
    public Table getWriteOffSpecListTable()
    {
        return getWriteOffSpecListContainer().getTable();
    }

    /**
     * @return кнопку "Изменить" в контейнере "Спецификации"
     */
    public Button getEditSpecButton()
    {
        return getWriteOffSpecListContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * @return кнопку "Провести" в контейнере "Спецификации"
     */
    public Button getExecuteSpecButton()
    {
        return getWriteOffSpecListContainer().getButton(EXECUTE);
    }

    /**
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }
}
