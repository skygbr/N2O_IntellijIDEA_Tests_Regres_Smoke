package test.businessTests.hospital;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RefusalHospitalizationTest extends TestBase
{
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        hospitalData.setAdmissionDepartment("Приемное отделение для отказаза от госпит");
        hospitalData.setPatient("Отказов Евгений Петрович");
        hospitalData.setFinancialType("ОМС");
        hospitalData.setTransportingType("На носилках");
        hospitalData.setCareProvidingForm("Экстренная");
        hospitalData.setInitGoal("Профилактика");
        hospitalData.setRepeatCount("Повторно");
        hospitalData.setSeverityLevel("крайне тяжёлое");
        hospitalData.setDoctor("Нуждина Е. А., Регистратор приемного отделения");
        hospitalData.setDiagnosis("A03.9 Шигеллез неуточненный");
        hospitalData.setRefusalEmployee(hospitalData.getDoctor());
        hospitalData.setStepResultReason("Доставлен не по адресу");
        hospitalData.setStepResult("Лечение прервано по инициативе пациента");
        hospitalData.setUid(String.valueOf(randomInt(9,999,1)));

        hospitalData.setCareRegimen("Стационар круглосуточный");
        hospitalData.setProfile("Вирусология");

        hospitalData.setMark(Boolean.TRUE);
        hospitalData.setRelatives(Boolean.TRUE);
        hospitalData.setInstitution(Boolean.TRUE);
    }

    @Test(description = "Запись в приемном отделении")
    public void step1_createHospitalCase()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getAdmissionDepartment());
        hospitalManager.openAdmisDepart();
        hospitalManager.getAdmisDepartPage().clickCreateHospitalCaseButton();
        hospitalManager.getAdmisDepartPage().getHospitalCasePage().fillHospitalForm(hospitalData);
        hospitalManager.getAdmisDepartPage().getHospitalCasePage().clickConfirmButton();
    }

    @Test(description = "Отказ от госпитализации", dependsOnMethods = "step1_createHospitalCase")
    public void step2_refuseHospitalization()
    {
       hospitalData.setRefusalDate(page.addMinutes(page.getCurrentDateTime(), 3));
       hospitalManager.getAdmisDepartPage().refusalHospitalization(hospitalData);
    }

    @Test(description= "Проверка формы отказа", dependsOnMethods = "step2_refuseHospitalization")
    public void step3_assertRefusalForm()
    {
        hospitalManager.getAdmisDepartPage().getHospitalCasePage().assertRefusalHospitalization(hospitalData);
    }

    @Test(description = "Удаление случая", dependsOnMethods = "step3_assertRefusalForm", alwaysRun = true)
    public void step4_deleteHospitalCase()
    {
        hospitalManager.openAdmisDepart();
        hospitalManager.getAdmisDepartPage().deleteHospitalCase(hospitalData);
    }
}
