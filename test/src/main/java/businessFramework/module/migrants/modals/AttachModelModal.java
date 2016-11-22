package businessFramework.module.migrants.modals;


import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Задать модель".
 * Это модальное окно открывается по нажатию кнопки "Задать модель всем услугам" в таблице "Услуги" на странице "Карточка мероприятия"
 */
public class AttachModelModal extends AttachModalHelper
{
    public AttachModelModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void clickApplyAttachModelButton()
    {
        getApplyModelButton().click();
    }

    /**
     * Нажатие кнопки "Лупа" в компоненте "Выбрать модель"
     */
    public void clickFindModelButton()
    {
        getSelectModelField().findModalButtonClick();
    }

    /**
     * Проверяет заголовок модального окна на эквивалентность строке, переданной в параметре header
     * @param header ожидаемый заголовок модального окна."
     */
    public void checkModalHeader(String header)
    {
        getAttachModelModal().assertModalHeader_equal(header);
    }

    /**
     * Получение модального окна "Список моделей пациента" из этого класса, тк это модальное окно вызывается с модального окна "Установить модель"
     * @return Модальное окно "Список моделей пациента"
     */
    public PatientModelsListModal getPatientListModelModal()
    {
        return new PatientModelsListModal(app);
    }

}
