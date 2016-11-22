package businessFramework.module.migrants.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Получение элементов на странице "Добавить пациента"
 */
public class AddPatientCardHelper extends Page implements Values
{
    public AddPatientCardHelper(ApplicationManager app)
    {
        super(app);
    }


    /**
     * Получение контейнера "Общие данные"
     * @return контейнер "Общие данные"
     */
    public Container getCommonDataContainer()
    {
        return getContainer("main");
    }


    /** ------------------------  Получение элементов, содержащих значения текстовых полей ----------------------------*/

    /**
     * Получение текстового поля surname. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле surname.
     */
    public WebElement getSurnameContainer()
    {
        return getCommonDataContainer().findElement(By.cssSelector("[data-field-id = 'surname']"));
    }

    /**
     * Получение текстового поля name. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле name.
     */
    public WebElement getNameContainer()
    {
        return getCommonDataContainer().findElement(By.cssSelector("[data-field-id = 'name']"));
    }

    /**
     * Получение текстового поля patrname. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле patrname.
     */
    public WebElement getPatrNameContainer()
    {
        return getCommonDataContainer().findElement(By.cssSelector("[data-field-id = 'patrname']"));
    }

    /**
     * Получение текстового поля birthday. Оно находится в элементе n2o-control-container, имеющим уникальное значение атрибута data-field-id
     * @return  текстовое поле birthday.
     */
    public WebElement getBirthDayContainer()
    {
        return getCommonDataContainer().findElement(By.cssSelector("[data-field-id = 'birthday']"));
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

        /* ------------------ Получение полей на форме ----------------- */

    /**
     * Получение поля "Фамилия"
     * @return поле "Фамилия"
     */
    public InputText getLatinSurnameField()
    {
        return getCommonDataContainer().getForm().getInputText("latinsurname");
    }

    /**
     * Получение поля "Имя"
     * @return поле "Имя"
     */
    public InputText getLatinNameField()
    {
        return getCommonDataContainer().getForm().getInputText("latinname");
    }

    /**
     * Получение поля "Отчество"
     * @return поле "Отчество"
     */
    public InputText getLatinPatrNameField()
    {
        return getCommonDataContainer().getForm().getInputText("latinpatrname");
    }

    /**
     * Получение поля "Прибыл из"
     * @return поле "Прибыл из"
     */
    public Classifier getArrivedCountryField()
    {
        return getCommonDataContainer().getForm().getClassifier("arrivedCountry");
    }

    /**
     * Получение поля "Цель получения справки"
     * @return поле "Цель получения справки"
     */
    public Classifier getPurposeField()
    {
        return getCommonDataContainer().getForm().getClassifier("purpose");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getCommonDataContainer().getButton(N2O_CONFIRM_BUTTON);
    }



    /* -------------------------- Контейнер "Услуги" ------------------------------ */

    /**
     * @return контейнер "Услуги"
     */
    public Container getServicesContainer()
    {
        return getContainer("services");
    }

    /**
     * Получение группы чекбоксов в контейнере "Услуги"
     * @return группу чекбоксов в контейнере "Услуги"
     */
    public InputCheckBox getServicesCheckBoxGroup()
    {
        return getServicesContainer().getForm().getInputCheckBox("services");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmServiceButton()
    {
        return getServicesContainer().getButton(N2O_CONFIRM_BUTTON);
    }



    /* -------------------------- Кнопки, не относящиеся к контейнерам ------------------------------ */

    /**
     * Получение кнопки "Назад"
     * @return кнопку "Назад"
     */
    public Button getBackButton()
    {
        return getButton(BACK);
    }
}
