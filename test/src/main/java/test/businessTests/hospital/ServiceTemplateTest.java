package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.prescription.PrescriptionHoldingData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplatePrescriptionData;
import businessFramework.entities.hospital.servicesTemplate.ServicesTemplateServiceData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.medicalHistory.MedicalHistoryPage;
import businessFramework.module.hospital.pages.servicesTemplate.ServicesTemplatePage;
import net.framework.autotesting.test.DateUtil;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bulat.garipov on 10.03.2016.
 */
public class ServiceTemplateTest extends TestBase {

    private HospitalManager hospitalManager;

    private HospitalData hospitalData;

    private ServicesTemplateData servicesTemplateDataCreate;
    private ServicesTemplateData servicesTemplateDataEdit;
    private ServicesTemplateData servicesTemplateDataForCheckValidation;

    private ServicesTemplateServiceData servicesTemplateServiceDataCreate;
    private ServicesTemplateServiceData servicesTemplateServiceDataEdit;

    private ServicesTemplatePrescriptionData prescriptionData;
    private ServicesTemplatePrescriptionData prescriptionData_copy;

    private ServicesTemplatePage servicesTemplatePage;

    private String serviceShortForm;
    private String diagnosis;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();

        servicesTemplateDataCreate = new ServicesTemplateData();
        servicesTemplateDataCreate.setName("Шаблон для автотестов");
        servicesTemplateDataCreate.setStandard("Стандарт для автотестов (не трогать)");
        servicesTemplateDataCreate.setType("Только услуги");
        servicesTemplateDataCreate.setNote("Комментарий шаблона автотестов");
        servicesTemplateDataCreate.setBeginDate(DateUtil.getDateWithoutTime("01.06.2015"));
        servicesTemplateDataCreate.setEndDate(DateUtil.getDateWithoutTime("30.07.2015"));

        servicesTemplateDataEdit = new ServicesTemplateData();
        servicesTemplateDataEdit.setName("Шаблон для автотестов (обновление)");
        servicesTemplateDataEdit.setType("Услуги и препараты");
        servicesTemplateDataEdit.setNote("Комментарий шаблона автотестов (обновление)");
        servicesTemplateDataEdit.setBeginDate(DateUtil.getDateWithoutTime("01.06.2015"));
        servicesTemplateDataEdit.setEndDate(DateUtil.getDateWithoutTime("31.07.2015"));

        servicesTemplateDataForCheckValidation =  new ServicesTemplateData();
        servicesTemplateDataForCheckValidation.setName("Шаблон для автотестов (обновление)");
        servicesTemplateDataForCheckValidation.setType("Услуги и препараты");
        servicesTemplateDataForCheckValidation.setBeginDate(DateUtil.getDateWithoutTime("01.06.2015"));
        servicesTemplateDataForCheckValidation.setEndDate(DateUtil.getDateWithoutTime("01.06.2015"));

        servicesTemplateServiceDataCreate = new ServicesTemplateServiceData();
        servicesTemplateServiceDataCreate.setScheduleSelectionType("Срочная запись");
        servicesTemplateServiceDataCreate.setRestriction("1");
        servicesTemplateServiceDataCreate.setService("Услуга для тестирования шаблонов услуг");
        servicesTemplateServiceDataCreate.setResGroup("Сост.ресурс для автотестов стационар");
        servicesTemplateServiceDataCreate.setDepartment("Клиническое отделение автотесты стационар");
        servicesTemplateServiceDataCreate.setDistrict("Участок для Стационара автотест");
        //servicesTemplateServiceDataCreate.setSpeciality("Специальность для автотеста");
        servicesTemplateServiceDataCreate.setProfile("Профиль для стационара автотест");
        servicesTemplateServiceDataCreate.setFunding("ОМС");
        servicesTemplateServiceDataCreate.setQueue("2");
        servicesTemplateServiceDataCreate.setMaxInterval("3");
        servicesTemplateServiceDataCreate.setIndent("4");
        servicesTemplateServiceDataCreate.setIndentMeasure("ч.");

        servicesTemplateServiceDataEdit = new ServicesTemplateServiceData();
        servicesTemplateServiceDataEdit.setScheduleSelectionType("Без записи");

        serviceShortForm = "Услуга шаблона";
        diagnosis = "холера";

        // препарат
        prescriptionData = new ServicesTemplatePrescriptionData();
        prescriptionData.setAdministrationRoute("Перорально");
        prescriptionData_copy = new ServicesTemplatePrescriptionData();
        prescriptionData_copy.setAdministrationRoute("Перорально");

        PrescriptionHoldingData holdingData0 = new PrescriptionHoldingData();
        holdingData0.setIndex(0);
        holdingData0.setCount(new BigDecimal(1));

        PrescriptionHoldingData holdingData1 = new PrescriptionHoldingData();
        holdingData1.setIndex(1);
        holdingData1.setDose(new BigDecimal(15));

        PrescriptionHoldingData holdingData_copy = new PrescriptionHoldingData();
        holdingData_copy.setIndex(0);
        holdingData_copy.setCount(new BigDecimal(1));

        prescriptionData.setHoldings(new ArrayList<>());
        prescriptionData.getHoldings().add(holdingData0);
        prescriptionData.getHoldings().add(holdingData1);
        prescriptionData.setTemplateNote("создание");
        prescriptionData.setPeriodicity("2 раза в день");
        prescriptionData.setTimes(2);
        prescriptionData.setBeginDay(2);
        prescriptionData.setCountDay(4);

        prescriptionData_copy = prescriptionData.clone();
        prescriptionData_copy.setHoldings(new ArrayList<>());
        prescriptionData_copy.getHoldings().add(holdingData_copy);

