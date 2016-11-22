package businessFramework.module.dAccount.pages;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
/*
*  Страница "План лечения и наблюдения"
* */
public class TreatmentPlanPage extends TreatmentPlanHelper implements Values {
    public TreatmentPlanPage(ApplicationManager app) {
        super(app);
    }

    public int row = 0;

    /**
     * Задает значение в фильтре "Регистр"
     */
    public void setRegisterFilter(String registerFilter) {
        getRegisterFilter().setValue(registerFilter);
    }

    /**
     * Проверяет значение в фильтре "Регистр"
     */
    public boolean checkRegisterFilter(String registerFilter) {
        return getRegisterFilter().getValue().equals(registerFilter);
    }
}
