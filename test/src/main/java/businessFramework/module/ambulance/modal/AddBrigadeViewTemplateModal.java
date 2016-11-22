package businessFramework.module.ambulance.modal;


import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Создать шаблон вида бригады"
 * Это модальное окно открывается со страницы "Настройка вида бригады" путем нажатия кнопки "Добавить" В контейнере "Настройка вида бригады"
 */
public class AddBrigadeViewTemplateModal extends AddBrigadeViewTemplateHelper
{
    public AddBrigadeViewTemplateModal(ApplicationManager app)
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
        getAddBrigadeViewTemplateModal().assertModalHeader_equal(header);
    }

    /**
     * Заполнение полей значениями. Можно заполнять не все поля, передав null в качестве значений тех полей, которые не надо заполнять.
     *
     * @param code          Значение для поля "Код"
     * @param name          Значение для поля "Наименование"
     * @param brigadeKind   Значение для поля "Вид бригады"
     * @param jobKind       Значение для поля "Вид наряда"
     * @param brigadeType   Значение для поля "Тип бригады"
     * @param profile       Значение для поля "Профиль"
     */
    public void fillFields(String code, String name, String brigadeKind, String jobKind, String brigadeType, String profile)
    {
        if ( code != null)          { getCodeField().setValue(code); }
        if ( name != null)          { getNameField().setValue(name); }
        if ( brigadeKind != null)   { getBrigadeKindField().setValue(brigadeKind); }
        if ( jobKind != null)       { getJobKindField().setValue(jobKind); }
        if ( brigadeType != null)   { getBrigadeTypeField().setValue(brigadeType); }
        if ( profile != null)       { getProfileField().setValue(profile); }
    }

    /**
     * Нажание кнопки "Сохранить"
     */
    public void clickSaveBrigadeViewTemplateButton()
    {
        getSaveBrigadeViewTemplateButton().click();
    }
}
