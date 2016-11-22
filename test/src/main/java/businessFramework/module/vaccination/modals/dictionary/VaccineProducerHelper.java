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
 * Получение элементов в модальном окне "Создать нового производителя вакцин" и "Изменить производителя вакцин"
 */
public class VaccineProducerHelper extends Page implements Values {

    public VaccineProducerHelper(ApplicationManager app) {
        super(app);
    }

    private Page page = Page.getInstance();

    //Получение модального окна
    public Modal getAddVaccineProducerModal() {
        return page.getModal();
    }


    /* ------------------- Получение полей ------------------- */

    // Получение поля "Страна"
    public Classifier getCountry() {
        return getAddVaccineProducerModal().getForm().getClassifier("country");
    }

    // Получение поля "Наименование"
    public InputText getLabel() {
        return getAddVaccineProducerModal().getForm().getInputText("label");
    }

    // Получение поля "Полное наименование"
    public InputText getFullName() {
        return getAddVaccineProducerModal().getForm().getInputText("full_name");
    }


    /* ------------------- Получение кнопок ------------------- */

    // Получение кнопки "Сохранить"
    public Button getSaveVaccineProducerButton() {
        return getAddVaccineProducerModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
