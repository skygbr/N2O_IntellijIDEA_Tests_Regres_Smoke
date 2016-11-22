package test.businessTests.vaccinationWithGeneration;

import businessFramework.entities.vaccination.DenyReasonDictionaryData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.DictionaryManager;
import net.framework.autotesting.entities.UserData;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 01.06.2016.
 */
public class DenyReasonDictionaryTest extends TestBase implements Values {

    private DictionaryManager manager;
    private DenyReasonDictionaryData data;
    private UserData user;

    int rowCreatedDenyReason;
    int rowUpdatedDenyReason;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        manager = new DictionaryManager();
        user = new UserData();

        user.setUser("DenyReasonTest");
        user.setPassword("xL62U88r");

        data = new DenyReasonDictionaryData();

        data.setCode("DenyReasonTest");
        data.setLabel("DenyReasonTest");

        data.setUpdateCode("DenyReasonTest_upd");
        data.setUpdateLabel("DenyReasonTest_upd");

    }

    @Test(description = "Создание тестовых данных и вход в n2o")
    public void beforeTest() {
        app.executeLiquibase("changelog/vaccination/201605231321_insert_DenyReasonDictionaryTest.xml");
        app.getNavigationHelper().openMainPage(user);
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Открытие страницы Справочники. Причины медицинского отвода", dependsOnMethods = "beforeTest", priority = 1)
    public void step1_openVaccineModule() {
        manager.openVaccinationModule();
        manager.openDenyReasonDictionaryPage();
    }

    @Test(description = "Создание причины медицинского отвода", dependsOnMethods = "step1_openVaccineModule")
    public void step2_createDenyReason() {
        page.sleep(5); //todo Удалить после решения задачи https://jira.is-mis.ru/projects/RMISDEV/issues/RMISDEV-3143
        manager.getDenyReasonPage().getCreateDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().assertCountOfModals(1);
        manager.getDenyReasonPage().getDenyReasonModal().fillFields("", data.getLabel(), true, true, false);
        manager.getDenyReasonPage().getDenyReasonModal().getSaveDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().getCode().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDenyReasonPage().getDenyReasonModal().fillFields(data.getCode(), "", true, true, false);
        manager.getDenyReasonPage().getDenyReasonModal().getSaveDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().getLabel().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDenyReasonPage().getDenyReasonModal().fillFields(data.getCode(), data.getLabel(), true, true, false);
        manager.getDenyReasonPage().getDenyReasonModal().getSaveDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().assertCountOfModals(0);
        manager.getDenyReasonPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        rowCreatedDenyReason = manager.getDenyReasonPage().checkTableDenyReasonsValues(data.getCode(), data.getLabel());
    }

    @Test(description = "Изменение причины медицинского отвода", dependsOnMethods = "step2_createDenyReason")
    public void step3_updateDenyReason() {
        if (manager.getDenyReasonPage().getUpdateDenyReasonButton().isDisplayed() == false) {
            manager.getDenyReasonPage().refresh();
        }
        rowCreatedDenyReason = manager.getDenyReasonPage().checkTableDenyReasonsValues(data.getCode(), data.getLabel());
        manager.getDenyReasonPage().getDenyReasonTable().chooseRowInTable(rowCreatedDenyReason);
        manager.getDenyReasonPage().getUpdateDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().assertCountOfModals(1);
        manager.getDenyReasonPage().getDenyReasonModal().fillFields(data.getUpdateCode(), data.getUpdateLabel(), false, false, true);
        manager.getDenyReasonPage().getDenyReasonModal().getSaveDenyReasonButton().click();
        manager.getDenyReasonPage().getDenyReasonModal().assertCountOfModals(0);
        manager.getDenyReasonPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        manager.getDenyReasonPage().getDenyReasonTable().assertColumnValuesIs("Код", data.getUpdateCode());
        manager.getDenyReasonPage().getDenyReasonTable().assertColumnValuesIs("Причина", data.getUpdateLabel());
        rowUpdatedDenyReason = manager.getDenyReasonPage().checkTableDenyReasonsValues(data.getUpdateCode(), data.getUpdateLabel());
    }

    @Test(description = "Удаление причины медицинского отвода", dependsOnMethods = "step5_filterDenyReasonByLabel")
    public void step6_deleteDenyReason() {
        if (manager.getDenyReasonPage().getDeleteDenyReasonButton().isDisplayed() == false) {
            manager.getDenyReasonPage().refresh();
        }
        rowUpdatedDenyReason = manager.getDenyReasonPage().checkTableDenyReasonsValues(data.getUpdateCode(), data.getUpdateLabel());
        manager.getDenyReasonPage().getDenyReasonTable().chooseRowInTable(rowUpdatedDenyReason);
        manager.getDenyReasonPage().getDeleteDenyReasonButton().assertIsEnabled();
        manager.getDenyReasonPage().getDeleteDenyReasonButton().click();
        manager.getDenyReasonPage().getDialog().clickYes();
        manager.getDenyReasonPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        manager.getDenyReasonPage().getDenyReasonContainer().getFilter().clickClearButton();
    }

    @Test(description = "Фильтр по коду", dependsOnMethods = "step3_updateDenyReason")
    public void step4_filterDenyReasonByCode() {
        manager.getDenyReasonPage().getDenyReasonContainer().getFilter().clickClearButton();
        manager.getDenyReasonPage().filterByCode(data.getCode());
        manager.getDenyReasonPage().assertTableData1(data.getUpdateCode());
    }

    @Test(description = "Фильтр по наименованию", dependsOnMethods = "step4_filterDenyReasonByCode")
    public void step5_filterDenyReasonByLabel() {
        manager.getDenyReasonPage().getDenyReasonContainer().getFilter().clickClearButton();
        manager.getDenyReasonPage().filterByLabel(data.getLabel());
        manager.getDenyReasonPage().assertTableData2(data.getUpdateLabel());
    }

    @Test(description = "Выход из n2o", dependsOnMethods = "step6_deleteDenyReason", alwaysRun = true)
    public void afterTest_logout() {
        page.getHeader().logOut();
    }

    @Test(description = "Удаление тестовых данных", dependsOnMethods = "afterTest_logout", alwaysRun = true)
    public void afterTest_generation() {
        app.executeLiquibase("changelog/vaccination/201605231322_delete_DenyReasonDictionaryTest.xml");
    }
}