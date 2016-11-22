package businessFramework.module.vaccination.pages.vaccineJournal;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

public class VacineJournalHelper extends Page implements Values {

    public VacineJournalHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainerVacineJournal()
    {
        return getRegion(SINGLE).getContainer("journ");
    }

    public void clickEditButton()
    {
        Button create = getEditButton();
        create.assertIsEnabled();
        create.click();
        assertModalPresentOnPage(true);
        getModal().assertModalHeader_contains("Редактирование прививки");
    }

    public Button getEditButton()
    {
        return getContainerVacineJournal().getButton("update");
    }

}
