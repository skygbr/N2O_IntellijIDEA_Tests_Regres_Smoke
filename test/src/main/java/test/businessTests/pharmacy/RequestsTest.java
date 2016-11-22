package test.businessTests.pharmacy;

import businessFramework.entities.pharmacy.PharmacyData;
import businessFramework.module.Values;
import businessFramework.module.pharmacy.PharmacyManager;
import net.framework.autotesting.test.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RequestsTest extends TestBase implements Values
{

    private PharmacyManager pharmacyManager;
    private PharmacyData pharmacyData;

    @BeforeClass
    public void initialize()
    {
        pharmacyManager = new PharmacyManager();
        pharmacyData = new PharmacyData();

        pharmacyData.setDepartmentForContext("Отделение экстренной госпитализации");

        /** Данные для модального окна "Требование" */
        pharmacyData.setRequestDocumentType("Требование");
        pharmacyData.setRequestNumber("Требование №1");
        pharmacyData.setRequestDate(page.getCurrentDate());
        pharmacyData.setRequestSendStore("Тестовый_склад_аптека");
        pharmacyData.setRequestStore("Тестовый_склад_отделение");
        pharmacyData.setRequestFundingSource("test_funding_source");
        pharmacyData.setRequestCommodityGroup("Тестовая тов. группа");
        String dateString = getFormattedDateString(new Date());
        pharmacyData.setRequestTrustDocumentNumberAndDate("Дов. №trust_doc_for_request_doc," + " " + dateString);
        pharmacyData.setRequestChangedNumber("Требование №2");
        pharmacyData.setRequestNumberColumnName("Номер");


        /** Данные для модального окна "Спецификация" */
        pharmacyData.setRequestSpecificationMedicineName("Тестовая модификация");
        pharmacyData.setRequestSpecificationMedicamentQuantity("5");
        pharmacyData.setRequestSpecificationMneiQuantity("5");
        pharmacyData.setRequestChangedSpecificationMedicamentQuantity("3");
        pharmacyData.setRequestChangedSpecificationMneiQuantity("3");

        /** Данные для проверки записи в таблице "Требования" */
        pharmacyData.setRequestTrustDocumentNumber("2015-1");

        /**Данные для заголовков модальных окон*/
        pharmacyData.setRequestModalHeader("Требование");
        pharmacyData.setUpdateAndViewSpecificationModalHeader("Спецификация требования №Требование №2 от " + page.getCurrentDate() + ".");
        pharmacyData.setAddSpecificationModalHeader("Спецификация требования №Требование №2 от " + page.getCurrentDate() + ". Добавление.");

        /**Данные для алертов(уведомлений об успешном сохранении и тд) */
        pharmacyData.setSuccessSaveAlertMessage("Спецификация сохранена");

        /**Данные для таблицы "Требования" */
        pharmacyData.setStatusApproved("утвержден");
    }

    private String getFormattedDateString(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    @Test (description = "Открытие модуля 'Контракты'")
    public void step1_openRequestsPageAndAssertFilter()
    {
        app.getNavigationHelper().openMainPage();
        page.getHeader().chooseContext(pharmacyData.getDepartmentForContext());
        pharmacyManager.openRequests();
        pharmacyManager.getRequestsPage().assertFilter();
    }

    @Test (description = "Создание требования: Нажатие на кнопку 'Создать', заполнение полей, проверка создания требования", dependsOnMethods = "step1_openRequestsPageAndAssertFilter")
    public void step2_createRequest()
    {
        pharmacyManager.getRequestsPage().clickCreateRequest();
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalHeader(pharmacyData.getRequestModalHeader());
        pharmacyManager.getRequestsPage().getRequestModal().fillRequestModalFields(pharmacyData.getRequestNumber(), pharmacyData.getRequestStore(), pharmacyData.getRequestSendStore(),pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup(), pharmacyData.getRequestTrustDocumentNumberAndDate());
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalFields(pharmacyData.getDocumentType(), null, pharmacyData.getRequestDate(), null, null, null, null);
        pharmacyManager.getRequestsPage().getRequestModal().clickSaveRequestButton();
        pharmacyManager.getRequestsPage().assertRequestListSuccessMessage("Требование № " + pharmacyData.getRequestNumber() + " сохранено");
        pharmacyManager.getRequestsPage().checkRecordInRequestTable(pharmacyData.getRequestNumber(), pharmacyData.getRequestDate(), pharmacyData.getRequestStore(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup(), null, "не отработан", null);
    }

    @Test (description = "Редактирование требования: Нажатие на кнопку 'Изменить', проверка полей, заполнение полей, проверка отредактированного требования", dependsOnMethods = "step2_createRequest")
    public void step3_editRequest()
    {
        pharmacyManager.getRequestsPage().clickEditRequest();
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalHeader(pharmacyData.getRequestModalHeader());
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalFields(pharmacyData.getDocumentType(), pharmacyData.getRequestNumber(), pharmacyData.getRequestDate(), pharmacyData.getRequestStore(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup(), pharmacyData.getRequestTrustDocumentNumberAndDate());
        pharmacyManager.getRequestsPage().getRequestModal().fillRequestModalFields(pharmacyData.getRequestChangedNumber(), pharmacyData.getRequestChangedStore(), pharmacyData.getRequestSendStore(),null, null,null);
        pharmacyManager.getRequestsPage().getRequestModal().clickSaveRequestButton();
        pharmacyManager.getRequestsPage().assertRequestListSuccessMessage("Требование № " + pharmacyData.getRequestChangedNumber() + " сохранено");
        pharmacyManager.getRequestsPage().checkRecordInRequestTable(pharmacyData.getRequestChangedNumber(), pharmacyData.getRequestDate(), pharmacyData.getRequestChangedStore(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup(),null, "не отработан", null);
    }

    @Test (description = "Просмотр требования: Нажатие на кнопку 'Просмотр', проверка полей", dependsOnMethods = "step3_editRequest")
    public void step4_viewRequest()
    {
        pharmacyManager.getRequestsPage().clickViewRequest();
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalHeader(pharmacyData.getRequestModalHeader());
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalFields(pharmacyData.getDocumentType(), pharmacyData.getRequestChangedNumber(), pharmacyData.getRequestDate(), pharmacyData.getRequestChangedStore(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup(), pharmacyData.getRequestTrustDocumentNumberAndDate());
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalDisability();
        pharmacyManager.getRequestsPage().getModal().closeModal();
    }

    @Test (description = "Копирование требования: Нажатие на кнопку 'Копировать', заполнение полей, проверка создания требования", dependsOnMethods = "step4_viewRequest")
    public void step5_copyRequest()
    {
        pharmacyManager.getRequestsPage().getRequestsListContainer().showFilter();
        pharmacyManager.getRequestsPage().getRequestsListContainer().getFilter().clickClearButton();
        pharmacyManager.getRequestsPage().getRequestsListTable().chooseRowInTableByColumnValue("Номер","request_for_copy_test");
        pharmacyManager.getRequestsPage().clickCopyRequest();
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalHeader(pharmacyData.getRequestModalHeader());
        pharmacyManager.getRequestsPage().getRequestModal().assertRequestModalFields(pharmacyData.getDocumentType(), null, pharmacyData.getRequestDate(), null, null, null, null);

        pharmacyManager.getRequestsPage().getRequestModal().getRequestNumber().setValue("request_for_copy_1_test");
        pharmacyManager.getRequestsPage().getRequestModal().getRequestStore().setValue("Тестовый_склад_отделение");
        pharmacyManager.getRequestsPage().getRequestModal().getRequestSendStore().setValue("Тестовый_склад_аптека");

        pharmacyManager.getRequestsPage().getRequestModal().clickSaveRequestButton();
        pharmacyManager.getRequestsPage().assertRequestListSuccessMessage("Копирование завершено. Требование № request_for_copy_1_test добавлено.");
        pharmacyManager.getRequestsPage().checkRecordInRequestTable("request_for_copy_1_test", pharmacyData.getRequestDate(), pharmacyData.getRequestStore(), "test_funding_source", "Тестовая тов. группа",null, "не отработан", null);
    }

    @Test (description = "Создание спецификации: Нажатие на кнопку 'Добавить', проверка фильтров окна 'Спецификация', выбор модификации лекарственного средства, нажатие на кнопку 'Добавить', заполнение полей модального окна, проверка созданной спецификации", dependsOnMethods = "step5_copyRequest")
    public void step6_createSpecification()
    {
        Map<String, String> columnAndValue = new HashMap<>();
        columnAndValue.put(pharmacyData.getRequestNumberColumnName(),pharmacyData.getRequestChangedNumber());

        pharmacyManager.getRequestsPage().getRequestsListTable().chooseRowBySeveralColumnValues(columnAndValue);
        pharmacyManager.getRequestsPage().clickCreateSpecification();
        pharmacyManager.getSpecificationsPage().assertBatchListFilter(pharmacyData.getRequestFundingSource(), pharmacyData.getRequestCommodityGroup());
        pharmacyManager.getSpecificationsPage().filterAndSelectModification(pharmacyData.getRequestSpecificationMedicineName());
        pharmacyManager.getSpecificationsPage().clickAddSpecification();
        pharmacyManager.getSpecificationsPage().assertAddSpecificationModalHeader(pharmacyData.getAddSpecificationModalHeader());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().fillSelectedSpecificationModal(pharmacyData.getRequestSpecificationMedicamentQuantity());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().assertSelectedSpecificationModalFields(pharmacyData.getRequestSpecificationMedicineName(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestSpecificationMedicamentQuantity(), pharmacyData.getRequestSpecificationMneiQuantity());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().clickSaveSelectedSpecificationButton();
        pharmacyManager.getSpecificationsPage().assertBatchListSuccessMessage(pharmacyData.getSuccessSaveAlertMessage());
    }

    @Test (description = "Редактирование спецификации: Нажатие на кнопку 'Изменить', проверка и заполнение полей модального окна", dependsOnMethods = "step6_createSpecification")
    public void step7_editSpecification()
    {
        pharmacyManager.getSpecificationsPage().clickUpdateSpecification();
        pharmacyManager.getSpecificationsPage().assertUpdateAndViewSpecificationModalHeader(pharmacyData.getUpdateAndViewSpecificationModalHeader());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().assertSelectedSpecificationModalFields(pharmacyData.getRequestSpecificationMedicineName(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestSpecificationMedicamentQuantity(), pharmacyData.getRequestSpecificationMneiQuantity());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().fillSelectedSpecificationModal(pharmacyData.getRequestChangedSpecificationMedicamentQuantity());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().clickSaveSelectedSpecificationButton();
        pharmacyManager.getSpecificationsPage().assertSpecificationListSuccessMessage(pharmacyData.getSuccessSaveAlertMessage());
    }

    @Test (description = "Просмотр спецификации: Нажатие на кнопку 'Просмотр', проверка заблокированности и значений полей модального окна", dependsOnMethods = "step7_editSpecification")
    public void step8_viewSpecification()
    {
        pharmacyManager.getSpecificationsPage().clickViewSpecification();
        pharmacyManager.getSpecificationsPage().assertUpdateAndViewSpecificationModalHeader(pharmacyData.getUpdateAndViewSpecificationModalHeader());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().assertSelectedSpecificationModalDisability();
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().assertSelectedSpecificationModalFields(pharmacyData.getRequestSpecificationMedicineName(), pharmacyData.getRequestFundingSource(), pharmacyData.getRequestChangedSpecificationMedicamentQuantity(), pharmacyData.getRequestChangedSpecificationMneiQuantity());
        pharmacyManager.getSpecificationsPage().getRequestSpecificationModal().closeAllModalsOnPage();
        pharmacyManager.getSpecificationsPage().closePage();
    }

    @Test (description = "Проведение спецификации: Нажатие на кнопку 'Утвердить', принятие диалогового окна с предупреждением, проверка сообщение об успешном проведении", dependsOnMethods = "step8_viewSpecification")
    public void step9_RequestApproval()
    {
        pharmacyManager.getRequestsPage().clickApproveRequestAndAcceptDialog();
        pharmacyManager.getRequestsPage().assertRequestListSuccessMessage("Данные сохранены");
    }

    @Test (description = "Удаление требований", dependsOnMethods = "step9_RequestApproval", alwaysRun = true)
    public void step10_DeleteRequests()
    {
        pharmacyManager.openRequests();
        pharmacyManager.getRequestsPage().filterRequestByDate(pharmacyData.getRequestDate(),pharmacyData.getRequestDate());
        while (pharmacyManager.getRequestsPage().getRequestsListTable().getCountRowsInTable(true) > 0)
        {
            pharmacyManager.getRequestsPage().getRequestsListTable().chooseRowInTable(0);
            if (pharmacyManager.getRequestsPage().getRequestsListTable().getRowColumnIntersectionValue(0, "Статус", true).equals(pharmacyData.getStatusApproved()))
            {
                pharmacyManager.getRequestsPage().clickDisapproveRequestAndAcceptDialog();
            }
            pharmacyManager.getRequestsPage().getRequestsListTable().chooseRowInTable(0);
            pharmacyManager.getRequestsPage().clickDeleteRequestAndAcceptDialog();
        }
    }
}
