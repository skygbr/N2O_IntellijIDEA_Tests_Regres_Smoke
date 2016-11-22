package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class SpecWriteOffDocHelper extends Page implements Values
{

    /* Модальное окно Спецификация акта списания */

    private Page page = Page.getInstance();

    public SpecWriteOffDocHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getSpecForWriteOffDoc_Modal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /** ------------------------ Поля в модальном окне --------------------------- */
    /**
     * @return поле "Наименование ЛС и ИМН "
     */
    public Classifier getNameLS_IMN_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getClassifier("modif");
    }

    /**
     * @return поле "Производитель"
     */
    public Classifier getCreator_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getClassifier("producer");
    }

    /**
     * @return поле "Серия"
     */
    public InputText getSeries_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputText("series");
    }

    /**
     * @return поле "Срок годности"
     */
    public InputDate getDate_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputDate("expireDt");
    }

    /**
     * @return поле "Цена с НДС (руб.)"
     */
    public InputText getPriceWithNDS_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputText("priceWithVat");
    }

    /**
     * @return поле "Ценовая ед. изм."
     */
    public Select getPriceUnit_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getSelect("priceUnitFlag");
    }

    /**
     * @return поле "Сумма с НДС (руб.)"
     */
    public InputText getSumWithNDS_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputText("amountWithVat");
    }

    /**
     * @return поле "Источник финансирования"
     */
    public Classifier getFinancingSource_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getClassifier("fundSource");
    }

    /**
     * @return поле "Примечание"
     */
    public TextArea getComment_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getTextArea("note");
    }

    /**
     * @return поле "Количество"
     */
    public InputText getCount_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputText("quantity");
    }

    /**
     * @return поле "Количество в МНЕИ"
     */
    public InputText getMNEICount_specModal_f()
    {
        return getSpecForWriteOffDoc_Modal().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле "Остаток"
     */
    public InputText getRestQuantity(){return  getSpecForWriteOffDoc_Modal().getForm().getInputText("restQuantity");}

    /**
     * @return поле "Остаток в МНЕИ"
     */
    public InputText getRestMneiQuantity(){return  getSpecForWriteOffDoc_Modal().getForm().getInputText("restMneiQuantity");}
    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveSpecModalButton()
    {
        return getSpecForWriteOffDoc_Modal().getButton(N2O_CONFIRM_BUTTON);
    }
}
