package businessFramework.module.dispensary.modal.agreement;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;

public class AgreementHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public AgreementHelper(ApplicationManager app) {
        super(app);
    }

    public Modal getAgreementModal(){
        return page.getModal();
    }

    /**
     *  Получение поля "Дата"
     * @return поле "Дата"
     */
    public InputDate getAgreementDate() {
        return getAgreementModal().getForm().getInputDate("date");
    }

    /**
     *  Получение кнопки потдвердить
     * @return кнопка Подтвердить
     */
    public Button getConfirmButton() {
        return getAgreementModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
