package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.module.Values;
import businessFramework.module.vaccination.modals.dictionary.DoseModal;
import businessFramework.module.vaccination.modals.dictionary.DoseTypeModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 */
public class DosesHelper extends Page implements Values {
    
    public DosesHelper(ApplicationManager app) {
        super(app);
    }

    // Получение контейнера "Дозировки"
    public Container getDoseContainer() {
        return getRegion(TOP).getContainer("dose");
    }

    // Получение контейнера "Единицы измерения"
    public Container getDoseTypeContainer() {
        return getContainer("dose_type");
    }

    // Получение модального окна "Создать новую дозировку" и "Изменить дозировку"
    public DoseModal getDoseModal() {
        return new DoseModal(app);
    }

    // Получение таблицы дозировок на странице "Дозировки"
    public Table getDoseTable() {
        return getDoseContainer().getTable();
    }

    // Получение модального окна "Создать новую дозировку" и "Изменить дозировку"
    public DoseTypeModal getDoseTypeModal() {
        return new DoseTypeModal(app);
    }

    // Получение таблицы единиц измерения на странице "Дозировки"
    public Table getDoseTypeTable() {
        return getDoseTypeContainer().getTable();
    }


    /* ------------------- Получение кнопок в контейнере "Дозировки" ------------------- */

    // Получение кнопки "Создать"
    public Button getCreateDoseButton() {
        return getDoseContainer().getButton(CREATE_BUTTON);
    }

    // Получение кнопки "Изменить"
    public Button getUpdateDoseButton() {
        return getDoseContainer().getButton(UPDATE_BUTTON);
    }

    // Получение кнопки "Удалить"
    public Button getDeleteDoseButton() {
        return getDoseContainer().getButton(DELETE_BUTTON);
    }

    // Получение кнопки подтверждения
    public Button getConfirmButton() {
        return this.getModal().getButton(N2O_CONFIRM_BUTTON);
    }

        /* ------------------- Получение кнопок в контейнере "Единицы измерения" ------------------- */

    // Получение кнопки "Создать"
    public Button getCreateDoseTypeButton() {
        return getDoseTypeContainer().getButton(CREATE_BUTTON);
    }

    // Получение кнопки "Изменить"
    public Button getUpdateDoseTypeButton() {
        return getDoseTypeContainer().getButton(UPDATE_BUTTON);
    }

    // Получение кнопки "Удалить"
    public Button getDeleteDoseTypeButton() {
        return getDoseTypeContainer().getButton(DELETE_BUTTON);
    }

    /* ------------------- Получение фильтров ------------------ */

    // Получение поля фильтра по полю "Доза" контейнера "Дозировки"
    public InputText getCount() {
        return this.getDoseContainer().getFilter().getInputText("count");
    }

    // Получение поля фильтра по полю "Единица измерения" контейнера "Дозировки"
    public Classifier getDoseType() {
        return this.getDoseContainer().getFilter().getClassifier("doseType");
    }

    // Получение поля фильтра по полю "Код" контейнера "Дозировки"
    public InputText getDoseCode() {
        return this.getDoseContainer().getFilter().getInputText("code");
    }

    // Получение поля фильтра по полю "Доза" контейнера "Единицы измерения"
    public InputText getDoseTypeCode() {
        return this.getDoseContainer().getFilter().getInputText("code");
    }

    // Получение поля фильтра по полю "Единица измерения" контейнера "Единицы измерения"
    public InputText getDoseTypeLabel() {
        return this.getDoseContainer().getFilter().getInputText("label");
    }
}
