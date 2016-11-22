package businessFramework.module.pharmacy.pages.contracts;


import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.Contract.ContractModal;
import businessFramework.module.pharmacy.modals.Specification.SpecificationModal;
import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContractsPage extends ContractsHelper implements Values
{
    public ContractsPage(ApplicationManager app)
    {
        super(app);
    }

    public int row = 0;

    /**
     * Открывает фильтр в контейнере "Контракты"
     */
    public void openFilterForContracts()
    {
        getContractsListContainer().showFilter();
    }

    /**
     * Проверка значения в поле дат
     */
    public void checkDatesValues()
    {
        String beginValue = getContractDate().getBeginValue();  // 01.01.2015
        String endValue = getContractDate().getEndValue();      // 01.04.2015

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String expectedBeginValue = "01.01." + formatBegin.format(nowDate);
        String expectedEndValue = formatEnd.format(nowDate);

        assertThat(beginValue, equalTo(expectedBeginValue));
        assertThat(endValue, equalTo(expectedEndValue));

    }

    /* -------------------- Кнопки в контейнере "Контракты" ------------------------- */

    /**
     * Нажимает кнопку "Добавить" над таблицей на странице "Контракты"
     */
    public void clickCreateContractButton()
    {
        getCreateContractButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Контракты"
     */
    public void clickEditContractButton()
    {
        getEditContractButton().click();
    }

    /**
     * Нажимает кнопку "Просмотр" в контейнере "Контракты"
     */
    public void clickViewContractButton()
    {
        getViewContractButton().click();
    }

    /**
     * Нажимает кнопку "Подтвердить" в контейнере "Контракты"
     */
    public void clickApplyContractButton()
    {
        getApplyContractButton().click();
    }

    /**
     * Нажимает кнопку "Снять подтверждение" в контейнере "Контракты"
     */
    public void clickRevertAcceptContractButton()
    {
        getRevertAcceptContractButton().click();
    }

    /**
     * Нажимает кнопку "Исполнить" в контейнере "Контракты"
     */
    public void clickExecuteContractButton()
    {
        getExecuteContractButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Контракты"
     */
    public void clickDeleteContractButton()
    {
        getDeleteContractButton().click();
    }

    /* -------------------- Кнопки в контейнере "Спецификация" ------------------------- */

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификация"
     */
    public void clickCreateSpecificationButton()
    {
        getCreateSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Спецификация"
     */
    public void clickEditSpecificationButton()
    {
        getEditSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Спецификация"
     */
    public void clickDeleteSpecificationButton()
    {
        getDeleteSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Снять подтверждение" в контейнере "Спецификация"
     */
    public void clickRevertAcceptSpecificationButton() {
        getRevertAcceptSpecificationButton().click();
    }



    /* -------------------- Спецификация ------------------------- */

    /**
     * Получение модального окна "Добавление спецификации" в этом классе, тк это модальное окно открывается со страницы "Контракты".
     */
    public SpecificationModal getSpecificationModal()
    {
        return new SpecificationModal(app);
    }

    /**
     * Проверяет, что в таблице "Контракты" отобразилась запись с необходимыми значениями
     *
     * @param nameLS_IMN_value значение в столбце "Наименование ЛС и ИМН"
     * @param seriesValue значение в столбце "Серия"
     * @param expiringDateValue значение в столбце "Срок годности"
     * @param quantityValue значение в столбце "Количество"
     * @param priceValue значение в столбце "Цена"
     * @param amountValue значение в столбце "Сумма"
     *
     * @return номер найденной строки
     */
    public int checkRecordInSpecificationTable(String nameLS_IMN_value, String seriesValue, String expiringDateValue, String quantityValue, String priceValue, String amountValue, String status)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if(nameLS_IMN_value != null)     { columnsAndValues.put("Наименование ЛС и ИМН", nameLS_IMN_value); }
        if(seriesValue != null)          { columnsAndValues.put("Серия", seriesValue); }
        if(expiringDateValue != null)    { columnsAndValues.put("Срок годности", expiringDateValue); }
        if(quantityValue != null)        { columnsAndValues.put("Количество", quantityValue); }
        if(priceValue != null)           { columnsAndValues.put("Цена", priceValue); }
        if(amountValue != null)          { columnsAndValues.put("Сумма", amountValue); }
        if(status != null)               { columnsAndValues.put("Статус", status); }

        row = getSpecificationsListContainer().getTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;

    }

        /* -------------------- "Контракты" ------------------------- */

    /**
     * Проверяет наличие сообщения об успешном сохранении на странице "Контракты"
     */
    public void checkSuccessMessage()
    {
        getContractsListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Выбирает строчку в таблице "Контракты" по номеру, найденному в методе checkRecordInContractsTable
     */
    public void selectFoundedRow(int rowNumber)
    {
        getContractsListTable().chooseRowInTable(rowNumber);
    }

    /**
     * Проверяет, что в таблице "Контракты" отобразилась запись с необходимыми значениями
     *
     * @param financingValue значение в столбце "Финансирование"
     * @param nameValue значение в столбце "Наименование"
     * @param sumValue значение в столбце "Сумма"
     * @param providerValue значение в столбце "Поставщик"
     * @param numberValue значение в стоблце "Номер" - случайная строка из цифр, которая была указана при создании контракта.
     */
    public int checkRecordInContractsTable(String nameValue, String numberValue, String financingValue, String providerValue, String sumValue, boolean checkContractDate, boolean checkBeginDate, boolean checkEndDate, String confirmed)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if(numberValue != null)     { columnsAndValues.put("Номер", numberValue); }
        if(nameValue != null)       { columnsAndValues.put("Наименование", nameValue); }
        if (sumValue != null)       { columnsAndValues.put("Сумма", sumValue); }
        if (financingValue != null) { columnsAndValues.put("Финансирование", financingValue); }
        if (providerValue != null)  { columnsAndValues.put("Поставщик", providerValue); }
        if (confirmed != null)      { columnsAndValues.put("Статус", confirmed); }

        if (checkContractDate)  { columnsAndValues.put("Дата", getCurrentDate()); }
        if (checkBeginDate)     { columnsAndValues.put("Начало", getCurrentDate()); }
        if (checkEndDate)       { columnsAndValues.put("Окончание", getCurrentDate()); }

        row = getContractsListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Получает запись в таблице "Контракты" по номеру
     *
     * @param numberValue значение в столбце "Финансирование"
     * @param status значение в столбце "Статус"
     */
    public int getRecordInContractsTableByNumber(String numberValue, String status) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null) {
            columnsAndValues.put("Номер", numberValue);
        }
        if (status != null) {
            columnsAndValues.put("Статус", status);
        }
        row = getContractsListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Получение модального окна "Контракт" в этом классе, тк это модальное окно открывается со страницы "Контракты".
     */
    public ContractModal getContractModal()
    {
        return new ContractModal(app);
    }

    /**
     * Нажимает на кнопку "Да" в модальном окне типа dialog ( текст в модальнмо окне "Изменить статус Контракта на "Подтверждён"?")
     */
    public void acceptConfirm()
    {

        getConfirmModal().clickYes();
    }
}
