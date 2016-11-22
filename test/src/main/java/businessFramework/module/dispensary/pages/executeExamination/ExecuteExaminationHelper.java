package businessFramework.module.dispensary.pages.executeExamination;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

public class ExecuteExaminationHelper extends Page implements Values {

    public ExecuteExaminationHelper(ApplicationManager app) {
        super(app);
    }


    /**
     * Получает поле Ресурс
     *
     * @return поле Ресурс
     */
    public Classifier getResource()
    {
        return getForm().getClassifier("resource");
    }

    /**
     * Получает поле Основной диагноз
     *
     * @return поле Основной диагноз
     */
    public Classifier getMainDiagnosis()
    {
        return getForm().getClassifier("main_diagnosis");
    }

    /**
     * Получает поле Характер заболевания
     *
     * @return поле Характер заболевания
     */
    public Classifier getDiseaseField()
    {
        return getForm().getClassifier("disease");
    }

    /**
     * Получает поле Дата
     *
     * @return поле Дата
     */
    public InputDate getDateField()
    {
        return getForm().getInputDate("date");
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