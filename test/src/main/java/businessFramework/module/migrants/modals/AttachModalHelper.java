package businessFramework.module.migrants.modals;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
/**
 * Получение элементов модального окна "Задать модель"
 */
public class AttachModalHelper extends Page implements Values
{
    private Page page = Page.getInstance();


    public AttachModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getAttachModelModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }


    /**
     * Получение кнопки "Подтвердить"
     * @return Кнопку "Подтвердить"
     */
    public Button getApplyModelButton()
    {
        return getAttachModelModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение поля "Выбрать модель"
     * @return Поле "Выбрать модель"
     */
    public Classifier getSelectModelField()
    {
        return getAttachModelModal().getForm().getClassifier("model");
    }

    /**
     * Проверяерт значение в поле "Выбрать модель" на соответствие ожидаемому
     * @param patientModelValue ожидаемое значение в поле "Выбрать модель"
     */
    public void checkFields(String patientModelValue)
    {
        getSelectModelField().assertValue_equals(patientModelValue);
    }

}
