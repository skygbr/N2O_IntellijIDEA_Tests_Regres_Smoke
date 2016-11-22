package businessFramework.module.pharmacy.modals.Contract;


import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

public class ContractModal extends ContractHelper {
    public ContractModal(ApplicationManager app) {
        super(app);
    }

    /* ------------------ Модальное окно "Контракт" --------------------- */

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Контракт"
     */
    public void checkModalHeader(String contractNumber, Boolean isCreateModal) {
        if (isCreateModal) { getContractModal().assertModalHeader_equal(String.format("Контракт №%s от %s", contractNumber, getCurrentDate())); }
        else { getContractModal().assertModalHeader_equal("Контракт"); }
    }

    /**
     * Устанавливает значения в поля
     *
     * @param nameValue      Значение для поля "Наименование"
     * @param sumValue       Значение для поля "Сумма"
     * @param financingValue Значение для поля "Фининсирование"
     * @param providerValue  Значение для поля "Поставщик"
     * @param randomNumber   значение поля "Номер"
     */
    public void setValuesToFields(String validEndDate, String nameValue, String sumValue, String financingValue, String providerValue, String randomNumber, boolean setEndDate) {
        if (validEndDate != null) getValidDateField().setEndDateValue(validEndDate); // Текущая дата
        getNumberField().setValue(randomNumber);  // Случайная строка из цифр
        getNameField().setValue(nameValue);
        getSumField().setValue(sumValue);
        List<String> fundingList = new ArrayList<>();
        fundingList.add(financingValue);
        getFinancingField().chooseNodeWithOpenClose(fundingList, true);
        getProviderField().setValue(providerValue);
    }

    /**
     * Проверяет значения в полях в модальном окне.
     *
     * @param expectedDocumentType Ожидаемое значение поля "Тип документа"
     * @param expectedNumber       Ожидаемое значение поля "Номер"
     * @param expectedName         Ожидаемое значение поля "Наименование"
     * @param expectedSum          Ожидаемое значение поля "Сумма"
     * @param expectedFinancing    Ожидаемое значение поля "Финансирование"
     * @param expectedProvider     Ожидаемое значение поля "Поставщик"
     */
    public void checkFieldsValues(String expectedDocumentType, String expectedNumber, String expectedName, String expectedSum, String expectedFinancing, String expectedProvider) {
        getDocumentType().assertValue_equals(expectedDocumentType);
        getNumberField().assertValue(expectedNumber);
        getNameField().assertValue(expectedName);

        getContractDateField().assertValue(getContractDateField().getValue(), getCurrentDate()); // Дата договора
        getValidDateField().assertThatBeginDateContainsValue(getCurrentDate()); // Начало действия
        getValidDateField().assertThatEndDateContainsValue(getCurrentDate()); // Окончание действия

        getSumField().assertValue(expectedSum);
        if (expectedFinancing != null)
            getFinancingField().assertValueIs(expectedFinancing);
        getProviderField().assertValue_equals(expectedProvider);
     }

    /**
     * Нажимает кнопку "Подтвердить"
     */
    public void pressConfirmButton() {
        getConfirmButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal() {
        getContractModal().closeModal();
    }

    /**
     * Проверка, что поля в модальном окне "Просмотр контракта" недоступны для редактирования значений.
     */
    public void checkFieldsDisability() {
        getDocumentType().assertThatComboboxIsDisabled();
        getNumberField().assertIsDisabled(true);
        getNameField().assertIsDisabled(true);
        getSumField().assertIsDisabled(true);
        getProviderField().assertThatComboboxIsDisabled();
        getContractDateField().assertIsDisabled(true);
        getValidDateField().assertThatBeginEndFieldsDisabled(true);
        getCommentField().assertThatTextareaFieldIsDisabled(true);
        // todo comment field
    }

}
