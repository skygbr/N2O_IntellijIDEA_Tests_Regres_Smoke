package businessFramework.entities.hospital.prescription;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PrescriptionHoldingData {
    private int index;
    private String holding;
    private BigDecimal count;
    private BigDecimal dose;
    private BigDecimal dosage;
    private String doseMeasure;
    private String mneiName;
    private boolean isPatientMedicament;
    private String store;
    private String modification;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHolding() {
        return holding;
    }

    public void setHolding(String holding) {
        this.holding = holding;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = round(count);
    }

    public BigDecimal getDosage() {
        return dosage;
    }

    public void setDosage(BigDecimal dosage) {
        this.dosage = round(dosage);
    }

    public void setDosage(String dosage) {
        this.dosage = round(new BigDecimal(dosage));
    }

    public String getDoseMeasure() {
        return doseMeasure;
    }


    public void setDoseMeasure(String doseMeasure) {
        this.doseMeasure = doseMeasure;
    }

    public String getDoseWithMeasure() {
        return dose.toPlainString() + " " + doseMeasure;
    }

    public String getDosageWithMeasure() {
        return dosage.toPlainString() + " " + doseMeasure;
    }

    public BigDecimal getDose() {
        return dose;
    }

    public void setDose(BigDecimal dose) {
        this.dose = round(dose);
    }

    public String getMneiName() {
        return mneiName;
    }

    public void setMneiName(String mneiName) {
        this.mneiName = mneiName;
    }

    public boolean isPatientMedicament() {
        return isPatientMedicament;
    }

    public void setPatientMedicament(boolean isPatientMedicament) {
        this.isPatientMedicament = isPatientMedicament;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    private BigDecimal round(BigDecimal val) {
        BigDecimal value = val.round(new MathContext(3, RoundingMode.HALF_UP));
        boolean isIntegerValue = value.signum() == 0 || value.scale() <= 0 || value.stripTrailingZeros().scale() <= 0;
        return isIntegerValue ? value : value.stripTrailingZeros();
    }
}
