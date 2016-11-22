package test.businessTests.pharmacy.refbook;

import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ydolgih
 * @since 23.09.2015
 */
public class WriteOffReasonTest extends TestBase {

    private PharmacyManager pharmacyManager;
    String departmentForContext;
    String shortName;
    String fullName;
    String orgName;
    String shortNameEdited;
    String fullNameEdited;


    @BeforeClass
    public void initialize() {

        pharmacyManager = new PharmacyManager();
        departmentForContext = "Отделение экстренной госпитализации";
        shortName = "autotest_write_of_reason_short_name";
        fullName = "autotest_write_of_reason_full_name";
        orgName = "Стационар для автотестов";

        shortNameEdited = "autotest_edited_write_of_reason_short_name";
        fullNameEdited = "autotest_edited_write_of_reason_full_name";
    }

    @Test(description = "Открытие страницы Справочники - Причины списания")
    public void step1_openWriteOffReasonListPage() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(departmentForContext);
        pharmacyManager.openWriteOffReasonListPage();
    }

    @Test(description = "Добавление Причины списания", dependsOnMethods = "step1_openWriteOffReasonListPage")
    public void step2_createWriteOffReason() {
        pharmacyManager.getWriteOffReasonListPage().clickCreateButton();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonFormModal().fillFields(orgName, shortName, fullName);
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonFormModal().clickSaveWriteOffReasonButton();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().chooseRowInTable(pharmacyManager.getWriteOffReasonListPage().checkWriteOffReasonTableValues(shortName));
    }

    @Test(description = "Редактирование Причины списания", dependsOnMethods = "step2_createWriteOffReason")
    public void step3_updateWriteOffReason() {
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().chooseRowInTable(pharmacyManager.getWriteOffReasonListPage().checkWriteOffReasonTableValues(shortName));
        pharmacyManager.getWriteOffReasonListPage().clickEditButton();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonFormModal().fillFields(orgName, shortNameEdited, fullNameEdited);
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonFormModal().clickSaveWriteOffReasonButton();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().getAlerts().assertSuccessAlertIsPresent();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().chooseRowInTable(pharmacyManager.getWriteOffReasonListPage().checkWriteOffReasonTableValues(shortNameEdited));
    }

    @Test(description = "Удаление Причины списания", dependsOnMethods = "step3_updateWriteOffReason")
    public void step4_deleteWriteOffReason() {
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().chooseRowInTable(pharmacyManager.getWriteOffReasonListPage().checkWriteOffReasonTableValues(shortNameEdited));
        pharmacyManager.getWriteOffReasonListPage().clickDeleteButton();
        pharmacyManager.getWriteOffReasonListPage().getDialog().clickYes();
        pharmacyManager.getWriteOffReasonListPage().getWriteOffReasonListTable().getAlerts().assertSuccessAlertIsPresent();
    }
}