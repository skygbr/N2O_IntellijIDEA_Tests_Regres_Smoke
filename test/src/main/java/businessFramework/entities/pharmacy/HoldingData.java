package businessFramework.entities.pharmacy;

import java.lang.String;

/**
 * Created by bulat.garipov on 20.02.2016.
 */
public class HoldingData {

    /** Данные для выбора контекста */
    private String departmentForContext;

    /** Данные для полей модального окна Номенклатура */
    String isVital;
    String isAccounting;
    String isGuaranty;
    String commonPrototype;
    String code;
    String name;
    String inn;
    String latinName;
    String commodityGroup;
    String ven;
    String officialList;
    String acts;
    String pharmGroup;
    String mkbDiagnosis;
    String pharmAction;

    /** Данные для полей Фильтра */
    String codeModif;

    /** Данные для алертов(уведомлений об успешном сохранении и тд) */
    private String successSaveAlertMessage ="Номенклатура с кодом 'Тестовый код' сохранена";

    public String getIsVital() {
        return isVital;
    }

    public void setIsVital(String isVital) {
        this.isVital = isVital;
    }

    public String getIsAccounting() {
        return isAccounting;
    }

    public void setIsAccounting(String isAccounting) {
        this.isAccounting = isAccounting;
    }

    public String getIsGuaranty() {
        return isGuaranty;
    }

    public void setIsGuaranty(String isGuaranty) {
        this.isGuaranty = isGuaranty;
    }

    public String getCommonPrototype() {
        return commonPrototype;
    }

    public void setCommonPrototype(String commonPrototype) {
        this.commonPrototype = commonPrototype;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getCommodityGroup() {
        return commodityGroup;
    }

    public void setCommodityGroup(String commodityGroup) {
        this.commodityGroup = commodityGroup;
    }

    public String getVen() {
        return ven;
    }

    public void setVen(String ven) {
        this.ven = ven;
    }

    public String getOfficialList() {
        return officialList;
    }

    public void setOfficialList(String officialList) {
        this.officialList = officialList;
    }

    public String getActs() {
        return acts;
    }

    public void setActs(String acts) {
        this.acts = acts;
    }

    public String getPharmGroup() {
        return pharmGroup;
    }

    public void setPharmGroup(String pharmGroup) {
        this.pharmGroup = pharmGroup;
    }

    public String getMkbDiagnosis() {
        return mkbDiagnosis;
    }

    public void setMkbDiagnosis(String mkbDiagnosis) {
        this.mkbDiagnosis = mkbDiagnosis;
    }

    public String getPharmAction() {
        return pharmAction;
    }

    public void setPharmAction(String pharmAction) {
        this.pharmAction = pharmAction;
    }

    public void setDepartmentForContext(String department) {
        this.departmentForContext = department;
    }

    public String getDepartmentForContext() {
        return departmentForContext;
    }

    public String getSuccessSaveAlertMessage() {
        return successSaveAlertMessage;
    }

    public void setSuccessSaveAlertMessage(String successSaveAlertMessage) {
        this.successSaveAlertMessage = successSaveAlertMessage;
    }

    public String getCodeModif() {
        return codeModif;
    }

    public void setCodeModif(String codeModif) {
        this.codeModif = codeModif;
    }
}