package businessFramework.module.pharmacy.pages.refbooks.storeList;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


import java.lang.annotation.Target;

/**
 * @author ydolgih
 * @since 03.07.2015
 */
public class StoreListHelper extends Page implements Values {

    String SET_STORE_CLOSING_DATE_BUTTON  = "setClosingPeriod";

    public StoreListHelper(ApplicationManager app) {
        super(app);
    }

    public Container getStoreListContainer() {
        return getContainer("storeList");
    }

    public Container getStoreClosingDateContainer() {
        return getContainer("closingPeriodList");
    }

    public Table getStoreListTable(){ return getStoreListContainer().getTable();}

    /**
     * @return кнопку "Изменить"
     */
    public Button getStoreClosingDateButton()
    {
        return getStoreListContainer().getButton(SET_STORE_CLOSING_DATE_BUTTON);
    }
}

