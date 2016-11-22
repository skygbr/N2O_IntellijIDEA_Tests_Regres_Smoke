package businessFramework.module.pharmacy.modals.ProductionDocument;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * @author ydolgih
 * @since 13.11.2015
 */
public class ProdSpecHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public ProdSpecHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     *
     * @return Это модальное окно
     */
    public Modal getProdSpecModal() {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получает контейнер в модальном окне добавления спецификации.
     *
     * @return контейнер в модальном окне добавления спецификации.
     */
    public Container getMainContainer() {
        return getContainer("main");
    }

    /** ----------------------------- Поля на форме модального окна добавления спецификации ---------------------------------- */

    /**
     * @return поле "Наименование ЛС и ИМН"
     */
    public Classifier getSpecModif() {
        return getMainContainer().getForm().getClassifier("modif");
    }

    /**
     * @return поле "Производитель"
     */
    public Classifier getProducer() {
        return getMainContainer().getForm().getClassifier("producer");
    }

    /**
     * @return поле "Серия"
     */
    public InputText getSeries() {
        return getMainContainer().getForm().getInputText("series");
    }

    /**
     * @return поле "Факт остаток"
     */
    public OutputText getActualBalanceArr() {
        return getMainContainer().getForm().getOutputText("actualBalanceArr");
    }


    /**
     * @return поле "Факт остаток МНЕИ"
     */
    public OutputText getActualBalanceMnei() {
        return getMainContainer().getForm().getOutputText("actualBalanceMnei");
    }


    /**
     * @return поле "Срок годности"
     */
    public InputDate getExpireDate() {
        return getMainContainer().getForm().getInputDate("expireDt");
    }

    /**
     * @return поле "Источник финансирования"
     */
    public Classifier getFundSource() {
        return getMainContainer().getForm().getClassifier("fundSource");
    }

    /**
     * @return поле "Количество"
     */
    public InputText getQuantity() {
        return getMainContainer().getForm().getInputText("quantity");
    }

    /**
     * @return поле "Количество в МНЕИ"
     */
    public InputText getMneiQuantity() {
        return getMainContainer().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле "Цена с НДС (руб.)"
     */
    public Select getPriceUnit() {
        return getMainContainer().getForm().getSelect("priceUnitFlag");
    }

    /**
     * @return поле "Цена с НДС (руб.)"
     */
    public InputText getPrice() {
        return getMainContainer().getForm().getInputText("priceWithVat");
    }


    /**
     * @return поле "Сумма с НДС (руб.)"
     */
    public InputText getAmount() {
        return getMainContainer().getForm().getInputText("amountWithVat");
    }



    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton_spec()
    {
        return getMainContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}
