package businessFramework.module.pharmacy.modals.ArrivalInvoiceSpecification;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;

public class ArrivalInvoiceSpecificationModalHelper extends Page implements Values
{
    public ArrivalInvoiceSpecificationModalHelper(ApplicationManager app)
    {
        super(app);
    }

    private Page page = Page.getInstance();

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getArrivalInvoiceSpecificationModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* -----------------------------  Компоненты в модальном окне ----------------------------- */

    /**
     * @return поле НДС
     */
    public InputText getNDS()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("vat");
    }

    /**
     * @return поле Торг. нац
     */
    public InputText getMargin()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("margin");
    }

    /**
     * @return поле Серия партии
     */
    public InputText getSeries()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("series");
    }

    /**
     * @return поле Сертификат
     */
    public InputText getCertificate()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("certificate");
    }

    /**
     * @return поле Кол-во
     */
    public InputText getQuantity()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("quantity");
    }

    /**
     * @return поле Сумма с НДС, руб
     */
    public InputText getAmountWithNDS()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("amountWithVat");
    }

    /**
     * @return поле Сумма без НДС, руб.
     */
    public InputText getAmount()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("amount");
    }

    /**
     * @return поле Сумма с наценкой, руб
     */
    public InputText getAmountWithMargin()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("amountWithMargin");
    }

    /**
     * @return поле Кол-во в МНЕИ:
     */
    public InputText getMneiQuantity()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("mneiQuantity");
    }

    /**
     * @return поле Цена с НДС, руб
     */
    public InputText getPriceWithNDS()
    {
        return new InputText(app, findElement(By.cssSelector("div:not(.n2o_hidden)[data-field-id='priceWithVat']")), "priceWithVat");
    }

    /**
     * @return поле Цена без НДС, руб.
     */
    public InputText getPrice()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("price");
    }

    /**
     * @return поле Цена с наценкой, руб.
     */
    public InputText getPriceWithMargin()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputText("priceWithMargin");
    }

    /**
     * @return поле проверка по контракту Наименование ЛС и ИМН
     */
    public OutputText getModificationCheck()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getOutputText("modif.name");
    }

    /**
     * @return поле Наименование ЛС и ИМН
     */
    public Classifier getModification()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getClassifier("modif");
    }

    /**
     * @return поле Спецификация контракта
     */
    public Classifier getContractModification()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getClassifier("contractSpec", false);
    }

    /**
     * @return поле Производитель
     */
    public Classifier getProducer()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getClassifier("producer");
    }

    /**
     * @return поле Страна
     */
    public Classifier getСountry()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getClassifier("country");
    }

    /**
     * @return поле Срок годности
     */
    public InputDate getExpireDate()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputDate("expireDate");
    }

    /**
     * @return поле Дата производства
     */
    public InputDate getProductionDate()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getInputDate("prodDate");
    }

    /**
     * @return поле Поставлено
     */
    public OutputText getDeliveredQuantity()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getOutputText("deliveredQuantity");
    }

    /**
     * @return поле Остаток
     */
    public OutputText getRestQuantity()
    {
        return getArrivalInvoiceSpecificationModal().getForm().getOutputText("restQuantityStr");
    }

    /**
     * @return кнопку сохранить
     */
    public Button getSaveButton()
    {
        return getArrivalInvoiceSpecificationModal().getButton(N2O_CONFIRM_BUTTON);
    }
}