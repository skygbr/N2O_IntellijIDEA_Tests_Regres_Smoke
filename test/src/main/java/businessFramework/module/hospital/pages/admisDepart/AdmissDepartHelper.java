package businessFramework.module.hospital.pages.admisDepart;


import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class AdmissDepartHelper extends Page implements Values
{
    public AdmissDepartHelper(ApplicationManager app) {
        super(app);
    }

    public Container getContainerHospitalCases()
    {
        return getRegion(TOP).getContainer("hospitalCases");
    }

    public Container getContainerServices()
    {
        return getRegion(LEFT).getContainer("services");
    }

    public Container getContainerHospitalRecords()
    {
        return getRegion(RIGHT).getContainer("hospitalRecords");
    }

    public Button getCreateHospitalButton()
    {
        return getContainerHospitalCases().getButton(CREATE_BUTTON);
    }

    public Button getEditHospitalButton()
    {
        return getContainerHospitalCases().getButton(UPDATE_BUTTON);
    }

    public Button getCreateServiceButton()
    {
        return getContainerServices().getButton("addPhysical");
    }

    public Button getCancelRenderedButton()
    {
        return getContainerServices().getButton("cancelRendered");
    }

    public Button getCopyServiceButton()
    {
        return getContainerServices().getButton("copy");
    }

    public Button getEditRenderedButton()
    {
        return getContainerServices().getButton("editRendered");
    }

    public Button getCreateRenderedButton()
    {
        return getContainerServices().getButton("createRendered");
    }

    public Button getDeleteHospitalButton()
    {
        return getContainerHospitalCases().getButton(DELETE_BUTTON);
    }
}
