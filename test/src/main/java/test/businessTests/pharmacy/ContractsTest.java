package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.PharmacyData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ContractsTest extends TestBase implements Values
{

    private PharmacyManager pharmacyManager;
    private PharmacyData pharmacyData;
    private String randomNumber;
    private String randomContractNumber;
    private String seriesValue = randomInt(5);
    private String certificateValue = randomInt(10);
    private int row;
    private int specificationRow;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException{
        pharmacyManager = new PharmacyManager();
        pharmacyData = new PharmacyData();

        pharmacyData.setDepartmentForContext("Отделение экстренной госпитализации");
        pharmacyData.setValidEndDate(page.getCurrentDate());
        pharmacyData.setName("Контракт №1");
        pharmacyData.setSum("500.000");
        pharmacyData.setFinancing("test_funding_source");
        pharmacyData.setProvider("Тестовый поставщик");
        pharmacyData.setDocumentType("Контракт на поставку лекарственного обеспечения");

        pharmacyData.setSumForEdit("500");
        pharmacyData.setNameForEdit("Контракт №2");

        /** Данные для полей в модальном окне "Контракт №%s от %s. Добавление спецификации." */
        pharmacyData.setNameLS_IMN("Тестовая модификация");
        pharmacyData.setSeries(seriesValue);
        pharmacyData.setProductionDate("01.01.2015");
        pharmacyData.setProducer("АДМ Евразия ООО");
        pharmacyData.setCountry("Абхазия");
        pharmacyData.setExpiringDate("01.01.2020");
        pharmacyData.setCertificate(certificateValue);
        pharmacyData.setQuantity("10");
        pharmacyData.setAmount("100");
        pharmacyData.setFormattedAmount("100.00");
        pharmacyData.setMneiQuantity("10");
        pharmacyData.setPrice("10");
        pharmacyData.setFormattedPrice("10.000");

        /** Данные для установки значений в модальном окне "Спецификация" в шаге "Редактирование спецификации"*/
        pharmacyData.setCountryForEditSpecification("Российская федерация");
        pharmacyData.setExpiringDateForEditSpecification("01.01.2022");
        pharmacyData.setQuantityForEditSpecification("20");
        pharmacyData.setMneiQuantityForEditSpecification("20");
        pharmacyData.setPriceForEditSpecification("5");

        /** Данные для измененных значений "Цена" (20.00) и "Сумма" (200.00)*/
        pharmacyData.setFormattedPriceForEditSpecification("5.000");
        pharmacyData.setFormattedAmountForEditSpecification("100.00");

        /** Значение столбца "Статус" в таблице "Контракты" после изменения статуса контракта на "Подтвержден" */
        pharmacyData.setConfirmed("подтвержден");
    }

    @Test (description = "Открытие модуля 'Контракты'")
    public void step1_openContractsPage()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(pharmacyData.getDepartmentForContext());
        pharmacyManager.openContracts();
    }

