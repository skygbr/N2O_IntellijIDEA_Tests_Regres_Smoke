package test.businessTests.hospital;

import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.hospital.HospitalManager;
import businessFramework.module.hospital.pages.prescriptionExecution.PrescriptionServiceExecutionPage;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by bulat.garipov on 02.03.2016.
 */

public class PrescriptionServiceExecutionTest extends TestBase {
    private HospitalData hospitalData;
    private HospitalManager hospitalManager;
    private PrescriptionServiceExecutionPage prescriptionServiceExecutionPage;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException {
        hospitalManager = new HospitalManager();
        hospitalData = new HospitalData();
        hospitalData.setPatient("Стационар Тест Автотестович");
        hospitalData.setDepartment("Отделение экстренной госпитализации");
        hospitalData.setService("Процедура(автотест)");
        hospitalData.setBdateService("12.03.2015 00:00");
    }

    @Test(description = "Выбор контекста, Открытие страницы процедурной мед.сестры")
    public void beforeTest() {
        hospitalManager.openHospitalModule();
        page.getHeader().chooseContext(hospitalData.getDepartment());
        hospitalManager.openPrescriptionExecutionPage();
        prescriptionServiceExecutionPage = hospitalManager.getPrescriptionServiceExecutionPage();
    }

    @Test(description = "Открытие назначений процедур. Фильтрация списка по периоду, пациенту, отделению.", dependsOnMethods = "beforeTest")
    public void filterByPeriodAndDepartment() {
        prescriptionServiceExecutionPage.filter(hospitalData, "12.03.2015");
    }

    @Test(description = "Выполнить процедуру", dependsOnMethods = "filterByPeriodAndDepartment")
    public void execute() {
        prescriptionServiceExecutionPage.execute();
    }

    @Test(description = "Отменить выполнение", dependsOnMethods = "execute")
    public void cancelRendered() {
        prescriptionServiceExecutionPage.cancelRendered();
    }

    @Test(description = "Отказ", dependsOnMethods = "cancelRendered")
    public void refusal() {
        prescriptionServiceExecutionPage.refusal("Отказ");
    }

    @Test(description = "Отменить выполнение, после чего внести результат", dependsOnMethods = "refusal")
    public void addResult() {
        prescriptionServiceExecutionPage.cancelRendered();

        prescriptionServiceExecutionPage.getCreateRenderedButton().click();

        hospitalManager.getServicePage().assertPrescriptionServiceForm(hospitalData);
        hospitalManager.getServicePage().clickConfirmButton();
        hospitalManager.getServicePage().clickBackButton();
        prescriptionServiceExecutionPage.checkAfterRender();
        prescriptionServiceExecutionPage.cancelRendered();
    }

}
