package test.businessTests.gibddMedicalExamination.settingsGibdd;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.GibddMedicalExaminationManager;
import businessFramework.module.gibddMedicalExamination.modals.patientModel.PatientModelModal;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class ModelPatientsTest extends TestBase
{
    GibddMedicalExaminationManager gMPManager;
    GibddMedicalExaminationData gMPData;
    GibddMedicalExaminationData gMPAData;

    @BeforeClass
    public void initialize() {
        gMPData = new GibddMedicalExaminationData();
        gMPAData = new GibddMedicalExaminationData();
        gMPManager = new GibddMedicalExaminationManager();

        gMPData.setContextName("Подразделение для ОДОДСГ");
        gMPData.setSearchPatientModelName("Автотест модель пациента");

        // Данные для полей в модальном окне "Модель пациента" базовая модель
        gMPData.setHeaderPatientModelModal("Модель пациента");
        gMPData.setPatientModelName("Автотест модель пациента (базовая)");
        // Пол
        gMPData.setPatientModelGender("Мужской,Женский,Не определенный");
        gMPData.setPatientModelGenderMan("Мужской");
        gMPData.setPatientModelGenderFemale("Женский");
        gMPData.setPatientModelGenderIndefinite("Не определенный");
        gMPData.setPatientModelSocial("Иностранные граждане");
        // Категории ТС
        gMPData.setLicenseCategoryA("Категория A"); gMPData.setLicenseCategoryA1("Категория A1");
        gMPData.setLicenseCategoryB("Категория B"); gMPData.setLicenseCategoryB1("Категория B1"); gMPData.setLicenseCategoryBE("Категория BE");
        gMPData.setLicenseCategoryC("Категория C"); gMPData.setLicenseCategoryC1("Категория C1"); gMPData.setLicenseCategoryCE("Категория CE"); gMPData.setLicenseCategoryC1E("Категория C1E");
        gMPData.setLicenseCategoryD("Категория D"); gMPData.setLicenseCategoryD1("Категория D1"); gMPData.setLicenseCategoryDE("Категория DE"); gMPData.setLicenseCategoryA("Категория D1E");
        // Текст сообщения об успешном сохранении данных на странице в контейнере "Список моделей пациента"
        gMPData.setSuccessSavingPatientModelAlertMessage("Данные успешно сохранены для модели \"Автотест модель пациента (базовая)\"");
        gMPData.setPerformedInTheYearEventBase("0,10,20,30,40,50, 0,0.10,1.8,2.6,3.4,4.2, 1.12,0,10,20,30,40,50, 0,0.10,1.8,2.6,3.4,4.2, 1.12,0,10,20,30,40,50, 0,0.10,1.8,2.6,3.4,4.2, 1.12");
        gMPData.setStatusExecuted("✔");


        // Данные для полей в модальном окне "Модель пациента" дополнительная модель
        gMPAData.setPatientModelName("Автотест модель пациента (дополнительная)");
        // Пол
        gMPAData.setPatientModelGender("Мужской,Женский");
        gMPAData.setPatientModelGenderMan("Мужской");
        gMPAData.setPatientModelGenderFemale("Женский");
        gMPAData.setPatientModelSocial("Работающий");
        // Категории ТС
        gMPAData.setLicenseCategoryM("Категория M");
        gMPAData.setLicenseCategoryTm("Категория Tm"); gMPAData.setLicenseCategoryTb("Категория Tb");
        // Текст сообщения об успешном сохранении данных на странице в контейнере "Список моделей пациента"
        gMPAData.setSuccessSavingPatientModelAlertMessage("Данные успешно сохранены для модели \"Автотест модель пациента (дополнительная)\"");
        gMPAData.setPerformedInTheYearEventAdditional("51,61,71,81,91, 4.3,5.1,5.11,6.9,7.7, 10.12,51,61,71,81,91, 4.3,5.1,5.11,6.9,7.7, 10.12");
        gMPAData.setStatusExecuted("✘");


    }

    @Test(description = "Подготовка тестовых данных: удаление моделей пациента, если такие существуют")
    public void beforeTest()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(gMPData.getContextName());      // Выбрать контекст для модуля
        gMPManager.openModelPatients();                              // Открытие Настроек, переход на страницу "Список моделей пациента"
        gMPManager.getModelPatientsPage().deleteAllModels(gMPData);
        gMPManager.getModelPatientsPage().getModelsTable().assertThatTableContainsOnlyXRows(0);
    }

    @Test(description = "Открытие модуля Освидетельствование для справки в ГИБДД, контейнер Список моделей пациента, проверка что в таблице нет записей по фильтру", dependsOnMethods = "beforeTest", enabled = true)
    public void step1_openModelPatientsModule()
    {
        gMPManager.openModelPatients();                                // Переход в настроки "Список моделей пациента"
        gMPManager.getModelPatientsPage().filterName(gMPData);
        gMPManager.getModelPatientsPage().getModelsTable().assertNoRecords();
    }

    @Test(description = "Добавление базовой 'Модели пациента'", dependsOnMethods = "step1_openModelPatientsModule", enabled = true)
    public void step2_addModelPatients() {
        gMPManager.getModelPatientsPage().pressCreateModelsButton();
        PatientModelModal patientModelModal = gMPManager.getModelPatientsPage().getPatientModelModal();
        patientModelModal.assertCountOfModals(1);
        patientModelModal.checkModalHeader(String.format(gMPData.getHeaderPatientModelModal()));
        patientModelModal.fillFieldsPatientModel(gMPData);
        patientModelModal.pressConfirmButton();
        gMPManager.getModelPatientsPage().getModelsTable().getAlerts().assertSuccessAlertMessage(gMPData.getSuccessSavingPatientModelAlertMessage());
        gMPManager.getModelPatientsPage().checkRecordBaseModelsTable(gMPData.getPatientModelName(), gMPData.getPatientModelGender(), gMPData.getPerformedInTheYearEventBase());
        System.out.println("Добавлена запись в таблице:\n Наименование " + gMPData.getPatientModelName() + "\nПол " + gMPData.getPatientModelGender() + "\nВозраст "
                + gMPData.getPerformedInTheYearEventBase() + "\nБазовая " + gMPData.getStatusExecuted());
    }

    @Test(description = "Добавление дополнительной 'Модели пациента'", dependsOnMethods = "step2_addModelPatients", enabled = true)
    public void step3_addAdditionalModelPatients() {
        gMPManager.getModelPatientsPage().pressCreateModelsButton();
        PatientModelModal patientModelModal = gMPManager.getModelPatientsPage().getPatientModelModal();
        patientModelModal.assertCountOfModals(1);
        patientModelModal.checkModalHeader(String.format(gMPData.getHeaderPatientModelModal()));
        patientModelModal.fillFieldsPatientAdditionalModel(gMPAData);
        patientModelModal.pressConfirmButton();
        gMPManager.getModelPatientsPage().getModelsTable().getAlerts().assertSuccessAlertMessage(gMPAData.getSuccessSavingPatientModelAlertMessage());
        gMPManager.getModelPatientsPage().checkRecordAdditionalModelsTable(gMPAData.getPatientModelName(), gMPAData.getPatientModelGender(), gMPAData.getPerformedInTheYearEventBase());
        System.out.println("Добавлена запись в таблице с наименованием:\n" + gMPAData.getPatientModelName() + " - " + gMPAData.getPatientModelGender() + " - \n"
                + gMPAData.getPerformedInTheYearEventBase() + " - " + gMPAData.getStatusExecuted());

    }



}
