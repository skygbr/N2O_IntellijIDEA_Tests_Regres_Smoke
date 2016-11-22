package businessFramework.module.phthisiatry.modals.mStep;

import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

/**
 * Created by bulat.garipov on 28.10.2016.
 */
public class MStepEditHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public MStepEditHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */

    public Modal getStepEditModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getStepEditModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getStepEditModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Заполнить дату "Дата посещения*"
     */
    public InputDate getAdmissionDateField()
    {
        return getStepEditModal().getForm().getInputDate("admission_date");
    }

    /**
     * @return Классифаер "Врач*"
     */
    public Classifier getVrachField()
    {
        return getStepEditModal().getForm().getClassifier("vrach");
    }

    /**
     * @return Классифаер "Оборудование"
     */
    public Classifier getEquipField()
    {
        return getStepEditModal().getForm().getClassifier("equip");
    }

    /**
     * @return Классифаер "Место обслуживания*"
     */
    public Classifier getPlaceField()
    {
        return getStepEditModal().getForm().getClassifier("place");
    }

    /**
     * @return Классифаер "Профиль*"
     */
    public Classifier getProfileField()
    {
        return getStepEditModal().getForm().getClassifier("profile");
    }

    /**
     * @return Классифаер "Цель посещения*"
     */
    public Classifier getInitGoalField()
    {
        return getStepEditModal().getForm().getClassifier("initGoal");
    }

    /**
     * @return Классифаер "Характер заболевания*"
     */
    public Classifier getDiseaseTypeField()
    {
        return getStepEditModal().getForm().getClassifier("disease_type");
    }

    /**
     * @return Список в виде дерева "Диагноз*"
     */
    public Diagnosis getMainDiagnosField()
    {
        return new Diagnosis(app, getStepEditModal().getForm().getFormElement(), "main_diagnos");
    }
    /**
     * @return Классифаер "Клиническая форма*"
     */
    public Classifier getClinicalFormField()
    {
        return getStepEditModal().getForm().getClassifier("clinicalForm");
    }

    /**
     * @return Классифаер "Вторая локализация"
     */
    public Classifier getLocalizationField()
    {
        return getStepEditModal().getForm().getClassifier("localization");
    }

    /**
     * @return Классифаер "Осложнения"
     */
    public Classifier getComplicationField()
    {
        return getStepEditModal().getForm().getClassifier("complication");
    }

}
