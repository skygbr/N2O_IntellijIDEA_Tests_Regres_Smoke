package businessFramework.module.gibddMedicalExamination.modals.population;

import businessFramework.entities.gibddMedicalExamination.GibddMedicalExaminationData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by bulat.garipov on 10.11.2016.
 */
public class PopulationModal extends PopulationHelper
{
    public PopulationModal(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Кнопка "Сохранить" в модальном окне
     */
    public void clickConfirm() {
        Button button = getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Кнопка "Отмена" в модальном окне
     */
    public void clickCancel() {
        Button button = getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Проверка текста заголовка модального окна на соответствие строке "Численность населения"
     * @param headerPopulationModal ожидаемый заголовок модального окна
     */
    public void checkModalHeader(String headerPopulationModal)
    {
        getPopulationModal().assertModalHeader_equal(headerPopulationModal);
    }

    /**
     * Проверяет наличие сообщения об успешном сохранении в контейнере "Численность населения"
     */
    public void checkPopulationModalSuccessMessage()
    {
        getPopulationModal().getAlerts().assertSuccessAlertIsPresent();
    }

    /**
     * Устанавливает значения в полях
     */
    public void setValuesToCreateFields(GibddMedicalExaminationData gPEditData)
    {
        getYear().setValue(gPEditData.getYear());
        getPopulationModal().getForm().selectCreateMore(true);
    }

    /**
     * Устанавливает значения в полях
     */
    public void setValuesToCreateDateAndMonthFields(GibddMedicalExaminationData gPDayAndMonthData)
    {
        getYear().setValue(gPDayAndMonthData.getYear());
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
     * Проверка системной валидации в модальном окне
     */
    public void assertPopulationYearValidationMessage() {
        String message = "На указанный год может быть только одна запись для МО    ";
        assertThat(message, isPresentModal(), is(true));
        getModal().getForm().getAlerts().assertErrorAlertMessage(message);
        System.out.println("Системная ошибка в модальном окне:\n" + message);
    }

}
