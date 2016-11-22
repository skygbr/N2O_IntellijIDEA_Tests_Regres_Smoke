package test.businessTests.vaccinationWithGeneration;

import businessFramework.entities.vaccination.DoseDictionaryData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.DictionaryManager;
import businessFramework.module.vaccination.pages.dictionary.DosesPage;
import net.framework.autotesting.entities.UserData;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 01.06.2016.
 */
public class DoseDictionaryTest extends TestBase implements Values {

    private DictionaryManager manager;
    private DoseDictionaryData data;
    private UserData user;

    int rowCreatedDose;
    int rowUpdatedDose;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        manager = new DictionaryManager();
        data = new DoseDictionaryData();
        user = new UserData();

        user.setUser("DoseDictionaryTest");
        user.setPassword("xL62U88r");

        data.setDoseTypeCode("1");
        data.setDoseTypeLabel("мл.");
        data.setCount("3.23");
        data.setDoseType("мл.");
        data.setCode("DoseDictionaryTest");
        data.seteCode("DoseDictionaryTest");
        data.setUpdateDoseTypeCode("2");
        data.setUpdateDoseTypeLabel("таб.");
        data.setUpdateCount("3.2");
        data.setUpdateDoseType("таб.");
        data.setUpdateCode("DoseDictionaryTest2");
        data.setUpdateECode("DoseDictionaryTest2");
    }

    @Test(description = "Создание тестовых данных и вход в n2o")
    public void beforeTest() {
        app.executeLiquibase("changelog/vaccination/201606081350_insert_DoseDictionaryTest.xml");
        app.getNavigationHelper().openMainPage(user);
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Открытие страницы Справочники. Дозировки", dependsOnMethods = "beforeTest", priority = 1)
    public void step1_openVaccineModule() {
        app.getNavigationHelper().openMainPage();
        manager.openVaccinationModule();
        manager.openDoseDictionaryPage();
    }

    @Test(description = "Создание дозы", dependsOnMethods = "step1_openVaccineModule")
    public void step2_createDose() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getCreateDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(1);
        manager.getDosePage().getDoseModal().fillFields("", data.getDoseType(), data.getCode(), data.geteCode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getCount().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseModal().getDoseType().removeValue();
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getDoseType().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseModal().fillFields(data.getCount(), data.getDoseType(), "", data.geteCode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getCode().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseModal().fillFields(data.getCount(), data.getDoseType(), data.getCode(), "");
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getECode().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseModal().fillFields(data.getCount(), data.getDoseType(), data.getCode(), data.geteCode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(0);
        rowCreatedDose = manager.getDosePage().checkTableDosesValues(data.getCount(), data.getDoseType(), data.getCode(), data.geteCode());
    }

    @Test(description = "Проверка уникальности кода дозировки", dependsOnMethods = "step2_createDose")
    public void step3_checkUniqueCode() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getCreateDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(1);
        manager.getDosePage().getDoseModal().fillFields(data.getCount(), data.getDoseType(), data.getCode(), data.geteCode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getCode().getValidations().assertErrorValidationMessage("Такой код уже существует");
        manager.getDosePage().closeAllModalsOnPage();
    }

    @Test(description = "Изменение дозы", dependsOnMethods = "step3_checkUniqueCode")
    public void step4_updateDoseType() {
        manager.getDosePage().getDoseContainer();
        rowCreatedDose = manager.getDosePage().checkTableDosesValues(data.getCount(), data.getDoseType(), data.getCode(), data.geteCode());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowCreatedDose);
        manager.getDosePage().getUpdateDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(1);
        manager.getDosePage().getDoseModal().fillFields(data.getUpdateCount(), data.getUpdateDoseType(), data.getUpdateCode(), data.getUpdateECode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(0);
        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        rowUpdatedDose = manager.getDosePage().checkTableDosesValues(data.getUpdateCount(), data.getUpdateDoseType(), data.getUpdateCode(), data.getUpdateECode());
    }

    @Test(description = "Фильтр доз по полю Доза", dependsOnMethods = "step4_updateDoseType")
    public void step5_filterDoseByCount() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByCount(data.getUpdateCount());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_COLUMN, data.getUpdateCount());
    }

    @Test(description = "Фильтр доз по полю Единица измерения", dependsOnMethods = "step5_filterDoseByCount")
    public void step6_filterDoseByDoseType() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByDoseType(data.getUpdateDoseType());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_TYPE_COLUMN, data.getUpdateDoseType());
    }

    @Test(description = "Фильтр доз по полю Код", dependsOnMethods = "step6_filterDoseByDoseType")
    public void step7_filterDoseByCode() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByCode(data.getUpdateCode());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_CODE_COLUMN, data.getUpdateCode());
    }

    @Test(description = "Удаление дозы", dependsOnMethods = "step7_filterDoseByCode")
    public void step8_deleteDose() {
        manager.getDosePage().getDoseContainer();
        rowUpdatedDose = manager.getDosePage().checkTableDosesValues(data.getUpdateCount(), data.getUpdateDoseType(), data.getUpdateCode(), data.getUpdateECode());
        manager.getDosePage().getDoseTable().chooseRowInTable(rowUpdatedDose);
        manager.getDosePage().getDeleteDoseButton().assertIsEnabled();
        manager.getDosePage().getDeleteDoseButton().click();
        manager.getDosePage().getDialog().clickYes();
        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
    }

    @Test(description = "Фильтр единиц измерения по полю Код", dependsOnMethods = "step8_deleteDose")
    public void step9_filterDoseTypeByCode() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getDoseTypeContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseTypeByCode(data.getUpdateDoseTypeCode());
        manager.getDosePage().assertDoseTypeTableData(DosesPage.DOSE_TYPE_TABLE_CODE_COLUMN, data.getUpdateDoseTypeCode());
    }

    @Test(description = "Фильтр единиц измерения по полю Единица измерения", dependsOnMethods = "step9_filterDoseTypeByCode")
    public void step10_filterDoseTypeByLabel() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getDoseTypeContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseTypeByLabel(data.getUpdateDoseTypeLabel());
        manager.getDosePage().assertDoseTypeTableData(DosesPage.DOSE_TYPE_TABLE_DOSE_TYPE_COLUMN, data.getUpdateDoseTypeLabel());
    }

    @Test(description = "Выход из n2o", dependsOnMethods = "step10_filterDoseTypeByLabel", alwaysRun = true)
    public void afterTest_logout() {
        page.getHeader().logOut();
    }

    @Test(description = "Удаление тестовых данных", dependsOnMethods = "afterTest_logout", alwaysRun = true)
    public void afterTest_generation() {
        app.executeLiquibase("changelog/vaccination/201606081355_delete_DoseDictionaryTest.xml");
    }
}
