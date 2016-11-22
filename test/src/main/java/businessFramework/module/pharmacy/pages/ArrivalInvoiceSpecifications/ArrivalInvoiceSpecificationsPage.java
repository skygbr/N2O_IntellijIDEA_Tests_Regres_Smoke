package businessFramework.module.pharmacy.pages.ArrivalInvoiceSpecifications;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.holdingProducer.HoldingProducerModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

public class ArrivalInvoiceSpecificationsPage extends ArrivalInvoiceSpecificationsHelper implements Values
{
    public ArrivalInvoiceSpecificationsPage(ApplicationManager app)
    {
        super(app);
    }

    /* ------------------------------ Нажатие кнопок на странице "Добавление спецификации" ----------------------------------*/

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveSpecificationButton()
    {
        getSaveButton().click();
    }

    /* ------------------- Верхний контейнер ------------------------------------*/

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
                           String series, String expireDate, String productionDate, String certificate, String quantity, String amountWithNDS)
    {
        if (contractModification != null)   { getContractModification().setValue(contractModification); }
        if (modification != null)           { getModification().setValue(modification); }
        if (nDS != null)                    { getNDS().setValue(nDS); }
        if (margin != null)                 { getMargin().setValue(margin); }
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
                            String amountWithNDS, String amount, String amountWithMargin, String priceWithNDS, String price, String priceWithMargin,
                            String contrSpecDeliveredQuantity, String contrSpecRestQuantity)
    {
        if (nDS != null)                    { getNDS().assertValue(nDS); }
        if (margin != null)                 { getMargin().assertValue(margin); }
        if (contractModification != null)   { getContractModification().assertValue_equals(contractModification); }
        if (modification != null)           { getModification().assertValue_equals(modification); }
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
        if (amountWithMargin != null)       { getamountWithMargin().assertValue(amountWithMargin); }
        if (priceWithNDS != null)           { getPriceWithVat().assertValue(priceWithNDS); }
        if (price != null)                  { getPrice().assertValue(price); }
        if (priceWithMargin != null)        { getPriceWithMargin().assertValue(priceWithMargin); }
        if (contrSpecDeliveredQuantity != null)   { getDeliveredQuantity().assertFieldText(contrSpecDeliveredQuantity); }
        if (contrSpecRestQuantity != null)        { getRestQuantity().assertFieldText(contrSpecRestQuantity); }
    }

    /* ------------------- Нижний контейнер ------------------------------------*/

    /**
     * Проверяет значение в тех столбцах таблицы, значения для которых указаны в @param
     *
     * @param modification      Наименование ЛС и ИМН
     * @param producer          Производитель
     * @param series            Серия партии
     * @param expireDate        Срок годности
     * @param quantity          Количество
     * @param measure           Ед.изм.
     * @param price             Цена
     * @param contractPrice     Цена контракта
     * @param amount            Сумма
     *
     * @return номер строки в таблице, которая подходит под данные
     */
    public int checkTableValues(String modification, String producer, String series, String expireDate,
                                String quantity, String measure, String price, String contractPrice, String amount)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (modification != null)   { columnsAndValues.put("Наименование ЛС и ИМН", modification);}
        if (producer != null)       { columnsAndValues.put("Производитель", producer);}
        if (series != null)         { columnsAndValues.put("Серия партии", series);}
        if (expireDate != null )    { columnsAndValues.put("Срок годности", expireDate);}
        if (quantity !=null)        { columnsAndValues.put("Количество", quantity);}
        if (measure != null)        { columnsAndValues.put("Ед.изм.", measure);}
        if (price != null)          { columnsAndValues.put("Цена", price);}
        if (contractPrice != null)  { columnsAndValues.put("Цена контракта", contractPrice);}
        if (amount != null)         { columnsAndValues.put("Сумма", amount);}

        return getSpecificationsListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);

    }

    /**
     * Получение модального окна "Производитель" в этом классе, тк это модальное окно открывается со страницы "Спецификация прих. накл.".
     */
    public HoldingProducerModal getHoldingProducerModel()
    {
        return new HoldingProducerModal("main");
    }
}