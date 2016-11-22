package businessFramework.module.pharmacy.modals.ArrivalInvoiceSpecification;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.holdingProducer.HoldingProducerModal;
import net.framework.autotesting.ApplicationManager;

public class ArrivalInvoiceSpecificationModal extends ArrivalInvoiceSpecificationModalHelper implements Values
{
    public ArrivalInvoiceSpecificationModal(ApplicationManager app)
    {
        super(app);
    }

    /* ------------------ Модальное окно "Спецификация" --------------------- */

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getArrivalInvoiceSpecificationModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Заполняет те поля, значения для которых указаны в @param.
     *
     * @param nDS                   значение поля НДС
     * @param margin                значение поля Торг. нац
     * @param contractModification  значение поля Спецификация контракта
     * @param modification          значение поля Наименование ЛС и ИМН
     * @param producer              значение поля Производитель
     * @param country               значение поля Страна
     * @param series                значение поля Серия партии
     * @param expireDate            значение поля Срок годности
     * @param productionDate        значение поля Дата производства
     * @param certificate           значение поля Сертификат
     * @param quantity              значение поля Кол-во
     * @param amountWithNDS         значение поля Сумма с НДС, руб.
     */
    public void fillFields(String nDS, String margin,String contractModification, String modification, String producer, String country,
                           String series, String expireDate, String productionDate, String certificate, String quantity,
                           String amountWithNDS)
    {

        if (nDS != null)                    { getNDS().setValue(nDS); }
        if (margin != null)                 { getMargin().setValue(margin); }
        if (contractModification != null)   { getContractModification().setValue(contractModification); }
        if (modification != null)           { getModification().setValue(modification); }
        if (producer != null)               { getProducer().setValue(producer); }
        if (country != null)                { getСountry().setValue(country); }
        if (series != null)                 { getSeries().setValue(series); }
        if (expireDate != null)             { getExpireDate().setValue(expireDate); }
        if (productionDate != null)         { getProductionDate().setValue(productionDate); }
        if (certificate != null)            { getCertificate().setValue(certificate); }
        if (quantity != null)               { getQuantity().setValue(quantity); }
        if (amountWithNDS != null)          { getAmountWithNDS().setValue(amountWithNDS); }
    }

    /**
     * Проверяет значения в тех полях, значения для которых указаны в @param.
     *
     * @param nDS                   значение поля НДС
     * @param margin                значение поля Торг. нац
     * @param contractModification  значение поля Спецификация контракта
     * @param modification          значение поля Наименование ЛС и ИМН
     * @param producer              значение поля Производитель
     * @param country               значение поля Страна
     * @param series                значение поля Серия партии
     * @param expireDate            значение поля Срок годности
     * @param productionDate        значение поля Дата производства
     * @param certificate           значение поля Сертификат
     * @param quantity              значение поля Кол-во
     * @param mneiQuantity          значение поля Кол-во в МНЕИ:
     * @param amountWithNDS         значение поля Сумма с НДС, руб.
     * @param amount                значение поля Сумма без НДС, руб.
     * @param amountWithMargin      значение поля Сумма с наценкой, руб.
     * @param priceWithNDS          значение поля Цена с НДС, руб
     * @param price                 значение поля Цена без НДС, руб.
     * @param priceWithMargin       значение поля Цена с наценкой, руб.
     */
    public void checkFields(String nDS, String margin,String contractModification, String modification, String producer, String country,
                            String series, String expireDate, String productionDate, String certificate, String quantity, String mneiQuantity,
                            String amountWithNDS, String amount, String amountWithMargin,
                            String priceWithNDS, String price, String priceWithMargin, String contrSpecDeliveredQuantity, String contrSpecRestQuantity)
    {
        if (nDS != null)                    { getNDS().assertValue(nDS); }
        if (margin != null)                 { getMargin().assertValue(margin); }
        if (contractModification != null)   { getContractModification().assertValue_equals(contractModification); }
        if (modification != null)           { getModificationCheck().assertFieldText(modification); }
        if (producer != null)               { getProducer().assertValue_equals(producer); }
        if (country != null)                { getСountry().assertValue_equals(country); }
        if (series != null)                 { getSeries().assertValue(series); }
        if (expireDate != null)             { getExpireDate().assertThatDateContainsValue(expireDate); }
        if (productionDate != null)         { getProductionDate().assertThatDateContainsValue(productionDate); }
        if (certificate != null)            { getCertificate().assertValue(certificate); }
        if (quantity != null)               { getQuantity().assertValue(quantity); }
        if (mneiQuantity != null)           { getMneiQuantity().assertValue(mneiQuantity); }
        if (amountWithNDS != null)          { getAmountWithNDS().assertValue(amountWithNDS); }
        if (amount != null)                 { getAmount().assertValue(amount); }
        if (amountWithMargin != null)       { getAmountWithMargin().assertValue(amountWithMargin); }
        if (price != null)                  { getPrice().assertValue(price); }
        if (priceWithMargin != null)        { getPriceWithMargin().assertValue(priceWithMargin); }
        if (contrSpecDeliveredQuantity != null)   { getDeliveredQuantity().assertFieldText(contrSpecDeliveredQuantity); }
        if (contrSpecRestQuantity != null)        { getRestQuantity().assertFieldText(contrSpecRestQuantity); }
    }

    /**
     * Проверяет, что все поля на форме в модальном окне "Спецификация" недоступны для редактирования.
     */
    public void checkFieldsDisability()
    {
        getNDS().assertIsDisabled(true);
        getMargin().assertIsDisabled(true);
        getContractModification().assertThatComboboxIsDisabled();
        getProducer().assertThatComboboxIsDisabled();
        getСountry().assertThatComboboxIsDisabled();
        getSeries().assertIsDisabled(true);
        getExpireDate().assertIsDisabled(true);
        getProductionDate().assertIsDisabled(true);
        getCertificate().assertIsDisabled(true);
        getQuantity().assertIsDisabled(true);
        getMneiQuantity().assertIsDisabled(true);
        getAmountWithNDS().assertIsDisabled(true);
        getAmountWithMargin().assertIsDisabled(true);
        getAmount().assertIsDisabled(true);
        getPrice().assertIsDisabled(true);
        getPriceWithNDS().assertIsDisabled(true);
        getPriceWithMargin().assertIsDisabled(true);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveSpecificationButton()
    {
        getSaveButton().click();
    }

    /**
     * Получение модального окна "Производитель" в этом классе, тк это модальное окно открывается со страницы "Спецификация прих. накл.".
     */
    public HoldingProducerModal getHoldingProducerModel()
    {
        return new HoldingProducerModal("main");
    }
}