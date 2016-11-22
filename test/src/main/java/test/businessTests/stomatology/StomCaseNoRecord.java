package test.businessTests.stomatology;

import businessFramework.entities.stomatology.ResultAdmissionDataStom;
import businessFramework.entities.stomatology.StomatologyAppointmentData;
import businessFramework.module.Values;
import businessFramework.module.stomatology.StomatologyManager;
import businessFramework.module.stomatology.modals.stomSearchPatient.StomSearchPatientModal;
import businessFramework.module.stomatology.pages.resultAdmissionStom.ResultAdmissionPageStom;
import businessFramework.module.stomatology.pages.stomatologyAppointment.StomatologyAppointmentPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StomCaseNoRecord extends TestBase implements Values {
    StomatologyManager stomatologyManager;
    StomatologyAppointmentData stomatologyAppointmentData;
    ResultAdmissionPageStom resultAdmissionPageStom;
    ResultAdmissionDataStom resultAdmissionDataStom;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        stomatologyManager = new StomatologyManager();
        stomatologyAppointmentData = new StomatologyAppointmentData();
        resultAdmissionDataStom = new ResultAdmissionDataStom();

        stomatologyAppointmentData.setPatientFIO("Стоматология Автотест Пациент");
        //Поля случая и посещения
        resultAdmissionDataStom.setMcCaseCareRegimen("Амбулаторный");
        resultAdmissionDataStom.setFundingSourceType("ОМС");
        resultAdmissionDataStom.setMcCaseType("Случай поликлинического обслуживания");
        resultAdmissionDataStom.setCareLevel("Другая");
        resultAdmissionDataStom.setCareProvidingForm("Плановая");
        resultAdmissionDataStom.setCareProvisionCondition("Общий");
        resultAdmissionDataStom.setCaseInitGoal("1 - Заболевание");
        resultAdmissionDataStom.setProfile("Терапия");
        resultAdmissionDataStom.setVisitPlace("в АПУ");
        resultAdmissionDataStom.setService("Прием");
        resultAdmissionDataStom.setMedicalCardPlaceName("В поликлинике");
    }

    @Test(description = "Открытие модуля 'Стоматология'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        page.getHeader().chooseContext("Подразделение стоматологии");
        stomatologyManager.openStomatologyPage();
    }

    @Test(description = "Найти пациента и переход в результаты", dependsOnMethods = "beforeTest")
    public void step1_searchStomPatient() {
        stomatologyManager.getStomatologyAppointmentPage().clickCreateNoRecordAppointment();
        stomatologyManager.getSearchPatienModal().searchPatient(stomatologyAppointmentData);
        StomSearchPatientModal searchPatientModal = stomatologyManager.getSearchPatienModal();
        searchPatientModal.clickConfirm();
    }

    @Test(description = "Заполнение полей случая и посещения", dependsOnMethods = "step1_searchStomPatient")
    public void step2_createStomCaseAndVisit() {
        ResultAdmissionPageStom resultAdmissionPageStom = stomatologyManager.getResultAdmissionPagesStom();
        resultAdmissionPageStom.clickCreateNewCase();
        resultAdmissionPageStom.setValueToField(resultAdmissionDataStom);
        resultAdmissionPageStom.clickSaveCase();
    }

    @Test(description = "Выход из результатов приема на главную страницу", dependsOnMethods = "step2_createStomCaseAndVisit")
    public void step3_exitFromStomResultAdmission() {
        stomatologyManager.openStomatologyPage();
    }

    @Test(description = "Найти пациента и переход в результаты", dependsOnMethods = "step3_exitFromStomResultAdmission")
    public void step4_searchStomSecondPatient() {
        stomatologyManager.getStomatologyAppointmentPage().clickCreateNoRecordAppointment();
        stomatologyManager.getSearchPatienModal().searchPatient(stomatologyAppointmentData);
        StomSearchPatientModal searchPatientModal = stomatologyManager.getSearchPatienModal();
        searchPatientModal.clickConfirm();
    }

    @Test(description = "Копирование последнего посещения", dependsOnMethods = "step4_searchStomSecondPatient")
    public void step5_copyLastVisit() {
        page.refresh(); //todo зависает окно приема при копировании посещения RMISDEV-3209
        ResultAdmissionPageStom resultAdmissionPageStom = stomatologyManager.getResultAdmissionPagesStom();
        resultAdmissionPageStom.selectCase();
        resultAdmissionPageStom.clickCopyLastVisit();
    }

    @Test(description = "Отменить посещение и Талон", dependsOnMethods = "step5_copyLastVisit")
    public void step6_removeVisitAndAppointment() {
        stomatologyManager.openStomatologyPage();
        StomatologyAppointmentPage stomatologyAppointmentPage = stomatologyManager.getStomatologyAppointmentPage();
        stomatologyAppointmentPage.clickCancelStomVisitNoRecord();
        stomatologyAppointmentPage.clickCancelAppointmenNoRecord();
        stomatologyAppointmentPage.clickCancelStomVisitNoRecord();
        stomatologyAppointmentPage.clickCancelAppointmenNoRecord();
    }
}
