package businessFramework.module.pharmacy.modals.TransferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class ExecuteDocumentModal extends ExecuteTransferActHelper implements Values {
    public ExecuteDocumentModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getExecuteTransferActModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Нажимает кнопку "Провести"
     */
    public void clickApplyButton()
    {
        getApplyButton().click();
    }
}