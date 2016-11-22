package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.entities.phthisiatry.MRefData;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;
import businessFramework.module.phthisiatry.modals.mRef.MRefSetHelper;

/**
 * Created by bulat.garipov on 31.10.2016.
 */
public class MRefSetModal extends MRefSetHelper
{
    public MRefSetModal(ApplicationManager app)
    {
        super(app);
    }

    public void clickConfirm()
    {
        Button button = getConfirmButton();
        button.assertIsEnabled();
        button.click();
    }

    public void clickCancel()
    {
        Button button = getCancelButton();
        button.assertIsEnabled();
        button.click();
    }

    /**
     * Устанавливает значения в поля
     */
    public void setValuesToFields(MRefData mRefData) {
        getPlannedDateField().setValue(mRefData.getPlannedDate());
        getServiceField().setValue(mRefData.getService());
    }

}
