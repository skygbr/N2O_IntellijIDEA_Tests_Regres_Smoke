package businessFramework.module.pharmacy.pages.ArrivalInvoiceSpecifications;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ArrivalInvoiceSpecificationsHelper extends Page implements Values
{
    public ArrivalInvoiceSpecificationsHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getSpecificationCreationContainer()
    {
        return getContainer("main");
    }

    public Container getSpecificationsList()
    {
        return getContainer("list");
    }

    /* -----------------------------  Компоненты в верхнем контейнере ----------------------------- */

    /**
     * @return поле НДС
     */
    public InputText getNDS()
    {
        return getSpecificationCreationContainer().getForm().getInputText("vat");
    }

    /**
     * @return поле Торг. нац
     */
    public InputText getMargin()
    {
        return getSpecificationCreationContainer().getForm().getInputText("margin");
    }

    /**
     * @return поле Серия партии
     */
    public InputText getSeries()
    {
        return getSpecificationCreationContainer().getForm().getInputText("series");
    }

    /**
     * @return поле Сертификат
     */
    public InputText getCertificate()
    {
        return getSpecificationCreationContainer().getForm().getInputText("certificate");
    }

    /**
     * @return поле Кол-во
     */
    public InputText getQuantity()
    {
        return getSpecificationCreationContainer().getForm().getInputText("quantity");
    }

    /**
     * @return поле Сумма с НДС, руб
     */
    public InputText getAmountWithNDS()
    {
        return getSpecificationCreationContainer().getForm().getInputText("amountWithVat");
    }

    /**
     * @return поле Сумма без НДС, руб.
     */
    public InputText getAmount()
    {
        return getSpecificationCreationContainer().getForm().getInputText("amount");
    }

    /**
     * @return поле Сумма с наценкой, руб
     */
    public InputText getamountWithMargin()
    {
        return getSpecificationCreationContainer().getForm().getInputText("amountWithMargin");
    }

    /**
     * @return поле Кол-во в МНЕИ:
     */
    public InputText getMneiQuantity()
    {
        return getSpecificationCreationContainer().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле Цена с НДС, руб
     */
    public InputText getPriceWithVat()
    {
        return getSpecificationCreationContainer().getForm().getInputText("priceWithVat");
    }

    /**
     * @return поле Цена без НДС, руб.
     */
    public InputText getPrice()
    {
        return getSpecificationCreationContainer().getForm().getInputText("price");
    }

    /**
     * @return поле Цена с наценкой, руб.
     */
    public InputText getPriceWithMargin()
    {
        return getSpecificationCreationContainer().getForm().getInputText("priceWithMargin");
    }

    /**
     * @return поле Наименование ЛС и ИМН
     */
    public Classifier getModification()
    {
        return getSpecificationCreationContainer().getForm().getClassifier("modif");
    }

    /**
     * @return поле Спецификация контракта
     */
    public Classifier getContractModification()
    {
        return getSpecificationCreationContainer().getForm().getClassifier("contractSpec");
    }

    /**
     * @return поле Производитель
     */
    public Classifier getProducer()
    {
        return getSpecificationCreationContainer().getForm().getClassifier("producer");
    }

    /**
     * @return поле Страна
     */
    public Classifier getСountry()
    {
        return getSpecificationCreationContainer().getForm().getClassifier("country");
    }

    /**
     * @return поле Срок годности
     */
    public InputDate getExpireDate()
    {
        return getSpecificationCreationContainer().getForm().getInputDate("expireDate");
    }

    /**
     * @return поле Дата производства
     */
    public InputDate getProductionDate()
    {
        return getSpecificationCreationContainer().getForm().getInputDate("prodDate");
    }

    /**
     * @return кнопку сохранить
     */
    public Button getSaveButton()
    {
        return getSpecificationCreationContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    /* -----------------------------  Компоненты в нижнем контейнере ----------------------------- */

    /**
     * @return таблицу списка спецификаций
     */
    public Table getSpecificationsListTable()
    {
        return getSpecificationsList().getTable();
    }

    /**
     * @return поле Поставлено
     */
    public OutputText getDeliveredQuantity()
    {
        return getSpecificationCreationContainer().getForm().getOutputText("deliveredQuantity");
    }

    /**
     * @return поле Остаток
     */
    public OutputText getRestQuantity()
    {
        return getSpecificationCreationContainer().getForm().getOutputText("restQuantityStr");
    }
}