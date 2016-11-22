package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.FormulaDocumentData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ydolgih
 * @since 31.10.2015
 */

public class FormulaDocumentTest extends TestBase implements Values {

    private FormulaDocumentData docData;
    private PharmacyManager pharmacyManager;

    @BeforeClass
    public void initialize() {
        pharmacyManager = new PharmacyManager();
        docData = new FormulaDocumentData();

        /** Данные для выбора контекста */
        docData.setDepartmentForContext("Отделение экстренной госпитализации");

        docData.setName("new_formula_document");
        docData.setModifName("Тестовая модификация");
        docData.setMneiQuantity("100");
        docData.setNote("note");
        docData.setUnitName("at_mnei");

        docData.setSpecModifName("Тестовая модификация");
        docData.setSpecMneiQuantity("50");
    }

    @Test(description = "Открытие страницы Прописи")
    public void step1_openFormulaDocumentPage() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(docData.getDepartmentForContext());
        pharmacyManager.openFormulaDocuments();
    }

    @Test(description = "Добавление прописи", dependsOnMethods = "step1_openFormulaDocumentPage")
    public void step2_createFormulaDocument() {
        pharmacyManager.getFormulaDocumentPage().clickAddFormulaDocButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocumentModal().fillFields(docData);
        pharmacyManager.getFormulaDocumentPage().getFormulaDocumentModal().clickSaveButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocListTable().chooseRowInTable(pharmacyManager.getFormulaDocumentPage().checkTableValues(docData));
    }

    @Test(description = "Редактирование Прописи", dependsOnMethods = "step2_createFormulaDocument")
    public void step3_updateFormulaDocument() {
        docData.setName("new_formula_document_2");
        docData.setModifName("Тестовая модификация_2");
        docData.setMneiQuantity("200");
        docData.setNote("note_2");
        docData.setUnitName("at_mnei");

        pharmacyManager.getFormulaDocumentPage().clickUpdateFormulaDocButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocumentModal().fillFields(docData);
        pharmacyManager.getFormulaDocumentPage().getFormulaDocumentModal().clickSaveButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocListTable().chooseRowInTable(pharmacyManager.getFormulaDocumentPage().checkTableValues(docData));
    }

    @Test(description = "Добавление спецификации", dependsOnMethods = "step3_updateFormulaDocument")
    public void step4_createFormulaSpec() {
        pharmacyManager.getFormulaDocumentPage().clickAddFormulaSpecButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecModal().fillFields(docData);
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecModal().clickSaveButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecListTable().chooseRowInTable(pharmacyManager.getFormulaDocumentPage().checkSpecTableValues(docData));
    }

    @Test(description = "Редактирование спецификации", dependsOnMethods = "step4_createFormulaSpec")
    public void step5_updateFormulaSpec() {
        docData.setSpecModifName("Тестовая модификация_2");
        docData.setSpecMneiQuantity("200");

        pharmacyManager.getFormulaDocumentPage().clickUpdateFormulaSpecButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecModal().fillFields(docData);
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecModal().clickSaveButton();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecListTable().chooseRowInTable(pharmacyManager.getFormulaDocumentPage().checkSpecTableValues(docData));
    }

    @Test(description = "Удаление спецификации", dependsOnMethods = "step5_updateFormulaSpec")
    public void step6_deleteSpecDocument() {
        pharmacyManager.getFormulaDocumentPage().clickDeleteFormulaSpecButton();
        pharmacyManager.getFormulaDocumentPage().getDialog().clickYes();
        pharmacyManager.getFormulaDocumentPage().getFormulaSpecListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    @Test(description = "Удаление прописи", dependsOnMethods = "step6_deleteSpecDocument")
    public void step7_deleteFormulaDocument() {
        pharmacyManager.getFormulaDocumentPage().clickDeleteFormulaDocButton();
        pharmacyManager.getFormulaDocumentPage().getDialog().clickYes();
        pharmacyManager.getFormulaDocumentPage().getFormulaDocListTable().getAlerts().assertSuccessAlertIsPresent();
    }
}