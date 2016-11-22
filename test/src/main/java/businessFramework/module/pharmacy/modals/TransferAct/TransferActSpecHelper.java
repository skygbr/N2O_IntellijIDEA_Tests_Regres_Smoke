package businessFramework.module.pharmacy.modals.TransferAct;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActSpecHelper  extends Page implements Values
{
    private Page page = Page.getInstance();

    public TransferActSpecHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getTransferActSpecModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получает контейнер в модальном окне добавления спецификации.
     * @return контейнер в модальном окне добавления спецификации.
     */
    public Container getMainContainer()
    {
        return getContainer("main");
    }

    /** ----------------------------- Поля на форме модального окна добавления спецификации ---------------------------------- */

    /**
     * @return поле "Наименование ЛС и ИМН"
     */
    public Classifier getNameLS_IMN_spec_f()
    {
        return getMainContainer().getForm().getClassifier("modif");
    }

    /**
     * @return поле "Производитель"
     */
    public Classifier getCreator_spec_f()
    {
        return getMainContainer().getForm().getClassifier("producer");
    }

    /**
     * @return поле "Источник финансирования"
     */
    public Classifier getFinancingSource_spec_f()
    {
        return getMainContainer().getForm().getClassifier("fundSource");
    }

    /**
     * @return поле "Количество"
     */
    public InputText getCount_spec_f()
    {
        return getMainContainer().getForm().getInputText("quantity");
    }

    /**
     * @return поле "Количество в МНЕИ"
     */
    public InputText getMNEICount_spec_f()
    {
        return getMainContainer().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле "Цена с НДС (руб.)"
     */
    public InputText getPrice_spec_f()
    {
        return getMainContainer().getForm().getInputText("priceWithVat");
    }

    /**
     * @return поле "Сумма с НДС (руб.)"
     */
    public InputText getSum_spec_f()
    {
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

