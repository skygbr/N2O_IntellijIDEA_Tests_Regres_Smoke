package businessFramework.module.dispensary.modal.addPatient;


import net.framework.autotesting.ApplicationManager;

public class AddPatientModal  extends AddPatientHelper
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
     * Нажатие кнопки "Подтвердить" модальном окне "Добавить пациента"
     */
    public void pressConfirmButton()
    {
        getConfirmButton().click();
    }
}

