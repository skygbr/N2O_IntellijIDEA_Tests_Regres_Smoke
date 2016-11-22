package businessFramework.module.pharmacy.modals.DocumentsForWriteOff;


import net.framework.autotesting.ApplicationManager;

public class SpecWriteOffDocModal extends SpecWriteOffDocHelper
{
    public SpecWriteOffDocModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getSpecForWriteOffDoc_Modal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Проверяет значения полей на соответствие ожидаемым, переданным в параметрах метода
     *
     * @param nameLS_IMN_sm         ожидаемое значение поля "Наименование ЛС и ИМН"
     * @param creator_sm            ожидаемое значение поля "Производитель"
     * @param mneiCount_sm          ожидаемое значение поля "Количество в МНЕИ"
     * @param count_sm              ожидаемое значение поля "Количество"
     * @param priceWithNDS_sm       ожидаемое значение поля "Цена с НДС (руб.)"
     * @param priceUnit_sm          ожидаемое значение поля "Ценовая ед. изм."
     * @param sumWithNDS_sm         ожидаемое значение поля "Сумма с НДС (руб.)"
     * @param financingSource_sm    ожидаемое значение поля "Источник финансирования"
     * @param restQuantity          ожидаемое значение поля "Остаток"
     * @param restMneiQuantity      ожидаемое значение поля "Остаток в МНЕИ"
     */
    public void checkFieldsValues(String nameLS_IMN_sm, String creator_sm, String financingSource_sm, String mneiCount_sm, String count_sm,
                                  String priceWithNDS_sm, String priceUnit_sm, String sumWithNDS_sm, String restQuantity, String restMneiQuantity)
    {
        if ( nameLS_IMN_sm != null )        { getNameLS_IMN_specModal_f().assertValue_equals(nameLS_IMN_sm);}
        if ( creator_sm != null )           { getCreator_specModal_f().assertValue_equals(creator_sm);}
        if ( financingSource_sm != null )   { getFinancingSource_specModal_f().assertValue_equals(financingSource_sm);}
        if ( mneiCount_sm != null )         { getMNEICount_specModal_f().assertValue(mneiCount_sm);}
        if ( count_sm != null )             { getCount_specModal_f().assertValue(count_sm); }
        if ( priceWithNDS_sm != null)       { getPriceWithNDS_specModal_f().assertValue(priceWithNDS_sm);}
        if ( priceUnit_sm != null)          { getPriceUnit_specModal_f().assertValue(priceUnit_sm);}
        if ( sumWithNDS_sm != null)         { getSumWithNDS_specModal_f().assertValue(sumWithNDS_sm);}
        if ( sumWithNDS_sm != null)         { getSumWithNDS_specModal_f().assertValue(sumWithNDS_sm);}
        if ( restQuantity != null)          { getRestQuantity().assertValue(restQuantity);}
        if ( restMneiQuantity != null)      { getRestMneiQuantity().assertValue(restMneiQuantity);}
    }

    /**
     * Устанавливает значения в поля
     *
     * @param count_sm значение поля "Количество"
     */
    public void fillFields(String count_sm, String restQuantity) {
        if (count_sm != null)
            getCount_specModal_f().setValue(count_sm);
        if (restQuantity != null)
            getRestQuantity().setValue(restQuantity);
    }

    /**
     * Нажимает кнопку "Сохранить"
     */
    public void clickSaveSpecModalButton()
    {
        getSaveSpecModalButton().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getSpecForWriteOffDoc_Modal().closeModal();
    }
}
