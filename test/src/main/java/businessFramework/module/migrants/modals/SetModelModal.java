package businessFramework.module.migrants.modals;


import net.framework.autotesting.ApplicationManager;

/**
 * Модальное окно "Назначить модель".
 * Это модальное окно открывается по кнопке "+" в контейнере "Модель пациента" на странице "Карточка мероприятия"
 */
public class SetModelModal extends SetModelHelper
{
    public SetModelModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void clickApplySettingModelButton()
    {
        getApplySettingModelButton().click();
    }

    /**
     * Нажатие кнопки "Лупа" в компоненте "Модель пациента"
     */
    public void clickSearchButton()
    {
        getPatientModelField().findModalButtonClick();
    }

    /**
     * Проверяет заголовок модального окна на эквивалентность строке, переданной в параметре header
     * @param header ожидаемый заголовок модального окна."
     */
    public void checkModalHeader(String header)
    {
        getSetModelModal().assertModalHeader_equal(header);
    }
}
