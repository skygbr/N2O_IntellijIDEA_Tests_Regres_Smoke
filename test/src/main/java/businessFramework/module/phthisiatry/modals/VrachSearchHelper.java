package businessFramework.module.phthisiatry.modals;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
/**
 * Получение элементов в модальном окне "Поиск врача"
 */
public class VrachSearchHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public VrachSearchHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Модальное окно Врач
     */
    public Modal getVrachSearchModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение классифаера "Врач"
     * @return классифаер "Врач"
     */
    public Classifier getVrach()
    {
        return getVrachSearchModal().getForm().getClassifier("res");
    }

    /* ------------------ Получение полей на форме ----------------- */

    /**
     * Получение поля "Фамилия"
     * @return поле "Фамилия"
     */
    public InputText getSurnameField()
    {
        return getVrachSearchModal().getFilter().getInputText("surname");
    }

    /**
     * Получение поля "Имя"
     * @return поле "Имя"
     */
    public InputText getNameField()
    {
        return getVrachSearchModal().getFilter().getInputText("name");
    }

    /**
     * Получение поля "Отчество"
     * @return поле "Отчество"
     */
    public InputText getPatrNameField()
    {
        return getVrachSearchModal().getFilter().getInputText("patr_name");
    }

    /**
     * Получение поля "Дата рождения"
     * @return поле "Дата рождения"
     */
    public InputDate getBirthDateField()
    {
        return getVrachSearchModal().getFilter().getInputDate("birth_date");
    }

    /**
     * Получение поля "Должность"
     * @return поле "Должность"
     */
    public InputText getPosNameField()
    {
        return getVrachSearchModal().getFilter().getInputText("pos.name");
    }

    /**
     * Получение кнопки "Найти"
     * @return кнопку "Найти"
     */
    public Button getSearchVrachButton()
    {
        return getVrachSearchModal().getButton(SUBMIT);
    }

    /**
     * Получение кнопки "Выбрать"
     * @return кнопку "Выбрать"
     */
    public Button getChooseVrachButton()
    {
        return getVrachSearchModal().getButton(CONFIRM_BUTTON);
    }

    /**
     * Получение таблицы со списком найденный по фильтру врачей
     * @return таблицу со списком найденный по фильтру врачей
     */
    public Table getFoundVrachListTable()
    {
        return getVrachSearchModal().getTable();
    }
}
