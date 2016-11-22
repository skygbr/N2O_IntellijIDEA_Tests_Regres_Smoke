package businessFramework.module.pharmacy.modals.PharmacyApplications;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class CreateAppSpecModalHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public CreateAppSpecModalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getCreateAppSpecModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /** ---------------------- Поля на форме модального окна "Создание спецификации" --------------------- */

    /**
     * @return поле "Наименование ЛС и ИМН"
     */
    public Classifier getNameLS_IMN_Field()
    {
        return getCreateAppSpecModal().getForm().getClassifier("modif");
    }

    /**
     * @return поле "Производитель"
     */
    public Classifier getCreatorField()
    {
        return getCreateAppSpecModal().getForm().getClassifier("producer");
    }

    /**
     * @return поле "Кол-во"
     */
    public InputText getCountField()
    {
        return getCreateAppSpecModal().getForm().getInputText("quantity");
    }

    /**
     * @return поле "Цена с НДС, руб."
     */
    public InputText getPriceNDS_Field()
    {
        return getCreateAppSpecModal().getForm().getInputText("price");
    }

    /**
     * @return поле "Сумма с НДС, руб."
     */
    public InputText getSumNDS_Field()
    {
        return getCreateAppSpecModal().getForm().getInputText("amount");
    }

    /**
     * @return поле "Примечание"
     */
    public InputText getCommentField()
    {
        return getCreateAppSpecModal().getForm().getInputText("note");
    }

    /** ---------------------- Кнопки на форме модального окна "Создание спецификации" --------------------- */

    /**
     * @return Кнопку "Сохранить"
     */
    public Button getSaveAppSpecButton()
    {
        return getCreateAppSpecModal().getButton(N2O_CONFIRM_BUTTON);
    }

}
