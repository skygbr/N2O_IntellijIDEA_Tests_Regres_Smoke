package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;

/**
 * Created by bulat.garipov on 31.10.2016.
 */
public class MRefSetHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public MRefSetHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getRefSetModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getRefSetModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getRefSetModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Классифаер "МО*"
     */
    public Classifier getСlinicField()
    {
        return getRefSetModal().getForm().getClassifier("clinic");
    }

    /**
     * @return Классифаер "Вид финансирования*"
     */
    public Classifier getFinancialTypeField()
    {
        return getRefSetModal().getForm().getClassifier("financialType");
    }

    /**
     * @return Заполнить дату "Дата направления*"
     */
    public InputDate getPlannedDateField()
    {
        return getRefSetModal().getForm().getInputDate("plannedDate");
    }

    /**
     * @return Классифаер "Услуга*"
     */
    public Classifier getServiceField()
    {
        return getRefSetModal().getForm().getClassifier("service");
    }

}
