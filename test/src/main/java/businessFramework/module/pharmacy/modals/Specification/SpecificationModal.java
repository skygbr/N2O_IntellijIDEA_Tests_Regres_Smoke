package businessFramework.module.pharmacy.modals.Specification;


import net.framework.autotesting.ApplicationManager;

public class SpecificationModal extends SpecificationHelper
{
    public SpecificationModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка заголовка модального окна
     */
    public void checkModalHeader(String contractNumber, Boolean isCreateModal)
    {
        if (isCreateModal) { getSpecificationModal().assertModalHeader_equal(String.format("Контракт №%s от %s. Добавление спецификации.", contractNumber, getCurrentDate())); }
        else { getSpecificationModal().assertModalHeader_equal("Спецификация"); }
    }

    /**
     * Устанавливает значения в поля на форме в модальном окне "Контракт №%s от %s. Добавление спецификации."
     *
     * @param nameLS_IMN значение для поля "Наименование ЛС и ИМН"
     * @param series значение для поля "Серия партии"
     * @param productionDate значение для поля "Дата производства"
     * @param producer значение для поля "Производитель"
     * @param country значение для поля "Страна"
     * @param expiringDate значение для поля "Срок годности"
     * @param certificate значение для поля "Сертификат"
     * @param quantity значение для поля "Кол-во"
     * @param amount значение для поля "Сумма (руб.)"
     */
    public void setValuesToFields(String nameLS_IMN, String series, String productionDate, String producer, String country, String expiringDate, String certificate, String quantity, String amount)
    {
        if(nameLS_IMN != null)      { getNameLS_IMN_Field().setValue(nameLS_IMN); }
        if(series != null)          { getSeriesField().setValue(series); }
        if(productionDate != null)  { getProductionDateField().setValue(productionDate); }
        if(producer != null)        { getProducerField().setValue(producer); }
        if(country != null)         { getCountryField().setValue(country); }
        if(expiringDate != null)    { getExpiringDateField().setValue(expiringDate); }
        if(certificate != null)     { getCertificateField().setValue(certificate); }
        if(quantity != null)        { getQuantityField().setValue(quantity); }
        if(amount != null)          { getAmountField().setValue(amount); }
    }

    /**
     * Проверяет значение полей в модальном окне "Контракт №%s от %s. Добавление спецификации."
     *
     * @param nameLS_IMN Значение для поля "Наименование ЛС и ИМН"
     * @param series Значение для поля "Серия партии"
     * @param productionDate Значение для поля "Дата производства"
     * @param producer Значение для поля "Производитель"
     * @param country Значение для поля "Страна"
     * @param expiringDate Значение для поля "Срок годности"
     * @param certificate Значение для поля "Сертификат"
     * @param quantity Значение для поля "Кол-во"
     * @param amount Значение для поля "Сумма (руб.)"
     * @param mneiQuantity Значение для поля "Кол-во в МНЕИ"
     * @param price Значение для поля "Цена (руб.)"
     */
    public void checkFieldsValues(String nameLS_IMN, String series, String productionDate, String producer, String country, String expiringDate, String certificate, String quantity, String amount, String mneiQuantity, String price)
    {
        if (nameLS_IMN != null)     { getNameLS_IMN_Field().assertValue_equals(nameLS_IMN); }
        if (series != null)         { getSeriesField().assertValue(series); }
        if (productionDate != null) { getProductionDateField().assertValue(getProductionDateField().getValue(), productionDate); }
        if (producer != null)       { getProducerField().assertValue_equals(producer); }
        if (country != null)        { getCountryField().assertValue_equals(country); }
        if (expiringDate != null)   { getExpiringDateField().assertValue(getExpiringDateField().getValue(), expiringDate); }
        if (certificate != null)    { getCertificateField().assertValue(certificate); }
        if (quantity != null)       { getQuantityField().assertValue(quantity); }
        if (amount != null)         { getAmountField().assertValue(amount); }
        if (mneiQuantity != null)   { getMNEIQuantityField().assertValue(mneiQuantity); }
        if (price != null)          { getPriceField().assertValue(price); }
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void pressSaveButton()
    {
        getSaveButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getSpecificationModal().closeModal();
    }

}
