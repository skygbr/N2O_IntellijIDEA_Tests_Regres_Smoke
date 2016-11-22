package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.ArrivalInvoiceData;
import businessFramework.entities.pharmacy.ExpenseInvoiceData;
import businessFramework.entities.pharmacy.HoldingProducerData;
import businessFramework.module.pharmacy.ExpenseInvoiceManager;
import businessFramework.module.pharmacy.PharmacyManager;
import businessFramework.module.pharmacy.modals.ArrivalInvoice.ArrivalInvoiceValues;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ArrivalInvoiceTest extends TestBase implements ArrivalInvoiceValues
{
    private ArrivalInvoiceData aIData;
    private ExpenseInvoiceData expInvoiceData;
    private PharmacyManager pharmacyManager;
    private ExpenseInvoiceManager eIManager;
    private int rowSpecifications;
    private int row;
    private String docNumForCopy;
    private String copyDocNumber;


    @BeforeClass
    public void initialize()
    {
        aIData = new ArrivalInvoiceData();
        aIData.setHoldingProducerData(new HoldingProducerData());
        pharmacyManager = new PharmacyManager();
        eIManager = new ExpenseInvoiceManager();

        /** Данные для выбора контекста */
        aIData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для полей модального окна Приходная накладная */
        aIData.setInvoiceExtDoсType(VALUE_EXT_DOC_TYPE);
        aIData.setInvoiceExtDocNumber("Автотест внешний номер 1");
        aIData.setInvoiceNoContractExtDocNumber("Автотест внешний номер 1 без контракта");
        aIData.setInvoiceExtDocDate(page.getCurrentDate());
        aIData.setInvoiceIntDoсType(VALUE_INT_DOC_TYPE);
        aIData.setInvoiceIntDocNumber("Автотест внутренний номер 1");
        aIData.setInvoiceNoContractIntDocNumber("Автотест внутренний номер 1 без контракта");
        aIData.setInvoiceIntDocDate(page.getCurrentDate());
        aIData.setInvoiceContractor("Тестовый поставщик");
        aIData.setInvoiceNoContractor("Контрольная МО");
        aIData.setInvoiceShipper("Контрольная МО");
        aIData.setInvoiceRecipient("Тестовый_склад_аптека");
        aIData.setInvoiceStoreOperation("Приход от поставщика");
        aIData.setInvoiceFundSource("test_funding_source");
        aIData.setInvoiceAmountPlanned("100");
        aIData.setInvoiceAmountFact("0");
        aIData.setInvoiceAmountFactEdited("0");
        aIData.setInvoiceNote("Тестовая запись");
        aIData.setInvoiceContract("Контр.Контракт для автотеста, 01.01.2014");
        aIData.setInvoiceChangedExtDocNumber("Автотест внешний номер 2");
        aIData.setInvoiceChangedIntDocNumber("Автотест внутренний номер 2");
        aIData.setInvoiceNoContractChangedExtDocNumber("Автотест внешний номер 2 без контракта");
        aIData.setInvoiceNoContractChangedIntDocNumber("Автотест внутренний номер 2 без контракта");
        aIData.setInvoiceChangedNote("Измененная тестовая запись");
        aIData.setInvoiceChargeOperation("Тестовая операция");
        aIData.setInvoiceArrivalOperation("Тестовая операция");
        aIData.setProcurementMethod("test_method");

        /** Данные для проверки записи в таблице Приходные накладные */
        aIData.setInvoiceTableExtInvoice("Тов.Автотест внешний номер 1, " + getFormattedDateString(getCurrentDate()));
        aIData.setInvoiceNoContractTableExtInvoice("Тов.Автотест внешний номер 1 без контракта, " + getFormattedDateString(getCurrentDate()));
        aIData.setInvoiceTableAmountPlanned("100.000");
        aIData.setInvoiceTableChangedExtInvoice("Тов.Автотест внешний номер 2, " + getFormattedDateString(getCurrentDate()));
        aIData.setInvoiceNoContractTableChangedExtInvoice("Тов.Автотест внешний номер 2 без контракта, " + getFormattedDateString(getCurrentDate()));

        aIData.setInvoiceTableStatusExecuted("✔");

        /** Данные для полей страницы Спецификация */
        aIData.setSpecificationNDS("10");
        aIData.setSpecificationMargin("10");
        aIData.setSpecificationContractModification("Тестовая модификация,цена:1.10000 руб.");
        aIData.setSpecificationModification("Тестовая модификация");
        aIData.setSpecificationProducer("АДМ Евразия ООО");
        aIData.setSpecificationSeries("789");
        aIData.setSpecificationCertificate("789789");
        aIData.setSpecificationExpireDate("01.01.2025");
        aIData.setSpecificationProductionDate(page.getCurrentDate());
        aIData.setSpecificationCountry("Российская федерация");
        aIData.setSpecificationQuantity("10");
        aIData.setSpecificationMneiQuantity("10");
        aIData.setSpecificationAmountWithNDS("11");
        aIData.setSpecificationAmount("10.00");
        aIData.setSpecificationAmountWithMargin("11.00");
        aIData.setSpecificationPriceWithNDS("1.10000");
        aIData.setSpecificationPrice("1.00000");
        aIData.setSpecificationPriceWithMargin("1.10000");
        aIData.setSpecificationChangedSeries("456");
        aIData.setSpecificationChangedCertificate("456456");

        /** Данные для полей модального окна редактирования спецификации **/
        aIData.setSpecificationEditQuantity("10");
        aIData.setSpecificationEditMneiQuantity("10");
        aIData.setSpecificationEditAmountWithNDS("11");
        aIData.setSpecificationEditAmount("10.00");
        aIData.setSpecificationEditAmountWithMargin("11.00");
        aIData.setSpecificationEditPriceWithNDS("1.1");
        aIData.setSpecificationEditPrice("1.00000");
        aIData.setSpecificationEditPriceWithMargin("1.10000");

        /** Данные для полей страницы Производитель*/
        aIData.getHoldingProducerData().setOrganization("АДМ Евразия ООО");
        aIData.getHoldingProducerData().setOrganizationName("АДМ Евразия ООО");
        aIData.getHoldingProducerData().setRegCertNumber(randomInt(7));
        aIData.getHoldingProducerData().setCodeRls(randomInt(7) + "ABC");
        aIData.getHoldingProducerData().setRegCertDateStart(page.getCurrentDate());
        aIData.getHoldingProducerData().setRegCertDateEnd(page.addDays(page.getCurrentDate(), 1));
        /** убрал заполнение штрих-кода*/
        //aIData.getHoldingProducerData().setEanCode(selectRandomNumbers(9));
        aIData.getHoldingProducerData().setLimitPrice("1000");
        aIData.getHoldingProducerData().setDecisionNumber("100");
        aIData.getHoldingProducerData().setPriceDate(page.getCurrentDate());
        aIData.getHoldingProducerData().setCertificateNumber(randomInt(9));

        /** Данные для проверки записи в таблице Спецификации */
        aIData.setSpecificationTableMeasure("at_mnei");
        aIData.setSpecificationTablePrice("1.100");
        aIData.setSpecificationTableContractPrice("1.100");
        aIData.setSpecificationTableAmount("11.000");


        /** Данные для проверки заголовка модального окна "Спецификация" */
        aIData.setSpecificationsModalHeader("Спецификация");
        aIData.setInvoiceExecutionModalHeader("Проводка документа: " + aIData.getInvoiceChangedIntDocNumber());
        aIData.setInvoiceExecutionNoContractModalHeader("Проводка документа: " + aIData.getInvoiceNoContractChangedIntDocNumber());

        /**Данные для алертов(уведомлений об успешном сохранении и тд) */
        aIData.setSuccessSaveAlertMessage("Данные сохранены");
        aIData.setSuccessDeleteAlertMessage("Документ и спецификации удалены");
        aIData.setSuccessExecutionAlertMessage("Документ проведён");
        aIData.setSuccessCancelExecutionAlertMessage("Проводка документа отменена");
        aIData.setSuccessArrivalInvoiceCreationAlertMessage("Приходная накладная № " + aIData.getInvoiceIntDocNumber() + " сохранена");
        aIData.setSuccessChangedArrivalInvoiceCreationAlertMessage("Приходная накладная № " + aIData.getInvoiceChangedIntDocNumber() + " сохранена");
        aIData.setSuccessArrivalInvoiceNoContractCreationAlertMessage("Приходная накладная № " + aIData.getInvoiceNoContractIntDocNumber() + " сохранена");
        aIData.setSuccessChangedArrivalInvoiceNoContractCreationAlertMessage("Приходная накладная № " + aIData.getInvoiceNoContractChangedIntDocNumber() + " сохранена");

        /**Данные для модального окна Расходной накладной, созданной на основе приходной*/
        expInvoiceData = new ExpenseInvoiceData();
        expInvoiceData.setExpInvBasedOnArrInvModalHeader("Добавление Расходной накладной на основе Приходной");
        expInvoiceData.setNumberEI("based_on_arrival_invoice");
        expInvoiceData.setNumberEIEdit("based_on_arrival_invoice");

        /** Поля остатков по спецификации контракта*/
        aIData.setContrSpecDeliveredQuantity("Поставлено: 0 at_mnei");
        aIData.setContrSpecRestQuantity("Остаток: 10 at_mnei");
    }

    private String getFormattedDateString(String date_usualFormat)
    {
        try {
            DateFormat formatter_usual = new SimpleDateFormat("dd.MM.yyyy");
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter_usual.parse(date_usualFormat);
            return formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Test(description = "Открытие страницы Приходные накладные и проверка фильтра")
    public void step1_openArrivalInvoicePageAndAssertFilter()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(aIData.getDepartmentForContext());
        pharmacyManager.openArrivalInvoices();
        pharmacyManager.getArrivalInvoicePage().openFilterForArrInvoice();
        pharmacyManager.getArrivalInvoicePage().checkFilterDatesValues();
        pharmacyManager.getArrivalInvoicePage().openFilterForArrInvoice();
    }

    @Test(description = "Создание Приходной накладной: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step1_openArrivalInvoicePageAndAssertFilter")
public void step2_createArrivalInvoice()
{
    pharmacyManager.getArrivalInvoicePage().clickAddArrInvoiceButton();
    pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillFields(aIData.getInvoiceExtDocNumber(),
            aIData.getInvoiceIntDocNumber(), aIData.getInvoiceContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
            aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceContract(), aIData.getInvoiceNote(), aIData.getProcurementMethod());

    pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().checkFields(aIData.getInvoiceExtDoсType(),
            aIData.getInvoiceExtDocNumber(), aIData.getInvoiceExtDocDate(), aIData.getInvoiceIntDoсType(), aIData.getInvoiceIntDocNumber(),
            aIData.getInvoiceIntDocDate(), aIData.getInvoiceContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
            aIData.getInvoiceStoreOperation(), aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceAmountFact(), aIData.getInvoiceContract(),
            aIData.getInvoiceNote(),  aIData.getProcurementMethod());

    pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
    pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
    pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessArrivalInvoiceCreationAlertMessage());

    pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceIntDocNumber(),
            aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null,
            aIData.getInvoiceContract(), aIData.getInvoiceTableExtInvoice(), aIData.getInvoiceFundSource()));
}

    @Test(description = "Копирование Приходной накладной: Нажатие на кнопку, проверка автозаполнения полей, сохранение и выбор созданной строки", dependsOnMethods = "step2_createArrivalInvoice")
    public void step3_copyArrivalInvoice()
    {
        docNumForCopy =  randomInt(1000000, 99999999, 7);
        pharmacyManager.getArrivalInvoicePage().clickCopyArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().assertModalPresentOnPage(true);
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().assertCopiedFields(aIData);
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillFields(docNumForCopy,
                docNumForCopy, null, aIData.getInvoiceShipper(), null, null, aIData.getInvoiceAmountPlanned(), null, aIData.getInvoiceNote(),  aIData.getProcurementMethod());
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage("Приходная накладная № " + docNumForCopy + " сохранена");

        pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(docNumForCopy,
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null,
                null, "Тов." + docNumForCopy + ", " + getFormattedDateString(aIData.getInvoiceIntDocDate()) , aIData.getInvoiceFundSource());
    }

    @Test(description = "Редактирование Приходной накладной: Нажатие на кнопку, проверка заполненности, заполнение полей, сохранение и выбор отредактированной строки", dependsOnMethods = "step2_createArrivalInvoice")
    public void step4_editArrivalInvoice()
    {
        pharmacyManager.getArrivalInvoicePage().closeAllModalsOnPage();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null,
                aIData.getInvoiceContract(), aIData.getInvoiceTableExtInvoice(), aIData.getInvoiceFundSource()));

        pharmacyManager.getArrivalInvoicePage().clickEditArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().checkFields(aIData.getInvoiceExtDoсType(),
                aIData.getInvoiceExtDocNumber(), aIData.getInvoiceExtDocDate(), aIData.getInvoiceIntDoсType(), aIData.getInvoiceIntDocNumber(),
                aIData.getInvoiceIntDocDate(), aIData.getInvoiceContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
                aIData.getInvoiceStoreOperation(), aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceAmountFactEdited(), aIData.getInvoiceContract(),
                aIData.getInvoiceNote(),  aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillFields(aIData.getInvoiceChangedExtDocNumber(), aIData.getInvoiceChangedIntDocNumber(), null, null, null, null, null, null, aIData.getInvoiceChangedNote(),  aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessChangedArrivalInvoiceCreationAlertMessage());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceChangedIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null, aIData.getInvoiceContract(), aIData.getInvoiceTableChangedExtInvoice(), aIData.getInvoiceFundSource()));
    }

    @Test(description = "Создание Спецификации: Нажатие на кнопку, заполнение полей, проверка заполненности, выбор созданной приходной накладной в таблице и проверка записи созданной спецификации", dependsOnMethods = "step4_editArrivalInvoice")
    public void step5_createSpecification()
    {
        pharmacyManager.getArrivalInvoicePage().clickAddSpecificationButton();

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().fillFields(aIData.getSpecificationNDS(),
                aIData.getSpecificationMargin(), aIData.getSpecificationModification(), aIData.getSpecificationModification(),
                aIData.getSpecificationProducer(), aIData.getSpecificationCountry(), aIData.getSpecificationSeries(), aIData.getSpecificationExpireDate(),
                aIData.getSpecificationProductionDate(), aIData.getSpecificationCertificate(), aIData.getSpecificationQuantity(), aIData.getSpecificationAmountWithNDS());
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().getProducer().getButton("AddHoldProducer").click();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().getHoldingProducerModel().fillHoldingProducerForm(aIData.getHoldingProducerData());//
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().getHoldingProducerModel().clickSaveHoldingProducer();

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().checkFields(aIData.getSpecificationNDS(),
                aIData.getSpecificationMargin(), aIData.getSpecificationContractModification(), aIData.getSpecificationModification(),
                aIData.getSpecificationProducer(), aIData.getSpecificationCountry(), aIData.getSpecificationSeries(), aIData.getSpecificationExpireDate(),
                aIData.getSpecificationProductionDate(), aIData.getSpecificationCertificate(), aIData.getSpecificationQuantity(), aIData.getSpecificationMneiQuantity(),
                aIData.getSpecificationAmountWithNDS(), aIData.getSpecificationAmount(), aIData.getSpecificationAmountWithMargin(), aIData.getSpecificationPriceWithNDS(),
                aIData.getSpecificationPrice(), aIData.getSpecificationPriceWithMargin(), aIData.getContrSpecDeliveredQuantity(), aIData.getContrSpecRestQuantity());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationsPage().clickSaveSpecificationButton();
        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessSaveAlertMessage());


        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceChangedIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null, aIData.getInvoiceContract(), aIData.getInvoiceTableChangedExtInvoice(), aIData.getInvoiceFundSource()));

        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkSpecificationsTableValues(aIData.getSpecificationModification(),aIData.getSpecificationProducer(), aIData.getSpecificationSeries(), aIData.getSpecificationExpireDate(),aIData.getSpecificationEditQuantity(), aIData.getSpecificationTableMeasure(),aIData.getSpecificationTablePrice(), aIData.getSpecificationTableContractPrice(), aIData.getSpecificationTableAmount()));
    }

    @Test(description = "Редактирование Спецификации: Нажатие на кнопку, проверка заполненности, заполнение полей, выбор созданной приходной накладной в таблице и проверка записи отредактированной спецификации", dependsOnMethods = "step5_createSpecification")
    public void step6_editSpecification()
    {
        pharmacyManager.getArrivalInvoicePage().clickUpdateSpecificationButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationModal().checkModalHeader(aIData.getSpecificationsModalHeader());
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationModal().checkFields(aIData.getSpecificationNDS(),
                aIData.getSpecificationMargin(), aIData.getSpecificationContractModification(), aIData.getSpecificationModification(),
                aIData.getSpecificationProducer(), aIData.getSpecificationCountry(),
                aIData.getSpecificationSeries(), aIData.getSpecificationExpireDate(),
                aIData.getSpecificationProductionDate(), aIData.getSpecificationCertificate(),
                aIData.getSpecificationQuantity(), aIData.getSpecificationEditMneiQuantity(),
                aIData.getSpecificationEditAmountWithNDS(), aIData.getSpecificationEditAmount(),
                aIData.getSpecificationEditAmountWithMargin(), aIData.getSpecificationEditPriceWithNDS(),
                aIData.getSpecificationEditPrice(), aIData.getSpecificationEditPriceWithMargin(), aIData.getContrSpecDeliveredQuantity(),aIData.getContrSpecRestQuantity());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationModal().fillFields(null, null, null, null, null, null, aIData.getSpecificationChangedSeries(), null, null, aIData.getSpecificationChangedCertificate(), null, null);

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceSpecificationModal().clickSaveSpecificationButton();
        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().getAlerts().assertSuccessAlertIsPresent();

        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessSaveAlertMessage());

        row = pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceChangedIntDocNumber(), aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceContractor(), aIData.getInvoiceTableAmountPlanned(), null, aIData.getInvoiceContract(), aIData.getInvoiceTableChangedExtInvoice(), aIData.getInvoiceFundSource());
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(row);

        rowSpecifications = pharmacyManager.getArrivalInvoicePage().checkSpecificationsTableValues(aIData.getSpecificationModification(), aIData.getSpecificationProducer(), aIData.getSpecificationChangedSeries(), aIData.getSpecificationExpireDate(), aIData.getSpecificationEditQuantity(), aIData.getSpecificationTableMeasure(),aIData.getSpecificationTablePrice(), aIData.getSpecificationTableContractPrice(), aIData.getSpecificationTableAmount());
        pharmacyManager.getArrivalInvoicePage().getSpecificationsListTable().chooseRowInTable(rowSpecifications);
    }


    @Test(description = "Проведение Приходной накладной: Нажатие на кнопку и принятие диалогового окна", dependsOnMethods = "step6_editSpecification")
    public void step7_executeArrivalInvoice()
    {
        pharmacyManager.getArrivalInvoicePage().clickExecuteArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getExecuteArrivalInvoiceModal().assertCountOfModals(1);
        pharmacyManager.getArrivalInvoicePage().getExecuteArrivalInvoiceModal().checkModalHeader(aIData.getInvoiceExecutionModalHeader());
        pharmacyManager.getArrivalInvoicePage().getExecuteArrivalInvoiceModal().clickApplyButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessExecutionAlertMessage());
    }

    @Test(description = "Создание Расходной накладной на основе приходной: Нажатие на кнопку и открытие диалогового окна", dependsOnMethods = "step7_executeArrivalInvoice")
    public void step8_createExpInvoiceBasedOnArrInvoice() {
        pharmacyManager.getArrivalInvoicePage().clickCreateExpInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getCreateExpInvoiceModal().assertCountOfModals(1);
        pharmacyManager.getArrivalInvoicePage().getCreateExpInvoiceModal().checkModalHeader(expInvoiceData.getExpInvBasedOnArrInvModalHeader());
        pharmacyManager.getArrivalInvoicePage().getCreateExpInvoiceModal().assertValuesFromArrivalInvoice(aIData.getInvoiceRecipient());
        pharmacyManager.getArrivalInvoicePage().getCreateExpInvoiceModal().fillFields(null, expInvoiceData.getNumberEI(), aIData.getInvoiceRecipient(), aIData.getInvoiceRecipient(), null,null, null, null, null, null, aIData.getInvoiceChargeOperation(), aIData.getInvoiceArrivalOperation());
        pharmacyManager.getArrivalInvoicePage().getCreateExpInvoiceModal().clickSaveExpInvoiceButton();

        eIManager.openExpenseInvoice();
        eIManager.getExpenseInvoicePage().getTableRecordByNumber(expInvoiceData.getNumberEI());
    }

    @Test(description = "Добавление Приходной накладной без Контракта/Договора: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step8_createExpInvoiceBasedOnArrInvoice", enabled = false)
    public void step9_createArrivalNoContractInvoice()
    {
        pharmacyManager.getArrivalInvoicePage().clickAddArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillNoContractFields(aIData.getInvoiceNoContractExtDocNumber(),
                aIData.getInvoiceNoContractIntDocNumber(), aIData.getInvoiceNoContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
                aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceNote(), aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().checkNoContractFields(aIData.getInvoiceExtDoсType(),
                aIData.getInvoiceNoContractExtDocNumber(), aIData.getInvoiceExtDocDate(), aIData.getInvoiceIntDoсType(), aIData.getInvoiceNoContractIntDocNumber(),
                aIData.getInvoiceIntDocDate(), aIData.getInvoiceNoContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
                aIData.getInvoiceStoreOperation(), aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceAmountFact(),
                aIData.getInvoiceNote(),  aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessArrivalInvoiceNoContractCreationAlertMessage());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceNoContractIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceNoContractor(), aIData.getInvoiceTableAmountPlanned(), null, null,
                aIData.getInvoiceNoContractTableExtInvoice(), aIData.getInvoiceFundSource()));
    }

    @Test(description = "Копирование Приходной накладной без контракта: Нажатие на кнопку, проверка автозаполнения полей, сохранение и выбор созданной строки", dependsOnMethods = "step9_createArrivalNoContractInvoice", enabled = false)
    public void step10_copyArrivalNoContractInvoice()
    {
        docNumForCopy =  randomInt(1000000, 99999999, 7);
        pharmacyManager.getArrivalInvoicePage().clickCopyArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().assertModalPresentOnPage(true);
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().assertNoContractCopiedFields(aIData);
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillNoContractFields(docNumForCopy,
                docNumForCopy, null, aIData.getInvoiceShipper(), null, null, aIData.getInvoiceAmountPlanned(), aIData.getInvoiceNote(),  aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage("Приходная накладная № " + docNumForCopy + " сохранена");

        pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(docNumForCopy,
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceNoContractor(), aIData.getInvoiceTableAmountPlanned(), null,
                null, "Тов." + docNumForCopy + ", " + getFormattedDateString(aIData.getInvoiceIntDocDate()) , aIData.getInvoiceFundSource());
    }

    @Test(description = "Редактирование Приходной накладной без контракта: Нажатие на кнопку, проверка заполненности, заполнение полей, сохранение и выбор отредактированной строки", dependsOnMethods = "step10_copyArrivalNoContractInvoice", enabled = false)
    public void step11_editArrivalNoContractInvoice()
    {
        pharmacyManager.getArrivalInvoicePage().closeAllModalsOnPage();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceNoContractIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceNoContractor(), aIData.getInvoiceTableAmountPlanned(), null,
                null, aIData.getInvoiceNoContractTableExtInvoice(), aIData.getInvoiceFundSource()));

        pharmacyManager.getArrivalInvoicePage().clickEditArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().checkNoContractFields(aIData.getInvoiceExtDoсType(),
                aIData.getInvoiceNoContractExtDocNumber(), aIData.getInvoiceExtDocDate(), aIData.getInvoiceIntDoсType(), aIData.getInvoiceNoContractIntDocNumber(),
                aIData.getInvoiceIntDocDate(), aIData.getInvoiceNoContractor(), aIData.getInvoiceShipper(), aIData.getInvoiceRecipient(),
                aIData.getInvoiceStoreOperation(), aIData.getInvoiceFundSource(), aIData.getInvoiceAmountPlanned(), aIData.getInvoiceAmountFactEdited(),
                aIData.getInvoiceNote(),  aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().fillNoContractFields(aIData.getInvoiceNoContractChangedExtDocNumber(), aIData.getInvoiceNoContractChangedIntDocNumber(), null, null, null, null, null, aIData.getInvoiceChangedNote(), aIData.getProcurementMethod());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoiceModal().clickSaveArrInvoiceButton();
        pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessChangedArrivalInvoiceNoContractCreationAlertMessage());

        pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(pharmacyManager.getArrivalInvoicePage().checkInvoiceTableValues(aIData.getInvoiceNoContractChangedIntDocNumber(),
                aIData.getInvoiceIntDocDate(), null, aIData.getInvoiceRecipient(), aIData.getInvoiceNoContractor(), aIData.getInvoiceTableAmountPlanned(), null, null, aIData.getInvoiceNoContractTableChangedExtInvoice(), aIData.getInvoiceFundSource()));
    }

    @Test(description = "Удаление созданных приходных и расходнных накладных", dependsOnMethods = "step8_createExpInvoiceBasedOnArrInvoice", alwaysRun = true)
    public void step12_deleteArrival_ExpenseInvoice()
    {
        pharmacyManager.openArrivalInvoices();
        List<String> documentNumbers =  Arrays.asList(aIData.getInvoiceIntDocNumber(), aIData.getInvoiceChangedIntDocNumber(), aIData.getInvoiceNoContractIntDocNumber(), aIData.getInvoiceNoContractChangedIntDocNumber(), docNumForCopy);
        for(String documentNumber : documentNumbers)
        {
            pharmacyManager.getArrivalInvoicePage().openFilterForArrInvoice();
            pharmacyManager.getArrivalInvoicePage().filterArrivalInvoiceByNumber(documentNumber);

            while (pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getCountRowsInTable(true)>0)
            {
                pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().chooseRowInTable(0);
                if(pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getRowColumnIntersectionValue(0,"",true).equals(aIData.getInvoiceTableStatusExecuted()))
                {
                    pharmacyManager.getArrivalInvoicePage().clickCancelExecutionArrInvoiceButton();
                    pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();
                    pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
                    pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessCancelExecutionAlertMessage());
                }
                pharmacyManager.getArrivalInvoicePage().clickDeleteArrInvoiceButton();
                pharmacyManager.getArrivalInvoicePage().getDialog().clickYes();
                pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertIsPresent();
                pharmacyManager.getArrivalInvoicePage().getArrivalInvoicesTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessDeleteAlertMessage());
            }
        }

        eIManager.openExpenseInvoice();
        List<String> documentNumbersExp = Arrays.asList(expInvoiceData.getNumberEI(),expInvoiceData.getNumberEIEdit(), copyDocNumber);

        for(String documentNumberE : documentNumbersExp)
        {
            eIManager.getExpenseInvoicePage().openFilterForExpInvoice();
            eIManager.getExpenseInvoicePage().filterExpenseInvoiceByNumber(documentNumberE);

            while (eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getCountRowsInTable(true) > 0) {
                eIManager.getExpenseInvoicePage().getExpInvoiceListTable().chooseRowInTable(0);
                eIManager.getExpenseInvoicePage().clickDeleteExpInvoiceButton();
                eIManager.getExpenseInvoicePage().getConfirmModal().clickYes();
                eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getAlerts().assertSuccessAlertIsPresent();
                eIManager.getExpenseInvoicePage().getExpInvoiceListTable().getAlerts().assertSuccessAlertMessage(aIData.getSuccessDeleteAlertMessage());
            }
        }
    }
}