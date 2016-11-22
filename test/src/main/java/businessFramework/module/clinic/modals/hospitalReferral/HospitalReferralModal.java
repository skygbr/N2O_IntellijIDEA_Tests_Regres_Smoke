package businessFramework.module.clinic.modals.hospitalReferral;

import net.framework.autotesting.meta.components.Button;

/**
 * Created by elvira.ibragimova on 24.09.2016.
 */
public class HospitalReferralModal extends HospitalReferralHelper {
    public void clickConfirm(){
        Button button = getConfirmButton();
        button.click();
    }
    public void clickCancel(){
        Button button = getCancelButton();
        button.click();
    }
    public void setValue(){
        getOrganization().setValue("МО для поликлиники");
        getRegimen().setValue("круглосуточный");
        getFinancialType().setValue("ОМС");
        getReferralComment().setValue("autotest_acceptance");
        getReferralDiagnosis().setValue("F50.0");
        getReferralDiagnosisComment().setValue("autotest_acceptance");
    }
    public void changeValue(){
        getRegimen().setValue("Стационар дневной в АПУ");
        getReferralComment().setValue("acceptance");
        getReferralDiagnosis().setValue("D31.0");
        getReferralDiagnosisComment().setValue("acceptance");
    }


}
