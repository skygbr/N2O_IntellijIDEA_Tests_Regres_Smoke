package businessFramework.module.phthisiatry.pages;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import businessFramework.entities.phthisiatry.MCaseData;
import businessFramework.entities.phthisiatry.MRefData;
import businessFramework.entities.phthisiatry.MStepData;
import businessFramework.module.phthisiatry.modals.mCase.MCaseCreateModal;
import businessFramework.module.phthisiatry.modals.mCase.MCaseEditModal;
import businessFramework.module.phthisiatry.modals.mCase.MCaseCloseModal;
import businessFramework.module.phthisiatry.modals.mStep.MStepCreateModal;
import businessFramework.module.phthisiatry.modals.mStep.MStepEditModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefSetModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefEditModal;
import businessFramework.module.phthisiatry.modals.mRef.MRefRenderedModal;
import businessFramework.module.phthisiatry.modals.VrachSearchModal;
import businessFramework.module.phthisiatry.pages.findVrachContainer.VrachSearchContainerPage;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
public class PhthisiatryPage extends PhthisiatryHelper implements Values
{
    public PhthisiatryPage(ApplicationManager app)
    {
        super(app);
    }

    public int row = 0;

    /* -----------------------------  Таблица "Случаи" и кнопки над этой таблицей----------------------------- */

    /**
     * Нажимает кнопку "Добавить" над таблицей "Случаи"
     */
    public void clickCreateCaseButton()
    {
        getCreateCaseButton().click();
    }

    /**
     * Нажимает кнопку "Результат (Закрыть)" над таблицей "Случаи"
     */
    public void clickCloseCaseButton()
    {
        getCloseCaseButton().click();
    }

    /**
     * Нажимает кнопку "Перейти в картотеку пациентов" над таблицей "Случаи"
     */
    public void clickToPatientButton()
    {
        getToPatientButton().click();
    }

