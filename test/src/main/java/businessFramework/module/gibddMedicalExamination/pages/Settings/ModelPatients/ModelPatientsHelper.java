package businessFramework.module.gibddMedicalExamination.pages.Settings.ModelPatients;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class ModelPatientsHelper extends Page implements Values
{

    public ModelPatientsHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение контейнера Список моделей пациента на странице
     * @return контейнер Список
     */
    public Container getModelsTableContainer()
    {
        return getRegion(LEFT).getContainer("models");
    }

    /**
     * Получение контейнера Модель пациента на странице
     * @return контейнер Модель пациента населения
     */
    public Container getModelContainer()
    {
        return getRegion(RIGHT).getContainer("model");
    }

    /**
     * Получение контейнера Пол и возраст на странице
     * @return контейнер Пол и возраст пациента
     */
    public Container getModelPatientBaseContainer()
    {
        return getRegion(RIGHT).getContainer("modelPatientBase");
    }


    /**
     * Получение контейнера Льготы на странице
     * @return контейнер Льготы
     */
    public Container getModelPatientBenefitContainer()
    {
        return getRegion(RIGHT).getContainer("modelPatientBenefit");
    }

    /**
     * Получение контейнера Д-учет на странице
     * @return контейнер Д-учет
     */
    public Container getModelPatientDContainer()
    {
        return getRegion(RIGHT).getContainer("modelPatientD");
    }

    /**
     * Получение контейнера Категория ТС на странице
     * @return контейнер Категория ТС
     */
    public Container getModelPatientDriverLicenceContainer()
    {
        return getRegion(RIGHT).getContainer("modelPatientDriverLicence");
    }

    /*--------------------------------- Фильтр контейнера 'Список моделей пациента' ----------------------------------*/
    /**
     * Получает фильтр в контейнере "Список моделей пациента"
     * @return фильтр в контейнере "Список моделей пациента"
     */
    public Filter getModelsFilter()
    {
        return getModelsTableContainer().getFilter();
    }

    /**
     * Получение текстового поля "Наименование"
     * @return текстовое поле "Наименование"
     */
    public InputText getName()
    {
        return getModelsFilter().getInputText("name");
    }

    /**
     * Получение группы чекбоксов "Пол"
     * @return группу чекбоксов "Пол"
     */
    public Radio getGenderFilterRadio()
    {
        return getModelsFilter().getRadio("genderFilter");
    }

    /**
     * Получение текстового поля "Возраст"
     * @return текстовое поле "Возраст"
     */
    public InputText getAge()
    {
        return getModelsFilter().getInputText("age");
    }

    /**
     * Получает группу радиокнопок base_model.
     * Надо получить конкретную радиокнопку и нажать ее - через этот метод путем вызова метода radioButtonPress
     * @return  группу радиокнопок base_model.
     */
    public Radio getModelRadio()
    {
        return getModelsFilter().getRadio("base_model");
    }


    /*------------------------------------- Контейнер 'Список моделей пациента' --------------------------------------*/
    /**
     * Получение кнопки "Создать"
     * @return кнопка "Создать"
     */
    public Button getCreateModelsButton()
    {
        return getModelsTableContainer().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Копировать"
     * @return кнопка "Копировать"
     */
    public Button getCopyModelsButton()
    {
        return getModelsTableContainer().getButton(COPY_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeleteModelsButton()
    {
        return getModelsTableContainer().getButton(DELETE_BUTTON);
    }

    /**
     * @return таблицу в контейнере "Случаи"
     */
    public Table getModelsTable()
    {
        return getModelsTableContainer().getTable();
    }

    /**
     * Получение состояния чекбокса в строке row в столбце номер columnNumber
     *
     * @param row           - порядковый номер строки
     * @param columnNumber  - номер - номер столбца, в котором чекбокс.
     * @param isActive      - учитывать ли активную строку
     *
     * @return true, если чекбокс отмечен, false - иначе.
     */
    public boolean isCheckboxInRowChecked(Table table, int row, int columnNumber, boolean isActive) {

        if (getCheckboxInRow(table, row, columnNumber, isActive).getAttribute("checked") == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @param columnNumber - - номер столбца, в котором чекбокс.
     * @return все значения столбца
     */
    public List<WebElement> getRowsInColumn(Table table, int columnNumber, boolean withActiveRow) {
        List<WebElement> list = new ArrayList<>();

        for (WebElement element : table.getRowsInTable(withActiveRow)) {
            list.add(findElements(By.cssSelector(" td:not([class*='n2o-table_multi-select-column'])"), element).get(columnNumber));
        }
        return list;
    }

    public WebElement getCheckboxInRow(Table table, int row, int columnNumber, Boolean isActive) {
        return getRowsInColumn(table, columnNumber, isActive).get(row).findElement(By.cssSelector("input[type='checkbox']"));
    }

    /*-------------------------------------- Контейнер 'Модель пациента' ---------------------------------------------*/
    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateModelButton()
    {
        return getModelContainer().getButton(UPDATE_BUTTON);
    }


    /*--------------------------------------- Контейнер 'Пол и возраст' ----------------------------------------------*/
    /**
     * Получение кнопки "Добавить"
     * @return кнопка "Добавить"
     */
    public Button getCreateModelPatientBaseButton()
    {
        return getModelPatientBaseContainer().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateModelPatientBaseButton()
    {
        return getModelPatientBaseContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeleteModelPatientBaseButton()
    {
        return getModelPatientBaseContainer().getButton(DELETE_BUTTON);
    }


     /*------------------------------------------ Контейнер 'Льготы' -------------------------------------------------*/
    /**
     * Получение кнопки "Добавить"
     * @return кнопка "Добавить"
     */
    public Button getCreateModelPatientBenefitButton()
    {
        return getModelPatientBenefitContainer().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateModelPatientBenefitButton()
    {
        return getModelPatientBenefitContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeleteModelPatientBenefitButton()
    {
        return getModelPatientBaseContainer().getButton(DELETE_BUTTON);
    }

     /*----------------------------------------- Контейнер 'Д-учет' -------------------------------------------------*/
    /**
     * Получение кнопки "Добавить"
     * @return кнопка "Добавить"
     */
    public Button getCreateModelPatientDButton()
    {
        return getModelPatientDContainer().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateModelPatientDButton()
    {
        return getModelPatientDContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeleteModelPatientDButton()
    {
        return getModelPatientDContainer().getButton(DELETE_BUTTON);
    }

    /*----------------------------------------- Контейнер 'Категория ТС' --------------------------------------------*/
    /**
     * Получение кнопки "Добавить"
     * @return кнопка "Добавить"
     */
    public Button getCreateModelPatientDriverLicenceButton()
    {
        return getModelPatientDriverLicenceContainer().getButton(ADD_BUTTON);
    }

    /**
     * Получение кнопки "Изменить"
     * @return кнопка "Изменить"
     */
    public Button getUpdateModelPatientDriverLicenceButton()
    {
        return getModelPatientDriverLicenceContainer().getButton(UPDATE_BUTTON);
    }

    /**
     * Получение кнопки "Удалить"
     * @return кнопка "Удалить"
     */
    public Button getDeleteModelPatientDriverLicenceButton()
    {
        return getModelPatientDriverLicenceContainer().getButton(DELETE_BUTTON);
    }


}
