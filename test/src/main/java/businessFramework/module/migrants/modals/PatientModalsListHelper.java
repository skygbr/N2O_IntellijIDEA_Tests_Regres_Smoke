package businessFramework.module.migrants.modals;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение компонентов в модальном окне "Список моделей пациента"
 */
public class PatientModalsListHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public PatientModalsListHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getPatientModalsListModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }


    /**
     * Получение контейнера models слева
     * @return Контейнер models
     */
    public Container getModelsContainer()
    {
        return getPatientModalsListModal().getContainer("models");
    }

    /**
     * Получение кнопки "Выбрать"
     * @return Кнопку "Выбрать"
     */
    public Button getChooseModelButton()
    {
        return getPatientModalsListModal().getButton(CONFIRM_BUTTON);
    }

    /**
     * Получение таблицы "Список моделей пациента"
     * @return Таблицу "Список моделей пациента"
     */
    public Table getModelsTable()
    {
        return getModelsContainer().getTable();
    }

    /**
     * Проверяет заголовок модального окна на эквивалентность строке, переданной в параметре header
     * @param header ожидаемый заголовок модального окна."
     */
    public void checkModalHeader(String header)
    {
        getPatientModalsListModal().assertModalHeader_equal(header);
    }
}
