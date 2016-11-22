package businessFramework.module.phthisiatry.modals.mStep;

import base.components.Diagnosis;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 28.10.2016.
 */
public class MStepCreateHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public MStepCreateHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getStepCreateModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getStepCreateModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getStepCreateModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Текстовое поле "Пациент* (поле задизейблено)"
     */
    public InputText getStepPatientField()
    {
        return getStepCreateModal().getForm().getInputText("mcase.patient.fio");
    }

    /**
     * @return Классифаер "Ресурс"
     */
    public Classifier getResField()
    {
        return getStepCreateModal().getForm().getClassifier("res");
    }

    /**
     * @return Классифаер "Врач*"
     */
    public Classifier getVrachField()
    {
        return getStepCreateModal().getForm().getClassifier("vrach");
    }

    /**
     * @return Классифаер "Услуга*"
     */
    public Classifier getServiceField()
    {
        return getStepCreateModal().getForm().getClassifier("service");
    }

    /**
     * @return Классифаер "Оборудование"
     */
    public Classifier getEquipField()
    {
        return getStepCreateModal().getForm().getClassifier("equip");
    }

    /**
     * @return Заполнить дату "Дата посещения*"
     */
    public InputDate getAdmissionDateField()
    {
        return getStepCreateModal().getForm().getInputDate("admission_date");
    }

    /**
     * @return Классифаер "Место обслуживания*"
     */
    public Classifier getPlaceField()
    {
        return getStepCreateModal().getForm().getClassifier("place");
    }

    /**
     * @return Классифаер "Профиль*"
     */
    public Classifier getProfileField()
    {
        return getStepCreateModal().getForm().getClassifier("profile");
    }

    /**
     * @return Классифаер "Цель посещения*"
     */
    public Classifier getInitGoalField()
    {
        return getStepCreateModal().getForm().getClassifier("initGoal");
    }

    /**
     * @return Классифаер "Характер заболевания*"
     */
    public Classifier getDiseaseTypeField()
    {
        return getStepCreateModal().getForm().getClassifier("disease_type");
    }

    /**
     * @return Список в виде дерева "Диагноз*"
     */
    public Diagnosis getMainDiagnosField()
    {
        return new Diagnosis(app, getStepCreateModal().getForm().getFormElement(), "main_diagnos");
    }
    /**
     * @return Классифаер "Клиническая форма*"
     */
    public Classifier getClinicalFormField()
    {
        return getStepCreateModal().getForm().getClassifier("clinicalForm");
    }

    /**
     * @return Классифаер "Вторая локализация"
     */
    public Classifier getLocalizationField()
    {
        return getStepCreateModal().getForm().getClassifier("localization");
    }

    /**
     * @return Классифаер "Осложнения"
     */
    public Classifier getComplicationField()
    {
        return getStepCreateModal().getForm().getClassifier("complication");
    }




}
