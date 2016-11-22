package businessFramework.module.pharmacy.pages.documentsForCancellation;


import businessFramework.module.Values;
import businessFramework.module.pharmacy.modals.DocumentsForWriteOff.DocumentsForWriteOffModal;
import businessFramework.module.pharmacy.modals.DocumentsForWriteOff.ExecuteWriteOffDocModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DocsForWriteOffPage extends DocsForWriteOffHelper implements Values
{

    private int row;

    public DocsForWriteOffPage(ApplicationManager app)
    {
        super(app);
    }

    /** -------------------- Действия с фильтром --------------------------- */
    /**
     * Открывает фильтр в контейнере "Расходные накладные"
     */
    public void openFilterForWriteOffDocs()
    {
        getWriteOffDocListContainer().showFilter();
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
     * Получение модального окна "Документ на списание" в этом классе, тк это модальное окно открывается со страницы "Документы на списание".
     */
    public DocumentsForWriteOffModal getDocumentsForWriteOffModal()
    {
        return new DocumentsForWriteOffModal(app);
    }

    /** ----------------- Контейнер "Документы на списание" и действия в нем ------------------------------- */

    /**
     * @return Контейнер "Документы на списание"
     */
    public Container getWriteOffDocListContainer()
    {
        return getContainer("writeOffDocList");
    }

    /**
     * @return таблицу в контейнере "Документы на списание"
     */
    public Table getWriteOffDocsTable()
    {
        return getWriteOffDocListContainer().getTable();
    }

    /**
     * Проверяет значения в столбцах таблицы в контейнере "Документы на списание"
     *
     * @param docNumberValue    значение столбца "№ документа"
     * @param dateValue         значение столбца "Дата"
     * @param senderValue       значение столбца "Отправитель"
     * @param operationValue    значение столбца "Операция"
     * @param productGroupValue значение столбца "Тов. группа"
     *
     * @return номер строчки, которая подходит по параметрам
     */
    public int checkTableValues(String docNumberValue, String dateValue, String senderValue, String operationValue, String productGroupValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if ( docNumberValue != null)    { columnsAndValues.put("№ документа", docNumberValue);}
        if ( dateValue != null)         { columnsAndValues.put("Дата", dateValue);}
        if ( senderValue != null)       { columnsAndValues.put("Отправитель", senderValue);}
        if ( operationValue != null)    { columnsAndValues.put("Операция", operationValue);}
        if ( productGroupValue != null) { columnsAndValues.put("Тов. группа", productGroupValue);}

        row = getWriteOffDocsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }


    /** ----------------- Нажатие кнопок на странице "Документы на списание" в контейнере "Документы на списание" -------------- */

    /**
     * Нажатие кнопки "Добавить"
     */
    public void clickAddDocButton()
    {
        getAddDocButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditDocButton()
    {
        getEditDocButton().click();
    }

    /**
     * Нажатие кнопки "Копировать"
     */
    public void clickCopyDocButton()
    {
        getCopyDocButton().click();
    }

    /**
     * Нажатие кнопки "Просмотр"
     */
    public void clickViewDocButton()
    {
        getViewDocButton().click();
    }

    /**
     * Нажатие кнопки "Удалить"
     */
    public void clickDeleteDocButton()
    {
        getDeleteDocButton().click();
    }

    /**
     * Нажатие кнопки "Провести"
     */
    public void clickExecuteDocButton()
    {
        getExecuteDocButton().click();
    }

    /**
     * Нажимает кнопку "Вернуть"
     */
    public void clickCancelExecuteDocButton()
    {
        getCancelExecutionWriteOffDocButton().click();
    }

    /** ------------------------------------ Действия с контейнером "Спецификации" --------------------------------------- */

    /**
     * Нажимает кнопку "Добавить"
     */
    public void clickAddSpecButton()
    {
        getAddSpecButton().click();
    }

    /**
     * @return Получение модального окна "Проводка документа" в этом классе, тк это модальное окно открывается со страницы "Документы на списание".
     */
    public ExecuteWriteOffDocModal getExecuteWriteOffDocModal()
    {
        return new ExecuteWriteOffDocModal(app);
    }


    public void clickExecuteSpecButton() {
        getExecuteSpecButton().click();
    }

    /**
     * @return контейнер "Спецификации"
     */
    public Container getWriteOffSpecListContainer() {
        return getContainer("writeOffSpecList");
    }

    /**
     * @return таблицу в контейнере "Спецификации"
     */
    public Table getWriteOffSpecListTable() {
        return getWriteOffSpecListContainer().getTable();
    }

    /**
     * @return Получение модального окна "Проводка спецификации"
     */
    public ExecuteWriteOffDocModal getExecuteWriteOffSpecModal() {
        return new ExecuteWriteOffDocModal(app);
    }
}
