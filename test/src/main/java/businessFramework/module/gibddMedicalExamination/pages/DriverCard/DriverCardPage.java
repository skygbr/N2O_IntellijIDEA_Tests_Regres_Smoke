package businessFramework.module.gibddMedicalExamination.pages.DriverCard;


import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DriverCardPage extends DriverCardHelper
{
    public DriverCardPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверяет данные на странице "Общие сведения"
     * @param gmeData необходимые данные.
     */
    public void checkGeneralInformationData(GibddMedicalExaminationData gmeData)
    {
        assertThat(getFIOValue(), equalTo(gmeData.getFioDriverCard()));
        assertThat(getGenderValue(), equalTo(gmeData.getGenderDriverCard()));
        assertThat(getBirthDateValue(), equalTo(gmeData.getBirthDateDriverCard()));
        assertThat(getPassportValue(), equalTo(gmeData.getPassportDriverCard()));
    }

    /**
     * Выбирает запись в таблице по номеру строчки в контейнере "Осмотры и услуги"
     * @param rowNumber номер строчки в таблице
     */
    public void selectRecordInServiceTable(int rowNumber)
    {
        getServiceTable().chooseRowInTable(rowNumber);
    }

    /**
     * Нажимает кнопку "Оказать услугу"
     */
    public void clickInspecButton()
    {
        getInspecButton().click();
    }

    /**
     * Проверяет значение столбца "Заключение" для первой записи
     */
    public void checkConcludeTableValues(String expectedValue)
    {
        int activeRowNumber = getServiceTable().getChosenRowNumber();
        String valueToCheck = getServiceTable().getRowColumnIntersectionValue(activeRowNumber, "Заключение", true);
        assertThat(valueToCheck, equalTo(expectedValue));
    }

    /**
     * Нажимает кнопку "Очистить"
     */
    public void pressClearButton()
    {
        getClearButton().click();
    }

    /**
     * Проверяет, что последнее открытое модальное окно - предупреждающее после наждатия кнопки "Очистить"
     */
    public void checkAndApplyConfirmModal()
    {
        // Убедимся, что последнее открытое модальное окно - то, которое нам нужно.

        getDialog().assertGeneralMessageContainsText("Нажмите \"Да\" если Вы уверены в совершаемом действии. Или \"Нет\" если ещё хотите обдумать совершаемое действие.");
        getDialog().clickYes();
    }

    public void clickSaveButton()
    {
        Button save = getSaveButton();
        save.assertIsEnabled();
        save.click();
    }

    public void assertConclusion(GibddMedicalExaminationData gibddMedicalExaminationData)
    {
        getContainerConclusion().clickContainer();
        getSeriesReference().assertValue(gibddMedicalExaminationData.getAddPatientReferenceSeries());
        getNumberReference().assertValue(gibddMedicalExaminationData.getAddPatientReferenceNumber());
        getBeginDate().assertThatDateContainsValue(getCurrentDate());
        getEndDate().assertThatDateContainsValue(addDays(getCurrentDate(),730));
    }

    public void confirmConclusion()
    {
        getMedCommission().setValue(0);
        clickSaveButton();
        getContainerConclusion().getForm().getAlerts().assertSuccessAlertMessage("Данные сохранены");
    }
}
