package businessFramework.module.pharmacy.pages.refbooks.storeList;

import businessFramework.module.pharmacy.modals.Store.StoreClosingDateModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ydolgih
 * @since 03.07.2015
 */
public class StoreListPage extends StoreListHelper {

    public StoreListPage(ApplicationManager app) {
        super(app);
    }

    public StoreClosingDateModal getStoreClosingDateModal() {
        return new StoreClosingDateModal(app);
    }

    /**
     * Проверка сообщения об успешном установлении Дяты закрытия периода
     */
    public void assertStoreClosingDateSuccessMessage(String successMessage) {
        getStoreListTable().getAlerts().assertSuccessAlertMessage(successMessage);
    }

    /**
     * Нажатие на кнопку "Установить дату закрытия периода"
     */
    public void clickSetClosingPeriodDate() {
        Button setClosingPeriodDateButton = getStoreClosingDateButton();
        setClosingPeriodDateButton.assertIsEnabled();
        setClosingPeriodDateButton.click();
    }

    public int checkRecordInStoreClosingDateTable(String closingDate, String date) {
        Map<String, String> columnsAndValues = new HashMap<>();

        if (closingDate != null) columnsAndValues.put("Дата закрытия периода", closingDate);
        if (date != null) columnsAndValues.put("Дата", date);
        return getStoreClosingDateContainer().getTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}
