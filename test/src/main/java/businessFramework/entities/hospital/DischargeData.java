package businessFramework.entities.hospital;

import java.util.List;

/**
 * Created by bulat.garipov on 28.01.2016.
 */
public class DischargeData {

    private String stepResult;
    private String outcome;
    private String careLevel;
    private String rankIn;
    private List<String> finalDiagnosisTree;
    private String finalDiagnosisCode;
    private String outcomeDate;
    private String bedProfile;

    private String deathDate;
    private String deathEmployee;

    private String coefCur0;
    private String coefCurVal0;

    private String coefCur1;
    private String coefCurVal1;

    public DischargeData() {
    }

    public String getStepResult() {
        return stepResult;
    }

    public void setStepResult(String stepResult) {
        this.stepResult = stepResult;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public String getRankIn() {
        return rankIn;
    }

    public void setRankIn(String rankIn) {
        this.rankIn = rankIn;
    }

    public String getBedProfile() {
        return bedProfile;
    }

    public void setBedProfile(String bedProfile) {
        this.bedProfile = bedProfile;
    }

    public List<String> getFinalDiagnosisTree() {
        return finalDiagnosisTree;
    }

    public void setFinalDiagnosisTree(List<String> finalDiagnosisTree) {
        this.finalDiagnosisTree = finalDiagnosisTree;
    }

    public String getOutcomeDate() {
        return outcomeDate;
    }

    public void setOutcomeDate(String outcomeDate) {
        this.outcomeDate = outcomeDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathEmployee() {
        return deathEmployee;
    }

    public void setDeathEmployee(String deathEmployee) {
        this.deathEmployee = deathEmployee;
    }

    public String getCoefCur0() {
        return coefCur0;
    }

    public void setCoefCur0(String coefCur0) {
        this.coefCur0 = coefCur0;
    }

    public String getCoefCurVal0() {
        return coefCurVal0;
    }

    public void setCoefCurVal0(String coefCurVal0) {
        this.coefCurVal0 = coefCurVal0;
    }

    public String getCoefCur1() {
        return coefCur1;
    }

    public void setCoefCur1(String coefCur1) {
        this.coefCur1 = coefCur1;
    }

    public String getCoefCurVal1() {
        return coefCurVal1;
    }

    public void setCoefCurVal1(String coefCurVal1) {
        this.coefCurVal1 = coefCurVal1;
    }

    public String getFinalDiagnosisCode() {
        return finalDiagnosisCode;
    }

    public void setFinalDiagnosisCode(String finalDiagnosisCode) {
        this.finalDiagnosisCode = finalDiagnosisCode;
    }
}
