package businessFramework.module.gibddMedicalExamination.pages.Settings.ModelPatients;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.entities.phthisiatry.MCaseData;
import businessFramework.module.gibddMedicalExamination.pages.Settings.ModelPatients.ModelPatientsHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import businessFramework.module.gibddMedicalExamination.modals.patientModel.PatientModelModal;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class ModelPatientsPage extends ModelPatientsHelper {

    public ModelPatientsPage(ApplicationManager app) {
        super(app);
    }

    public int row = 0;

    /**
     * Получение модального окна "Модель пациента"
     * @return модальное окно "Модель пациента"
     */
    public PatientModelModal getPatientModelModal()
    {
        return new PatientModelModal(app);
    }

    /**
     * Удаление из таблицы записей списка моделей пациента
     */
    public void deleteAllModels(GibddMedicalExaminationData gMPData) {
        this.openFilterModels();
        getName().setValue(gMPData.getSearchPatientModelName());
        this.filterButtonSearch();

        Table table = this.getModelsTable();

        while (table.getCountRowsInTable(true) > 0) {
            int size = table.getCountRowsInTable(true);
            table.chooseRowInTable(0);
            this.pressDeleteModelsButton();
            table = this.getModelsTable();
            assertThat("Rows doesn't delete from table", size,
                    not(table.getCountRowsInTable(true)));
        }
        getModelsTableContainer().clickDropdownToggle("Обновить");
    }

    /*--------------------------------- Фильтр контейнера 'Список моделей пациента' ----------------------------------*/

    /**
     * Открывает фильтр в контейнере "Случаи"
     */
    public void openFilterModels()
    {
        getModelsTableContainer().showFilter();
    }
    /**
     * Заполнение в фильтре текстового поля "Наименование"
     * @return Заполнение в фильтре текстового поля "Наименование"
     */
    public void filterName(GibddMedicalExaminationData gMPData)
    {
        this.openFilterModels();
        getName().setValue(gMPData.getSearchPatientModelName());
        this.filterButtonSearch();
    }

    /**
     * Получение в фильтре кнопки "Найти"
     * @return кнопку "Найти"
     */
    public void filterButtonSearch()
    {
        getModelsFilter().clickFindButton();
    }

    /**
     * Получение в фильтре кнопки "Очистить"
     * @return кнопку "Очистить"
     */
    public void filterButtonClear()
    {
        getModelsFilter().clickClearButton();
    }


     /* ----------------------------------- Контейнер "Список моделей пациента" ------------------------------------- */
    /**
     * Получение и нажатие кнопки 'Создать'
     */
    public void pressCreateModelsButton()
    {
        getCreateModelsButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Копировать'
     */
    public void pressCopyModelsButton()
    {
        getCopyModelsButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeleteModelsButton()
    {
        Button deleteModels = getDeleteModelsButton();
        deleteModels.assertIsEnabled();
        deleteModels.click();
        getDialog().getButton(CONFIRM_BUTTON).click();
    }

    /**
     * Проверяет, что в таблице "Список моделей пациента" отобразилась запись с необходимыми значениями
     *
     * @param nameValue значение в стоблце "Наименование"
     * @param genderValue значение в столбце "Пол"
     * @param ageValue значение в столбце "Возраст"

     */
    public int checkRecordBaseModelsTable(String nameValue, String genderValue, String ageValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (nameValue != null)  { columnsAndValues.put(NAME_MODEL_PATIENT, nameValue); }
        if (genderValue != null) { columnsAndValues.put(GENDER_MODEL_PATIENT, genderValue); }
        if (ageValue != null) { columnsAndValues.put(AGE_MODEL_PATIENT, ageValue); }

        row = getModelsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        getModelsTable().assertThatCheckboxInRowChecked(row, "Базовая", true, true);
        return row;
    }

    /**
     * Проверяет, что в таблице "Список моделей пациента" отобразилась запись с необходимыми значениями
     *
     * @param nameValue значение в стоблце "Наименование"
     * @param genderValue значение в столбце "Пол"
     * @param ageValue значение в столбце "Возраст"

     */
    public int checkRecordAdditionalModelsTable(String nameValue, String genderValue, String ageValue)
    {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (nameValue != null)  { columnsAndValues.put(NAME_MODEL_PATIENT, nameValue); }
        if (genderValue != null) { columnsAndValues.put(GENDER_MODEL_PATIENT, genderValue); }
        if (ageValue != null) { columnsAndValues.put(AGE_MODEL_PATIENT, ageValue); }

        row = getModelsTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
        getModelsTable().assertThatCheckboxInRowChecked(row, "Базовая", true, false);
        return row;
    }

    /*-------------------------------------- Контейнер 'Модель пациента' ---------------------------------------------*/
    /**
     * Получение и нажатие кнопки 'Изменить'
     */
    public void pressUpdateModelButton()
    {
        getUpdateModelButton().click();
    }


    /*--------------------------------------- Контейнер 'Пол и возраст' ----------------------------------------------*/
    /**
     * Получение и нажатие кнопки 'Добавить'
     */
    public void pressCreateModelPatientBaseButton()
    {
        getCreateModelPatientBaseButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Изменить'
     */
    public void pressUpdateModelPatientBaseButton()
    {
        getUpdateModelPatientBaseButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeleteModelPatientBaseButton()
    {
        getDeleteModelPatientBaseButton().click();
    }


     /*------------------------------------------ Контейнер 'Льготы' -------------------------------------------------*/
    /**
     * Получение и нажатие кнопки 'Добавить'
     */
    public void pressCreateModelPatientBenefitButton()
    {
        getCreateModelPatientBenefitButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Изменить'
     */
    public void pressUpdateModelPatientBenefitButton()
    {
        getUpdateModelPatientBenefitButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeleteModelPatientBenefitButton()
    {
        getDeleteModelPatientBenefitButton().click();
    }


     /*----------------------------------------- Контейнер 'Д-учет' --------------------------------------------------*/
    /**
     * Получение и нажатие кнопки 'Добавить'
     */
    public void pressCreateModelPatientDButton()
    {
        getCreateModelPatientDButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Изменить'
     */
    public void pressUpdateModelPatientDButton()
    {
        getUpdateModelPatientDButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeleteModelPatientDButton()
    {
        getDeleteModelPatientDButton().click();
    }


    /*----------------------------------------- Контейнер 'Категория ТС' ---------------------------------------------*/
    /**
     * Получение и нажатие кнопки 'Добавить'
     */
    public void pressCreateModelPatientDriverLicenceButton()
    {
        getCreateModelPatientDriverLicenceButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Изменить'
     */
    public void pressUpdateModelPatientDriverLicenceButton()
    {
        getUpdateModelPatientDriverLicenceButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeleteModelPatientDriverLicenceButton()
    {
        getDeleteModelPatientDriverLicenceButton().click();
    }



}
