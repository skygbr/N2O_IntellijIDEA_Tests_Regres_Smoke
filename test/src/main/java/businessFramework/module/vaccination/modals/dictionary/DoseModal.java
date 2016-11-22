package businessFramework.module.vaccination.modals.dictionary;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает модальное окно "Создать новую дозировку" и "Изменить дозировку"
 */
public class DoseModal extends DoseHelper {

    public DoseModal(ApplicationManager app) {
        super(app);
    }

    // Заполнение формы добавления дозировки
    public void fillFields(String count, String label, String code, String eCode) {
        if (count != null)
            getCount().setValue(count);
        if (label != null)
            getDoseType().setValue(label);
        if (code != null)
            getCode().setValue(code);
        if (eCode != null)
            getECode().setValue(eCode);
    }
}
