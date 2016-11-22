package businessFramework.module.ambulance.modal;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * Класс описывает модальное окно "Создать бригаду"
 * Это модальное окно открывается со страницы "Бригады: справочники" - "Бригады" по кнопке "Создать" в контейнере "Бригады"
 */
public class AddBrigadeModal extends AddBrigadeHelper
{
    Page page = Page.getInstance();

    public AddBrigadeModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка заголовка модального окна на эквивалентность ожидаемому
     *
     * @param header ожидаемый заголовок модального окна
     */
    public void checkModalHeader(String header)
    {
        getAddBrigadeModal().assertModalHeader_equal(header);
    }

    /**
     * Заполнение полей
     *
     * @param code          Значение для поля "Шаблон" (называется "code" - потому что это значение поля "Код" при создании шаблона вида бригады)
     * @param profile       Значение для поля "Профиль"
     * @param radioCode     Значение для поля "Код рации"
     * @param brigadeName   Значение для поля "Бригада"
     */
    public void fillFields(String code, String profile, String radioCode, String brigadeName)
    {
        if (code != null)           { getTemplateField().setValue(code); }
        if (profile != null)        { getProfileField().setValue(profile); }
        if (radioCode != null)      { getRadioCodeField().setValue(radioCode); }
        if (brigadeName != null)    { getBrigadeNameField().setValue(brigadeName); }
    }

    /**
     * Проверка, что поля заполнены необходимыми значениями.
     *
     * @param jobKind             Значение поля "Вид наряда"
     * @param brigadeKind         Значение поля "Вид бригады"
     * @param brigadeType         Значение поля "Тип бригады"
     * @param brigade             Значение поля "Бригада"
     * @param beginWorkTime       Значение поля "Начало работы бригады"
     * @param endWorkTime       Значение поля "Окончание работы бригады"
     * @param medicalProfile      Значение поля "Мед. профиль"
     */
    public void checkFieldsValues(String jobKind, String brigadeKind, String brigadeType, String brigade, String beginWorkTime, String endWorkTime, String medicalProfile)
    {
        if (jobKind != null)        { getJobKindField().assertValue_equals(jobKind); }
        if (brigadeKind != null)    { getBrigadeKindField().assertValue_equals(brigadeKind); }
        if (brigadeType != null)    { getBrigadeTypeField().assertValue_equals(brigadeType); }
        if (brigade != null)        { getBrigadeNameField().assertValue(brigade); }
        if (beginWorkTime != null)  { getStartBrigadeWorkTimeField().assertValue_equals(beginWorkTime); }
        if (endWorkTime != null)    { getEndBrigadeWorkTimeField().assertValue_equals(endWorkTime); }
        if (medicalProfile != null) { getMedProfileField().assertValue_equals(medicalProfile); }
    }

    /**
     * Заполнение полей Начало действия, Окончания действия прошедшими датами, что приводит к удалению бригад
     */
    public void deleteBrigade()
    {
        getBeginActionField().setValue(page.addDays(page.getCurrentDate(),-2));
        getEndActionField().setValue(page.addDays(page.getCurrentDate(), -1));
        getSaveBrigadeButton().click();
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveBrigadeButton()
    {
        getSaveBrigadeButton().click();
    }

}
