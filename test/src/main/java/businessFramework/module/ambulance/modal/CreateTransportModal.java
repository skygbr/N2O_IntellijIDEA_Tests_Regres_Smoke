package businessFramework.module.ambulance.modal;


import net.framework.autotesting.ApplicationManager;

/**
 * Класс описывает модальное окно "Добавить карточку ТС".
 * Это модальное окно открывается со страницы "Бригады: справочники" - "Транспортное средство"
 */
public class CreateTransportModal extends CreateTransportHelper
{

    public CreateTransportModal(ApplicationManager app)
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
        getCreateTransportModal().assertModalHeader_equal(header.toLowerCase());
    }

    /**
     * Закрывает модальное окно.
     */
    public void closeModal()
    {
        getCreateTransportModal().closeModal();
    }


    /**
     * Заполнение полей
     *
     * @param number            Значение для поля "Гос. номер"
     * @param equipmentKind     Значение для поля "Вид оснащения"
     * @param category          Значение для поля "Категория"
     */
    public void fillFields(String number, String equipmentKind, String category)
    {
        if ( number != null )           { getNumberField().setValue(number);  }
        if ( equipmentKind != null )    { getEquipmentKindField().setValue(equipmentKind);  }
        if ( category != null )         { getTransportCategoryField().setValue(category);  }
    }

    /**
     * Проверка значений в полях
     * @param isChecked Проверять ли, что отмечено поле "Является ресурсом"
     */
    public void checkFields(Boolean isChecked)
    {
        if (isChecked) { getIsResourceField().assertThatCheckboxIsChecked(true); }
    }

    /**
     * Проверка, что поля задизейблены
     */
    public void checkFieldsDisability()
    {
        getIdField().assertIsDisabled(true);
        getSubStationField().assertThatComboboxIsDisabled();
        getNumberField().assertIsDisabled(true);
        getRegistrationCodeField().assertIsDisabled(true);
        getTransportCategoryField().assertThatComboboxIsDisabled();
        getTransportTypeField().assertThatComboboxIsDisabled();
        getTransportBrandField().assertThatComboboxIsDisabled();
        getTransportModelField().assertThatComboboxIsDisabled();
        getModelField().assertIsDisabled(true);
        getEquipmentKindField().assertThatComboboxIsDisabled();
        getStatusField().assertIsDisabled(true);
        getBuildingField().assertThatComboboxIsDisabled();
        getRoomField().assertThatComboboxIsDisabled();
        getIsResourceField().assertIsDisabled();
        getFromField().assertIsDisabled(true);
        getToField().assertIsDisabled(true);
    }


    /**
     * Нажатие кнопки "Сохранить"
     */
    public void clickSaveCreatedTransportButton()
    {
        getSaveCreatedTransportButton().click();
    }

    /**
     * Нажатие кнопки "Изменить"
     */
    public void clickEditCreatedTSButton()
    {
        getEditCreatedTSButton().click();
    }

}
