package businessFramework.module.hospital.pages.statistics;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class StatisticsHelper extends Page implements Values
{
    public StatisticsHelper(ApplicationManager app)
    {
        super(app);
    }

    public Container getContainerStatisticalMapList()
    {
        return getContainer("statisticalMapList");
    }

    public Container getContainerHospitalRecords()
    {
        return getContainer("hospitalRecords");
    }

    public Container getContainerServices()
    {
        return getContainer("services");
    }

    public Button getCreateButton()
    {
        return getContainerStatisticalMapList().getButton(CREATE_BUTTON);
    }

    public Button getEditButton()
    {
        return getContainerStatisticalMapList().getButton(UPDATE_BUTTON);
    }

    public Button getDeleteButton()
    {
        return getContainerStatisticalMapList().getButton(DELETE_BUTTON);
    }

    public Button getBillButton()
    {
        return getContainerStatisticalMapList().getButton("getBill");
    }

    public Button getConfirmBillButton()
    {
        return getModal().getButton(N2O_CONFIRM_BUTTON);
    }

    public Classifier getBill()
    {
        return getModal().getForm().getClassifier("bill");
    }
}
