package businessFramework.module.stomatology.pages.resultAdmissionStom;

import businessFramework.entities.stomatology.ResultAdmissionDataStom;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;

/**
 * Created by RTlabs on 19.07.2016.
 */
public class ResultAdmissionPageStom extends ResultAdmissionHelperStom {

    public ResultAdmissionPageStom(ApplicationManager app) {
        super(app);
    }
    public void clickCreateNewCase() {
        Button button = getMcCase().getButton("Новый случай");
        button.assertIsEnabled();
        button.click();
    }
    public void setValueToField(ResultAdmissionDataStom rd){
        getMcCaseCareRegimen().setValue(rd.getMcCaseCareRegimen());
        getMcCaseType().setValue(rd.getMcCaseType());
        getFundingSourceType().setValue(rd.getFundingSourceType());
        getMcCaseCaseInitGoal().setValue(rd.getCaseInitGoal());
        getMcCaseCareProvidingForm().setValue(rd.getCareProvidingForm());
        getVisitPlace().setValue(rd.getVisitPlace());
        getMcCaseCareLevel().setValue(rd.getCareLevel());
        getMcCaseCareProvisionCondition().setValue(rd.getCareProvisionCondition());
        getProfile().setValue(rd.getProfile());
        getService().setValue(rd.getService());

    }
    public void clickSaveCase(){
        Button button = getSaveCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        button.assertIsDisplayed(false);
    }
    public void clickGoCase(){
        Button button = getGoCaseButton();
        button.assertIsEnabled();
        button.click();
    }
    /**
     * сохранение местонахождения АМК
     * @param rd - возвращает  значение классифаера выбора местонахождения АМК
     */
    public void saveMedicalCard(ResultAdmissionDataStom rd){
        getMedicalCard().setValue(rd.getMedicalCardPlaceName());
        getButton("addCardPlace").click();
    }
    // открытие модального окна истории местонахождения АМК
    public void clickMedicalCardHistory(){
        Button button = getMedicalCardHistory();
        button.assertIsEnabled();
        button.click();
        assertModalPresentOnPage(true);
    }
    //зубная формула Осмотры
    public void clickAddInspection(){
        Button button = getAddInspection();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Заполнение осмотра");
    }
    //Услуги,Протоколы
    public Table getTableService(){
        return getContainerServicesAndProtocols().getTable();
    }
    public void clickCreateService(){
        Button button = getCreateServiceAndProtocolButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Оказание услуги");
    }
    public void clickUpdateService(){
        Button button = getUpdateServiceAndProtocolButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Оказание услуги");
    }
    public void clickDeleteService(){
        Button button = getDeleteServiceAndProtocolButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
      //  getAlerts().assertSuccessAlertIsPresent();
    }
    //Услуги для Информации по случаю
    public void clickCreateServiceInform(){
        Button button = getCreateServiceInformButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Оказание услуги");
    }
    public void clickUpdateServiceInform(){
        Button button = getUpdateServiceInformButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Оказание услуги");
    }
    public void clickDeleteServiceInform(){
        Button button = getDeleteServiceInformButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
        //  getAlerts().assertSuccessAlertIsPresent();
    }
    //Диагнозы
    //получение первой записи из таблицы
    public void clickCreateDiagnosisButton(){
        Button button = getCreateDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Диагноз");
    }
    public void clickUpdateDiagnosis(){
        Button button = getUpdateDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Диагноз");
    }

    public void clickDeleteDiagnosis(){
        Button button = getDeleteDiagnosisButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
        // getAlerts().assertSuccessAlertIsPresent();
    }

    public void clickCreateToothMaterialButton(){
        Button button = getCreateToothMaterialButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Расходный материал");
    }
    public void clickCopyToothMaterialButton(){
        Button button = getCopyToothMaterialButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Расходный материал");
    }
    public void clickUpdateToothMaterialButton(){
        Button button = getUpdateToothMaterialButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Расходный материал");
    }
    public void clickDeleteToothMaterialButton(){
        Button button = getDeleteToothMaterialButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Расходный материал");
    }
    public void clickDeleteAllToothMaterialButton() {
        while (getTableToothMaterial().getCountRowsInTable(true)>0) {
            getTableToothMaterial().chooseRowInTable(0);
            clickDeleteToothMaterialButton();
            getDialog().clickYes();
        }
    }
    public void clickCreateReferral(){
        getContainerReferral().clickDropdown("Добавить", "направление на услуги", "createClinicReferral");
    }

