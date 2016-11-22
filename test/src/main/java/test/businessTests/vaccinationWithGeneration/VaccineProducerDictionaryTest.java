package test.businessTests.vaccinationWithGeneration;

import businessFramework.entities.vaccination.VaccineProducerDictionaryData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.DictionaryManager;
import net.framework.autotesting.entities.UserData;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 01.06.2016.
 */
public class VaccineProducerDictionaryTest extends TestBase implements Values {

    private DictionaryManager manager;
    private VaccineProducerDictionaryData data;
    private UserData user;

    int rowCreatedVaccineProducer;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        manager = new DictionaryManager();
        data = new VaccineProducerDictionaryData();
        user = new UserData();

        user.setUser("VacProducerTest");
        user.setPassword("xL62U88r");

        data.setErrorLabel("VacProducerTest");
        data.setErrorFullName("VacProducerTest");

        data.setCountry("Россия");
        data.setLabel("VaccineProducerDictionaryTestProducer");
        data.setFullName("VaccineProducerDictionaryTestProducer");

        data.setUpdateCountry("Франция");
        data.setUpdateLabel("VaccineProducerDictionaryTestProducerUpdated");
        data.setUpdateLabelPart("roducerDictionaryTestProduce");
        data.setUpdateFullName("VaccineProducerDictionaryTestProducerUpdated");
        data.setUpdateLabelPart("roducerDictionaryTestProduce");
        data.setUpdateFullNamePart("roducerDictionaryTestProduce");
    }

    @Test(description = "Создание тестовых данных и вход в n2o")
    public void beforeTest() {
        app.executeLiquibase("changelog/vaccination/201606081244_insert_VaccineProducerDictionaryTest.xml");
        app.getNavigationHelper().openMainPage(user);
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Открытие страницы Справочники. Производители вакцин", dependsOnMethods = "beforeTest", priority = 1)
    public void step1_openVaccineModule() {
        manager.openVaccinationModule();
        manager.openVaccineProducerDictionaryPage();
    }

    @Test(description = "Создание производителя вакцины", dependsOnMethods = "step1_openVaccineModule")
    public void step2_createVaccineProducer() {
        page.sleep(5); //todo Удалить после решения задачи https://jira.is-mis.ru/projects/RMISDEV/issues/RMISDEV-3143
        manager.getVaccineProducerPage().getCreateVaccineProducerButton().click();
        manager.getVaccineProducerPage().getVaccineProducerModal().assertCountOfModals(1);
        manager.getVaccineProducerPage().getVaccineProducerModal().getFullName().setValue(data.getErrorFullName());
        manager.getVaccineProducerPage().getVaccineProducerModal().getLabel().setValue(data.getErrorLabel());
        manager.getVaccineProducerPage().getVaccineProducerModal().getLabel().getValidations().assertErrorValidationMessage("Производитель с таким наименованием уже существует");
        manager.getVaccineProducerPage().getVaccineProducerModal().fillFields(data.getCountry(), data.getLabel(), data.getFullName());
        manager.getVaccineProducerPage().getVaccineProducerModal().getSaveVaccineProducerButton().click();
        manager.getVaccineProducerPage().getVaccineProducerModal().assertCountOfModals(0);
        manager.getVaccineProducerPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Страна", data.getCountry());
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Наименование", data.getLabel());
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Полное наименование", data.getFullName());
    }

    @Test(description = "Изменение производителя вакцины", dependsOnMethods = "step2_createVaccineProducer")
    public void step3_updateVaccineProducer() {
        if (manager.getVaccineProducerPage().getUpdateVaccineProducerButton().isDisplayed() == false) {
            manager.getVaccineProducerPage().refresh();
        }
        rowCreatedVaccineProducer = manager.getVaccineProducerPage().checkTableVaccineProducersValues(data.getCountry(), data.getLabel(), data.getFullName());
        manager.getVaccineProducerPage().getVaccineProducerTable().chooseRowInTable(rowCreatedVaccineProducer);
        manager.getVaccineProducerPage().getUpdateVaccineProducerButton().click();
        manager.getVaccineProducerPage().getVaccineProducerModal().assertCountOfModals(1);
        manager.getVaccineProducerPage().getVaccineProducerModal().fillFields(data.getUpdateCountry(), data.getUpdateLabel(), data.getUpdateFullName());
        manager.getVaccineProducerPage().getVaccineProducerModal().getSaveVaccineProducerButton().click();
        manager.getVaccineProducerPage().getVaccineProducerModal().assertCountOfModals(0);
        manager.getVaccineProducerPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Страна", data.getUpdateCountry());
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Наименование", data.getUpdateLabel());
        manager.getVaccineProducerPage().getVaccineProducerTable().assertColumnValuesIs("Полное наименование", data.getUpdateFullName());
    }

    @Test(description = "Удаление производителя вакцины", dependsOnMethods = "step7_filterVaccineProducerByFullName")
    public void step4_deleteVaccineProducer() {
        if (manager.getVaccineProducerPage().getDeleteVaccineProducerButton().isDisplayed() == false) {
            manager.getVaccineProducerPage().refresh();
        }
        rowCreatedVaccineProducer = manager.getVaccineProducerPage().checkTableVaccineProducersValues(data.getUpdateCountry(), data.getUpdateLabel(), data.getUpdateFullName());
        manager.getVaccineProducerPage().getVaccineProducerTable().chooseRowInTable(rowCreatedVaccineProducer);
        manager.getVaccineProducerPage().getDeleteVaccineProducerButton().assertIsEnabled();
        manager.getVaccineProducerPage().getDeleteVaccineProducerButton().click();
        manager.getVaccineProducerPage().getDialog().clickYes();
        manager.getVaccineProducerPage().getAlerts().assertSuccessAlertMessage("Данные сохранены");
        manager.getVaccineProducerPage().getVacineProducerContainer().getFilter().clickClearButton();
    }

    @Test(description = "Фильтр по стране", dependsOnMethods = "step3_updateVaccineProducer")
    public void step5_filterVaccineProducerByCountry() {
        manager.getVaccineProducerPage().getVacineProducerContainer().getFilter().clickClearButton();
        manager.getVaccineProducerPage().filterByCountry(data.getUpdateCountry());
        manager.getVaccineProducerPage().assertTableData1(data.getUpdateCountry());
    }

    @Test(description = "Фильтр по наименованию", dependsOnMethods = "step5_filterVaccineProducerByCountry")
    public void step6_filterVaccineProducerByLabel() {
        manager.getVaccineProducerPage().getVacineProducerContainer().getFilter().clickClearButton();
        manager.getVaccineProducerPage().filterByLabel(data.getUpdateLabelPart());
        manager.getVaccineProducerPage().assertTableData2(data.getUpdateLabel());
    }

    @Test(description = "Фильтр по полному наименованию", dependsOnMethods = "step6_filterVaccineProducerByLabel")
    public void step7_filterVaccineProducerByFullName() {
        manager.getVaccineProducerPage().getVacineProducerContainer().getFilter().clickClearButton();
        manager.getVaccineProducerPage().filterByFullName(data.getUpdateFullNamePart());
        manager.getVaccineProducerPage().assertTableData3(data.getUpdateFullName());
    }

    @Test(description = "Выход из n2o", dependsOnMethods = "step4_deleteVaccineProducer", alwaysRun = true)
    public void afterTest_logout() {
        page.getHeader().logOut();
    }

    @Test(description = "Удаление тестовых данных", dependsOnMethods = "afterTest_logout", alwaysRun = true)
    public void afterTest_generation() {
        app.executeLiquibase("changelog/vaccination/201606081250_delete_VaccineProducerDictionaryTest.xml");
    }
}
