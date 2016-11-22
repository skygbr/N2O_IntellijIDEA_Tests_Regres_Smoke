package businessFramework.entities.dAccount;

public class DAccountFrcInvolExamData implements Cloneable{
    /** Данные для установки значений в поля в модальном окне "Недобровольное освидетельствование" */
    private String examDt;
    private String result;

    public String getExamDt() {
        return examDt;
    }

    public void setExamDt(String examDt) {
        this.examDt = examDt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public DAccountFrcInvolExamData clone() throws CloneNotSupportedException
    {
        return (DAccountFrcInvolExamData)super.clone();
    }
}
