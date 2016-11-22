package businessFramework.entities.dAccount;

public class DAccountHospitalData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Сведения о госпитализациях" */
    private String admission_dt;
    private String outcome_date;
    private String diagName;
    private String goalName;

    public String getAdmission_dt() {
        return admission_dt;
    }

    public void setAdmission_dt(String admission_dt) {
        this.admission_dt = admission_dt;
    }

    public String getOutcome_date() {
        return outcome_date;
    }

    public void setOutcome_date(String outcome_date) {
        this.outcome_date = outcome_date;
    }

    public String getDiagName() {
        return diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    @Override
    public DAccountHospitalData clone() throws CloneNotSupportedException
    {
        return (DAccountHospitalData)super.clone();
    }
}
