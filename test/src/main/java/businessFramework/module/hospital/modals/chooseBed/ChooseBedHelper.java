package businessFramework.module.hospital.modals.chooseBed;


import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

public class ChooseBedHelper
{
    private String container;
    private Page page = Page.getInstance();

    public ChooseBedHelper()
    {
        this.container = "orgstructure";
    }

    public ChooseBedHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }
}
