package businessFramework.entities.hospital.servicesTemplate;

/**
 * @author agabdrakhmanova
 * @since 30.06.2015
 */
public class ServicesTemplateServiceData {
    private String scheduleSelectionType;
    private String restriction;
    private String service;
    private String resGroup;
    private String department;
    private String district;
    private String speciality;
    private String profile;
    private String funding;
    private String queue;
    private String maxInterval;
    private String indent;
    private String indentMeasure;

    public ServicesTemplateServiceData() {
    }

    public String getScheduleSelectionType() {
        return scheduleSelectionType;
    }

    public void setScheduleSelectionType(String scheduleSelectionType) {
        this.scheduleSelectionType = scheduleSelectionType;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getResGroup() {
        return resGroup;
    }

    public void setResGroup(String resGroup) {
        this.resGroup = resGroup;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getMaxInterval() {
        return maxInterval;
    }

    public void setMaxInterval(String maxInterval) {
        this.maxInterval = maxInterval;
    }

    public String getIndentMeasure() {
        return indentMeasure;
    }

    public void setIndentMeasure(String indentMeasure) {
        this.indentMeasure = indentMeasure;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }
}
