package businessFramework.module.gibddMedicalExamination.modals.addPatient;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddPatientModal extends AddPatientHelper
{

    public AddPatientModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Добавить пациента"
     */
    public void checkModalHeader()
    {
        getAddPatientModal().assertModalHeader_equal("Добавить пациента");
    }

    /**
     *  Проверка значения поля "Дата выдачи бланка"
     */
    public void checkBlankDateValue()
    {
        assertThat(getBlankDateValue(), equalTo(getCurrentDate()));
    }

    /**
     * Нажатие кнопки "Лупа" в классифаере "Пациент"
     */
    public void pressFindButtonPatientClassifier()
    {
        getPatientClassifier().findModalButtonClick();
    }

    /**
     * Проверка значения в классифаере "Пациент"
     * @param fullName - значение, которое ожидается в классифаере "Пациент"
     */
    public void checkValueInPatientClassifier(String fullName)
    {
        getPatientClassifier().assertValue_equals(fullName);
    }

    /**
     * Заполнение полей в модальном окне "Добавить пациента"
     * @param gMEData - значения для полей
     */
    public void fillFields(GibddMedicalExaminationData gMEData)
    {
        getReferenceSeries().setValue(gMEData.getAddPatientReferenceSeries());// Серия справки
        getReferenceNumber().setValue(gMEData.getAddPatientReferenceNumber());// Номер справки
        getCheckboxesCategoryTS().check(gMEData.getAddPatientCategoryTS(), true);// Категория ТС
        checkBlankDateValue();// Проверка значения поля "Дата выдачи бланка". Значение поля - текущая дата.
    }

    /**
     * Нажатие кнопки "Подтвердить" модальном окне "Добавить пациента"
     */
    public void pressConfirmButton()
    {
        getConfirmButton().click();
    }
}
