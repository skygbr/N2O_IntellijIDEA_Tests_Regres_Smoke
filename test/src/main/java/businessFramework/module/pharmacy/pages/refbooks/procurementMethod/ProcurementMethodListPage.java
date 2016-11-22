package businessFramework.module.pharmacy.pages.refbooks.procurementMethod;

import businessFramework.module.pharmacy.modals.ProcurementMethod.ProcurementMethodModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydolgih on 12.01.2016.
 */
public class ProcurementMethodListPage extends ProcurementMethodListHelper {

    public ProcurementMethodListPage(ApplicationManager app) {
        super(app);
    }

    public ProcurementMethodModal getProcurementMethodModal() {
        return new ProcurementMethodModal(app);
    }

    /**
     * Проверка сообщения об успешном выполнении действия
     */
    public void assertProcurementMethodSuccessMessage(String successMessage) {
        getProcurementMethodListTable().getAlerts().assertSuccessAlertMessage(successMessage);
    }

    /**
     * Нажатие на кнопку "Добавить"
     */
    public void clickCreateButton() {
        Button createButton = getCreateButton();
        createButton.assertIsEnabled();
        createButton.click();
    }

    /**
     * Нажатие на кнопку "Изменить"
     */
    public void clickUpdateButton() {
        Button updateButton = getUpdateButton();
        updateButton.assertIsEnabled();
        updateButton.click();
    }

    /**
     * Нажатие на кнопку "Удалить"
     */
    public void clickDeleteButton() {
        Button deleteButton = getDeleteButton();
        deleteButton.assertIsEnabled();
        deleteButton.click();
    }

    /**
     * Поиск строки
     * @param code
     * @param name
     * @return номер строки
     */
    public int getRecordInTable(String code, String name){
        Map<String, String> columnsAndValues = new HashMap<>();

        if (code != null) columnsAndValues.put("Код", code);
        if (name != null) columnsAndValues.put("Наименование", name);
        return getProcurementMethodListTable().getRowNumberBySeveralColumnValues(columnsAndValues, true);
    }
}