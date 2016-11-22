package businessFramework.module.pharmacy.modals.ExpenseInvoice;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class ExecuteDocumentModal extends ExecuteExpInvoiceHelper implements Values
{
    public ExecuteDocumentModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getExecuteExpInvoiceModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Нажимает кнопку "Провести"
     */
    public void clickApplyButton()
    {
        getApplyButton().click();
    }
}