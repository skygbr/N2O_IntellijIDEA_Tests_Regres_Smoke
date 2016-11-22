package businessFramework.module.hospital.modals.movingDepartment;


import businessFramework.entities.hospital.HospitalData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.components.Button;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovingDepartmentModal implements Values
{
    private MovingDepartmentHelper movingDepartmentHelper;

    public MovingDepartmentModal()
    {
        movingDepartmentHelper = new MovingDepartmentHelper();
    }

    /**
     * Сохранение формы движения по отделениям
     */
    public void clickConfirmButton()
    {
        Button confirm = movingDepartmentHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    /**
     * Проверка текущей даты на форме

     */
    public void assertAdmissionDate(String date)
    {
        movingDepartmentHelper.getAdmissionDate().assertThatDateContainsValueWithDeviation(date, 1);
    }

    /**
     * Направление в отделение
     */
    public void fillSendToDepartmentForm(HospitalData hospitalData)
    {
        movingDepartmentHelper.getPatientOutputText().assertFieldText(hospitalData.getPatient());
        movingDepartmentHelper.getUid().clickLink("Заполнить");
        movingDepartmentHelper.getDepartment().setValue(hospitalData.getDepartment());
        movingDepartmentHelper.getFinancialTypeOutputText().assertFieldText(hospitalData.getFinancialType());
        movingDepartmentHelper.getProfile().setValue(hospitalData.getProfile());
        movingDepartmentHelper.getCareRegimen().setValue(hospitalData.getCareRegimen());
        assertThat("Uid is empty", movingDepartmentHelper.getUid().getValue().matches("\\d+"), is(true));
        movingDepartmentHelper.getUid().setValue("199");

        movingDepartmentHelper.getSickListIssueDate().assertIsHidden(true);
        movingDepartmentHelper.getSickListNumber().assertIsHidden(true);

        movingDepartmentHelper.getNeedSickList().check(hospitalData.getNeedSickList());
        movingDepartmentHelper.getHasSickList().check(hospitalData.getHasSickList());

        movingDepartmentHelper.getSickListIssueDate().assertIsHidden(false);
        movingDepartmentHelper.getSickListNumber().assertIsHidden(false);

        movingDepartmentHelper.getSickListIssueDate().setValue(hospitalData.getSickListIssueDate());
        movingDepartmentHelper.getSickListNumber().setValue(hospitalData.getSickListNumber());
    }

    /**
     * Проферка формы текущего отделения
     */
    public void assertCurrentDepartment(HospitalData hospitalData)
    {
        movingDepartmentHelper.getAdmissionDate().assertThatDateContainsValue(hospitalData.getAdmissionDate());
        movingDepartmentHelper.getAdmissionDepartment().assertValue_contains(hospitalData.getAdmissionDepartment());
        movingDepartmentHelper.getProfile().assertValue_contains(hospitalData.getProfile());
        movingDepartmentHelper.getCareRegimen().assertValue_contains(hospitalData.getCareRegimen());
//        movingDepartmentHelper.getDoctor().assertValue_contains(hospitalData.getDoctor());
        movingDepartmentHelper.getBedProfile().assertValue_contains(hospitalData.getBedProfile());
        movingDepartmentHelper.getFinancialType().setValue(hospitalData.getNextFinancialType());
//        movingDepartmentHelper.getDiagnosisTree().searchValue(hospitalData.getDiagnosisCode());
    }

    /**
     * Направление из одного отделения в другое
     */
    public void fillNextDepartment(HospitalData hospitalData)
    {
        movingDepartmentHelper.getOutcomeDate().setValue(hospitalData.getOutcomeDate());
        movingDepartmentHelper.getStepResult().setValue(hospitalData.getStepResult());
        movingDepartmentHelper.getOutcome().setValue(hospitalData.getOutcome());
        movingDepartmentHelper.getNextDepartment().setValue(hospitalData.getNextDepartment());
        movingDepartmentHelper.getNextProfile().setValue(hospitalData.getNextProfile());
        movingDepartmentHelper.getNextBedProfile().setValue(hospitalData.getNextBedProfile());
        movingDepartmentHelper.getNextCareRegiment().setValue(hospitalData.getNextCareRegiment());
        movingDepartmentHelper.getNextFinancialType().setValue(hospitalData.getNextFinancialType());
//        movingDepartmentHelper.getCareRegimen().setValue(hospitalData.getCareRegimen());
//        movingDepartmentHelper.getFinancialType().setValue(hospitalData.getFinancialType());
//        movingDepartmentHelper.getDiagnosisTree().searchValue(hospitalData.getDiagnosisCode());
    }

    /**
     * Заполнение "Стандарты"
     * @param hospitalData
     */
    public void fillStandards(HospitalData hospitalData) {

        movingDepartmentHelper.getComplexityLevel().setValue(hospitalData.getComplexityLevel());
        movingDepartmentHelper.getDeviationReason().setValue(hospitalData.getDeviationReason());
    }

    public void fillOutcomeDate(HospitalData hospitalData)
    {
        movingDepartmentHelper.getOutcomeDate().setValue(hospitalData.getOutcomeDate());
    }

    /**
     * Заполнение формы движения по отделениям в Статистической карте
     */
    public void fillStatisticSendToDepartment(HospitalData hospitalData)
    {
        movingDepartmentHelper.getStepDepartment().setValue(hospitalData.getStepDepartment());
        movingDepartmentHelper.getProfile().setValue(hospitalData.getProfile());
        movingDepartmentHelper.getCareRegimen().setValue(hospitalData.getCareRegimen());
        movingDepartmentHelper.getBedProfile().setValue(hospitalData.getBedProfile());
        movingDepartmentHelper.getFinancialType().setValue(hospitalData.getFinancialType());
        movingDepartmentHelper.getStepResult().setValue(hospitalData.getStepResult());
        movingDepartmentHelper.getOutcome().setValue(hospitalData.getOutcome());
        movingDepartmentHelper.getDiagnosis().setValue(hospitalData.getDiagnosis());

        movingDepartmentHelper.getFinalDiagnosis().assertIsHidden(false);
        movingDepartmentHelper.getFinalDiagnosis().assertValue_contains(hospitalData.getDiagnosis());
    }

    /**
     * Проверка формы движения по отделениям в Статистической карте
     */
    public void assertStatisticSendToDepartment(HospitalData hospitalData)
    {
        movingDepartmentHelper.getStepDepartment().assertValue_contains(hospitalData.getStepDepartment());
        movingDepartmentHelper.getProfile().assertValue_contains(hospitalData.getProfile());
        movingDepartmentHelper.getOutcomeDate().assertThatDateContainsValue(hospitalData.getOutcomeDate());
        movingDepartmentHelper.getCareRegimen().assertValue_contains(hospitalData.getCareRegimen());
        movingDepartmentHelper.getBedProfile().assertValue_contains(hospitalData.getBedProfile());
        movingDepartmentHelper.getFinancialType().assertValue_contains(hospitalData.getFinancialType());
        movingDepartmentHelper.getStepResult().assertValue_contains(hospitalData.getStepResult());

        movingDepartmentHelper.getFinalDiagnosis().assertIsHidden(false);
        movingDepartmentHelper.getFinalDiagnosis().assertValue_contains(hospitalData.getDiagnosis());
    }

    public void clickStandardsTab() {
        movingDepartmentHelper.clickStandardTab();
    }
}
