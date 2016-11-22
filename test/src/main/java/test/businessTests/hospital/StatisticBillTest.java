package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class StatisticBillTest extends TestBase
{
    private HospitalManager hospitalManager;
    private HospitalData hospitalData;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        hospitalData.setDepartment("Департамент финансирования");
        hospitalData.setPatient("Счетов Игорь Иванович");
    }

    @Test(description = "Поиск пациента, для которого сформирован счет")
    public void step1_openPageAndFindPatient()
    {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openStatistic();
        hospitalManager.getStatisticsPage().getFilter().getAdmissionDate().setPeriod("", "");
        hospitalManager.getStatisticsPage().getFilter().getPatient().setValue(hospitalData.getPatient());
        hospitalManager.getStatisticsPage().getFilter().getHasBill().selectOption(1);
        hospitalManager.getStatisticsPage().getContainerStatisticalMapList().getFilter().clickFindButton();
        assertThat("Rows doesn't present in table",
                hospitalManager.getStatisticsPage().getContainerStatisticalMapList().getTable().getCountRowsInTable(true), greaterThan(0));
    }

    @Test(description = "Просмотр счета", dependsOnMethods = "step1_openPageAndFindPatient")
    public void step2_assertBill()
    {
        hospitalManager.getStatisticsPage().getContainerStatisticalMapList().getTable().chooseRowInTable(0);
        hospitalManager.getStatisticsPage().assertBill();
    }
}
