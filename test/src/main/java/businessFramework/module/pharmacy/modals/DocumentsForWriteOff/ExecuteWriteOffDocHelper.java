package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ExecuteWriteOffDocHelper extends Page implements Values
{

    /** Модальное окно "Проводка документа */

    private Page page = Page.getInstance();

    public ExecuteWriteOffDocHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getExecuteWriteOffDocModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * @return кнопку "Провести"
     */
    public Button getApplyButton()
    {
        return getExecuteWriteOffDocModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
