package businessFramework.module.pharmacy.modals.PharmacyApplications;


import net.framework.autotesting.ApplicationManager;

public class CreateAppSpecModal extends CreateAppSpecModalHelper
{
    public CreateAppSpecModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getCreateAppSpecModal().closeModal();
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getCreateAppSpecModal().assertModalHeader_equal(expectedHeader);
    }

    /** ---------------------- Поля на форме модального окна "Создание спецификации" --------------------- */
    /** ---------------------- Нажатие кнопок на форме модального окна "Создание спецификации" --------------------- */

    /**
     * Нажимает кнопку "Подтвердить"
     */
    public void clickSaveAppSpecButton()
    {
        getSaveAppSpecButton().click();
    }

    /**
     * Заполняет поля на форме в модальном окне создания спецификации
     *
     * @param nameLS_IMN    значение для поля "Наименование ЛС и ИМН"
     * @param creator       значение для поля "Производитель"
     * @param count         значение для поля "Кол-во"
     * @param priceWithNDS  значение для поля "Цена с НДС, руб."
     * @param sumWithNDS    значение для поля "Сумма с НДС, руб."
     * @param comment       значение для поля "Примечание"
     */
    public void fillFields(String nameLS_IMN, String creator, String count, String priceWithNDS, String sumWithNDS, String comment)
    {
        if ( nameLS_IMN != null )   { getNameLS_IMN_Field().setValue(nameLS_IMN);}
        if ( creator != null )      { getCreatorField().setValue(creator);}
        if ( count != null )        { getCountField().setValue(count);}
        if ( priceWithNDS != null ) { getPriceNDS_Field().setValue(priceWithNDS);}
        if ( sumWithNDS != null )   { getSumNDS_Field().setValue(sumWithNDS);}
        if ( comment != null )      { getCommentField().setValue(comment);}
    }

    /**
     * Проверяет значения в полях на соответствие ожидаемым
     *
     * @param nameLS_IMN    ожидаемое значение поля "Наименование ЛС и ИМН"
     * @param creator       ожидаемое значение поля "Производитель"
     * @param count         ожидаемое значение поля "Кол-во"
     * @param priceWithNDS  ожидаемое значение поля "Цена с НДС, руб."
     * @param sumWithNDS    ожидаемое значение поля "Сумма с НДС, руб."
     * @param comment       ожидаемое значение поля "Примечание"
     */
    public void checkFields(String nameLS_IMN, String creator, String count, String priceWithNDS, String sumWithNDS, String comment)
    {
        if ( nameLS_IMN != null )   { getNameLS_IMN_Field().assertValue_equals(nameLS_IMN);}
        if ( creator != null )      { getCreatorField().assertValue_equals(creator);}
        if ( count != null )        { getCountField().assertValue(count);}
        if ( priceWithNDS != null ) { getPriceNDS_Field().assertValue(priceWithNDS);}
        if ( sumWithNDS != null )   { getSumNDS_Field().assertValue(sumWithNDS);}
        if ( comment != null )      { getCommentField().assertValue(comment);}
    }

    /**
     * Проверка, что поля недоступны для изменения значений
     */
    public void checkFieldsDisability()
    {
        getNameLS_IMN_Field().assertThatComboboxIsDisabled();
        getCreatorField().assertThatComboboxIsDisabled();
        getCountField().assertIsDisabled(true);
        getCountField().assertIsDisabled(true);
        getPriceNDS_Field().assertIsDisabled(true);
        getSumNDS_Field().assertIsDisabled(true);
        getCommentField().assertIsDisabled(true);
    }
}

