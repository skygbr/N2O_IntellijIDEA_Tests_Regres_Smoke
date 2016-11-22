package test.businessTests.hospital;

import businessFramework.entities.hospital.referral.HospReferralData;
import businessFramework.module.Values;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HospPlanning_HospitalReferralTest extends TestBase implements Values
{
    private HospitalManager hospitalManager;
    private HospReferralData referralData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        referralData = new HospReferralData();

        referralData.setPatient("Стационар Станислав Александрович");
        referralData.setPatientId(7360551);
        referralData.setRefOrgRole("МО");
        referralData.setRefOrg("Стационар для автотестов");
        referralData.setRefDep("Отделение экстренной госпитализации");
        referralData.setRefEmployee("Нуждина Е. А.");

        referralData.setRecvOrgCode("00001");
        referralData.setRecvOrg("Контрольная МО");
        referralData.setRecvDep("Оториноларингология");
        referralData.setRecvEmployee("Доков Д. Д.");

        referralData.setRefDate(getCurrentDate());
        referralData.setCito(true);
        referralData.setRefType("направление на госпитализацию");
        referralData.setRecvRegimen("Стационар круглосуточный");
        referralData.setFinType("ОМС");
        referralData.setRefComment("создание");
        referralData.setOrderNumber("78451293");

        referralData.setRefDiagnosis("A08.0 Ротавирусный энтерит");
        referralData.setRefDiagnosisComment("диагноз");
    }

    @Test(description = "Подготовка тестовых данных: удаление напрвлений пациента, если такие существуют")
    public void beforeTest()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(referralData.getRefDep());
        hospitalManager.openReferralListPage();
        hospitalManager.getReferralListPage().removePatientReferrals(referralData);
    }

    @Test(description = "Создание направления, проверка, возврат к списку", dependsOnMethods = "beforeTest")
    public void step01_createHospitalReferral()
    {
        hospitalManager.getReferralListPage().createReferral(referralData);
        hospitalManager.getReferralListPage().assertReferral(referralData);
        hospitalManager.getReferralListPage().backToReferralList();
    }

    @Test(description = "Найти направление", dependsOnMethods = "step01_createHospitalReferral")
    public void step02_findHospitalReferral()
    {
        hospitalManager.getReferralListPage().findReferral(referralData);
    }


    @Test(description = "Редактирование направления, проверка, возврат к списку", dependsOnMethods = "step02_findHospitalReferral")
    public void step03_updateHospitalReferral()
    {
        hospitalManager.getReferralListPage().updateReferral(referralData);
        hospitalManager.getReferralListPage().assertReferral(referralData);
        hospitalManager.getReferralListPage().backToReferralList();
    }

    @Test(description = "Удаление направления", dependsOnMethods = "step03_updateHospitalReferral")
    public void step04_removeHospitalReferral()
    {
        hospitalManager.getReferralListPage().removeReferral(referralData);
    }
}
