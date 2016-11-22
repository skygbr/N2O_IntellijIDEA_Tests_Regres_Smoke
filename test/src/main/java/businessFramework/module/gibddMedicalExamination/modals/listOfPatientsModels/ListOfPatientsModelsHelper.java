package businessFramework.module.gibddMedicalExamination.modals.listOfPatientsModels;


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
     * Получение кнопки "Добавить"
     * @return кнопку "Добавить"
     */
    public Button getAddButton()
    {
        return getModelsContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Получение кнопки Удалить в контейнере "Список моделей пациента"
     * @return кнопку Удалить в контейнере "Список моделей пациента"
     */
    public Button getDeleteButton()
    {
        return getModelsContainer().getButton(DELETE_BUTTON);
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
     * Получение модального окна с предупреждением при удалении записи из контейнера "Список моделей пациента"
     * @return модальное окно с предупреждением при удалении записи из контейнера "Список моделей пациента"
     */
    public Modal getWarningModal()
    {
        return page.getModal();
    }

    /**
     * Получение кнопки "Выбрать" в модальном окне "Список моделей пациента"
     * @return кнопку "Выбрать" в модальном окне "Список моделей пациента"
     */
    public Button getChooseButton()
    {
        return getModelsModal().getButton(CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки "Да" в модальном окне getWarningModal
     * @return кнопку "Да" в модальном окне getWarningModal
     */
    public Button getConfirmButtonWarningModal()
    {
        return getWarningModal().getButton(CONFIRM_BUTTON);
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


    /* ----------------- Работа с контейнером "Пол и возраст" в модальном окне "Список моделей пациента" ----------------- */


    /**
     * Получение контейнера "Пол и возраст" в правом регионе
     * @return контейнер "Пол и возраст" в правом регионе
     */
    public Container getGenderAndAgeContainer()
    {
        return getModelsModal().getContainer("modelPatientBase");
    }

    /**
     * Получение таблицы "Пол и возраст"
     * @return таблицу "Пол и возраст"
     */
    public Table getGenderAndAgeTable()
    {
        return getGenderAndAgeContainer().getTable();
    }


}
