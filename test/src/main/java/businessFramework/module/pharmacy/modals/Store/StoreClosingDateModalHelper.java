package businessFramework.module.pharmacy.modals.Store;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 03.07.2015
 */
public class StoreClosingDateModalHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public StoreClosingDateModalHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     *
     * @return Это модальное окно
     */
    public Modal getModal() {
        return page.getModal();
    }

    /**
     * @return Поле "Дата"
     */
    public InputDate getDateField() {
        return getModal().getForm().getInputDate("closingDate");
    }

    public Button getSaveButton() {
        return page.getButton(N2O_CONFIRM_BUTTON);
    }
}