    /**
     * Нажимает кнопку "Переоткрыть" над таблицей "Случаи"
     */
    public void clickReOpenCaseButton()
    {
        Button reOpen = getReOpenCaseButton();
        reOpen.assertIsEnabled();
        reOpen.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Случаи"
     */
    public void clickEditCaseButton()
    {
        getEditCaseButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Случаи"
     */
    public void clickDeleteCaseButton()
    {
        Button delete = getDeleteCaseButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Открывает фильтр в контейнере "Случаи"
     */
    public void openFilterForCases()
    {
        getCaseListContainer().showFilter();
    }

    /**
     * Открывает фильтр в контейнере "Посещения"
     */
    public void openFilterForSteps()
    {
        getStepListContainer().showFilter();
    }

    /**
     * Открывает фильтр в контейнере "Направления (Назначения)"
     */
    public void openFilterForRefs()
    {
        getRefListContainer().showFilter();
    }


    /**
    * Удаление случаев конкретного пациента из mCaseData
     */
    public void deleteCases(MCaseData mCaseData) {
        this.openFilterForCases();
        getFilterPatient().setValue(mCaseData.getPatient());
        this.getFilterForCases().clickFindButton();

        Table table = this.getCaseListTable();

        while (table.getCountRowsInTable(true) > 0) {
            int size = table.getCountRowsInTable(true);
            table.chooseRowInTable(0);
            this.clickDeleteCaseButton();
            table = this.getCaseListTable();
            assertThat("Rows doesn't delete from table", size,
                    not(table.getCountRowsInTable(true)));
        }
        this.getStepListContainer().assertThatContainerIsAvailable(false);
        this.getRefListContainer().assertThatContainerIsAvailable(false);
    }

    /**
     * Фильтрация созданного Случая mCaseData
     */
    public void filterForCases(MCaseData mCaseData) {
        this.openFilterForCases();
        getFilterUid().setValue(mCaseData.getUid());
        getFilterCreateDate().setValue(mCaseData.getCreateDate());
        getFilterMdCaseDiagnos().setValue(mCaseData.getMdCaseDiagnos());
        getFilterPatient().setValue(mCaseData.getPatient());
        this.getFilterForCases().clickFindButton();

        this.getStepListContainer().assertThatContainerIsAvailable(true);
        this.getRefListContainer().assertThatContainerIsAvailable(false);
    }

    /**
     * Фильтрация созданного случая по Направлению (Назначения) mRefData
     */
    public void filterForRefs(MRefData mRefData) {
        this.openFilterForRefs();
        getFilterStepDepartment().setValue(mRefData.getStepDepartment());
        this.getFilterForRefs().clickFindButton();

        this.getCaseListContainer().assertThatContainerIsAvailable(true);
        this.getStepListContainer().assertThatContainerIsAvailable(true);
    }

    /**
     * Фильтрация созданного случая по пациенту
     */
    public void filterPacient(MCaseData mCaseData) {
        this.openFilterForCases();
        this.getFilterForCases().clickClearButton();
        this.openFilterForCases();
        getFilterPatient().setValue(mCaseData.getPatient());
        this.getFilterForCases().clickFindButton();
    }

    /**
     * Получение в фильтре кнопки "Врач"
     */
    public void filterButtonVrach()
    {
        this.openFilterForCases();
        getFilterVrach().findModalButtonClick();
    }

    /**
     * Проверка значения в классифаере "Врач" для контейнера
     * @param fullName - значение, которое ожидается в классифаере "Врач"
     */
    public void checkValueInVrachContainer(String fullName)
    {
        getFilterVrach().assertValue_equals(fullName);
    }

    /**
     * Получение в фильтре кнопки "Найти"
     */
    public void filterButtonSearch()
    {
        getFilterForCases().clickFindButton();
    }

    /**
     * Получение модального окна "Создание случая"
     */
    public MCaseCreateModal getMCaseCreateModal()
    {
        return new MCaseCreateModal(app);
    }

    /**
     * Получение модального окна "Редактирование случая"
     */
    public MCaseEditModal getMCaseEditModal()
    {
        return new MCaseEditModal(app);
    }


    /**
     * Получение модального окна "Закрыть случай (Результат)"
     */
    public MCaseCloseModal getMCaseCloseModal()
    {
        return new MCaseCloseModal(app);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Случаи"
     */
    public void checkCaseSuccessMessage()
    {
        getCaseListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Случаи" отобразилась запись с необходимыми значениями
     *
     * @param numberValue значение в стоблце "Номер случая"
     * @param patientValue значение в столбце "Пациент"
     * @param fundingValue значение в столбце "Вид оплаты"
     */
    public int checkRecordInCasesTable(String numberValue, String patientValue, String fundingValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null)  { columnsAndValues.put("Номер случая", numberValue); }
        if (patientValue != null) { columnsAndValues.put("Пациент", patientValue); }
        if (fundingValue != null) { columnsAndValues.put("Вид оплаты", fundingValue); }

        row = getCaseListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Случаи" отобразилась запись с необходимыми значениями
     *
     * @param numberValue значение в стоблце "Номер случая"
     * @param patientValue значение в столбце "Пациент"
     * @param fundingValue значение в столбце "Вид оплаты"
     */
    public int checkRecordInReOpenCasesTable(String numberValue, String patientValue, String fundingValue, String establishmentDateValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (numberValue != null)            { columnsAndValues.put("Номер случая", numberValue); }
        if (patientValue != null)           { columnsAndValues.put("Пациент", patientValue); }
        if (fundingValue != null)           { columnsAndValues.put("Вид оплаты", fundingValue); }
        if (establishmentDateValue != null) { columnsAndValues.put("Дата закрытия случая", establishmentDateValue); }

        row = getCaseListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /* -----------------------------  Таблица "Посещения" и кнопки над этой таблицей----------------------------- */

    /**
     * Нажимает кнопку "Добавить" над таблицей "Посещения"
     */
    public void clickCreateStepButton()
    {
        getCreateStepButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Посещения"
     */
    public void clickEditStepButton()
    {
        getEditStepButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Посещения"
     */
    public void clickDeleteStepButton()
    {
        Button delete = getDeleteStepButton();
        delete.assertIsEnabled();
        delete.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Получение модального окна "Создание посещения"
     */
    public MStepCreateModal getMStepCreateModal()
    {
        return new MStepCreateModal(app);
    }

    /**
     * Получение модального окна "Редактирование посещения"
     */
    public MStepEditModal getMStepEditModal()
    {
        return new MStepEditModal(app);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Посещения"
     */

    public void checkStepSuccessMessage()
    {
        getStepListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Посещения" отобразилась запись с необходимыми значениями
     *
     * @param аdmissionDateValue значение в стоблце "Дата оказания"
     * @param vrachValue значение в столбце "Врач"
     * @param serviceValue значение в столбце "Услуга"
     */
    public int checkRecordInStepTable(String аdmissionDateValue, String vrachValue, String serviceValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (аdmissionDateValue != null) { columnsAndValues.put("Дата оказания", аdmissionDateValue); }
        if (vrachValue != null)         { columnsAndValues.put("Врач", vrachValue); }
        if (serviceValue != null)       { columnsAndValues.put("Услуга", serviceValue); }

        row = getStepListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

        /* -----------------------------  Таблица "Направления (Назначения)" и кнопки над этой таблицей----------------------------- */
    /**
     * Нажимает кнопку "Назначить" над таблицей "Направления (Назначения)"
     */
    public void clickSetRefButton()
    {
        getSetRefButton().click();
    }

    /**
     * Нажимает кнопку "Изменить" над таблицей "Направления (Назначения)"
     */
    public void clickEditRefButton()
    {
        getEditRefButton().click();
    }

    /**
     * Нажимает кнопку "Удалить" над таблицей "Направления (Назначения)"
     */
    public void clickDeleteRefButton()
    {
        Button deleteRef = getDeleteRefButton();
        deleteRef.assertIsEnabled();
        deleteRef.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Нажимает кнопку "Внести результат" над таблицей "Направления (Назначения)"
     */
    public void clickRenderedRefButton()
    {
        getRenderedRefButton().click();
    }

    /**
     * Получение модального окна "Назначение услуги"
     */
    public MRefSetModal getMRefSetModal()
    {
        return new MRefSetModal(app);
    }

    /**
     * Получение модального окна "Внести результат"
     */
    public MRefRenderedModal getMRefRenderedModal()
    {
        return new MRefRenderedModal(app);
    }

    /**
     * Получение модального окна выбора "Врач"
     */
    public VrachSearchModal getVrachSearchModal()
    {
        return new VrachSearchModal(app);
    }

    /**
     * Получение модального окна "Редактирование услуги"
     */
    public MRefEditModal getMRefEditModal()
    {
        return new MRefEditModal(app);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Направления (Назначения)"
     */

    public void checkRefSuccessMessage()
    {
        getRefListTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверяет, что в таблице "Направления (Назначения)" отобразилась запись с необходимыми значениями
     *
     * @param clinicValue значение в стоблце "Дата оказания"
     * @param plannedDateValue значение в столбце "Врач"
     * @param serviceValue значение в столбце "Услуга"
     */
    public int checkRecordInRefTable(String clinicValue, String plannedDateValue, String serviceValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (clinicValue != null)      { columnsAndValues.put("МО", clinicValue); }
        if (plannedDateValue != null) { columnsAndValues.put("Дата планирования", plannedDateValue); }
        if (serviceValue != null)     { columnsAndValues.put("Услуга", serviceValue); }

        row = getRefListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Направления (Назначения)" отобразилась запись с необходимыми значениями
     *
     * @param serviceValue значение в столбце "Услуга"
     * @param plannedDateValue значение в столбце "Дата планирования"
     * @param renderedDateValue значение в столбце "Дата оказания"
     * @param refStatusValue значение в стоблце "Статус"
     * @param clinicValue значение в стоблце "МО"
     */
    public int checkRecordInRefRenderedTable(String serviceValue, String plannedDateValue, String renderedDateValue, String refStatusValue, String clinicValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (serviceValue != null)      { columnsAndValues.put("Услуга", serviceValue); }
        if (plannedDateValue != null)  { columnsAndValues.put("Дата планирования", plannedDateValue); }
        if (renderedDateValue != null) { columnsAndValues.put("Дата оказания", renderedDateValue); }
        if (refStatusValue != null)    { columnsAndValues.put("Статус", refStatusValue); }
        if (clinicValue != null)       { columnsAndValues.put("МО", clinicValue); }


        row = getRefListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        return row;
    }

    /**
     * Получение ссылки на страницу "Поиск врача" с этой страницы, т.к. переход на нее происходит с модального окна "Внести результат"
     *
     * @return ссылку на страницу "Карточка мероприятия".
     */
    public VrachSearchContainerPage getVrachSearchPage()
    {
        return new VrachSearchContainerPage(app);
    }

}
