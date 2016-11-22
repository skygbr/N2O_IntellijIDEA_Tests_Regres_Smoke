package businessFramework.module.pharmacy.pages.transferAct;

import businessFramework.module.pharmacy.modals.TransferAct.AcceptDocumentModal;
import businessFramework.module.pharmacy.modals.TransferAct.ExecuteDocumentModal;
import businessFramework.module.pharmacy.modals.TransferAct.TransferActModal;
import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActPage extends TransferActsHelper
{
    public TransferActPage(ApplicationManager app)
    {
        super(app);
    }

    public int row = 0;

    /* ------------------------------ Действия с фильтром на странице "Акты переброски" ----------------------------------*/

    /**
     * Открывает фильтр в контейнере "Акты переброски"
     */
    public void openFilterForTransferAct()
    {
        getTransferActListContainer().showFilter();
    }

    /**
     * Проверка значения в поле дат
     */
    public void checkDatesValues()
    {
        String beginValue = getDocumentDate().getBeginValue();  // 01.01.2015
        String endValue = getDocumentDate().getEndValue();      // 01.04.2015

        Date nowDate = new Date();
        SimpleDateFormat formatBegin = new SimpleDateFormat("MM.yyyy");
        SimpleDateFormat formatEnd = new SimpleDateFormat("dd.MM.yyyy");

        String expectedBeginValue = "01." + formatBegin.format(nowDate);
        String expectedEndValue = formatEnd.format(nowDate);

        assertThat(beginValue, equalTo(expectedBeginValue));
        assertThat(endValue, equalTo(expectedEndValue));

    }

    /**
     * Фильтрация таблицы "Расходные документы" по номеру документа
     * @param documentNumber номер документа
     */
    public void filterTransferActByNumber(String documentNumber)
    {
        getDocumentNumber().setValue(documentNumber);
        getFilterTransferAct().clickFindButton();
    }

    /* ------------------------------ Нажатие кнопок на странице "Акты переброски" ----------------------------------*/

    /**
     * Нажимает кнопку "Добавить" в контейнере "Акты переброски"
     */
    public void clickAddTransferActButton()
    {
        getAddTransferActButton().click();
    }

    /**
     * Нажимает на кнопку "Изменить" в контейнере "Акты переброски"
     */
    public void clickEditTransferActButton(){
        getEditTransferActButton().click();
    }

    /**
     * Нажимает кнопку "Провести" в контейнере "Акты переброски"
     */
    public void clickExecuteTransferActButton()
    {
        getExecuteTransferActButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" в контейнере "Акты переброски"
     */
    public void clickDeleteTransferActButton()
    {
        getDeleteTransferActButton().click();
    }

    /**
     * Нажимает кнопку "Вернуть" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public void clickCancelExecutionTransferActButton()
    {
        getCancelExecutionTransferActButton().click();
    }

    /**
     * Нажимает кнопку "Добавить" в контейнере "Спецификация"
     */
    public void clickAddSpecificationButton()
    {
        getAddSpecificationButton().click();
    }

    /**
     * Нажимает кнопку "Принять" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public void clickAcceptTransferActButton(){
        getAcceptTransferActButton().click();
    }

    /**
     * Нажимает кнопку "Отменить прием" в контейнере "Акты переброски" на странице "Акты переброски"
     */
    public void clickRevertAcceptTransferActButtonn(){
        getRevertAcceptTransferActButton().click();
    }

    /* -------------------- Расходная накладная ------------------------- */

    /**
     * Получение модального окна "Расходная накладная " в этом классе, тк это модальное окно открывается со страницы "Акты переброски".
     */
    public TransferActModal getTransferActModal()
    {
        return new TransferActModal(app);
    }


    /**
     * Получение страницы "Создание спецификации" в этом классе, тк эта страница открывается со страницы "Акты переброски".
     * @return страницу "Создание спецификации"
     */
    public TransferActCreateSpecPage getTransferActCreateSpecPage()
    {
        return new TransferActCreateSpecPage(app);
    }

    /**
     * Проверяет значение в тех столбцах таблицы, значения для которых указаны в @param
     *
     * @param numberValue           № накладной
     * @param dateValue             Дата
     * @param senderValue           Отправитель
     * @param arrivalOperationValue Операция прихода
     * @param recipientValue        Получатель
     * @param chargeOperationValue  Операция расхода
     * @return номер строчки в таблице, которая подходит по этим данным.
     */
    public int checkTableValues(String numberValue, String dateValue, String senderValue, String arrivalOperationValue,
                                String recipientValue, String chargeOperationValue, String executed, String fundingSourceValue, String newFundingSourceValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null)            { columnsAndValues.put("№ накладной", numberValue);}
        if (dateValue != null)              { columnsAndValues.put("Дата", dateValue);}
        if (senderValue != null)            { columnsAndValues.put("Отправитель", senderValue);}
        if (arrivalOperationValue != null ) { columnsAndValues.put("Операция прихода", arrivalOperationValue);}
        if (recipientValue != null)         { columnsAndValues.put("Получатель", recipientValue);}
        if (chargeOperationValue != null)   { columnsAndValues.put("Операция расхода", chargeOperationValue);}
        if (executed != null)               { columnsAndValues.put("Проведён", executed);}
        if(fundingSourceValue != null)      { columnsAndValues.put("Финансирование", fundingSourceValue);}
        if(newFundingSourceValue != null)   { columnsAndValues.put("Новый ИФ", newFundingSourceValue);}

        row = getTransferActListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * @return Получение модального окна "Проводка документа" в этом классе, тк это модальное окно открывается со страницы "Акты переброски".
     */
    public ExecuteDocumentModal getExecuteTransferActModal()
    {
        return new ExecuteDocumentModal(app);
    }

    /**
     * @return Получение модального окна "Прием документа" в этом классе, тк это модальное окно открывается со страницы "Акты переброски".
     */
    public AcceptDocumentModal getAcceptTransferActModal()
    {
        return new AcceptDocumentModal(app);
    }


}
