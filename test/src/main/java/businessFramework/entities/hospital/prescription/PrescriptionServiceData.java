package businessFramework.entities.hospital.prescription;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class PrescriptionServiceData {

    private String caseInfo;
    private String name;
    private String service;
    private String duration;
    private String srvDurationUnit;
    private String periodicity;
    private String visitTerm;
    private String periodBeginDt;
    private String periodEndDt;
    private String note;
    private String execution;
    private String count;
    private String financialType;

    private String generatedFirstDate;
    private String hospitalRecord;

    public PrescriptionServiceData() {
    }

    public String getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(String caseInfo) {
        this.caseInfo = caseInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSrvDurationUnit() {
        return srvDurationUnit;
    }

    public void setSrvDurationUnit(String srvDurationUnit) {
        this.srvDurationUnit = srvDurationUnit;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getVisitTerm() {
        return visitTerm;
    }

    public void setVisitTerm(String visitTerm) {
        this.visitTerm = visitTerm;
    }

    public String getPeriodBeginDt() {
        return periodBeginDt;
    }

    public void setPeriodBeginDt(String periodBeginDt) {
        this.periodBeginDt = periodBeginDt;
    }

    public String getPeriodEndDt() {
        return periodEndDt;
    }

    public void setPeriodEndDt(String periodEndDt) {
        this.periodEndDt = periodEndDt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getGeneratedFirstDate() {
        return generatedFirstDate;
    }

    public void setGeneratedFirstDate(String generatedFirstDate) {
        this.generatedFirstDate = generatedFirstDate;
    }

    public String getHospitalRecord() {
        return hospitalRecord;
    }

    public void setHospitalRecord(String hospitalRecord) {
        this.hospitalRecord = hospitalRecord;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }
}
