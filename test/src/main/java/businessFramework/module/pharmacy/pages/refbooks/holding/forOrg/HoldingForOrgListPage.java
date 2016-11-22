package businessFramework.module.pharmacy.pages.refbooks.holding.forOrg;

import businessFramework.module.pharmacy.modals.Holding.HoldingModal;
import businessFramework.module.pharmacy.modals.Modification.ModifForOrgModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class HoldingForOrgListPage extends HoldingForOrgListHelper {

    public HoldingForOrgListPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна "Модификация"
     */
    public ModifForOrgModal getModifModal()
    {
        return new ModifForOrgModal(app);
    }

    /**
     * Получение модального окна "Номенклатура"
     */
    public HoldingModal getHoldingModal()
    {
        return new HoldingModal("main");
    }

    public void clickCreateModifButton()
    {
        Button createModifButton = getCreateModifButton();
        createModifButton.assertIsEnabled();
        createModifButton.click();
    }
}