    public void clickCreateLaboratoryReferral(){
        Button button = getCreateLaboratoryReferralButton();
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
    }
    public void clickCreateClinicReferral(){
        Button button = getCreateClinicReferralButton();
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
    }
    public void clickCreateHospReferral(){
        Button button = getCreateHospReferralButton();
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
    }
    public void clickUpdateReferral(){
        Button button = getUpdateReferralButton();
        button.assertIsDisplayed(true);
        button.click();
    }


    public void clickUpdateLaboratoryReferral(){
        Button button = getUpdateLaboratoryReferralButton();
        button.assertIsDisplayed(true);
        button.click();
    }
    public void clickUpdateHospitalReferral(){
        Button button = getUpdateHospitalReferralButton();
        button.assertIsDisplayed(true);
        button.click();
    }
    public void clickDeleteReferral(){
        Button button = getDeleteReferralButton();
        button.assertIsEnabled();
        button.click();
      //  getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Удаление всех направлений
     */
    public void deleteAllReferral() {
        while (getTableReferral().getCountRowsInTable(true)>0) {
            getTableReferral().chooseRowInTable(0);
            clickDeleteReferral();
            getDialog().clickYes();
        }
    }
    public void clickCloseCase(){
        Button button = getCloseCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        assertPageTitleIs("Закрытие случая");
    }
    public void clickReopenCase(){
        Button button = getReopenCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        button.assertIsDisplayed(false);
    }
    //Назначения
    public void clickViewPrescription(){
        Button button = getViewPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение. Просмотр");
    }
    public void clickCreatePrescription(){
        Button button = getCreatePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение. Создание");
    }
    public void clickEditPrescription(){
        Button button = getUpdatePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение. Редактирование");
    }
    public void clickDeletePrescription(){
        Button button = getDeletePrescriptionButton();
        button.assertIsEnabled();
        button.click();
      //  getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Удаление всех назначений
     */
    public void deleteAllPrescription() {
        while (getTablePrescrition().getCountRowsInTable(true)>0) {
            getTablePrescrition().chooseRowInTable(0);
            clickDeletePrescription();
            getDialog().clickYes();
        }
    }

    public void clickConfirmPrescription(){
        Button button = getConfirmPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCancelPrescription(){
        Button button = getCancelPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    //Рецепты
    public void clickCreateGeneralReceipt(){
        Button button = getCreateGeneralReceiptButton();
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
        assertPageTitleIs("Рецепт");
    }
    public void clickEditReceipt(){
        Button button = getUpdateReceiptButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Рецепт");
    }
    public void clickDeleteReceipt(){
        Button button = getDeleteReceiptButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Рецепт");
    }

    /**
     * Удаление всех рецептов
     */
    public void deleteAllReceipt(){
        while (getTableReceipt().getCountRowsInTable(true)>0) {
            getTableReceipt().chooseRowInTable(0);
            clickDeleteReceipt();
            getDialog().clickYes();
        }
    }
    public void clickCreateCert(){
        Button button = getCreateCertButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Справка о стоимости услуг");
    }
    public void clickCreateRefusal(){
        Button button = getCreateRefusalButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Отказ от справки о стоимости услуг");
    }
    public void clickAnnuleCert(){
        Button button = getAnnuleCertButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCancelAnnuledCert(){
        Button button = getCancelAnnuledCertButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void selectCase(){
        getMcCase().setValue(0);
    }
    public void clickCopyLastVisit(){
        Button button = getCopyLastVisitButton();
        button.assertIsEnabled();
        button.click();
      //  getDialog().getButton(CONFIRM_BUTTON).click();
        findElement(By.cssSelector("footer.modal-footer button.confirm")).click(); // TODO: 09.06.2016   убрать после RMISDEV-2072
        sleep(5);
        getAlerts().acceptAlert();
       // getAlerts().assertSuccessAlertIsPresent();
    }
}
