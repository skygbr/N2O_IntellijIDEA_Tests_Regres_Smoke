package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
public class MRefRenderedHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public MRefRenderedHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getRefRenderedModal()
    {
        return page.getModal();
    }

    public Button getConfirmButton()
    {
        return getRefRenderedModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCancelButton()
    {
        return getRefRenderedModal().getButton(N2O_CANCEL_BUTTON);
    }

    /**
     * @return Классифаер "МО*"
     */
    public Classifier getСlinicField()
    {
        return getRefRenderedModal().getForm().getClassifier("clinic");
    }

    /**
     * @return Классифаер "Вид финансирования*"
     */
    public Classifier getFinancialTypeField()
    {
        return getRefRenderedModal().getForm().getClassifier("financialType");
    }

    /**
     * @return Заполнить дату "Дата оказания*"
     */
    public InputDate getRenderedDateField()
    {
        return getRefRenderedModal().getForm().getInputDate("renderedDate");
    }

    /**
     * @return Заполнить дату "Дата направления*"
     */
    public InputDate getPlannedDateField()
    {
        return getRefRenderedModal().getForm().getInputDate("plannedDate");
    }

    /**
     * @return Классифаер "Услуга*"
     */
    public Classifier getServiceField()
    {
        return getRefRenderedModal().getForm().getClassifier("service");
    }

    /**
     * @return Классифаер "Врач*"
     */
    public Classifier getVrachField()
    {
        return getRefRenderedModal().getForm().getClassifier("res");
    }

    /**
     * @return Классифаер "Диагноз*"
     */
    public Classifier getDiagnosField()
    {
        return getRefRenderedModal().getForm().getClassifier("diagnos");
    }

    /**
     * @return Текстовое поле "Заключение"
     */
    public InputText getCommentField()
    {
        return getRefRenderedModal().getForm().getInputText("comment");
    }

}
