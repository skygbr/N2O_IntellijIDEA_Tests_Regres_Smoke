package businessFramework.module.gibddMedicalExamination.pages.DriverCard;


import businessFramework.module.Values;
import businessFramework.module.gibddMedicalExamination.pages.doService.DoServicePage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriverCardHelper extends Page implements Values
{
    public DriverCardHelper(ApplicationManager app)
    {
        super(app);
    }

    //----------------------------- Контейнер "Общая информация" ------------------------------//

    /**
     * Возвращает контейнер "Общая информация"
     * @return контейнер "Общая информация"
     */
    public Container getGeneralInformationContainer()
    {
        return getRegion(TOP).getContainer("generalInformation");
    }

    /**
     * Возвращает текстовое значение "ФИО"
     * @return текстовое значение "ФИО"
     */
    public WebElement getFIO()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("div[data-field-id='fio']:not([style='display: none;'])"));
    }

    /**
     * Возвращает текстовое значение "Пол"
     * @return текстовое значение "Пол"
     */
    public WebElement getGender()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("div[data-field-id='gender.name']:not([style='display: none;'])"));
    }

    /**
     * Возвращает текстовое значение "Дата рождения"
     * @return текстовое значение "Дата рождения"
     */
    public WebElement getBirthDate()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("div[data-field-id='birthday']:not([style='display: none;'])"));
    }

    /**
     * Возвращает текстовое значение "Паспорт"
     * @return текстовое значение "Паспорт"
     */
    public WebElement getPassport()
    {
        return getGeneralInformationContainer().findElement(By.cssSelector("div[data-field-id='passport']:not([style='display: none;'])"));
    }

    /**
     * Возвращает значение текстового значения "ФИО"
     * @return значение текстового значения "ФИО"
     */
    public String getFIOValue()
    {
        return getFIO().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Возвращает значение текстового значения "Пол"
     * @return значение текстового значения "Пол"
     */
    public String getGenderValue()
    {
        return getGender().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Возвращает значение текстового значения "Дата рождения"
     * @return значение текстового значения "Дата рождения"
     */
    public String getBirthDateValue()
    {
        return getBirthDate().findElement(By.className("n2o-text-value")).getText();
    }

    /**
     * Возвращает значение текстового значения "Паспорт"
     * @return значение текстового значения "Паспорт"
     */
    public String getPassportValue()
    {
        return getPassport().findElement(By.className("n2o-text-value")).getText();
    }

    // ---------------------------- Контейнер "Осмотры и услуги" --------------------------------- //

    /**
     * Получает контейнер "Осмотры и услуги"
     * @return контейнер "Осмотры и услуги"
     */
    public Container getServiceDataContainer()
    {
        return getContainer("serviceData");
    }

    /**
     * Получает таблицу в контейнере "Осмотры и услуги"
     * @return таблицу в контейнере "Осмотры и услуги"
     */
    public Table getServiceTable()
    {
        return getServiceDataContainer().getTable();
    }

    /**
     * Получает кнопку "Оказать услугу"
     * @return кнопку "Оказать услугу"
     */
    public Button getInspecButton()
    {
        return getServiceDataContainer().getButton("inspec");
    }

    /**
     * Получает кнопку "Очистить"
     * @return кнопку "Очистить"
     */
    public Button getClearButton()
    {
        return getServiceDataContainer().getButton(CLEAR_SERVICE);
    }


    // ---------------------------- Контейнер "Заключение" -------------------------- //

    /**
     * Возвращает контейнер "Заключение"
     * @return Контейнер "Заключение"
     */
    public Container getContainerConclusion()
    {
        return getRegion(TOP).getContainer("conclusion");
    }

    /**
     * Возвращает текстовое поле "Серия справки:"
     * @return Текстовое поле "Серия справки:"
     */
    public InputText getSeriesReference()
    {
        return getContainerConclusion().getForm().getInputText("seriesReference");
    }

    /**
     * Возвращает текстовое поле "Номер справки:"
     * @return Текстовое поле "Номер справки:"
     */
    public InputText getNumberReference()
    {
        return getContainerConclusion().getForm().getInputText("numberReference");
    }

    /**
     * Возвращает поле даты "Дата выдачи:"
     * @return Поле даты "Дата выдачи:"
     */
    public InputDate getBeginDate()
    {
        return getContainerConclusion().getForm().getInputDate("issued");
    }

    /**
     * Возвращает поле даты "Годна до:"
     * @return Поле даты "Годна до:"
     */
    public InputDate getEndDate()
    {
        return getContainerConclusion().getForm().getInputDate("exp");
    }

    /**
     * Возвращает классификатор "Врачебная комиссия"
     * @return Классификатор "Врачебная комиссия"
     */
    public Classifier getMedCommission()
    {
        return getContainerConclusion().getForm().getClassifier("medCommission");
    }

    /**
     * Возвращает кнопку "Сохранить"
     * @return Кнопка "Сохранить"
     */
    public Button getSaveButton()
    {
        return getContainerConclusion().getButton(N2O_CONFIRM_BUTTON);
    }

        //---------------------- Модальное окно "Оказание услуги" -----------------------------//

    /**
     * Получение модального окна "Оказание услуги".
     * Получаем через класс DriverCardHelper, тк окно открывается со страницы "Карточка".
     *
     * @return модальное окно "Оказание услуги".
     */
    public DoServicePage getDoServicePage()
    {
        return new DoServicePage(app);
    }
}
