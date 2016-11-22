package businessFramework.module.hospital.pages.medicalHistory;


import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputDate;
import net.framework.autotesting.meta.components.OutputText;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MedicalHistoryHelper extends Page implements MedicalHistoryValues {
    public MedicalHistoryHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerMedicalHistory() {
        return getContainer("medicalHistoryContainerForm");
    }

    public Container getContainerServices() {
        return getContainer("physicalServices");
    }

    public Container getContainerPlannedAndRenderedServiceList() {
        return getContainer("plannedAndRenderedServiceList");
    }

    public Container getContainerHospitalRecords() {
        return getContainer("hospitalRecordList");
    }

    public Container getContainerBedList() {
        return getContainer("bedList");
    }

    public Container getContainerDiagnosisList() {
        return getContainer("diagnosisList");
    }

    public Container getContainerPrescriptionList() {
        return getContainer("prescriptionList");
    }

    public Container getContainerTreatmentPlanList() {
        return getContainer("mdHistoryTreatmentPlan");
    }

    public Container getContainerSickList() {
        return getContainer("sickList");
    }

    public Container getContainerHospitalizationInfo() {
        return getContainer("hospitalizationInfo");
    }

    public Container getPrescriptionServiceList() {
        return getContainer("prescriptionServiceList");
    }


    public OutputText getPatientName() {
        return getContainerMedicalHistory().getForm().getOutputText("patientName");
    }

    public OutputText getBirthDate() {
        return getContainerMedicalHistory().getForm().getOutputText("birthDate");
    }

    public OutputText getGender() {
        return getContainerMedicalHistory().getForm().getOutputText("gender");
    }

    public OutputText getUid() {
        return getContainerMedicalHistory().getForm().getOutputText("uid");
    }

    public OutputText getFinancialType() {
        return getContainerMedicalHistory().getForm().getOutputText("financialType");
    }

    public InputDate getAdmissionDate() {
        return getContainerMedicalHistory().getForm().getInputDate("admissionDate");
    }

    public OutputText getOutcomeDate() {
        return getContainerMedicalHistory().getForm().getOutputText("outcomeDate");
    }

    public OutputText getDoctor() {
        return getContainerMedicalHistory().getForm().getOutputText("doctor");
    }

    public OutputText getDepartment() {
        return getContainerMedicalHistory().getForm().getOutputText("department");
    }

    public OutputText getBedDaysAmount() {
        return getContainerMedicalHistory().getForm().getOutputText("bedDaysAmount");
    }

    public OutputText getDiagnosisName() {
        return getContainerMedicalHistory().getForm().getOutputText("diagnosisName");
    }

    public Classifier getProvisionCondition() {
        return getContainerMedicalHistory().getForm().getClassifier("provisionCondition");
    }

    public int getCount(List<WebElement> list, String value) {
        for (WebElement element : list) {
            String elemValue = element.getText();
            if (elemValue.contains(value)) {
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(elemValue);
                if (matcher.find()) {
                    return matcher.groupCount();
                }
            }
        }
        assertThat(String.format("Value %s doesn't present in table", value), true, is(false));
        return 0;
    }

    public int getDiagnosisCount() {
        return this.getContainerDiagnosisList().getTable().getCountRowsInTable(true);
    }

    public int getServiceCount() {
        return this.getContainerServices().getTable().getCountRowsInTable(true);
    }

    public int getSendToDepartmentCount() {
        return this.getContainerHospitalRecords().getTable().getCountRowsInTable(true);
    }

    public int getTreatmentPlanCount() {
        return this.getContainerTreatmentPlanList().getTable().getCountRowsInTable(true);
    }

    public int getSendToBed() {
        return this.getContainerBedList().getTable().getCountRowsInTable(true);
    }

    public Button getDeleteHospitalButton()
    {
        return getContainerHospitalRecords().getButton("delete");
    }

    public Button getCreateDiagnosisButton() {
        return getContainerDiagnosisList().getButton("create");
    }

    public Button getEditDiagnosisButton() {
        return getContainerDiagnosisList().getButton("update");
    }

    public Button getDeleteDiagnosisButton() {
        return getContainerDiagnosisList().getButton("delete");
    }

    public Button getCreateTreatmentPlanButton() {
        return getContainerTreatmentPlanList().getButton("createTreatmentPlan");
    }

    public Button getUpdateTreatmentPlanButton() {
        return getContainerTreatmentPlanList().getButton("editTreatmentPlan");
    }

    public Button getViewTreatmentPlanButton() {
        return getContainerTreatmentPlanList().getButton("showTreatmentPlan");
    }

    public Button getDeleteTreatmentPlanButton() {
        return getContainerTreatmentPlanList().getButton("deleteTreatmentPlan");
    }

    public Button getEditPrescriptionButton() {
        return getContainerPrescriptionList().getButton("update");
    }

    public Button getCopyPrescriptionButton() {
        return getContainerPrescriptionList().getButton("copy");
    }

    public Button getDeletePrescriptionButton() {
        return getContainerPrescriptionList().getButton("delete");
    }

    public Button getConfirmPrescriptionButton() {
        return getContainerPrescriptionList().getButton("confirm");
    }

    public Button getCancelPrescriptionButton() {
        return getContainerPrescriptionList().getButton("cancel");
    }

    public Button getResumePrescriptionButton() {
        return getContainerPrescriptionList().getButton("resume");
    }

    public Button getReadPrescriptionButton() {
        return getContainerPrescriptionList().getButton("read");
    }

    public Button getProlongPrescriptionButton() {
        return getContainerPrescriptionList().getButton("prolong");
    }

    public Button getUpdateHospitalRecordButton() {
        return getContainerHospitalRecords().getButton("update");
    }

    public Button getDischargeButton() {
        return getContainerHospitalRecords().getButton("discharge");
    }

    public Button getCancelDischargeButton() {
        return getContainerHospitalRecords().getButton("reopen");
    }

    public Button getEditDischargeButton() {
        return getContainerHospitalRecords().getButton("editDischarge");
    }

    public Button getDeleteHospitalRecordButton() {
        return getContainerHospitalRecords().getButton("delete");
    }

    public Button getCreateServiceButton() {
        return getContainerTreatmentPlanList().getButton("add");
    }

    public Button getCreateServiceByTemplateButton() {
        return getContainerPlannedAndRenderedServiceList().getButton("srvByTemplate");
    }

    public Button getCreateRenderedButton() {
        return getContainerPlannedAndRenderedServiceList().getButton("createRendered");
    }

    public Button getCreatePlannedOperationButton() {
        return getContainerPlannedAndRenderedServiceList().getButton("createPlannedOperation");
    }

    public Button getUpdatePlannedOperationButton() {
        return getContainerPlannedAndRenderedServiceList().getButton("updatePlannedOperation");
    }

    public Button getCreateRenderedOperationButton() {
        return getContainerPlannedAndRenderedServiceList().getButton("createRenderOperation");
    }

    public Button getDeletePlannedServiceList() {
        return getContainerPlannedAndRenderedServiceList().getButton("deletePlannedService");
    }

    public Button getDeleteRenderedServiceList() {
        return getContainerPlannedAndRenderedServiceList().getButton("delete");
    }

    public Button getSickListIssuedAnotherClinicButton() {
        return getContainerSickList().getButton("issuedAnotherClinicCreate");
    }

    public Button getEditSickListButton() {
        return getContainerSickList().getButton("issuedAnotherClinicUpdate");
    }

    public Button getDeleteSickListButton() {
        return getContainerSickList().getButton("delete");
    }

    //prescription service
    public Button getCreatePrescriptionServiceButton() {
        return getPrescriptionServiceList().getButton("create");
    }

    public Button getUpdatePrescriptionServiceButton() {
        return getPrescriptionServiceList().getButton("update");
    }

    public Button getConfirmPrescriptionServiceButton() {
        return getPrescriptionServiceList().getButton("confirm");
    }

    public Button getCancelPrescriptionServiceButton() {
        return getPrescriptionServiceList().getButton("cancel");
    }

    public Button getDeletePrescriptionServiceButton() {
        return getPrescriptionServiceList().getButton("delete");
    }

}
