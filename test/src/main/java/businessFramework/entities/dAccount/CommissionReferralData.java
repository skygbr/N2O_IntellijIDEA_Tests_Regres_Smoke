package businessFramework.entities.dAccount;

import java.util.List;

/**
 * Created by bulat.garipov on 05.01.2016.
 */
public class CommissionReferralData {
    private String patient;
    private String recvOrganization;
    private String orderNumber;
    private String referralDate;
    private String goal;
    private List<String> mainDiagnos;
    private String mainDiagnosCode;
    private String clinicalForm;

    public CommissionReferralData() {
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getRecvOrganization() {
        return recvOrganization;
    }

    public void setRecvOrganization(String recvOrganization) {
        this.recvOrganization = recvOrganization;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<String> getMainDiagnos() {
        return mainDiagnos;
    }

    public void setMainDiagnos(List<String> mainDiagnos) {
        this.mainDiagnos = mainDiagnos;
    }

    public String getMainDiagnosCode() {
        return mainDiagnosCode;
    }

    public void setMainDiagnosCode(String mainDiagnosCode) {
        this.mainDiagnosCode = mainDiagnosCode;
    }

    public String getClinicalForm() {
        return clinicalForm;
    }

    public void setClinicalForm(String clinicalForm) {
        this.clinicalForm = clinicalForm;
    }
}
