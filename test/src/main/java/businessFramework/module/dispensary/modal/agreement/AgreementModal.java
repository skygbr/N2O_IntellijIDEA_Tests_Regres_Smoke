package businessFramework.module.dispensary.modal.agreement;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

public class AgreementModal extends AgreementHelper {

    private Page page = Page.getInstance();
    public AgreementModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Заполнение поля "Дата"
     */
    public void fillDateField() {
        getAgreementDate().setValue(page.getCurrentDate());
        getConfirmButton().click();
        getDialog().clickYes();
    }
}
