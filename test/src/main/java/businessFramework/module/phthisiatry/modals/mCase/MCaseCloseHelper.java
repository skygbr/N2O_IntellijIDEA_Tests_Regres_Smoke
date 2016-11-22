package businessFramework.module.phthisiatry.modals.mCase;


import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseCloseHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public MCaseCloseHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getCaseCloseModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getCaseCloseModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getCaseCloseModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Классифаер "Результат обращения"
     */
    public Classifier getResultTreatmentField()
    {
        return getCaseCloseModal().getForm().getClassifier("result");
    }

    /**
     * @return Классифаер "Причина"
     */
    public Classifier getResultReasonField()
    {
        return getCaseCloseModal().getForm().getClassifier("resultReason");
    }

    /**
     * @return Классифаер "Исход заболевания"
     */
    public Classifier getOutcomeField()
    {
        return getCaseCloseModal().getForm().getClassifier("outcome");
    }

    /**
     * @return Классифаер "Причина отклонения от стандарта"
     */
    public Classifier getDeviationReasonField()
    {
        return getCaseCloseModal().getForm().getClassifier("deviationReason");
    }

    /**
     * @return Классифаер "КСГ"
     */
    public Classifier getCsgField()
    {
        return getCaseCloseModal().getForm().getClassifier("csg");
    }

    /**
     * @return Список в виде дерева "Диагноз"
     */
    public Diagnosis getDiagnosField()
    {
        return new Diagnosis(app, getCaseCloseModal().getForm().getFormElement(), "diagnos");
    }

    /**
     * @return Классифаер "Вид"
     */
    public Classifier getDiagnosisTypeField()
    {
        return getCaseCloseModal().getForm().getClassifier("diagnosisType");
    }

    /**
     * @return Классифаер "Характер заболевания"
     */
    public Classifier getDiseaseTypeField()
    {
        return getCaseCloseModal().getForm().getClassifier("diseaseType");
    }

    /**
     * @return Заполнить дату "Дата установления"
     */
    public InputDate getEstablishmentDateField(){
        return getCaseCloseModal().getForm().getInputDate("establishmentDate");
    }

    /**
     * Получение чекбокса "Основной диагноз"
     * @return чекбокс "Основной диагноз"
     */
    public InputCheckBox getCheckboxesMain()
    {
        return getCaseCloseModal().getForm().getInputCheckBox("main");
    }
}
