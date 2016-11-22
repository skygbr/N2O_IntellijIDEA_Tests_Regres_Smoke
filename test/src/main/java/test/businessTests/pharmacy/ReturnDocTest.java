package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.PharmacyData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReturnDocTest extends TestBase implements Values{

private PharmacyManager pharmacyManager;
    private PharmacyData pharmacyData;
    private String randomNumber;
    private String randomReturnDocNumber;
    private int row;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException{
        pharmacyManager = new PharmacyManager();
        pharmacyData = new PharmacyData();

        pharmacyData.setDepartmentForContext("Отделение экстренной госпитализации");
        pharmacyData.setReturnDocNumber("10");
        pharmacyData.setReturnDocDate(page.getCurrentDate());
        pharmacyData.setStoreName("Тестовый_склад_аптека");
        pharmacyData.setStoreOperation("Возврат поставщику");
        pharmacyData.setContractorName("Тестовый поставщик");
        pharmacyData.setFunding("test_funding_source");
        pharmacyData.setReturnReason("причина");
        pharmacyData.setAnnotation("примечание");
    }

    @Test (description = "Открытие модуля 'Возвратные документы'")
    public void step1_openReturnDocPage(){
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(pharmacyData.getDepartmentForContext());
        pharmacyManager.openReturnDocs();
    }

    @Test (description = "Создание Возвратного документа: нажать кнопку 'Добавить' заполнение полей, проверка созданной записи", dependsOnMethods = "step1_openReturnDocPage")
    public void step2_createReturnDoc(){
        randomNumber = randomInt(5);
        randomReturnDocNumber = "Док. "+randomNumber;
        pharmacyManager.getReturnDocsPage().clickCreateReturnDocButton();
        pharmacyManager.getReturnDocsPage().getReturnDocModal().assertCountOfModals(1);
        pharmacyManager.getReturnDocsPage().getReturnDocModal().setValuesToFields(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding(), pharmacyData.getReturnReason(),
                pharmacyData.getAnnotation());
        pharmacyManager.getReturnDocsPage().getReturnDocModal().checkFieldsValues(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding(), pharmacyData.getReturnReason(), pharmacyData.getAnnotation());
        pharmacyManager.getReturnDocsPage().getReturnDocModal().pressConfirmButton();
        pharmacyManager.getReturnDocsPage().getReturnDocListTable().getAlerts().assertSuccessAlertIsPresent();
        row = pharmacyManager.getReturnDocsPage().checkRecordInReturnDocsTable(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding());
    }

    @Test (description = "Редактирование возвратного документа", dependsOnMethods = "step2_createReturnDoc")
    public void step3_editReturnDoc(){
        pharmacyManager.getReturnDocsPage().selectFoundedRow(row);
        pharmacyManager.getReturnDocsPage().clickEditReturnDocButton();
        pharmacyManager.getReturnDocsPage().assertCountOfModals(1);
        pharmacyManager.getReturnDocsPage().getReturnDocModal().checkFieldsValues(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding(), pharmacyData.getReturnReason(), pharmacyData.getAnnotation());
        pharmacyData.setReturnDocNumber("edited_number");
        pharmacyManager.getReturnDocsPage().getReturnDocModal().setValuesToFields(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding(), pharmacyData.getReturnReason(),
                pharmacyData.getAnnotation());
        pharmacyManager.getReturnDocsPage().getReturnDocModal().pressConfirmButton();
        pharmacyManager.getReturnDocsPage().getReturnDocListTable().getAlerts().assertSuccessAlertIsPresent();
        row = pharmacyManager.getReturnDocsPage().checkRecordInReturnDocsTable(pharmacyData.getReturnDocNumber(),
                pharmacyData.getReturnDocDate(), pharmacyData.getStoreName(), pharmacyData.getStoreOperation(),
                pharmacyData.getContractorName(), pharmacyData.getFunding());
    }

    @Test(description = "Удаление созданных записей", dependsOnMethods = "step3_editReturnDoc", alwaysRun = true)
    public void step4_deleteAllCreateRecords() {
        if (pharmacyManager.getReturnDocsPage().getCountOfModals() > 0) {
            pharmacyManager.getReturnDocsPage().getModal().closeModal();
        }
        pharmacyManager.getReturnDocsPage().getReturnDocListTable().chooseRowInTable(row);
        pharmacyManager.getReturnDocsPage().clickDeleteReturnDocButton();
        pharmacyManager.getReturnDocsPage().getConfirmModal().clickYes();
        pharmacyManager.getReturnDocsPage().getReturnDocListTable().getAlerts().assertSuccessAlertIsPresent();
    }
}
