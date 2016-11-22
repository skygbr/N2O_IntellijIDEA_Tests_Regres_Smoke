package test.businessTests.gibddMedicalExamination.settingsGibdd;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.GibddMedicalExaminationManager;
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
public class ServiceByDocTest extends TestBase
{
    GibddMedicalExaminationManager gMEManager;
    GibddMedicalExaminationData gMEData;

    @BeforeClass
    public void initialize() {
        gMEData = new GibddMedicalExaminationData();
        gMEManager = new GibddMedicalExaminationManager();

        gMEData.setContextName("Подразделение для ОДОДСГ");

    }

    @Test(description = "Открытие модуля Освидетельствование для справки в ГИБДД, контейнер Услуги по нормативному документу")
    public void step1_openHospitalModule()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(gMEData.getContextName());   // Выбрать контекст для модуля
        gMEManager.openServiceByDoc();                              // Открытие Настроек, переход на страницу "Услуги по нормативному документу"
    }

}
