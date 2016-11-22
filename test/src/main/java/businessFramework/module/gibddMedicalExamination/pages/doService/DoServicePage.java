package businessFramework.module.gibddMedicalExamination.pages.doService;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DoServicePage extends DoServiceHelper {

    public DoServicePage(ApplicationManager app) {
        super(app);
    }

    /**
     * Проверяет значения полей на форме в модальном окне "Оказание услуги"
     *
     * @param gmeData ожидаемые значения полей.
     */
    public void checkFieldsValues(GibddMedicalExaminationData gmeData) {
        // Получим текущую дату
        Date nowDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String nowDateString = format.format(nowDate);

        assertThat(getDateValue(), equalTo(nowDateString));
    }

    //----------------------- Установка значений для полей ---------------------- //

    /**
     * Выбирает первое значение в комбобоксе "Ресурс" в модальном окне "Оказание услуги"
     */
    public void setResourceAndDiseaseValues() {
        getResourceField().setValue(0); // первая запись из списка.
        getDiseaseCharacterField().setValue(0); // первая запись из списка.
    }

    /**
     * Отмечает радиокнопку "Годен" в модальном окне "Оказание услуги"
     */
    public void setValidValue() {
        getValidField().radioButtonPress("Годен");
    }

    /**
     * Нажимает кнопку "Сохранить" в модальном окне "Оказание услуги"
     */
    public void pressSaveButton() {
        getSaveButton().click();
    }

    /**
     * Устанавливает значения для полей "Ресурс" и "Годен" и нажимает кнопку "Сохранить"
     */
    public void setValuesAndSave() {
        setResourceAndDiseaseValues();
        setValidValue();
        pressSaveButton();
    }

    /**
     * Проверка сообщения об успешном сохранении, когда оно находится в контейнере messages-container
     */
    public void checkSuccessMessage() {
        getContainer("main").getForm().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Закрывает модальное окно "Оказание услуги"
     */
    public void closeDoServiceModal() {
        closePage();
    }
}
