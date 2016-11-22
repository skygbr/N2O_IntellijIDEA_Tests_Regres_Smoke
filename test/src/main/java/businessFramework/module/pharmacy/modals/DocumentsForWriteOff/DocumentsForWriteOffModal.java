package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;


import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentsForWriteOffModal extends DocumentsForWriteOffHelper
{
    /** Модальное окно - "Документ на списание" */

    public DocumentsForWriteOffModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getDocForWriteOffModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Проверяет значения полей в модальном окне на совпадение с ожиддаемыми значениями( переданными как параметры )
     *
     * @param docTypeDemoValue      ожидаемое значение поля "Тип документа" на demo
     * @param docTypeTestValue      ожидаемое значение поля "Тип документа" на test
     * @param numberValue           ожидаемое значение поля "Номер"
     * @param dateValue             ожидаемое значение поля "Дата"
     * @param storeValue            ожидаемое значение поля "Склад"
     * @param storeOperationValue   ожидаемое значение поля "Операция расхода"
     * @param financingSourceValue  ожидаемое значение поля "Источник финансирования"
     * @param productGroupValue     ожидаемое значение поля "Товарная группа"
     * @param commentValue          ожидаемое значение поля "Примечание"
     */
    public void checkFieldsValues(String docTypeDemoValue, String docTypeTestValue, String numberValue, String dateValue, String storeValue, String storeOperationValue, String financingSourceValue, String productGroupValue, String commentValue)
    {
        List<String> docTypes = Arrays.asList(docTypeDemoValue, docTypeTestValue);

        if ((docTypeTestValue != null) && (docTypeDemoValue != null))   { getDocType_f().assertValue_oneOf(docTypes);}

        if (numberValue != null)            { getNumber_f().assertValue(numberValue);}
        if (dateValue != null)              { getDate_f().assertThatDateContainsValue(dateValue);}
        if (storeValue != null)             { getStore_f().assertValue_equals(storeValue);}
        if (storeOperationValue != null)    { getStoreOperation_f().assertValue_equals(storeOperationValue);}
        if (financingSourceValue != null)   { getFinancingSource_f().assertValueIs(financingSourceValue);}
        if (productGroupValue != null)      { getProductGroup_f().assertValue_equals(productGroupValue);}
        if (commentValue != null)           { getComment_f().assertValue(commentValue);}
    }


    /**
     * Устанавливает значения в поля в модальном окне
     *
     * @param docTypeValue          значение для поля "Тип документа"
     * @param numberValue           значение для поля "Номер"
     * @param dateValue             значение для поля "Дата"
     * @param storeValue            значение для поля "Склад"
     * @param storeOperationValue   значение для поля "Операция расхода"
     * @param productGroupValue     значение для поля "Товарная группа"
     * @param commentValue          значение для поля "Примечание"
     */
    public void fillFields(String docTypeValue, String numberValue, String dateValue, String storeValue, String storeOperationValue, String productGroupValue, String commentValue, String financingSourceValue)
    {
        if (docTypeValue != null)           { getDocType_f().setValue(docTypeValue);}
        if (numberValue != null)            { getNumber_f().setValue(numberValue);}
        if (dateValue != null)              { getDate_f().setValue(dateValue);}
        if (storeValue != null)             { getStore_f().setValue(storeValue);}
        if (storeOperationValue != null)    { getStoreOperation_f().setValue(storeOperationValue);}
        if (productGroupValue != null)      { getProductGroup_f().setValue(productGroupValue);}
        if (commentValue != null)           { getComment_f().setValue(commentValue);}
        if (financingSourceValue != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(financingSourceValue);
            getFinancingSource_f().chooseNodeWithOpenClose(fundingList, true);
        }
    }

    /**
     * Проверяет, что поля "Тип документа", "Номер", "Дата", "Склад", "Операция расхода", "Причина списания", "Источник финансирования", "Товарная группа", "Примечание" недоступны для редактирования
     */
    public void checkThatCllFieldsAreDisabled()
    {
        getDocType_f().assertThatComboboxIsDisabled();
        getNumber_f().assertIsDisabled(true);
        getDate_f().assertIsDisabled(true);
        getStore_f().assertThatComboboxIsDisabled();
        getStoreOperation_f().assertThatComboboxIsDisabled();
        getReason_f().assertThatComboboxIsDisabled();
        //getFinancingSource_f().assertThatComboboxIsDisabled();
        getProductGroup_f().assertThatComboboxIsDisabled();
        getComment_f().assertThatTextareaFieldIsDisabled(true);
    }

    /**
     * Нажимает кнопку "Подтвердить"
     */
    public void clickApplyDocButton()
    {
        getApplyDocButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeWriteOffDocModal()
    {
        getDocForWriteOffModal().closeModal();
    }
}
