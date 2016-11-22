package businessFramework.module.vaccination.modals.dictionary;

import net.framework.autotesting.ApplicationManager;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Класс описывает модальное окно "Создать новую причину медицинского отвода" и "Изменить причину медицинского отвода"
 */
public class DenyReasonModal extends DenyReasonHelper {

    public DenyReasonModal(ApplicationManager app) {
        super(app);
    }

    // Заполнение формы добавления причины медицинского отвода
    public void fillFields(String code, String label, Boolean permanently, Boolean diagnos, Boolean diagnosRequired) {
        if (code != null)
            getCode().setValue(code);
        if (label != null)
            getLabel().setValue(label);
        getPermanently().check(permanently);
        getDiagnos().check(diagnos);
        getDiagnosRequired().check(diagnosRequired);
    }
}
