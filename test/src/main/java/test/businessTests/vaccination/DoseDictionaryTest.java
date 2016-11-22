package test.businessTests.vaccination;

import businessFramework.entities.vaccination.DoseDictionaryData;
import businessFramework.module.Values;
import businessFramework.module.vaccination.DictionaryManager;
import businessFramework.module.vaccination.pages.dictionary.DosesPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.substring;

/**
 * Created by bulat.garipov on 01.06.2016.
 */
public class DoseDictionaryTest extends TestBase implements Values {

    private DictionaryManager manager;
    private DoseDictionaryData data;

    int rowCreatedDose;
    int rowUpdatedDose;

    int rowCreatedDoseType;
    int rowUpdatedDoseType;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        final String PREFIX = "at";
        final String doseTypeCode = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);
        final String doseTypeLabel = substring(PREFIX + UUID.randomUUID().toString(), 0, 255);
        final String doseTypeCode2 = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);
        final String doseTypeLabel2 = substring(PREFIX + UUID.randomUUID().toString(), 0, 255);
        final String doseCode = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);
        final String doseCode2 = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);
        final String doseECode = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);
        final String doseECode2 = substring(PREFIX + UUID.randomUUID().toString(), 0, 20);

        manager = new DictionaryManager();
        data = new DoseDictionaryData();
        data.setDoseTypeCode(doseTypeCode);
        data.setDoseTypeLabel(doseTypeLabel);
        data.setCount("3.23");
        data.setDoseType(doseTypeLabel);
        data.setCode(doseCode);
        data.seteCode(doseECode);
        data.setUpdateDoseTypeCode(doseTypeCode2);
        data.setUpdateDoseTypeLabel(doseTypeLabel2);
        data.setUpdateCount("3.2");
        data.setUpdateDoseType(doseTypeLabel2);
        data.setUpdateCode(doseCode2);
        data.setUpdateECode(doseECode2);
        data.setDoseDepartment("Вакцинопрофилактика");
    }

    @Test(description = "Открытие модуля Вакцинопрофилактика. Открытие страницы Справочники. Дозировки", priority = 1)
    public void step1_openVaccineModule() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(data.getDoseDepartment());
        manager.openVaccinationModule();
        manager.openDoseDictionaryPage();
    }

    @Test(description = "Создание единицы измерения", dependsOnMethods = "step1_openVaccineModule")
    public void step2_createDoseType() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getCreateDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().assertCountOfModals(1);
        manager.getDosePage().getDoseTypeModal().fillFields("", data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeModal().getSaveDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().getCode().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseTypeModal().fillFields(data.getDoseTypeCode(), "");
        manager.getDosePage().getDoseTypeModal().getSaveDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().getLabel().getValidations().assertErrorValidationMessage("Поле обязательно для заполнения");
        manager.getDosePage().getDoseTypeModal().fillFields(data.getDoseTypeCode(), data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeModal().getSaveDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().assertCountOfModals(0);
//        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        rowCreatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getDoseTypeCode(), data.getDoseTypeLabel());
    }

    @Test(description = "Проверка уникальности наименования единицы измерения", dependsOnMethods = "step2_createDoseType")
    public void step3_checkUniqueLabel() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getCreateDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().assertCountOfModals(1);
        manager.getDosePage().getDoseTypeModal().fillFields(data.getDoseTypeCode(), data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeModal().getSaveDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().getLabel().getValidations().assertErrorValidationMessage("Такая единица измерения уже существует");
        manager.getDosePage().closeAllModalsOnPage();
    }

    @Test(description = "Проверка доступности кнопки Удалить", dependsOnMethods = "step3_checkUniqueLabel")
    public void step4_checkDeleteIsAvailable() {
        manager.getDosePage().getDoseTypeContainer();
        rowCreatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getDoseTypeCode(), data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowCreatedDoseType);
        manager.getDosePage().getDeleteDoseTypeButton().assertIsEnabled();
    }

    @Test(description = "Создание дозы", dependsOnMethods = "step4_checkDeleteIsAvailable")
    public void step5_createDose() {
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

    @Test(description = "Проверка уникальности кода дозировки", dependsOnMethods = "step5_createDose")
    public void step6_checkUniqueCode() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getCreateDoseButton().click();
        manager.getDosePage().getDoseModal().assertCountOfModals(1);
        manager.getDosePage().getDoseModal().fillFields(data.getCount(), data.getDoseType(), data.getCode(), data.geteCode());
        manager.getDosePage().getDoseModal().getSaveDoseButton().click();
        manager.getDosePage().getDoseModal().getCode().getValidations().assertErrorValidationMessage("Такой код уже существует");
        manager.getDosePage().closeAllModalsOnPage();
    }

    @Test(description = "Проверка недоступности кнопки Удалить", dependsOnMethods = "step6_checkUniqueCode")
    public void step7_checkDeleteIsAvailable() {
        manager.getDosePage().refresh();
        manager.getDosePage().getDoseTypeContainer();
        rowCreatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getDoseTypeCode(), data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowCreatedDoseType);
        manager.getDosePage().getDeleteDoseTypeButton().assertIsDisabled();
    }

    @Test(description = "Изменение единицы измерения", dependsOnMethods = "step7_checkDeleteIsAvailable")
    public void step8_updateDoseType() {
        manager.getDosePage().getDoseTypeContainer();
        rowCreatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getDoseTypeCode(), data.getDoseTypeLabel());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowCreatedDoseType);
        manager.getDosePage().getUpdateDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().assertCountOfModals(1);
        manager.getDosePage().getDoseTypeModal().fillFields(data.getUpdateDoseTypeCode(), data.getUpdateDoseTypeLabel());
        manager.getDosePage().getDoseTypeModal().getSaveDoseTypeButton().click();
        manager.getDosePage().getDoseTypeModal().assertCountOfModals(0);
        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        rowUpdatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getUpdateDoseTypeCode(), data.getUpdateDoseTypeLabel());
    }

    @Test(description = "Изменение дозы", dependsOnMethods = "step8_updateDoseType")
    public void step9_updateDoseType() {
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

    @Test(description = "Фильтр доз по полю Доза", dependsOnMethods = "step9_updateDoseType")
    public void step10_filterDoseByCount() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByCount(data.getUpdateCount());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_COLUMN, data.getUpdateCount());
    }

    @Test(description = "Фильтр доз по полю Единица измерения", dependsOnMethods = "step10_filterDoseByCount")
    public void step11_filterDoseByDoseType() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByDoseType(data.getUpdateDoseType());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_TYPE_COLUMN, data.getUpdateDoseType());
    }

    @Test(description = "Фильтр доз по полю Код", dependsOnMethods = "step11_filterDoseByDoseType")
    public void step12_filterDoseByCode() {
        manager.getDosePage().getDoseContainer();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseByCode(data.getUpdateCode());
        manager.getDosePage().assertDoseTableData(DosesPage.DOSE_TABLE_DOSE_CODE_COLUMN, data.getUpdateCode());
    }

    @Test(description = "Удаление дозы", dependsOnMethods = "step12_filterDoseByCode")
    public void step13_deleteDose() {
        manager.getDosePage().getDoseContainer();
        rowUpdatedDose = manager.getDosePage().checkTableDosesValues(data.getUpdateCount(), data.getUpdateDoseType(), data.getUpdateCode(), data.getUpdateECode());
        manager.getDosePage().getDoseTable().chooseRowInTable(rowUpdatedDose);
        manager.getDosePage().getDeleteDoseButton().assertIsEnabled();
        manager.getDosePage().getDeleteDoseButton().click();
        manager.getDosePage().getDialog().clickYes();
        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        manager.getDosePage().getDoseContainer().getFilter().clickClearButton();
    }

    @Test(description = "Проверка доступности кнопки Удалить", dependsOnMethods = "step13_deleteDose")
    public void step14_checkDeleteIsAvailable() {
        manager.getDosePage().refresh();
        manager.getDosePage().getDoseTypeContainer();
        rowUpdatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getUpdateDoseTypeCode(), data.getUpdateDoseTypeLabel());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowUpdatedDoseType);
        manager.getDosePage().getDeleteDoseTypeButton().assertIsEnabled();
    }

    @Test(description = "Фильтр единиц измерения по полю Код", dependsOnMethods = "step13_deleteDose")
    public void step15_filterDoseTypeByCode() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getDoseTypeContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseTypeByCode(data.getUpdateDoseTypeCode());
        manager.getDosePage().assertDoseTypeTableData(DosesPage.DOSE_TYPE_TABLE_CODE_COLUMN, data.getUpdateDoseTypeCode());
    }

    @Test(description = "Фильтр единиц измерения по полю Единица измерения", dependsOnMethods = "step15_filterDoseTypeByCode")
    public void step16_filterDoseTypeByLabel() {
        manager.getDosePage().getDoseTypeContainer();
        manager.getDosePage().getDoseTypeContainer().getFilter().clickClearButton();
        manager.getDosePage().filterDoseTypeByLabel(data.getUpdateDoseTypeLabel());
        manager.getDosePage().assertDoseTypeTableData(DosesPage.DOSE_TYPE_TABLE_DOSE_TYPE_COLUMN, data.getUpdateDoseTypeLabel());
    }

    @Test(description = "Удаление единицы измерения", dependsOnMethods = "step16_filterDoseTypeByLabel")
    public void step17_deleteDoseType() {
        manager.getDosePage().getDoseTypeContainer();
        rowUpdatedDoseType = manager.getDosePage().checkTableDoseTypesValues(data.getUpdateDoseTypeCode(), data.getUpdateDoseTypeLabel());
        manager.getDosePage().getDoseTypeTable().chooseRowInTable(rowUpdatedDoseType);
        manager.getDosePage().getDeleteDoseTypeButton().assertIsEnabled();
        manager.getDosePage().getDeleteDoseTypeButton().click();
        manager.getDosePage().getDialog().clickYes();
        manager.getDosePage().getAlerts().assertSuccessAlertIsPresent();
        manager.getDosePage().getDoseTypeContainer().getFilter().clickClearButton();
    }
}
