package businessFramework.module.vaccination.pages.dictionary;

import businessFramework.module.Values;
import businessFramework.module.vaccination.modals.dictionary.VaccineProducerModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Получение элементов на странице "Производители вакцин"
 */
public class VaccineProducersHelper extends Page implements Values {

    public VaccineProducersHelper(ApplicationManager app) {
        super(app);
    }

    // Получение контейнера "Производители вакцин"
    public Container getVacineProducerContainer() {
        return getRegion(SINGLE).getContainer("single");
    }

    // Получение модального окна "Создать нового производителя вакцин"
    public VaccineProducerModal getVaccineProducerModal() {
        return new VaccineProducerModal(app);
    }

    // Получение таблицы на странице "Производители вакцин"
    public Table getVaccineProducerTable() {
        return getVacineProducerContainer().getTable();
    }


    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Создать"
    public Button getCreateVaccineProducerButton() {
        return getVacineProducerContainer().getButton(CREATE_BUTTON);
    }

    // Получение кнопки "Изменить"
    public Button getUpdateVaccineProducerButton() {
        return getVacineProducerContainer().getButton(UPDATE_BUTTON);
    }

    // Получение кнопки "Удалить"
    public Button getDeleteVaccineProducerButton() {
        return getVacineProducerContainer().getButton(DELETE_BUTTON);
    }

    // Получение кнопки подтверждения
    public Button getConfirmButton() {
        return this.getModal().getButton(N2O_CONFIRM_BUTTON);
    }


    /* ------------------- Получение полей ------------------- */

    // Получение поля фильтра по полю "Страна"
    public Classifier getCountry() {
        return this.getVacineProducerContainer().getFilter().getClassifier("country");
    }

    // Получение поля фильтра по полю "Наименование"
    public InputText getLabel() {
        return this.getVacineProducerContainer().getFilter().getInputText("label");
    }

    // Получение поля фильтра по полю "Полное наименование"
    public InputText getFullName() {
        return this.getVacineProducerContainer().getFilter().getInputText("full_name");
    }

}
