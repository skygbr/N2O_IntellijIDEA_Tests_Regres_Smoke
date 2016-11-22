package businessFramework.module.examination.pages.qualityExam;

import businessFramework.entities.examination.CaseForExamData;
import businessFramework.entities.examination.ExamCardData;
import businessFramework.module.examination.pages.qualityExam.containerHeplers.CardsForCaseHelper;
import businessFramework.module.examination.pages.qualityExam.containerHeplers.CasesHelper;
import businessFramework.module.values.CommonValues.ButtonsValues;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Form;
import net.framework.autotesting.meta.Modal;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class QualityExamPage extends QualityExamHelper {

    private CasesHelper casesHelper                 = new CasesHelper(app);
    private CardsForCaseHelper cardsForCaseHelper   = new CardsForCaseHelper(app);
    private SimpleDateFormat sdf                    = new SimpleDateFormat("dd.MM.yyyy");


    public QualityExamPage(ApplicationManager app) {
        super(app);
    }

    public void openCasesForExamFilterTab() {
        getContainer("tab2").clickContainer();
    }

    public void assertCasesForExaminationFilter() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); // начало месяца
        casesHelper.getFilterCloseDtField().assertThatBeginDateContainsValue(sdf.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  // конец месяца
        casesHelper.getFilterCloseDtField().assertThatEndDateContainsValue(sdf.format(calendar.getTime()));

        assertFilterFieldsVisibility(false);
        casesHelper.getFilterExtCheckbox().check();
        assertFilterFieldsVisibility(true);
    }

    public void findCase(CaseForExamData caseForExamData) {
        casesHelper.getFilterCaseTypeField().setValue(caseForExamData.getCaseType());

        casesHelper.getFilterOpenDtField().setBeginDateValue(caseForExamData.getOpenDate());
        casesHelper.getFilterOpenDtField().setEndDateValue(caseForExamData.getOpenDate());

        casesHelper.getFilterCloseDtField().setBeginDateValue(caseForExamData.getCloseDate());
        casesHelper.getFilterCloseDtField().setEndDateValue(caseForExamData.getCloseDate());

        casesHelper.getFilterDepartmentField().setValue(caseForExamData.getLastStepDepartment());
        casesHelper.getFilterDoctorField().setValue(caseForExamData.getDoctor());

        casesHelper.getFilterNotExaminedByLevelField().setValue(0);
        casesHelper.getFilterPatientField().setValue(caseForExamData.getPatient());
        casesHelper.getFilterSocGroupField().setExactValue(caseForExamData.getSocGroup());

        casesHelper.getFilterDiagnosisField().setValue(caseForExamData.getMainDiagCode());
        casesHelper.getFilterDifferentOutAndClinicDiagCheckbox().check(caseForExamData.isOutAndClinicDiagDifferent());
        casesHelper.getFilterDifferentAdmAndClinicDiagCheckbox().check(caseForExamData.isAdmAndClinicDiagDifferent());

        casesHelper.getFilterResultField().setValue(caseForExamData.getResultWithCode());

        casesHelper.getFilter().clickFindButton();
        casesHelper.getGrid().assertThatCountOfRowsIs(1);

        assertCaseColumnsValues(caseForExamData, casesHelper.getGrid());
    }

    private void assertCaseColumnsValues(CaseForExamData caseForExamData, Table table) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Ступень", caseForExamData.getExaminedByLevels());
        map.put("Пациент", caseForExamData.getPatient().trim().split(" ")[0]);
        map.put("Номер случая", caseForExamData.getUid());
        map.put("Открыт", caseForExamData.getOpenDate());
        map.put("Закрыт", caseForExamData.getCloseDate());
        map.put("Длительность", String.valueOf(caseForExamData.getDuration()));
        map.put("Отделение", caseForExamData.getLastStepDepartment());
        map.put("Лечащий врач", caseForExamData.getDoctor());
        map.put("Диагноз", caseForExamData.getMainDiagCode());
        map.put("Результат", caseForExamData.getResult());
        table.assertThatRowColumnsIntersectionValueContains(0, map);
    }

    private void assertFilterFieldsVisibility(boolean isExt) {
        casesHelper.getFilterSocGroupField().assertIsHidden(!isExt);
        casesHelper.getFilterAgeGroupField().assertIsHidden(!isExt);

        casesHelper.getFilterDifferentOutAndClinicDiagCheckbox().assertIsHidden(!isExt);
        casesHelper.getFilterDifferentAdmAndClinicDiagCheckbox().assertIsHidden(!isExt);
        casesHelper.getFilterDifferentOperationBeforeAndAfterDiagCheckbox().assertIsHidden(!isExt);
        casesHelper.getFilterDifferentPatAndClinicDiagCheckbox().assertIsHidden(!isExt);

        casesHelper.getFilterRepeatDuringMonthsField().assertIsHidden(!isExt);
        casesHelper.getFilterPercentDurationIsMoreField().assertIsHidden(!isExt);
        casesHelper.getFilterPercentDurationIsLessField().assertIsHidden(!isExt);
    }

    private void lsdOpeningButtonTest(Button btn, String btnLabel, String partOfLink ) {
        btn.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Экспертная карта");
        closeAllModalsOnPage();
    }

    public void createExamCardButtonTest() {
        this.lsdOpeningButtonTest(casesHelper.getCreateExamCardBtn(), "Создать ЭК" , "/examination/card/new");
    }

    public void openCaseButtonTest() {
        casesHelper.getOpenHospitalCaseBtn().click();
        assertBreadcrumbContainsValue("История болезни");
        closePage();
        assertBreadcrumbContainsValue("Экспертиза качества медицинской помощи");
    }

    public void noRemarksBtnTest(CaseForExamData caseForExamData, ExamCardData cardData) {
        casesHelper.getNoDefectsBtn().click();
        assertModalPresentOnPage(true);
        assertAndFillNoRemarksModalForm(caseForExamData, cardData);
        casesHelper.getGrid().getAlerts().assertSuccessAlertIsPresent();

        Map<String, String> map = new HashMap<String, String>();
        map.put("Ступень", caseForExamData.getExaminedByLevels());
        casesHelper.getGrid().assertThatRowColumnsIntersectionValueContains(0,map);
        cardsForCaseHelper.getGrid().assertThatCountOfRowsIs(1);
    }

    private void assertAndFillNoRemarksModalForm(CaseForExamData caseForExamData, ExamCardData cardData) {
        Modal modal = getModal();
        modal.assertModalHeader_equal("Отметить отсутствие замечаний по случаям");

        modal.getContainer("caseList").getTable().assertThatCountOfRowsIs(1);
        assertCaseColumnsValues(caseForExamData, getModal().getContainer("caseList").getTable());

        Form form = modal.getContainer("main").getForm();
        form.getClassifier("expert").assertIsDisplayed(false);
        form.getClassifier("controlLevel").assertIsDisabled(true);
        form.getClassifier("controlLevel").setValue(String.valueOf(cardData.getLevel()));
        form.getClassifier("expert").assertIsDisplayed(true);
        form.getClassifier("expert").assertValue_contains(cardData.getExpert());
        form.getInputDate("createDate").assertValue_contains(getCurrentDate());
        modal.getButton(ButtonsValues.N2O_CONFIRM_BUTTON).click();
        caseForExamData.setExaminedByLevels(cardData.getLevel());
    }

    public void updateAndDeleteButtonsTest_cardsForCaseList(CaseForExamData caseForExamData) {
        cardsForCaseHelper.getGrid().chooseRowInTable(0);
        cardsForCaseHelper.getUpdateBtn().assertIsDisabled();
        cardsForCaseHelper.getDeleteBtn().assertIsEnabled();
        cardsForCaseHelper.getDeleteBtn().click();
        getDialog().clickYes();
        cardsForCaseHelper.getGrid().getAlerts().assertSuccessAlertIsPresent();
        caseForExamData.setExaminedByLevels("");
    }
}
