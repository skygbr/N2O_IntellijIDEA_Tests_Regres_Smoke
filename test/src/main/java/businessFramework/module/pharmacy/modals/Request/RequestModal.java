package businessFramework.module.pharmacy.modals.Request;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import java.util.ArrayList;
import java.util.List;

public class RequestModal extends RequestHelper implements Values
{

    public RequestModal(ApplicationManager app)
    {
        super(app);
    }

    /* ------------------ Модальное окно "Требование" --------------------- */

    public void assertRequestModalHeader(String headerName)
    {
        assertCountOfModals(1);
        getModal().assertModalHeader_contains(headerName);
    }

    /**
     * Заполнение полей модального окна "Требование"
     *
     * @param number            Номер
     * @param store             Склад
     * @param fundingSource     Финансирование
     * @param commodityGroup    Товарная группа
     * @param trustDoc          Доверенность
     */
    public void fillRequestModalFields(String number, String store, String sendStore, String fundingSource, String commodityGroup, String trustDoc) {
        getRequestNumber().setValue(number);
        getRequestStore().setValue(store);
        getRequestSendStore().setValue(sendStore);
        if (fundingSource != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(fundingSource);
            getRequestFundingSource().chooseNodeWithOpenClose(fundingList, true);
        }
        getRequestCommodityGroup().setValue(commodityGroup);
        getRequestTrustDocument().setValue(trustDoc);
    }

    /**
     * Проверка значений полей модального окна "Требование"
     *
     * @param docType           Тип документа
     * @param number            Номер
     * @param date              Дата
     * @param store             Склад
     * @param fundingSource     Финансирование
     * @param commodityGroup    Товарная группа
     * @param trustDoc          Доверенность
     */
    public void assertRequestModalFields(String docType, String number, String date, String store, String fundingSource, String commodityGroup, String trustDoc)
    {
        getRequestDocumentType().assertValue_equals(docType);
        getRequestNumber().assertValue(number);
        getRequestDate().assertThatDateContainsValue(date);
        getRequestStore().assertValue_equals(store);
        if (fundingSource != null) getRequestFundingSource().assertValueIs(fundingSource);
        getRequestCommodityGroup().assertValue_equals(commodityGroup);
        getRequestTrustDocument().assertValue_equals(trustDoc);
    }

    /**
     * Проверка задизебленности полей модального окна "Требование"
     */
    public void assertRequestModalDisability()
    {
        getRequestDocumentType().assertThatComboboxIsDisabled();
        getRequestNumber().assertIsDisabled(true);
        getRequestDate().assertIsDisabled(true);
        getRequestStore().assertThatComboboxIsDisabled();
        getRequestCommodityGroup().assertThatComboboxIsDisabled();
        getRequestTrustDocument().assertThatComboboxIsDisabled();
    }

    /**
     * Нажатие кнопки сохранения требования
     */
    public void clickSaveRequestButton()
    {
        Button saveRequest = getSaveRequestButton();
        saveRequest.assertIsEnabled();
        saveRequest.click();
    }

}