package businessFramework.module.dispensary.modal.setModelAllServices;


import net.framework.autotesting.ApplicationManager;

public class SetModelAllServicesModal extends SetModelAllServicesHelper
{
    public SetModelAllServicesModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Выбор значения в классифаере "Выбрать модель" (завязано на индекс 0 - первая запись)
     */
    public void chooseModelInClassifier()
    {
        getChooseModalClassifier().setValue(0);
    }

    /**
     * Выбор значения в классифаере "Выбрать модель"
     */
    public void chooseModelInClassifier(String modelName)
    {
        getChooseModalClassifier().setValue(modelName);
    }

    /**
     * Возвращает значение, которое выбрано в классифаере "Выбрать модель"
     *
     * @return
     */
    public String getSelectedModel()
    {
        return getChooseModalClassifier().getValue();
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void pressApplyButton()
    {
        getApplyButton().click();
    }
}
