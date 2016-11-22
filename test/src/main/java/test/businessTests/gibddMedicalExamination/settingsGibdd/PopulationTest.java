package test.businessTests.gibddMedicalExamination.settingsGibdd;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.GibddMedicalExaminationManager;
import businessFramework.module.gibddMedicalExamination.modals.population.PopulationModal;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class PopulationTest extends TestBase {
    GibddMedicalExaminationManager gPManager;
    GibddMedicalExaminationData gPData;
    GibddMedicalExaminationData gPEditData;
    GibddMedicalExaminationData gPDayAndMonthData;
    GibddMedicalExaminationData gPDayAndMonthAutoData;

    @BeforeClass
    public void initialize() {
        gPData = new GibddMedicalExaminationData();
        gPEditData = new GibddMedicalExaminationData();
        gPDayAndMonthData = new GibddMedicalExaminationData();
        gPDayAndMonthAutoData = new GibddMedicalExaminationData();

        gPManager = new GibddMedicalExaminationManager();

        gPData.setContextName("Подразделение для ОДОДСГ");

        // Данные для ввода и проверки значений в полях
        gPData.setHeaderPopulationModal("Численность населения");
        gPData.setPopulationName("ОДОДСГ," + gPManager.getPopulationPage().getFormattedDateYear());
        gPData.setOrgName("ОДОДСГ");
        gPData.setYear("01.01." + gPManager.getPopulationPage().getFormattedDateYear());
        gPData.setM21_36Begin("6000");
        gPData.setM39_60Begin("4000");
        gPData.setM60Begin("2000");
        gPData.setF21_36Begin("9000");
        gPData.setF39_60Begin("6000");
        gPData.setF60Begin("3000");
        gPData.setM21_36Disp("2000");
        gPData.setM39_60Disp("1500");
        gPData.setM60Disp("1000");
        gPData.setF21_36Disp("3000");
        gPData.setF39_60Disp("2500");
        gPData.setF60Disp("2000");
        gPData.setCh0_4Disp("500");
        gPData.setCh5_9Disp("400");
        gPData.setCh10_14Disp("300");
        gPData.setCh15_17Disp("100");

        // Данные для ввода в контейнер Численность населения
        gPEditData.setYear("01.01." + gPManager.getPopulationPage().getFormattedDateNextYear());
        gPEditData.setM21_36Begin("6006");
        gPEditData.setM39_60Begin("4004");
        gPEditData.setM60Begin("2002");
        gPEditData.setF21_36Begin("9009");
        gPEditData.setF39_60Begin("6006");
        gPEditData.setF60Begin("3003");
        gPEditData.setM21_36Disp("2002");
        gPEditData.setM39_60Disp("1551");
        gPEditData.setM60Disp("1001");
        gPEditData.setF21_36Disp("3003");
        gPEditData.setF39_60Disp("2552");
        gPEditData.setF60Disp("2002");
        gPEditData.setCh0_4Disp("505");
        gPEditData.setCh5_9Disp("404");
        gPEditData.setCh10_14Disp("303");
        gPEditData.setCh15_17Disp("101");

        // Данные для ввода в контейнер Численность населения текущая дата + 5 лет
        gPDayAndMonthData.setYear(gPManager.getPopulationPage().getFormattedDate20XX());

        // Данные для проверки даты в контейнере Списка ЧС 01.01.yyyy + 5 лет
        gPDayAndMonthAutoData.setYear("01.01."+ gPManager.getPopulationPage().getFormattedDate20XXYear());
    }


    @Test(description = "Открытие модуля Освидетельствование для справки в ГИБДД, переход в настройки контейнер ЧН(Численность населения)")
    public void step1_openPopulationModule()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(gPData.getContextName());   // Выбрать контекст для модуля
        gPManager.openPopulation();                                // Открытие Настроек, переход на страницу "Численность населения"
    }

    @Test(description = "Добавление в список ЧН на текущий год, выбор в списке созданного ЧН и проверка данных в полях", dependsOnMethods = "step1_openPopulationModule", enabled = true)
    public void step2_choosePopulationName()
    {
        gPManager.getPopulationPage().pressCreatePopulationButton();
        PopulationModal populationModal = gPManager.getPopulationPage().getPopulationModal();
        populationModal.assertCountOfModals(1);
        populationModal.checkModalHeader(String.format(gPData.getHeaderPopulationModal()));
        populationModal.setValuesToFields(gPData);
        populationModal.clickConfirm();
        gPManager.getPopulationPage().choosePopulationName();
        gPManager.getPopulationPage().checkFieldsData(gPData.getOrgName(), gPData.getYear(), gPData.getM21_36Begin(),
                gPData.getM39_60Begin(), gPData.getM60Begin(), gPData.getF21_36Begin(), gPData.getF39_60Begin(), gPData.getF60Begin(),
                gPData.getM21_36Disp(), gPData.getM39_60Disp(), gPData.getM60Disp(), gPData.getF21_36Disp(), gPData.getF39_60Disp(),
                gPData.getF60Disp(), gPData.getCh0_4Disp(), gPData.getCh5_9Disp(), gPData.getCh10_14Disp(), gPData.getCh15_17Disp());
    }

    @Test(description = "Изменение и проверка сохранения данных в полях в контейнере ЧН", dependsOnMethods = "step2_choosePopulationName", enabled = true)
    public void step3_editAndCheckPopulationName()
    {
        gPManager.getPopulationPage().pressUpdatePopulationButton();
        gPManager.getPopulationPage().setValuesToFields(gPEditData);
        gPManager.getPopulationPage().clickConfirm();
        gPManager.getPopulationPage().getAlerts().assertSuccessAlertIsPresent();

        gPManager.getPopulationPage().pressUpdatePopulationButton();
        gPManager.getPopulationPage().assertCountOfModals(0);
        gPManager.getPopulationPage().checkFieldsData(gPData.getOrgName(), gPEditData.getYear(), gPEditData.getM21_36Begin(),
                gPEditData.getM39_60Begin(), gPEditData.getM60Begin(), gPEditData.getF21_36Begin(), gPEditData.getF39_60Begin(), gPEditData.getF60Begin(),
                gPEditData.getM21_36Disp(), gPEditData.getM39_60Disp(), gPEditData.getM60Disp(), gPEditData.getF21_36Disp(), gPEditData.getF39_60Disp(),
                gPEditData.getF60Disp(), gPEditData.getCh0_4Disp(), gPEditData.getCh5_9Disp(), gPEditData.getCh10_14Disp(), gPEditData.getCh15_17Disp());
        gPManager.getPopulationPage().clickCancel();
    }

    @Test(description = "Возврат данных для списка ЧС в полях к исходному значению и проверка сохранения данных в полях в контейнере ЧН", dependsOnMethods = "step3_editAndCheckPopulationName", enabled = true)
    public void step4_returnPopulationName()
    {
        gPManager.getPopulationPage().pressUpdatePopulationButton();
        gPManager.getPopulationPage().setValuesToFields(gPData);
        gPManager.getPopulationPage().clickConfirm();
        gPManager.getPopulationPage().getAlerts().assertSuccessAlertIsPresent();
        gPManager.getPopulationPage().assertCountOfModals(0);
        gPManager.getPopulationPage().checkFieldsData(gPData.getOrgName(), gPData.getYear(), gPData.getM21_36Begin(),
                gPData.getM39_60Begin(), gPData.getM60Begin(), gPData.getF21_36Begin(), gPData.getF39_60Begin(), gPData.getF60Begin(),
                gPData.getM21_36Disp(), gPData.getM39_60Disp(), gPData.getM60Disp(), gPData.getF21_36Disp(), gPData.getF39_60Disp(),
                gPData.getF60Disp(), gPData.getCh0_4Disp(), gPData.getCh5_9Disp(), gPData.getCh10_14Disp(), gPData.getCh15_17Disp());
    }

    @Test(description = "Добавление в список ЧН списка на следующий год и проверка системной валидации в модальном окне", dependsOnMethods = "step4_returnPopulationName", enabled = true)
    public void step5_addAndEditPopulationName()
    {
        gPManager.getPopulationPage().pressCreatePopulationButton();
        PopulationModal populationModal = gPManager.getPopulationPage().getPopulationModal();
        populationModal.assertCountOfModals(1);
        populationModal.checkModalHeader(String.format(gPData.getHeaderPopulationModal()));
        populationModal.setValuesToCreateFields(gPData);
        populationModal.clickConfirm();
        populationModal.assertPopulationYearValidationMessage();
        populationModal.clickCancel();

        gPManager.getPopulationPage().pressCreatePopulationButton();
        populationModal.assertCountOfModals(1);
        populationModal.setValuesToFields(gPEditData);
        populationModal.clickConfirm();
        gPManager.getPopulationPage().getPopulationNameTable().getAlerts().assertSuccessAlertIsPresent();
    }

    @Test(description = "Проверка значений ЧН в полях на странице контейнера при нажатии кнопки редактировать и проверка системной валидации", dependsOnMethods = "step5_addAndEditPopulationName", enabled = true)
    public void step6_checkNewPopulationName()
    {
        gPManager.getPopulationPage().chooseNewPopulationName();
        gPManager.getPopulationPage().pressUpdatePopulationButton();
        gPManager.getPopulationPage().checkFieldsData(gPData.getOrgName(), gPEditData.getYear(), gPEditData.getM21_36Begin(),
                gPEditData.getM39_60Begin(), gPEditData.getM60Begin(), gPEditData.getF21_36Begin(), gPEditData.getF39_60Begin(), gPEditData.getF60Begin(),
                gPEditData.getM21_36Disp(), gPEditData.getM39_60Disp(), gPEditData.getM60Disp(), gPEditData.getF21_36Disp(), gPEditData.getF39_60Disp(),
                gPEditData.getF60Disp(), gPEditData.getCh0_4Disp(), gPEditData.getCh5_9Disp(), gPEditData.getCh10_14Disp(), gPEditData.getCh15_17Disp());
        gPManager.getPopulationPage().setValuesToAlertFields(gPData);
        gPManager.getPopulationPage().clickConfirm();
        gPManager.getPopulationPage().assertPopulationYearContValidationMessage();
        gPManager.getPopulationPage().setValuesToAlertFields(gPEditData);
        gPManager.getPopulationPage().clickCancel();
        page.getAlerts().acceptAlert();
    }

    @Test(description = "Проверка при передачи текущей даты, при сохранение 'день' и 'месяц' изменяется на '01.01.(+5 year)'", dependsOnMethods = "step6_checkNewPopulationName", enabled = true)
    public void step7_checkDateAndMonthPopulationName()
    {
        gPManager.getPopulationPage().pressCreatePopulationButton();
        PopulationModal populationModal = gPManager.getPopulationPage().getPopulationModal();
        populationModal.assertCountOfModals(1);
        populationModal.checkModalHeader(String.format(gPData.getHeaderPopulationModal()));
        populationModal.setValuesToCreateDateAndMonthFields(gPDayAndMonthData);
        populationModal.clickConfirm();
        gPManager.getPopulationPage().choosePopulation20XXYearName();
        gPManager.getPopulationPage().checkFieldsDateAndMonthData(gPDayAndMonthAutoData.getYear());
    }

    @Test(description = "Удаление из таблицы списка ЧН созданные записи", dependsOnMethods = "step7_checkDateAndMonthPopulationName", enabled = false)
    public void step8_deletePopulationName()
    {
        gPManager.getPopulationPage().deleteAllCreateListPopulation();
    }

}
