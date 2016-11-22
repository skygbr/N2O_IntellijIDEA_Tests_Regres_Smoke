package businessFramework.module.hospital.modals.discharge;

import businessFramework.entities.hospital.DischargeData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.test.DateUtil;

import java.util.Calendar;

/**
 * @author agabdrakhmanova
 * @since 15.05.2015
 */
public class DischargeModal {

    private DischargeHelper dischargeHelper;
    private DischargeTabHelper dischargeTabHelper;
    private ApplicationManager app = ApplicationManager.getInstance();

    public DischargeModal() {
        this.dischargeHelper = new DischargeHelper();
        this.dischargeTabHelper = new DischargeTabHelper(app);
    }

    public void fillDischargeForm(DischargeData dischargeData) {
        String outcomeDt = DateUtil.getCurrentDateTime();
        dischargeHelper.getOutcomeDate().setValue(outcomeDt);
        dischargeData.setOutcomeDate(outcomeDt);
// TODO: 22.08.2016 поле заполненяется автоматически и задизейблено
//      dischargeHelper.getBedProfile().setValue(dischargeData.getBedProfile());
        dischargeHelper.getStepResult().setValue(dischargeData.getStepResult());
        dischargeHelper.getOutcome().setValue(dischargeData.getOutcome());
        dischargeHelper.getCareLevel().setValue(dischargeData.getCareLevel());
//TODO временное решение RankIn не происходит поиск в классифаере по набранному значению RMISDEV-3699
        dischargeHelper.getRankIn().setValue(0);
        dischargeHelper.getFinalDiagnosis().searchValue(dischargeData.getFinalDiagnosisCode());

        this.setDeathFieldsValuesIfNeeded(dischargeData);


        dischargeTabHelper.clickResultTab();
        dischargeHelper.getCurCoefVal0().clickLink("Добавить");

        dischargeHelper.getCurCoefCriteria1().assertIsHidden(false);
        dischargeHelper.getCurCoefVal1().assertIsHidden(false);

        dischargeHelper.getCurCoefCriteria0().setValue(dischargeData.getCoefCur0());
        dischargeHelper.getCurCoefVal0().setValue(dischargeData.getCoefCurVal0());

        dischargeHelper.getCurCoefCriteria1().setValue(dischargeData.getCoefCur1());
        dischargeHelper.getCurCoefVal1().setValue(dischargeData.getCoefCurVal1());
        dischargeTabHelper.clickDischargeTab();
    }

    private void setDeathFieldsValuesIfNeeded(DischargeData dischargeData) {
        boolean isDeathResult = dischargeHelper.getStepResult().getValue().contains("Умер");
        dischargeHelper.getDeathDate().assertIsHidden(!isDeathResult);
        dischargeHelper.getDeathEmployee().assertIsHidden(!isDeathResult);

        if (dischargeData.getDeathDate() == null)
            return;
        dischargeHelper.getDeathDate().getValidations().assertRequiredStar(true);
        dischargeHelper.getDeathDate().assertValue_equals(dischargeHelper.getOutcomeDate().getValue());
        dischargeHelper.getDeathDate().setValue(dischargeData.getDeathDate());
        dischargeHelper.getDeathEmployee().setValue(dischargeData.getDeathEmployee());
    }

    private void assertDeathFieldsValuesIfNeeded(DischargeData dischargeData) {
        boolean isDeathResult = dischargeHelper.getStepResult().getValue().contains("Умер");
        dischargeHelper.getDeathDate().assertIsHidden(!isDeathResult);
        dischargeHelper.getDeathEmployee().assertIsHidden(!isDeathResult);

        if (dischargeData.getDeathDate() == null)
            return;
        dischargeHelper.getDeathDate().assertValue_equals(dischargeData.getDeathDate());
        dischargeHelper.getDeathEmployee().assertValue_contains(dischargeData.getDeathEmployee());
    }

    public void assertForm(DischargeData dischargeData)
    {
        dischargeHelper.getStepResult().assertValue_contains(dischargeData.getStepResult());
        dischargeHelper.getOutcome().assertValue_contains(dischargeData.getOutcome());
        dischargeHelper.getCareLevel().assertValue_contains(dischargeData.getCareLevel());
        if (!dischargeData.getFinalDiagnosisTree().isEmpty())
            dischargeHelper.getFinalDiagnosis().assertValueContains
                    (dischargeData.getFinalDiagnosisTree().get(dischargeData.getFinalDiagnosisTree().size() - 1));
        dischargeHelper.getOutcomeDate().assertThatDateContainsValue(dischargeData.getOutcomeDate());

        assertDeathFieldsValuesIfNeeded(dischargeData);

        dischargeTabHelper.clickResultTab();

        dischargeHelper.getCurCoefCriteria1().assertIsHidden(false);
        dischargeHelper.getCurCoefVal1().assertIsHidden(false);

        dischargeHelper.getCurCoefCriteria0().assertValue_contains(dischargeData.getCoefCur0());
        dischargeHelper.getCurCoefVal0().assertValue(dischargeData.getCoefCurVal0());

        dischargeHelper.getCurCoefCriteria1().assertValue_contains(dischargeData.getCoefCur1());
        dischargeHelper.getCurCoefVal1().assertValue(dischargeData.getCoefCurVal1());

        dischargeTabHelper.clickDischargeTab();
    }

    public void clickSave()
    {
        Button button = dischargeHelper.getDischargeButton();
        button.assertIsEnabled();
        button.click();
    }


}
