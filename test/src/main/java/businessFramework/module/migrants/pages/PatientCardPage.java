package businessFramework.module.migrants.pages;

import businessFramework.module.migrants.modals.ClosingCardModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Класс описывает страницу "Карточка ИГ и ЛГ".
 * Переход на эту страницу осуществляется со страницы "Список мероприятий" по нажатию кнопки "Карточка" в контейнере "Освидетельствование ИГ и ЛГ", выбрав строчку в таблице.
 */
public class PatientCardPage extends PatientCardHelper
{
    public PatientCardPage(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Переход на вкладку "Общие сведения"
     */
    public void clickGeneralInfoContainer()
    {
        getGeneralInformationContainer().clickContainer();
    }

    /**
     * Проверяет значения текстовых полей на соответствие ожидаемым ( в контейнере "Общие значения" )
     *
     * @param surname   ожидаемое значение поля "Фамилия"
     * @param name      ожидаемое значение поля "Имя"
     * @param patrName  ожидаемое значение поля "Отчество"
     * @param birthDay  ожидаемое значение поля "Дата рождения"
     */
    public void checkCommonInfo(String surname, String name, String patrName, String birthDay)
    {
        if (surname != null )   { assertThat(getSurnameValue(),     equalTo(surname)); }
        if (name != null )      { assertThat(getNameValue(),        equalTo(name)); }
        if (patrName != null )  { assertThat(getPatrNameValue(),    equalTo(patrName)); }
        if (birthDay!= null )   { assertThat(getBirthDayValue(),    equalTo(birthDay)); }
    }

    /**
     * Проверяет значения в полях "Прибыл из" и "Цель получения справки"
     *
     * @param arrived   ожидаемое значение поля "Прибыл из"
     * @param purpose   ожидаемое значение поля "Цель получения справки"
     */
    public void checkFieldsValues(String arrived, String purpose)
    {
        //Нажатие на ссылку "Показать подробную информацию"
        getGeneralInformationContainer().getForm().findElement(By.cssSelector(".n2o-form-widget-short-button")).click();
        if (arrived != null) { getArrivedCountryField().assertValue_equals(arrived); }
        if (purpose != null) { getPurposeField().assertValue_equals(purpose); }
    }

    /**
     * Нажатие на кнопку "Очистить", прием диалогового окна и проверка сообщения об успешном сохранении
     */
    public void clearService()
    {
        Button button = getClearServiceButton();
        button.assertIsEnabled();
        button.click();
        getDialog().clickYes();
        getServicesAndViewTable().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Нажатие на кнопку "Выполнить услугу"
     */
    public void clickExecuteServiceButton()
    {
        Button button = getExecuteServiceButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Получение модального окна "Выполнение услуги"
     * @return "Выполнение услуги"
     */
    public ServiceExecutionPage getServiceExecutionPage()
    {
        return new ServiceExecutionPage(app);
    }


    /**------------------------- Действия в контейнере "Заключение" -----------------------------------------------*/

    /**
     * Проверка значений полей дат
     */
    public void assertConclusionDates()
    {
        getConclusionDate().assertThatDateContainsValue(getCurrentDate());
        getSertificateBeginDate().assertThatDateContainsValue(getCurrentDate());
    }

    /**
     * Выполнение заключения: Заполнение обязательных полей, нажатие кнопки "Сохранить", проверка сообщения об успешном сохранении
     * @param sertificateNumber значение поля "Номер сертификата"
     */
    public void executeConclussion(String sertificateNumber, String conclusionNumber)
    {
        getSertificateNumber().setValue(sertificateNumber);
        getConclusionNumber().setValue(conclusionNumber);
        getCommission().setValue(0);

        Button saveButton = getSaveButton();
        saveButton.assertIsEnabled();
        saveButton.click();

        getConclusionContainer().getForm().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Нажатие кнопки "Закрыть карту""
     */
    public void clickCloseCardButton()
    {
        Button button = getCloseCardButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Получение модального окна "Выполнение услуги"
     * @return "Выполнение услуги"
     */
    public ClosingCardModal getClosingCardModal()
    {
        return new ClosingCardModal(app);
    }

    /** ------------------------  Получение элементов, содержащих значения текстовых полей ----------------------------*/

}
