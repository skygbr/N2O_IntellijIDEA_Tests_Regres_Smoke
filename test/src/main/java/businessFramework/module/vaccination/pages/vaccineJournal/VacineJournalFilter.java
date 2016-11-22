package businessFramework.module.vaccination.pages.vaccineJournal;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

public class VacineJournalFilter extends VacineJournalHelper
{
    public VacineJournalFilter(ApplicationManager app)
    {
        super(app);
    }

    public Classifier getPatient()
    {
        return this.getContainerVacineJournal().getFilter().getClassifier("individual");
    }


    public Classifier getOrg()
    {
        return this.getContainerVacineJournal().getFilter().getClassifier("org");
    }

    public InputDate getInputDate()
    {
        return this.getContainerVacineJournal().getFilter().getInputDate("dateInt");
    }
}
