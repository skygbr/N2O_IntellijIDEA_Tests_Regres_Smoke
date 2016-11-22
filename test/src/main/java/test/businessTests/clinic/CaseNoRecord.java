package test.businessTests.clinic;

import businessFramework.entities.clinic.ClinicAppointmentData;
import businessFramework.entities.clinic.ResultAdmissionData;
import businessFramework.module.Values;
import businessFramework.module.clinic.ClinicManager;
import businessFramework.module.clinic.modals.searchPatient.SearchPatientModal;
import businessFramework.module.clinic.pages.clinicAppointment.ClinicAppointmentPages;
import businessFramework.module.clinic.pages.resultAdmission.ResultAdmissionPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class CaseNoRecord extends TestBase implements Values {
    ClinicManager clinicManager;
    ResultAdmissionData resultAdmissionData;
    ClinicAppointmentData clinicAppointmentData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        clinicManager = new ClinicManager();
        resultAdmissionData = new ResultAdmissionData();
        clinicAppointmentData = new ClinicAppointmentData();

        //данные для поиска пациента без записи
        clinicAppointmentData.setPatientFIO("Пациент Автотестов Поликлиники");

        //Поля случая и посещения
        resultAdmissionData.setFundingSourceType("ОМС");
        resultAdmissionData.setMcCaseType("Случай поликлинического обслуживания");
        resultAdmissionData.setCaseInitGoal("1 - Заболевание");
        resultAdmissionData.setCareProvidingForm("Плановая");
        resultAdmissionData.setCareLevel("Другая");
        resultAdmissionData.setCareProvisionCondition("Общий");
        resultAdmissionData.setVisitPlace("в АПУ");
        resultAdmissionData.setProfile("Терапия");
        resultAdmissionData.setDiagnosis("A01.1 Паратиф А");
        resultAdmissionData.setService("Осмотр");
        resultAdmissionData.setDiseaseType("1");
    }


    @Test(description = "Открытие модуля 'Поликлиника'")
    public void beforeTest() {
        app.getNavigationHelper().openMainPage();
        //Изменен размер окна браузера из-за проблем заполнения полей в шаге step2_createCaseAndVisit
        app.getWebDriverHelper().getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        page.getHeader().chooseContext("Подразделение поликлиники");
        clinicManager.openClinicPage();
    }

    @Test(description = "Найти пациента и переход в результаты", dependsOnMethods = "beforeTest")
    public void step1_searchPatient() {
        clinicManager.getClinicAppointmentPages().clickCreateNoRecordAppointment();
        clinicManager.getSearchPatienModal().searchPatient(clinicAppointmentData);
        SearchPatientModal searchPatientModal = clinicManager.getSearchPatienModal();
        searchPatientModal.clickConfirm();
    }

    @Test(description = "Заполнение полей случая и посещения", dependsOnMethods = "step1_searchPatient")
    public void step2_createCaseAndVisit() throws AWTException {
        //TODO убрать refresh после фикса бага  RMISDEV-3209
        page.refresh();
        ResultAdmissionPage resultAdmissionPage = clinicManager.getResultAdmissionPages();
        resultAdmissionPage.clickCreateNewCase();
        resultAdmissionPage.setValueToField(resultAdmissionData);
        resultAdmissionPage.clickSaveCase();
    }

    @Test(description = "Выход из результатов приема на главную страницу", dependsOnMethods = "step2_createCaseAndVisit")
    public void step3_exitFromResultAdmission() {
        clinicManager.openClinicPage();
    }

    @Test(description = "Найти пациента и переход в результаты", dependsOnMethods = "step3_exitFromResultAdmission")
    public void step4_searchSecondPatient() {
        clinicManager.getClinicAppointmentPages().clickCreateNoRecordAppointment();
        clinicManager.getSearchPatienModal().searchPatient(clinicAppointmentData);
        SearchPatientModal searchPatientModal = clinicManager.getSearchPatienModal();
        searchPatientModal.clickConfirm();
    }

    @Test(description = "Копирование последнего посещения", dependsOnMethods = "step4_searchSecondPatient")
    public void step5_copyLastVisit() {
        page.refresh(); //todo зависает окно приема при копировании посещения RMISDEV-3209
        ResultAdmissionPage resultAdmissionPage = clinicManager.getResultAdmissionPages();
        resultAdmissionPage.selectCase(resultAdmissionData.getDiagnosis());
        resultAdmissionPage.clickCopyLastVisit();
    }

    @Test(description = "Отменить посещение и Талон", dependsOnMethods = "step5_copyLastVisit", alwaysRun = true)
    public void step6_removeVisitAndAppointment() {
        clinicManager.openClinicPage();
        ClinicAppointmentPages clinicAppointmentPages = clinicManager.getClinicAppointmentPages();
            clinicAppointmentPages.clickCancelVisitNoRecord();
            clinicAppointmentPages.clickCancelAppointmenNoRecord();
            clinicAppointmentPages.clickCancelVisitNoRecord();
            clinicAppointmentPages.clickCancelAppointmenNoRecord();

    }
}
