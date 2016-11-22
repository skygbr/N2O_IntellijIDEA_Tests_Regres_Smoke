package businessFramework.module.gibddMedicalExamination.modals.addPatient;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

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
     * Получение поля "Дата выдачи бланка"
     * @return поле "Дата выдачи бланка"
     */
    public InputDate getBlankDate()
    {
        return getAddPatientModal().getForm().getInputDate("blank_date");
    }

    /**
     * Получение значения поля "Дата выдачи бланка"
     * @return значение поля "Дата выдачи бланка"
     */
    public String getBlankDateValue()
    {
        return getBlankDate().getValue();
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
     * Получение поля "Серия справки"
     * @return поле "Серия справки"
     */
    public InputText getReferenceSeries()
    {
        return getAddPatientModal().getForm().getInputText("reference_series");
    }

    /**
     * Получение поля "Номер справки"
     * @return поле "Номер справки"
     */
    public InputText getReferenceNumber()
    {
        return getAddPatientModal().getForm().getInputText("reference_number");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getAddPatientModal().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение группы чекбоксов "Категория ТС"
     * @return группу чекбоксов "Категория ТС"
     */
    public InputCheckBox getCheckboxesCategoryTS()
    {
        return getAddPatientModal().getForm().getInputCheckBox("categoryTS");
    }



}
