package businessFramework.module.dispensary.modal.SetModel;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;


public class SetModelHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public SetModelHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера в модальном окне
     * @return контейнер main
     */
    public Container getModalContainer()
    {
        return getSetModelModal().getContainer("main");
    }

    /**
     * Получение модального окна "Установить модель"
     * @return модальное окно "Установить модель"
     */
    public Modal getSetModelModal()
    {
        return page.getModal();
    }

    /**
     * Получение классифаера "Модель пациента"
     * @return классифаер "Модель пациента"
     */
    public Classifier getPatientModelClassifier()
    {
        return getModalContainer().getForm().getClassifier("model");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getApplyButton()
    {
        return getModalContainer().getButton(N2O_CONFIRM_BUTTON);
    }
}