package businessFramework.module.migrants.modals;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

/**
 * Получение элементов в модальном окне "Поиск пациента"
 */
public class PatientSearchModalHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public PatientSearchModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getPatientSearchModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /* ------------------ Получение полей на форме ----------------- */

    /**
     * Получение поля "Фамилия"
     * @return поле "Фамилия"
     */
    public InputText getSurnameField()
    {
        return getPatientSearchModal().getFilter().getInputText("surname");
    }

    /**
     * Получение поля "Имя"
     * @return поле "Имя"
     */
    public InputText getNameField()
    {
        return getPatientSearchModal().getFilter().getInputText("name");
    }

    /**
     * Получение поля "Отчество"
     * @return поле "Отчество"
     */
    public InputText getPatrNameField()
    {
        return getPatientSearchModal().getFilter().getInputText("patrName");
    }

    /**
     * Получение поля "Дата рождения"
     * @return поле "Дата рождения"
     */
    public InputDate getBirthDateField()
    {
        return getPatientSearchModal().getFilter().getInputDate("birthDate");
    }

    /**
     * Получение поля "Номер документа"
     * @return поле "Номер документа"
     */
    public InputText getDocumentNumberField()
    {
        return getPatientSearchModal().getFilter().getInputText("document");
    }

    /**
     * Получение кнопки "Найти"
     * @return кнопку "Найти"
     */
    public Button getSearchPatientButton()
    {
        return getPatientSearchModal().getButton(SUBMIT);
    }

    /**
     * Получение кнопки "Выбрать"
     * @return кнопку "Выбрать"
     */
    public Button getChoosePatientButton()
    {
        return getPatientSearchModal().getButton(CONFIRM_BUTTON);
    }

    /**
     * Получение таблицы со списком найденный по фильтру пациентов
     * @return таблицу со списком найденный по фильтру пациентов
     */
    public Table getFoundPatientsListTable()
    {
        return getPatientSearchModal().getTable();
    }



}
