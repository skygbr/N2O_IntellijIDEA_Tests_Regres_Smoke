package test.businessTests.hospital;

import businessFramework.entities.hospital.*;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 29.01.2016.
 */
public class MedicalHistory_HospitalizationInfoTest extends TestBase {
    private HospitalData hospitalData;
    private HospitalManager hospitalManager;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setAdmissionDepartment("Отделение экстренной госпитализации ");
        hospitalData.setCareProvidingForm("Экстренная");
        hospitalData.setDrunkennessType("Наркотическое");
        hospitalData.setWhereFromDelivered("из дома");
        hospitalData.setNarcoticSubstance("Наркотик А1");
    }

    @Test(description = "Выбор контекста, Открытие страницы 'Истории болезни'")
    public void step01_openMedicalHistory() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
        hospitalManager.getBranchManagerPage().clickMedicalHistory();
    }

    @Test(description = "Информация о госпитализации. Заполнение формы", dependsOnMethods = "step01_openMedicalHistory")
    public void step02_fillForm() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().updateHospitalizationInfo(hospitalData);
    }

    @Test(description = "Информация о госпитализации. Проверка после сохранения", dependsOnMethods = "step02_fillForm")
    public void step03_assertForm() {
        hospitalManager.getBranchManagerPage().getMedicalHistoryPage().assertHospitalizationInfoForm(hospitalData);
    }
}
