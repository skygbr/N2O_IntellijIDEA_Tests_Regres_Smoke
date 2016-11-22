package businessFramework.module.pharmacy.modals.RequestSpecification;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class RequestSpecificationHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public RequestSpecificationHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getSelectedSpecificationModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * @return Поле "Наименование ЛС и ИМН"
     */
    public Classifier getModificationField() {
        return getSelectedSpecificationModal().getForm().getClassifier("modif");
    }

    /**
     * @return Поле "Финансирование"
     */
    public Classifier getFundingSourceField() {
        return getSelectedSpecificationModal().getForm().getClassifier("fundSource");
    }

    /**
     * @return Поле "Кол-во"
     */
    public InputText getQuantityField() {
        return getSelectedSpecificationModal().getForm().getInputText("quantity");
    }

    /**
     * @return Поле "Кол-во в МНЕИ"
     */
    public InputText getQuantityInMneiField() {
        return getSelectedSpecificationModal().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton()
    {
        return getSelectedSpecificationModal().getButton(N2O_CONFIRM_BUTTON);
    }
}