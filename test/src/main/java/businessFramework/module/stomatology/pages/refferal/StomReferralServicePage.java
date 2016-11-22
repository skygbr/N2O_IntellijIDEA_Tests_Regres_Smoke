package businessFramework.module.stomatology.pages.refferal;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 21.07.2016.
 */
public class StomReferralServicePage extends StomReferralServiceHelper{
    public StomReferralServicePage(ApplicationManager app){
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
        getDiagnosis().setValue("F30.0 Гипомания");
        getRecvDepartment().setValue("Подразделение стоматологии");
        getRecvDoctor().setValue("Нуждина");
        getReferralService().setValue("Прием");
        getReferralComment().setValue("autotest_acceptance");
    }
    public void updateValue(){
        getReferralType().setValue("направление на дообследование");
        getReferralService().setValue("Лабораторное");
    }
}
