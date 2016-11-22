package businessFramework.module.pharmacy.modals.TransferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class ExecuteTransferActHelper extends Page implements Values
{
    // Модальное окно - "Проводка документа: ..."

    private Page page = Page.getInstance();

    public ExecuteTransferActHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getExecuteTransferActModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * @return кнопку "Провести"
     */
    public Button getApplyButton()
    {
        return getExecuteTransferActModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
