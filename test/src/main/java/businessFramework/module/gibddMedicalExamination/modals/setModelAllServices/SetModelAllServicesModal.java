package businessFramework.module.gibddMedicalExamination.modals.setModelAllServices;


import net.framework.autotesting.ApplicationManager;

public class SetModelAllServicesModal extends SetModelAllServicesHelper
{
    public SetModelAllServicesModal(ApplicationManager app)
    {
        super(app);
    }

    // Выбор значения в классифаере "Выбрать модель" (завязано на индекс 0 - первая запись)
    public void chooseModelInClassifier()
    {
        getChooseModalClassifier().setValue(0);
    }

    // Возвращает значение, которое выбрано в классифаере "Выбрать модель"
    public String getSelectedModel()
    {
       return getChooseModalClassifier().getValue();
    }

    // Нажатие кнопки "Подтвердить"
    public void pressApplyButton()
    {
        getApplyButton().click();
    }
}
