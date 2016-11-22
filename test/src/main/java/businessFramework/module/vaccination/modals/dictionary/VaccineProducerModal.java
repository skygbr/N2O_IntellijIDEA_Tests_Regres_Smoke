package businessFramework.module.vaccination.modals.dictionary;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает модальное окно "Создать нового производителя вакцин" и "Изменить производителя вакцин"
 */
public class VaccineProducerModal extends VaccineProducerHelper {

    public VaccineProducerModal(ApplicationManager app) {
        super(app);
    }

    // Заполнение формы добавления производителя вакцин
    public void fillFields(String country, String label, String fullName) {
        if (country != null)
            getCountry().setValue(country);
        if (label != null)
            getLabel().setValue(label);
        if (fullName != null)
            getFullName().setValue(fullName);
    }

}