//   @Test (description = "Открытие фильтра и проверка дат в фильтре", dependsOnMethods = "step1_openContractsPage")
//    public void step2_checkDateFieldsInFilter()
//    {
//        pharmacyManager.getContractsPage().openFilterForContracts();
//        pharmacyManager.getContractsPage().checkDatesValues();
//    }
//
//    @Test (description = "Создание контракта: Нажать кнопку 'Добавить', заполнение полей, проверка созданной записи", dependsOnMethods = "step2_checkDateFieldsInFilter")
//    public void step3_createContract()
//    {
//        randomNumber = selectRandomNumbers(5);
//        randomContractNumber = "Контр. "+randomNumber;
//        pharmacyManager.getContractsPage().clickCreateContractButton();
//        pharmacyManager.getContractsPage().getContractModal().assertCountOfModals(1); // проверим, что количество модальных окон - 1.
//        pharmacyManager.getContractsPage().getContractModal().checkModalHeader(null, false);     // Проверим, что окно действительно называется "Контракт"
//        pharmacyManager.getContractsPage().getContractModal().setValuesToFields(pharmacyData.getValidEndDate(), pharmacyData.getName(), pharmacyData.getSum(), pharmacyData.getFinancing(), pharmacyData.getProvider(), randomNumber, true);
//        pharmacyManager.getContractsPage().getContractModal().checkFieldsValues(pharmacyData.getDocumentType(), null, null, null, null, null);
//        pharmacyManager.getContractsPage().getContractModal().pressConfirmButton();
//        pharmacyManager.getContractsPage().checkSuccessMessage();
//        row = pharmacyManager.getContractsPage().checkRecordInContractsTable(pharmacyData.getName(), randomContractNumber, pharmacyData.getFinancing(), pharmacyData.getProvider(), pharmacyData.getSum(), true, true, true, null);
//    }
//
//    @Test (description = "Редактирование контракта", dependsOnMethods = "step3_createContract")
//    public void step4_editContract()
//    {
//        pharmacyManager.getContractsPage().selectFoundedRow(row);
//        pharmacyManager.getContractsPage().clickEditContractButton();
//        pharmacyManager.getContractsPage().getContractModal().assertCountOfModals(1); // проверим, что количество модальных окон - 1.
//        pharmacyManager.getContractsPage().getContractModal().checkModalHeader(randomNumber, true);     // Проверим, что окно действительно называется "Контракт"
//        pharmacyManager.getContractsPage().getContractModal().checkFieldsValues(pharmacyData.getDocumentType(), randomNumber, pharmacyData.getName(), pharmacyData.getSumForEdit(), pharmacyData.getFinancing(), pharmacyData.getProvider());
//        pharmacyManager.getContractsPage().getContractModal().setValuesToFields(null, pharmacyData.getNameForEdit(), pharmacyData.getSumForEdit(), null, null, null, false);
//        pharmacyManager.getContractsPage().getContractModal().pressConfirmButton();
//        pharmacyManager.getContractsPage().checkSuccessMessage();
//        row = pharmacyManager.getContractsPage().checkRecordInContractsTable(pharmacyData.getNameForEdit(), randomContractNumber, pharmacyData.getFinancing(), pharmacyData.getProvider(), pharmacyData.getSum(), true, true, false, null);
//    }
//
//    @Test (description = "Просмотр контракта", dependsOnMethods = "step4_editContract")
//    public void step5_viewContract()
//    {
//        pharmacyManager.getContractsPage().selectFoundedRow(row);
//        pharmacyManager.getContractsPage().clickViewContractButton();
//        pharmacyManager.getContractsPage().getContractModal().assertCountOfModals(1); // проверим, что количество модальных окон - 1.
//        pharmacyManager.getContractsPage().getContractModal().checkModalHeader(null, false);     // Проверим, что окно действительно называется "Контракт"
//        pharmacyManager.getContractsPage().getContractModal().checkFieldsDisability();
//        pharmacyManager.getContractsPage().getContractModal().checkFieldsValues(pharmacyData.getDocumentType(), randomNumber, pharmacyData.getNameForEdit(), pharmacyData.getSumForEdit(), pharmacyData.getFinancing(), pharmacyData.getProvider());
//        pharmacyManager.getContractsPage().getContractModal().closeModal();
//
//    }
//
//    @Test (description = "Создание спецификации", dependsOnMethods = "step5_viewContract")
//    public void step6_creatingSpecification()
//    {
//        pharmacyManager.getContractsPage().clickCreateSpecificationButton();
//        pharmacyManager.getContractsPage().getSpecificationModal().assertCountOfModals(1);
//        pharmacyManager.getContractsPage().getSpecificationModal().checkModalHeader(randomNumber, true);
//        pharmacyManager.getContractsPage().getSpecificationModal().setValuesToFields(pharmacyData.getNameLS_IMN(),
//                pharmacyData.getSeries(), pharmacyData.getProductionDate(), pharmacyData.getProducer(), pharmacyData.getCountry(),
//                pharmacyData.getExpiringDate(), pharmacyData.getCertificate(), pharmacyData.getQuantity(), pharmacyData.getAmount());
//
//        pharmacyManager.getContractsPage().getSpecificationModal().checkFieldsValues(null, null, null, null, null, null, null, null, null,
//                                                                                           pharmacyData.getMneiQuantity(), pharmacyData.getPrice());
//
//        pharmacyManager.getContractsPage().getSpecificationModal().pressSaveButton();
//        pharmacyManager.getContractsPage().getSpecificationsListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
//        specificationRow = pharmacyManager.getContractsPage().checkRecordInSpecificationTable(pharmacyData.getNameLS_IMN(), seriesValue, pharmacyData.getExpiringDate(),
//                pharmacyData.getQuantity(), pharmacyData.getFormattedPrice(), pharmacyData.getFormattedAmount(),null);
//
//    }
//
//    @Test (description = "Редактирование спецификации", dependsOnMethods = "step6_creatingSpecification")
//    public void step7_editingSpecification()
//    {
//        pharmacyManager.getContractsPage().getSpecificationsTable().chooseRowInTable(specificationRow);
//        pharmacyManager.getContractsPage().clickEditSpecificationButton();
//        pharmacyManager.getContractsPage().getSpecificationModal().assertCountOfModals(1);
//        pharmacyManager.getContractsPage().getSpecificationModal().checkModalHeader(null, false);
//        pharmacyManager.getContractsPage().getSpecificationModal().checkFieldsValues(pharmacyData.getNameLS_IMN(), pharmacyData.getSeries(), pharmacyData.getProductionDate(), pharmacyData.getProducer(), pharmacyData.getCountry(),pharmacyData.getExpiringDate(),certificateValue,pharmacyData.getQuantity(), pharmacyData.getAmount(), pharmacyData.getMneiQuantity(), pharmacyData.getPrice());
//        pharmacyManager.getContractsPage().getSpecificationModal().setValuesToFields(null, null, null, null, pharmacyData.getCountryForEditSpecification(), pharmacyData.getExpiringDateForEditSpecification(), null, pharmacyData.getQuantityForEditSpecification(), pharmacyData.getAmount()); //todo сумма заполняется повторно, дождаться решения https://jira.i-novus.ru/browse/HOTANALYTICS-1811, возможно придется переделывать
//        pharmacyManager.getContractsPage().getSpecificationModal().pressSaveButton();
//
//        specificationRow = pharmacyManager.getContractsPage().checkRecordInSpecificationTable(pharmacyData.getNameLS_IMN(), pharmacyData.getSeries(), pharmacyData.getExpiringDateForEditSpecification(), pharmacyData.getQuantityForEditSpecification(), pharmacyData.getFormattedPriceForEditSpecification(), pharmacyData.getFormattedAmountForEditSpecification(),null);
//
//        pharmacyManager.getContractsPage().getSpecificationsTable().chooseRowInTable(specificationRow);
//        pharmacyManager.getContractsPage().clickEditSpecificationButton();
//        pharmacyManager.getContractsPage().getSpecificationModal().assertCountOfModals(1);
//        pharmacyManager.getContractsPage().getSpecificationModal().checkModalHeader(null, false);
//        pharmacyManager.getContractsPage().getSpecificationModal().checkFieldsValues(pharmacyData.getNameLS_IMN(), pharmacyData.getSeries(), pharmacyData.getProductionDate(), pharmacyData.getProducer(), pharmacyData.getCountryForEditSpecification(), pharmacyData.getExpiringDateForEditSpecification(), pharmacyData.getCertificate(), pharmacyData.getQuantityForEditSpecification(), pharmacyData.getAmount(), pharmacyData.getMneiQuantityForEditSpecification(), pharmacyData.getPriceForEditSpecification());
//        pharmacyManager.getContractsPage().getSpecificationModal().closeModal();
//
//    }
//
//    @Test (description = "Проведение контракта", dependsOnMethods = "step7_editingSpecification")
//    public void step8_acceptContract()
//    {
//        pharmacyManager.getContractsPage().getContractsListTable().chooseRowInTable(row);
//        pharmacyManager.getContractsPage().clickApplyContractButton();
//        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
//        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertMessage("Статус Контракта изменён на \"Подтверждён\"");
//
//        row = pharmacyManager.getContractsPage().checkRecordInContractsTable(pharmacyData.getNameForEdit(), randomContractNumber, pharmacyData.getFinancing(), pharmacyData.getProvider(), pharmacyData.getSum(), true, true, false, pharmacyData.getConfirmed());
//    }
//
//    @Test (description = "Исполнение контракта", dependsOnMethods = "step8_acceptContract")
//    public void step9_executeContract()
//    {
//        int rowId= pharmacyManager.getContractsPage().getRecordInContractsTableByNumber("Дог. contract_to_execute", pharmacyData.getConfirmed());
//        pharmacyManager.getContractsPage().getContractsListTable().chooseRowInTable(rowId);
//        pharmacyManager.getContractsPage().clickExecuteContractButton();
//        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
//        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertMessage("Статус Контракта изменён на \"Исполнен\"");
//        row= pharmacyManager.getContractsPage().getRecordInContractsTableByNumber("Дог. contract_to_execute", "исполнен");
//    }
//
//    @Test (description = "Отмена подтверждения спецификации", dependsOnMethods = "step9_executeContract")
//    public void step10_revertAcceptContractSpec()
//    {
//        int contractRow = pharmacyManager.getContractsPage().checkRecordInContractsTable("contract_to_revert_accept", "Контр. contract_to_revert_accept",null,null, "1 000.00", false, false, false, null);
//        pharmacyManager.getContractsPage().getContractsListTable().chooseRowInTable(contractRow);
//        specificationRow = pharmacyManager.getContractsPage().checkRecordInSpecificationTable("contr_autotest_modif",null,null,"10","10.000","100.00", "подтвержден");
//        pharmacyManager.getContractsPage().getSpecificationsTable().chooseRowInTable(specificationRow);
//        pharmacyManager.getContractsPage().clickRevertAcceptSpecificationButton();
//        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//        pharmacyManager.getContractsPage().getSpecificationsListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
//        pharmacyManager.getContractsPage().getSpecificationsListContainer().getTable().getAlerts().assertSuccessAlertMessage("Статус спецификации изменён на \"Черновик\"");
//        pharmacyManager.getContractsPage().checkRecordInSpecificationTable("contr_autotest_modif",null,null,"10","10.000","100.00", "черновик");
//    }

    @Test (description = "Создание контракта: Нажать кнопку 'Добавить', заполнение полей, проверка созданной записи", dependsOnMethods = "step1_openContractsPage")
    public void step11_createContractWithDeliveryDate()
    {
        randomNumber = randomInt(5);
        randomContractNumber = "Контр. "+randomNumber;
        pharmacyManager.getContractsPage().clickCreateContractButton();
      //  pharmacyManager.getContractsPage().getContractModal().assertCountOfModals(1); // проверим, что количество модальных окон - 1.
       // pharmacyManager.getContractsPage().getContractModal().checkModalHeader(null, false);     // Проверим, что окно действительно называется "Контракт"
        pharmacyManager.getContractsPage().getContractModal().setValuesToFields(pharmacyData.getValidEndDate(), pharmacyData.getName(), pharmacyData.getSum(), pharmacyData.getFinancing(), pharmacyData.getProvider(), randomNumber, true);
        pharmacyManager.getContractsPage().getContractModal().checkFieldsValues(pharmacyData.getDocumentType(), null, null, null, pharmacyData.getFinancing(), null);
        pharmacyManager.getContractsPage().getContractModal().pressConfirmButton();
        pharmacyManager.getContractsPage().checkSuccessMessage();
        row = pharmacyManager.getContractsPage().checkRecordInContractsTable(pharmacyData.getName(), randomContractNumber, pharmacyData.getFinancing(), pharmacyData.getProvider(), pharmacyData.getSum(), true, true, true, null);
    }
