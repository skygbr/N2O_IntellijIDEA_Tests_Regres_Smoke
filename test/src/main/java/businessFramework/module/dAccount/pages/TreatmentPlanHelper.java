package businessFramework.module.dAccount.pages;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Filter;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;
import net.framework.autotesting.meta.components.Classifier;

public class TreatmentPlanHelper extends Page implements Values
{

    public TreatmentPlanHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получает контейнер "Фильтр Регистр"
     * @return контейнер "Фильтр Регистр"
     */
    public Container getRegisterFilterContainer()
    {
        return getContainer("registerFilter");
    }

    /**
     * @return  Классифаер "Регистр"
     */
    public Classifier getRegisterFilter()
    {
        return getRegisterFilterContainer().getForm().getClassifier("register");
    }
}
