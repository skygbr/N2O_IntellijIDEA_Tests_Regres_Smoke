package test.businessTests.pharmacy.refbook;

import businessFramework.entities.pharmacy.HoldingData;
import businessFramework.entities.pharmacy.HoldingProducerData;
import businessFramework.entities.pharmacy.ModifData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class HoldingForOrgTest extends TestBase implements Values {

    private HoldingData holdingData;
    private ModifData modifData;
    private HoldingProducerData producerData;

    private HoldingData regionalHoldingData;
    private ModifData regionalModifData;
    private HoldingProducerData regionalProducerData;

    private PharmacyManager pharmacyManager;

    @BeforeClass
    public void initialize() {
        holdingData = new HoldingData();
        modifData = new ModifData();
        producerData = new HoldingProducerData();
        pharmacyManager = new PharmacyManager();
        regionalProducerData = new HoldingProducerData();
        regionalHoldingData = new HoldingData();
        regionalModifData = new ModifData();

        /** Данные для выбора контекста */
        holdingData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для полей модального окна Номенклатура*/
        holdingData.setIsVital("true");
        holdingData.setIsAccounting("true");
        holdingData.setIsGuaranty("true");
        holdingData.setCode("based_on_regional");
        holdingData.setName("Номенклатура_на_основе_региональной");
        holdingData.setInn("Тестовый МНН");
        holdingData.setLatinName("Test latin name");
        holdingData.setCommodityGroup("Тестовая тов. группа");
        holdingData.setVen("V");
        holdingData.setOfficialList("Тестовый форм. лист");
        holdingData.setActs("Тестовый АТХ");
        holdingData.setPharmGroup("Тестовая фарм. группа");
        holdingData.setMkbDiagnosis("Код тестового диагноза Тестовый диагноз");
        holdingData.setPharmAction("Тестовое фарм. действие");

        regionalHoldingData.setCode("");
        regionalHoldingData.setName("АТ_Региональная_номенклатура");
        regionalHoldingData.setCommodityGroup("Тестовая тов. группа");
        regionalHoldingData.setIsAccounting("true");
        regionalHoldingData.setIsGuaranty("true");

        /** Данные для полей модального окна Модификация*/
        modifData.setCode("");
        modifData.setCommonPrototype("АТ_Региональная_модификация");
        modifData.setName("АТ_Региональная_модификация");
        modifData.setLatinName("АТ_Regional_modif");
        modifData.setForm("autotest_form_type");
        modifData.setMnei("at_mnei");
        modifData.setPriceUnitFlag("Втор. уп.");
        modifData.setConcentrVal("4");
        modifData.setConcentrUnit("concentr_unit");
        modifData.setVolumeVal("5");
        modifData.setVolumeUnit("volume_unit");
        modifData.setMassVal("3");
        modifData.setMassUnit("mass_unit");
        modifData.setDosageVal("2");
        modifData.setDosageUnit("dosage_unit");
        modifData.setNumberOfDoses("10");
        modifData.setWriteOffUnitFlag("Не списывать");
        modifData.setStorageCond("A");
        modifData.setIsExtemporal("true");
        modifData.setAngroFlag("true");
        modifData.setMedPurposeFlag("true");
        modifData.setDloFlag("true");
        modifData.setCodeOkdp("code_okpd");

        /** Данные для полей модального окна Максимальные дозы*/
        modifData.setMaxDailyDoseVal("10");
        modifData.setMaxSingleDoseVal("10");

        /** Данные для полей модального окна Производитель*/
        producerData.setOrganization("АДМ Евразия ООО");
        producerData.setRegCertNumber("123456789");
        producerData.setCodeRls("1234567ABC");
        producerData.setRegCertDateStart("01.01.2015");
        producerData.setRegCertDateEnd("02.01.2015");
        producerData.setEanCode("1234567890");
        producerData.setLimitPrice("1000");
        producerData.setFormattedLimitPrice("1 000.00");
        producerData.setDecisionNumber("100");
        producerData.setPriceDate("01.01.2015");
        producerData.setCertificateNumber("1234567890");

        regionalModifData.setName("АТ_Региональная_модификация");
        regionalProducerData.setOrganizationName("АДМ Евразия ООО");
        regionalProducerData.setEanCode("123456789");
    }

    @Test(description = "Открытие страницы Справочники-Номенклатор МО")
    public void step1_openHoldingRefbookPageCheckFilter() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(holdingData.getDepartmentForContext());
        pharmacyManager.openHoldingForOrgRefbook();
    }

    @Test(description = "Создание Модификации: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step1_openHoldingRefbookPageCheckFilter")
    public void step2_createModification() {
        pharmacyManager.getHoldingForOrgListPage().clickCreateModifButton();
        pharmacyManager.getHoldingForOrgListPage().getModifModal().clickFindFromPrototype();
        pharmacyManager.getHoldingForOrgListPage().getModifModal().getSearchRegionalModifModal().chooseModifByFilter(regionalHoldingData.getName(), regionalProducerData.getEanCode());
        pharmacyManager.getHoldingForOrgListPage().getModifModal().getSearchRegionalModifModal().checkRecordInRegionalModifTable(regionalHoldingData.getName(),
                regionalModifData.getName(), regionalProducerData.getOrganizationName());
        pharmacyManager.getHoldingForOrgListPage().getModifModal().getSearchRegionalModifModal().clickChooseButton();
        pharmacyManager.getHoldingForOrgListPage().getModifModal().clickFillFromPrototype();
        pharmacyManager.getHoldingForOrgListPage().getModifModal().clickAddHolding();
        pharmacyManager.getHoldingForOrgListPage().getHoldingModal().checkHoldingFormFields(regionalHoldingData);
        pharmacyManager.getHoldingForOrgListPage().getHoldingModal().fillHoldingForm(holdingData);
        pharmacyManager.getHoldingForOrgListPage().getHoldingModal().clickSaveHolding();
        modifData.setHoldinfName(holdingData.getName());
        pharmacyManager.getHoldingForOrgListPage().getModifModal().checkModifFromForOrgFields(modifData);
        pharmacyManager.getHoldingForOrgListPage().getModifModal().clickSaveButton();

        pharmacyManager.getHoldingForOrgListPage().getModifListTable().getAlerts().isAlertPresent();
    }
}
