package businessFramework.module.phthisiatry.modals.mCase;

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
public class MCaseEditHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public MCaseEditHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getContractModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getContractModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getContractModal().getButton(N2O_CANCEL_BUTTON);
    }


    /**
     * @return Классифаер "Пациент"
     */
    public Classifier getPatientField()
    {
        return getContractModal().getForm().getClassifier("patient");
    }

    /**
     * @return Текстовое поле "Номер случая"
     */
    public InputText getNumberField()
    {
        return getContractModal().getForm().getInputText("number");
    }

    /**
     * @return Классифаер "Обращение в текущем году"
     */
    public Classifier getRepeatCountField()
    {
        return getContractModal().getForm().getClassifier("repeat_count");
    }

    /**
     * @return Классифаер "Вид случая"
     */
    public Classifier getCaseTypeField()
    {
        return getContractModal().getForm().getClassifier("case_type");
    }

    /**
     * @return Классифаер "Условия оказания"
     */
    public Classifier getCareRegimenField()
    {
        return getContractModal().getForm().getClassifier("care_regimen");
    }

    /**
     * @return Классифаер "Тип помощи"
     */
    public Classifier getCareLevelField()
    {
        return getContractModal().getForm().getClassifier("care_level");
    }

    /**
     * @return Классифаер "Вид финансирования"
     */
    public Classifier getFundingField()
    {
        return getContractModal().getForm().getClassifier("funding");
    }

    /**
     * @return Классифаер "Цель первичного обращения"
     */
    public Classifier getInitGoalField()
    {
        return getContractModal().getForm().getClassifier("init_goal");
    }

    /**
     * @return Классифаер "Этап установления диагноза"
     */
    public Classifier getStageField()
    {
        return getContractModal().getForm().getClassifier("stage");
    }

    /**
     * @return Классифаер "Диагноз"
     */
    public Classifier getMainDiagnosField()
    {
        return getContractModal().getForm().getClassifier("main_diagnos");
    }

    /**
     * @return Классифаер "Характеристика 1"
     */
    public Classifier getAttr1Field()
    {
        return getContractModal().getForm().getClassifier("attr1");
    }

    /**
     * @return Классифаер "Характеристика 2"
     */
    public Classifier getAttr2Field()
    {
        return getContractModal().getForm().getClassifier("attr2");
    }

    /**
     * @return Классифаер "Характеристика 3"
     */
    public Classifier getAttr3Field()
    {
        return getContractModal().getForm().getClassifier("attr3");
    }

    /**
     * @return Классифаер "Характеристика 4"
     */
    public Classifier getAttr4Field()
    {
        return getContractModal().getForm().getClassifier("attr4");
    }

    /**
     * @return Классифаер "Характеристика 5"
     */
    public Classifier getAttr5Field()
    {
        return getContractModal().getForm().getClassifier("attr5");
    }

    /**
     * @return Классифаер "Характеристика 6"
     */
    public Classifier getAttr6Field()
    {
        return getContractModal().getForm().getClassifier("attr6");
    }

    /**
     * @return Классифаер "Клиническая форма"
     */
    public Classifier getClinicalFormField()
    {
        return getContractModal().getForm().getClassifier("clinicalForm");
    }

    /**
     * @return Классифаер "Вторая локализация"
     */
    public Classifier getLocalizationField()
    {
        return getContractModal().getForm().getClassifier("localization");
    }

    /**
     * @return Классифаер "Осложнения"
     */
    public Classifier getComplicationField()
    {
        return getContractModal().getForm().getClassifier("complication");
    }
}
