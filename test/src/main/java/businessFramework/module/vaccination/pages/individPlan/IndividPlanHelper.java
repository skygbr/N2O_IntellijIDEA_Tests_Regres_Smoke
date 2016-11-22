package businessFramework.module.vaccination.pages.individPlan;

import net.framework.autotesting.ApplicationManager;
import businessFramework.module.Values;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;


public class IndividPlanHelper extends Page implements Values
{
    public IndividPlanHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerIndividPlan()
    {
        return getRegion(SINGLE).getContainer("main");
    }

    public Container getContainerIndividPlanTable()
    {
        return getContainer(".n2o-grid-container_table");
    }

    public Button getFormedButton()
    {
        return getContainerIndividPlan().getButton(SUBMIT);
    }

    public Button getConfirmButton()
    {
        return this.getModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Button getNewDenyButton()
    {
        return this.getModal().getContainer("deny").getButton("createDeny");
    }

    public Button getSeriesLink()
    {
        return this.getModal().getButton(CREATE_LINK);
    }

    public Button getAssignAllInfectionsButton()
    {
        return getContainerIndividPlan().getButton("assign_all_infections");
    }

    public Button getRollbackButton()
    {
        return getContainerIndividPlan().getButton("rollback_assignation");
    }

    public Button getAddSchemeTemplateButton()
    {
        return getContainerIndividPlan().getButton("add_scheme_template");
    }

    public Classifier getPatient()
    {
        return this.getContainerIndividPlan().getFilter().getClassifier("patient");
    }

    public Classifier getCalendar()
    {
        return this.getContainerIndividPlan().getFilter().getClassifier("calendar");
    }

    public MultiClassifier getGroupOfRisk()
    {
        return this.getContainerIndividPlan().getFilter().getMultiClassifier("groupOfRiskDiseases");
    }

    public InputDate getAssignAllInfectionsDate()
    {
        return this.getModal().getForm().getInputDate("period");
    }

    public InputDate getPeriodDate()
    {
        return this.getModal().getForm().getInputDate("period");
    }

    public Button getAddInoculationButton()
    {
        return getContainerIndividPlan().getButton("addInoculation");
    }

    public Button getAddProbaButton()
    {
        return getContainerIndividPlan().getButton("addProba");
    }

    public Button getEditButton()
    {
        return getContainerIndividPlan().getButton("update");
    }

    public Button getDeleteButton()
    {
        return getContainerIndividPlan().getButton("delete");
    }

    public Classifier getClinic()
    {
        return this.getModal().getForm().getClassifier("clinic");
    }

    public Classifier getResourse()
    {
        return  this.getModal().getForm().getClassifier("emplPosRes");
    }

    public Classifier getVaccine()
    {
        return this.getModal().getForm().getClassifier("vaccine");
    }

    public ButtonGroup getStatus()
    {
        return this.getModal().getForm().getButtonGroup("status");
    }

    public Classifier getPhase()
    {
        return this.getModal().getForm().getClassifier("number");
    }

    public Classifier getSeries()
    {
        return this.getModal().getForm().getClassifier("series");
    }

    public Classifier getDose()
    {
        return this.getModal().getForm().getClassifier("dose");
    }

    public Classifier getInputType()
    {
        return this.getModal().getForm().getClassifier("inputType");
    }

    public Classifier getProducer()
    {
        return this.getModal().getForm().getClassifier("producer");
    }

    public InputText getName()
    {
        return this.getModal().getForm().getInputText("seriesLabel");
    }

    public InputDate getProduceDate()
    {
        return this.getModal().getForm().getInputDate("produceDate");
    }

    public Classifier getReason()
    {
        return this.getModal().getForm().getClassifier("reason");
    }

    public Classifier getScheme()
    {
        return this.getModal().getForm().getClassifier("schema");
    }

    public InputText getDenyNumber()
    {
        return this.getModal().getForm().getInputText("denyNumber");
    }

    public Select getDenyPeriodType()
    {
        return this.getModal().getForm().getSelect("denyPeriodType");
    }

    public InputDate getEndDate()
    {
        return this.getModal().getForm().getInputDate("endDate");
    }
}
