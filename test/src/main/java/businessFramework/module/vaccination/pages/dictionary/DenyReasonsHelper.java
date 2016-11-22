package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.module.Values;
import businessFramework.module.vaccination.modals.dictionary.DenyReasonModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Получение элементов на странице "Причины медицинского отвода"
 */
public class DenyReasonsHelper extends Page implements Values {

    public DenyReasonsHelper(ApplicationManager app) {
        super(app);
    }

    // Получение контейнера "Причины медицинского отвода"
    public Container getDenyReasonContainer() {
        return getRegion(SINGLE).getContainer("single");
    }

    // Получение модального окна "Создать новую причину медицинского отвода"
    public DenyReasonModal getDenyReasonModal() {
        return new DenyReasonModal(app);
    }

    // Получение таблицы на странице "Причины медицинского отвода"
    public Table getDenyReasonTable() {
        return getDenyReasonContainer().getTable();
    }


    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Создать"
    public Button getCreateDenyReasonButton() {
        return getDenyReasonContainer().getButton(CREATE_BUTTON);
    }

    // Получение кнопки "Изменить"
    public Button getUpdateDenyReasonButton() {
        return getDenyReasonContainer().getButton(UPDATE_BUTTON);
    }

    // Получение кнопки "Удалить"
    public Button getDeleteDenyReasonButton() {
        return getDenyReasonContainer().getButton(DELETE_BUTTON);
    }

    // Получение кнопки подтверждения
    public Button getConfirmButton() {
        return this.getModal().getButton(N2O_CONFIRM_BUTTON);
    }


    /* ------------------- Получение фильтров ------------------ */

    // Получение поля фильтра по полю "Страна"
    public InputText getCode() {
        return this.getDenyReasonContainer().getFilter().getInputText("code");
    }

    // Получение поля фильтра по полю "Причина"
    public InputText getLabel() {
        return this.getDenyReasonContainer().getFilter().getInputText("label");
    }

}
