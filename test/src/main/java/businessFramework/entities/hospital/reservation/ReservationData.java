package businessFramework.entities.hospital.reservation;

import businessFramework.entities.hospital.referral.HospReferralData;

public class ReservationData implements Cloneable {
    private String patient;
    private Integer patientId;
    private HospReferralData existingReferral;
    private HospReferralData newReferral;
    private String plannedDate;
    private String department;
    private String regimen;
    private String profile;
    private String bedProfile;
    private Integer duration;
    private Integer avgBedDays;
    private String issuePlannedDate;
    private String financialType;
    private String status;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public HospReferralData getExistingReferral() {
        return existingReferral;
    }

    public void setExistingReferral(HospReferralData existingReferral) {
        this.existingReferral = existingReferral;
    }

    public HospReferralData getNewReferral() {
        return newReferral;
    }

    public void setNewReferral(HospReferralData newReferral) {
        this.newReferral = newReferral;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getBedProfile() {
        return bedProfile;
    }

    public void setBedProfile(String bedProfile) {
        this.bedProfile = bedProfile;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAvgBedDays() {
        return avgBedDays;
    }

    public void setAvgBedDays(Integer avgBedDays) {
        this.avgBedDays = avgBedDays;
    }

    public String getIssuePlannedDate() {
        return issuePlannedDate;
    }

    public void setIssuePlannedDate(String issuePlannedDate) {
        this.issuePlannedDate = issuePlannedDate;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public ReservationData clone() throws CloneNotSupportedException {
        return (ReservationData) super.clone();
    }
}
