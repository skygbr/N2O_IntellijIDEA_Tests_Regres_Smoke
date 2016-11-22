package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.ProdDocData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * @edited by bgaripov 02.09.2016
 */

public class ProductionDocTest extends TestBase implements Values {

    private ProdDocData data;
    private PharmacyManager pharmacyManager;
    public int specModif;

    @BeforeClass
    public void initialize() {
        data = new ProdDocData();
        pharmacyManager = new PharmacyManager();

        /** Данные для выбора контекста */
        data.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для полей модального окна Приходная накладная */

        data.setDocNumber("new_test_production_doc");
        data.setDocDate(page.getCurrentDate());
        data.setDocType("Изгот.");
        data.setBaseDocNumber("new_test_prod_base_doc");
        data.setBaseDocDate(page.getCurrentDate());
        data.setBaseDocType("Изгот.");
        data.setStore("Тестовый_склад_аптека");
        data.setFundSource("test_funding_source");
        data.setArrivalOperation("Приход производство");
        data.setExpOperation("Списание производство");
        data.setModif("Док_на_изготовление_модификация");
        data.setFormulaDoc("Пропись для автотестов");
        data.setMneiQuantity("10");
        data.setQuantity("10");
        data.setPrice("0");
        data.setAmount("0");
        data.setFormattedAmount("0.000");
        data.setSeries("888");
        data.setExpireDate("01.01.2017");
        data.setCertificate("888");
        data.setProductionDate(page.getCurrentDate());
        data.setNote("new_note");
        data.setStatusExecuted("✘");

        /** Данные для полей страницы Спецификация */
        data.setSpecQuantity("10");
        data.setSpecMneiQuantity("10");
        data.setSpecModif("Тестовая модификация");
        data.setSpecProducer("");
        data.setSpecSeries("7777");
        data.setSpecExpireDate("01.01.2017");
        data.setSpecActBalance("100");
        data.setSpecActBalanceMnei("100");
        data.setSpecPrice("10");
        data.setSpecFormattedPrice("10.000");
        data.setSpecPriceUnit("Втор. уп.");
        data.setSpecAmount("100");
        data.setSpecAmountFormatted("100.000");
        data.setSpecFundSource("test_funding_source");
    }

    @Test(description = "Открытие страницы Документы на изготовление")
    public void step1_openProdDocListPage() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(data.getDepartmentForContext());
        pharmacyManager.openProductionDocuments();
    }

    @Test(description = "Добавление документа на изготовление", dependsOnMethods = "step1_openProdDocListPage")
    public void step2_createProductionDocument() {
        pharmacyManager.getProductionDocumentPage().clickAddProdDocButton();
        pharmacyManager.getProductionDocumentPage().getProdDocModal().checkFilledFields(data);
        pharmacyManager.getProductionDocumentPage().getProdDocModal().fillFields(data);
        pharmacyManager.getProductionDocumentPage().getProdDocModal().checkFields(data);
        pharmacyManager.getProductionDocumentPage().getProdDocModal().clickSaveButton();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertMessage("Документ на изготовление № new_test_production_doc сохранен");
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
    }

    @Test(description = "Редактирование документа на изготовление", dependsOnMethods = "step2_createProductionDocument")
    public void step3_updateProductionDocument() {
        pharmacyManager.getProductionDocumentPage().clickUpdateProdDocButton();
        pharmacyManager.getProductionDocumentPage().getProdDocModal().checkFields(data);
        data.setDocNumber("edit_test_production_doc");
        pharmacyManager.getProductionDocumentPage().getProdDocModal().fillFields(data);
        pharmacyManager.getProductionDocumentPage().getProdDocModal().clickSaveButton();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertMessage("Документ на изготовление № edit_test_production_doc сохранен");
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
    }

    @Test(description = "Добавление спецификации", dependsOnMethods = "step3_updateProductionDocument")
    public void step4_createProductionSpec() {
        pharmacyManager.getProductionDocumentPage().clickAddSpecButton();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().openFilterBatchListTable();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().filterBySpecModif(data.getSpecModif());
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getBatchListTable().chooseRowInTable(0);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().clickAddSpecBatchListBtn();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().fillModalFields(data);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().checkModalFieldsValues(data);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().clickSaveButton();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getBatchListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getBatchListTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().checkTableValues(data);
    }

    @Test(description = "Редактирование спецификации", dependsOnMethods = "step4_createProductionSpec")
    public void step5_updateProductionSpec() {
        specModif = pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().checkTableValuesChoiseRow(data.getSpecModif(), data.getSpecSeries(), data.getSpecMneiQuantity(), data.getSpecFormattedPrice(), data.getSpecAmountFormatted());

        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getBatchListTable().chooseRowInTable(0);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getSpecificationsTable().chooseRowInTable(specModif);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().clickUpdateSpecButton();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().checkModalFieldsValues(data);
        data.setSpecMneiQuantity("5");
        data.setSpecAmountFormatted("50.000");
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().fillModalFields(data);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getProdSpecModal().clickSaveButton();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getSpecificationsTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().getSpecificationsTable().getAlerts().assertSuccessAlertMessage("Спецификация сохранена");
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().checkTableValues(data);
        pharmacyManager.getProductionDocumentPage().getProdSpecStoreSupplyPage().clickBackButton();
        data.setFormattedAmount("500.000");
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
    }

    @Test(description = "Проводка документа", dependsOnMethods = "step5_updateProductionSpec")
    public void step6_executeProductionDoc() {
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
        pharmacyManager.getProductionDocumentPage().clickExecuteProdDocButton();
        pharmacyManager.getProductionDocumentPage().getExecuteDocumentModal().assertCountOfModals(1);
        pharmacyManager.getProductionDocumentPage().getExecuteDocumentModal().clickApplyButton();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertMessage("Документ проведён");
    }

    @Test(description = "Отмена проводки документа 'Вернуть'", dependsOnMethods = "step6_executeProductionDoc")
    public void step7_cancelProductionDoc() {
        data.setStatusExecuted("✔");
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
        pharmacyManager.getProductionDocumentPage().clickCancelProdDocButton();
        pharmacyManager.getProductionDocumentPage().getExecuteDocumentModal().assertCountOfModals(1);
        pharmacyManager.getProductionDocumentPage().getConfirmModal().clickYes();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertMessage("Проводка документа отменена");
    }

    @Test(description = "Удаление спецификации", dependsOnMethods = "step7_cancelProductionDoc")
    public void step8_deleteProductionSpec() {
        pharmacyManager.getProductionDocumentPage().getProdSpecListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkSpecTableValues(data));
        pharmacyManager.getProductionDocumentPage().clickDeleteSpecButton();
        pharmacyManager.getProductionDocumentPage().getConfirmModal().clickYes();
        pharmacyManager.getProductionDocumentPage().getProdSpecListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdSpecListTable().getAlerts().assertSuccessAlertMessage("Спецификация удалена");
    }

    @Test(description = "Удаление документа", dependsOnMethods = "step8_deleteProductionSpec")
    public void step9_deleteProductionDoc() {
        data.setStatusExecuted("✘");
        data.setFormattedAmount("0.000");
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().chooseRowInTable(pharmacyManager.getProductionDocumentPage().checkDocTableValues(data));
        pharmacyManager.getProductionDocumentPage().clickDeleteProdDocButton();
        pharmacyManager.getProductionDocumentPage().getConfirmModal().clickYes();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getProductionDocumentPage().getProdDocListTable().getAlerts().assertSuccessAlertMessage("Документ и спецификации удалены");
    }
}