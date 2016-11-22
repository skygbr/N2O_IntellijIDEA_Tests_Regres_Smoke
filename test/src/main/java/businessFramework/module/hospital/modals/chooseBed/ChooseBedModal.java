package businessFramework.module.hospital.modals.chooseBed;


import businessFramework.module.Values;
import net.framework.autotesting.meta.Page;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class ChooseBedModal implements Values
{
    private ChooseBedHelper chooseBedHelper;
    private Page page = Page.getInstance();

    public ChooseBedModal()
    {
        this.chooseBedHelper = new ChooseBedHelper();
    }

    public void chooseBed(Boolean free)
    {
        List<WebElement> freeElements;
        if(free)
        {
            freeElements = chooseBedHelper.getContainer().getTree().getTreeItemContainValue("свободна");
        }
        else
        {
            freeElements = chooseBedHelper.getContainer().getTree().getAllTreeFolderContent();
            freeElements.removeAll(chooseBedHelper.getContainer().getTree().getTreeItemContainValue("свободна"));
        }
        assertThat("Not "+ (free ? "free" : "busy") + " beds in departmernt", freeElements.size(), greaterThan(0));
        freeElements.get(0).click();

        page.getModal().getButton(CONFIRM_BUTTON).click();
    }
}
