package businessFramework.module.dAccount.pages;

import businessFramework.entities.dAccount.CommissionReferralData;
import net.framework.autotesting.ApplicationManager;

/**
 * @author agabdrakhmanova
 * @since 15.01.2016
 */
public class CommissionReferralPage extends CommissionReferralHelper {
    public CommissionReferralPage(ApplicationManager app) {
        super(app);
    }

    public void create(CommissionReferralData commissionReferralData)
    {
        getPatient().assertValue_equals(commissionReferralData.getPatient());
        getRecvOrganization().assertValue_equals(commissionReferralData.getRecvOrganization());

        getOrderNumber().setValue(commissionReferralData.getOrderNumber());
        getReferralDate().setValue(commissionReferralData.getReferralDate());
        getGoal().setValue(commissionReferralData.getGoal());
        getClinicalForm().setValue(commissionReferralData.getClinicalForm());
        getDiagnosisTree().searchValue(commissionReferralData.getMainDiagnosCode());

        getConfirmButton().assertIsEnabled();
        getConfirmButton().click();
    }
}
