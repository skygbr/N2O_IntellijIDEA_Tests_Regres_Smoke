package businessFramework.module.clinic.pages.referral;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by asamoilov on 17.02.2016.
 */
public class ReferralServicePage extends ReferralServiceHelper {
    public ReferralServicePage(ApplicationManager app){
        super(app);
    }
    public void clickConfirm(){
        Button button = getContainerReferralService().getButton(N2O_CONFIRM_BUTTON);
        button.click();
    }
    public void clickCancel(){
        Button button = getContainerReferralService().getButton(N2O_CANCEL_BUTTON);
        button.click();
    }

    public void setValue(){
        getReferralType().setValue("направление донора");
        getRecvDepartment().setValue("Подразделение поликлиники");
        getRecvDoctor().setValue("Нуждина");
        getReferralService().setValue("Осмотр");
        getReferralComment().setValue("autotest_acceptance");
        getDiagnosis().setValue("G51.0");
    }
    public void updateValue(){
        getReferralType().setValue("направление на дообследование");
        getReferralService().setValue("Лабораторное");
    }
}
