package businessFramework.module.migrants.modals;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;

public class ClosingCardModal extends ClosingCardHelper implements Values {
    public ClosingCardModal(ApplicationManager app) {
        super(app);
    }

    public void assertAndConfirmClosing(String reason)
    {
        getClosingReason().assertThatComboboxIsDisabled();
        getClosingReason().assertValue_equals(reason);
        getConfirmButton().click();
    }
}