package businessFramework.module.pharmacy.pages.requests;

import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.Request.RequestModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RequestsPage extends RequestsHelper implements Values
{
    public RequestsPage(ApplicationManager app)
    {
        super(app);
    }

    /* -------------------- Кнопки в контейнере "Требования" ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickCreateRequest()
    {
        Button createRequest = getCreateRequestButton();
        createRequest.assertIsEnabled();
        createRequest.click();
    }

    /**
     * Нажатие на кнопку "Изменить"
     */
    public void clickEditRequest()
    {
        Button editRequest = getEditRequestButton();
        editRequest.assertIsEnabled();
        editRequest.click();
    }

    /**
     * Нажатие на кнопку "Копировать"
     */
    public void clickCopyRequest()
    {
        Button copyRequest = getCopyRequestButton();
        copyRequest.assertIsEnabled();
        copyRequest.click();
    }

    /**
     * Нажатие на кнопку "Просмотр"
     */
    public void clickViewRequest()
    {
        Button viewRequest = getViewRequestButton();
        viewRequest.assertIsEnabled();
        viewRequest.click();
    }

    /**
     * Нажатие на кнопку "Утвердить" и потдверждение диалогового окна
     */
    public void clickApproveRequestAndAcceptDialog()
    {
        Button approveRequest = getApproveRequestButton();
        approveRequest.assertIsEnabled();
        approveRequest.click();
        getDialog().clickYes();
    }

    /**
     * Нажатие на кнопку "Отменить утверждение" и потдверждение диалогового окна
     */
    public void clickDisapproveRequestAndAcceptDialog()
    {
        Button disapproveRequest = getDisapproveRequestButton();
        disapproveRequest.assertIsEnabled();
        disapproveRequest.click();
        getDialog().clickYes();
    }

    /**
     * Нажатие на кнопку "Удалить" и потдверждение диалогового окна
     */
    public void clickDeleteRequestAndAcceptDialog()
    {
        Button deleteRequest = getDeleteRequestButton();
        deleteRequest.assertIsEnabled();
        deleteRequest.click();
        getDialog().clickYes();
    }

    /* -------------------- Кнопки в контейнере "Спецификации" ------------------------- */

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickCreateSpecification()
    {
        Button createSpecification = getCreateSpecificationButton();
        createSpecification.assertIsEnabled();
        createSpecification.click();
    }

    /* -------------------- Действия в контейнере "Требования" ------------------------- */

    /**
     * Получение модального окна "Требование"
     */
    public RequestModal getRequestModal()
    {
        return new RequestModal(app);
    }

    /**
     * Проверка поля "Дата" в фильтре
     */
    public void assertFilter()
    {
        getRequestsListContainer().showFilter();

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("MM.yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String beginDate = "01." + formatBegin.format(nowDate);
        String endDate = formatEnd.format(nowDate);

        getFilterContractDate().assertThatPeriodContainsValues(beginDate, endDate);
    }

    public void filterRequestByDate(String documentBeginDate, String documentEndDate)
    {
        getRequestsListContainer().showFilter();
        getFilterContractDate().setBeginDateValue(documentBeginDate);
        getFilterContractDate().setEndDateValue(documentEndDate);
        getRequestsListContainer().getFilter().clickFindButton();
    }

    /**
     * Проверка что созданное требование отобразилось в таблице и было выбрано
     *
     * @param number            Номер требования
     * @param documentDate      Дата документа
     * @param store             Получатель
     * @param fundingSource     Финансирование
     * @param commodityGroup    Тов. группа
     * @param trustDoc          Доверенность
     * @param status            Статус
     * @param executionDate     Дата отработки
     */
    public void checkRecordInRequestTable(String number, String documentDate, String store, String fundingSource, String commodityGroup, String trustDoc, String status, String executionDate)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if(number!=null)columnsAndValues.put("Номер", number);
        if(documentDate!=null)columnsAndValues.put("Дата документа", documentDate);
        if(store!=null)columnsAndValues.put("Получатель", store);
        if(fundingSource!=null)columnsAndValues.put("Финансирование", fundingSource);
        if(commodityGroup!=null)columnsAndValues.put("Тов. группа", commodityGroup);
        if(trustDoc!=null)columnsAndValues.put("Доверенность", trustDoc);
        if(status!=null)columnsAndValues.put("Статус", status);
        if(executionDate!=null)columnsAndValues.put("Дата отработки", executionDate);

        getRequestsListTable().assertRowIsChosen(columnsAndValues, true);
    }

    /**
     * Проверка сообщения об успешном сохранении "Спецификация сохранена"
     */
    public void assertRequestListSuccessMessage(String successMessage)
    {
        getRequestsListTable().getAlerts().assertSuccessAlertMessage(successMessage);
    }
}