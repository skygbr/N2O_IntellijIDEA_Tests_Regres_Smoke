package businessFramework.module.dispensary.modal.listOfPatientsModels;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class ListOfPatientsModelsHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public ListOfPatientsModelsHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return модальное окно "Список моделей пациента"
     */
    public Modal getModelsModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение контейнера региона left в модальном окне
     * @return контейнер models
     */
    public Container getModelsContainer()
    {
        return getModelsModal().getContainer("models");
    }

    /**
     * Получение таблицы в левом регионе
     * @return таблицу в левом регионе
     */
    public Table getModelsListTable()
    {
        return getModelsContainer().getTable();
    }


    /**
     * Получение кнопки "Выбрать" в модальном окне "Список моделей пациента"
     * @return кнопку "Выбрать" в модальном окне "Список моделей пациента"
     */
    public Button getChooseButton()
    {
        return getModelsModal().getButton(CONFIRM_BUTTON);
    }


    /* ----------------- Работа с контейнером "Модель пациента" в модальном окне "Список моделей пациента" ----------------- */


    /**
     * Получение формы в контейнере "Модель пациента"
     * @return форму в контейнере "Модель пациента"
     */
    public Form getModelForm()
    {
        return getPatientModelContainer().getForm();
    }

    /**
     * Получение контейнера "Модель пациента" (model) в правом регионе
     * @return контейнер model
     */
    public Container getPatientModelContainer()
    {
        return getModelsModal().getContainer("model");
    }

    /**
     * Получение поля "Название" в контейнере "Модель пациента"
     * @return поле "Название"
     */
    public InputText getModelNameField()
    {
        getModelsModal().assertModalHeader_contains("Список моделей пациента");
        return getModelForm().getInputText("name");
    }

    /**
     * Получение поля "Социальное положение" в контейнере "Модель пациента"
     * @return поле "Социальное положение"
     */
    public Classifier getSocGroupField()
    {
        return getPatientModelContainer().getForm().getClassifier("socGroup");
    }
}
