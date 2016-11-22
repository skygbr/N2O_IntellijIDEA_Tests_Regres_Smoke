package businessFramework.module.pharmacy.modals.ReturnDoc;


import net.framework.autotesting.ApplicationManager;

import java.util.ArrayList;
import java.util.List;

public class ReturnDocModal extends ReturnDocHelper{
    public ReturnDocModal(ApplicationManager app) {
        super(app);
    }

    /* ------------------ Модальное окно "Возвратный документ" --------------------- */
    /**
     * устанавливает значения в поля
     *
     * @param returnDocNumber   Значение для поля "Префикс номер"
     * @param date              Значение для поля "Дата"
     * @param store             Значение для поля "Склад"
     * @param storeOperation    Значение для поля "Складская операция"
     * @param contractor        Значение для поля "Поставщик"
     * @param funding           Значение для поля "Финансирование"
     * @param returnReason      Значение для поля "Причина возврата"
     * @param annotation        Значение для поля "Примечание"
     */
    public void setValuesToFields (String returnDocNumber, String date, String store,
                                   String storeOperation, String contractor, String funding,
                                   String returnReason, String annotation){
        getReturnDocNumberField().setValue(returnDocNumber);
        getReturnDocDateField().setValue(date);
        getReturnDocStore().setValue(store);
        getReturnDocStoteOper().setValue(storeOperation);
        getContractor().setValue(contractor);
        if (funding != null) {
            List<String> fundingList = new ArrayList<>();
            fundingList.add(funding);
            getFunding().chooseNodeWithOpenClose(fundingList, true);
        }
        getReturnReason().setValue(returnReason);
        getAnnotation().setValue(annotation);
    }

    /**
     * Проверяет значения в полях, в модальном окне
     *
     * @param expectedDocNumber         Ожидаемое значение поля "Префикс номер"
     * @param expectedDate              Ожидаемое значение поля "Дата"
     * @param expectedStore             Ожидаемое значение поля "Склад"
     * @param expectedStoreOperation    Ожидаемое значение поля "Складская операция"
     * @param expectedContractor        Ожидаемое значение поля "Поставщик"
     * @param expectedFunding           Ожидаемое значение поля "Финансирование"
     * @param expectedReturnReason      Ожидаемое значение поля "Причина возврата"
     * @param expectedAnnotation        Ожидаемое значение поля "Примечание"
     */
    public void checkFieldsValues(String expectedDocNumber, String expectedDate, String expectedStore,
                                  String expectedStoreOperation, String expectedContractor,
                                  String expectedFunding, String expectedReturnReason, String expectedAnnotation){
        getReturnDocNumberField().assertValue(expectedDocNumber);
        getReturnDocDateField().assertValue(getReturnDocDateField().getValue(), getCurrentDate());
        getReturnDocStore().assertValue_contains(expectedStore);
        getReturnDocStoteOper().assertValue_contains(expectedStoreOperation);
        getContractor().assertValue_contains(expectedContractor);
        getFunding().assertValueIs(expectedFunding);
        getReturnReason().assertValue(expectedReturnReason);
        getAnnotation().assertValue(expectedAnnotation);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void pressConfirmButton(){
        getConfirmButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal(){
        getReturnDocModal().closeModal();
    }
}
