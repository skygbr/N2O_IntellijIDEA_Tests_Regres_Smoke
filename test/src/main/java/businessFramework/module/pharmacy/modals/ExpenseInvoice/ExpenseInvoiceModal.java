package businessFramework.module.pharmacy.modals.ExpenseInvoice;


import businessFramework.module.pharmacy.modals.TrustDocument.TrustDocModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.util.ArrayList;
import java.util.List;

public class ExpenseInvoiceModal extends ExpenseInvoiceModalHelper implements ExpInvoiceValues
{
    public ExpenseInvoiceModal(ApplicationManager app)
    {
        super(app);
    }

     /* ------------------ Модальное окно "Расходная накладная" --------------------- */

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getExpInvoiceModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Заполняет те поля на форме в модальном окне "Расходная накладная", значения для которых указаны в @param.
     *
     * @param numberValue               Значение поля "Номер"
     * @param senderValue               Значение поля "Отправитель"
     * @param recipientValue            Значение поля "Получатель"
     * @param financingSourceTypeValue  Значение поля "Источник финансирования"
     * @param productGroupValue         Значение поля "Товарная группа"
     * @param recipientMOLValue         Значение поля "МОЛ получателя"
     * @param commentValue              Значение поля "Примечание"
     * @param requireValue              Значение поля "Требование"
     * @param trustValue                Значение поля "Доверенность"
     */
    public void fillFields(String requireValue, String numberValue, String senderValue, String recipientValue, String financingSourceTypeValue, String productGroupValue,String senderMOLValue,String recipientMOLValue, String trustValue,   String commentValue, String chargeOperation, String arrivalOperation)
    {
        if (!getSenderField().isDisabled() && senderValue != null) { getSenderField().setValue(senderValue); }
        if (recipientValue != null)             { getRecipientField().setValue(recipientValue); }
        if (productGroupValue != null)          { getProductGroupField().setValue(productGroupValue); }
        if (recipientMOLValue != null)          { getRecipientMOLField().setValue(recipientMOLValue); }
        if (senderMOLValue != null)             { getSenderMOLField().setValue(senderMOLValue); }
        if (trustValue != null)                 { getTrustField().setValue(trustValue); }
        if (requireValue != null)               { getRequirementField().setValue(requireValue); }
        if (financingSourceTypeValue != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(financingSourceTypeValue);
            getFinancingSourceTypeField().chooseNodeWithOpenClose(fundingList, true);
        }
        if (commentValue != null)               { getCommentField().setValue(commentValue); }
        if (numberValue != null)                { getNumberField().setValue(numberValue); }
        if (chargeOperation != null)            { getChargeOperationField().setValue(chargeOperation);}
        if (arrivalOperation != null)           { getArrivalOperationField().setValue(arrivalOperation);}
    }


    /**
     * Проверяет значения в тех полях, значения для которых указаны в @param.
     *
     * @param documentTypeValue     Значение поля "Тип документа"
     * @param dateValue             Значение поля "Дата"
     * @param chargeOperationValue  Значение поля "Операция расхода"
     * @param arrivalOperationValue Значение поля "Операция прихода"
     * @param senderMOLValue        Значение поля "МОЛ Отправителя"
     * @param commentValue          Значение поля "Примечание"
     * @param financingSourceValue  Значение поля "Финансирование"
     * @param numberValue           Значение поля "Номер"
     * @param productGroupValue     Значение поля "Товарная группа"
     * @param recipientMOLValue     Значение поля "МОЛ получателя"
     * @param recipientValue        Значение поля "Получатель"
     * @param requirementValue      Значение поля "Требование"
     * @param senderValue           Значение поля "Отправитель"
     * @param trustValue            Значение поля "Доверенность"
     */
    public void checkFields(String documentTypeValue, String numberValue, String dateValue, String requirementValue,
                            String trustValue, String senderValue, String recipientValue, String chargeOperationValue,
                            String arrivalOperationValue, String senderMOLValue, String recipientMOLValue,
                            String financingSourceValue, String productGroupValue, String commentValue)
    {
        if( documentTypeValue != null)      { getDocumentTypeField().assertValue_equals(documentTypeValue); }
        if (numberValue != null)            { getNumberField().assertValue(numberValue); }
        if( dateValue != null)              { getDateField().assertThatDateContainsValue(dateValue); }
        if (requirementValue != null)       { getRequirementField().assertValue_equals(requirementValue); }
        if (trustValue != null)             { getTrustField().assertValue_equals(trustValue); }
        if (senderValue != null)            { getSenderField().assertValue_equals(senderValue); }
        if (recipientValue != null)         { getRecipientField().assertValue_equals(recipientValue); }
        if( chargeOperationValue != null)   { getChargeOperationField().assertValue_equals(chargeOperationValue); }
        if( arrivalOperationValue != null)  { getArrivalOperationField().assertValue_equals(arrivalOperationValue); }
        if( senderMOLValue != null)         { getSenderMOLField().assertValue_equals(senderMOLValue); }
        if (recipientMOLValue != null)      { getRecipientMOLField().assertValue_equals(recipientMOLValue); }
        if (financingSourceValue != null)   { getFinancingSourceTypeField().assertValueIs(financingSourceValue); }
        if (productGroupValue != null)      { getProductGroupField().assertValue_equals(productGroupValue);}
        if (commentValue != null)           { getCommentField().assertValue(commentValue);}

    }

