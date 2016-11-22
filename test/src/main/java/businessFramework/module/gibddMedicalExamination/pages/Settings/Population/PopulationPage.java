package businessFramework.module.gibddMedicalExamination.pages.Settings.Population;

import businessFramework.module.gibddMedicalExamination.pages.Settings.Population.PopulationHelper;
import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import businessFramework.module.gibddMedicalExamination.modals.population.PopulationModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.Tree;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.InputText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by bulat.garipov on 08.11.2016.
 */
public class PopulationPage extends PopulationHelper {

    private Page page = Page.getInstance();

    public PopulationPage(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение модального окна "Численность населения"
     * @return модальное окно "Численность населения"
     */
    public PopulationModal getPopulationModal()
    {
        return new PopulationModal(app);
    }

    /**
     * Получение списка из контейнера таблицы tree
     * @return списка из контейнера tree
     */
    public Table getPopulationNameTable()
    {
        return getContainerListPopulationName().getTable(); }

    /* -------------------------- Контейнер "Список" ------------------------- */
    /**
     * Получение и нажатие кнопки 'Создать'
     */
    public void pressCreatePopulationButton()
    {
        getCreatePopulationButton().click();
    }

    /**
     * Получение и нажатие кнопки 'Удалить'
     */
    public void pressDeletePopulationButton()
    {
        getDeletePopulationButton().click();
    }

    /**
     * Удаление из таблицы в списке ЧН созданных записей
     */
    public void deleteAllCreateListPopulation() {
        Table populationNameTable = getPopulationNameTable();

        int countOfRecords = populationNameTable.getCountRowsInTable(true);

        for (int i = 0; i < countOfRecords; i++) {
            populationNameTable.chooseRowInTable(0);// нажать на строчку в таблице услуг
            if (getContainerListPopulationName().getTable().getCountRowsInTable(true) > 1)
            {
                getDeletePopulationButton().click();
                getConfirmModalAfterDeleteListPopulationName().getButton(CONFIRM_BUTTON).click(); // Нажать кнопку "Да" в подтверждающем удаление модальном окне.
            }
        }
        getContainerListPopulationName().clickDropdownToggle("Обновить");
        getContainerListPopulationName().getTable().assertThatTableContainsOnlyXRows(1);
    }

    /**
     * Формат времени текущий год 1-й вариант (использовать)
     */
    public String getFormattedDateYear() {
        DateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(new Date());
    }

    /**
     * Формат времени текущий год 2-й вариант (дополнительный)
     */
    public String getFormattedDateStringYear(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(date);
    }
    String dateStringYear = getFormattedDateStringYear(new Date());

    /**
     * Получение в контейнере записи "ОДОДСГ,2016"
     */
    public void choosePopulationName()
    {
        getPopulationNameTable().chooseRowInTableByColumnValue("МО, год","ОДОДСГ," + getFormattedDateYear());
    }

    /**
     * Формат времени будущий год
     */
    public String getFormattedDateNextYear()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        return formatter.format(calendar.getTime());
    }

