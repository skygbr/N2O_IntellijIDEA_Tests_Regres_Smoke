package businessFramework.module.hospital.modals.prescription;

import businessFramework.entities.hospital.prescription.PrescriptionCancelData;
import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

/**
 * @author agabdrakhmanova
 * @since 30.11.2015
 */
public class PrescriptionCancelModal implements Values {
    private Page page = Page.getInstance();
    private String container;

    public PrescriptionCancelModal() {
        this.container = "main";
    }

    private Container getContainer() {
        return page.getModal().getContainer(container);
    }


    public void cancel(PrescriptionCancelData prescriptionCancelData)
    {
        getContainer().getForm().getInputDate("cancelDt").setValue(prescriptionCancelData.getCancelDt());
        getContainer().getForm().getInputText("cancelReason").setValue(prescriptionCancelData.getCancelReason());
        getContainer().getButton(N2O_CONFIRM_BUTTON).click();
    }
}
