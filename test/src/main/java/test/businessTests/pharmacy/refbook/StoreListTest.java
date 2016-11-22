package test.businessTests.pharmacy.refbook;

import businessFramework.entities.pharmacy.StoreData;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ydolgih
 * @since 03.07.2015
 */
public class StoreListTest extends TestBase {

    private PharmacyManager pharmacyManager;
    private StoreData storeData;

    @BeforeClass
    public void initialize() {
        storeData = new StoreData();
        pharmacyManager = new PharmacyManager();
        storeData.setClosingDateString("01.01.2015");
        storeData.setDepartmentForContext("Отделение экстренной госпитализации");
    }

    @Test(description = "Открытие страницы Справочники-Склады")
    public void step1_openStoreListRefbookPage() {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(storeData.getDepartmentForContext());
        pharmacyManager.openStoreRefbook();
    }

    @Test(description = "Установление даты закрытия периода для складов", dependsOnMethods = "step1_openStoreListRefbookPage")
    public void step2_setStoreClosingPeriod() {
        pharmacyManager.getStoreListPage().clickSetClosingPeriodDate();
        pharmacyManager.getStoreListPage().getStoreClosingDateModal().assertCountOfModals(1);
        pharmacyManager.getStoreListPage().getStoreClosingDateModal().fillClosingDate(storeData.getClosingDateString());
        pharmacyManager.getStoreListPage().getStoreClosingDateModal().pressSaveButton();
        pharmacyManager.getStoreListPage().assertStoreClosingDateSuccessMessage(storeData.getSuccessSetStoreClosingDateAlertMessage());

        pharmacyManager.getStoreListPage().getStoreClosingDateContainer().clickContainer();
        pharmacyManager.getStoreListPage().checkRecordInStoreClosingDateTable(storeData.getClosingDateString(), page.getCurrentDate());
    }
}