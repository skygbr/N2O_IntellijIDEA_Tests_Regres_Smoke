package businessFramework.module.vaccination.modals.dictionary;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Получение элементов в модальном окне "Создать дозировку" и "Изменить дозировку"
 */
public class DoseHelper extends Page implements Values {

    public DoseHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    //Получение модального окна
    public Modal getAddDoseModal() {
        return page.getModal();
    }

    /* ------------------- Получение полей ------------------- */

    // Получение поля "Доза"
    public InputText getCount() {
        return getAddDoseModal().getForm().getInputText("count");
    }

    // Получение поля "Единица измерения"
    public Classifier getDoseType() {
        return getAddDoseModal().getForm().getClassifier("doseType");
    }

    // Получение поля "Код"
    public InputText getCode() {
        return getAddDoseModal().getForm().getInputText("code");
    }

    // Получение поля "Дополнительный код"
    public InputText getECode() {
        return getAddDoseModal().getForm().getInputText("e_code");
    }

    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Сохранить"
    public Button getSaveDoseButton() {
        return getAddDoseModal().getButton(N2O_CONFIRM_BUTTON);
    }

    // Получение кнопки "Отмена"
    public Button getCancelButton() {
        return getAddDoseModal().getButton(N2O_CANCEL_BUTTON);
    }
}
