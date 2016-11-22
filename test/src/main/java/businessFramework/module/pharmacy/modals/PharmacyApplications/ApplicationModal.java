package businessFramework.module.pharmacy.modals.PharmacyApplications;


import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModal extends ApplicationModalHelper
{
    public ApplicationModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getApplicationModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveAppButton()
    {
        getSaveAppButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getApplicationModal().closeModal();
    }

    /**
     * Проверяет значения в полях в модальном окне заявки на соответствие ожидаемым
     *
     * @param docTypeValue          ожидаемое значение поля "Тип документа"
     * @param yearValue             ожидаемое значение поля "Год"
     * @param appTypeValue          ожидаемое значение поля "Тип заявки"
     * @param prefixNumberValue     ожидаемое значение поля "Префикс-номер"
     * @param dateValue             ожидаемое значение поля "Дата"
     * @param financingValue        ожидаемое значение поля "Финансирование"
     * @param departmentValue       ожидаемое значение поля "Подразделение"
     * @param storeValue            ожидаемое значение поля "Склад"
     * @param productGroupValue     ожидаемое значение поля "Товарная группа"
     * @param commentValue          ожидаемое значение поля "Примечание"
     */
    public void checkFields(String docTypeValue, String yearValue, String appTypeValue, String prefixNumberValue, String dateValue, String financingValue, String departmentValue, String storeValue, String productGroupValue, String commentValue)
    {
        if ( docTypeValue != null )         { getDocTypeField().assertValue_equals(docTypeValue);}
        if ( yearValue != null )            { getYearField().assertValue(yearValue);}
        if ( appTypeValue != null )         { getApplicationTypeField().assertValue_equals(appTypeValue);}
        if ( prefixNumberValue != null )    { getPrefixNumberField().assertValue(prefixNumberValue);}
        if ( dateValue != null )            { getDateField().assertThatDateContainsValue(dateValue);}
        if ( financingValue != null )       { getFinancingField().assertValueIs(financingValue);}
        if ( departmentValue != null )      { getDepartmentField().assertValue_equals(departmentValue);}
        if ( storeValue != null )           { getStoreField().assertValue_equals(storeValue);}
        if ( productGroupValue != null )    { getProductGroupField().assertValue_equals(productGroupValue);}
        if ( commentValue != null )         { getCommentField().assertValue(commentValue);}
    }

    /**
     * Устанавливает значения в полях в модальном окне заявки
     *
     * @param docTypeValue          ожидаемое значение поля "Тип документа"
     * @param yearValue             ожидаемое значение поля "Год"
     * @param appTypeValue          ожидаемое значение поля "Тип заявки"
     * @param prefixNumberValue     ожидаемое значение поля "Префикс-номер"
     * @param dateValue             ожидаемое значение поля "Дата"
     * @param financingValue        ожидаемое значение поля "Финансирование"
     * @param departmentValue       ожидаемое значение поля "Подразделение"
     * @param storeValue            ожидаемое значение поля "Склад"
     * @param productGroupValue     ожидаемое значение поля "Товарная группа"
     * @param commentValue          ожидаемое значение поля "Примечание"
     */
    public void fillFields(String docTypeValue, String yearValue, String appTypeValue, String prefixNumberValue, String dateValue, String financingValue, String departmentValue, String storeValue, String productGroupValue, String commentValue)
    {
        if ( docTypeValue != null )         { getDocTypeField().setValue(docTypeValue);}
        if ( yearValue != null )            { getYearField().setValue(yearValue);}
        if ( appTypeValue != null )         { getApplicationTypeField().setValue(appTypeValue);}
        if ( prefixNumberValue != null )    { getPrefixNumberField().setValue(prefixNumberValue);}
        if ( dateValue != null )            { getDateField().setValue(dateValue);}
        if (financingValue != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(financingValue);
            getFinancingField().chooseNodeWithOpenClose(fundingList, true);
        }
        if ( departmentValue != null )      { getDepartmentField().setValue(departmentValue);}
        if ( storeValue != null )           { getStoreField().setValue(storeValue);}
        if ( productGroupValue != null )    { getProductGroupField().setValue(productGroupValue);}
        if ( commentValue != null )         { getCommentField().setValue(commentValue);}
    }

    /**
     * Проверяет, что поля недступны для изменения данных
     */
    public void checkFieldsDisability()
    {
        getDocTypeField().assertThatComboboxIsDisabled();
        getYearField().assertIsDisabled(true);
        getApplicationTypeField().assertThatComboboxIsDisabled();
        getPrefixNumberField().assertIsDisabled(true);
        getDateField().assertIsDisabled(true);
        getDepartmentField().assertThatComboboxIsDisabled();
        getStoreField().assertThatComboboxIsDisabled();
        getProductGroupField().assertThatComboboxIsDisabled();
        getCommentField().assertThatTextareaFieldIsDisabled(true);
    }

    /**
     * Проверяет значения в полях в модальном окне Сводной заявки на соответствие ожидаемым
     *
     * @param docTypeValue          ожидаемое значение поля "Тип документа"
     * @param yearValue             ожидаемое значение поля "Год"
     * @param appTypeValue          ожидаемое значение поля "Тип заявки"
     * @param prefixNumberValue     ожидаемое значение поля "Префикс-номер"
     * @param dateValue             ожидаемое значение поля "Дата"
     * @param financingValue        ожидаемое значение поля "Финансирование"
     * @param departmentValues       ожидаемое значение поля "Подразделения"
     * @param storeValue            ожидаемое значение поля "Склад"
     * @param productGroupValue     ожидаемое значение поля "Товарная группа"
     * @param commentValue          ожидаемое значение поля "Примечание"
     */
    public void checkSumApplicationFields(String docTypeValue, String yearValue, String appTypeValue, String prefixNumberValue, String dateValue, String financingValue, List<String> departmentValues, String storeValue, String productGroupValue, String commentValue)
    {
        if ( docTypeValue != null )         { getDocTypeField().assertValue_equals(docTypeValue);}
        if ( yearValue != null )            { getYearField().assertValue(yearValue);}
        if ( appTypeValue != null )         { getApplicationTypeField().assertValue_equals(appTypeValue);}
        if ( prefixNumberValue != null )    { getPrefixNumberField().assertValue(prefixNumberValue);}
        if ( dateValue != null )            { getDateField().assertThatDateContainsValue(dateValue);}
        if ( financingValue != null )       { getFinancingField().assertValueIs(financingValue);}
        if ( departmentValues != null)       { getDepartmentListField().assertThatMultiValuesAre(departmentValues);}
        if ( storeValue != null )           { getStoreField().assertValue_equals(storeValue);}
        if ( productGroupValue != null )    { getProductGroupField().assertValue_equals(productGroupValue);}
        if ( commentValue != null )         { getCommentField().assertValue(commentValue);}
    }

}
