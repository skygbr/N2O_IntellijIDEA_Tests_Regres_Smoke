package businessFramework.module.dispensary.modal.setModelAllServices;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class SetModelAllServicesHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public SetModelAllServicesHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна "Задать модель"
     * @return модальное окно "Задать модель"
     */
    public Modal getSetModelAllServicesModal()
    {
        return page.getModal();
    }

    /**
     * Получение комбобокса "Выбрать модель" в модальном окне "Задать модель"
     * @return комбобокс "Выбрать модель"
     */
    public Classifier getChooseModalClassifier()
    {
        return getSetModelAllServicesModal().getForm().getClassifier("model");
    }

    /**
     * Получение кнопки "Подтвердить" в модальном окне
     * @return кнопку "Подтвердить" в модальном окне
     */
    public Button getApplyButton()
    {
        return getSetModelAllServicesModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
