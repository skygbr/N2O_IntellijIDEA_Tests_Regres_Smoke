package businessFramework.entities.pharmacy;

/**
 * Created by bulat.garipov on 20.02.2016.
 */
public class HoldingProducerData {

    String organization;
    String organizationName;
    String regCertNumber;
    String codeRls;
    String regCertDateStart;
    String eanCode;
    String regCertDateEnd;
    String limitPrice;
    String formattedLimitPrice;
    String decisionNumber;
    String priceDate;
    String certificateNumber;

    /** Данные для алертов(уведомлений об успешном сохранении и тд) */
    private String successSaveAlertMessage ="Данные сохранены";

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRegCertNumber() {
        return regCertNumber;
    }

    public void setRegCertNumber(String regCertNumber) {
        this.regCertNumber = regCertNumber;
    }

    public String getCodeRls() {
        return codeRls;
    }

    public void setCodeRls(String codeRls) {
        this.codeRls = codeRls;
    }

    public String getRegCertDateStart() {
        return regCertDateStart;
    }

    public void setRegCertDateStart(String regCertDateStart) {
        this.regCertDateStart = regCertDateStart;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getRegCertDateEnd() {
        return regCertDateEnd;
    }

    public void setRegCertDateEnd(String regCertDateEnd) {
        this.regCertDateEnd = regCertDateEnd;
    }

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getDecisionNumber() {
        return decisionNumber;
    }

    public void setDecisionNumber(String decisionNumber) {
        this.decisionNumber = decisionNumber;
    }

    public String getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate;
    }

    public String getSuccessSaveAlertMessage() {
        return successSaveAlertMessage;
    }

    public void setSuccessSaveAlertMessage(String successSaveAlertMessage) {
        this.successSaveAlertMessage = successSaveAlertMessage;
    }

    public String getFormattedLimitPrice() {
        return formattedLimitPrice;
    }

    public void setFormattedLimitPrice(String formattedLimitPrice) {
        this.formattedLimitPrice = formattedLimitPrice;
    }
}
