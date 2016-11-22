package businessFramework.entities.hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulat.garipov on 28.01.2016.
 */
public class DiagnosisData {
    private String stageDiagnosis;
    private String diagnosis;
    private String diagnosisCode;
    private String diagnosisCodeList;
    private String diagnosisFeature1;
    private String diagnosisFeature2;
    private List<String> diagnosisTree;

    public DiagnosisData() {
    }

    public String getStageDiagnosis() {
        return stageDiagnosis;
    }

    public void setStageDiagnosis(String stageDiagnosis) {
        this.stageDiagnosis = stageDiagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisFeature1() {
        return diagnosisFeature1;
    }

    public void setDiagnosisFeature1(String diagnosisFeature1) {
        this.diagnosisFeature1 = diagnosisFeature1;
    }

    public String getDiagnosisFeature2() {
        return diagnosisFeature2;
    }

    public void setDiagnosisFeature2(String diagnosisFeature2) {
        this.diagnosisFeature2 = diagnosisFeature2;
    }

    public List<String> getDiagnosisTree() {
        return diagnosisTree;
    }

    public void setDiagnosisTree(List<String> diagnosisTree) {
        this.diagnosisTree = diagnosisTree;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisCodeList() {
        return diagnosisCodeList;
    }

    public void setDiagnosisCodeList(String diagnosisCodeList) {
        this.diagnosisCodeList = diagnosisCodeList;
    }
}
