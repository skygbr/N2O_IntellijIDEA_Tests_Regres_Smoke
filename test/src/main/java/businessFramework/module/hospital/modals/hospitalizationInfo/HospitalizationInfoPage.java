package businessFramework.module.hospital.modals.hospitalizationInfo;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.*;

/**
 * @author agabdrakhmanova
 * @since 29.10.2015
 */
public class HospitalizationInfoPage implements Values {
    private Page page = Page.getInstance();
    private String container;

    public HospitalizationInfoPage(String container) {
        this.container = container;
    }

    public Container getContainer()
    {
        return page.getContainer(container);
    }

    public InputCheckBox getNeedSickListCheckBox()
    {
        return getContainer().getForm().getInputCheckBox("is_need_sickList");
    }

    public Classifier getCareProvidingForm() {
        return getContainer().getForm().getClassifier("careProvidingForm");
    }

    public Classifier getDrunkennessType() {
        return getContainer().getForm().getClassifier("drunkennessType");
    }

    public InputText getNarcoticSubstance() {
        return getContainer().getForm().getInputText("narcoticSubstance");
    }

    public InputText getWhereFromDelivered() {
        return getContainer().getForm().getInputText("whereFromDelivered");
    }

    public void save()
    {
        Button confirmButton = getContainer().getButton(N2O_CONFIRM_BUTTON);
        confirmButton.assertIsEnabled();
        confirmButton.click();
    }
}
