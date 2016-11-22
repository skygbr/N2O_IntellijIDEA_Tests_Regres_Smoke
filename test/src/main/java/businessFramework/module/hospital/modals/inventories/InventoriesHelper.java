package businessFramework.module.hospital.modals.inventories;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class InventoriesHelper implements Values {
    private String container;
    private Page page = Page.getInstance();

    public InventoriesHelper() {
        this.container = "inventories";
    }

    public InventoriesHelper(String container) {
        this.container = container;
    }

    public Container getContainer() {
        return page.getModal().getContainer(container);
    }

    public Button getExecuteButton() {
        return page.getModal().getButton("executeWithWriteOff");
    }

    public Button getConfirmButton() {
        return page.getModal().getButton(CONFIRM_BUTTON);
    }

    public Button getCancelButton() {
        return page.getModal().getButton(CANCEL);
    }

    public void closeInventoriesModal() {
        page.getModal().closeModal();
    }

}
