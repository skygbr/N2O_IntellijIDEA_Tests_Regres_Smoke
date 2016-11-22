package test.businessTests.pharmacy.refbook;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ydolgih on 12.01.2016.
 */

public class ProcurementMethodTest extends TestBase implements Values {
    private String name;
    private String code;
    private String departmentForContext;
    private PharmacyManager pharmacyManager;

    @BeforeClass
    public void initialize() {
        pharmacyManager = new PharmacyManager();
        name = "test_procurement_method_name";
        code = "test_code";
        departmentForContext = "Отделение экстренной госпитализации";
    }

    @Test(description = "Открытие страницы Справочники-Способы закупки")
    public void step1_openProcurementMethodListPage() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(departmentForContext);
        pharmacyManager.openProcurementMethodRefbook();
    }

    @Test(description = "Способы закупки. Добавление записи", dependsOnMethods = "step1_openProcurementMethodListPage")
    public void step2_createProcurementMethod() {
        pharmacyManager.getProcurementMethodRefbookPage().clickCreateButton();
        pharmacyManager.getProcurementMethodRefbookPage().isPresentModal();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodModal().fillFields(code, name);
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodModal().clickSaveButton();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().getAlerts().isAlertPresent();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().chooseRowInTable
                (pharmacyManager.getProcurementMethodRefbookPage().getRecordInTable(code, name));
    }

    @Test(description = "Способы закупки. Редактирование записи", dependsOnMethods = "step2_createProcurementMethod")
    public void step3_updateProcurementMethod() {
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().chooseRowInTable
                (pharmacyManager.getProcurementMethodRefbookPage().getRecordInTable(code, name));
        pharmacyManager.getProcurementMethodRefbookPage().clickUpdateButton();
        pharmacyManager.getProcurementMethodRefbookPage().isPresentModal();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodModal().checkFields(code, name);
        code = "test_code_edit";
        name = "test_procurement_method_edit";
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodModal().fillFields(code, name);
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodModal().clickSaveButton();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().getAlerts().isAlertPresent();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().chooseRowInTable
                (pharmacyManager.getProcurementMethodRefbookPage().getRecordInTable(code, name));
    }

    @Test(description = "Способы закупки. Удаление записи", dependsOnMethods = "step3_updateProcurementMethod")
    public void step4_deleteProcurementMethod() {
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().chooseRowInTable
                (pharmacyManager.getProcurementMethodRefbookPage().getRecordInTable(code, name));
        pharmacyManager.getProcurementMethodRefbookPage().clickDeleteButton();
        pharmacyManager.getProcurementMethodRefbookPage().getDialog().clickYes();
        pharmacyManager.getProcurementMethodRefbookPage().getProcurementMethodListTable().getAlerts().assertSuccessAlertMessage("Данные удалены");
    }
}