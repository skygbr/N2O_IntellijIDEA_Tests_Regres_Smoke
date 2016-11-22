package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.ServiceRenderedByTemplateData;
import businessFramework.module.hospital.HospitalManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import net.framework.autotesting.test.TestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 05.03.2016.
 */
public class MedicalHistory_ServiceByTemplateTest extends TestBase {
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;
    private ServiceRenderedByTemplateData data;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();

        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setDoctor("Нуждина Е. А., Врач стационара");
        hospitalData.setDiagnosis("");
        hospitalData.setStageDiagnosis("Клинический");
        hospitalData.setAdmissionDepartment("Отделение экстренной госпитализации");
        hospitalData.setUid("191");

        data = new ServiceRenderedByTemplateData();
        data.setTemplate("Шаблон 1 автотест");

        List<String> serviceList = new ArrayList<>();
        serviceList.add("Услуга шаблона 1 автотест");
        serviceList.add("Услуга шаблона 2 автотест");
        serviceList.add("Услуга шаблона 3 автотест");
        data.setServiceNameList(serviceList);

        List<String> columnNameList = new ArrayList<>();
        columnNameList.add("Услуга");
        columnNameList.add("Статус");
        columnNameList.add("Дата и время");
        data.setColumnNameList(columnNameList);
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Истории болезни'")
    public void step01_openMedicalHistory() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
    }

    @Test(description = "Создание услуг по шаблону", dependsOnMethods = "step01_openMedicalHistory")
    public void step02_createServiceRenderedByTemplate() {
        data.setBdate(hospitalManager.getBranchManagerPage().getMedicalHistoryPage().getAdmissionDateFromHistoryMainData() + " 23:00");
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createServiceByTemplate(data);
    }

    @Test(description = "Ф-ция 'Отмена'", dependsOnMethods = "step02_createServiceRenderedByTemplate")
    public void step03_cancel() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().cancel(data);
    }

    @Test(description = "Удалить", dependsOnMethods = "step03_cancel")
    public void step04_delete() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deletePlannedServices();
    }

}
