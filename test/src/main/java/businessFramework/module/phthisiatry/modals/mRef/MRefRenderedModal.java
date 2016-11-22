package businessFramework.module.phthisiatry.modals.mRef;

import businessFramework.entities.phthisiatry.MRefData;
import businessFramework.module.phthisiatry.modals.mRef.MRefSetHelper;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by bulat.garipov on 01.11.2016.
 */
public class MRefRenderedModal extends MRefRenderedHelper
{
    public MRefRenderedModal(ApplicationManager app)
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
        getRenderedDateField().setValue(mRefData.getRenderedDate());
        getDiagnosField().setValue(mRefData.getDiagnos());
        getCommentField().setValue(mRefData.getComment());
    }

}
