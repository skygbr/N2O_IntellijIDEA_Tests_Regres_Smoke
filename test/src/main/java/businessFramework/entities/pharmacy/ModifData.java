package businessFramework.entities.pharmacy;

/**
 * Created by bulat.garipov on 20.02.2016.
 */
public class ModifData {

    /**
     * Данные для выбора контекста
     */
    private String departmentForContext;

    /**
     * Данные для полей модального окна Модификация
     */
    String code;
    String codeTfoms;
    String isCommon;
    String commonPrototype;
    String form;
    String name;
    String latinName;
    String mnei;
    String priceUnitFlag;
    String concentrVal;
    String concentrUnit;
    String actVal;
    String actUnit;
    String volumeVal;
    String volumeUnit;
    String dosageVal;
    String dosageUnit;
    String massVal;
    String massUnit;
    String writeOffUnitFlag;
    String storageCond;
    String numberOfDoses;
    String isExtemporal;
    String angroFlag;
    String medPurposeFlag;
    String dloFlag;

    /**Максимальные дозы модификации*/
    String maxSingleDoseVal;
    String maxDailyDoseVal;
    String maxSingleDoseUnit;
    String maxDailyDoseUnit;

    String codeOkdp;

    String holdinfName;

    /**
     * Данные для алертов(уведомлений об успешном сохранении и тд)
     */
    private String successSaveAlertMessage = "Модификация с кодом 'Тестовый код' сохранёна";

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public void setDepartmentForContext(String departmentForContext) {
        this.departmentForContext = departmentForContext;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeTfoms() {
        return codeTfoms;
    }

    public void setCodeTfoms(String codeTfoms) {
        this.codeTfoms = codeTfoms;
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon;
    }

    public String getCommonPrototype() {
        return commonPrototype;
    }

    public void setCommonPrototype(String commonPrototype) {
        this.commonPrototype = commonPrototype;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getMnei() {
        return mnei;
    }

    public void setMnei(String mnei) {
        this.mnei = mnei;
    }

    public String getPriceUnitFlag() {
        return priceUnitFlag;
    }

    public void setPriceUnitFlag(String priceUnitFlag) {
        this.priceUnitFlag = priceUnitFlag;
    }

    public String getConcentrVal() {
        return concentrVal;
    }

    public void setConcentrVal(String concentrVal) {
        this.concentrVal = concentrVal;
    }

    public String getConcentrUnit() {
        return concentrUnit;
    }

    public void setConcentrUnit(String concentrUnit) {
        this.concentrUnit = concentrUnit;
    }

    public String getSuccessSaveAlertMessage() {
        return successSaveAlertMessage;
    }

    public void setSuccessSaveAlertMessage(String successSaveAlertMessage) {
        this.successSaveAlertMessage = successSaveAlertMessage;
    }

    public String getActVal() {
        return actVal;
    }

    public void setActVal(String actVal) {
        this.actVal = actVal;
    }

    public String getActUnit() {
        return actUnit;
    }

    public void setActUnit(String actUnit) {
        this.actUnit = actUnit;
    }

    public String getVolumeVal() {
        return volumeVal;
    }

    public void setVolumeVal(String volumeVal) {
        this.volumeVal = volumeVal;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public String getDosageVal() {
        return dosageVal;
    }

    public void setDosageVal(String dosageVal) {
        this.dosageVal = dosageVal;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public String getMassVal() {
        return massVal;
    }

    public void setMassVal(String massVal) {
        this.massVal = massVal;
    }

    public String getMassUnit() {
        return massUnit;
    }

    public void setMassUnit(String massUnit) {
        this.massUnit = massUnit;
    }

    public String getWriteOffUnitFlag() {
        return writeOffUnitFlag;
    }

    public void setWriteOffUnitFlag(String writeOffUnitFlag) {
        this.writeOffUnitFlag = writeOffUnitFlag;
    }

    public String getStorageCond() {
        return storageCond;
    }

    public void setStorageCond(String storageCond) {
        this.storageCond = storageCond;
    }

    public String getNumberOfDoses() {
        return numberOfDoses;
    }

    public void setNumberOfDoses(String numberOfDoses) {
        this.numberOfDoses = numberOfDoses;
    }

    public String getIsExtemporal() {
        return isExtemporal;
    }

    public void setIsExtemporal(String isExtemporal) {
        this.isExtemporal = isExtemporal;
    }

    public String getAngroFlag() {
        return angroFlag;
    }

    public void setAngroFlag(String angroFlag) {
        this.angroFlag = angroFlag;
    }

    public String getMedPurposeFlag() {
        return medPurposeFlag;
    }

    public void setMedPurposeFlag(String medPurposeFlag) {
        this.medPurposeFlag = medPurposeFlag;
    }

    public String getDloFlag() {
        return dloFlag;
    }

    public void setDloFlag(String dloFlag) {
        this.dloFlag = dloFlag;
    }

    public String getMaxSingleDoseVal() {
        return maxSingleDoseVal;
    }

    public void setMaxSingleDoseVal(String maxSingleDoseVal) {
        this.maxSingleDoseVal = maxSingleDoseVal;
    }

    public String getMaxDailyDoseVal() {
        return maxDailyDoseVal;
    }

    public void setMaxDailyDoseVal(String maxDailyDoseVal) {
        this.maxDailyDoseVal = maxDailyDoseVal;
    }

    public String getMaxSingleDoseUnit() {
        return maxSingleDoseUnit;
    }

    public void setMaxSingleDoseUnit(String maxSingleDoseUnit) {
        this.maxSingleDoseUnit = maxSingleDoseUnit;
    }

    public String getMaxDailyDoseUnit() {
        return maxDailyDoseUnit;
    }

    public void setMaxDailyDoseUnit(String maxDailyDoseUnit) {
        this.maxDailyDoseUnit = maxDailyDoseUnit;
    }

    public String getCodeOkdp() {
        return codeOkdp;
    }

    public void setCodeOkdp(String codeOkdp) {
        this.codeOkdp = codeOkdp;
    }

    public String getHoldinfName() {
        return holdinfName;
    }

    public void setHoldinfName(String holdinfName) {
        this.holdinfName = holdinfName;
    }
}
