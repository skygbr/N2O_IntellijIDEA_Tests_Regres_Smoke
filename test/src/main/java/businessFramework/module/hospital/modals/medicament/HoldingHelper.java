package businessFramework.module.hospital.modals.medicament;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class HoldingHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public HoldingHelper() {
        this.container = "holding";
    }

    public HoldingHelper(String container) {
        this.container = container;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Container getHoldingListContainer() {
        return page.getModal().getContainer("main");
    }

    public Container getHoldingStoresContainer() {
        return page.getModal().getContainer("holdingStores");
    }

    public Table getHoldingListTable() {
        return getHoldingListContainer().getTable();
    }

    public Button getButtonConfirm() {
        return page.getModal().getButton(CONFIRM_BUTTON);
    }

    public Classifier getFilterHoldingField() {
        return page.getModal().getFilter().getClassifier("holding");
    }

    public Filter getModalFilter() {
        return page.getModal().getFilter();
    }
}
