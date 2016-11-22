package businessFramework.module.pharmacy.modals.TransferAct;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by ngerasimov on 20.11.2015.
 */
public class TransferActSpecModal extends TransferActSpecHelper
{
    public TransferActSpecModal(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Проверка текста заголовка модального окна
     */
    public void checkModalHeader(String expectedHeader)
    {
        getTransferActSpecModal().assertModalHeader_equal(expectedHeader);
    }

    /**
     * Проверка значений в полях в модальном окне добавления спецификации
     *
     * @param nameLS_IMN_spec       поле "Наименование ЛС и ИМН"
     * @param creator_spec          поле "Производитель"
     * @param financingSource_spec  поле "Источник финансирования"
     * @param MNEICount_spec        поле "Количество в МНЕИ:"
     * @param count_spec            поле "Количество"
     * @param price_spec            поле "Цена с НДС(руб.)"
     * @param sum_spec              поле "Сумма с НДС(руб)"
     */
    public void checkModalWindowFieldsValues(String nameLS_IMN_spec, String creator_spec, String financingSource_spec, String MNEICount_spec, String count_spec, String price_spec, String sum_spec)
    {
        if (nameLS_IMN_spec != null)        { getNameLS_IMN_spec_f().assertValue_equals(nameLS_IMN_spec);}
        if (creator_spec != null)           { getCreator_spec_f().assertValue_equals(creator_spec);}
        if (financingSource_spec != null)   { getFinancingSource_spec_f().assertValue_equals(financingSource_spec);}
        if (MNEICount_spec != null)         { getMNEICount_spec_f().assertValue(MNEICount_spec);}
        if (count_spec != null)             { getCount_spec_f().assertValue(count_spec);}
        if (price_spec != null)             { getPrice_spec_f().assertValue(price_spec);}
        if (sum_spec != null)               { getSum_spec_f().assertValue(sum_spec);}
    }

    /**
     * Установка значений в поля в модальном окне добавления спецификации
     * @param count     поле "Количество"
     */
    public void setModalWindowFieldsValues(String count)
    {
        if (count != null) { getCount_spec_f().setValue(count); }
    }

    /**
     * Нажимает кнопку "Сохранить" в модальном окне добавления спецификации
     */
    public void clickSaveSpecButton()
    {
        getSaveButton_spec().click();
    }

    /**
     * Закрывает модальное окно
     */
    public void closeModal()
    {
        getTransferActSpecModal().closeModal();
    }
}
