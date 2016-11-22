package businessFramework.module.pharmacy.modals.Modification;

import net.framework.autotesting.ApplicationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydolgih on 15.12.2015.
 */
public class SearchRegionalModifModal extends  SearchRegionalModifModalHelper {

    public SearchRegionalModifModal(ApplicationManager app)
    {
        super(app);
    }

    public void chooseModifByFilter(String name, String eanCode) {
        getFilter().getInputText("holding.name").setValue(name);
        getFilter().getInputText("eanCode").setValue(eanCode);
        getFilter().clickFindButton();
    }

    public int checkRecordInRegionalModifTable(String holding, String modif, String producer) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (holding != null) columnsAndValues.put("Номенклатура", holding);
        if (holding != null) columnsAndValues.put("Наименование", modif);
        if (producer != null) columnsAndValues.put("Производитель", producer);
        return getModifSearchTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }


    /**
     * Нажатие кнопки "Выбрать"
     */
    public void clickChooseButton() {
        getChooseButton().click();
    }
}
