package businessFramework.module.migrants.modals;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Назначить модель"
 */
public class SetModelHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public SetModelHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getSetModelModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getApplySettingModelButton()
    {
        return getSetModelModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение поля "Модель пациента"
     * @return поле "Модель пациента"
     */
    public Classifier getPatientModelField()
    {
        return getSetModelModal().getForm().getClassifier("model");
    }

    /**
     * Получение модального окна "Список моделей пациента" из этого класса, тк это модальное окно вызывается с модального окна "Установить модель"
     * @return Модальное окно "Список моделей пациента"
     */
    public PatientModelsListModal getPatientListModelModal()
    {
        return new PatientModelsListModal(app);
    }


    /**
     * Проверяерт значение в поле "Модель пациента" на соответствие ожидаемому
     * @param patientModelValue ожидаемое значение в поле "Модель пациента"
     */
    public void checkFields(String patientModelValue)
    {
        getPatientModelField().assertValue_equals(patientModelValue);
    }
}
