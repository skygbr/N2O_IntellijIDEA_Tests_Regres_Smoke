package businessFramework.module.pharmacy.modals.TransferAct;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by ngerasimov on 25.11.2015.
 */
public class AcceptDocumentModal extends AcceptTransferActHelper {
    public AcceptDocumentModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader){
        getAcceptTransferActModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Нажимает кнопку "Принять"
     */
    public void clickAcceptButton(){
        getAcceptButton().click();
    }
}
