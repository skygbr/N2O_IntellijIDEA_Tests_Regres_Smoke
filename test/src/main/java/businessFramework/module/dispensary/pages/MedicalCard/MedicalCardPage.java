package businessFramework.module.dispensary.pages.MedicalCard;

import businessFramework.entities.dispensary.DispensaryData;
import businessFramework.module.dispensary.pages.executeExamination.ExecuteExaminationPage;
import net.framework.autotesting.ApplicationManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MedicalCardPage extends MedicalCardHelper
{
    public MedicalCardPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Проверяет данные на странице "Общие сведения"
     * @param dispensaryData необходимые данные.
     */
    public void checkGeneralInformationData(DispensaryData dispensaryData)
    {
        assertThat(getFIOValue(), equalTo(dispensaryData.getFioDriverCard()));
        assertThat(getGenderValue(), equalTo(dispensaryData.getGenderDriverCard()));
        assertThat(getBirthDateValue(), containsString(dispensaryData.getBirthDateDriverCard()));
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
     * Нажатие по вкладке "Результаты"
     */
    public void clickResultsTab()
    {
        getResultsTab().click();
    }

    /**
     * Удаление диагноза на вкладке "Результаты"
     */
    public void deleteDiagnosis()
    {
        getRefreshDiagnosisButton().click();
        getContainerDiagnosis().getTable().chooseRowInTable(0);
        getDeleteDiagnosisButton().click();
        getDialog().clickYes();
    }

    /**
     * Получение модального окна "Осмотр"
     * @return модальное окно "Осмотр"
     */
    public ExecuteExaminationPage getExecuteExaminationPage() {
        return new ExecuteExaminationPage(app);
    }
}
