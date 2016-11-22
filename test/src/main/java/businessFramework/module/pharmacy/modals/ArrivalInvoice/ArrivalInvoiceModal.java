package businessFramework.module.pharmacy.modals.ArrivalInvoice;

import businessFramework.entities.pharmacy.ArrivalInvoiceData;
import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

public class ArrivalInvoiceModal extends ArrivalInvoiceModalHelper implements ArrivalInvoiceValues
{
    public ArrivalInvoiceModal(ApplicationManager app)
    {
        super(app);
    }

     /* ------------------ Модальное окно "Приходная накладная" --------------------- */

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getArrInvoiceModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Заполняет те поля на форме в модальном окне "Приходная накладная", значения для которых указаны в @param.
     *
     * @param extDocNumber      значение поля Префикс-номер Внешнего реквизита
     * @param intDocNumber      значение поля Префикс-номер Внутреннего реквизита
     * @param contractor        значение поля Поставщик
     * @param shipper           значение поля Грузоотправитель
     * @param recipient         значение поля Склад
     * @param fundSource        значение поля Финансирование
     * @param amountPlanned     значение поля Сумма плановая(руб.)
     * @param contract          значение поля Контракт/Договор
     * @param note              значение поля Примечание
     * @param procurementMethod значение поля Способ закупки
     */
    public void fillFields(String extDocNumber, String intDocNumber, String contractor, String shipper,
                           String recipient, String fundSource, String amountPlanned, String contract, String note, String procurementMethod)
    {
        if (extDocNumber != null)    { getExtDocumentNumber().setValue(extDocNumber); }
        if (intDocNumber != null)    { getIntDocumentNumber().setValue(intDocNumber); }
        if (contractor != null)      { getContractor().setValue(contractor); }
        if (note != null)            { getNote().setValue(note); }
        if (shipper != null)         { getShipper().setValue(shipper); }
        if (recipient != null)       { getRecipient().setValue(recipient); }
        if (fundSource != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(fundSource);
            getFundSource().chooseNodeWithOpenClose(fundingList, true);
        }
        if (amountPlanned != null)   { getAmountPlanned().setValue(amountPlanned); }
        if (contract != null)        { getContract().setValue(contract); }
        if (procurementMethod != null) { getProcurementMethod().setValue(procurementMethod); }
    }

    /**
     * Проверяет значения в тех полях, значения для которых указаны в @param.
     *
     * @param extDoсType        значение поля Тип документа Внешнего реквизита
     * @param extDocNumber      значение поля Префикс-номер Внешнего реквизита
     * @param extDocDate        значение поля Дата Внешнего реквизита
     * @param intDoсType        значение поля Тип документа Внутреннего реквизита
     * @param intDocNumber      значение поля Префикс-номер Внутреннего реквизита
     * @param intDocDate        значение поля Дата Внутреннего реквизита
     * @param contractor        значение поля Поставщик
     * @param shipper           значение поля Грузоотправитель
     * @param recipient         значение поля Склад
     * @param storeOperation    значение поля Складская операция
     * @param fundSource        значение поля Финансирование
     * @param amountPlanned     значение поля Сумма плановая(руб.)
     * @param amountFact        значение поля Сумма фактическая (руб.)
     * @param contract          значение поля Контракт/Договор
     * @param note              значение поля Примечание
     * @param procurementMethod значение поля Способ закупки
     */
    public void checkFields(String extDoсType, String extDocNumber, String extDocDate, String intDoсType,
                            String intDocNumber, String intDocDate, String contractor, String shipper,
                            String recipient, String storeOperation, String fundSource,
                            String amountPlanned, String amountFact, String contract, String note, String procurementMethod)
    {
        if (extDoсType != null)             { getExtDocumentType().assertValue_equals(extDoсType); }
        if (extDocNumber != null)           { getExtDocumentNumber().assertValue(extDocNumber); }
        if (extDocDate != null)             { getExtDocumentDate().assertThatDateContainsValue(extDocDate); }
        if (intDoсType != null)             { getIntDocumentType().assertValue_equals(intDoсType); }
        if (intDocNumber != null)           { getIntDocumentNumber().assertValue(intDocNumber); }
        if (intDocDate != null)             { getIntDocumentDate().assertThatDateContainsValue(intDocDate); }
        if (contractor != null)             { getContractor().assertValue_equals(contractor); }
        if (shipper != null)                { getShipper().assertValue_equals(shipper); }
        if (recipient != null)              { getRecipient().assertValue_equals(recipient); }
        if (storeOperation != null)         { getStoreOperation().assertValue_equals(storeOperation); }
        if (fundSource != null)             { getFundSource().assertValueIs(fundSource); }
        if (amountPlanned != null)          { getAmountPlanned().assertValue(amountPlanned); }
        if (amountFact != null)             { getAmountFact().assertValue(amountFact);}
        if (contract != null)               { getContract().assertValue_equals(contract);}
        if (note != null)                   { getNote().assertValue(note);}
        if (procurementMethod!=null)        { getProcurementMethod().assertValue_equals(procurementMethod);}
    }


