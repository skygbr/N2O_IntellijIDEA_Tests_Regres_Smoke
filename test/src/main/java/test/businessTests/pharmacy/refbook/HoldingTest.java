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
 * @author ydolgih
 * @since 28.05.2015
 */
public class HoldingTest extends TestBase implements Values {
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
        holdingData.setCommonPrototype("Тестовая номенклатура прот");
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

        /** Данные для полей Фильтра */
        holdingData.setCodeModif("code_for_filter");

        /** Данные для полей модального окна Модификация*/
        modifData.setCode("autotest_modif_code");
        modifData.setCodeTfoms("autotest_modif_tfoms_code");
        modifData.setName("autotest_modif_name");
        modifData.setName("autotest_modif_latin_name");
        modifData.setForm("autotest_form_type");
        modifData.setMnei("at_mnei");
        modifData.setPriceUnitFlag("Втор. уп.");
        modifData.setConcentrVal("1");
        modifData.setConcentrUnit("concentr_unit");
        modifData.setVolumeVal("1");
        modifData.setVolumeUnit("volume_unit");
        modifData.setMassVal("1");
        modifData.setMassUnit("mass_unit");
        modifData.setDosageVal("1");
        modifData.setDosageUnit("dosage_unit");
        modifData.setActVal("1");
        modifData.setActUnit("act_unit");
        modifData.setNumberOfDoses("10");
        modifData.setWriteOffUnitFlag("Не списывать");
        modifData.setStorageCond("A");
        modifData.setIsExtemporal("true");
        modifData.setAngroFlag("true");
        modifData.setMedPurposeFlag("true");
        modifData.setDloFlag("true");
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
        pharmacyManager.openHoldingRefbook();
        pharmacyManager.getHoldingListPage().fillFilterValues(holdingData.getCodeModif());
        pharmacyManager.getHoldingListPage().clickFilterFindButtonForHoldingList();
        pharmacyManager.getHoldingListPage().getHoldingListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().getRecordInHoldingListByCode(holdingData.getCodeModif()));
        pharmacyManager.getHoldingListPage().clearFilterValues();
        pharmacyManager.getHoldingListPage().clickFilterFindButtonForHoldingList();
    }

    @Test(description = "Создание Номенклатуры: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step1_openHoldingRefbookPageCheckFilter")
    public void step2_createHolding()
    {
        pharmacyManager.getHoldingListPage().clickCreateHolding();
        pharmacyManager.getHoldingListPage().getHoldingModal().fillHoldingForm(holdingData);

        pharmacyManager.getHoldingListPage().getHoldingModal().checkHoldingFormFields(holdingData);

        pharmacyManager.getHoldingListPage().getHoldingModal().clickSaveHolding();
        pharmacyManager.getHoldingListPage().getHoldingListTable().getAlerts().assertSuccessAlertMessage(holdingData.getSuccessSaveAlertMessage());

        pharmacyManager.getHoldingListPage().getHoldingListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInHoldingListTable
                ( holdingData.getCode(), holdingData.getName(), holdingData.getLatinName(), holdingData.getInn(), holdingData.getCommodityGroup(),
                        holdingData.getIsVital(), holdingData.getIsAccounting(), holdingData.getIsGuaranty()));
    }

    @Test(description = "Создание Модификации: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step2_createHolding")
    public void step3_createModification() {
        pharmacyManager.getHoldingListPage().clickCreateModif();
        pharmacyManager.getHoldingListPage().getModifModal().fillModifForm(modifData);
        pharmacyManager.getHoldingListPage().getModifModal().checkfillModifFormFields(modifData);
        pharmacyManager.getHoldingListPage().getModifModal().clickSaveModif();
        //pharmacyManager.getHoldingListPage().getModifListTable().getAlerts().assertSuccessAlertMessage(modifData.getSuccessSaveAlertMessage());

        pharmacyManager.getHoldingListPage().getModifListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInModifListTable(modifData));
    }

    @Test(description = "Модификация: Добавление максимальных доз", dependsOnMethods = "step3_createModification")
    public void step4_addMaxDosesModification() {
        pharmacyManager.getHoldingListPage().clickAddMaxDoses();
        pharmacyManager.getHoldingListPage().getModifMaxDosesModal().fillModifMaxDoses(modifData);
        pharmacyManager.getHoldingListPage().getModifMaxDosesModal().clickSaveMaxDoses();
        pharmacyManager.getHoldingListPage().getModifListTable().getAlerts().assertSuccessAlertMessage("Максимальные дозировки добавлены");
    }

    @Test(description = "Создание Проивозителя: Нажатие на кнопку, заполнение полей, проверка заполненности, сохранение и выбор созданной строки", dependsOnMethods = "step4_addMaxDosesModification")
    public void step5_createHoldProducer() {
        pharmacyManager.getHoldingListPage().clickCreateProducer();
        pharmacyManager.getHoldingListPage().getProducerModal().fillHoldingProducerForm(producerData);
        pharmacyManager.getHoldingListPage().getProducerModal().checkHoldingProducerFormFields(producerData);
        pharmacyManager.getHoldingListPage().getProducerModal().clickSaveHoldingProducer();
        pharmacyManager.getHoldingListPage().getProducerListTable().getAlerts().assertSuccessAlertMessage(producerData.getSuccessSaveAlertMessage());

        pharmacyManager.getHoldingListPage().getProducerListTable().chooseRowInTable(pharmacyManager.getHoldingListPage().checkRecordInProducerListTable(producerData));
    }
}
