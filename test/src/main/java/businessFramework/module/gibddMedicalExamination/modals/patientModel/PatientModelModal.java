package businessFramework.module.gibddMedicalExamination.modals.patientModel;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PatientModelModal extends PatientModelHelper
{
    private Page page = Page.getInstance();

    public PatientModelModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Заполнение полей на форме в модальном окне "Модель пациента"
     */
    public void fillFieldsPatientModel(GibddMedicalExaminationData gMPData)
    {
        getName().setValue(gMPData.getPatientModelName());                                        // Установка значения в поле "Наименование"
        //Todo решение проблемы поиска по лейблу, не срабатывет поиск: css selector: .n2o-modal-container]] -> class name: n2o-form-container]] -> css selector: [data-field-id*='gender']]] -> xpath: //label[contains(string(), ' Мужской')]/input]
        /**
         * getCheckboxesGenderGroup().check(gMPData.getPatientModelGenderMan(), true);            // Отметить чекбоксы 1 - 'Мужской' , 2 - 'Женский', 3 - 'Не определенный' в группе чекбоксов "Пол"
         * getCheckboxesGenderGroup().check(gMPData.getPatientModelGenderFemale(), true);
         * getCheckboxesGenderGroup().check(gMPData.getPatientModelGenderIndefinite(), true);
         */
        this.getPatientModelForm().findElement(By.xpath("(//input[@name='gender'])[1]")).click();
        this.getPatientModelForm().findElement(By.xpath("(//input[@name='gender'])[2]")).click();
        this.getPatientModelForm().findElement(By.xpath("(//input[@name='gender'])[3]")).click();
        getSocial().setValue(gMPData.getPatientModelSocial());                                    // Заполнить значение Социальное положение
        getGenderRadio().radioButtonPress("Базовая");                                             // Отметить 'Базовый' вид модели пациента
        getCheckboxesLicenceCategory().check(gMPData.getLicenseCategoryA(), true);                // Отметить чекбоксы 'A', 'A1', 'B', 'B1' в группе чекбоксов Категории ТС
        getCheckboxesLicenceCategory().check(gMPData.getLicenseCategoryA1(), true);
        getCheckboxesLicenceCategory().check(gMPData.getLicenseCategoryB(), true);
        getCheckboxesLicenceCategory().check(gMPData.getLicenseCategoryB1(), true);

        fillAfFields("0", "50", "10", "Лет", null, null);                                         // заполнение полей в компоненте "Исполняется в год мероприятия"
        clickAfAddNewButton();
        checkResult("0,10,20,30,40,50");
        fillAfFields("0", "50", "10", "Месяцев", null, null);
        clickAfAddNewButton();
        checkResult("0,10,20,30,40,50, 0.0,0.10,1.8,2.6,3.4,4.2");
        fillAfFields(null, null, null, null, "1", "12");
        clickAfManualAddButton();
        checkResult("0,10,20,30,40,50, 0.0,0.10,1.8,2.6,3.4,4.2, 1.12");
    }

    /**
     * Заполнение полей на форме в модальном окне "Модель пациента" дополнительная модель
     */
    public void fillFieldsPatientAdditionalModel(GibddMedicalExaminationData gMPAData)
    {
        getName().setValue(gMPAData.getPatientModelName());                                       // Установка значения в поле "Наименование"
        /**
        getCheckboxesGenderGroup().check(gMPAData.getPatientModelGenderMan(), true);              // Отметить чекбоксы 1 - 'Мужской' , 2 - 'Женский', 3 - 'Не определенный' в группе чекбоксов "Пол"
        getCheckboxesGenderGroup().check(gMPAData.getPatientModelGenderFemale(), true);
         */
        this.getPatientModelForm().findElement(By.xpath("(//input[@name='gender'])[1]")).click();
        this.getPatientModelForm().findElement(By.xpath("(//input[@name='gender'])[2]")).click();
        getSocial().setValue(gMPAData.getPatientModelSocial());                                   // Заполнить значение Социальное положение
        getGenderRadio().radioButtonPress("Дополнительная");                                      // Отметить 'Дополнительный' вид модели пациента
        getCheckboxesLicenceCategory().check(gMPAData.getLicenseCategoryM(), true);               // Отметить чекбоксы 'M', 'Tm', 'Tb' в группе чекбоксов Категории ТС
        getCheckboxesLicenceCategory().check(gMPAData.getLicenseCategoryTm(), true);
        getCheckboxesLicenceCategory().check(gMPAData.getLicenseCategoryTb(), true);

        fillAfFields("51", "100", "10", "Лет", null, null);                                       // заполнение полей в компоненте "Исполняется в год мероприятия"
        clickAfAddNewButton();
        checkResult("51,61,71,81,91");
        fillAfFields("51", "100", "10", "Месяцев", null, null);
        clickAfAddNewButton();
        checkResult("51,61,71,81,91, 4.3,5.1,5.11,6.9,7.7");
        fillAfFields(null, null, null, null, "10", "12");
        clickAfManualAddButton();
        checkResult("51,61,71,81,91, 4.3,5.1,5.11,6.9,7.7, 10.12");
    }

    public void checkResult(String expectedResult)
    {
        assertThat("In the Input Text field af-result value " + getAfResult().getAttribute("value") + " is not equal to " + expectedResult,
                   getAfResult().getAttribute("value"), equalTo(expectedResult));
    }

    /**
     * Заполнение полей в компоненте "Исполняется в год мероприятия"
     */
    public void fillAfFields(String afStartDate, String afEndDate, String afIntDate, String afTypeDate, String afManualY, String afManualM)
    {
        executeJavaScript("$('.af-result').focus()");

        if (afStartDate != null)
        {
            afStartDateSetValue(afStartDate);
        }
        if (afEndDate != null)
        {
            afEndDateSetValue(afEndDate);
        }
        if (afIntDate != null)
        {
            afIntDateSetValue(afIntDate);
        }
        if (afTypeDate != null)
        {
            selectAfTypeDate(afTypeDate);
        }
        if (afManualY != null)
        {
            afManualYSetValue(afManualY);
        }
        if (afManualM != null)
        {
            afManualMSetValue(afManualM);
        }
    }

    public void setValue(WebElement element, String value)
    {

        String script = "var meta = arguments[0];"+
                "$(meta).val('\"\"'); " +
                "$(meta).val('" + value + "'); " +
                "$(meta).keyup();";

        executeJavaScript(script, element);
        waitForNetworkAndJsIdle();
    }

    /**
     * Установка данных в поля в компоненте "Исполняется в год мероприятия"
     */

    /**
     * Установка значения в поле af-start-date
     */
    public void afStartDateSetValue(String value)
    {
        setValue(getStartDate(), value);
    }

    /**
     * Установка значения в поле af-end-date
     */
    public void afEndDateSetValue(String value)
    {
        setValue(getEndDate(), value);
    }

    /**
     * Установка значения в поле af-int-date
     */
    public void afIntDateSetValue(String value)
    {
        setValue(getIntDate(), value);
    }

    /**
     * Нажатие кнопки af-add-new
     */
    public void clickAfAddNewButton()
    {
        click(getAddNewButton());
    }

    /**
     * Установка значения в поле af-type-date
     */
    public void selectAfTypeDate(String value)
    {
        for (WebElement option : getOptions()){
            if (option.getText().equals(value)) {
                click(option);
                break;
            }
        }
    }

    /**
     * Установка значения в поле af-manual-y-date
     */
    public void afManualYSetValue(String value)
    {
        setValue(getManualYDate(), value);
    }

    /**
     * Установка значения в поле af-manual-m-date
     */
    public void afManualMSetValue(String value)
    {
        setValue(getManualMDate(), value);
    }

    /**
     * Нажатие кнопки af-add-manual
     */
    public void clickAfManualAddButton()
    {
        click(getAddManualButton());
    }

    /**
     * Проверка, что появилось сообщение об успешном сохранении
     */
    public void checkSuccessMessage()
    {
        getPatientModelForm().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Численность населения"
     * @param headerPatientModelModal ожидаемый заголовок модального окна
     */
    public void checkModalHeader(String headerPatientModelModal)
    {
        getPatientModelModal().assertModalHeader_equal(headerPatientModelModal);
    }

    /**
     * Нажать кнопку "Сохранить"
     */
    public void pressConfirmButton()
    {
        Button buttonConfirm = getConfirmButton();
        buttonConfirm.assertIsEnabled();
        buttonConfirm.click();
    }

    /**
     * Нажать кнопку "Отмена"
     */
    public void pressCancelButton()
    {
        Button buttonCancel = getCancelButton();
        buttonCancel.assertIsEnabled();
        buttonCancel.click();
    }
}
