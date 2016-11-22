package businessFramework.module.hospital.pages.informationDesk;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;

public class InformationDeskHelper extends Page implements Values
{
    public InformationDeskHelper(ApplicationManager app){
        super(app);
    }

    public Container getContainerInformationDesk()
    {
        return getRegion(TOP).getContainer("informationDesk");
    }

    public Container getContainerHospitalRecords()
    {
        return getRegion(LEFT).getContainer("hospitalRecords");
    }

    public Container getContainerServices()
    {
        return getRegion(RIGHT).getContainer("services");
    }
}
