package businessFramework.module.vaccination.modals.dictionary;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Получение элементов в модальном окне "Создать новую единицу измерения" и "Изменить единицу измерения"
 */
public class DoseTypeHelper extends Page implements Values {

    public DoseTypeHelper(ApplicationManager app) {
        super(app);
    }
    private Page page = Page.getInstance();

    //Получение модального окна
    public Modal getAddDoseTypeModal() {
        return page.getModal();
    }

    /* ------------------- Получение полей ------------------- */

    // Получение поля "Код"
    public InputText getCode() {
        return getAddDoseTypeModal().getForm().getInputText("code");
    }

    // Получение поля "Единица измерения"
    public InputText getLabel() {
        return getAddDoseTypeModal().getForm().getInputText("label");
    }

    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Сохранить"
    public Button getSaveDoseTypeButton() {
        return getAddDoseTypeModal().getButton(N2O_CONFIRM_BUTTON);
    }

    // Получение кнопки "Отмена"
    public Button getCancelButton() {
        return getAddDoseTypeModal().getButton(N2O_CANCEL_BUTTON);
    }
}
