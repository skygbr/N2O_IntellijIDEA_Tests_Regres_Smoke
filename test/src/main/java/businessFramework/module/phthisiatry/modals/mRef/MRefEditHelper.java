package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputCheckBox;
import net.framework.autotesting.meta.components.InputDate;

/**
 * Created by bulat.garipov on 31.10.2016.
 */
public class MRefEditHelper  extends Page implements Values
{
    private Page page = Page.getInstance();

    public MRefEditHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */

    public Modal getRefEditModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getRefEditModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getRefEditModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * Получение чекбокса "Срочно"
     * @return чекбокс "Срочно"
     */
    public InputCheckBox getCheckboxesIsUrgentField()
    {
        return getRefEditModal().getForm().getInputCheckBox("isUrgent");
    }

    /**
     * @return Классифаер "МО*"
     */
    public Classifier getClinicField()
    {
        return getRefEditModal().getForm().getClassifier("clinic");
    }

    /**
     * @return Классифаер "Вид финансирования*"
     */
    public Classifier getFinancialTypeField()
    {
        return getRefEditModal().getForm().getClassifier("financialType");
    }

    /**
     * @return Заполнить дату "Дата направления*"
     */
    public InputDate getPlannedDateField()
    {
        return getRefEditModal().getForm().getInputDate("plannedDate");
    }

    /**
     * @return Классифаер "Услуга*"
     */
    public Classifier getServiceField()
    {
        return getRefEditModal().getForm().getClassifier("service");
    }

}