        // Лек. назначение по шаблону
        hospitalData = new HospitalData();
        hospitalData.setPatient("Стационар Второй Александрович");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Шаблон услуг'")
    public void openServiceTemplate()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext("Отделение экстренной госпитализации");
        hospitalManager.openServicesTemplatePage();
        servicesTemplatePage = hospitalManager.getServicesTemplatePage();
    }

    @Test(description = "1. Создание и изменение шаблона", dependsOnMethods = "openServiceTemplate")
    public void step1_servicesTemplate_create_and_update() {
        servicesTemplatePage.createAndUpdateServicesTemplate(servicesTemplateDataCreate, servicesTemplateDataEdit);
    }

    @Test(description = "2. Создание услуги шаблона (краткая форма)",
            dependsOnMethods = "step1_servicesTemplate_create_and_update")
    public void step2_createServicesTemplateService() {
        servicesTemplatePage.createServiceInShortForm(serviceShortForm);
        servicesTemplatePage.getServicesTemplateServiceContainer().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "3. Удаление услуги шаблона (краткая форма)",
            dependsOnMethods = "step2_createServicesTemplateService")
    public void step3_deleteServicesTemplateServiceInShortForm() {
        servicesTemplatePage.deleteServiceInShortForm(serviceShortForm);
        servicesTemplatePage.getServicesTemplateServiceContainer().getTable().assertThatCountOfRowsIs(1);

    }

    @Test(description = "4. Попытка изменить период шаблона (который не совпадает с периодом услуги). Должна сработать валидация",
            dependsOnMethods = "step3_deleteServicesTemplateServiceInShortForm")
    public void step4_checkServiceTemplateValidation() {
        servicesTemplatePage.checkServiceTemplateValidation(servicesTemplateDataForCheckValidation);
    }

    @Test(description = "5. Удаление услуги шаблона",
            dependsOnMethods = "step4_checkServiceTemplateValidation")
    public void step5_deleteServicesTemplateService() {
        servicesTemplatePage.deleteServicesTemplateService();
    }

    @Test(description = "6. Создание диагноза под шаблон", dependsOnMethods = "step5_deleteServicesTemplateService")
    public void step6_createServicesTemplateDiagnosis() {
        servicesTemplatePage.getServicesTemplateDiagnosisContainer().clickContainer();
        servicesTemplatePage.createDiagnosis(diagnosis);
        servicesTemplatePage.getServicesTemplateDiagnosisContainer().getTable().assertThatCountOfRowsIs(2);
    }

    @Test(description = "7. Удаление диагноза через саму форму (чекбокс)",
            dependsOnMethods = "step6_createServicesTemplateDiagnosis")
    public void step7_deleteServicesTemplateDiagnosisAcrossCheckBox() {
        servicesTemplatePage.deleteDiagnosisAcrossCheckBox(diagnosis);
        servicesTemplatePage.getServicesTemplateDiagnosisContainer().getTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "8. Удаление диагноза через кнопку на списке",
            dependsOnMethods = "step7_deleteServicesTemplateDiagnosisAcrossCheckBox")
    public void step8_deleteServicesTemplateDiagnosisAcrossButton() {
        servicesTemplatePage.deleteDiagnosisAcrossButton();
    }

    @Test(description = "9. Вкладка Препарат: Создание, Проверка, Копирование, Удаление",
            dependsOnMethods = "step8_deleteServicesTemplateDiagnosisAcrossButton")
    public void step9_servicesTemplateHoldingOperations() {
        servicesTemplatePage.getServicesTemplateHoldingContainer().clickContainer();

        servicesTemplatePage.createHolding(prescriptionData);
        servicesTemplatePage.getServicesTemplateHoldingTable().assertThatCountOfRowsIs(1);
        servicesTemplatePage.assertHolding(prescriptionData);

        servicesTemplatePage.updateHolding(prescriptionData);
        servicesTemplatePage.getServicesTemplateHoldingTable().assertThatCountOfRowsIs(1);
        servicesTemplatePage.assertHolding(prescriptionData);
        servicesTemplatePage.closeAllModalsOnPage();

        servicesTemplatePage.copyHolding(prescriptionData, prescriptionData_copy);
        servicesTemplatePage.getServicesTemplateHoldingTable().assertThatCountOfRowsIs(2);
        servicesTemplatePage.assertHolding(prescriptionData_copy);

        servicesTemplatePage.closeAllModalsOnPage();
        servicesTemplatePage.deleteHolding();
        servicesTemplatePage.getServicesTemplateHoldingTable().assertThatCountOfRowsIs(1);
    }

    @Test(description = "10. Лек.назначение по шаблону",  dependsOnMethods = "step9_servicesTemplateHoldingOperations")
    public void step10_createPrescriptionByTemplate() {
        servicesTemplatePage.closeAllModalsOnPage();
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
        MedicalHistoryPage medicalHistoryPage = hospitalManager.getBranchManagerPage().getMedicalHistoryPage();

        medicalHistoryPage.createPrescriptionByTemplate(prescriptionData, servicesTemplateDataEdit.getName());
        medicalHistoryPage.createAndConfirmPrescriptionByTemplate(prescriptionData, servicesTemplateDataEdit.getName());
        medicalHistoryPage.createConfirmAndCancelPrescriptionByTemplate(prescriptionData, servicesTemplateDataEdit.getName());
    }

    @Test(description = "11. Удаление шаблона",
            dependsOnMethods = "step10_createPrescriptionByTemplate", alwaysRun = true)
    public void step11_deleteServicesTemplate() {
        servicesTemplatePage.closeAllModalsOnPage();
        hospitalManager.openServicesTemplatePage();
        servicesTemplatePage.filterTemplateById();
        servicesTemplatePage.deleteServicesTemplate();
    }

}
