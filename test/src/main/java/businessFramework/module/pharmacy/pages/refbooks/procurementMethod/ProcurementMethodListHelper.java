package businessFramework.module.pharmacy.pages.refbooks.procurementMethod;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ydolgih on 12.01.2016.
 */

public class ProcurementMethodListHelper extends Page implements Values {

    public ProcurementMethodListHelper(ApplicationManager app) {
        super(app);
    }

    public Container getProcurementMethodListContainer() {
        return getContainer("procurementMethodList");
    }

    public Table getProcurementMethodListTable() {
        return getProcurementMethodListContainer().getTable();
    }

    public Button getCreateButton() {
        return getProcurementMethodListContainer().getButton(CREATE_BUTTON);
    }

    public Button getUpdateButton() {
        return getProcurementMethodListContainer().getButton(UPDATE_BUTTON);
    }

    public Button getDeleteButton() {
        return getProcurementMethodListContainer().getButton(DELETE_BUTTON);
    }

}