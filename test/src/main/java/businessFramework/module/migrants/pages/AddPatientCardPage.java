package businessFramework.module.migrants.pages;

import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает страницу "Добавить пациента", которая открывается по нажатию кнопки "Создать новую" ( карточку ) на странице "Поиск пациента"
 */
public class AddPatientCardPage extends AddPatientCardHelper
{
    public AddPatientCardPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверяет значения текстовых полей на соответствие ожидаемым ( в контейнере "Общие значения" )
     *
     * @param surname   ожидаемое значение поля "Фамилия"
     * @param name      ожидаемое значение поля "Имя"
     * @param patrName  ожидаемое значение поля "Отчество"
     * @param birthDay  ожидаемое значение поля "Дата рождения"
     */
    public void checkCommonValues(String surname, String name, String patrName, String birthDay)
    {
        if (surname != null )   { assertThat(getSurnameValue(), equalTo(surname)); }
        if (name != null )      { assertThat(getNameValue(), equalTo(name)); }
        if (patrName != null )  { assertThat(getPatrNameValue(), equalTo(patrName)); }
        if (birthDay!= null )   { assertThat(getBirthDayValue(), equalTo(birthDay)); }
    }

    /**
     * Заполнение полей значениями. Можно заполнять выборочно поля, для этого передать null как параметр в случае, если поле заполнять на надо.
     *
     * @param latinSurname           Значение для поля "Фамилия на латин."
     * @param latinName              Значение для поля "Имя на латин."
     * @param latinPatrName          Значение для поля "Отчество на латин."
     */
    public void fillFieldsPatient(String latinSurname, String latinName, String latinPatrName)
    {
        if (latinSurname != null)        { getLatinSurnameField().setValue(latinSurname); }
        if (latinName != null)           { getLatinNameField().setValue(latinName); }
        if (latinPatrName != null)       { getLatinPatrNameField().setValue(latinPatrName); }
    }


    /**
     * Заполнение обязательных полей ("Прибыл из" и "Цель получения справки") на форме значениями
     */
    public List<String> fillRequiredFields()
    {
        List<String> values = new ArrayList<String>();

        getArrivedCountryField().setValue(0);
        getPurposeField().setValue(0);

        values.add(getArrivedCountryField().getValue());
        values.add(getPurposeField().getValue());

        return values;
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void clickConfirmCommonValuesButton()
    {
        getConfirmButton().click();
    }

    /* -------------------------- Контейнер "Услуги" ------------------------------ */

    /**
     * Отмечает услугу в контейнере "Услуги" в группе чекбоксов
     */
    public void selectServicesInServicesContainer()
    {
        getServicesCheckBoxGroup().check(0,true);
    }

    /**
     * Нажатие кнопки "Подтвердить"
     */
    public void clickConfirmServiceButton()
    {
        getConfirmServiceButton().click();
    }


    /* -------------------------- Кнопки, не относящиеся к контейнерам ------------------------------ */

    /**
     * Нажатие кнопки "Назад"
     */
    public void clickBackButton()
    {
        getBackButton().click();
    }
}

