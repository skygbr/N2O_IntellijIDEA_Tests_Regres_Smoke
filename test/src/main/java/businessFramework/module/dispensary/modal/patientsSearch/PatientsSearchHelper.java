package businessFramework.module.dispensary.modal.patientsSearch;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.*;


public class PatientsSearchHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public PatientsSearchHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return модальное окно "Поиск пациентов"
     */
    public Modal getSearchPatientsModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение поля Фамилия
     * @return значение поля "Фамилия"
     */
    public InputText getSurnameField()
    {
        return getSearchPatientsModal().getFilter().getInputText("surname");
    }

    /**
     * Получение поля Имя
     * @return значение поля "Имя"
     */
    public InputText getNameField()
    {
        return getSearchPatientsModal().getFilter().getInputText("name");
    }

    /**  Получение поля Отчество
     * @return значение поля "Отчество"
     */
    public InputText getPatrNameField()
    {
        return getSearchPatientsModal().getFilter().getInputText("patrName");
    }

    /**
     * Получение поля Дата Рождения
     * @return значение поля "Дата Рождения"
     */
    public InputDate getBirthDateField()
    {
        return getSearchPatientsModal().getFilter().getInputDate("birthDate");
    }

    /**
     * Получение поля Номер документа
     * @return значение поля "Номер документа"
     */
    public InputText getDocumentNumberField()
    {
        return getSearchPatientsModal().getFilter().getInputText("document");
    }

    /**
     * Получение кнопки "Найти"
     * @return кнопку "Найти"
     */
    public Button getFindButton()
    {
        return getSearchPatientsModal().getButton(SUBMIT);
    }

    /**
     * Получение таблицы в контейнере pats
     * @return таблицу в контейнере pats
     */
    public Table getPatientsSearchTable()
    {
        return getSearchPatientsModal().getContainer("pats").getTable();
    }

    /**
     * Получение кнопки "Выбрать"
     * @return кнопку "Выбрать"
     */
    public Button getChooseButton()
    {
        return getSearchPatientsModal().getButton(CONFIRM_BUTTON);
    }

}
