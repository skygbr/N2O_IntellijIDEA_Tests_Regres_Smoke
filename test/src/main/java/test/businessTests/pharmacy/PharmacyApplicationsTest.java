package test.businessTests.pharmacy;


import businessFramework.entities.pharmacy.PharmacyApplicationsData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyApplicationsManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PharmacyApplicationsTest extends TestBase implements Values
{

    private PharmacyApplicationsData pAData;
    private PharmacyApplicationsManager pAManager;
    public int createdRecordRow;
    public int editedRecordRow;
    public int createdSpecRow;

    @BeforeClass
    public void initialize() throws CloneNotSupportedException
    {
        pAData = new PharmacyApplicationsData();
        pAManager = new PharmacyApplicationsManager();

        /** Данные для выбора контекста */
        pAData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для проверка значений в поле "Статус документа" в фильтре */
        pAData.setDocStatus("Все");

        /** Данные для проверки заголовка модального окна "Добавление заявки" */
        pAData.setCreateAppModalHeader("Добавление заявки");

        /** Данные для заполнения и проверки значений в полях в модальном окне "Создание заявки" */
        pAData.setDocType("Заявка");
        pAData.setYear("2016");
        pAData.setAppType("Годовая");
        pAData.setPrefixNumber(randomInt(5));
        pAData.setDate(page.getCurrentDate());
        pAData.setFinancing("test_funding_source");
        pAData.setDepartment("Отделение экстренной госпитализации");
        pAData.setStore("Склад отделения экстренной госпитализации");
        pAData.setProductGroup("Тестовая тов. группа");
        pAData.setComment(randomChar(40));

        /** Данные для сообщения об успешном сохранении заявки ( после добавления)*/
        pAData.setSuccessMessageAfterAddingApp(String.format("Заявка № %s сохранена", pAData.getPrefixNumber()));

        /** Данные для проверки заголовка модального окна редактирования заявки */
        pAData.setEditAppModalHeader(String.format("Заявка №%s от %s", pAData.getPrefixNumber(), pAData.getDate()));

        /** Данные для изменения данных в модальном окне редактирования заявки */
        pAData.setCommentEdited(randomChar(41));
        pAData.setPrefixNumberEdited(randomInt(4));
        pAData.setProductGroupEdited("Лекарственные средства");

        /** Данные для проверки заголовка модального окна просмотра заявки */
        pAData.setViewAppModalHeader(String.format("Заявка №%s от %s", pAData.getPrefixNumberEdited(), pAData.getDate()));

        /** Данные для сообщения об успешном сохранении заявки (после редактирования)*/
        pAData.setSuccessMessageAfterEditingApp(String.format("Заявка № %s сохранена", pAData.getPrefixNumberEdited()));

        /** Данные для заполнения полей в модальном окне добавления спецификации */
        pAData.setNameLS_IMNSpec("Цитрамон 250 мг табл Уп.№30");
        pAData.setCountSpec("5");
        pAData.setPriceWithNDSSpec("10");
        pAData.setCommentSpec(randomInt(42));
        pAData.setCreatorSpec("Контрольная МО");
        pAData.setSumWithNDSSpec("50.00");
        pAData.setSumWithNDSSpecAssert("50");

        /** Данные для проверки заголовка модального окна добавления спецификации */
        pAData.setAddSpecModalHeader(String.format("Заявка № %s от %s. Добавление спецификации.", pAData.getPrefixNumberEdited(),page.getCurrentDate()));

        /** Данные для проверки значений в таблице в контейнере "Спецификации" после добавления спецификации*/
        pAData.setCountSt("5");
        pAData.setUnitSt("уп.");
        pAData.setPriceSt("10.000");
        pAData.setSumSt("50.000");

        /** Данные для проверки заголовка модального окна добавления спецификации */
        pAData.setEditSpecModalHeader("Спецификация");

        /** Данные для проверки и заполнения значений в модальном окне при редактировании спецификации */
        pAData.setCountSpecEdited("10");
        pAData.setPriceWithNDS_SpecEdited("1");
        pAData.setSumWithNDS_specEdited("10.00");
        pAData.setSumWithNDS_specEditedAssert("10");

        /** Данные для проверки текста в подтверждающем модальном окне подтверждения утверждения заявки*/
        pAData.setMessageExecutingApplicationDialog(String.format("Вы действительно хотите утвердить документ № %s?", pAData.getPrefixNumberEdited()));

        /** Данные для проверки текста сообщения об успешном утверждении заявки*/
        pAData.setSuccessExecutingMessage(String.format("Статус документа № %s изменён на \"утверждён\"", pAData.getPrefixNumberEdited()));

        /** Данные для проверки заголовков и значений в столбцах таблицы "Заявки" ("статус" и "утвержден") */
        pAData.setStatusTD("Статус");
        pAData.setExecutedTDValue("не утвержден");

        /** Данные для процедуры консолидации */
        pAData.setConsolidateNumberOne("to_consolidate_1");
        pAData.setConsolidateNumberTwo("to_consolidate_2");
        pAData.setSumApplicationType("Сводная заявка");
        pAData.setSumApplicationNumber("consolidated_sum_application");
        pAData.setConsolidationSuccessMessage("Консолидация завершена. Сводная заявка № consolidated_sum_application сохранена");

        pAData.setDepartmentList(new ArrayList<>());
        pAData.getDepartmentList().add("Отделение экстренной госпитализации");
        pAData.getDepartmentList().add("Отделение экстренной госпитализации");
    }

    @Test (description = "Открытие модуля 'Заявки'")
    public void step1_openApplicationsPage()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(pAData.getDepartmentForContext());
        pAManager.openPharmacyApplicationsPage();
    }

    @Test (description = "Открытие фильтра и проверка значений в полях в фильтре", dependsOnMethods = "step1_openApplicationsPage")
    public void step2_checkDateFieldsInFilter()
    {
        pAManager.getPharmacyApplicationsPage().openFilterForApplicationsList();
        pAManager.getPharmacyApplicationsPage().checkDatesValues();
        pAManager.getPharmacyApplicationsPage().checkFilterFieldsValues(pAData.getDocStatus());
    }

    @Test (description = "Создание заявки", dependsOnMethods = "step1_openApplicationsPage")
    public void step3_addApplication()
    {
        pAManager.getPharmacyApplicationsPage().clickAddAppButton();
        pAManager.getPharmacyApplicationsPage().getApplicationModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkModalHeader(pAData.getCreateAppModalHeader());

        pAManager.getPharmacyApplicationsPage().getApplicationModal().fillFields(null, null, pAData.getAppType(), pAData.getPrefixNumber(), null, pAData.getFinancing(), null, pAData.getStore(), pAData.getProductGroup(), pAData.getComment());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkFields(pAData.getDocType(), pAData.getYear(), null, null, pAData.getDate(), null, pAData.getDepartment(), pAData.getStore(), null, null);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().clickSaveAppButton();

        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertIsPresent();
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertMessage(pAData.getSuccessMessageAfterAddingApp());
        createdRecordRow = pAManager.getPharmacyApplicationsPage().checkAppTableValues(pAData.getAppType(), pAData.getPrefixNumber(), pAData.getDate(), pAData.getYear(), pAData.getDepartment(), pAData.getStore(), null, pAData.getFinancing(), pAData.getProductGroup());

    }

    @Test (description = "Редактирование заявки", dependsOnMethods = "step3_addApplication")
    public void step4_editApplication()
    {
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseRowInTable(createdRecordRow);
        pAManager.getPharmacyApplicationsPage().clickEditAppButton();
        pAManager.getPharmacyApplicationsPage().getApplicationModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkModalHeader(pAData.getEditAppModalHeader());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkFields(pAData.getDocType(), pAData.getYear(), pAData.getAppType(), pAData.getPrefixNumber(), pAData.getDate(), pAData.getFinancing(), pAData.getDepartment(), pAData.getStore(), pAData.getProductGroup(), pAData.getComment());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().fillFields(null, null, null, pAData.getPrefixNumberEdited(), null, null, null, null, pAData.getProductGroupEdited(), pAData.getCommentEdited());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().clickSaveAppButton();

        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertIsPresent();
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertMessage(pAData.getSuccessMessageAfterEditingApp());

        editedRecordRow = pAManager.getPharmacyApplicationsPage().checkAppTableValues(pAData.getAppType(), pAData.getPrefixNumberEdited(), pAData.getDate(), pAData.getYear(), pAData.getDepartment(), pAData.getStore(), null, pAData.getFinancing(), pAData.getProductGroupEdited());
    }

    @Test (description = "Просмотр заявки", dependsOnMethods = "step4_editApplication")
    public void step5_viewApplication()
    {
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseRowInTable(editedRecordRow);
        pAManager.getPharmacyApplicationsPage().clickViewAppButton();

        pAManager.getPharmacyApplicationsPage().getApplicationModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkModalHeader(pAData.getViewAppModalHeader());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkFields(pAData.getDocType(), pAData.getYear(), pAData.getAppType(), pAData.getPrefixNumberEdited(), pAData.getDate(), pAData.getFinancing(), pAData.getDepartment(), pAData.getStore(), pAData.getProductGroupEdited(), pAData.getCommentEdited());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkFieldsDisability();
        pAManager.getPharmacyApplicationsPage().getApplicationModal().closeModal();
    }

    @Test (description = "Создание спецификации", dependsOnMethods = "step5_viewApplication")
    public void step6_createSpecification()
    {
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseRowInTable(editedRecordRow);
        pAManager.getPharmacyApplicationsPage().clickAddSpecButton();

        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkModalHeader(pAData.getAddSpecModalHeader());

        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().fillFields(pAData.getNameLS_IMNSpec(), pAData.getCreatorSpec(), pAData.getCountSpec(), pAData.getPriceWithNDSSpec(), null, pAData.getComment());
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkFields(null, null, pAData.getCountSpec(), null, pAData.getSumWithNDSSpec(), null);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().clickSaveAppSpecButton();
        // todo проверка сообщения об успешном сохранении, после того, как поправят https://jira.i-novus.ru/browse/HOTTESTLSD-3443
        createdSpecRow = pAManager.getPharmacyApplicationsPage().checkSpecTableValues(pAData.getNameLS_IMNSpec(), pAData.getCountSt(), pAData.getUnitSt(), pAData.getPriceSt(), pAData.getSumSt());

    }

    @Test (description = "Редактирование спецификации", dependsOnMethods = "step6_createSpecification")
    public void step7_editSpecification()
    {
        pAManager.getPharmacyApplicationsPage().getSpecificationsTable().chooseRowInTable(createdSpecRow);
        pAManager.getPharmacyApplicationsPage().clickEditSpecButton();

        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkModalHeader(pAData.getEditSpecModalHeader());

        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkFields(pAData.getNameLS_IMNSpec(), pAData.getCreatorSpec(), pAData.getCountSpec(), pAData.getPriceWithNDSSpec(), pAData.getSumWithNDSSpecAssert(), pAData.getComment());
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().fillFields(null, null, pAData.getCountSpecEdited(), pAData.getPriceWithNDS_SpecEdited(), null, null);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkFields(null, null, null, null, pAData.getSumWithNDS_specEdited(), null);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().clickSaveAppSpecButton();
        // todo проверка сообщения об успешном сохранении, после того, как поправят https://jira.i-novus.ru/browse/HOTTESTLSD-3443
    }

    @Test (description = "Просмотр спецификации", dependsOnMethods = "step7_editSpecification")
    public void step8_viewSpecification()
    {
        pAManager.getPharmacyApplicationsPage().getSpecificationsTable().chooseRowInTable(createdSpecRow);
        pAManager.getPharmacyApplicationsPage().clickViewSpecButton();

        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkModalHeader(pAData.getEditSpecModalHeader());
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkFields(pAData.getNameLS_IMNSpec(), pAData.getCreatorSpec(), pAData.getCountSpecEdited(), pAData.getPriceWithNDS_SpecEdited(), pAData.getSumWithNDS_specEditedAssert(), pAData.getComment());
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().checkFieldsDisability();
        pAManager.getPharmacyApplicationsPage().getCreateAppSpecModal().closeModal();

    }

    @Test (description = "Проведение заявки", dependsOnMethods = "step8_viewSpecification")
    public void step9_executingApplication()
    {
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseRowInTable(editedRecordRow);
        pAManager.getPharmacyApplicationsPage().clickApproveButton();
        pAManager.getPharmacyApplicationsPage().getDialog().assertGeneralMessageContainsText(pAData.getMessageExecutingApplicationDialog());
        pAManager.getPharmacyApplicationsPage().getDialog().clickYes();

        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertIsPresent();
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertMessage(pAData.getSuccessExecutingMessage());

    }

    @Test(description = "Косолидация заявок", dependsOnMethods = "step9_executingApplication", enabled = false)
    public void step10_consolidateApplication() {
        List<String> valueList = new ArrayList<>();
        valueList.add(pAData.getConsolidateNumberOne());
        valueList.add(pAData.getConsolidateNumberTwo());
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseGroupRowsByColumnValues("Номер", valueList);
        pAManager.getPharmacyApplicationsPage().getConsolidateApplicationButton().click();
        pAManager.getPharmacyApplicationsPage().getApplicationModal().assertCountOfModals(1);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().getPrefixNumberField().setValue(pAData.getSumApplicationNumber());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().getStoreField().setValue(pAData.getStore());
        pAManager.getPharmacyApplicationsPage().getApplicationModal().checkSumApplicationFields(pAData.getSumApplicationType(), pAData.getYear(), pAData.getAppType(), pAData.getSumApplicationNumber(), pAData.getDate(), pAData.getFinancing(), pAData.getDepartmentList(), pAData.getStore(), pAData.getProductGroup(), null);
        pAManager.getPharmacyApplicationsPage().getApplicationModal().clickSaveAppButton();
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertIsPresent();
        pAManager.getPharmacyApplicationsPage().getApplicationsTable().getAlerts().assertSuccessAlertMessage(pAData.getConsolidationSuccessMessage());
    }

    @Test (description = "Удаление созданных данных", dependsOnMethods = "step9_executingApplication")
    public void step11_deleteCreatedRecords()
    {
        if (pAManager.getPharmacyApplicationsPage().getCountOfModals() > 0)
        {
            pAManager.getPharmacyApplicationsPage().getModal().closeModal();
        }

        if (pAManager.getPharmacyApplicationsPage().getApplicationsTable().getCountRowsInTable(true) > 0 && !pAManager.getPharmacyApplicationsPage().getApplicationsTable().assertNoRecordsReturnResult())
        {
            while (pAManager.getPharmacyApplicationsPage().getApplicationsTable().getCountRowsInTable(true) > 0 && !pAManager.getPharmacyApplicationsPage().getApplicationsTable().assertNoRecordsReturnResult())
            {
                pAManager.getPharmacyApplicationsPage().getApplicationsTable().chooseRowInTable(0);
                List<String> elements = pAManager.getPharmacyApplicationsPage().getApplicationsTable().getColumnValues(pAData.getStatusTD());

                if (elements.get(0).equals(pAData.getExecutedTDValue()))
                {
                    pAManager.getPharmacyApplicationsPage().clickDeleteAppButton();
                    pAManager.getPharmacyApplicationsPage().getDialog().clickYes();
                }
                else
                {
                    pAManager.getPharmacyApplicationsPage().clickCancelApproveButton();
                    pAManager.getPharmacyApplicationsPage().getDialog().clickYes();
                    pAManager.getPharmacyApplicationsPage().clickDeleteAppButton();
                    pAManager.getPharmacyApplicationsPage().getDialog().clickYes();
                }
            }
        }
    }
}
