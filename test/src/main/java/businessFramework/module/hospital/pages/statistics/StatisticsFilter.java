package businessFramework.module.hospital.pages.statistics;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class StatisticsFilter extends StatisticsHelper
{
    public StatisticsFilter(ApplicationManager app)
    {
        super(app);
    }

    public InputDate getAdmissionDate()
    {
        return getContainerStatisticalMapList().getFilter().getInputDate("admissionDate");
    }

    public Classifier getPatient()
    {
        return getContainerStatisticalMapList().getFilter().getClassifier("patient");
    }

    public Select getHasBill()
    {
        return getContainerStatisticalMapList().getFilter().getSelect("hasBill");
    }

    public Select getChooseCases(){
        return getContainerStatisticalMapList().getFilter().getSelect("chooseCases");
    }
}
