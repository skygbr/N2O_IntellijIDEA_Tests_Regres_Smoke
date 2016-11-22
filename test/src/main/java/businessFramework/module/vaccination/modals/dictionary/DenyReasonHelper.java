package businessFramework.module.vaccination.modals.dictionary;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Получение элементов в модальном окне "Создать новую причину медицинского отвода" и "Изменить причину медициинского отвода"
 */
public class DenyReasonHelper extends Page implements Values {

    public DenyReasonHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    //Получение модального окна
    public Modal getAddDenyReasonModal() {
        return page.getModal();
    }

    /* ------------------- Получение полей ------------------- */

    // Получение поля "Код"
    public InputText getCode() {
        return getAddDenyReasonModal().getForm().getInputText("code");
    }

    // Получение поля "Наименование"
    public InputText getLabel() {
        return getAddDenyReasonModal().getForm().getInputText("label");
    }

    // Получение поля "Признак постоянности отвода"
    public InputCheckBox getPermanently() {
        return getAddDenyReasonModal().getForm().getInputCheckBox("permanently");
    }

    // Получение поля "Наличие диагноза"
    public InputCheckBox getDiagnos() {
        return getAddDenyReasonModal().getForm().getInputCheckBox("diagnos");
    }

    // Получение поля "Обязательность диагноза"
    public InputCheckBox getDiagnosRequired() {
        return getAddDenyReasonModal().getForm().getInputCheckBox("diagnos_required");
    }

    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Сохранить"
    public Button getSaveDenyReasonButton() {
        return getAddDenyReasonModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
