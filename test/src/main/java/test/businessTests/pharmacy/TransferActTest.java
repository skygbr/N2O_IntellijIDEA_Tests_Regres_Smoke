package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.TransferActData;
import businessFramework.module.pharmacy.PharmacyManager;
import businessFramework.module.pharmacy.modals.TransferAct.TransferActValues;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActTest extends TestBase implements TransferActValues{
    private TransferActData tActData;
    private PharmacyManager pharmacyManager;

    int transferActRow;
    int specAfterCreateRow;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        pharmacyManager = new PharmacyManager();
        tActData = new TransferActData();

        /** Данные для выбора контекста */
        tActData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для заполнения полей на форме в модальном окне "Акт переброски" */
        tActData.setNumberTA(randomInt(5));
        tActData.setSenderTA("Тестовый_склад_аптека");
        tActData.setRecipientTA("Тестовый_склад_аптека");
        tActData.setFundingTypeTA("test_funding_source");
        //tActData.setNewFundingTypeTA("test_funding_source");
        tActData.setRecipientMOLTA("Автотест-аптека А.А., Врач-автотест аптеки");
        tActData.setCommentTA(randomChar(40));

        /** Данные для проверки данных в полях на форме в модальном окне "Акт переброски" */
        tActData.setDocTypeTA(VALUE_DOC_TYPE);
        tActData.setDateTA(page.getCurrentDate());
        tActData.setChargeOperationTA("Переброска");
        tActData.setArrOperationTA("Переброска");
        tActData.setSenderMOLTA("Автотест-аптека А.А., Врач-автотест аптеки");

        /** При редактировании акта переброски в модальном окне тип документа "Накладная" */
        tActData.setDocTypeForEdit(VALUE_DOC_TYPE);

        /** Данные для редактирования акта переброски ( проверяются при проверке данных в полях, не заполняются при редактировании.*/

        tActData.setNumberTAEdit(randomInt(5));
        tActData.setCommentTAEdit(randomChar(40));

        /** Данные для полей в фильтре. Заполнение при создании спецификации */
        tActData.setNameLS_IMN_F("Тестовая модификация");

        /** Данные для полей в модальном окне "Добавление спецификации" */
        tActData.setNameLS_IMN_spec("Тестовая модификация");
        tActData.setFundingSource_spec("test_funding_source");
        tActData.setCreator_spec("");

        tActData.setCount_spec("1");
        tActData.setMneiCount_spec("1");
        tActData.setMneiCount_specAssert("1");

        /** Данные для проверки значений в столбцах */
        tActData.setSold_spec("1");
        tActData.setUnit_spec("at_mnei");
        tActData.setPriceFormatted_spec("10.000");
        tActData.setSumFormatted_spec("10.000");
        tActData.setPrice_spec("10");
        tActData.setCount_spec("1");
        tActData.setSum_spec("10");
        tActData.setCountEdited_spec("2");
        tActData.setMneiCountEdited_spec("2");
        tActData.setMneiCountEdited_specAssert("2");
        tActData.setSumEdited_spec("20");
        tActData.setSumEdited_spec_formatted("20.000");
    }


    @Test(description = "Открытие модуля 'Акты переброски'")
    public void step1_openTransferActPage()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(tActData.getDepartmentForContext());
        pharmacyManager.openTransferAct();
    }

    @Test (description = "Открытие фильтра и проверка дат в фильтре", dependsOnMethods = "step1_openTransferActPage")
    public void step2_checkDateFieldsInFilter()
    {
        pharmacyManager.getTransferActPage().openFilterForTransferAct();
        pharmacyManager.getTransferActPage().checkDatesValues();
    }

    @Test (description = "Создание акта переброски", dependsOnMethods = "step2_checkDateFieldsInFilter")
    public void step3_creatingTransferAct()
    {
        pharmacyManager.getTransferActPage().clickAddTransferActButton();
        pharmacyManager.getTransferActPage().getTransferActModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getTransferActModal().checkModalHeader(MODAL_HEADER_TRANSFER_ACT);
        pharmacyManager.getTransferActPage().getTransferActModal().fillFields(
                tActData.getNumberTA(), tActData.getSenderTA(), tActData.getSenderMOLTA(), tActData.getRecipientTA(), tActData.getRecipientMOLTA(),
                tActData.getFundingTypeTA(),tActData.getNewFundingTypeTA(), tActData.getCommentTA());
        pharmacyManager.getTransferActPage().getTransferActModal().checkFields(tActData.getDocTypeTA(),tActData.getNumberTA(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getRecipientTA(),
                tActData.getChargeOperationTA(),tActData.getArrOperationTA(),tActData.getSenderMOLTA(), tActData.getRecipientMOLTA(), tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA(), tActData.getCommentTA());
        pharmacyManager.getTransferActPage().getTransferActModal().clickSaveTransferActButton();

        pharmacyManager.getTransferActPage().getTransferActListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListContainer().getTable().getAlerts().assertSuccessAlertMessage("Акт переброски № " + tActData.getNumberTA() + " сохранен");
        transferActRow = pharmacyManager.getTransferActPage().checkTableValues(tActData.getNumberTA(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getArrOperationTA(),
                tActData.getRecipientTA(), tActData.getChargeOperationTA(),null, tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA());
    }

    @Test (description = "Редактирование акта переброски", dependsOnMethods = "step3_creatingTransferAct")
    public void step4_editingTransferAct()
    {
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickEditTransferActButton();
        pharmacyManager.getTransferActPage().getTransferActModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getTransferActModal().checkModalHeader(MODAL_HEADER_TRANSFER_ACT + ": №" + tActData.getNumberTA() + " от " + tActData.getDateTA());
        pharmacyManager.getTransferActPage().getTransferActModal().checkFields(tActData.getDocTypeTA(),tActData.getNumberTA(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getRecipientTA(),
                tActData.getChargeOperationTA(),tActData.getArrOperationTA(),tActData.getSenderMOLTA(), tActData.getRecipientMOLTA(), tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA(), tActData.getCommentTA());

        pharmacyManager.getTransferActPage().getTransferActModal().fillFields(
                tActData.getNumberTAEdit(), tActData.getSenderTA(), tActData.getSenderMOLTA(), tActData.getRecipientTA(), tActData.getRecipientMOLTA(),
                tActData.getFundingTypeTA(),tActData.getNewFundingTypeTA(), tActData.getCommentTAEdit());
        pharmacyManager.getTransferActPage().getTransferActModal().clickSaveTransferActButton();
        pharmacyManager.getTransferActPage().getTransferActListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListContainer().getTable().getAlerts().assertSuccessAlertMessage("Акт переброски № " + tActData.getNumberTAEdit() + " сохранен");
        transferActRow = pharmacyManager.getTransferActPage().checkTableValues(tActData.getNumberTAEdit(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getArrOperationTA(),
                tActData.getRecipientTA(), tActData.getChargeOperationTA(),null, tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA());

        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickEditTransferActButton();
        pharmacyManager.getTransferActPage().getTransferActModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getTransferActModal().checkModalHeader(MODAL_HEADER_TRANSFER_ACT + ": №" + tActData.getNumberTAEdit() + " от " + tActData.getDateTA());
        pharmacyManager.getTransferActPage().getTransferActModal().checkFields(tActData.getDocTypeTA(),tActData.getNumberTAEdit(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getRecipientTA(),
                tActData.getChargeOperationTA(),tActData.getArrOperationTA(),tActData.getSenderMOLTA(), tActData.getRecipientMOLTA(), tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA(), tActData.getCommentTAEdit());
        pharmacyManager.getTransferActPage().getTransferActModal().closeModal();
    }

    @Test (description = "Создание спецификации", dependsOnMethods = "step4_editingTransferAct")
    public void step5_specificationCreate()
    {
        pharmacyManager.getTransferActPage().clickAddSpecificationButton();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().checkFilterFieldsValues(tActData.getStore_F(), tActData.getProductGroup_F(), tActData.getFinSource_F());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().setFilterFieldsValuesAndPressFindBtn(tActData.getNameLS_IMN_F(), null, null, null);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getBatchListTable().chooseRowInTable(0);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().clickAddSpecBatchListBtn();

        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalHeader(String.format("Спецификация акта переброски №%s от %s. Добавление.", tActData.getNumberTAEdit(), tActData.getDateTA()));
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalWindowFieldsValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getFundingSource_spec(), null, null, null, null);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().setModalWindowFieldsValues(tActData.getCount_spec());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalWindowFieldsValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getFundingSource_spec(), tActData.getMneiCount_spec(), null, null, null);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().clickSaveSpecButton();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getBatchListContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getBatchListContainer().getTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");

        specAfterCreateRow = pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().checkTableValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getSold_spec(), tActData.getFundingSource_spec(), tActData.getUnit_spec(), tActData.getPriceFormatted_spec(), tActData.getSumFormatted_spec());

    }

    @Test (description = "Редактирование спецификации", dependsOnMethods = "step5_specificationCreate")
    public void step6_specificationEdit()
    {
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getSpecificationsTable().chooseRowInTable(specAfterCreateRow);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().clickEditSpecButton();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalHeader(String.format("Спецификация акта переброски №%s от %s", tActData.getNumberTAEdit(), tActData.getDateTA()));
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalWindowFieldsValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getFundingSource_spec(), tActData.getMneiCount_specAssert(), tActData.getCount_spec(), tActData.getPrice_spec(), tActData.getSum_spec());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().setModalWindowFieldsValues(tActData.getCountEdited_spec());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalWindowFieldsValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getFundingSource_spec(), tActData.getMneiCountEdited_spec(), tActData.getCountEdited_spec(), tActData.getPrice_spec(), tActData.getSumEdited_spec());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().clickSaveSpecButton();

        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecContainer().getTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecContainer().getTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");

        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getSpecificationsTable().chooseRowInTable(specAfterCreateRow);

        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().clickEditSpecButton();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalHeader(String.format("Спецификация акта переброски №%s от %s", tActData.getNumberTAEdit(), tActData.getDateTA()));
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().checkModalWindowFieldsValues(tActData.getNameLS_IMN_spec(), tActData.getCreator_spec(), tActData.getFundingSource_spec(), tActData.getMneiCountEdited_specAssert(), tActData.getCountEdited_spec(), tActData.getPrice_spec(), tActData.getSumEdited_spec());
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().getTransferActSpecModal().closeModal();
        pharmacyManager.getTransferActPage().getTransferActCreateSpecPage().clickBackButton();
        transferActRow = pharmacyManager.getTransferActPage().checkTableValues(tActData.getNumberTAEdit(), tActData.getDateTA(), tActData.getSenderTA(), tActData.getArrOperationTA(), tActData.getRecipientTA(), tActData.getChargeOperationTA(), null, tActData.getFundingTypeTA(), tActData.getNewFundingTypeTA());
    }

    @Test (description = "Проведение акта переброски", dependsOnMethods = "step6_specificationEdit")
    public void step7_executingTransferAct()
    {
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickExecuteTransferActButton();

        pharmacyManager.getTransferActPage().getExecuteTransferActModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getExecuteTransferActModal().checkModalHeader(String.format("Проводка документа: %s", tActData.getNumberTAEdit()));
        pharmacyManager.getTransferActPage().getExecuteTransferActModal().clickApplyButton();

        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertMessage("Документ проведён");

    }

    @Test (description = "Прием акта переброски", dependsOnMethods = "step7_executingTransferAct")
    public void step8_acceptingTransferAct(){
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickAcceptTransferActButton();

        pharmacyManager.getTransferActPage().getAcceptTransferActModal().assertCountOfModals(1);
        pharmacyManager.getTransferActPage().getAcceptTransferActModal().checkModalHeader(String.format("Прием документа: %s", tActData.getNumberTAEdit()));
        pharmacyManager.getTransferActPage().getAcceptTransferActModal().clickAcceptButton();

        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertMessage("Документ принят");
    }

    @Test (description = "Отмена приема акта переброски", dependsOnMethods = "step8_acceptingTransferAct")
    public void step9_revertAcceptTransferAct(){
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickRevertAcceptTransferActButtonn();
        pharmacyManager.getTransferActPage().getConfirmModal().clickYes();

        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertMessage("Статус документа изменён на \"не принят\"");
    }


    @Test(description = "Отмена проводки акта переброски", dependsOnMethods = "step9_revertAcceptTransferAct")
    public void step10_cancelExecutionTransferAct(){
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickCancelExecutionTransferActButton();
        pharmacyManager.getTransferActPage().getConfirmModal().clickYes();

        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertMessage("Проводка документа отменена");
    }

    @Test (description = "Удаление созданных записей", dependsOnMethods = "step10_cancelExecutionTransferAct", alwaysRun = true)
    public void step11_removeAllCreatedRecords()
    {
        pharmacyManager.getTransferActPage().getTransferActListTable().chooseRowInTable(transferActRow);
        pharmacyManager.getTransferActPage().clickDeleteTransferActButton();
        pharmacyManager.getTransferActPage().getConfirmModal().clickYes();

        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getTransferActPage().getTransferActListTable().getAlerts().assertSuccessAlertMessage("Документ и спецификации удалены");
    }
}