    /**
     * Заполняет те поля на форме в модальном окне "Приходная накладная" без контракта/договора, значения для которых указаны в @param.
     *
     * @param extDocNumber      значение поля Префикс-номер Внешнего реквизита
     * @param intDocNumber      значение поля Префикс-номер Внутреннего реквизита
     * @param contractor        значение поля Поставщик
     * @param shipper           значение поля Грузоотправитель
     * @param recipient         значение поля Склад
     * @param fundSource        значение поля Финансирование
     * @param amountPlanned     значение поля Сумма плановая(руб.)
     * @param note              значение поля Примечание
     * @param procurementMethod значение поля Способ закупки
     */
    public void fillNoContractFields(String extDocNumber, String intDocNumber, String contractor, String shipper,
                           String recipient, String fundSource, String amountPlanned, String note, String procurementMethod)
    {
        if (extDocNumber != null)    { getExtDocumentNumber().setValue(extDocNumber); }
        if (intDocNumber != null)    { getIntDocumentNumber().setValue(intDocNumber); }
        if (contractor != null)      { getContractor().setValue(contractor); }
        if (note != null)            { getNote().setValue(note); }
        if (shipper != null)         { getShipper().setValue(shipper); }
        if (recipient != null)       { getRecipient().setValue(recipient); }
        if (fundSource != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(fundSource);
            getFundSource().chooseNodeWithOpenClose(fundingList, true);
        }
        if (amountPlanned != null)   { getAmountPlanned().setValue(amountPlanned); }
        if (procurementMethod != null) { getProcurementMethod().setValue(procurementMethod); }
    }

    /**
     * Проверяет значения в тех полях, значения для которых указаны в @param.
     *
     * @param extDoсType        значение поля Тип документа Внешнего реквизита
     * @param extDocNumber      значение поля Префикс-номер Внешнего реквизита
     * @param extDocDate        значение поля Дата Внешнего реквизита
     * @param intDoсType        значение поля Тип документа Внутреннего реквизита
     * @param intDocNumber      значение поля Префикс-номер Внутреннего реквизита
     * @param intDocDate        значение поля Дата Внутреннего реквизита
     * @param contractor        значение поля Поставщик
     * @param shipper           значение поля Грузоотправитель
     * @param recipient         значение поля Склад
     * @param storeOperation    значение поля Складская операция
     * @param fundSource        значение поля Финансирование
     * @param amountPlanned     значение поля Сумма плановая(руб.)
     * @param amountFact        значение поля Сумма фактическая (руб.)
     * @param note              значение поля Примечание
     * @param procurementMethod значение поля Способ закупки
     */
    public void checkNoContractFields(String extDoсType, String extDocNumber, String extDocDate, String intDoсType,
                            String intDocNumber, String intDocDate, String contractor, String shipper,
                            String recipient, String storeOperation, String fundSource,
                            String amountPlanned, String amountFact, String note, String procurementMethod)
    {
        if (extDoсType != null)             { getExtDocumentType().assertValue_equals(extDoсType); }
        if (extDocNumber != null)           { getExtDocumentNumber().assertValue(extDocNumber); }
        if (extDocDate != null)             { getExtDocumentDate().assertThatDateContainsValue(extDocDate); }
        if (intDoсType != null)             { getIntDocumentType().assertValue_equals(intDoсType); }
        if (intDocNumber != null)           { getIntDocumentNumber().assertValue(intDocNumber); }
        if (intDocDate != null)             { getIntDocumentDate().assertThatDateContainsValue(intDocDate); }
        if (contractor != null)             { getContractor().assertValue_equals(contractor); }
        if (shipper != null)                { getShipper().assertValue_equals(shipper); }
        if (recipient != null)              { getRecipient().assertValue_equals(recipient); }
        if (storeOperation != null)         { getStoreOperation().assertValue_equals(storeOperation); }
        if (fundSource != null)             { getFundSource().assertValueIs(fundSource); }
        if (amountPlanned != null)          { getAmountPlanned().assertValue(amountPlanned); }
        if (amountFact != null)             { getAmountFact().assertValue(amountFact);}
        if (note != null)                   { getNote().assertValue(note);}
        if (procurementMethod!=null)        { getProcurementMethod().assertValue_equals(procurementMethod);}
    }