    /**
     * Формат времени текущая дата + 5 лет
     */
    public String getFormattedDate20XXYear()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 5);
        return formatter.format(calendar.getTime());
    }

    /**
     * Формат времени + 5 лет
     */
    public String getFormattedDate20XX()
    {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 5);
        return formatter.format(calendar.getTime());
    }

    /**
     * Получение в контейнере записи "ОДОДСГ,20XX" + 5 лет
     */
    public void choosePopulation20XXYearName()
    {
        getPopulationNameTable().chooseRowInTableByColumnValue("МО, год","ОДОДСГ," + getFormattedDate20XXYear());
    }

    /**
     * Получение в контейнере записи "ОДОДСГ,2017"
     */
    public void chooseNewPopulationName()
    {
        getPopulationNameTable().chooseRowInTableByColumnValue("МО, год","ОДОДСГ," + getFormattedDateNextYear());
    }

    /* ------------------------ Контейнер "Численность населения" ----------------------- */

    /**
     * Получение и нажатие кнопки Редактировать
     */
    public void pressUpdatePopulationButton()
    {
        getUpdatePopulationButton().click();
    }

    /**
     * Кнопка "Сохранить"
     */
    public void clickConfirm() {
        Button button = getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Кнопка "Отмена"
     */
    public void clickCancel() {
        Button button = getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Устанавливает значения в полях
     */
    public void setValuesToFields(GibddMedicalExaminationData gPEditData)
    {
        getYear().setValue(gPEditData.getYear());
        getM21_36Begin().setValue(gPEditData.getM21_36Begin());
        getM39_60Begin().setValue(gPEditData.getM39_60Begin());
        getM60Begin().setValue(gPEditData.getM60Begin());
        getF21_36Begin().setValue(gPEditData.getF21_36Begin());
        getF39_60Begin().setValue(gPEditData.getF39_60Begin());
        getF60Begin().setValue(gPEditData.getF60Begin());
        getM21_36Disp().setValue(gPEditData.getM21_36Disp());
        getM39_60Disp().setValue(gPEditData.getM39_60Disp());
        getM60Disp().setValue(gPEditData.getM60Disp());
        getF21_36Disp().setValue(gPEditData.getF21_36Disp());
        getF39_60Disp().setValue(gPEditData.getF39_60Disp());
        getF60Disp().setValue(gPEditData.getF60Disp());
        getCh0_4Disp().setValue(gPEditData.getCh0_4Disp());
        getCh5_9Disp().setValue(gPEditData.getCh5_9Disp());
        getCh10_14Disp().setValue(gPEditData.getCh10_14Disp());
        getCh15_17Disp().setValue(gPEditData.getCh15_17Disp());
    }

    /**
     * Устанавливает значения в полях
     */
    public void setValuesToAlertFields(GibddMedicalExaminationData gPEditData)
    {
        getYear().setValue(gPEditData.getYear());
    }

    /**
     * Сравнивает данные в полях контейнера "Численность населения"
     */
    public void checkFieldsDateAndMonthData(String year)
    {
        if (year != null) { getYear().assertValue_equals(year);
        }
    }

    /**
     * Сравнивает данные в полях контейнера "Численность населения"
     */
    public void checkFieldsData(String orgName, String year, String m21_36Begin, String m39_60Begin, String m60Begin,
                                String f21_36Begin, String f39_60Begin, String f60Begin, String m21_36Disp,
                                String m39_60Disp, String m60Disp, String f21_36Disp, String f39_60Disp, String f60Disp,
                                String ch0_4Disp, String ch5_9Disp, String ch10_14Disp, String ch15_17Disp)
    {
        if ( orgName != null)     { getOrgName().assertValue(orgName); }
        if ( year != null)        { getYear().assertValue_equals(year); }
        if ( m21_36Begin != null) { getM21_36Begin().assertValue(m21_36Begin); }
        if ( m39_60Begin != null) { getM39_60Begin().assertValue(m39_60Begin); }
        if ( m60Begin != null)    { getM60Begin().assertValue(m60Begin); }
        if ( f21_36Begin != null) { getF21_36Begin().assertValue(f21_36Begin); }
        if ( f39_60Begin != null) { getF39_60Begin().assertValue(f39_60Begin); }
        if ( f60Begin != null)    { getF60Begin().assertValue(f60Begin); }
        if ( m21_36Disp != null)  { getM21_36Disp().assertValue(m21_36Disp); }
        if ( m39_60Disp != null)  { getM39_60Disp().assertValue(m39_60Disp); }
        if ( m60Disp != null)     { getM60Disp().assertValue(m60Disp); }
        if ( f21_36Disp != null)  { getF21_36Disp().assertValue(f21_36Disp); }
        if ( f39_60Disp != null)  { getF39_60Disp().assertValue(f39_60Disp); }
        if ( f60Disp != null)     { getF60Disp().assertValue(f60Disp); }
        if ( ch0_4Disp != null)   { getCh0_4Disp().assertValue(ch0_4Disp); }
        if ( ch5_9Disp != null)   { getCh5_9Disp().assertValue(ch5_9Disp); }
        if ( ch10_14Disp != null) { getCh10_14Disp().assertValue(ch10_14Disp); }
        if ( ch15_17Disp != null) { getCh15_17Disp().assertValue(ch15_17Disp); }
    }

    /**
     * Проверка системной валидации контейнера "Численность населения"
     */
    public void assertPopulationYearContValidationMessage() {
        String message = "На указанный год может быть только одна запись для МО    ";
        page.getAlerts().assertErrorAlertMessage(message);
        System.out.println("Системная ошибка:\n" + message);
    }


}
