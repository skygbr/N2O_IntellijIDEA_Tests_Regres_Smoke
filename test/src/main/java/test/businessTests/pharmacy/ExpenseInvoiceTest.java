package test.businessTests.pharmacy;


import businessFramework.entities.pharmacy.ExpenseInvoiceData;
import businessFramework.module.pharmacy.ExpenseInvoiceManager;
import businessFramework.module.pharmacy.modals.ExpenseInvoice.ExpInvoiceValues;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ExpenseInvoiceTest extends TestBase implements ExpInvoiceValues
{
    private ExpenseInvoiceData eIData;
    private ExpenseInvoiceManager eIManager;
    private String copyDocNumber;

    int expInvoiceRow;
    int specAfterCreateRow;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        eIManager = new ExpenseInvoiceManager();
        eIData = new ExpenseInvoiceData();

        /** Данные для выбора контекста */
        eIData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для заполнения полей на форме в модальном окне "Расходная накладная" */
        eIData.setNumberEI("request_document_test");
        eIData.setSenderEI("Тестовый_склад_аптека");
        eIData.setRecipientEI("Тестовый_склад_отделение");
        eIData.setFinancingTypeEI("test_funding_source");
        eIData.setProductGroupEI("Тестовая тов. группа");
        eIData.setRecipientMOLEI("Автотест-аптека А.А., Врач-автотест аптеки");
        eIData.setSenderMOLEI("Автотест-аптека А.А., Врач-автотест аптеки");
        eIData.setCommentEI(randomChar(40));
        String dateString = getFormattedDateString(new Date());
        eIData.setRequireEI("№ request_document_test, " + dateString + ", Тестовый_склад_отделение");
        eIData.setTrustEI("Дов. №test_trust_doc_for_expense, " + "2017-01-01");

        /** Данные для проверки данных в полях на форме "Доверенность" */
        eIData.setTrustDocType("Доверенность");
        eIData.setTrustDocNumber("test_trust_doc_for_expense");
        eIData.setTrustDocIssueDate("01.01.2017");
        eIData.setTrustDocEndDate("01.01.2017");
        eIData.setTrustDocStore("Тестовый_склад_отделение");
        eIData.setTrustDocEmpPos("Автотест-аптека А.А., Врач-автотест аптеки");

        /** Данные для проверки данных в полях на форме в модальном окне "Расходная накладная" */
        eIData.setDocTypeEI(VALUE_DOC_TYPE);
        eIData.setDateEI(page.getCurrentDate());
        eIData.setChargeOperationEI("Расход в отделении");
        eIData.setArrOperationEI("Приход от аптеки");

        /** При редактировании расходной накладной в модальном окне тип документа не "Накладная" а "Расх.накл"*/
        eIData.setDocTypeForEdit(VALUE_DOC_TYPE);

        /** Данные для редактирования расходной накладной ( проверяются при проверке данных в полях, не заполняются при редактировании.*/

        eIData.setNumberEIEdit(randomChar(5));
        eIData.setCommentEIEdit(randomChar(40));

        /** Данные для полей в фильтре. Заполнение при создании спецификации */
        eIData.setNameLS_IMN_F("Тестовая модификация");

        /** Данные для полей в модальном окне "Добавление спецификации" */
        eIData.setNameLS_IMN_spec("Тестовая модификация");
        eIData.setFinancingSource_spec("test_funding_source");

        eIData.setCount_spec("15");
        eIData.setMneiCount_spec("15");
        eIData.setMneiCount_specAssert("15");

        /** Данные для проверки значений в столбцах */
        eIData.setSold_spec("15");
        eIData.setCommonSold_spec("30");
        eIData.setUnit_spec("at_mnei");
        eIData.setPriceFormatted_spec("10.000");
        eIData.setSumFormatted_spec("150.000");
        eIData.setCommonSumFormatted_spec("300.000");
        eIData.setPrice_spec("10");
        eIData.setSum_spec("150");
        eIData.setCountEdited_spec("30");
        eIData.setMneiCountEdited_spec("30");
        eIData.setMneiCountEdited_specAssert("30");
        eIData.setSumEdited_spec("300");
        eIData.setSumEdited_spec_formatted("300.000");
    }

    private String getFormattedDateString(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    @Test(description = "Открытие модуля 'Расходные накладные'")
    public void step1_openExpenseInvoicePage()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(eIData.getDepartmentForContext());
        eIManager.openExpenseInvoice();
    }

    @Test (description = "Открытие фильтра и проверка дат в фильтре", dependsOnMethods = "step1_openExpenseInvoicePage")
    public void step2_checkDateFieldsInFilter()
    {
        eIManager.getExpenseInvoicePage().openFilterForExpInvoice();
        eIManager.getExpenseInvoicePage().checkDatesValues();
    }

    @Test (description = "Создание расходной накладной", dependsOnMethods = "step1_openExpenseInvoicePage")
    public void step3_creatingExpenseInvoice()
    {
        eIManager.getExpenseInvoicePage().clickAddExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkModalHeader(MODAL_HEADER_EXP_INVOICE);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().fillFields(
                eIData.getRequireEI(), null, eIData.getSenderEI(), eIData.getRecipientEI(),
                eIData.getFinancingTypeEI(), eIData.getProductGroupEI(), eIData.getSenderMOLEI(), eIData.getRecipientMOLEI(), null, eIData.getCommentEI(), null, null);
        
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().clickCreateTrustDocument();
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getTrustDocModal().fillFields(null, eIData.getTrustDocNumber(), eIData.getTrustDocIssueDate(), eIData.getTrustDocEndDate(), null, eIData.getTrustDocEmpPos());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getTrustDocModal().checkFields(eIData.getTrustDocType(), eIData.getTrustDocNumber(),
                eIData.getTrustDocIssueDate(), eIData.getTrustDocEndDate(), eIData.getTrustDocStore(), eIData.getTrustDocEmpPos());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getTrustDocModal().clickSaveTrustDocumentButton();

        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkFields(eIData.getDocTypeEI(), eIData.getNumberEI(), eIData.getDateEI(), eIData.getRequireEI(),
                eIData.getTrustEI(), null, eIData.getRecipientEI(), eIData.getChargeOperationEI(), eIData.getArrOperationEI(), eIData.getSenderMOLEI(),
                null, eIData.getFinancingTypeEI(), eIData.getProductGroupEI(), null);

        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().clickSaveExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertMessage("Расходная накладная № " + eIData.getNumberEI() + " сохранена");
        expInvoiceRow = eIManager.getExpenseInvoicePage().checkTableValues(eIData.getNumberEI(), eIData.getDateEI(), eIData.getSenderEI(), eIData.getArrOperationEI(), eIData.getRecipientEI(), eIData.getChargeOperationEI(),null, null);
    }

    @Test (description = "Копирование расходной накладной", dependsOnMethods = "step3_creatingExpenseInvoice")
    public void step4_copyExpenseInvoice()
    {
        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(expInvoiceRow);
        eIManager.getExpenseInvoicePage().clickCopyExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkModalHeader(MODAL_HEADER_EXP_INVOICE);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().assertCopiedValues(null, eIData.getRecipientEI(), eIData.getChargeOperationEI(),eIData.getArrOperationEI(), eIData.getSenderMOLEI(), null, eIData.getFinancingTypeEI(), eIData.getProductGroupEI());
        copyDocNumber = String.valueOf(randomIntInt(10000, 999999));
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getSenderField().setValue(eIData.getSenderEI());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getDocumentTypeField().setValue(eIData.getDocTypeEI());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().getNumberField().setValue(copyDocNumber);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().clickSaveExpInvoiceButton();

        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertMessage("Расходная накладная № " + copyDocNumber + " сохранена");

        eIManager.getExpenseInvoicePage().checkTableValues(copyDocNumber, getCurrentDate(), eIData.getSenderEI(), eIData.getArrOperationEI(), eIData.getRecipientEI(), eIData.getChargeOperationEI(), null, null);
    }

    @Test (description = "Редактирование расходной накладной", dependsOnMethods = "step3_creatingExpenseInvoice")
    public void step5_editingExpenseInvoice()
    {
        if (eIManager.getExpenseInvoicePage().getCountOfModals() > 0)
            eIManager.getExpenseInvoicePage().getModal().closeModal();
        expInvoiceRow = eIManager.getExpenseInvoicePage().checkTableValues(eIData.getNumberEI(), eIData.getDateEI(), eIData.getSenderEI(), eIData.getArrOperationEI(), eIData.getRecipientEI(), eIData.getChargeOperationEI(), null, null);
        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(expInvoiceRow);
        eIManager.getExpenseInvoicePage().clickEditExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkModalHeader(MODAL_HEADER_EXP_INVOICE + ": №" + eIData.getNumberEI() + " от " + eIData.getDateEI());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkFields(
                eIData.getDocTypeForEdit(), eIData.getNumberEI(), eIData.getDateEI(),eIData.getRequireEI(),
                eIData.getTrustEI(), eIData.getSenderEI(), eIData.getRecipientEI(),
                eIData.getChargeOperationEI(),eIData.getArrOperationEI(), eIData.getSenderMOLEI(),
                eIData.getRecipientMOLEI(), eIData.getFinancingTypeEI(), eIData.getProductGroupEI(), eIData.getCommentEI());

        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().fillFields( null, eIData.getNumberEIEdit(),  null, null, null, null, null,null, null, eIData.getCommentEIEdit(), null, null);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().clickSaveExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceListContainer().getTable().getAlerts().assertSuccessAlertMessage("Расходная накладная № " + eIData.getNumberEIEdit() + " сохранена");
        expInvoiceRow = eIManager.getExpenseInvoicePage().checkTableValues(eIData.getNumberEIEdit(), eIData.getDateEI(), eIData.getSenderEI(), eIData.getArrOperationEI(), eIData.getRecipientEI(), eIData.getChargeOperationEI(), null, null);

        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(expInvoiceRow);
        eIManager.getExpenseInvoicePage().clickEditExpInvoiceButton();
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkModalHeader(MODAL_HEADER_EXP_INVOICE + ": №" + eIData.getNumberEIEdit() + " от " + eIData.getDateEI());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().checkFields( eIData.getDocTypeForEdit(), eIData.getNumberEIEdit(),
                eIData.getDateEI(),eIData.getRequireEI(), eIData.getTrustEI(), eIData.getSenderEI(),
                eIData.getRecipientEI(), eIData.getChargeOperationEI(),eIData.getArrOperationEI(), eIData.getSenderMOLEI(),
                eIData.getRecipientMOLEI(), eIData.getFinancingTypeEI(), eIData.getProductGroupEI(), eIData.getCommentEIEdit());
        eIManager.getExpenseInvoicePage().getExpenseInvoiceModal().closeModal();
    }

    @Test (description = "Создание спецификации", dependsOnMethods = "step5_editingExpenseInvoice")
    public void step6_specificationCreate()
    {
        eIManager.getExpenseInvoicePage().clickAddSpecificationButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().checkFilterFieldsValues(eIData.getStore_F(), eIData.getProductGroup_F(), eIData.getFinSource_F());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().setFilterFieldsValuesAndPressFindBtn(eIData.getNameLS_IMN_F(), null, null, null);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getBatchListTable().chooseRowInTable(0);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().clickAddSpecBatchListBtn();

        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalHeader(String.format("Спецификация расходной накладной №%s от %s. Добавление.", eIData.getNumberEIEdit(), eIData.getDateEI()));
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalWindowFieldsValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getFinancingSource_spec(), null, null, null, null);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().setModalWindowFieldsValues(eIData.getCount_spec());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalWindowFieldsValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getFinancingSource_spec(), eIData.getMneiCount_spec(), null, null, null);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().clickSaveSpecButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getBatchListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getBatchListContainer().getTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");

        specAfterCreateRow = eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().checkTableValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getSold_spec(), eIData.getFinancingSource_spec(), eIData.getUnit_spec(), eIData.getPriceFormatted_spec(), eIData.getSumFormatted_spec());
    }

    @Test (description = "Редактирование спецификации", dependsOnMethods = "step6_specificationCreate")
    public void step7_specificationEdit()
    {
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getSpecificationsTable().chooseRowInTable(specAfterCreateRow);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().clickEditSpecButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalHeader(String.format("Спецификация расходной накладной №%s от %s", eIData.getNumberEIEdit(), eIData.getDateEI()));
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalWindowFieldsValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getFinancingSource_spec(), eIData.getMneiCount_specAssert(), eIData.getCount_spec(), eIData.getPrice_spec(), eIData.getSum_spec());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().setModalWindowFieldsValues(eIData.getCountEdited_spec());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalWindowFieldsValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getFinancingSource_spec(), eIData.getMneiCountEdited_spec(), eIData.getCountEdited_spec(), eIData.getPrice_spec(), eIData.getSumEdited_spec());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().clickSaveSpecButton();

        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpSpecContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpSpecContainer().getTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");

        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getSpecificationsTable().chooseRowInTable(specAfterCreateRow);

        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().clickEditSpecButton();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalHeader(String.format("Спецификация расходной накладной №%s от %s", eIData.getNumberEIEdit(), eIData.getDateEI()));
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().checkModalWindowFieldsValues(eIData.getNameLS_IMN_spec(), eIData.getCreator_spec(), eIData.getFinancingSource_spec(), eIData.getMneiCountEdited_specAssert(), eIData.getCountEdited_spec(), eIData.getPrice_spec(), eIData.getSumEdited_spec());
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().getExpInvoiceSpecModal().closeModal();
        eIManager.getExpenseInvoicePage().getExpInvoiceCreateSpecPage().clickBackButton();
        expInvoiceRow = eIManager.getExpenseInvoicePage().checkTableValues(eIData.getNumberEIEdit(), eIData.getDateEI(), eIData.getSenderEI(), eIData.getArrOperationEI(), eIData.getRecipientEI(), eIData.getChargeOperationEI(), eIData.getSumEdited_spec_formatted(), null);
    }

    @Test (description = "Проведение расходной накладной", dependsOnMethods = "step7_specificationEdit")
    public void step8_executingExpInvoice()
    {
        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(expInvoiceRow);
        eIManager.getExpenseInvoicePage().clickExecuteExpInvoiceButton();

        eIManager.getExpenseInvoicePage().getExecuteExpInvoiceModal().assertCountOfModals(1);
        eIManager.getExpenseInvoicePage().getExecuteExpInvoiceModal().checkModalHeader(String.format("Проводка документа: %s", eIData.getNumberEIEdit()));
        eIManager.getExpenseInvoicePage().getExecuteExpInvoiceModal().clickApplyButton();

        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getAlerts().assertSuccessAlertIsPresent();
        eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getAlerts().assertSuccessAlertMessage("Документ проведён");

    }

    @Test (description = "Удаление созданных записей", dependsOnMethods = "step8_executingExpInvoice", alwaysRun = true)
    public void step9_removeAllCreatedRecords()
    {
        eIManager.openExpenseInvoice();
        List<String> documentNumbers = Arrays.asList(eIData.getNumberEI(),eIData.getNumberEIEdit(), copyDocNumber);

        for(String documentNumber : documentNumbers)
        {
            eIManager.getExpenseInvoicePage().openFilterForExpInvoice();
            eIManager.getExpenseInvoicePage().filterExpenseInvoiceByNumber(documentNumber);

            while (eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getCountRowsInTable(true) > 0)
            {
                eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(0);
                List<String> elements = eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getColumnValues("Проведён");

                if (elements.get(0).equals(""))
                {
                    eIManager.getExpenseInvoicePage().clickDeleteExpInvoiceButton();
                    eIManager.getExpenseInvoicePage().getConfirmModal().clickYes();
                } else
                {
                    eIManager.getExpenseInvoicePage().clickCancelExecutionExpInvoiceButton();
                    eIManager.getExpenseInvoicePage().getConfirmModal().clickYes();
                    eIManager.getExpenseInvoicePage().clickDeleteExpInvoiceButton();
                    eIManager.getExpenseInvoicePage().getConfirmModal().clickYes();
                }
            }
        }
    }
}
