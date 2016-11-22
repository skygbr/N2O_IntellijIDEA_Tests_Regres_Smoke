package businessFramework.module.gibddMedicalExamination.modals.setModel;


import businessFramework.module.gibddMedicalExamination.modals.listOfPatientsModels.ListOfPatientsModelsModal;
import net.framework.autotesting.ApplicationManager;

public class SetModelModal extends SetModelHelper {
    public SetModelModal(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверка, что модальное окно открылось
     *
     * @param count       ожидаемое количество модальных окон на странице
     * @param modalHeader заголовок модального окна, который необходимо проверить.
     */
    public void assertThatModalIsPresent(int count, String modalHeader) {
        assertCountOfModals(count);
        getSetModelModal().assertModalHeader_equal(modalHeader); // заголовок последнего активного модального окна
    }

    /**
     * Нажать на иконку Лупа классифаера "Модель пациента"
     */
    public void pressFindButton() {
        getPatientModelClassifier().findModalButtonClick();
    }

    /**
     * Получение модального окна "Список моделей пациента" (получаем через модальное окно "Назначить модель",
     * т.к. с этого окна происходит открытие модального окна Список моделей пациента)
     *
     * @return модальное окно "Список моделей пациента"
     */
    public ListOfPatientsModelsModal getListOfPatientsModelsModal() {
        return new ListOfPatientsModelsModal(app);
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void clickApplyButton() {
        getApplyButton().click();
    }

}
