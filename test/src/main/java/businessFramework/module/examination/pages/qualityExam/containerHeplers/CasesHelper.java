package businessFramework.module.examination.pages.qualityExam.containerHeplers;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.*;
import net.framework.autotesting.meta.components.Button;

public class CasesHelper extends Page {

    public CasesHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainer() {
        return getRegion("tab2").getContainer("caseForExaminationList");
    }

    public Table getGrid() {
        return getContainer().getTable();
    }


    /* -------------------- Получение фильтра и полей в фильтре -------------------- */

    public Filter getFilter() {
        return getContainer().getFilter();
    }

    public InputCheckBox getFilterExtCheckbox() {
        return getFilter().getInputCheckBox("isExtended");
    }

    public Classifier getFilterCaseTypeField() {
        return getFilter().getClassifier("caseType");
    }

    public InputDate getFilterOpenDtField() {
        return getFilter().getInputDate("openDate");
    }

    public InputDate getFilterCloseDtField() {
        return getFilter().getInputDate("closeDate");
    }

    public Classifier getFilterDepartmentField() {
        return getFilter().getClassifier("department");
    }

    public Classifier getFilterDoctorField() {
        return getFilter().getClassifier("doctor");
    }

    public Classifier getFilterNotExaminedByLevelField() {
        return getFilter().getClassifier("notExaminedByLevel");
    }

    public Classifier getFilterPatientField() {
        return getFilter().getClassifier("patient");
    }

    public Classifier getFilterSocGroupField() {
        return getFilter().getClassifier("socGroup");
    }

    public Classifier getFilterAgeGroupField() {
        return getFilter().getClassifier("ageGroup");
    }

    public Classifier getFilterDiagnosisField() {
        return getFilter().getClassifier("diagnosis");
    }

    public InputCheckBox getFilterDifferentOutAndClinicDiagCheckbox() {
        return getFilter().getInputCheckBox("isOutcomeAndClinicalDiagnosisNotSame");
    }

    public InputCheckBox getFilterDifferentAdmAndClinicDiagCheckbox() {
        return getFilter().getInputCheckBox("isAdmissionAndClinicalDiagnosisNotSame");
    }

    public InputCheckBox getFilterDifferentOperationBeforeAndAfterDiagCheckbox() {
        return getFilter().getInputCheckBox("isOperationBeforeAndAfterDiagnosisNotSame");
    }

    public InputCheckBox getFilterDifferentPatAndClinicDiagCheckbox() {
        return getFilter().getInputCheckBox("isPathologicalAndClinicalDiagnosisNotSame");
    }

    public Classifier getFilterResultField() {
        return getFilter().getClassifier("result");
    }

    public InputText getFilterRepeatDuringMonthsField() {
        return getFilter().getInputText("repeatDuringMonths");
    }

    public InputText getFilterPercentDurationIsMoreField() {
        return getFilter().getInputText("percentDurationIsMore");
    }

    public InputText getFilterPercentDurationIsLessField() {
        return getFilter().getInputText("percentDurationIsLess");
    }


    /* -------------------- Получение кнопок -------------------- */

    public Button getCreateExamCardBtn() {
        return getContainer().getButton("create");
    }

    public Button getNoDefectsBtn() {
        return getContainer().getButton("setNoDefects");
    }

    public void clickSecondLevelBtn() {
        getContainer().clickDropdown("Без замечаний", "II ступень", "second");
    }

    public Button getOpenHospitalCaseBtn() {
       return getContainer().getButton("openPage1");
   }

    public Button getOpenClinicalCaseBtn() {
        return getContainer().getButton("openPage2");
    }
}