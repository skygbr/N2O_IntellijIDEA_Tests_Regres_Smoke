package businessFramework.module.pharmacy.pages.refbooks.holding;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 28.05.2015
 */
public class HoldingListHelper extends Page implements Values {
    public HoldingListHelper(ApplicationManager app) {
    super(app);
}

    /**
     * Возвращает контейнер "Номенклатура"
     * @return контейнер "Номенклатура"
     */
    public Container getHoldingListContainer()
    {
        return getContainer("holdingList");
    }

    /* -----------------------------  Фильтр на странице "Номенклатор" ----------------------------- */

    /**
     * @return фильтр в контейнере "Номенклатор"
     */
    public Filter getFilterHoldingList()
    {
        return getHoldingListContainer().getFilter();
    }

    /**
     * Получает фильтр в контейнере "Номенклатура"
     * @return фильтр в контейнере "Номенклатура"
     */
    public Filter getFilterForHoldingList() {
        return getHoldingListContainer().getFilter();
    }

    /**
     * @return таблицу в контейнере "Номенклатуы"
     */
    public Table getHoldingListTable()
    {
        return getHoldingListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateHoldingButton()
    {
        return getHoldingListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditHoldingButton()
    {
        return getHoldingListContainer().getButton(UPDATE_BUTTON);
    }


    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteHoldingButton()
    {
        return getHoldingListContainer().getButton(DELETE_BUTTON);
    }


    /**
     * Возвращает контейнер "Модификации"
     * @return контейнер "Модификации"
     */
    public Container getModifListContainer()
    {
        return getContainer("holdModificationsList");
    }

    /**
     * @return таблицу в контейнере "Модификации"
     */
    public Table getModifListTable()
    {
        return getModifListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" в таблице "Модификации"
     */
    public Button getCreateModifButton()
    {
        return getModifListContainer().getButton(CREATE_BUTTON);
    }

    /**
     * @return кнопку "Максимальные дозы" в таблице "Модификации"
     */
    public Button getAddMaxDosesButton()
    {
        return getModifListContainer().getButton(ADD_MAX_DOSES);
    }
    /**
     * Возвращает контейнер "Производители"
     * @return контейнер "Производители"
     */
    public Container getProducerListContainer()
    {
        return getContainer("holdProducerList");
    }

    /**
     * @return таблицу в контейнере "Производители"
     */
    public Table getProducerListTable()
    {
        return getProducerListContainer().getTable();
    }

    /**
     * @return кнопку "Добавить" в таблице "Производители"
     */
    public Button getCreateProducerButton()
    {
        return getProducerListContainer().getButton(CREATE_BUTTON);
    }
}