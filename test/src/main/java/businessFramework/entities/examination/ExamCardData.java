package businessFramework.entities.examination;

public class ExamCardData implements Cloneable {
    private String expert;
    private String level;

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public ExamCardData clone() throws CloneNotSupportedException {
        return (ExamCardData) super.clone();
    }
}
