package businessFramework.module.phthisiatry.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Dialog;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
public class PhthisiatryHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public PhthisiatryHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Случаи"
     * @return контейнер "Случаи"
     */
    public Container getCaseListContainer()
    {
        return getContainer("mcase");
    }

    /**
     * Получает контейнер "Посещения"
     * @return контейнер "Посещения"
     */
    public Container getStepListContainer()
    {
        return getContainer("step");
    }

    /**
     * Получает контейнер "Направления (Назначения)"
     * @return контейнер "Направления (Назначения)"
     */
    public Container getRefListContainer()
    {
        return getContainer("ref");
    }

    /**
     * Получает фильтр в контейнере "Случаи"
     * @return фильтр в контейнере "Случаи"
     */
    public Filter getFilterForCases()
    {
        return getCaseListContainer().getFilter();
    }

    /**
     * Получает фильтр в контейнере "Посещения"
     * @return фильтр в контейнере "Посещения"
     */
    public Filter getFilterForRSteps()
    {
        return getStepListContainer().getFilter();
    }

    /**
     * Получает фильтр в контейнере "Направления (Назначения)"
     * @return фильтр в контейнере "Направления (Назначения)"
     */
    public Filter getFilterForRefs()
    {
        return getRefListContainer().getFilter();
    }

    /**
     * @return Поле "Отделение" в фильтре
     */
    public Classifier getFilterStepDepartment()
    {
        return getFilterForCases().getClassifier("stepDepartment");
    }

    /**
     * @return Поле "Номер случая" в фильтре
     */
    public InputText getFilterUid()
    {
        return getFilterForCases().getInputText("number");
    }

    /**
     * @return Поле "Дата создания случая" в фильтре
     */
    public InputDate getFilterCreateDate()
    {
        return getFilterForCases().getInputDate("create_date");
    }

    /**
     * @return Поле "Диагноз" в фильтре
     */
    public Classifier getFilterMdCaseDiagnos()
    {
        return getFilterForCases().getClassifier("md_case_diagnos");
    }

    /**
     * @return Поле "Пациент" в фильтре
     */
    public Classifier getFilterPatient()
    {
        return getFilterForCases().getClassifier("patient");
    }

    /**
     * @return Классифаер "Врач*"
     */
    public Classifier getFilterVrach()
    {
        return getFilterForCases().getClassifier("vrach");
    }

    /* -----------------------------  Таблица "Случаи" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateCaseButton()
    {
        return getCaseListContainer().getButton("createCase");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditCaseButton()
    {
        return getCaseListContainer().getButton("editCase");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteCaseButton()
    {
        return getCaseListContainer().getButton("deleteCase");
    }


    /**
     * @return кнопку "Результат (Закрыть)"
     */
    public Button getCloseCaseButton()
    {
        return getCaseListContainer().getButton("closeCase");
    }

    /**
     * @return кнопку "Перейти в картотеку пациентов"
     */
    public Button getToPatientButton()
    {
        return getCaseListContainer().getButton("toPatient");
    }

    /**
     * @return кнопку "Переоткрыть"
     */
    public Button getReOpenCaseButton()
    {
        return getCaseListContainer().getButton("reopen");
    }

    /**
     * @return таблицу в контейнере "Случаи"
     */
    public Table getCaseListTable()
    {
        return getCaseListContainer().getTable();
    }

    /* -----------------------------  Таблица "Посещения" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Добавить"
     */
    public Button getCreateStepButton()
    {
        return getStepListContainer().getButton("createStep");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditStepButton()
    {
        return getStepListContainer().getButton("editStep");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteStepButton()
    {
        return getStepListContainer().getButton("deleteStep");
    }

    /**
     * @return таблицу в контейнере "Посещения"
     */
    public Table getStepListTable()
    {
        return getStepListContainer().getTable();
    }

    /* -----------------------------  Таблица "Направления (Назначения)" и кнопки над этой таблицей----------------------------- */

    /**
     * @return кнопку "Назначить"
     */
    public Button getSetRefButton()
    {
        return getRefListContainer().getButton("assign");
    }

    /**
     * @return кнопку "Изменить"
     */
    public Button getEditRefButton()
    {
        return getRefListContainer().getButton("edit");
    }

    /**
     * @return кнопку "Удалить"
     */
    public Button getDeleteRefButton()
    {
        return getRefListContainer().getButton("delete");
    }

    /**
     * @return кнопку "Внести результат"
     */
    public Button getRenderedRefButton()
    {
        return getRefListContainer().getButton("rendered");
    }

    /**
     * @return таблицу в контейнере "Направления (Назначения)"
     */
    public Table getRefListTable()
    {
        return getRefListContainer().getTable();
    }

}