//    @Test (description = "Удаление созданных записей", dependsOnMethods = "step10_revertAcceptContractSpec", alwaysRun = true)
//    public void step11_deleteAllCreatedRecords()
//    {
//        // 1. Если в таблице Контракты есть записи ...( то есть getCountRowsInTable должно быть > 0 и при этом assertNoRecordsReturnResult должен вернуть false(если есть одна строка в таблице - это не должна быть строка с записью "нет данных для отображения)
//        // 2. ... то выбираем по порядку очередную запись
//        // 3. Смотрим значение столбца "Статус" у этой записи (т.к. если там значение "подтвержден" - чтобы удалить запись - надо вначале снять подтверждение)
//        // 4. Если значение столбца "Статус" = "подтвержден", то нажать кнопку "Снять подтверждение" и нажать кнопку "Да" в модальном подтверждающем действие окне. и перейти к п. 6
//        // 5. Если значение столбца "Статус" = "черновик" - то перейти к п.6
//        // 6. Посмотреть количество записей в таблице "Спецификация" для выбранной в таблице "Контракты" записи.  ( то есть getCountRowsInTable должно быть > 0 и при этом assertNoRecordsReturnResult должен вернуть false(если есть одна строка в таблице - это не должна быть строка с записью "нет данных для отображения)
//        // 7. Если записи есть - то выбираем по порядку очередную запись в таблице "Спецификация" и нажимаем кнопку "Удалить" и нажать кнопку "Да" в модальном подтверждающем действие окне.
//
//        if (pharmacyManager.getContractsPage().getCountOfModals() > 0) pharmacyManager.getContractsPage().getModal().closeModal();
//
//        if (pharmacyManager.getContractsPage().getContractsListTable().getCountRowsInTable(true) > 0 && !pharmacyManager.getContractsPage().getContractsListTable().assertNoRecordsReturnResult())
//        {
//            while(pharmacyManager.getContractsPage().getContractsListTable().getCountRowsInTable(true)>1 &&  !pharmacyManager.getContractsPage().getContractsListTable().assertNoRecordsReturnResult() )
//            {
//                if (!pharmacyManager.getContractsPage().getContractsListTable().assertNoRecordsReturnResult()) {
//                    pharmacyManager.getContractsPage().getContractsListTable().chooseRowInTable(0);
//                    String isConfirmed = pharmacyManager.getContractsPage().getContractsListTable().getRowColumnIntersectionValue(0, "Статус", true);
//
//                    if (isConfirmed.equals("исполнен")) {
//                        pharmacyManager.getContractsPage().getContractsListTable().chooseRowInTable(1);
//                        isConfirmed = pharmacyManager.getContractsPage().getContractsListTable().getRowColumnIntersectionValue(1, "Статус", true);
//                    }
//
//                    if (isConfirmed.equals("подтвержден"))
//                    {
//                        pharmacyManager.getContractsPage().clickRevertAcceptContractButton();
//                        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//                        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
//                        pharmacyManager.getContractsPage().getContractsListContainer().getTable().getAlerts().assertSuccessAlertMessage("Статус Контракта изменён на \"Черновик\"");
//
//                        if (pharmacyManager.getContractsPage().getSpecificationsTable().getCountRowsInTable(true) > 0 && !pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                        {
//                            while (pharmacyManager.getContractsPage().getSpecificationsTable().getCountRowsInTable(true) > 0 && !pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                            {
//                                if (!pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                                {
//                                    pharmacyManager.getContractsPage().getSpecificationsTable().chooseRowInTable(0);
//                                    pharmacyManager.getContractsPage().clickDeleteSpecificationButton();
//                                    pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//                                }
//                            }
//                        }
//
//                        pharmacyManager.getContractsPage().clickDeleteContractButton();
//                        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//                    }
//                    else {
//                        if (pharmacyManager.getContractsPage().getSpecificationsTable().getCountRowsInTable(true) > 0 && !pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                        {
//                            while (pharmacyManager.getContractsPage().getSpecificationsTable().getCountRowsInTable(true) > 0 && !pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                            {
//                                if (!pharmacyManager.getContractsPage().getSpecificationsTable().assertNoRecordsReturnResult())
//                                {
//                                    pharmacyManager.getContractsPage().getSpecificationsTable().chooseRowInTable(0);
//                                    pharmacyManager.getContractsPage().clickDeleteSpecificationButton();
//                                    pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//                                }
//                            }
//                        }
//
//                        List<String> columnValues = pharmacyManager.getContractsPage().getContractsListTable().getColumnValues("Статус");
//                        if (!columnValues.contains("черновик") && !columnValues.contains("подтвержден"))
//                            break;
//
//                        pharmacyManager.getContractsPage().clickDeleteContractButton();
//                        pharmacyManager.getContractsPage().getConfirmModal().clickYes();
//                    }
//                }
//            }
//        }
//    }
}

