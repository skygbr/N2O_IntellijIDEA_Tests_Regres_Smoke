package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ServiceExecutionHelper extends Page implements Values
{

    public ServiceExecutionHelper(ApplicationManager app) {
        super(app);
    }


    /**
     * Получение контейнера "Выполнение услуги"
     * @return контейнер "Выполнение услуги"
     */
    public Container getContainerService()
    {
        return getContainer("main");
    }

    /**
     * Получение поля "Организация"
     * @return поле "Организация"
     */
    public InputText getOwnerOrganisation()
    {
        return getContainerService().getForm().getInputText("owner_org");
    }

    /**
     * Получение поля "Дата"
     * @return поле "Дата"
     */
    public InputDate getExecutionDate()
    {
        return getContainerService().getForm().getInputDate("date");
    }

    /**
     * Получение радиобаттона "Результат"
     * @return радиобаттон "Результат"
     */
    public Radio getResultRadio()
    {
        return getContainerService().getForm().getRadio("result");
    }

    /**
     * Получение поля "Основной диагноз"
     * @return поле "Основной диагноз"
     */
    public Classifier getMainDiagnosis() {
        return getContainerService().getForm().getClassifier("main_diagnosis");
    }

    /**
     * Получение поля "Основной диагноз"
     * @return поле "Основной диагноз"
     */
    public Classifier getDisease() {
        return getContainerService().getForm().getClassifier("disease");
    }

    /**
     * Получение кнопки "Подтведить"
     * @return кнопка "Подтведить"
     */
    public Button getConfirmButton()
    {
        return getContainerService().getButton(N2O_CONFIRM_BUTTON);
    }
}