    /**
     * Проверяет дефолтные значения на форме создания/копирования
     */
    public void assertDefaultValues()
    {
        getDocumentTypeField().assertValue_equals(VALUE_DOC_TYPE);
        getDateField().assertThatDateContainsValue(getCurrentDate());
    }

    /**
     * Проверяет переносимые с копируемой формы значения полей
     */
    public void assertCopiedValues(String senderValue, String recipientValue, String chargeOperationValue,
                                   String arrivalOperationValue, String senderMOLValue, String recipientMOLValue,
                                   String financingSourceValue, String productGroupValue)
    {
        getSenderField().assertValue_equals(senderValue);
        getRecipientField().assertValue_equals(recipientValue);
        getChargeOperationField().assertValue_equals(chargeOperationValue);
        getArrivalOperationField().assertValue_equals(arrivalOperationValue);
        getSenderMOLField().assertValue_equals(senderMOLValue);
        getRecipientMOLField().assertValue_equals(recipientMOLValue);
        if (financingSourceValue != null) getFinancingSourceTypeField().assertValueIs(financingSourceValue);
        getProductGroupField().assertValue_equals(productGroupValue);
    }

    /**
     * Проверяет заполненные поля при добавлении на основе Приходной накладной
     */
    public void assertValuesFromArrivalInvoice(String senderValue)
    {
        getSenderField().assertValue_equals(senderValue);
       assertDefaultValues();
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveExpInvoiceButton()
    {
        getSaveExpInvoiceButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getExpInvoiceModal().closeModal();
    }

    /**
     * Проверяет, что все поля на форме в модальном окне "Расходная накладная" недоступны для редактирования.
     */
    public void checkFieldsDisability()
    {
        getDocumentTypeField().assertThatComboboxIsDisabled();
        getNumberField().assertIsDisabled(true);
        getDateField().assertIsDisabled(true);
        getRequirementField().assertThatComboboxIsDisabled();
        getTrustField().assertThatComboboxIsDisabled();
        getSenderField().assertThatComboboxIsDisabled();
        getSenderMOLField().assertThatComboboxIsDisabled();
        getChargeOperationField().assertThatComboboxIsDisabled();
        getRecipientField().assertThatComboboxIsDisabled();
        getRecipientMOLField().assertThatComboboxIsDisabled();
        getArrivalOperationField().assertThatComboboxIsDisabled();
        getProductGroupField().assertThatComboboxIsDisabled();
        getCommentField().assertThatTextareaFieldIsDisabled(true);
    }

    /**
     * Получение модального окна "Доверенность"
     */
    public TrustDocModal getTrustDocModal() {
        return new TrustDocModal();
    }

    /**
     * Нажатие на кнопку "Создать доверенность"
     */
    public void clickCreateTrustDocument() {
        Button button = getTrustField().getButton("addTrustDoc");
        button.assertIsEnabled();
        button.click();
    }
}
