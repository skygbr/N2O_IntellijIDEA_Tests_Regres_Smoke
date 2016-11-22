package businessFramework.module.migrants.modals;

import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.*;
import net.framework.autotesting.meta.components.*;

public class ClosingCardHelper extends Page implements Values {

    private Page page = Page.getInstance();

    public ClosingCardHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Получение этого модального окна
     * @return Это модальное окно
     */
    public Modal getClosingCardModal()
    {
        return page.getModal();
    }

    public Classifier getClosingReason ()
    {
        return getClosingCardModal().getForm().getClassifier("reason");
    }

    public Button getConfirmButton()
    {
         return getClosingCardModal().getButton(N2O_CONFIRM_BUTTON);
    }
}