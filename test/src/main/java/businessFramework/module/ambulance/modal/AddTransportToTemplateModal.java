package businessFramework.module.ambulance.modal;

import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Добавить ТС в шаблон вида бригады 'ЛИН'"
 */
public class AddTransportToTemplateModal extends AddTransportToTemplateHelper
{
    public AddTransportToTemplateModal(ApplicationManager app)
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
        getAddTransportModal().assertModalHeader_equal(header);
    }

    /**
     * Заполнение полей
     *
     * @param role          Значение для поля "Роль"
     * @param workingPlace  Значение для поля "Рабочее место"
     * @param tsType        Значение для поля "Тип ТС"
     * @param equipmentKind Значение для поля "Вид оснащения"
     */
    public void fillFields(String role, String workingPlace, String tsType, String equipmentKind)
    {
        if ( role != null)          { getTransportRoleField().setValue(role); }
        if ( workingPlace != null)  { getTransportWorkingPlaceField().setValue(workingPlace); }
        if ( tsType != null)        { getTS_TypeField().setValue(tsType); }
        if ( equipmentKind != null) { getEquipmentKindField().setValue(equipmentKind); }
    }

    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveTransportButton()
    {
        getSaveTransportButton().click();
    }
}
