package businessFramework.module.hospital.pages.statisticCard;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class StatisticCardHelper extends Page implements Values
{
    public StatisticCardHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerMain() {
        return getContainer("main");
    }

    public Container getContainerDepartmentOperations()
    {
        return getContainer("tab2");
    }

    public Container getContainerHospitalRecordList()
    {
        return getContainer("hospitalRecordList");
    }

    public Container getContainerServiceRenderedList()
    {
        return getContainer("serviceRenderedList");
    }

    public Container getContainerDiagnosisList()
    {
        return getContainer("diagnosisList");
    }

    public Classifier getPatient() {
        return getContainerMain().getForm().getClassifier("patient");
    }

    public InputText getUid() {
        return getContainerMain().getForm().getInputText("uid");
    }

    public Classifier getCareProvidingForm() {
        return getContainerMain().getForm().getClassifier("careProvidingForm");
    }

    public Classifier getFinancialType() {
        return getContainerMain().getForm().getClassifier("financialType");
    }

    public Classifier getInitGoal() {
        return getContainerMain().getForm().getClassifier("initGoal");
    }

    public Classifier getCareLevel()
    {
        return getContainerMain().getForm().getClassifier("careLevel");
    }

    public Classifier getAdmissionDepartment()
    {
        return getContainerMain().getForm().getClassifier("admissionDepartment");
    }

    public Classifier getTransportingType()
    {
        return getContainerMain().getForm().getClassifier("transportingType");
    }

    public Button getSaveStatisticButton()
    {
        return getContainerMain().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getCreateSendToDepartmentButton()
    {
        return getContainerHospitalRecordList().getButton(CREATE_BUTTON);
    }

    public Button getEditSendToDepartmentButton()
    {
        return getContainerHospitalRecordList().getButton(UPDATE_BUTTON);
    }

    public Button getCreateServiceButton()
    {
        return getContainerServiceRenderedList().getButton(CREATE_BUTTON);
    }

    public Button getEditServiceButton()
    {
        return getContainerServiceRenderedList().getButton(UPDATE_BUTTON);
    }

    public Button getCreateDiagnosisButton()
    {
        return getContainerDiagnosisList().getButton(CREATE_BUTTON);
    }

    public Button getEditDiagnosisButton()
    {
        return getContainerDiagnosisList().getButton(UPDATE_BUTTON);
    }
}
