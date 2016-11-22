package businessFramework.module.pharmacy.modals.Specification;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class SpecificationHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public SpecificationHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getSpecificationModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * @return Поле "Наименование ЛС и ИМН"
     */
    public Classifier getNameLS_IMN_Field()
    {
        return getSpecificationModal().getForm().getClassifier("modif");
    }

    /**
     * @return Поле "Серия партии"
     */
    public InputText getSeriesField()
    {
        return getSpecificationModal().getForm().getInputText("series");
    }

    /**
     * @return Поле "Дата производства"
     */
    public InputDate getProductionDateField()
    {
        return getSpecificationModal().getForm().getInputDate("prodDate");
    }

    /**
     * @return Поле "Производитель"
     */
    public Classifier getProducerField()
    {
        return getSpecificationModal().getForm().getClassifier("producer");
    }

    /**
     * @return Поле "Страна"
     */
    public Classifier getCountryField()
    {
        return getSpecificationModal().getForm().getClassifier("country");
    }

    /**
     * @return Поле "Срок годности"
     */
    public InputDate getExpiringDateField()
    {
        return getSpecificationModal().getForm().getInputDate("expireDate");
    }

    /**
     * @return Поле "Сертификат"
     */
    public InputText getCertificateField()
    {
        return getSpecificationModal().getForm().getInputText("certificate");
    }

    /**
     * @return Поле "Кол-во"
     */
    public InputText getQuantityField()
    {
        return getSpecificationModal().getForm().getInputText("quantity");
    }

    /**
     * @return Поле "Сумма (руб.)"
     */
    public InputText getAmountField()
    {
        return getSpecificationModal().getForm().getInputText("amount");
    }

    /**
     * @return Поле "Кол-во в МНЕИ"
     */
    public InputText getMNEIQuantityField()
    {
        return getSpecificationModal().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return Поле "Цена (руб.)"
     */
    public InputText getPriceField()
    {
        return getSpecificationModal().getForm().getInputText("price");
    }

    /**
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton()
    {
        return getSpecificationModal().getButton(N2O_CONFIRM_BUTTON);
    }


}
