package businessFramework.module.pharmacy.modals.TransferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ngerasimov on 25.11.2015.
 */
public class AcceptTransferActHelper extends Page implements Values{
    
    //Модальное окно - "Прием документа:..."

    private Page page = Page.getInstance();

    public AcceptTransferActHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getAcceptTransferActModal(){
        return page.getModal();
    }

    /**
     * @return кнопку "Принять"
     */
    public Button getAcceptButton(){
        return getAcceptTransferActModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
