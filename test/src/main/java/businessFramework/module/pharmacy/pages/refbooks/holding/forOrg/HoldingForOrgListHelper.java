package businessFramework.module.pharmacy.pages.refbooks.holding.forOrg;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class HoldingForOrgListHelper extends Page implements Values {
    public HoldingForOrgListHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Возвращает контейнер "Модификации"
     * @return контейнер "Модификации"
     */
    public Container getModifListContainer()
    {
        return getContainer("holdModifList");
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

}
