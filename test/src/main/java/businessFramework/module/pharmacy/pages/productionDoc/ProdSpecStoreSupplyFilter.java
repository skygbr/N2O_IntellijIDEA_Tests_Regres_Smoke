package businessFramework.module.pharmacy.pages.productionDoc;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 02.09.2016.
 * Фильтры на странице "Спецификации"
 */
public class ProdSpecStoreSupplyFilter extends ProdSpecStoreSupplyHelper{
    public ProdSpecStoreSupplyFilter(ApplicationManager app) {
        super(app);
    }

    /**
     * Фильтр по полю "Наименование ЛС и ИМН"
     */
        public InputText getSpecModif() {
        return this.getBatchListContainer().getFilter().getInputText("filterHoldModif.name");
    }

}
