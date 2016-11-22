package businessFramework.module.ambulance.modal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;


/**
 * Получение элементов в модальном окне "Добавить карточку ТС"
 */
public class CreateTransportHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public CreateTransportHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна.
     *
     * Возвращает последнее активное модальное окно
     * @return это модальное окно
     */
    public Modal getCreateTransportModal()
    {
        return page.getModal();
    }



    /*-------------------------------- Получение полей --------------------------------*/


    /**
     * Получение поля "Идентификатор"
     * @return поле "Идентификатор"
     */
    public InputText getIdField()
    {
        return getCreateTransportModal().getForm().getInputText("id");
    }

    /**
     * Получение поля "Организация"
     * @return "Организация"
     */
    public Classifier getOrganisationField()
    {
        return getCreateTransportModal().getForm().getClassifier("station");
    }

    /**
     * Получение поля "Подразделение(МОЛ)"
     * @return поле "Подразделение(МОЛ)"
     */
    public Classifier getSubStationField()
    {
        return getCreateTransportModal().getForm().getClassifier("substation");
    }

    /**
     * Получение поля "Гос. номер"
     * @return поле "Гос. номер"
     */
    public InputText getNumberField()
    {
        return getCreateTransportModal().getForm().getInputText("inventory_number");
    }

    /**
     * Получение поля "Код региона регистрации"
     * @return поле "Код региона регистрации"
     */
    public InputText getRegistrationCodeField()
    {
        return getCreateTransportModal().getForm().getInputText("inventory_code");
    }

    /**
     * Получение поля "Категория"
     * @return поле "Категория"
     */
    public Classifier getTransportCategoryField()
    {
        return getCreateTransportModal().getForm().getClassifier("transport_category");
    }

    /**
     * Получение поля "Тип"
     * @return поле "Тип"
     */
    public Classifier getTransportTypeField()
    {
        return getCreateTransportModal().getForm().getClassifier("transport_type");
    }

    /**
     * Получение поля "Марка"
     * @return поле "Марка"
     */
    public Classifier getTransportBrandField()
    {
        return getCreateTransportModal().getForm().getClassifier("transport_brand");
    }

    /**
     * Получение поля "Модель"
     * @return поле "Модель"
     */
    public Classifier getTransportModelField()
    {
        return getCreateTransportModal().getForm().getClassifier("transport_model");
    }

    /**
     * Получение поля, которое находится под полем "Модель"
     * @return поле, которое находится под полем "Модель"
     */
    public InputText getModelField()
    {
        return getCreateTransportModal().getForm().getInputText("model");
    }

    /**
     * Получение поля "Вид оснащения"
     * @return поле "Вид оснащения"
     */
    public Classifier getEquipmentKindField()
    {
        return getCreateTransportModal().getForm().getClassifier("transport_equipment");
    }

    /**
     * Получение поля "Статус"
     * @return поле "Статус"
     */
    public InputText getStatusField()
    {
        return getCreateTransportModal().getForm().getInputText("stock_unit_state.state_string");
    }

    /**
     * Получение поля "Здание"
     * @return поле "Здание"
     */
    public Classifier getBuildingField()
    {
        return getCreateTransportModal().getForm().getClassifier("building");
    }

    /**
     * Получение поля "Помещение"
     * @return поле "Помещение"
     */
    public Classifier getRoomField()
    {
        return getCreateTransportModal().getForm().getClassifier("room");
    }

    /**
     * Получение поля "Является ресурсом"
     * @return поле "Является ресурсом"
     */
    public InputCheckBox getIsResourceField()
    {
        return getCreateTransportModal().getForm().getInputCheckBox("is_res");
    }

    /**
     * Получение поля "Действует с"
     * @return поле "Действует с"
     */
    public InputDate getFromField()
    {
        return getCreateTransportModal().getForm().getInputDate("from_dt");
    }

    /**
     * Получение поля "по"
     * @return поле "по"
     */
    public InputDate getToField()
    {
        return getCreateTransportModal().getForm().getInputDate("to_dt");
    }


    /*-------------------------------- Получение кнопок --------------------------------*/

    /**
     * Получение кнопки "Сохранить"
     * @return кнопку "Сохранить"
     */
    public Button getSaveCreatedTransportButton()
    {
        return getCreateTransportModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопку "Изменить"
     */
    public Button getEditCreatedTSButton()
    {
        return getCreateTransportModal().getButton(UPDATE_BUTTON);
    }
}
