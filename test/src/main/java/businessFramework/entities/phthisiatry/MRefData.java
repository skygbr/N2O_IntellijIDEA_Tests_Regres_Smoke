package businessFramework.entities.phthisiatry;

import java.util.List;

/**
 * Created by bulat.garipov on 31.10.2016.
 */
public class MRefData implements Cloneable
{
    /** Данные для установки значений в поля в модальном окне "Направления (Назначения)" */

    private String checkboxesIsUrgent;
    private String clinic;
    private String stepDepartment;
    private String financialType;
    private String plannedDate;
    private String service;
    private String vrach;
    private String diagnos;
    private String comment;
    private String surname;
    private String name;
    private String patrName;
    private String birthDate;
    private String posName;
    private String renderedDate;
    private String refStatus;


    public String getCheckboxesIsUrgent() {
        return checkboxesIsUrgent;
    }

    public void setCheckboxesIsUrgent(String checkboxesIsUrgent) {
        this.checkboxesIsUrgent = checkboxesIsUrgent;
    }

    public String getStepDepartment() {
        return stepDepartment;
    }

    public void setStepDepartment(String stepDepartment) {
        this.stepDepartment = stepDepartment;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getRenderedDate() {
        return renderedDate;
    }

    public void setRenderedDate(String renderedDate) {
        this.renderedDate = renderedDate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getVrach() {
        return vrach;
    }

    public void setVrach(String vrach) {
        this.vrach = vrach;
    }

    public String getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPatrName()
    {
        return patrName;
    }

    public void setPatrName(String patrName)
    {
        this.patrName = patrName;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getPosName()
    {
        return posName;
    }

    public void setPosName(String posName)
    {
        this.posName = posName;
    }

    public String getRefStatus()
    {
        return refStatus;
    }

    public void setRefStatus(String refStatus)
    {
        this.refStatus = refStatus;
    }

    @Override
    public MRefData clone() throws CloneNotSupportedException
    {
        return (MRefData)super.clone();
    }

}
