package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;


import net.framework.autotesting.ApplicationManager;

public class ExecuteWriteOffDocModal extends ExecuteWriteOffDocHelper
{

    /** Модальное окно "Проводка документа */

    public ExecuteWriteOffDocModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getExecuteWriteOffDocModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Нажимает кнопку "Провести"
     */
    public void clickApplyButton()
    {
        getApplyButton().click();
    }
}
