package businessFramework.module.hospital.pages.prescriptionOnceExecution;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PrescriptionOnceExecutionHelper extends Page implements PrescriprionOnceExecutionValues {
    public PrescriptionOnceExecutionHelper(ApplicationManager app) {
        super(app);
    }

    // Инфопанель

    public Container getContainerInfoPanel() {
        return getRegion(TOP).getContainer("infopanel");
    }

    public Classifier getPatientField() {
        return getContainerInfoPanel().getForm().getClassifier("patient");
    }

    public InputText getCaseUidField() {
        return getContainerInfoPanel().getForm().getInputText("case.uid");
    }

    public InputText getDiagnosisField() {
        return getContainerInfoPanel().getForm().getInputText("diagnosis");
    }

    public InputDate getAdmissionDateField() {
        return getContainerInfoPanel().getForm().getInputDate("admissionDate");
    }

    // Спиок Списанные препараты

    public Container getListContainer() {
        return getRegion(LEFT).getContainer("list");
    }

    public Table getListTable() {
        return getListContainer().getTable();
    }

    public Button getRemoveButton(){
        return getListContainer().getButton("delete");
    }


    // Форма Лекарственное назначение

    public Container getFormContainer() {
        return getRegion(RIGHT).getContainer("form");
    }

    public Form getPrescriptionForm() {
        return getFormContainer().getForm();
    }

    public Button getConfirmButton() {
        return getFormContainer().getButton(N2O_CONFIRM_BUTTON);
    }

    public WebElement getCreateMoreWebElement() {
        return findElement(By.className(CREATE_MORE));
    }

    public Classifier getHoldingField() {
        return this.getForm().getClassifier("holding");
    }

    public OutputText getMneiNameField(){
        return this.getForm().getOutputText("holding.mneiName");
    }

    public InputText getCountField() {
        return this.getForm().getInputText("count");
    }

    public OutputText getDoseWithMeasureField(){
        return this.getForm().getOutputText("holding.doseWithMeasure");
    }

    public InputText getDoseField(){
        return this.getForm().getInputText("dose");
    }

    public Classifier getAdministrationRouteField() {
        return this.getForm().getClassifier("administrationRoute");
    }

    public Classifier getPeriodicityField() {
        return this.getForm().getClassifier("periodicity");
    }

    public Classifier getVisitTermField() {
        return this.getForm().getClassifier("visitTerm");
    }

    public InputDate getFromField(){
        return getForm().getInputDate("periodBeginDt");
    }

    public InputDate getToField(){
        return getForm().getInputDate("periodEndDt");
    }

    // Товарные запасы склада

    public Filter getModalFilter() {
        return getModal().getFilter();
    }

    public Classifier getFilterHoldingField() {
        return getModalFilter().getClassifier("holding");
    }

    public Classifier getComGroupField() {
        return getModalFilter().getClassifier("comGroup");
    }

    public Classifier getFundSourceField() {
        return getModalFilter().getClassifier("fundSource");
    }

    public Classifier getStoreField() {
        return getModalFilter().getClassifier("store");
    }

    public Table getStoreBalanceTable() {
        return getModal().getContainer("storeSupplyList").getTable();
    }
}