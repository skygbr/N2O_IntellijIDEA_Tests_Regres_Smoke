package businessFramework.module.hospital.modals.doctorHistory;

import businessFramework.module.Values;
import net.framework.autotesting.meta.*;

public class DoctorHistoryHelper implements Values
{
    private String container;
    private Page page = Page.getInstance();

    public DoctorHistoryHelper()
    {
        this.container = "doctorHistory";
    }

    public DoctorHistoryHelper(String container)
    {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getModal().getContainer(container);
    }
}
