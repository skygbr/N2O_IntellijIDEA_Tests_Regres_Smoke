package test.businessTests.hospital;

import businessFramework.entities.dAccount.CommissionReferralData;
import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 05.01.2016.
 */
public class CommissionReferralTest extends TestBase {
    private CommissionReferralData commissionReferralData;
    private HospitalData hospitalData;

    private HospitalManager hospitalManager;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();

        commissionReferralData = new CommissionReferralData();
        commissionReferralData.setPatient("Стационар Второй Александрович (28.01.1988)");
        commissionReferralData.setRecvOrganization("Стационар для автотестов");
        commissionReferralData.setOrderNumber("1234567899");
        commissionReferralData.setReferralDate(getCurrentDate());
        commissionReferralData.setGoal("Изменение схемы лечения");
        commissionReferralData.setClinicalForm("1. Инфильтративный туберкулез легких");

        List<String> diagnosisTree = new ArrayList<>();
        diagnosisTree.add("G00-G99 БОЛЕЗНИ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree.add("G00-G09 ВОСПАЛИТЕЛЬНЫЕ БОЛЕЗНИ ЦЕНТРАЛЬНОЙ НЕРВНОЙ СИСТЕМЫ");
        diagnosisTree.add("G00 Бактериальный менингит, не классифицированный в других рубриках");
        diagnosisTree.add("G00.3 Стафилококковый менингит");
        commissionReferralData.setMainDiagnos(diagnosisTree);
        commissionReferralData.setMainDiagnosCode("G00.3");

        hospitalData = new HospitalData();
        hospitalData.setPatient("Стационар Второй Александрович");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
    }

    @Test(description = "Отркытие страницы 'Заведующий отделением'")
    public void step1_openPage() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openBranchManager();
        hospitalManager.getBranchManagerPage().filterByPatient(hospitalData);
    }


    @Test(description = "Направить на ЦВКК", dependsOnMethods = "step1_openPage")
    public void step2_commissionReferralClick() {
        hospitalManager.getBranchManagerPage().clickCommissionReferralButton();
        hospitalManager.getBranchManagerPage().getCommissionReferralPage().create(commissionReferralData);
        hospitalManager.getBranchManagerPage().getTable().getAlerts().assertSuccessAlertIsPresent();
    }

}
