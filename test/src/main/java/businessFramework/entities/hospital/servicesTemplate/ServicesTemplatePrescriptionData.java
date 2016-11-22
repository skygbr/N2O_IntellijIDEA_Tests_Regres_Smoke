package businessFramework.entities.hospital.servicesTemplate;

import businessFramework.entities.hospital.prescription.PrescriptionData;

public class ServicesTemplatePrescriptionData extends PrescriptionData implements Cloneable {
    private Integer beginDay;
    private Integer countDay;
    private String templateNote;

    public Integer getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Integer beginDay) {
        this.beginDay = beginDay;
    }

    public Integer getCountDay() {
        return countDay;
    }

    public void setCountDay(Integer countDay) {
        this.countDay = countDay;
    }

    public String getTemplateNote() {
        return templateNote;
    }

    public void setTemplateNote(String templateNote) {
        this.templateNote = templateNote;
    }

    @Override
    public ServicesTemplatePrescriptionData clone() throws CloneNotSupportedException {
        return (ServicesTemplatePrescriptionData) super.clone();
    }
}
