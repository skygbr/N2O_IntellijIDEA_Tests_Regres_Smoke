package businessFramework.module.phthisiatry.modals.mCase;

import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.10.2016.
 */
public class MCaseCreateHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public MCaseCreateHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getCaseCreateModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getCaseCreateModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getCaseCreateModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Текстовое поле "Номер случая"
     */
    public InputText getUidField()
    {
        return getCaseCreateModal().getForm().getInputText("number");
    }

    /**
     * @return Классифаер "Пациент"
     */
    public Classifier getPatientField()
    {
        return getCaseCreateModal().getForm().getClassifier("patient");
    }

    /**
     * @return Классифаер "Обращение в текущем году"
     */
    public Classifier getRepeatCountField()
    {
        return getCaseCreateModal().getForm().getClassifier("repeat_count");
    }

    /**
     * @return Классифаер "Вид случая"
     */
    public Classifier getCaseTypeField()
    {
        return getCaseCreateModal().getForm().getClassifier("case_type");
    }

    /**
     * @return Классифаер "Условия оказания"
     */
    public Classifier getCareRegimenField()
    {
        return getCaseCreateModal().getForm().getClassifier("care_regimen");
    }

    /**
     * @return Классифаер "Тип помощи"
     */
    public Classifier getCareLevelField()
    {
        return getCaseCreateModal().getForm().getClassifier("care_level");
    }

    /**
     * @return Классифаер "Вид финансирования"
     */
    public Classifier getFundingField()
    {
        return getCaseCreateModal().getForm().getClassifier("funding");
    }

    /**
     * @return Классифаер "Цель первичного обращения"
     */
    public Classifier getInitGoalField()
    {
        return getCaseCreateModal().getForm().getClassifier("init_goal");
    }

    /**
     * @return Классифаер "Этап установления диагноза"
     */
    public Classifier getStageField()
    {
        return getCaseCreateModal().getForm().getClassifier("stage");
    }

    /**
     * @return Открытие списка в виде дерева "Диагноз"
     */
    public Diagnosis getMainDiagnosField()
    {
        return new Diagnosis(app, getCaseCreateModal().getForm().getFormElement(), "main_diagnos");
    }

    /**
     * @return Классифаер "Клиническая форма"
     */
    public Classifier getClinicalFormField()
    {
        return getCaseCreateModal().getForm().getClassifier("clinicalForm");
    }

    /**
     * @return Классифаер "Вторая локализация"
     */
    public Classifier getLocalizationField()
    {
        return getCaseCreateModal().getForm().getClassifier("localization");
    }

    /**
     * @return Классифаер "Осложнения"
     */
    public Classifier getComplicationField()
    {
        return getCaseCreateModal().getForm().getClassifier("complication");
    }
}
