package businessFramework.module.vaccination.modals.dictionary;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает модальное окно "Создать новую единицу измерения" и "Изменить единицы измерения"
 */
public class DoseTypeModal extends DoseTypeHelper{

    public DoseTypeModal(ApplicationManager app) {
        super(app);
    }



    // Заполнение формы добавления единицы измерения
    public void fillFields(String code, String label) {
        if (label != null)
            getLabel().setValue(label);
        if (code != null)
            getCode().setValue(code);
    }
}
