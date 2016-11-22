package businessFramework.module.dispensary.pages.MedicalCard;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MedicalCardHelper extends Page implements Values
{
    public MedicalCardHelper(ApplicationManager app)
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

    // ---------------------------- Контейнер "Заключение" -------------------------- //

    public WebElement getResultsTab()
    {
        return findElement(By.xpath("//ul[@class='nav nav-tabs']/li/a[contains(text(), 'Результаты')]"));
    }

    /**
     * Возвращает контейнер "Диагнозы"
     * @return Контейнер "Диагнозы"
     */
    public Container getContainerDiagnosis()
    {
        return getRegion("rightresult").getContainer("dignosisData");
    }

    /**
     * Возвращает кнопку "Обновить"
     * @return Кнопка "Обновить"
     */
    public Button getRefreshDiagnosisButton()
    {
        return getContainerDiagnosis().getButton("menu_action-refresh");
    }

    /**
     * Возвращает кнопку "Удалить"
     * @return Кнопка "Удалить"
     */
    public Button getDeleteDiagnosisButton()
    {
        return getContainerDiagnosis().getButton(DELETE_BUTTON);
    }





    /**
     * Возвращает контейнер "Заключение"
     * @return Контейнер "Заключение"
     */
    public Container getContainerConclusion()
    {
        return getRegion(TOP).getContainer("conclusion");
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
     * Возвращает кнопку "Сохранить"
     * @return Кнопка "Сохранить"
     */
    public Button getSaveButton()
    {
        return getContainerConclusion().getButton(N2O_CONFIRM_BUTTON);
    }

}

