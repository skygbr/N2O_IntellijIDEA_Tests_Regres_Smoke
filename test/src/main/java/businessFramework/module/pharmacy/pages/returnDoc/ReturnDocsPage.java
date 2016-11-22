package businessFramework.module.pharmacy.pages.returnDoc;


import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.ReturnDoc.ReturnDocModal;
import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;


public class ReturnDocsPage extends ReturnDocsHelper implements Values{

    private int row = 0;

    public ReturnDocsPage(ApplicationManager app) {
        super(app);
    }

    /* -------------------- Кнопки в контейнере "Возвратные документы" ------------------------- */

    /**
     * Нажимает кнопку "Добавить" в контейнере "Возвратные документы"
     */
    public void clickCreateReturnDocButton()
    {
        getCreateReturnDocButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" в контейнере "Возвратные документы"
     */
    public void clickEditReturnDocButton()
    {
        getEditReturnDocButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Возвратные документы"
     */
    public void clickDeleteReturnDocButton()
    {
        getDeleteReturnDocButton().click();
    }

    /**
     * Выбирает строчку в таблице "Возвратные документы"
     */
    public void selectFoundedRow(int rowNumber){
        getReturnDocListTable().chooseRowInTable(rowNumber);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении на странице "Возвратные документы"
     */
    public void checkSuccessMessage()
    {
        getReturnDocListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Возвратные документы" отобразилась запись с необходимыми значениями
     *
     * @param returnDocNumber   Значение для поля "Префикс номер"
     * @param date              Значение для поля "Дата"
     * @param store             Значение для поля "Склад"
     * @param storeOperation    Значение для поля "Складская операция"
     * @param contractor        Значение для поля "Поставщик"
     * @param funding           Значение для поля "Финансирование"
     */
    public int checkRecordInReturnDocsTable(String returnDocNumber, String date, String store,
                                            String storeOperation, String contractor, String funding){
        Map<String, String> columnsAndValues = new HashMap<>();
        if(returnDocNumber  != null)     {columnsAndValues.put("№"  ,returnDocNumber);}
        if(date             != null)     {columnsAndValues.put("Дата"           ,date);}
        if(store            != null)     {columnsAndValues.put("Отправитель"    ,store);}
        if(storeOperation   != null)     {columnsAndValues.put("Операция"       ,storeOperation);}
        if(contractor       != null)     {columnsAndValues.put("Поставщик"      ,contractor);}
        if(funding          != null)     {columnsAndValues.put("Финансирование" ,funding);}

        row = getReturnDocListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Получение модального окна "Возвратный документ"
     */
    public ReturnDocModal getReturnDocModal(){
        return new ReturnDocModal(app);
    }
}
