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
 * Created by ydolgih on 08.12.2015.
 */
public class RegionalHoldingTest extends TestBase implements Values {
    private HoldingData holdingData;
    private ModifData modifData;
    private HoldingProducerData producerData;
    private PharmacyManager pharmacyManager;
    private int rowHoldings;
    private int row;

    @BeforeClass
    public void initialize() {
        holdingData = new HoldingData();
        modifData = new ModifData();
        producerData= new HoldingProducerData();
        pharmacyManager = new PharmacyManager();

        /** Данные для выбора контекста */
        holdingData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для полей модального окна Номенклатура*/
        holdingData.setIsVital("true");
        holdingData.setIsAccounting("true");
        holdingData.setIsGuaranty("true");
        holdingData.setCode("Тестовый код");
        holdingData.setName("Тестовое наименование");
        holdingData.setInn("Тестовый МНН");
        holdingData.setLatinName("Test latin name");
        holdingData.setCommodityGroup("Тестовая тов. группа");
        holdingData.setVen("V");
        holdingData.setOfficialList("Тестовый форм. лист");
        holdingData.setActs("Тестовый АТХ");
        holdingData.setPharmGroup("Тестовая фарм. группа");
        holdingData.setMkbDiagnosis("Код тестового диагноза Тестовый диагноз");
        holdingData.setPharmAction("Тестовое фарм. действие");

        /** Данные для полей модального окна Модификация*/
        modifData.setCode("autotest_modif_code");
        modifData.setCodeTfoms("autotest_modif_tfoms_code");
        modifData.setName("autotest_modif_name");
        modifData.setLatinName("autotest_modif_latin_name");
        modifData.setForm("autotest_form_type");
        modifData.setMnei("at_mnei");
        modifData.setPriceUnitFlag("МНЕИ");
        modifData.setConcentrVal("1");
        modifData.setConcentrUnit("concentr_unit");
        modifData.setVolumeVal("1");
        modifData.setVolumeUnit("volume_unit");
        modifData.setMassVal("1");
        modifData.setMassUnit("mass_unit");
        modifData.setDosageVal("1");
        modifData.setDosageUnit("dosage_unit");
        modifData.setNumberOfDoses("10");
        modifData.setWriteOffUnitFlag("Не списывать");
        modifData.setStorageCond("A");
        modifData.setIsExtemporal("true");
        modifData.setAngroFlag("true");
        modifData.setMedPurposeFlag("true");
        modifData.setDloFlag("true");
        modifData.setCodeOkdp("code_okdp");
        modifData.setSuccessSaveAlertMessage("Модификация с кодом 'autotest_modif_code' сохранена");

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
    }

    @Test(description = "Открытие страницы Справочники-Номенклатор")
    public void step1_openHoldingRefbookPageCheckFilter() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(holdingData.getDepartmentForContext());
        pharmacyManager.openRegionalHoldingRefbook();
    }

    @Test(description = "Создание Номенклатуры: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step1_openHoldingRefbookPageCheckFilter")
    public void step2_createHolding()
    {
        pharmacyManager.getRegionalHoldingListPage().clickCreateHolding();
        pharmacyManager.getRegionalHoldingListPage().getHoldingModal().fillHoldingForm(holdingData);

        pharmacyManager.getRegionalHoldingListPage().getHoldingModal().checkHoldingFormFields(holdingData);

        pharmacyManager.getRegionalHoldingListPage().getHoldingModal().clickSaveHolding();
        pharmacyManager.getRegionalHoldingListPage().getHoldingListTable().getAlerts().assertSuccessAlertMessage(holdingData.getSuccessSaveAlertMessage());

        pharmacyManager.getRegionalHoldingListPage().getHoldingListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInHoldingListTable
                (holdingData.getCode(), holdingData.getName(), holdingData.getLatinName(), holdingData.getInn(), holdingData.getCommodityGroup(),
                        holdingData.getIsVital(), holdingData.getIsAccounting(), holdingData.getIsGuaranty()));
    }

    @Test(description = "Создание Модификации: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step2_createHolding")
    public void step3_createModification() {
        pharmacyManager.getRegionalHoldingListPage().clickCreateModif();
        pharmacyManager.getRegionalHoldingListPage().getModifModal().fillModifForm(modifData);
        pharmacyManager.getRegionalHoldingListPage().getModifModal().checkfillModifFormFields(modifData);
        pharmacyManager.getRegionalHoldingListPage().getModifModal().clickSaveModif();

        pharmacyManager.getHoldingListPage().getModifListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInModifListTable(modifData));
    }

    @Test(description = "Создание Производителя: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step3_createModification")
    public void step5_createHoldProducer() {
        pharmacyManager.getRegionalHoldingListPage().clickCreateProducer();
        pharmacyManager.getRegionalHoldingListPage().getProducerModal().fillHoldingProducerForm(producerData);
        pharmacyManager.getRegionalHoldingListPage().getProducerModal().checkHoldingProducerFormFields(producerData);
        pharmacyManager.getRegionalHoldingListPage().getProducerModal().clickSaveHoldingProducer();
        pharmacyManager.getRegionalHoldingListPage().getProducerListTable().getAlerts().assertSuccessAlertMessage(producerData.getSuccessSaveAlertMessage());

        pharmacyManager.getRegionalHoldingListPage().getProducerListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInProducerListTable(producerData));
    }
}
