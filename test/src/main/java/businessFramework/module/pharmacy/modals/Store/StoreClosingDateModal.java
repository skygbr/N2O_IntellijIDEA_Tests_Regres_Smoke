package businessFramework.module.pharmacy.modals.Store;


import net.framework.autotesting.ApplicationManager;

/**
 * @author ydolgih
 * @since 03.07.2015
 */
public class StoreClosingDateModal extends StoreClosingDateModalHelper {

    public StoreClosingDateModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void pressSaveButton() {
        getSaveButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal() {
        getModal().closeModal();
    }

    public void fillClosingDate(String closingDate) {
        if (closingDate != null) getDateField().setValue(closingDate);
    }
}