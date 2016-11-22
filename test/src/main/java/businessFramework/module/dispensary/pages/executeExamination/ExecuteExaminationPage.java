package businessFramework.module.dispensary.pages.executeExamination;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class ExecuteExaminationPage extends ExecuteExaminationHelper implements Values {
    public ExecuteExaminationPage(ApplicationManager app) {
        super(app);
    }

    public void executeExamination()
    {
        getDateField().assertThatDateContainsValue(getCurrentDate());
        getResource().setValue(0);
        getMainDiagnosis().setValue(0);
        getDiseaseField().setValue(0);
        getSaveButton().click();
        getForm().getAlerts().assertSuccessAlertIsPresent();
        closePage();
    }
}