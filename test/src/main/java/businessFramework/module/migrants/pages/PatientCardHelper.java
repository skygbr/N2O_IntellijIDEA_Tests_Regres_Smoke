package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Получение элементов на странице "Карточка ИГ и ЛГ"
 */
public class PatientCardHelper extends Page implements Values
{
    public PatientCardHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера "Общие сведения"
     * @return контейнер "Общие сведения"
     */
    public Container getGeneralInformationContainer()
    {
        return getContainer("generalInformation");
    }


    /** ------------------------  Получение элементов, содержащих значения текстовых полей ----------------------------*/

    /**
     * Получение текстового поля surname. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле surname.
     */
    public WebElement getSurnameContainer()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("[data-field-id = 'surname']"));
    }

    /**
     * Получение текстового поля name. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле name.
     */
    public WebElement getNameContainer()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("[data-field-id = 'name']"));
    }

    /**
     * Получение текстового поля patrname. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле patrname.
     */
    public WebElement getPatrNameContainer()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("[data-field-id = 'patrname']"));
    }

    /**
     * Получение текстового поля birthday. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле birthday.
     */
    public WebElement getBirthDayContainer()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("[data-field-id = 'birthday']"));
    }



    /*--------------------- Получение значений текстовых полей -----------------------*/


    /**
     * Получение значения текстового поля Surname. Оно находится в элементе n2o-text-value, который находится в элементе, возвращаемом методом getSurnameContainer
     * @return значение текстового поля Surname.
     */
    public String getSurnameValue()
    {
        return getSurnameContainer().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Получение значения текстового поля Name. Оно находится в элементе n2o-text-value, который находится в элементе, возвращаемом методом getNameContainer
     * @return значение текстового поля Name.
     */
    public String getNameValue()
    {
        return getNameContainer().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Получение значения текстового поля PatrName. Оно находится в элементе n2o-text-value, который находится в элементе, возвращаемом методом getPatrNameContainer
     * @return значение текстового поля PatrName.
     */
    public String getPatrNameValue()
    {
        return getPatrNameContainer().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Получение значения текстового поля BirthDay. Оно находится в элементе n2o-text-value, который находится в элементе, возвращаемом методом getBirthDayContainer
     * @return значение текстового поля BirthDay.
     */
    public String getBirthDayValue()
    {
        return getBirthDayContainer().findElement(By.className("n2o-text-value")).getText();
    }


    /* -------------------------- Получение полей ------------------------------ */

    /**
     * Получение поля "Прибыл из"
     * @return поле "Прибыл из"
     */
    public Classifier getArrivedCountryField()
    {
        return getGeneralInformationContainer().getForm().getClassifier("arrivedCountry");
    }

    /**
     * Получение поля "Цель получения справки"
     * @return поле "Цель получения справки"
     */
    public Classifier getPurposeField()
    {
        return getGeneralInformationContainer().getForm().getClassifier("purpose");
    }



    /* -------------------------- Контейнер "Осмотры и услуги" ------------------------------ */

    /**
     * Получение контейнера "Осмотры и услуги"
     * @return конетйнер "Осмотры и услуги"
     */
    public Container getServicesAndViewContainer()
    {
        return getContainer("serviceData");
    }

    /**
     * Получение таблицы в контейнере "Осмотры и услуги"
     * @return таблицу в контейнере "Осмотры и услуги"
     */
    public Table getServicesAndViewTable()
    {
        return getServicesAndViewContainer().getTable();
    }

    /**
     * Получение кнопки "Оказать услугу"
     * @return кнопка "Оказать услугу"
     */
    public Button getExecuteServiceButton()
    {
        return getServicesAndViewContainer().getButton("inspec");
    }

    /**
     * Получение кнопки "Очистить"
     * @return кнопка "Очистить"
     */
    public Button getClearServiceButton()
    {
        return getServicesAndViewContainer().getButton("clearService");
    }

    /*-------------------------- Контейнер "Заключение" ------------------------------ */

    /**
     * Получение контейнера "Заключение"
     * @return конетйнер "Заключение"
     */
    public Container getConclusionContainer()
    {
        return getContainer("conclusion");
    }

    /**
     * Получение текстового поля "Номер сертификата"
     * @return текстовое поле "Номер сертификата"
     */
    public InputText getSertificateNumber()
    {
        return getConclusionContainer().getForm().getInputText("certificate_number");
    }

    /**
     * Получение текстового поля "Номер заключения"
     * @return текстовое поле "Номер заключения"
     */
    public InputText getConclusionNumber()
    {
        return getConclusionContainer().getForm().getInputText("conclusion_number");
    }

    /**
     * Получение поля даты "Дата выдачи"
     * @return текстовое поле "Дата выдачи"
     */
    public InputDate getSertificateBeginDate()
    {
        return getConclusionContainer().getForm().getInputDate("cert_date_begin");
    }

    /**
     * Получение поля даты "Годен до"
     * @return текстовое поле "Годен до"
     */
    public InputDate getSertificateEndDate()
    {
        return getConclusionContainer().getForm().getInputDate("cert_date_end");
    }

    /**
     * Получение поля даты "Дата выдачи"
     * @return текстовое поле "Дата выдачи"
     */
    public InputDate getConclusionDate()
    {
        return getConclusionContainer().getForm().getInputDate("conclusion_date");
    }

    /**
     * Получение поля даты "Врачебная комиссия"
     * @return текстовое поле "Врачебная комиссия"
     */
    public Classifier getCommission()
    {
        return getConclusionContainer().getForm().getClassifier("medCommission");
    }

    /**
     * Получение кнопки "Закрыть карту"
     * @return кнопку "Закрыть карту"
     */
    public Button getCloseCardButton()
    {
        return getConclusionContainer().getButton("closeMigrCard");
    }

    /**
     * Получение кнопки "Сохранить"
     * @return кнопка "Сохранить"
     */
    public Button getSaveButton()
    {
        return getConclusionContainer().getButton(N2O_CONFIRM_BUTTON);
    }

}
