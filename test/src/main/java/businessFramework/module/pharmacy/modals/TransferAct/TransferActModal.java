package businessFramework.module.pharmacy.modals.TransferAct;

import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActModal extends TransferActModalHelper implements TransferActValues{

    public TransferActModal(ApplicationManager app) {
        super(app);
    }
         /* ------------------ Модальное окно "Акты переброски" --------------------- */

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getTransferActModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Заполняет те поля на форме в модальном окне "Акты переброски", значения для которых указаны в @param.
     *
     * @param numberValue               Значение поля "Номер"
     * @param senderValue               Значение поля "Отправитель"
     * @param recipientValue            Значение поля "Получатель"
     * @param financingSourceTypeValue  Значение поля "Источник финансирования"
     * @param newFundingValue           Значение поля "Новый источник"
     * @param recipientMOLValue         Значение поля "МОЛ получателя"
     * @param commentValue              Значение поля "Примечание"
     */
    public void fillFields(String numberValue, String senderValue, String senderMOLValue, String recipientValue, String recipientMOLValue,
                           String financingSourceTypeValue, String newFundingValue,    String commentValue)
    {
        if (numberValue != null)                { getNumberField().setValue(numberValue); }
        if (!getSenderField().isDisabled() && senderValue != null) { getSenderField().setValue(senderValue); }
        if(senderMOLValue != null)              { getSenderMOLField().setValue(senderMOLValue);}
        if (recipientValue != null)             { getRecipientField().setValue(recipientValue); }
        if (recipientMOLValue != null)          { getRecipientMOLField().setValue(recipientMOLValue); }
        if (financingSourceTypeValue != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(financingSourceTypeValue);
            getFinancingSourceTypeField().chooseNodeWithOpenClose(fundingList, true);
        }
        if (newFundingValue != null)            { getNewFundingSourceField().setValue(newFundingValue); }
        if (commentValue != null)               { getCommentField().setValue(commentValue); }
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
     * @param senderValue           Значение поля "Отправитель"
     */
    public void checkFields(String documentTypeValue, String numberValue, String dateValue,
                            String senderValue, String recipientValue, String chargeOperationValue,
                            String arrivalOperationValue, String senderMOLValue, String recipientMOLValue,
                            String financingSourceValue, String productGroupValue, String commentValue)
    {
        if( documentTypeValue != null)      { getDocumentTypeField().assertValue_equals(documentTypeValue); }
        if (numberValue != null)            { getNumberField().assertValue(numberValue); }
        if( dateValue != null)              { getDateField().assertThatDateContainsValue(dateValue); }
        if (senderValue != null)            { getSenderField().assertValue_equals(senderValue); }
        if (recipientValue != null)         { getRecipientField().assertValue_equals(recipientValue); }
        if( chargeOperationValue != null)   { getChargeOperationField().assertValue_equals(chargeOperationValue); }
        if( arrivalOperationValue != null)  { getArrivalOperationField().assertValue_equals(arrivalOperationValue); }
        if( senderMOLValue != null)         { getSenderMOLField().assertValue_equals(senderMOLValue); }
        if (recipientMOLValue != null)      { getRecipientMOLField().assertValue_equals(recipientMOLValue); }
        if (financingSourceValue != null)   { getFinancingSourceTypeField().assertValueIs(financingSourceValue); }
        if (productGroupValue != null)      { getNewFundingSourceField().assertValue_equals(productGroupValue);}
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
                                   String fundingSourceValue, String newFundingSourceValue)
    {
        getSenderField().assertValue_equals(senderValue);
        getRecipientField().assertValue_equals(recipientValue);
        getChargeOperationField().assertValue_equals(chargeOperationValue);
        getArrivalOperationField().assertValue_equals(arrivalOperationValue);
        getSenderMOLField().assertValue_equals(senderMOLValue);
        getRecipientMOLField().assertValue_equals(recipientMOLValue);
        getFinancingSourceTypeField().assertValueIs(fundingSourceValue);
        getNewFundingSourceField().assertValue_equals(newFundingSourceValue);
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
    public void clickSaveTransferActButton()
    {
        getSaveTransferActButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getTransferActModal().closeModal();
    }

    /**
     * Проверяет, что все поля на форме в модальном окне "Акты переброски" недоступны для редактирования.
     */
    public void checkFieldsDisability()
    {
        getDocumentTypeField().assertThatComboboxIsDisabled();
        getNumberField().assertIsDisabled(true);
        getDateField().assertIsDisabled(true);
        getSenderField().assertThatComboboxIsDisabled();
        getSenderMOLField().assertThatComboboxIsDisabled();
        getChargeOperationField().assertThatComboboxIsDisabled();
        getRecipientField().assertThatComboboxIsDisabled();
        getRecipientMOLField().assertThatComboboxIsDisabled();
        getArrivalOperationField().assertThatComboboxIsDisabled();
        //getFinancingSourceTypeField().assertThatComboboxIsDisabled();
        getNewFundingSourceField().assertThatComboboxIsDisabled();
        getCommentField().assertThatTextareaFieldIsDisabled(true);
    }
}
