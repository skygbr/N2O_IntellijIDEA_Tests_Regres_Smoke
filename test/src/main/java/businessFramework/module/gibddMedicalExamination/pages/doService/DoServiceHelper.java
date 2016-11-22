package businessFramework.module.gibddMedicalExamination.pages.doService;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;


public class DoServiceHelper extends Page implements Values
{

    public DoServiceHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получение поля "Дата"
     *
     * @return поле "Дата"
     */
    public InputDate getDateField()
    {
        return getForm().getInputDate("date");
    }

    /**
     * Получение поля "Основной диагноз"
     *
     * @return поле "Основной диагноз"
     */
    public Classifier getMainDiagnosisField()
    {
        return getForm().getClassifier("main_diagnosis");
    }

    /**
     * Получение поля "Характер заболевания"
     *
     * @return поле "Характер заболевания"
     */
    public Classifier getDiseaseCharacterField()
    {
        return getForm().getClassifier("disease");
    }

    /**
     * Получение значения поля "Дата"
     *
     * @return значение поля "Дата"
     */
    public String getDateValue()
    {
        return getDateField().getValue();
    }

    /**
     * Получение значения поля "Основной диагноз"
     *
     * @return значение поля "Основной диагноз"
     */
    public String getMainDiagnosisValue()
    {
        return getMainDiagnosisField().getValue();
    }

    /**
     * Получение значения поля "Характер заболевания"
     *
     * @return значение поля "Характер заболевания"
     */
    public String getDiseaseCharacterValue()
    {
        return getDiseaseCharacterField().getValue();
    }

    /**
     * Получает поле Ресурс
     *
     * @return поле Ресурс
     */
    public Classifier getResourceField()
    {
        return getForm().getClassifier("resource");
    }

    /**
     * Получает группу радиокнопок is_validA.
     * Надо получить конкретную радиокнопку и нажать ее - через этот метод путем вызова метода radioButtonPress
     *
     * @return  группу радиокнопок is_validA.
     */
    public Radio getValidField()
    {
        return getForm().getRadio("is_validA");
    }

    /**
     * Получение кнопки "Сохранить"
     *
     * @return кнопку "Сохранить"
     */
    public Button getSaveButton()
    {
        return getButton(N2O_CONFIRM_BUTTON);
    }
}
