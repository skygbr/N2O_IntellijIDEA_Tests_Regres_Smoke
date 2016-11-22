package businessFramework.module.pharmacy.pages.refbooks.holding.regional;

import businessFramework.module.pharmacy.modals.Modification.RegionalModifModal;
import businessFramework.module.pharmacy.pages.refbooks.holding.HoldingListPage;
import net.framework.autotesting.ApplicationManager;

/**
 * Created by ydolgih on 08.12.2015.
 */
public class RegionalHoldingListPage  extends HoldingListPage{

    public RegionalHoldingListPage(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Получение модального окна "Модификация"
     */
    public RegionalModifModal getModifModal()
    {
        return new RegionalModifModal("main");
    }
}
