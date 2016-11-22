package businessFramework.entities.hospital.prescription;

import java.math.BigDecimal;
import java.util.*;

public class PrescriptionData implements Cloneable {
    public List<PrescriptionHoldingData> holdings;
    private String administrationRoute;
    private String periodicity;
    private int times;
    private String visitTerm;
    private String periodBeginDt;
    private String periodEndDt;
    private String employee;
    private String note;
    private int dayAmount;
    private String singleDoseWithMeasure;
    private String dailyDoseWithMeasure;
    private String courseDoseWithMeasure;
    private int statusId;
    private int executedTimes;

    public List<PrescriptionHoldingData> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<PrescriptionHoldingData> holdings) {
        this.holdings = holdings;
    }

    public String getAdministrationRoute() {
        return administrationRoute;
    }

    public void setAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(int dayAmount) {
        this.dayAmount = dayAmount;
    }

    public String getSingleDoseWithMeasure() {
        return singleDoseWithMeasure;
    }

    public void setSingleDoseWithMeasure(String singleDoseWithMeasure) {
        this.singleDoseWithMeasure = singleDoseWithMeasure;
    }

    public String getDailyDoseWithMeasure() {
        return dailyDoseWithMeasure;
    }

    public void setDailyDoseWithMeasure(String dailyDoseWithMeasure) {
        this.dailyDoseWithMeasure = dailyDoseWithMeasure;
    }

    public String getCourseDoseWithMeasure() {
        return courseDoseWithMeasure;
    }

    public void setCourseDoseWithMeasure(String courseDoseWithMeasure) {
        this.courseDoseWithMeasure = courseDoseWithMeasure;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        if (executedTimes > 0 && executedTimes == dayAmount * times && statusId == PrescriptionStatus.PERFORM.getId())
            statusId = PrescriptionStatus.EXECUTED.getId();
        if (executedTimes == 0 && statusId == PrescriptionStatus.PERFORM.getId())
            statusId = PrescriptionStatus.SCHEDULED.getId();
        this.statusId = statusId;
    }

    public boolean isPrescriptionExecuted() {
        return executedTimes < dayAmount * times;
    }

    // numberOfExecutions = 1 - выполнен 1 раз
    // numberOfExecutions = -1 - отмена выполнения 1 раз

    public void addExecutions(int numberOfExecutions) {
        executedTimes = executedTimes + numberOfExecutions;
        if (executedTimes == dayAmount * times) {
            statusId = 4;
        }

        if (executedTimes < dayAmount * times && executedTimes > 1) {
            statusId = 3;
        }
    }

    public boolean isComplex() {
        return holdings.size() > 1;
    }

    public String getStatusName() {
        switch (getStatusId()) {
            case 1:
                return "Ожидает подтверждения";
            case 2:
                return "Запланировано";
            case 3:
                return "Выполняется";
            case 4:
                return "Исполнено";
            case 5:
                return "Отменено";
            default:
                return "";
        }
    }

    @Override
    public PrescriptionData clone() throws CloneNotSupportedException {
        return (PrescriptionData) super.clone();
    }

    public void calculateSingleDailyCourseDose() {
        Map<String, BigDecimal> singleMap = new LinkedHashMap<>();
        for (PrescriptionHoldingData holdingData : getHoldings()) {
            String measure = holdingData.getDoseMeasure();
            BigDecimal dose = singleMap.containsKey(measure) ? singleMap.get(measure).add(holdingData.getDose()) : holdingData.getDose();
            singleMap.put(measure, dose);
        }

        String singleDoseWithMeasure = null;
        String dailyDoseWithMeasure = null;
        String courseDoseWithMeasure = null;
        Set<Map.Entry<String, BigDecimal>> entrySet = singleMap.entrySet();
        for (Map.Entry<String, BigDecimal> entry : entrySet) {
            singleDoseWithMeasure = (singleDoseWithMeasure == null ? "" : (singleDoseWithMeasure + " + "))
                    + entry.getValue() + " " + entry.getKey();

            dailyDoseWithMeasure = (dailyDoseWithMeasure == null ? "" : (dailyDoseWithMeasure + " + "))
                    + entry.getValue().multiply(new BigDecimal(getTimes()))+ " " + entry.getKey();

            courseDoseWithMeasure = (courseDoseWithMeasure == null ? "" : (courseDoseWithMeasure + " + "))
                    + entry.getValue().multiply(new BigDecimal(getTimes()).
                    multiply(new BigDecimal(getDayAmount()))) + " " + entry.getKey();
        }
        setSingleDoseWithMeasure(singleDoseWithMeasure);
        setDailyDoseWithMeasure(dailyDoseWithMeasure);
        setCourseDoseWithMeasure(courseDoseWithMeasure);
    }
}