    /**
     * Проверяет заполениее полей копируемой записи на форме копирования
     *
     * @param copiedData        данные копируемой записи
     */
    public void assertCopiedFields(ArrivalInvoiceData copiedData)
    {
        getExtDocumentType().assertValue_equals(copiedData.getInvoiceExtDoсType());
        getIntDocumentType().assertValue_equals(copiedData.getInvoiceIntDoсType());
        getExtDocumentDate().assertValue_equals(copiedData.getInvoiceExtDocDate());
        getIntDocumentDate().assertValue_equals(copiedData.getInvoiceIntDocDate());
        getAmountPlanned().assertValue("");
        getAmountFact().assertValue("0");
        getContractor().assertValue_equals(copiedData.getInvoiceContractor());
        getRecipient().assertValue_equals(copiedData.getInvoiceRecipient());
        getStoreOperation().assertValue_equals(copiedData.getInvoiceStoreOperation());
        getFundSources().assertValue_equals(copiedData.getInvoiceFundSource());
    }


    /**
     * Проверяет заполениее полей копируемой записи на форме копирования
     *
     * @param copiedData        данные копируемой записи
     */
    public void assertNoContractCopiedFields(ArrivalInvoiceData copiedData)
    {
        getExtDocumentType().assertValue_equals(copiedData.getInvoiceExtDoсType());
        getIntDocumentType().assertValue_equals(copiedData.getInvoiceIntDoсType());
        getExtDocumentDate().assertValue_equals(copiedData.getInvoiceExtDocDate());
        getIntDocumentDate().assertValue_equals(copiedData.getInvoiceIntDocDate());
        getAmountPlanned().assertValue("");
        getAmountFact().assertValue("0");
        getContractor().assertValue_equals(copiedData.getInvoiceNoContractor());
        getRecipient().assertValue_equals(copiedData.getInvoiceRecipient());
        getStoreOperation().assertValue_equals(copiedData.getInvoiceStoreOperation());
        getFundSources().assertValue_equals(copiedData.getInvoiceFundSource());
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveArrInvoiceButton()
    {
        getSaveArrInvoiceButton().click();

    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getArrInvoiceModal().closeModal();
    }

    /**
     * Проверяет, что все поля на форме в модальном окне "Приходная накладная" недоступны для редактирования.
     */
    public void checkFieldsDisability()
    {
        getExtDocumentType().assertThatComboboxIsDisabled();
        getExtDocumentNumber().assertIsDisabled(true);
        getExtDocumentDate().assertIsDisabled(true);
        getIntDocumentType().assertThatComboboxIsDisabled();
        getIntDocumentNumber().assertIsDisabled(true);
        getIntDocumentDate().assertIsDisabled(true);
        getContractor().assertThatComboboxIsDisabled();
        getShipper().assertThatComboboxIsDisabled();
        getRecipient().assertThatComboboxIsDisabled();
        getStoreOperation().assertThatComboboxIsDisabled();
        getAmountPlanned().assertIsDisabled(true);
        getAmountFact().assertIsDisabled(true);
        getContract().assertThatComboboxIsDisabled();
        getNote().assertThatTextareaFieldIsDisabled(true);
    }
}