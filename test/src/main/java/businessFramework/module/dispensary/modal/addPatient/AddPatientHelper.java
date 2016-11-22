package businessFramework.module.dispensary.modal.addPatient;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class AddPatientHelper extends Page implements Values
{
    private Page page = Page.getInstance();

    public AddPatientHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getAddPatientModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение классифаера "Пациент"
     * @return классифаер "Пациент"
     */
    public Classifier getPatientClassifier()
    {
        return getAddPatientModal().getForm().getClassifier("patient");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getAddPatientModal().getButton(N2O_CONFIRM_BUTTON);
    }
}
