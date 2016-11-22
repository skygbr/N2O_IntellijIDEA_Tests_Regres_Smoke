package businessFramework.module.clinic.pages.resultAdmission;

import businessFramework.entities.clinic.ResultAdmissionData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;


/**
 * Created by asamoilov on 20.08.2015.
 */
public class ResultAdmissionPage extends ResultAdmissionHelper {
    public ResultAdmissionPage(ApplicationManager app) {
        super(app);
    }

    public void clickCreateVisitClinic(){
        Button button = getCreateVisitButton();
        button.assertIsDisplayed(true);
        button.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickSaveCase() {
        Button button = getSaveCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        //getDialog().getButton(CONFIRM_BUTTON).click();
        findElement(By.cssSelector("footer.modal-footer button.confirm")).click();
        sleep(5);
       // getAlerts().acceptAlert();
    }

    public void clickUpdateCase(){
        Button button = getUpdateCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickRewriteCase(){
        Button button = getRewriteCaseButton();
        button.assertIsDisplayed(true);
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
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
    public void clickGoCase(){
        Button button = getGoCaseButton();
        button.assertIsEnabled();
        button.click();
    }
    public void clickPatientCardPlace(){
        Button button = getPatientCardPlaceButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Местонахождение АМК");
    }
    public void clickAddCardPlace(){
        Button button = getAddCardPlaceButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    //копия последнего посещения 
    public void clickCopyLastVisit(){
        Button button = getCopyLastVisitButton();
        button.assertIsEnabled();
        button.click();
        //getDialog().getButton(CONFIRM_BUTTON).click();
        findElement(By.cssSelector("footer.modal-footer button.confirm")).click();
        sleep(5);
        getAlerts().acceptAlert();
        getAlerts().assertSuccessAlertIsPresent();
    }

    //ТАП
    public void clickSaveTAP(){
        Button button = getSaveTAP();
        button.assertIsEnabled();
        button.click();
       // getAlerts().assertSuccessAlertIsPresent();
    }

    //Услуги,Протоколы
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
       // getAlerts().assertSuccessAlertIsPresent(); //// TODO: 13.08.2016 почему падает???
    }

    //Направления
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

    //Назначения
    public void clickViewPrescription(){
        Button button = getViewPrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение услуги");
    }
    public void clickCreatePrescription(){
        Button button = getCreatePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение услуги");
    }

    public void clickEditPrescription(){
        Button button = getUpdatePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Назначение услуги");
    }
    public void clickDeletePrescription(){
        Button button = getDeletePrescriptionButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
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

    //Листы нетрудоспособности
    public void clickRequestSickList(){
        Button button = getRequestSickListButton();
        button.assertIsEnabled();
        button.clickButtonOnDropDown();
        assertPageTitleIs("Заявка");
    }
    public void clickDeleteSickList(){
        Button button = getDeleteSickListButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }

    //Журнал прививок
    public void clickAddInoculation(){
        Button button = getAddInoculationButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Прививка");
    }
    public void clickAddMantu(){
        Button button = getAddMantuButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Прививка");
    }
    public void clickUpdateVaccinations(){
        Button button = getUpdateVaccinationsButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Прививка");
    }
    public void clickDeleteVaccinations(){
        Button button = getDeleteVaccinationsButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickIndivPlan(){
        Button button = getIndivPlanButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Индивидуальное планирование");
    }

    //Справки
    public void clickViewCert(){
        Button button = getViewCertButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Справка о стоимости услуг");
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

    //Проишествие
    public void clickCreateAccident(){
        Button button = getCreateAccidentButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Регистрация происшествия");
    }
    public void clickUpdateAccident(){
        Button button = getUpdateAccidentButton();
        button.assertIsEnabled();
        button.click();
        assertPageTitleIs("Регистрация происшествия");
    }
    public void clickDeleteAccident(){
        Button button = getDeleteAccidentButton();
        button.assertIsEnabled();
        button.click();
        getAlerts().assertSuccessAlertIsPresent();
    }
    public void clickCreateNewCase() {
        Button button = getMcCase().getButton("Новый случай");
        button.assertIsEnabled();
        button.click();
    }

    public void setValueToField(ResultAdmissionData rd){
        getMcCaseCareRegimen().setValue(rd.getMcCaseCareRegimen());
        getFundingSourceType().setExactValue(rd.getFundingSourceType());
        getMcCaseType().setValue(rd.getMcCaseType());
        getMcCaseCaseInitGoal().setValue(rd.getCaseInitGoal());
        getMcCaseCareProvidingForm().setValue(rd.getCareProvidingForm());
        getMcCaseCareLevel().setValue(rd.getCareLevel());
        getMcCaseCareProvisionCondition().setValue(rd.getCareProvisionCondition());
        getVisitPlace().setValue(rd.getVisitPlace());
        getProfile().setValue(rd.getProfile());
        getDiagnosis().setValue(rd.getDiagnosis());
        getService().setValue(rd.getService());
        getDiseaseType().setValue(rd.getDiseaseType());
    }

    /**
     * сохранение местонахождения АМК
     * @param rd - возвращает  значение классифаера выбора местонахождения АМК
     */
    public void saveMedicalCard(ResultAdmissionData rd){
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
    public void selectCase(String diagnos){
        getMcCase().setValue(diagnos);
    }

}
