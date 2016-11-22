package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.entities.hospital.ServiceRenderedByTemplateData;
import businessFramework.entities.hospital.SickListIssuedAnotherClinicData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 02.03.2016.
 */
public class MedicalHistory_SickListTest extends TestBase {

    private SickListIssuedAnotherClinicData sickListData1;
    private SickListIssuedAnotherClinicData sickListData2;

    private HospitalManager hospitalManager;
    private HospitalData hospitalData;

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

        sickListData1 = new SickListIssuedAnotherClinicData();
        sickListData1.setIssueDate("01.10.2015");
        sickListData1.setNumber("123456789123");

        sickListData2 = new SickListIssuedAnotherClinicData();
        sickListData2.setIssueDate("02.10.2015");
        sickListData2.setNumber("123456789456");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Истории болезни'")
    public void step01_openMedicalHistory() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
    }

    @Test(description = "Выдан в другом МО", dependsOnMethods = "step01_openMedicalHistory")
    public void step02_createSickListIssuedAnotherClinic() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().createSickListIssuedAnotherClinic(sickListData1);
    }

    @Test(description = "Изменить ЛН", dependsOnMethods = "step02_createSickListIssuedAnotherClinic")
    public void step03_updateSickListIssuedAnotherClinic() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updateSickListIssuedAnotherClinic(sickListData1, sickListData2);
    }

    @Test(description = "Удалить ЛН", dependsOnMethods = "step03_updateSickListIssuedAnotherClinic", alwaysRun = true)
    public void step04_deleteSickListIssuedAnotherClinic() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().deleteSickListIssuedAnotherClinic();
    }


}
