package businessFramework.entities.hospital.referral;

import java.util.Date;

public class HospReferralData implements Cloneable {
    private String patient;
    private Integer patientId;
    private String refOrgRole;
    private String refOrg;
    private String refDep;
    private String refEmployee;
    private String recvOrgCode;
    private String recvOrg;
    private String recvDep;
    private String recvEmployee;
    private String refDate;
    private String orderNumber;
    private Boolean cito;
    private String refType;
    private String recvRegimen;
    private String finType;
    private String refComment;
    private String refDiagnosis;
    private String refDiagnosisComment;

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

    public String getRefOrgRole() {
        return refOrgRole;
    }

    public void setRefOrgRole(String refOrgRole) {
        this.refOrgRole = refOrgRole;
    }

    public String getRefOrg() {
        return refOrg;
    }

    public void setRefOrg(String refOrg) {
        this.refOrg = refOrg;
    }

    public String getRefDep() {
        return refDep;
    }

    public void setRefDep(String refDep) {
        this.refDep = refDep;
    }

    public String getRefEmployee() {
        return refEmployee;
    }

    public void setRefEmployee(String refEmployee) {
        this.refEmployee = refEmployee;
    }

    public String getRecvOrg() {
        return recvOrg;
    }

    public void setRecvOrg(String recvOrg) {
        this.recvOrg = recvOrg;
    }

    public String getRecvDep() {
        return recvDep;
    }

    public void setRecvDep(String recvDep) {
        this.recvDep = recvDep;
    }

    public String getRecvEmployee() {
        return recvEmployee;
    }

    public void setRecvEmployee(String recvEmployee) {
        this.recvEmployee = recvEmployee;
    }

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean getCito() {
        return cito;
    }

    public void setCito(Boolean cito) {
        this.cito = cito;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRecvRegimen() {
        return recvRegimen;
    }

    public void setRecvRegimen(String recvRegimen) {
        this.recvRegimen = recvRegimen;
    }

    public String getFinType() {
        return finType;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getRefComment() {
        return refComment;
    }

    public void setRefComment(String refComment) {
        this.refComment = refComment;
    }

    public String getRefDiagnosis() {
        return refDiagnosis;
    }

    public void setRefDiagnosis(String refDiagnosis) {
        this.refDiagnosis = refDiagnosis;
    }

    public String getRefDiagnosisComment() {
        return refDiagnosisComment;
    }

    public void setRefDiagnosisComment(String refDiagnosisComment) {
        this.refDiagnosisComment = refDiagnosisComment;
    }

    public String getRecvOrgCode() {
        return recvOrgCode;
    }

    public void setRecvOrgCode(String recvOrgCode) {
        this.recvOrgCode = recvOrgCode;
    }

    @Override
    public HospReferralData clone() throws CloneNotSupportedException {
        return (HospReferralData) super.clone();
    }
}
