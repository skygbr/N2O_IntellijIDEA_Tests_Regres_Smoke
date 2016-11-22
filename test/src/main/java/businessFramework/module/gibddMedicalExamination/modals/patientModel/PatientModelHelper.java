package businessFramework.module.gibddMedicalExamination.modals.patientModel;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PatientModelHelper extends Page implements Values
{

    private Page page = Page.getInstance();

    public PatientModelHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return модальное окно "Модель пациента"
     */
    public Modal getPatientModelModal()
    {
        return page.getModal(); // (получает последнее активное модальное окно)
    }

    /**
     * Получение контейнера в модальном окне "Модель пациента"
     * @return контейнер main
     */
    public Container getPatientModelContainer()
    {
        return getPatientModelModal().getContainer("main");
    }

    /**
     * Получение формы в модальном окне "Модель пациента"
     * @return форму в модальном окне "Модель пациента"
     */
    public Form getPatientModelForm()
    {
        return getPatientModelContainer().getForm();
    }

    /**
     * Получение текстового поля "Наименование"
     * @return текстовое поле "Наименование"
     */
    public InputText getName()
    {
        return getPatientModelContainer().getForm().getInputText("name");
    }

    /**
     * Получение компонента Исполняется в год мероприятия
     * @return компонента Исполняется в год мероприятия
     */
    public WebElement getCalendar()
    {
        return findElement(By.cssSelector("div.well.popup"));
    }

    /**
     * Получение текстовой надписи af-popup-result
     * @return текстовую надпись af-popup-result
     */
    public WebElement getPopupResult()
    {
        return findElement(By.cssSelector(".af-popup-result"), getCalendar());
    }

    /**
     * Получение af-result текстового поля
     * @return af-result текстовое поле
     */
    public WebElement getAfResult()
    {
        return findElement(By.cssSelector("input.af-result"));
    }

    /**
     * Получение поля af-start-date (с)
     * @return поле af-start-date
     */
    public WebElement getStartDate()
    {
        return findElement(By.cssSelector(".af-start-date"), getCalendar());
    }

    /**
     * Получение поля af-end-date (по)
     * @return поле af-end-date
     */
    public WebElement getEndDate()
    {
        return findElement(By.cssSelector(".af-end-date"), getCalendar());
    }

    /**
     * Получение поля af-int-date (через)
     * @return поле af-int-date
     */
    public WebElement getIntDate()
    {
        return findElement(By.cssSelector(".af-int-date"), getCalendar());
    }

    /**
     * Получение кнопки af-add-new (+(Добавить))
     * @return кнопку af-add-new
     */
    public WebElement getAddNewButton()
    {
        return findElement(By.cssSelector(".af-add-new"), getCalendar());
    }

    /**
     * Получение селекта af-type-date (лет, месяцев)
     * @return селект af-type-date
     */
    public WebElement getTypeDateSelect()
    {
        return findElement(By.cssSelector(".af-type-date"), getCalendar());
    }

    /**
     * Получение options у селекта af-type-date (Выбор 'Лет' или 'Месяцев')
     * @return options у селекта af-type-date
     */
    public List<WebElement> getOptions()
    {
        return findElements(By.cssSelector("option"), getTypeDateSelect());
    }

    /**
     * Получение формы af-manual-added-form (Задать вручную)
     * @return форму af-manual-added-form
     */
    public WebElement getFormManualAdd()
    {
        return findElement(By.cssSelector(".af-manual-added-form"), getCalendar());
    }

    /**
     * Получение поля af-manual-y-date (задать лет)
     * @return поле af-manual-y-date
     */
    public WebElement getManualYDate()
    {
        return findElement(By.cssSelector(".af-manual-y-date"), getCalendar());
    }

    /**
     * Получение поля af-manual-m-date (задать месяцев)
     * @return поле af-manual-m-date
     */
    public WebElement getManualMDate()
    {
        return findElement(By.cssSelector(".af-manual-m-date"), getCalendar());
    }

    /**
     * Получение кнопки af-add-manual (+(Добавить))
     * @return кнопку af-add-manual
     */
    public WebElement getAddManualButton()
    {
        return findElement(By.cssSelector(".af-add-manual"), getCalendar());
    }

    /**
     * Получение группы чекбоксов "Пол"
     * @return группу чекбоксов "Пол"
     */
    public InputCheckBox getCheckboxesGenderGroup()
    {
        return getPatientModelContainer().getForm().getInputCheckBox("gender");
    }

    /**
     * Получение поля "Социальное положение"
     * @return поле "Социальное положение"
     */
    public Classifier getSocial()
    {
        return getPatientModelContainer().getForm().getClassifier("socGroup");
    }

    /**
     * Получение группы чекбоксов "Пол"
     * @return группу чекбоксов "Пол"
     */
    public Radio getGenderRadio()
    {
        return getPatientModelContainer().getForm().getRadio("base_model");
    }

    /**
     * Получение группы чекбоксов "Категория ТС"
     * @return группу чекбоксов "Категория ТС"
     */
    public InputCheckBox getCheckboxesLicenceCategory()
    {
        return getPatientModelContainer().getForm().getInputCheckBox("licence");
    }

    /**
     * Получение кнопки "Подтвердить"
     * @return кнопку "Подтвердить"
     */
    public Button getConfirmButton()
    {
        return getPatientModelContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    /**
     * Получение кнопки "Отмена"
     * @return кнопку "Отмена"
     */
    public Button getCancelButton()
    {
        return getPatientModelContainer().getButton(N2O_CANCEL_BUTTON);
    }
}
